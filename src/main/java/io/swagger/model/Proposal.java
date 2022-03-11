package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Proposal
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")


public class Proposal   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("call_title")
  private String callTitle = null;

  @JsonProperty("deadline")
  private OffsetDateTime deadline = null;

  @JsonProperty("submitted_on")
  private OffsetDateTime submittedOn = null;

  @JsonProperty("author")
  private String author = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("abstract")
  private String _abstract = null;

  @JsonProperty("file")
  @Valid
  private List<Object> file = null;

  /**
   * Gets or Sets stage
   */
  public enum StageEnum {
    DEPARMENT("Deparment"),
    
    COLLEGE("College"),
    
    RVP("RVP"),
    
    RD("RD");

    private String value;

    StageEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StageEnum fromValue(String text) {
      for (StageEnum b : StageEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("stage")
  private StageEnum stage = null;

  @JsonProperty("remainingDay")
  private Integer remainingDay = null;

  @JsonProperty("totalBudget")
  private Long totalBudget = null;

  @JsonProperty("remainingBudget")
  private Long remainingBudget = null;

  public Proposal id(Long id) {
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

  public Proposal callTitle(String callTitle) {
    this.callTitle = callTitle;
    return this;
  }

  /**
   * Get callTitle
   * @return callTitle
   **/
  @Schema(description = "")
  
    public String getCallTitle() {
    return callTitle;
  }

  public void setCallTitle(String callTitle) {
    this.callTitle = callTitle;
  }

  public Proposal deadline(OffsetDateTime deadline) {
    this.deadline = deadline;
    return this;
  }

  /**
   * Get deadline
   * @return deadline
   **/
  @Schema(description = "")
  
    @Valid
    public OffsetDateTime getDeadline() {
    return deadline;
  }

  public void setDeadline(OffsetDateTime deadline) {
    this.deadline = deadline;
  }

  public Proposal submittedOn(OffsetDateTime submittedOn) {
    this.submittedOn = submittedOn;
    return this;
  }

  /**
   * Get submittedOn
   * @return submittedOn
   **/
  @Schema(description = "")
  
    @Valid
    public OffsetDateTime getSubmittedOn() {
    return submittedOn;
  }

  public void setSubmittedOn(OffsetDateTime submittedOn) {
    this.submittedOn = submittedOn;
  }

  public Proposal author(String author) {
    this.author = author;
    return this;
  }

  /**
   * Get author
   * @return author
   **/
  @Schema(description = "")
  
    public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Proposal title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   **/
  @Schema(description = "")
  
    public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Proposal _abstract(String _abstract) {
    this._abstract = _abstract;
    return this;
  }

  /**
   * Get _abstract
   * @return _abstract
   **/
  @Schema(description = "")
  
    public String getAbstract() {
    return _abstract;
  }

  public void setAbstract(String _abstract) {
    this._abstract = _abstract;
  }

  public Proposal file(List<Object> file) {
    this.file = file;
    return this;
  }

  public Proposal addFileItem(Object fileItem) {
    if (this.file == null) {
      this.file = new ArrayList<Object>();
    }
    this.file.add(fileItem);
    return this;
  }

  /**
   * this type is array of object
   * @return file
   **/
  @Schema(description = "this type is array of object")
  
    public List<Object> getFile() {
    return file;
  }

  public void setFile(List<Object> file) {
    this.file = file;
  }

  public Proposal stage(StageEnum stage) {
    this.stage = stage;
    return this;
  }

  /**
   * Get stage
   * @return stage
   **/
  @Schema(description = "")
  
    public StageEnum getStage() {
    return stage;
  }

  public void setStage(StageEnum stage) {
    this.stage = stage;
  }

  public Proposal remainingDay(Integer remainingDay) {
    this.remainingDay = remainingDay;
    return this;
  }

  /**
   * if the proposal is accepted it will come with the number of day remaining until its last milestone
   * @return remainingDay
   **/
  @Schema(description = "if the proposal is accepted it will come with the number of day remaining until its last milestone")
  
    public Integer getRemainingDay() {
    return remainingDay;
  }

  public void setRemainingDay(Integer remainingDay) {
    this.remainingDay = remainingDay;
  }

  public Proposal totalBudget(Long totalBudget) {
    this.totalBudget = totalBudget;
    return this;
  }

  /**
   * if the proposal is accepted it will come with the total budget
   * @return totalBudget
   **/
  @Schema(description = "if the proposal is accepted it will come with the total budget")
  
    public Long getTotalBudget() {
    return totalBudget;
  }

  public void setTotalBudget(Long totalBudget) {
    this.totalBudget = totalBudget;
  }

  public Proposal remainingBudget(Long remainingBudget) {
    this.remainingBudget = remainingBudget;
    return this;
  }

  /**
   * if the proposal is accepted it will come with the remaining budget
   * @return remainingBudget
   **/
  @Schema(description = "if the proposal is accepted it will come with the remaining budget")
  
    public Long getRemainingBudget() {
    return remainingBudget;
  }

  public void setRemainingBudget(Long remainingBudget) {
    this.remainingBudget = remainingBudget;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Proposal proposal = (Proposal) o;
    return Objects.equals(this.id, proposal.id) &&
        Objects.equals(this.callTitle, proposal.callTitle) &&
        Objects.equals(this.deadline, proposal.deadline) &&
        Objects.equals(this.submittedOn, proposal.submittedOn) &&
        Objects.equals(this.author, proposal.author) &&
        Objects.equals(this.title, proposal.title) &&
        Objects.equals(this._abstract, proposal._abstract) &&
        Objects.equals(this.file, proposal.file) &&
        Objects.equals(this.stage, proposal.stage) &&
        Objects.equals(this.remainingDay, proposal.remainingDay) &&
        Objects.equals(this.totalBudget, proposal.totalBudget) &&
        Objects.equals(this.remainingBudget, proposal.remainingBudget);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, callTitle, deadline, submittedOn, author, title, _abstract, file, stage, remainingDay, totalBudget, remainingBudget);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Proposal {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    callTitle: ").append(toIndentedString(callTitle)).append("\n");
    sb.append("    deadline: ").append(toIndentedString(deadline)).append("\n");
    sb.append("    submittedOn: ").append(toIndentedString(submittedOn)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    _abstract: ").append(toIndentedString(_abstract)).append("\n");
    sb.append("    file: ").append(toIndentedString(file)).append("\n");
    sb.append("    stage: ").append(toIndentedString(stage)).append("\n");
    sb.append("    remainingDay: ").append(toIndentedString(remainingDay)).append("\n");
    sb.append("    totalBudget: ").append(toIndentedString(totalBudget)).append("\n");
    sb.append("    remainingBudget: ").append(toIndentedString(remainingBudget)).append("\n");
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
