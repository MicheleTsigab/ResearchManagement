package io.research.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ProposalCall
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")


public class ProposalCall   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("topic")
  private String topic = null;

  @JsonProperty("file")
  private Object file = null;

  @JsonProperty("deadline")
  private OffsetDateTime deadline = null;

  @JsonProperty("posted_date")
  private OffsetDateTime postedDate = null;

  @JsonProperty("subno")
  private Integer subno = null;

  @JsonProperty("evano")
  private Integer evano = null;

  @JsonProperty("accno")
  private Integer accno = null;

  public ProposalCall id(Long id) {
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

  public ProposalCall title(String title) {
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

  public ProposalCall topic(String topic) {
    this.topic = topic;
    return this;
  }

  /**
   * Get topic
   * @return topic
   **/
  @Schema(description = "")
  
    public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public ProposalCall file(Object file) {
    this.file = file;
    return this;
  }

  /**
   * Get file
   * @return file
   **/
  @Schema(description = "")
  
    public Object getFile() {
    return file;
  }

  public void setFile(Object file) {
    this.file = file;
  }

  public ProposalCall deadline(OffsetDateTime deadline) {
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

  public ProposalCall postedDate(OffsetDateTime postedDate) {
    this.postedDate = postedDate;
    return this;
  }

  /**
   * Get postedDate
   * @return postedDate
   **/
  @Schema(description = "")
  
    @Valid
    public OffsetDateTime getPostedDate() {
    return postedDate;
  }

  public void setPostedDate(OffsetDateTime postedDate) {
    this.postedDate = postedDate;
  }

  public ProposalCall subno(Integer subno) {
    this.subno = subno;
    return this;
  }

  /**
   * the number of submitted proposal to this call
   * @return subno
   **/
  @Schema(description = "the number of submitted proposal to this call")
  
    public Integer getSubno() {
    return subno;
  }

  public void setSubno(Integer subno) {
    this.subno = subno;
  }

  public ProposalCall evano(Integer evano) {
    this.evano = evano;
    return this;
  }

  /**
   * the number of proposals that are currently evaluated
   * @return evano
   **/
  @Schema(description = "the number of proposals that are currently evaluated")
  
    public Integer getEvano() {
    return evano;
  }

  public void setEvano(Integer evano) {
    this.evano = evano;
  }

  public ProposalCall accno(Integer accno) {
    this.accno = accno;
    return this;
  }

  /**
   * the number of accepted proposals
   * @return accno
   **/
  @Schema(description = "the number of accepted proposals")
  
    public Integer getAccno() {
    return accno;
  }

  public void setAccno(Integer accno) {
    this.accno = accno;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProposalCall proposalCall = (ProposalCall) o;
    return Objects.equals(this.id, proposalCall.id) &&
        Objects.equals(this.title, proposalCall.title) &&
        Objects.equals(this.topic, proposalCall.topic) &&
        Objects.equals(this.file, proposalCall.file) &&
        Objects.equals(this.deadline, proposalCall.deadline) &&
        Objects.equals(this.postedDate, proposalCall.postedDate) &&
        Objects.equals(this.subno, proposalCall.subno) &&
        Objects.equals(this.evano, proposalCall.evano) &&
        Objects.equals(this.accno, proposalCall.accno);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, topic, file, deadline, postedDate, subno, evano, accno);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProposalCall {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    topic: ").append(toIndentedString(topic)).append("\n");
    sb.append("    file: ").append(toIndentedString(file)).append("\n");
    sb.append("    deadline: ").append(toIndentedString(deadline)).append("\n");
    sb.append("    postedDate: ").append(toIndentedString(postedDate)).append("\n");
    sb.append("    subno: ").append(toIndentedString(subno)).append("\n");
    sb.append("    evano: ").append(toIndentedString(evano)).append("\n");
    sb.append("    accno: ").append(toIndentedString(accno)).append("\n");
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
