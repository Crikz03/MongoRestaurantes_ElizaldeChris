/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Chris
 */
public class Restaurantes {

    private ObjectId id;
    private String nombre;
    private double rating;
    private Date fechaInauguracion;
    private List<String> categorias;

    public Restaurantes() {
    }

    public Restaurantes(ObjectId id) {
        this.id = id;
    }

    public Restaurantes(ObjectId id, String nombre, double rating, Date fechaInauguracion, List<String> categorias) {
        this.id = id;
        this.nombre = nombre;
        this.rating = rating;
        this.fechaInauguracion = fechaInauguracion;
        this.categorias = categorias;
    }

    public Restaurantes(String nombre, double rating, Date fechaInauguracion) {
        this.nombre = nombre;
        this.rating = rating;
        this.fechaInauguracion = fechaInauguracion;
    }

    public Restaurantes(String nombre, double rating, Date fechaInauguracion, List<String> categorias) {
        this.nombre = nombre;
        this.rating = rating;
        this.fechaInauguracion = fechaInauguracion;
        this.categorias = categorias;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Date getFechaInauguracion() {
        return fechaInauguracion;
    }

    public void setFechaInauguracion(Date fechaInauguracion) {
        this.fechaInauguracion = fechaInauguracion;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Restaurantes{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", rating=").append(rating);
        sb.append(", fechaInauguracion=").append(fechaInauguracion);
        sb.append(", categorias=").append(categorias);
        sb.append('}');
        return sb.toString();
    }

}
