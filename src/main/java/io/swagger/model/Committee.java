package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Point;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Committee
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")


public class Committee   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("review")
  @Valid
  private List<String> review = null;

  @JsonProperty("point")
  @Valid
  private List<Point> point = null;

  public Committee id(Long id) {
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

  public Committee name(String name) {
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

  public Committee review(List<String> review) {
    this.review = review;
    return this;
  }

  public Committee addReviewItem(String reviewItem) {
    if (this.review == null) {
      this.review = new ArrayList<String>();
    }
    this.review.add(reviewItem);
    return this;
  }

  /**
   * Get review
   * @return review
   **/
  @Schema(description = "")
  
    public List<String> getReview() {
    return review;
  }

  public void setReview(List<String> review) {
    this.review = review;
  }

  public Committee point(List<Point> point) {
    this.point = point;
    return this;
  }

  public Committee addPointItem(Point pointItem) {
    if (this.point == null) {
      this.point = new ArrayList<Point>();
    }
    this.point.add(pointItem);
    return this;
  }

  /**
   * Get point
   * @return point
   **/
  @Schema(description = "")
      @Valid
    public List<Point> getPoint() {
    return point;
  }

  public void setPoint(List<Point> point) {
    this.point = point;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Committee committee = (Committee) o;
    return Objects.equals(this.id, committee.id) &&
        Objects.equals(this.name, committee.name) &&
        Objects.equals(this.review, committee.review) &&
        Objects.equals(this.point, committee.point);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, review, point);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Committee {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    review: ").append(toIndentedString(review)).append("\n");
    sb.append("    point: ").append(toIndentedString(point)).append("\n");
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
