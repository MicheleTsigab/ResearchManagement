package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.core.io.Resource;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AdminCallBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")


public class AdminCallBody   {
  @JsonProperty("title")
  private String title = null;

  @JsonProperty("topic")
  private String topic = null;

  @JsonProperty("deadline")
  private OffsetDateTime deadline = null;

  @JsonProperty("postedDate")
  private OffsetDateTime postedDate = null;

  @JsonProperty("file")
  private Resource file = null;

  public AdminCallBody title(String title) {
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

  public AdminCallBody topic(String topic) {
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

  public AdminCallBody deadline(OffsetDateTime deadline) {
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

  public AdminCallBody postedDate(OffsetDateTime postedDate) {
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

  public AdminCallBody file(Resource file) {
    this.file = file;
    return this;
  }

  /**
   * file to upload
   * @return file
   **/
  @Schema(description = "file to upload")
  
    @Valid
    public Resource getFile() {
    return file;
  }

  public void setFile(Resource file) {
    this.file = file;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdminCallBody adminCallBody = (AdminCallBody) o;
    return Objects.equals(this.title, adminCallBody.title) &&
        Objects.equals(this.topic, adminCallBody.topic) &&
        Objects.equals(this.deadline, adminCallBody.deadline) &&
        Objects.equals(this.postedDate, adminCallBody.postedDate) &&
        Objects.equals(this.file, adminCallBody.file);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, topic, deadline, postedDate, file);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminCallBody {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    topic: ").append(toIndentedString(topic)).append("\n");
    sb.append("    deadline: ").append(toIndentedString(deadline)).append("\n");
    sb.append("    postedDate: ").append(toIndentedString(postedDate)).append("\n");
    sb.append("    file: ").append(toIndentedString(file)).append("\n");
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
