package io.swagger.api;

import io.swagger.model.Committee;
import io.swagger.model.Review;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")
@RestController
public class ProposalApiController implements ProposalApi {

    private static final Logger log = LoggerFactory.getLogger(ProposalApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ProposalApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> approveMilestone(@Parameter(in = ParameterIn.PATH, description = "the id of the proposal", required=true, schema=@Schema()) @PathVariable("pid") Integer pid,@Parameter(in = ParameterIn.PATH, description = "the milestone id", required=true, schema=@Schema()) @PathVariable("mid") Integer mid,@NotNull @Parameter(in = ParameterIn.QUERY, description = "approve or disapprove" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "approved", required = true) Boolean approved) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteCommittee(@Parameter(in = ParameterIn.PATH, description = "the id of the proposal", required=true, schema=@Schema()) @PathVariable("pid") Integer pid,@Parameter(in = ParameterIn.PATH, description = "the committee", required=true, schema=@Schema()) @PathVariable("cid") Integer cid) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> evaluateProposal(@Parameter(in = ParameterIn.PATH, description = "the id of the proposal to accept or reject", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Review>> getAllReview(@Parameter(in = ParameterIn.PATH, description = "id of the proposal", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Review>>(objectMapper.readValue("[ {\n  \"level\" : \"level\",\n  \"review\" : \"review\",\n  \"id\" : 0,\n  \"reviewer\" : \"reviewer\",\n  \"sent\" : false\n}, {\n  \"level\" : \"level\",\n  \"review\" : \"review\",\n  \"id\" : 0,\n  \"reviewer\" : \"reviewer\",\n  \"sent\" : false\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Review>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Review>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Committee>> getComittee(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("id") Integer id,@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "role", required = true) String role) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Committee>>(objectMapper.readValue("[ {\n  \"review\" : [ \"review\", \"review\" ],\n  \"name\" : \"name\",\n  \"id\" : 0,\n  \"point\" : [ {\n    \"name\" : \"name\",\n    \"weight\" : 0\n  }, {\n    \"name\" : \"name\",\n    \"weight\" : 0\n  } ]\n}, {\n  \"review\" : [ \"review\", \"review\" ],\n  \"name\" : \"name\",\n  \"id\" : 0,\n  \"point\" : [ {\n    \"name\" : \"name\",\n    \"weight\" : 0\n  }, {\n    \"name\" : \"name\",\n    \"weight\" : 0\n  } ]\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Committee>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Committee>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> getReviewOfTheProposal(@Parameter(in = ParameterIn.PATH, description = "the id of the proposal", required=true, schema=@Schema()) @PathVariable("pid") Integer pid,@Parameter(in = ParameterIn.PATH, description = "the review id to be approved or disapproved", required=true, schema=@Schema()) @PathVariable("rid") Integer rid,@NotNull @Parameter(in = ParameterIn.QUERY, description = "approve or disapprove" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "approved", required = true) Boolean approved) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> proposalAccepte(@Parameter(in = ParameterIn.PATH, description = "the id of the proposal to accept or reject", required=true, schema=@Schema()) @PathVariable("id") Integer id,@NotNull @Parameter(in = ParameterIn.QUERY, description = "accept or reject" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "accepted", required = true) Boolean accepted) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> proposalIdCommitteePost(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("id") Integer id,@NotNull @Parameter(in = ParameterIn.QUERY, description = "email of the user to add to the committee" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "email", required = true) String email) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
