package io.research.api;

import io.research.Repository.FileStorageRepository;
import io.research.database.Staff;
import io.research.model.InlineResponse200;
import io.research.model.Milestone;
import io.research.model.Paper;
import io.research.model.PidReviewsBody1;
import io.research.model.Point;
import io.research.model.Proposal;
import io.research.model.ProposalCall;
import io.research.model.RefreshToken;
import io.research.service.ProposalService;
import io.research.service.UserService;
import org.springframework.core.io.Resource;
import io.research.model.Reviews;
import io.research.model.SignInReq;
import io.research.model.SignedInUser;
import io.research.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")
@RestController
@RequestMapping("/api")
public class UserApiController implements UserApi {



    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final FileStorageRepository fileRepo;
    private final HttpServletRequest request;
    private final ProposalService proposalService;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, PasswordEncoder passwordEncoder, UserService userService, FileStorageRepository fileRepo, HttpServletRequest request, ProposalService proposalService) {
        this.objectMapper = objectMapper;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.fileRepo = fileRepo;
        this.request = request;
        this.proposalService = proposalService;
    }

    public ResponseEntity<SignedInUser> signUp(@Parameter(in = ParameterIn.DEFAULT, description = "",schema=@Schema()) @RequestParam(value="name")  String name, @Parameter(in = ParameterIn.DEFAULT, description = "",schema=@Schema()) @RequestParam(value="email")  String email, @Parameter(in = ParameterIn.DEFAULT, description = "",schema=@Schema()) @RequestParam(value="role")  String role, @Parameter(in = ParameterIn.DEFAULT, description = "",schema=@Schema()) @RequestParam(value="password")  String password, @Parameter(description = "file detail") @Valid @RequestPart(name = "file", required=false) MultipartFile picture) {
        String avatar = "none";
        if(picture!=null){
            if(!picture.isEmpty())
                avatar = name.trim()+System.currentTimeMillis();
        }

        Staff staff = new Staff(name,email,"phone",role,password,avatar);
        Optional<SignedInUser> toke = userService.createUser(staff);
        if(toke.isPresent()&&avatar!="none"){
            fileRepo.save(picture,name.trim());
        }
        return ResponseEntity.ok(toke.get());
    }

    public ResponseEntity<SignedInUser> signIn(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody SignInReq body) {
        log.info("Teterchalehu");
        Staff userEntity = userService.findUserByEmail(body.getUsername());
        if (passwordEncoder.matches(body.getPassword(), userEntity.getPassword())) {
            return ResponseEntity.ok(userService.getSignedInUser(userEntity));
        }
        throw new InsufficientAuthenticationException("Unauthorized.");
    }

    public ResponseEntity<Void> addMilestone(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("uid") Integer uid,@Parameter(in = ParameterIn.PATH, description = "the paper id.", required=true, schema=@Schema()) @PathVariable("pid") Integer pid,@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody List<Milestone> body) {
        body.stream().forEach(m->proposalService.addMileStone(pid,m));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> addPaper(@Parameter(in = ParameterIn.PATH, description = "the user id", required=true, schema=@Schema()) @PathVariable("uid") Integer uid,@Parameter(in = ParameterIn.PATH, description = "the paper id", required=true, schema=@Schema()) @PathVariable("pid") Integer pid,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="title", required=true)  String title,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="abstract", required=true)  String _abstract,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="file", required=true)  MultipartFile file, @RequestParam(value="file", required=true)  MultipartFile fil2) {
        proposalService.addAnotherVersionOfThePaper(pid,title, _abstract,file,fil2);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> addPoint(@Parameter(in = ParameterIn.PATH, description = "the id of the user", required=true, schema=@Schema()) @PathVariable("uid") Integer uid,@Parameter(in = ParameterIn.PATH, description = "the paper id", required=true, schema=@Schema()) @PathVariable("pid") Integer pid,@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody List<Point> body) {
        proposalService.addListOfPoint(uid,pid,body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> addReviewFile(@Parameter(in = ParameterIn.PATH, description = "the id of the user", required=true, schema=@Schema()) @PathVariable("uid") Integer uid,@Parameter(in = ParameterIn.PATH, description = "the paper id", required=true, schema=@Schema()) @PathVariable("pid") Integer pid,@Parameter(description = "file detail") @Valid @RequestPart("file") MultipartFile file) {
        proposalService.addReviewFile(uid,pid,file);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> addReviewtoPaper(@Parameter(in = ParameterIn.PATH, description = "the id of the user", required=true, schema=@Schema()) @PathVariable("uid") Integer uid,@Parameter(in = ParameterIn.PATH, description = "the paper id", required=true, schema=@Schema()) @PathVariable("pid") Integer pid,@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody List<PidReviewsBody1> body) {
        proposalService.addReviewToPaper(uid,pid,body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    //TODO: apply for application
    public ResponseEntity<Void> applyForApplication(@Parameter(in = ParameterIn.PATH, description = "call id.", required=true, schema=@Schema()) @PathVariable("cid") Integer cid,@Parameter(in = ParameterIn.PATH, description = "user id.", required=true, schema=@Schema()) @PathVariable("uid") Integer uid,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="title", required=true)  String title,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="abstract", required=true)  String _abstract,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="file", required=true)  List<Resource> file) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    //TODO: Get call list
    public ResponseEntity<List<ProposalCall>> callList() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<ProposalCall>>(objectMapper.readValue("[ {\n  \"file\" : { },\n  \"evano\" : 1,\n  \"accno\" : 5,\n  \"topic\" : \"topic\",\n  \"subno\" : 6,\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"deadline\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"posted_date\" : \"2000-01-23T04:56:07.000+00:00\"\n}, {\n  \"file\" : { },\n  \"evano\" : 1,\n  \"accno\" : 5,\n  \"topic\" : \"topic\",\n  \"subno\" : 6,\n  \"id\" : 0,\n  \"title\" : \"title\",\n  \"deadline\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"posted_date\" : \"2000-01-23T04:56:07.000+00:00\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<ProposalCall>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<ProposalCall>>(HttpStatus.NOT_IMPLEMENTED);
    }

    //TODO: Implement get access token
    public ResponseEntity<SignedInUser> getAccessToken(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody RefreshToken body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SignedInUser>(objectMapper.readValue("{\n  \"accessToken\" : \"accessToken\",\n  \"userId\" : \"userId\",\n  \"refreshToken\" : \"refreshToken\",\n  \"username\" : \"username\"\n}", SignedInUser.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SignedInUser>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SignedInUser>(HttpStatus.NOT_IMPLEMENTED);
    }

    //TODO: get all review
    public ResponseEntity<List<Reviews>> getAllTheReview(@Parameter(in = ParameterIn.PATH, description = "the id of the user", required=true, schema=@Schema()) @PathVariable("uid") Integer uid,@Parameter(in = ParameterIn.PATH, description = "the paper id", required=true, schema=@Schema()) @PathVariable("pid") Integer pid) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Reviews>>(objectMapper.readValue("[ {\n  \"level\" : \"Mandatory\",\n  \"review\" : \"review\",\n  \"remark\" : \"remark\",\n  \"id\" : 0,\n  \"status\" : \"None\"\n}, {\n  \"level\" : \"Mandatory\",\n  \"review\" : \"review\",\n  \"remark\" : \"remark\",\n  \"id\" : 0,\n  \"status\" : \"None\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Reviews>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Reviews>>(HttpStatus.NOT_IMPLEMENTED);
    }

    //TODO: Implement get access token
    public ResponseEntity<InlineResponse200> getAllTheReviewFile(@Parameter(in = ParameterIn.PATH, description = "the id of the user", required=true, schema=@Schema()) @PathVariable("uid") Integer uid,@Parameter(in = ParameterIn.PATH, description = "the paper id", required=true, schema=@Schema()) @PathVariable("pid") Integer pid) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse200>(objectMapper.readValue("{\n  \"files_url\" : [ \"files_url\", \"files_url\" ]\n}", InlineResponse200.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse200>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse200>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Point>> getEvaluationCriteria(@Parameter(in = ParameterIn.PATH, description = "the id of the user", required=true, schema=@Schema()) @PathVariable("uid") Integer uid,@Parameter(in = ParameterIn.PATH, description = "the paper id", required=true, schema=@Schema()) @PathVariable("pid") Integer pid) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Point>>(objectMapper.readValue("[ {\n  \"name\" : \"name\",\n  \"weight\" : 0\n}, {\n  \"name\" : \"name\",\n  \"weight\" : 0\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Point>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Point>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Proposal>> getSubmittedPaper(@Parameter(in = ParameterIn.PATH, description = "id of the user", required=true, schema=@Schema()) @PathVariable("id") Integer id,@NotNull @Parameter(in = ParameterIn.QUERY, description = "Define whether the paper is accepted, rejected or watting for approval form the RD or CoE" ,required=true,schema=@Schema(allowableValues={ "Accepted", "Rejected", "Watting" }
)) @Valid @RequestParam(value = "status", required = true) String status) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Proposal>>(objectMapper.readValue("[ {\n  \"submitted_on\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"call_title\" : \"call_title\",\n  \"file\" : [ { }, { } ],\n  \"stage\" : \"Deparment\",\n  \"totalBudget\" : 1,\n  \"remainingBudget\" : 5,\n  \"author\" : \"author\",\n  \"id\" : 0,\n  \"abstract\" : \"abstract\",\n  \"remainingDay\" : 6,\n  \"deadline\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"title\" : \"title\"\n}, {\n  \"submitted_on\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"call_title\" : \"call_title\",\n  \"file\" : [ { }, { } ],\n  \"stage\" : \"Deparment\",\n  \"totalBudget\" : 1,\n  \"remainingBudget\" : 5,\n  \"author\" : \"author\",\n  \"id\" : 0,\n  \"abstract\" : \"abstract\",\n  \"remainingDay\" : 6,\n  \"deadline\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"title\" : \"title\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Proposal>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Proposal>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Paper>> getSubmittedPaperforReview(@Parameter(in = ParameterIn.PATH, description = "id of the user", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Paper>>(objectMapper.readValue("[ {\n  \"file\" : [ { }, { } ],\n  \"abstarct\" : \"abstarct\",\n  \"id\" : 0,\n  \"title\" : \"title\"\n}, {\n  \"file\" : [ { }, { } ],\n  \"abstarct\" : \"abstarct\",\n  \"id\" : 0,\n  \"title\" : \"title\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Paper>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Paper>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> requestBudget(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("uid") Integer uid,@Parameter(in = ParameterIn.PATH, description = "the paper id.", required=true, schema=@Schema()) @PathVariable("pid") Integer pid,@Parameter(in = ParameterIn.PATH, description = "milestone id.", required=true, schema=@Schema()) @PathVariable("mid") Integer mid) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> signOut(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "refreshToken", required = true) RefreshToken refreshToken) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<User> userIdGet(@Parameter(in = ParameterIn.PATH, description = "id of the user to return.", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<User>(objectMapper.readValue("{\n  \"revno\" : 5,\n  \"role\" : \"CoE\",\n  \"avatar_url\" : \"avatar_url\",\n  \"evano\" : 1,\n  \"accno\" : 5,\n  \"name\" : \"name\",\n  \"subno\" : 6,\n  \"id\" : 0\n}", User.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> userIdPatch(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("id") Integer id,@NotNull @Parameter(in = ParameterIn.QUERY, description = "the new password" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "password", required = true) String password) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> userIdPut(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("id") Integer id,@Parameter(description = "file detail") @Valid @RequestPart("file") MultipartFile file) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Milestone>> userMilestone(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("uid") Integer uid,@Parameter(in = ParameterIn.PATH, description = "the paper id.", required=true, schema=@Schema()) @PathVariable("pid") Integer pid) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Milestone>>(objectMapper.readValue("[ {\n  \"requested\" : false,\n  \"approved\" : false,\n  \"activity\" : [ \"activity\", \"activity\" ],\n  \"endDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"name\" : \"name\",\n  \"id\" : 0,\n  \"startDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"budget\" : 6\n}, {\n  \"requested\" : false,\n  \"approved\" : false,\n  \"activity\" : [ \"activity\", \"activity\" ],\n  \"endDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"name\" : \"name\",\n  \"id\" : 0,\n  \"startDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"budget\" : 6\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Milestone>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Milestone>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
