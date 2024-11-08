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
 * Director
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-17T11:17:33.178797818Z[GMT]")

@Entity
@Table(name = "director")
public class Director {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)  // Solo visible en la respuesta, no en la solicitud
  @Column(name = "id")
  private Integer id;

  @JsonProperty("name")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Excluye del JSON si está ausente
  @JsonSetter(nulls = Nulls.FAIL)               // Falla si se recibe un valor nulo
  @Column(name = "name", nullable = false)
  private String name;

  @JsonProperty("biography")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Excluye del JSON si está ausente
  @JsonSetter(nulls = Nulls.FAIL)               // Falla si se recibe un valor nulo
  @Column(name = "biography", columnDefinition = "TEXT")
  private String biography;

  // Constructor vacío para JPA
  public Director() {
  }

  public Director name(String name) {
    this.name = name;
    return this;
  }

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

  @Schema(description = "Biography of the director")
  public String getBiography() {
    return biography;
  }

  public void setBiography(String biography) {
    this.biography = biography;
  }

  // Getter y Setter para id
  @Schema(description = "Unique identifier for the director")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Director director = (Director) o;
    return Objects.equals(id, director.id) &&
            Objects.equals(name, director.name) &&
            Objects.equals(biography, director.biography);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, biography);
  }

  @Override
  public String toString() {
    return "Director{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", biography='" + biography + '\'' +
            '}';
  }
}
