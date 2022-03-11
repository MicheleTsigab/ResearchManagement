package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")


public class User   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  /**
   * Gets or Sets role
   */
  public enum RoleEnum {
    COE("CoE"),
    
    RVP("RVP"),
    
    DEPT("Dept"),
    
    COLLEGE("College");

    private String value;

    RoleEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RoleEnum fromValue(String text) {
      for (RoleEnum b : RoleEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("role")
  private RoleEnum role = null;

  @JsonProperty("avatar_url")
  private String avatarUrl = null;

  @JsonProperty("subno")
  private Integer subno = null;

  @JsonProperty("evano")
  private Integer evano = null;

  @JsonProperty("accno")
  private Integer accno = null;

  @JsonProperty("revno")
  private Integer revno = null;

  public User id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(description = "")
  
    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(description = "")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User role(RoleEnum role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
   * @return role
   **/
  @Schema(description = "")
  
    public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  public User avatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
    return this;
  }

  /**
   * Get avatarUrl
   * @return avatarUrl
   **/
  @Schema(description = "")
  
    public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public User subno(Integer subno) {
    this.subno = subno;
    return this;
  }

  /**
   * this is the number of submitted paper
   * @return subno
   **/
  @Schema(description = "this is the number of submitted paper")
  
    public Integer getSubno() {
    return subno;
  }

  public void setSubno(Integer subno) {
    this.subno = subno;
  }

  public User evano(Integer evano) {
    this.evano = evano;
    return this;
  }

  /**
   * this is the number of avaluated paper
   * @return evano
   **/
  @Schema(description = "this is the number of avaluated paper")
  
    public Integer getEvano() {
    return evano;
  }

  public void setEvano(Integer evano) {
    this.evano = evano;
  }

  public User accno(Integer accno) {
    this.accno = accno;
    return this;
  }

  /**
   * this is the number of accepted paper
   * @return accno
   **/
  @Schema(description = "this is the number of accepted paper")
  
    public Integer getAccno() {
    return accno;
  }

  public void setAccno(Integer accno) {
    this.accno = accno;
  }

  public User revno(Integer revno) {
    this.revno = revno;
    return this;
  }

  /**
   * this is the number of paper submitted to comment on.
   * @return revno
   **/
  @Schema(description = "this is the number of paper submitted to comment on.")
  
    public Integer getRevno() {
    return revno;
  }

  public void setRevno(Integer revno) {
    this.revno = revno;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.name, user.name) &&
        Objects.equals(this.role, user.role) &&
        Objects.equals(this.avatarUrl, user.avatarUrl) &&
        Objects.equals(this.subno, user.subno) &&
        Objects.equals(this.evano, user.evano) &&
        Objects.equals(this.accno, user.accno) &&
        Objects.equals(this.revno, user.revno);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, role, avatarUrl, subno, evano, accno, revno);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    avatarUrl: ").append(toIndentedString(avatarUrl)).append("\n");
    sb.append("    subno: ").append(toIndentedString(subno)).append("\n");
    sb.append("    evano: ").append(toIndentedString(evano)).append("\n");
    sb.append("    accno: ").append(toIndentedString(accno)).append("\n");
    sb.append("    revno: ").append(toIndentedString(revno)).append("\n");
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
