package io.research.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Milestone
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")


public class Milestone   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("activity")
  @Valid
  private List<String> activity = null;

  @JsonProperty("startDate")
  private OffsetDateTime startDate = null;

  @JsonProperty("endDate")
  private OffsetDateTime endDate = null;

  @JsonProperty("budget")
  private Long budget = null;

  @JsonProperty("requested")
  private Boolean requested = false;

  @JsonProperty("approved")
  private Boolean approved = false;

  public Milestone id(Long id) {
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

  public Milestone name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name of the milestone
   * @return name
   **/
  @Schema(description = "name of the milestone")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Milestone activity(List<String> activity) {
    this.activity = activity;
    return this;
  }

  public Milestone addActivityItem(String activityItem) {
    if (this.activity == null) {
      this.activity = new ArrayList<String>();
    }
    this.activity.add(activityItem);
    return this;
  }

  /**
   * Get activity
   * @return activity
   **/
  @Schema(description = "")
  
    public List<String> getActivity() {
    return activity;
  }

  public void setActivity(List<String> activity) {
    this.activity = activity;
  }

  public Milestone startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
   **/
  @Schema(description = "")
  
    @Valid
    public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public Milestone endDate(OffsetDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
   **/
  @Schema(description = "")
  
    @Valid
    public OffsetDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  public Milestone budget(Long budget) {
    this.budget = budget;
    return this;
  }

  /**
   * Get budget
   * @return budget
   **/
  @Schema(description = "")
  
    public Long getBudget() {
    return budget;
  }

  public void setBudget(Long budget) {
    this.budget = budget;
  }

  public Milestone requested(Boolean requested) {
    this.requested = requested;
    return this;
  }

  /**
   * Get requested
   * @return requested
   **/
  @Schema(description = "")
  
    public Boolean isRequested() {
    return requested;
  }

  public void setRequested(Boolean requested) {
    this.requested = requested;
  }

  public Milestone approved(Boolean approved) {
    this.approved = approved;
    return this;
  }

  /**
   * Get approved
   * @return approved
   **/
  @Schema(description = "")
  
    public Boolean isApproved() {
    return approved;
  }

  public void setApproved(Boolean approved) {
    this.approved = approved;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Milestone milestone = (Milestone) o;
    return Objects.equals(this.id, milestone.id) &&
        Objects.equals(this.name, milestone.name) &&
        Objects.equals(this.activity, milestone.activity) &&
        Objects.equals(this.startDate, milestone.startDate) &&
        Objects.equals(this.endDate, milestone.endDate) &&
        Objects.equals(this.budget, milestone.budget) &&
        Objects.equals(this.requested, milestone.requested) &&
        Objects.equals(this.approved, milestone.approved);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, activity, startDate, endDate, budget, requested, approved);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Milestone {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    activity: ").append(toIndentedString(activity)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    budget: ").append(toIndentedString(budget)).append("\n");
    sb.append("    requested: ").append(toIndentedString(requested)).append("\n");
    sb.append("    approved: ").append(toIndentedString(approved)).append("\n");
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
