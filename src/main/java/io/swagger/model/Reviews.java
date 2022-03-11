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
 * Reviews
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")


public class Reviews   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("review")
  private String review = null;

  /**
   * Gets or Sets level
   */
  public enum LevelEnum {
    MANDATORY("Mandatory"),
    
    OPTIONAL("Optional");

    private String value;

    LevelEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LevelEnum fromValue(String text) {
      for (LevelEnum b : LevelEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("level")
  private LevelEnum level = null;

  /**
   * this show whether the author accepted the review or not.
   */
  public enum StatusEnum {
    ACCEPTED("Accepted"),
    
    REJECTED("Rejected"),
    
    NONE("None");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")
  private StatusEnum status = StatusEnum.NONE;

  @JsonProperty("remark")
  private String remark = null;

  public Reviews id(Long id) {
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

  public Reviews review(String review) {
    this.review = review;
    return this;
  }

  /**
   * Get review
   * @return review
   **/
  @Schema(description = "")
  
    public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }

  public Reviews level(LevelEnum level) {
    this.level = level;
    return this;
  }

  /**
   * Get level
   * @return level
   **/
  @Schema(description = "")
  
    public LevelEnum getLevel() {
    return level;
  }

  public void setLevel(LevelEnum level) {
    this.level = level;
  }

  public Reviews status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * this show whether the author accepted the review or not.
   * @return status
   **/
  @Schema(description = "this show whether the author accepted the review or not.")
  
    public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Reviews remark(String remark) {
    this.remark = remark;
    return this;
  }

  /**
   * Get remark
   * @return remark
   **/
  @Schema(description = "")
  
    public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reviews reviews = (Reviews) o;
    return Objects.equals(this.id, reviews.id) &&
        Objects.equals(this.review, reviews.review) &&
        Objects.equals(this.level, reviews.level) &&
        Objects.equals(this.status, reviews.status) &&
        Objects.equals(this.remark, reviews.remark);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, review, level, status, remark);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reviews {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    review: ").append(toIndentedString(review)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    remark: ").append(toIndentedString(remark)).append("\n");
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
