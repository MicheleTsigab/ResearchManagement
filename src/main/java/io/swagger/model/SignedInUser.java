package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Signed-in user information
 */
@Schema(description = "Signed-in user information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")


public class SignedInUser   {
  @JsonProperty("refreshToken")
  private String refreshToken = null;

  @JsonProperty("accessToken")
  private String accessToken = null;

  @JsonProperty("username")
  private String username = null;

  @JsonProperty("userId")
  private String userId = null;

  public SignedInUser refreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }

  /**
   * Refresh Token, a unique secure string
   * @return refreshToken
   **/
  @Schema(description = "Refresh Token, a unique secure string")
  
    public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public SignedInUser accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  /**
   * JWT Token aka access token
   * @return accessToken
   **/
  @Schema(description = "JWT Token aka access token")
  
    public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public SignedInUser username(String username) {
    this.username = username;
    return this;
  }

  /**
   * User Name
   * @return username
   **/
  @Schema(description = "User Name")
  
    public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public SignedInUser userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * User Identifier
   * @return userId
   **/
  @Schema(description = "User Identifier")
  
    public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignedInUser signedInUser = (SignedInUser) o;
    return Objects.equals(this.refreshToken, signedInUser.refreshToken) &&
        Objects.equals(this.accessToken, signedInUser.accessToken) &&
        Objects.equals(this.username, signedInUser.username) &&
        Objects.equals(this.userId, signedInUser.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(refreshToken, accessToken, username, userId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignedInUser {\n");
    
    sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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
