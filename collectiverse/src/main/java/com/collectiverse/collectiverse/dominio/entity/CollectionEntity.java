package com.collectiverse.collectiverse.dominio.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "collection")
public class CollectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_collection")
    @SequenceGenerator(name = "sec_collection", sequenceName = "sec_collection", allocationSize = 1)
    @Column(name = "id_collection")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

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
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
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