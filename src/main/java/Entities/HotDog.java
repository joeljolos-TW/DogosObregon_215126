/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 *
 * @author Laboratorios
 */
@Entity

@NamedQueries({
        @NamedQuery(name = "HotDog.findAll"
                , query = "SELECT h FROM HotDog h"),
        @NamedQuery(name = "HotDog.findByPrices"
                , query = "SELECT h FROM HotDog h ORDER BY precio ASC"),
        @NamedQuery(name = "HotDog.findByPrice"
                , query = "SELECT h FROM HotDog h WHERE h.precio >= :precio ORDER BY precio ASC"),
        @NamedQuery(name = "HotDog.findByNameASC"
                , query = "SELECT h FROM HotDog h ORDER BY nombre ASC"),
        @NamedQuery(name = "HotDog.findByNameDESC"
                , query = "SELECT h FROM HotDog h ORDER BY nombre DESC")
})
public class HotDog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="nombre")
    private String nombre;
    
    @Column(name="precio")
    private BigDecimal precio;
    
    @Column(name="iva")
    private BigDecimal iva;
    
    @OneToMany(mappedBy = "hotdog")
    private Set<Pedido_Hotdogs> detalles;

    public HotDog() {
    }

    public HotDog(String nombre, BigDecimal precio) {

        this.nombre = nombre;
        this.precio = precio;
        this.iva = precio.multiply(new BigDecimal(0.16));
    }

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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public Set<Pedido_Hotdogs> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<Pedido_Hotdogs> detalles) {
        this.detalles = detalles;
    }
    
    
}
