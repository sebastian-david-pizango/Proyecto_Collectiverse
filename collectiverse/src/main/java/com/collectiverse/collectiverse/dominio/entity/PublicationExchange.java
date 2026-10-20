package com.collectiverse.collectiverse.dominio.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "publication_exchange")
public class PublicationExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_publication_exchange")
    @SequenceGenerator(name = "sec_publication_exchange", sequenceName = "sec_publication_exchange", allocationSize = 1)
    @Column(name = "id_exchange")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_publication", nullable = false)
    private Publication publication;

    @Column(name = "requested_name", nullable = false, length = 100)
    private String requestedName;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

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
    public Publication getPublication() { return publication; }
    public void setPublication(Publication publication) { this.publication = publication; }
    public String getRequestedName() { return requestedName; }
    public void setRequestedName(String requestedName) { this.requestedName = requestedName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
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