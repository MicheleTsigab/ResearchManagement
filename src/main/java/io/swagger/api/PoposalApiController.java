package io.swagger.api;

import io.swagger.model.Milestone;
import io.swagger.model.Version;
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
public class PoposalApiController implements PoposalApi {

    private static final Logger log = LoggerFactory.getLogger(PoposalApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PoposalApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> approveProposal(@NotNull @Parameter(in = ParameterIn.QUERY, description = "approve/disaprove proposal to the evaluation stage." ,required=true,schema=@Schema()) @Valid @RequestParam(value = "accepted", required = true) Boolean accepted,@Parameter(in = ParameterIn.PATH, description = "the id of the proposal to approve or disaprove", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Milestone>> getMilestone(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
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

    public ResponseEntity<List<Version>> getVersionOfProposal(@Parameter(in = ParameterIn.PATH, description = "id of the proposal", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Version>>(objectMapper.readValue("[ {\n  \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"file_url\" : [ \"file_url\", \"file_url\" ],\n  \"stage\" : \"Department\",\n  \"Point\" : 0\n}, {\n  \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"file_url\" : [ \"file_url\", \"file_url\" ],\n  \"stage\" : \"Department\",\n  \"Point\" : 0\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Version>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Version>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
