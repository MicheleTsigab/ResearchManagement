package io.research.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Paper
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")


public class Paper   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("abstarct")
  private String abstarct = null;

  @JsonProperty("file")
  @Valid
  private List<Object> file = null;

  public Paper id(Long id) {
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

  public Paper title(String title) {
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

  public Paper abstarct(String abstarct) {
    this.abstarct = abstarct;
    return this;
  }

  /**
   * Get abstarct
   * @return abstarct
   **/
  @Schema(description = "")
  
    public String getAbstarct() {
    return abstarct;
  }

  public void setAbstarct(String abstarct) {
    this.abstarct = abstarct;
  }

  public Paper file(List<Object> file) {
    this.file = file;
    return this;
  }

  public Paper addFileItem(Object fileItem) {
    if (this.file == null) {
      this.file = new ArrayList<Object>();
    }
    this.file.add(fileItem);
    return this;
  }

  /**
   * Get file
   * @return file
   **/
  @Schema(description = "")
  
    public List<Object> getFile() {
    return file;
  }

  public void setFile(List<Object> file) {
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
    Paper paper = (Paper) o;
    return Objects.equals(this.id, paper.id) &&
        Objects.equals(this.title, paper.title) &&
        Objects.equals(this.abstarct, paper.abstarct) &&
        Objects.equals(this.file, paper.file);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, abstarct, file);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Paper {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    abstarct: ").append(toIndentedString(abstarct)).append("\n");
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
