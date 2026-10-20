package com.collectiverse.collectiverse.dominio.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_rating")
    @SequenceGenerator(name = "sec_rating", sequenceName = "sec_rating", allocationSize = 1)
    @Column(name = "id_rating")
    private Integer id;

    @Column(name = "id_user", nullable = false)
    private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_publication", nullable = false)
    private Publication publication;

    @Column(name = "user_rating")
    private Integer userRating;

    @Column(name = "publication_rating")
    private Integer publicationRating;

    @Column(name = "comment", length = 255)
    private String comment;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @PrePersist
    protected void prePersist() {
        if (date == null) date = LocalDateTime.now();
    }

    // --- Auditoría ---
    @Column(name = "status", nullable = false)
    private Boolean status = true;

    @CreationTimestamp
    @Column(name = "created", updatable = false, nullable = false)
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "modified")
    private LocalDateTime modified;

    @Column(name = "created_id", nullable = false)
    private Integer createdId;

    @Column(name = "modified_id")
    private Integer modifiedId;

    // Getters y Setters...
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public Publication getPublication() { return publication; }
    public void setPublication(Publication publication) { this.publication = publication; }
    public Integer getUserRating() { return userRating; }
    public void setUserRating(Integer userRating) { this.userRating = userRating; }
    public Integer getPublicationRating() { return publicationRating; }
    public void setPublicationRating(Integer publicationRating) { this.publicationRating = publicationRating; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
    public LocalDateTime getCreated() { return created; }
    public void setCreated(LocalDateTime created) { this.created = created; }
    public LocalDateTime getModified() { return modified; }
    public void setModified(LocalDateTime modified) { this.modified = modified; }
    public Integer getCreatedId() { return createdId; }
    public void setCreatedId(Integer createdId) { this.createdId = createdId; }
    public Integer getModifiedId() { return modifiedId; }
    public void setModifiedId(Integer modifiedId) { this.modifiedId = modifiedId; }
}