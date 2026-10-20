package com.collectiverse.collectiverse.dominio.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_categoria")
    @SequenceGenerator(
        name = "sec_categoria",
        sequenceName = "sec_categoria",
        allocationSize = 1
    )
    @Column(name = "id_categoria")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    // Relación: Una categoría tiene muchas colecciones
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Coleccion> colecciones = new ArrayList<>();

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Coleccion> getColecciones() {
        return colecciones;
    }

    public void setColecciones(List<Coleccion> colecciones) {
        this.colecciones = colecciones;
    }
}