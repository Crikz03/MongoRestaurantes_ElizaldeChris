/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import datos.RestauranteDAO;
import excepciones.PersistenciaException;
import interfaces.IRestauranteDAO;
import org.bson.types.ObjectId;

/**
 *
 * @author Chris
 */
public class Eliminar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IRestauranteDAO restauranteDAO = new RestauranteDAO();
        try {
            ObjectId idAEliminar = new ObjectId("673195230bd6e633d53e971f");
            restauranteDAO.eliminarRestaurantePorId(idAEliminar);
        } catch (PersistenciaException e) {
            System.out.println("No se pudo eliminar el restaurante");
        }

        try {
            // Elimina restaurantes con rating de 3 o menos
            restauranteDAO.eliminarRestaurantesConRatingMenorOIgualA(3);
        } catch (PersistenciaException e) {
            System.out.println("No se pudo eliminar los restaurantes");
        }
    }

}
