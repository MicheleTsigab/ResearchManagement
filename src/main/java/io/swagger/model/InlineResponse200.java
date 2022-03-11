package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineResponse200
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")


public class InlineResponse200   {
  @JsonProperty("files_url")
  @Valid
  private List<String> filesUrl = null;

  public InlineResponse200 filesUrl(List<String> filesUrl) {
    this.filesUrl = filesUrl;
    return this;
  }

  public InlineResponse200 addFilesUrlItem(String filesUrlItem) {
    if (this.filesUrl == null) {
      this.filesUrl = new ArrayList<String>();
    }
    this.filesUrl.add(filesUrlItem);
    return this;
  }

  /**
   * Get filesUrl
   * @return filesUrl
   **/
  @Schema(description = "")
  
    public List<String> getFilesUrl() {
    return filesUrl;
  }

  public void setFilesUrl(List<String> filesUrl) {
    this.filesUrl = filesUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.filesUrl, inlineResponse200.filesUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filesUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    filesUrl: ").append(toIndentedString(filesUrl)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
