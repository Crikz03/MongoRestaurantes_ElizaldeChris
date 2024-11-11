/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import datos.RestauranteDAO;
import excepciones.PersistenciaException;
import interfaces.IRestauranteDAO;
import objetos.Restaurantes;
import org.bson.types.ObjectId;

/**
 *
 * @author Chris
 */
public class agrega_actualiza {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IRestauranteDAO restauranteDAO = new RestauranteDAO();
//        try {
//            restauranteDAO.agregarCategoriaARestaurante("sushi itto", "Japonesa");
//            System.out.println("\nAgregando categoría 'Japonesa' a 'sushilito'");
//        } catch (PersistenciaException ex) {
//            System.out.println("No se ha podido agregar la categoria a dicho restaurante.");
//        }

        try {
            Restaurantes restaurante = new Restaurantes(new ObjectId("6620de1821cbe3efa9f37676"));
            Restaurantes restauranteActualizado = restauranteDAO.consultar(restaurante);

            restauranteActualizado.setNombre("sushi itto");
            restauranteActualizado.setRating(5);

            // Actualiza el restaurante en la base de datos
            System.out.println("\nActualizando 'sushilito' a 'sushi itto' con rating 5:");
            boolean actualizado = restauranteDAO.actualizar(restauranteActualizado);
            if (actualizado) {
                System.out.println("El restaurante ha sido actualizado correctamente.");
            } else {
                System.out.println("No se pudo actualizar el restaurante.");
            }
        } catch (PersistenciaException e) {
            System.out.println("No se ha podido actualizar el restaurante: " + e);
        }
    }

}
