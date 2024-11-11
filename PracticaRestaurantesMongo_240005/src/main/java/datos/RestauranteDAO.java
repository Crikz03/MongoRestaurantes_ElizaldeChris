/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import conexion.ConexionBD;
import excepciones.PersistenciaException;
import interfaces.IRestauranteDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import objetos.Restaurantes;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Chris
 */
public class RestauranteDAO implements IRestauranteDAO {

    private final MongoCollection<Restaurantes> coleccionRestaurantes;

    public RestauranteDAO() {
        this.coleccionRestaurantes = ConexionBD.crearConexion().getCollection("restaurantes", Restaurantes.class);
    }

    @Override
    public boolean agregar(Restaurantes r) throws PersistenciaException {
        try {
            this.coleccionRestaurantes.insertOne(r);
            return true;
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar el restaurante." + r.getId());
        }
    }

    @Override
    public boolean actualizar(Restaurantes r) throws PersistenciaException {
        try {
            Bson filtroID = Filters.eq("_id", r.getId());

            Bson actualizacionDatos = Updates.combine(
                    Updates.set("nombre", r.getNombre()),
                    Updates.set("rating", r.getRating()),
                    Updates.set("categorias", r.getCategorias()),
                    Updates.set("fechaInauguracion", r.getFechaInauguracion())
            );
            this.coleccionRestaurantes.updateOne(filtroID, actualizacionDatos);
            return true;
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo actualizar el restaurante: " + r.getId());
        }
    }

    @Override
    public boolean eliminar(Restaurantes r) throws PersistenciaException {
        try {
            DeleteResult result = this.coleccionRestaurantes.deleteOne(Filters.eq("_id", r.getId()));
            return result.getDeletedCount() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Restaurantes consultar(Restaurantes r) throws PersistenciaException {
        try {
            Restaurantes result = (Restaurantes) this.coleccionRestaurantes.find(eq("_id", r.getId())).first();
            return result;
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo encontrar el restaurante: " + r.getId());
        }
    }

    @Override
    public List<Restaurantes> consultarTodos() throws PersistenciaException {
        try {
            List<Restaurantes> restaurantes = new ArrayList<>();
            this.coleccionRestaurantes.find().into(restaurantes);
            return restaurantes;
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudieron encontrar los restaurantes.");
        }
    }

    @Override
    public List<Restaurantes> obtenerRestaurantesConRatingMayorA(int estrellas) throws PersistenciaException {
        try {
            List<Restaurantes> restaurantes = new ArrayList<>();
            this.coleccionRestaurantes.find(Filters.gt("rating", estrellas)).into(restaurantes);
            return restaurantes;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudieron encontrar los restaurantes con las estrellas: " + estrellas);
        }

    }

    @Override
    public List<Restaurantes> obtenerRestaurantesConCategoria(String categoria) throws PersistenciaException {
        try {
            List<Restaurantes> restaurantes = new ArrayList<>();
            this.coleccionRestaurantes.find(Filters.eq("categorias", categoria)).into(restaurantes);
            return restaurantes;
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudieron encontrar los restaurantes con la categoria: " + categoria);
        }
    }

    @Override
    public List<Restaurantes> obtenerRestaurantesPorNombre(String palabraClave) throws PersistenciaException {
        try {
            List<Restaurantes> restaurantes = new ArrayList<>();
            this.coleccionRestaurantes.find(Filters.regex("nombre", palabraClave, "i")).into(restaurantes);
            return restaurantes;
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudieron encontrar los restaurantes con la palabra: " + palabraClave);
        }

    }

    @Override
    public void agregarCategoriaARestaurante(String nombreRestaurante, String nuevaCategoria) throws PersistenciaException {
        Bson filtro = Filters.eq("nombre", nombreRestaurante);
        Restaurantes restaurante = coleccionRestaurantes.find(filtro).first();

        if (restaurante != null) {
            List<String> categorias = restaurante.getCategorias();
            categorias.add(nuevaCategoria);
            coleccionRestaurantes.updateOne(filtro, Updates.set("categorias", categorias));
        } else {
            Restaurantes nuevoRestaurante = new Restaurantes(nombreRestaurante, 3, new Date());
            nuevoRestaurante.setCategorias(Arrays.asList(nuevaCategoria));
            coleccionRestaurantes.insertOne(nuevoRestaurante);
        }
    }

    @Override
    public void eliminarRestaurantePorId(ObjectId id) throws PersistenciaException {
        try {
            this.coleccionRestaurantes.deleteOne(Filters.eq("_id", id));
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo eliminar el restaurante con id: " + id);
        }

    }

    @Override
    public void eliminarRestaurantesConRatingMenorOIgualA(int estrellas) throws PersistenciaException {
        try {
            this.coleccionRestaurantes.deleteMany(Filters.lte("rating", estrellas));
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo eliminar los restaurantes con las estrellas: " + estrellas);
        }

    }

}
