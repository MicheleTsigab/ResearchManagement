/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.33).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.AdminSendemailBody;
import org.threeten.bp.OffsetDateTime;
import org.springframework.core.io.Resource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")
@Validated
public interface AdminApi {

    @Operation(summary = "call for application", description = "This can only be done by CoE or RD.", tags={ "call" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation") })
    @RequestMapping(value = "/admin/call",
        consumes = { "multipart/form-data" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> postCall(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="title", required=true)  String title, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="topic", required=true)  String topic, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="deadline", required=true)  OffsetDateTime deadline, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true,schema=@Schema()) @RequestParam(value="postedDate", required=true)  OffsetDateTime postedDate, @Parameter(description = "file detail") @Valid @RequestPart("file") MultipartFile file);


    @Operation(summary = "Send email.", description = "", tags={ "email" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful Operation."),
        
        @ApiResponse(responseCode = "400", description = "not successful") })
    @RequestMapping(value = "/admin/sendemail",
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> sendEmail(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "subject", required = true) String subject, @NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "body", required = true) String body2, @Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody AdminSendemailBody body);

}

