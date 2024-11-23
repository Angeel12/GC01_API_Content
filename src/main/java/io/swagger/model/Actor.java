package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import io.swagger.configuration.NotUndefined;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.Objects;

/**
 * Actor
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-17T11:17:33.178797818Z[GMT]")

@Entity
@Table(name = "actor")
public class Actor   {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)  // Solo visible en la respuesta, no en la solicitud
  @Column(name = "id")
  private Integer id = null;

  @JsonProperty("name")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String name = null;

  @JsonProperty("biography")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String biography = null;



  public Actor id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for the actor
   * @return id
   **/
  @Schema(description = "Unique identifier for the actor")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Actor name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the actor
   * @return name
   **/
  @Schema(description = "Name of the actor")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Actor biography(String biography) {
    this.biography = biography;
    return this;
  }

  /**
   * Biography of the actor
   * @return biography
   **/
  @Schema(description = "Biography of the actor")
  public String getBiography() {
    return biography;
  }

  public void setBiography(String biography) {
    this.biography = biography;
  }




  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Actor actor = (Actor) o;
    return Objects.equals(this.id, actor.id) &&
            Objects.equals(this.name, actor.name) &&
            Objects.equals(this.biography, actor.biography);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, biography);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Actor {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    biography: ").append(toIndentedString(biography)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}