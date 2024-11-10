package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Content
 */
@Validated
@Entity
@Table(name = "content")
public class Content {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @Column(name = "id")
  private Integer id;

  @JsonProperty("type")
  @NotNull
  @Column(name = "type", length = 20, nullable = false)
  private String type;

  @JsonProperty("title")
  @NotNull
  @Column(name = "title", length = 255, nullable = false)
  private String title;

  @JsonProperty("synopsis")
  @Column(name = "synopsis", columnDefinition = "TEXT")
  private String synopsis;

  @JsonProperty("parentSeriesId")
  @Column(name = "parent_series_id")
  private Integer parentSeriesId;

  @JsonProperty("releaseYear")
  @NotNull
  @Column(name = "release_year")
  @Min(1900)
  @Max(2100)
  private Integer releaseYear;

  @JsonProperty("duration")
  @NotNull
  @Column(name = "duration")
  @Min(1)
  private Integer duration;

  @JsonProperty("coverImage")
  @Column(name = "cover_image", length = 255)
  private String coverImage;

  @JsonProperty("genre")
  @NotNull
  @Column(name = "genre", length = 20, nullable = false)
  private String genre;

  @JsonProperty("actorIds")
  @ElementCollection
  @CollectionTable(name = "content_actor", joinColumns = @JoinColumn(name = "content_id"))
  @Column(name = "actor_id")
  private List<Integer> actorIds = new ArrayList<>();

  @JsonProperty("directorIds")
  @ElementCollection
  @CollectionTable(name = "content_director", joinColumns = @JoinColumn(name = "content_id"))
  @Column(name = "director_id")
  private List<Integer> directorIds = new ArrayList<>();

  @Column(name = "language")
  @JsonProperty("language")
  private String language;

  @Column (name = "status")
  @JsonProperty("status")
  private String status;


  // Enums de validación para type, genre y language
  public enum ContentType {
    MOVIE("movie"),
    SERIES("series"),
    EPISODE("episode"),
    DOCUMENTARY("documentary");

    private final String valueType;

    ContentType(String value) {
      this.valueType = value;
    }

    public static boolean isValid(String type) {
      for (ContentType t : ContentType.values()) {
        if (t.valueType.equalsIgnoreCase(type)) {
          return true;
        }
      }
      return false;
    }
  }

  public enum GenreType {
    ACTION("action"),
    COMEDY("comedy"),
    DRAMA("drama"),
    HORROR("horror"),
    THRILLER("thriller"),
    ROMANCE("romance"),
    SCI_FI("sci-fi"),
    FANTASY("fantasy"),
    DOCUMENTARY("documentary"),
    ANIMATION("animation");

    private final String valueGenre;

    GenreType(String value) {
      this.valueGenre = value;
    }

    public static boolean isValid(String genre) {
      for (GenreType g : GenreType.values()) {
        if (g.valueGenre.equalsIgnoreCase(genre)) {
          return true;
        }
      }
      return false;
    }
  }

  public enum LanguageType {
    ENGLISH("english"),
    SPANISH("spanish"),
    FRENCH("french"),
    GERMAN("german"),
    ITALIAN("italian"),
    CHINESE("chinese"),
    JAPANESE("japanese"),
    KOREAN("korean"),
    ARABIC("arabic"),
    RUSSIAN("russian");

    private final String valueLanguage;

    LanguageType(String value) {
      this.valueLanguage = value;
    }

    public static boolean isValid(String language) {
      for (LanguageType l : LanguageType.values()) {
        if (l.valueLanguage.equalsIgnoreCase(language)) {
          return true;
        }
      }
      return false;
    }
  }

  public enum StatusType {
    PUBLIC("public"),
    PRIVATE("private"),
    UNLISTED("unlisted");

    private final String valueStatus;

    StatusType(String value) {
      this.valueStatus = value;
    }

    public static boolean isValid(String status) {
      for (StatusType s : StatusType.values()) {
        if (s.valueStatus.equalsIgnoreCase(status)) {
          return true;
        }
      }
      return false;
    }
  }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (StatusType.isValid(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status: " + status);
        }
    }

  // Métodos de validación para type, genre y language
  public String getType() {
    return type;
  }

  public void setType(String type) {
    if (ContentType.isValid(type)) {
      this.type = type;
    } else {
      throw new IllegalArgumentException("Invalid content type: " + type);
    }
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    if (GenreType.isValid(genre)) {
      this.genre = genre;
    } else {
      throw new IllegalArgumentException("Invalid genre: " + genre);
    }
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    if (LanguageType.isValid(language)) {
      this.language = language;
    } else {
      throw new IllegalArgumentException("Invalid language: " + language);
    }
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSynopsis() {
    return synopsis;
  }

  public void setSynopsis(String synopsis) {
    this.synopsis = synopsis;
  }

  public Integer getParentSeriesId() {
    return parentSeriesId;
  }

  public void setParentSeriesId(Integer parentSeriesId) {
    this.parentSeriesId = parentSeriesId;
  }

  public Integer getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(Integer releaseYear) {
    this.releaseYear = releaseYear;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public String getCoverImage() {
    return coverImage;
  }

  public void setCoverImage(String coverImage) {
    this.coverImage = coverImage;
  }

  public List<Integer> getActorIds() {
    return actorIds;
  }

  public void setActorIds(List<Integer> actorIds) {
    this.actorIds = actorIds;
  }

  public List<Integer> getDirectorIds() {
    return directorIds;
  }

  public void setDirectorIds(List<Integer> directorIds) {
    this.directorIds = directorIds;
  }

  @Override
  public boolean equals(Object o) {
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
            Objects.equals(this.language, content.language) &&
            Objects.equals(this.actorIds, content.actorIds) &&
            Objects.equals(this.directorIds, content.directorIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, title, synopsis, parentSeriesId, releaseYear, duration, coverImage, genre, language, actorIds, directorIds);
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
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    actorIds: ").append(toIndentedString(actorIds)).append("\n");
    sb.append("    directorIds: ").append(toIndentedString(directorIds)).append("\n");
    sb.append("status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
