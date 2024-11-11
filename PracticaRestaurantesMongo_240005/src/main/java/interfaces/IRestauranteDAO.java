/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.PersistenciaException;
import java.util.List;
import objetos.Restaurantes;
import org.bson.types.ObjectId;

/**
 *
 * @author Chris
 */
public interface IRestauranteDAO {

    public boolean agregar(Restaurantes r) throws PersistenciaException;

    public boolean actualizar(Restaurantes r) throws PersistenciaException;

    public boolean eliminar(Restaurantes r) throws PersistenciaException;

    public Restaurantes consultar(Restaurantes r) throws PersistenciaException;

    public List<Restaurantes> consultarTodos() throws PersistenciaException;

    public List<Restaurantes> obtenerRestaurantesConRatingMayorA(int estrellas) throws PersistenciaException;

    public List<Restaurantes> obtenerRestaurantesConCategoria(String categoria) throws PersistenciaException;

    public List<Restaurantes> obtenerRestaurantesPorNombre(String palabraClave) throws PersistenciaException;

    public void agregarCategoriaARestaurante(String nombreRestaurante, String nuevaCategoria) throws PersistenciaException;

    public void eliminarRestaurantePorId(ObjectId id) throws PersistenciaException;

    public void eliminarRestaurantesConRatingMenorOIgualA(int estrellas) throws PersistenciaException;
}
