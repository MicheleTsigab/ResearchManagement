package io.research.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * Review
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")


public class Review   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("reviewer")
  private String reviewer = null;

  @JsonProperty("review")
  private String review = null;

  @JsonProperty("level")
  private String level = null;

  @JsonProperty("sent")
  private Boolean sent = false;

  public Review id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(description = "")
  
    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Review reviewer(String reviewer) {
    this.reviewer = reviewer;
    return this;
  }

  /**
   * Get reviewer
   * @return reviewer
   **/
  @Schema(description = "")
  
    public String getReviewer() {
    return reviewer;
  }

  public void setReviewer(String reviewer) {
    this.reviewer = reviewer;
  }

  public Review review(String review) {
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

  public Review level(String level) {
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

  public Review sent(Boolean sent) {
    this.sent = sent;
    return this;
  }

  /**
   * decide whether to send the review to the author or not.
   * @return sent
   **/
  @Schema(description = "decide whether to send the review to the author or not.")
  
    public Boolean isSent() {
    return sent;
  }

  public void setSent(Boolean sent) {
    this.sent = sent;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Review review = (Review) o;
    return Objects.equals(this.id, review.id) &&
        Objects.equals(this.reviewer, review.reviewer) &&
        Objects.equals(this.review, review.review) &&
        Objects.equals(this.level, review.level) &&
        Objects.equals(this.sent, review.sent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, reviewer, review, level, sent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Review {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    reviewer: ").append(toIndentedString(reviewer)).append("\n");
    sb.append("    review: ").append(toIndentedString(review)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    sent: ").append(toIndentedString(sent)).append("\n");
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
