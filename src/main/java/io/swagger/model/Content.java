package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.Actor;
import io.swagger.model.Director;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Content
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-17T11:17:33.178797818Z[GMT]")


public class Content   {
  @JsonProperty("id")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer id = null;

  /**
   * Type of the content (e.g., movie, series, episode, documentary)
   */
  public enum TypeEnum {
    MOVIE("movie"),
    
    SERIES("series"),
    
    EPISODE("episode"),
    
    DOCUMENTARY("documentary");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("type")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private TypeEnum type = null;

  @JsonProperty("title")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String title = null;

  @JsonProperty("synopsis")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String synopsis = null;

  @JsonProperty("parentSeriesId")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer parentSeriesId = null;

  @JsonProperty("releaseYear")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer releaseYear = null;

  @JsonProperty("duration")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer duration = null;

  @JsonProperty("coverImage")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String coverImage = null;

  /**
   * Genre associated with the content
   */
  public enum GenreEnum {
    ACTION("Action"),
    
    COMEDY("Comedy"),
    
    DRAMA("Drama"),
    
    HORROR("Horror"),
    
    THRILLER("Thriller"),
    
    ROMANCE("Romance"),
    
    SCI_FI("Sci-Fi"),
    
    FANTASY("Fantasy"),
    
    DOCUMENTARY("Documentary"),
    
    ANIMATION("Animation");

    private String value;

    GenreEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GenreEnum fromValue(String text) {
      for (GenreEnum b : GenreEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("genre")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private GenreEnum genre = null;

  /**
   * Gets or Sets languages
   */
  public enum LanguagesEnum {
    ENGLISH("English"),
    
    SPANISH("Spanish"),
    
    FRENCH("French"),
    
    MANDARIN("Mandarin"),
    
    ARABIC("Arabic"),
    
    HINDI("Hindi"),
    
    RUSSIAN("Russian"),
    
    PORTUGUESE("Portuguese");

    private String value;

    LanguagesEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LanguagesEnum fromValue(String text) {
      for (LanguagesEnum b : LanguagesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("languages")
  @Valid
  private List<LanguagesEnum> languages = null;
  @JsonProperty("actors")
  @Valid
  private List<Actor> actors = null;
  @JsonProperty("directors")
  @Valid
  private List<Director> directors = null;

  public Content id(Integer id) { 

    this.id = id;
    return this;
  }

  /**
   * Unique identifier for the content
   * @return id
   **/
  
  @Schema(description = "Unique identifier for the content")
  
  public Integer getId() {  
    return id;
  }



  public void setId(Integer id) { 
    this.id = id;
  }

  public Content type(TypeEnum type) { 

    this.type = type;
    return this;
  }

  /**
   * Type of the content (e.g., movie, series, episode, documentary)
   * @return type
   **/
  
  @Schema(description = "Type of the content (e.g., movie, series, episode, documentary)")
  
  public TypeEnum getType() {  
    return type;
  }



  public void setType(TypeEnum type) { 
    this.type = type;
  }

  public Content title(String title) { 

    this.title = title;
    return this;
  }

  /**
   * Title of the content
   * @return title
   **/
  
  @Schema(description = "Title of the content")
  
  public String getTitle() {  
    return title;
  }



  public void setTitle(String title) { 
    this.title = title;
  }

  public Content synopsis(String synopsis) { 

    this.synopsis = synopsis;
    return this;
  }

  /**
   * A short synopsis of the content
   * @return synopsis
   **/
  
  @Schema(description = "A short synopsis of the content")
  
  public String getSynopsis() {  
    return synopsis;
  }



  public void setSynopsis(String synopsis) { 
    this.synopsis = synopsis;
  }

  public Content parentSeriesId(Integer parentSeriesId) { 

    this.parentSeriesId = parentSeriesId;
    return this;
  }

  /**
   * ID of the parent series if the content is an episode
   * @return parentSeriesId
   **/
  
  @Schema(description = "ID of the parent series if the content is an episode")
  
  public Integer getParentSeriesId() {  
    return parentSeriesId;
  }



  public void setParentSeriesId(Integer parentSeriesId) { 
    this.parentSeriesId = parentSeriesId;
  }

  public Content releaseYear(Integer releaseYear) { 

    this.releaseYear = releaseYear;
    return this;
  }

  /**
   * Year of release
   * @return releaseYear
   **/
  
  @Schema(description = "Year of release")
  
  public Integer getReleaseYear() {  
    return releaseYear;
  }



  public void setReleaseYear(Integer releaseYear) { 
    this.releaseYear = releaseYear;
  }

  public Content duration(Integer duration) { 

    this.duration = duration;
    return this;
  }

  /**
   * Duration in minutes
   * @return duration
   **/
  
  @Schema(description = "Duration in minutes")
  
  public Integer getDuration() {  
    return duration;
  }



  public void setDuration(Integer duration) { 
    this.duration = duration;
  }

  public Content coverImage(String coverImage) { 

    this.coverImage = coverImage;
    return this;
  }

  /**
   * URL of the cover image for the content
   * @return coverImage
   **/
  
  @Schema(description = "URL of the cover image for the content")
  
  public String getCoverImage() {  
    return coverImage;
  }



  public void setCoverImage(String coverImage) { 
    this.coverImage = coverImage;
  }

  public Content genre(GenreEnum genre) { 

    this.genre = genre;
    return this;
  }

  /**
   * Genre associated with the content
   * @return genre
   **/
  
  @Schema(description = "Genre associated with the content")
  
  public GenreEnum getGenre() {  
    return genre;
  }



  public void setGenre(GenreEnum genre) { 
    this.genre = genre;
  }

  public Content languages(List<LanguagesEnum> languages) { 

    this.languages = languages;
    return this;
  }

  public Content addLanguagesItem(LanguagesEnum languagesItem) {
    if (this.languages == null) {
      this.languages = new ArrayList<LanguagesEnum>();
    }
    this.languages.add(languagesItem);
    return this;
  }

  /**
   * List of languages available for the content
   * @return languages
   **/
  
  @Schema(description = "List of languages available for the content")
  
  public List<LanguagesEnum> getLanguages() {  
    return languages;
  }



  public void setLanguages(List<LanguagesEnum> languages) { 
    this.languages = languages;
  }

  public Content actors(List<Actor> actors) { 

    this.actors = actors;
    return this;
  }

  public Content addActorsItem(Actor actorsItem) {
    if (this.actors == null) {
      this.actors = new ArrayList<Actor>();
    }
    this.actors.add(actorsItem);
    return this;
  }

  /**
   * List of actors associated with the content
   * @return actors
   **/
  
  @Schema(description = "List of actors associated with the content")
  @Valid
  public List<Actor> getActors() {  
    return actors;
  }



  public void setActors(List<Actor> actors) { 
    this.actors = actors;
  }

  public Content directors(List<Director> directors) { 

    this.directors = directors;
    return this;
  }

  public Content addDirectorsItem(Director directorsItem) {
    if (this.directors == null) {
      this.directors = new ArrayList<Director>();
    }
    this.directors.add(directorsItem);
    return this;
  }

  /**
   * List of directors associated with the content
   * @return directors
   **/
  
  @Schema(description = "List of directors associated with the content")
  @Valid
  public List<Director> getDirectors() {  
    return directors;
  }



  public void setDirectors(List<Director> directors) { 
    this.directors = directors;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Content content = (Content) o;
    return Objects.equals(this.id, content.id) &&
        Objects.equals(this.type, content.type) &&
        Objects.equals(this.title, content.title) &&
        Objects.equals(this.synopsis, content.synopsis) &&
        Objects.equals(this.parentSeriesId, content.parentSeriesId) &&
        Objects.equals(this.releaseYear, content.releaseYear) &&
        Objects.equals(this.duration, content.duration) &&
        Objects.equals(this.coverImage, content.coverImage) &&
        Objects.equals(this.genre, content.genre) &&
        Objects.equals(this.languages, content.languages) &&
        Objects.equals(this.actors, content.actors) &&
        Objects.equals(this.directors, content.directors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, title, synopsis, parentSeriesId, releaseYear, duration, coverImage, genre, languages, actors, directors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Content {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    synopsis: ").append(toIndentedString(synopsis)).append("\n");
    sb.append("    parentSeriesId: ").append(toIndentedString(parentSeriesId)).append("\n");
    sb.append("    releaseYear: ").append(toIndentedString(releaseYear)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    coverImage: ").append(toIndentedString(coverImage)).append("\n");
    sb.append("    genre: ").append(toIndentedString(genre)).append("\n");
    sb.append("    languages: ").append(toIndentedString(languages)).append("\n");
    sb.append("    actors: ").append(toIndentedString(actors)).append("\n");
    sb.append("    directors: ").append(toIndentedString(directors)).append("\n");
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
