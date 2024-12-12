package ups.edu.ejb.model;

import java.io.Serializable;

public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer cantidadDisponible;

    // Constructor por defecto
    public Producto() {}

    // Constructor con parámetros
    public Producto(Long id, String nombre, String descripcion, Double precio, Integer cantidadDisponible) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
}
