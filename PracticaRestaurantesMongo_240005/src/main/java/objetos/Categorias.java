/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import org.bson.types.ObjectId;

/**
 *
 * @author Chris
 */
public class Categorias {

    private ObjectId id;
    private String nombre;
    private ObjectId IdRestaurante;

    public Categorias() {
    }

    public Categorias(ObjectId id) {
        this.id = id;
    }

    public Categorias(ObjectId id, String nombre, ObjectId IdRestaurante) {
        this.id = id;
        this.nombre = nombre;
        this.IdRestaurante = IdRestaurante;
    }

    public Categorias(String nombre, ObjectId IdRestaurante) {
        this.nombre = nombre;
        this.IdRestaurante = IdRestaurante;
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

    public ObjectId getIdRestaurante() {
        return IdRestaurante;
    }

    public void setIdRestaurante(ObjectId IdRestaurante) {
        this.IdRestaurante = IdRestaurante;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Categorias{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", IdRestaurante=").append(IdRestaurante);
        sb.append('}');
        return sb.toString();
    }

}
