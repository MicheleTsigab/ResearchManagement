package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PaperPidBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")


public class PaperPidBody   {
  @JsonProperty("title")
  private String title = null;

  @JsonProperty("abstract")
  private String _abstract = null;

  @JsonProperty("file")
  @Valid
  private List<Resource> file = null;

  public PaperPidBody title(String title) {
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

  public PaperPidBody _abstract(String _abstract) {
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

  public PaperPidBody file(List<Resource> file) {
    this.file = file;
    return this;
  }

  public PaperPidBody addFileItem(Resource fileItem) {
    if (this.file == null) {
      this.file = new ArrayList<Resource>();
    }
    this.file.add(fileItem);
    return this;
  }

  /**
   * Get file
   * @return file
   **/
  @Schema(description = "")
      @Valid
    public List<Resource> getFile() {
    return file;
  }

  public void setFile(List<Resource> file) {
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
    PaperPidBody paperPidBody = (PaperPidBody) o;
    return Objects.equals(this.title, paperPidBody.title) &&
        Objects.equals(this._abstract, paperPidBody._abstract) &&
        Objects.equals(this.file, paperPidBody.file);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, _abstract, file);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaperPidBody {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    _abstract: ").append(toIndentedString(_abstract)).append("\n");
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
