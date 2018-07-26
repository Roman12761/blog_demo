package model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

import static model.Post.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class Post {
    public static final String TABLE_NAME = "posts";
    private static final String ID_COLUMN = "id";
    private static final String SUMMARY_COLUMN = "summary";
    private static final String DESCRIPTION_COLUMN = "description";
    private static final String CREATING_DATE_COLUMN = "created";
    private static final String UPDATING_DATE_COLUMN = "updated";
    private static final String IMAGE_URL_COLUMN = "image_path";
    private static final String IS_VISIBLE_COLUMN = "is_visible";

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq_gen")
    @SequenceGenerator(name = "post_seq_gen", sequenceName = "post_id_seq", allocationSize = 1)
    @Column(name = ID_COLUMN)
    private int id;

    @NotNull
    @NotBlank
    @Column(name = SUMMARY_COLUMN)
    private String summary;

    @Column(name = DESCRIPTION_COLUMN)
    private String description;

    @Column(name = IMAGE_URL_COLUMN)
    private String image_url;

    @NotNull
    @Column(name = CREATING_DATE_COLUMN)
    private LocalDateTime dateOfCreating;

    @NotNull
    @Column(name = UPDATING_DATE_COLUMN)
    private LocalDateTime dateOfUpdating;

    @NotNull
    @Column(name = IS_VISIBLE_COLUMN)
    private Boolean visible;

    public Post() {
    }

    public Post(@NotNull @NotBlank String summary, String description, String image_url, @NotNull LocalDateTime dateOfCreating, @NotNull LocalDateTime dateOfUpdating, @NotNull Boolean visible) {
        this.summary = summary;
        this.description = description;
        this.image_url = image_url;
        this.dateOfCreating = dateOfCreating;
        this.dateOfUpdating = dateOfUpdating;
        this.visible = visible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public LocalDateTime getDateOfCreating() {
        return dateOfCreating;
    }

    public void setDateOfCreating(LocalDateTime dateOfCreating) {
        this.dateOfCreating = dateOfCreating;
    }

    public LocalDateTime getDateOfUpdating() {
        return dateOfUpdating;
    }

    public void setDateOfUpdating(LocalDateTime dateOfUpdating) {
        this.dateOfUpdating = dateOfUpdating;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}
