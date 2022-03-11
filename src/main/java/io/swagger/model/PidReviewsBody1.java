package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PidReviewsBody1
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")


public class PidReviewsBody1   {
  @JsonProperty("review")
  private String review = null;

  @JsonProperty("level")
  private String level = null;

  public PidReviewsBody1 review(String review) {
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

  public PidReviewsBody1 level(String level) {
    this.level = level;
    return this;
  }

  /**
   * Get level
   * @return level
   **/
  @Schema(description = "")
  
    public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PidReviewsBody1 pidReviewsBody1 = (PidReviewsBody1) o;
    return Objects.equals(this.review, pidReviewsBody1.review) &&
        Objects.equals(this.level, pidReviewsBody1.level);
  }

  @Override
  public int hashCode() {
    return Objects.hash(review, level);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PidReviewsBody1 {\n");
    
    sb.append("    review: ").append(toIndentedString(review)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
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
