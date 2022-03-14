package io.research.api;

import io.research.model.Proposal;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")
@RestController
public class ProposalsApiController implements ProposalsApi {

    private static final Logger log = LoggerFactory.getLogger(ProposalsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ProposalsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Proposal>> getProposal(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Which Proposal Do you need. accepted or evaluated or rejected." ,required=true,schema=@Schema(allowableValues={ "submitted", "evaluated", "accepted", "rejected", "disaproved" }
)) @Valid @RequestParam(value = "status", required = true) String status, @Parameter(in = ParameterIn.QUERY, description = "if it is given then return the list of proposal submitted to that call only." ,schema=@Schema()) @Valid @RequestParam(value = "callid", required = false) Integer callid) {
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

}
