package com.collectiverse.collectiverse.dominio.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_image")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_product_image")
    @SequenceGenerator(name = "sec_product_image", sequenceName = "sec_product_image", allocationSize = 1)
    @Column(name = "id_image")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;

    @Column(name = "url", nullable = false, length = 255)
    private String url;

    @Column(name = "image_order")
    private Integer order;

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
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public Integer getOrder() { return order; }
    public void setOrder(Integer order) { this.order = order; }
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