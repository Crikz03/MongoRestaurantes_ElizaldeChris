/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.PersistenciaException;
import java.util.List;
import objetos.Categorias;

/**
 *
 * @author Chris
 */
public interface ICategoriaDAO {

    public boolean agregar(Categorias c) throws PersistenciaException;

    public boolean actualizar(Categorias c) throws PersistenciaException;

    public boolean eliminar(Categorias c) throws PersistenciaException;

    public Categorias consultar(Categorias c) throws PersistenciaException;

    public List<Categorias> consultarTodos() throws PersistenciaException;
}
