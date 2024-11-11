/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import datos.RestauranteDAO;
import excepciones.PersistenciaException;
import interfaces.IRestauranteDAO;
import java.util.List;
import objetos.Restaurantes;

/**
 *
 * @author Chris
 */
public class Consultas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            IRestauranteDAO restauranteDAO = new RestauranteDAO();

            // Consulta los restaurantes con más de 4 estrellas
            List<Restaurantes> restaurantesRatingAlto = restauranteDAO.obtenerRestaurantesConRatingMayorA(4);
            System.out.println("");
            System.out.println("Restaurantes con más de 4 estrellas:");
            for (Restaurantes r : restaurantesRatingAlto) {
                System.out.println("-" + r.getNombre() + " : Rating = " + r.getRating());
            }

            // Consulta los restaurantes con la categoría "pizza"
            System.out.println("\nRestaurantes con la categoría 'pizza':");
            List<Restaurantes> restaurantesPizza = restauranteDAO.obtenerRestaurantesConCategoria("pizza");
            for (Restaurantes r : restaurantesPizza) {
                System.out.println("-" + r.getNombre());
            }

            // Consulta los restaurantes que incluyan la palabra "sushi" en su nombre
            System.out.println("\nRestaurantes con 'sushi' en su nombre:");
            List<Restaurantes> restaurantesSushi = restauranteDAO.obtenerRestaurantesPorNombre("sushi");
            for (Restaurantes r : restaurantesSushi) {
                System.out.println("-" + r.getNombre());
            }
        } catch (PersistenciaException ex) {
            System.out.println("No se han podido encontrar los restaurantes con los filtros ingresados.");
        }
    }

}
