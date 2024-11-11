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
import interfaces.ICategoriaDAO;
import java.util.ArrayList;
import java.util.List;
import objetos.Categorias;
import org.bson.conversions.Bson;

/**
 *
 * @author Chris
 */
public class CategoriaDAO implements ICategoriaDAO {

    private final MongoCollection<Categorias> coleccionCategorias;

    public CategoriaDAO() {
        this.coleccionCategorias = ConexionBD.crearConexion().getCollection("categorias", Categorias.class);
    }

    @Override
    public boolean agregar(Categorias c) throws PersistenciaException {
        try {
            this.coleccionCategorias.insertOne(c);
            return true;
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar la categoria." + c.getId());
        }
    }

    @Override
    public boolean actualizar(Categorias c) throws PersistenciaException {
        try {
            Bson filtroID = Filters.eq("_id", c.getId());

            Bson actualizacionDatos = Updates.combine(
                    Updates.set("nombre", c.getNombre())
            );
            this.coleccionCategorias.updateOne(filtroID, actualizacionDatos);
            return true;
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo actualizar la categoria: " + c.getId());
        }
    }

    @Override
    public boolean eliminar(Categorias c) throws PersistenciaException {
        try {
            DeleteResult result = this.coleccionCategorias.deleteOne(Filters.eq("_id", c.getId()));
            return result.getDeletedCount() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Categorias consultar(Categorias c) throws PersistenciaException {
        try {
            Categorias result = (Categorias) this.coleccionCategorias.find(eq("_id", c.getId())).first();
            return result;
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo encontrar la categoria: " + c.getId());
        }
    }

    @Override
    public List<Categorias> consultarTodos() throws PersistenciaException {
        try {
            List<Categorias> categorias = new ArrayList<>();
            this.coleccionCategorias.find().into(categorias);
            return categorias;
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudieron encontrar las categorias.");
        }
    }

}
