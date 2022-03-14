package io.research.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * AdminSendemailBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")


public class AdminSendemailBody   {
  @JsonProperty("email")
  @Valid
  private List<String> email = null;

  public AdminSendemailBody email(List<String> email) {
    this.email = email;
    return this;
  }

  public AdminSendemailBody addEmailItem(String emailItem) {
    if (this.email == null) {
      this.email = new ArrayList<String>();
    }
    this.email.add(emailItem);
    return this;
  }

  /**
   * Get email
   * @return email
   **/
  @Schema(description = "")
  
    public List<String> getEmail() {
    return email;
  }

  public void setEmail(List<String> email) {
    this.email = email;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdminSendemailBody adminSendemailBody = (AdminSendemailBody) o;
    return Objects.equals(this.email, adminSendemailBody.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminSendemailBody {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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
