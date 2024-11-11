/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package pruebas;

import datos.CategoriaDAO;
import datos.RestauranteDAO;
import excepciones.PersistenciaException;
import interfaces.IRestauranteDAO;
import java.util.Arrays;
import java.util.Date;
import objetos.Categorias;
import objetos.Restaurantes;

/**
 *
 * @author Chris
 */
public class Inserts {

    public static void main(String[] args) {
        IRestauranteDAO restauranteDAO = new RestauranteDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();

        // Insertar 3 restaurantes
        Restaurantes restaurante = new Restaurantes("Restaurante Gourmet", 5, new Date(), Arrays.asList("Italiana", "Postres", "Vegetariana"));
        Restaurantes restaurante2 = new Restaurantes("Donpapu", 4.3, new Date(), Arrays.asList("Tacos", "Sincronizadas", "Asada"));
        Restaurantes restaurante3 = new Restaurantes("Los Agrietados", 4.0, new Date(), Arrays.asList("Quesadillas", "Molletes"));
        try {
            // Agregar los restaurantes a la base de datos
            restauranteDAO.agregar(restaurante);
            restauranteDAO.agregar(restaurante2);
            restauranteDAO.agregar(restaurante3);

//            Categorias categoria1 = new Categorias("Italiana", restaurante.getId());
//            Categorias categoria2 = new Categorias("Postres", restaurante.getId());
//            Categorias categoria3 = new Categorias("Vegetariana", restaurante.getId());
//
//            Categorias categoria4 = new Categorias("Tacos", restaurante2.getId());
//            Categorias categoria5 = new Categorias("Sincronizadas", restaurante2.getId());
//            Categorias categoria6 = new Categorias("Asada", restaurante2.getId());
//
//            Categorias categoria7 = new Categorias("Quesadillas", restaurante3.getId());
//            Categorias categoria8 = new Categorias("Molletes", restaurante3.getId());
//
//            categoriaDAO.agregar(categoria1);
//            categoriaDAO.agregar(categoria2);
//            categoriaDAO.agregar(categoria3);
//            categoriaDAO.agregar(categoria4);
//            categoriaDAO.agregar(categoria5);
//            categoriaDAO.agregar(categoria6);
//            categoriaDAO.agregar(categoria7);
//            categoriaDAO.agregar(categoria8);
            System.out.println("Restaurantes agregados correctamente.");
        } catch (PersistenciaException e) {
            System.err.println("Error al agregar restaurantes o categorías: " + e.getMessage());
        }
    }

}
