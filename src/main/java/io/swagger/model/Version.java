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
 * this is final version submitted by the author.
 */
@Schema(description = "this is final version submitted by the author.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-11T07:16:01.610Z[GMT]")


public class Version   {
  @JsonProperty("date")
  private OffsetDateTime date = null;

  @JsonProperty("file_url")
  @Valid
  private List<String> fileUrl = null;

  /**
   * Stage of the file
   */
  public enum StageEnum {
    DEPARTMENT("Department"),
    
    COLLEGE("College"),
    
    RVP("RVP");

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

  @JsonProperty("Point")
  private Integer point = null;

  public Version date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
   **/
  @Schema(description = "")
  
    @Valid
    public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public Version fileUrl(List<String> fileUrl) {
    this.fileUrl = fileUrl;
    return this;
  }

  public Version addFileUrlItem(String fileUrlItem) {
    if (this.fileUrl == null) {
      this.fileUrl = new ArrayList<String>();
    }
    this.fileUrl.add(fileUrlItem);
    return this;
  }

  /**
   * Get fileUrl
   * @return fileUrl
   **/
  @Schema(description = "")
  
    public List<String> getFileUrl() {
    return fileUrl;
  }

  public void setFileUrl(List<String> fileUrl) {
    this.fileUrl = fileUrl;
  }

  public Version stage(StageEnum stage) {
    this.stage = stage;
    return this;
  }

  /**
   * Stage of the file
   * @return stage
   **/
  @Schema(description = "Stage of the file")
  
    public StageEnum getStage() {
    return stage;
  }

  public void setStage(StageEnum stage) {
    this.stage = stage;
  }

  public Version point(Integer point) {
    this.point = point;
    return this;
  }

  /**
   * total point given by the evaluation team.
   * @return point
   **/
  @Schema(description = "total point given by the evaluation team.")
  
    public Integer getPoint() {
    return point;
  }

  public void setPoint(Integer point) {
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
    Version version = (Version) o;
    return Objects.equals(this.date, version.date) &&
        Objects.equals(this.fileUrl, version.fileUrl) &&
        Objects.equals(this.stage, version.stage) &&
        Objects.equals(this.point, version.point);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, fileUrl, stage, point);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Version {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    fileUrl: ").append(toIndentedString(fileUrl)).append("\n");
    sb.append("    stage: ").append(toIndentedString(stage)).append("\n");
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
