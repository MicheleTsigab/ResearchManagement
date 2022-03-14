package io.research.service;

import io.research.Repository.StaffRepository;
import io.research.database.Staff;
import io.research.database.UserToken;
import io.research.model.RefreshToken;
import io.research.model.SignedInUser;
import io.research.security.JwtManager;
import io.research.Repository.UserTokenRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Optional;
import java.util.Random;


@Controller
    public class UserServiceImpl implements UserService {
        private final UserTokenRepository userTokenRepository;
        private final StaffRepository staffRepository;
        private final PasswordEncoder bCrypPasswordEncoder;
        private final JwtManager tokenManager;

    public UserServiceImpl(UserTokenRepository userTokenRepository, StaffRepository staffRepository, PasswordEncoder bCrypPasswordEncoder, JwtManager tokenManager) {
        this.userTokenRepository = userTokenRepository;
        this.staffRepository = staffRepository;
        this.bCrypPasswordEncoder = bCrypPasswordEncoder;
        this.tokenManager = tokenManager;
    }

    private Staff setPassword(Staff staff){

        Staff user = new Staff();
        BeanUtils.copyProperties(staff,user);
        user.setPassword(bCrypPasswordEncoder.encode(staff.getPassword()));
        return user;

    }

    @Override
    public Optional<Staff> getUserById(long id) {
        return staffRepository.findById(id);
    }

    private SignedInUser createSignedUserWithRefreshToken(Staff userEntity) {
        return createSignedInUser(userEntity).refreshToken(createRefreshToken(userEntity));
    }

    private SignedInUser createSignedInUser(Staff staff) {
        String token = tokenManager.create(org.springframework.security.core.userdetails.User.builder()
                .username(staff.getEmail())
                .password(staff.getPassword())
                .authorities(staff.getRole())
                .build());
        return new SignedInUser().username(staff.getEmail()).accessToken(token)
                .userId(staff.getId()+"");
    }

    private String createRefreshToken(Staff user) {
        String token = RandomHolder.randomKey(128);
        UserToken userToken = new UserToken();
        userToken.setRefreshToken(token);
        userToken.setUser(user);
        userTokenRepository.save(userToken);
        return token;
    }

    @Override
    @Transactional
    public Optional<SignedInUser> createUser(Staff staff){
       Optional<Staff> user = staffRepository.findByEmail(staff.getEmail());
        if (user.isPresent()) {
            throw new UsernameNotFoundException("User name Already Exist");
        }
        Staff savedPass = staffRepository.save(setPassword(staff));
        return Optional.of(createSignedUserWithRefreshToken(savedPass));
    }

    @Override
    public Staff findUserByEmail(String email) {
        if (Strings.isBlank(email)) {
            throw new UsernameNotFoundException("Invalid user.");
        }
        final String uname = email.trim();
        Optional<Staff> oStaff = staffRepository.findByEmail(uname);
        Staff staff12 = oStaff.orElseThrow(() ->
                new UsernameNotFoundException( String.format("Given user(%s) not found.", uname)));
        return staff12;
    }

    @Override
    @Transactional
    public SignedInUser getSignedInUser(Staff user) {
        userTokenRepository.deleteByUserId(user.getId());
        return createSignedUserWithRefreshToken(user);
    }

    @Override
    public Optional<SignedInUser> getAccessToken(RefreshToken refreshToken) {
        // You may add an additional validation for time that would remove/invalidate the refresh token
        return userTokenRepository.findByRefreshToken(refreshToken.getRefreshToken())
                .map(ut -> Optional.of(createSignedInUser(ut.getUser()).refreshToken(refreshToken.getRefreshToken())))
                .orElseThrow(() -> new RuntimeException("Invalid token."));
    }

    @Override
    public void removeRefreshToken(RefreshToken refreshToken) {
        userTokenRepository.findByRefreshToken(refreshToken.getRefreshToken())
                .ifPresentOrElse(userTokenRepository::delete, () -> {
                    throw new RuntimeException("Invalid token.");
                });
    }

    // https://stackoverflow.com/a/31214709/109354
    // or can use org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(n)
    private static class RandomHolder {
        static final Random random = new SecureRandom();
        public static String randomKey(int length) {
            return String.format("%"+length+"s", new BigInteger(length*5/*base 32,2^5*/, random)
                    .toString(32)).replace('\u0020', '0');
        }
    }
}
