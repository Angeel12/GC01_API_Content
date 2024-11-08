package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Director
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-17T11:17:33.178797818Z[GMT]")


public class Director   {
  @JsonProperty("id")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer id = null;

  @JsonProperty("name")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String name = null;

  @JsonProperty("biography")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String biography = null;

  @JsonProperty("birthDate")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String birthDate = null;


  public Director id(Integer id) { 

    this.id = id;
    return this;
  }

  /**
   * Unique identifier for the director
   * @return id
   **/
  
  @Schema(description = "Unique identifier for the director")
  
  public Integer getId() {  
    return id;
  }



  public void setId(Integer id) { 
    this.id = id;
  }

  public Director name(String name) { 

    this.name = name;
    return this;
  }

  /**
   * Name of the director
   * @return name
   **/
  
  @Schema(description = "Name of the director")
  
  public String getName() {  
    return name;
  }



  public void setName(String name) { 
    this.name = name;
  }

  public Director biography(String biography) { 

    this.biography = biography;
    return this;
  }

  /**
   * Biography of the director
   * @return biography
   **/
  
  @Schema(description = "Biography of the director")
  
  public String getBiography() {  
    return biography;
  }



  public void setBiography(String biography) { 
    this.biography = biography;
  }

  public Director birthDate(String birthDate) { 

    this.birthDate = birthDate;
    return this;
  }

  /**
   * Date of birth of the director
   * @return birthDate
   **/
  
  @Schema(description = "Date of birth of the director")
  
  public String getBirthDate() {  
    return birthDate;
  }



  public void setBirthDate(String birthDate) { 
    this.birthDate = birthDate;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Director director = (Director) o;
    return Objects.equals(this.id, director.id) &&
        Objects.equals(this.name, director.name) &&
        Objects.equals(this.biography, director.biography) &&
        Objects.equals(this.birthDate, director.birthDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, biography, birthDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Director {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    biography: ").append(toIndentedString(biography)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
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
