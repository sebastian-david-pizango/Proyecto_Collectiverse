package com.collectiverse.collectiverse.dominio.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publication")
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_publication")
    @SequenceGenerator(name = "sec_publication", sequenceName = "sec_publication", allocationSize = 1)
    @Column(name = "id_publication")
    private Integer id;

    @Column(name = "id_user", nullable = false)
    private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @Column(name = "state", nullable = false, length = 20)
    private String state;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PublicationExchange> exchanges = new ArrayList<>();

    @PrePersist
    protected void prePersist() {
        if (date == null) date = LocalDateTime.now();
    }

    public void addExchange(String requestedName, String description, Integer quantity) {
        PublicationExchange item = new PublicationExchange();
        item.setPublication(this);
        item.setRequestedName(requestedName);
        item.setDescription(description);
        item.setQuantity(quantity);
        exchanges.add(item);
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
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
    public List<PublicationExchange> getExchanges() { return exchanges; }
    public void setExchanges(List<PublicationExchange> exchanges) { this.exchanges = exchanges; }
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