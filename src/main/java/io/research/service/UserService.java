package io.research.service;

import io.research.database.Staff;
import io.research.model.RefreshToken;
import io.research.model.SignedInUser;

import java.util.Optional;

public interface UserService {

    Optional<Staff> getUserById(long id);

    Optional<SignedInUser> createUser(Staff staff);

    Staff findUserByEmail(String email);

    SignedInUser getSignedInUser(Staff user);

    Optional<SignedInUser> getAccessToken(RefreshToken refreshToken);

    void removeRefreshToken(RefreshToken refreshToken);
}
