/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.Barrio;
import entidad.Usuario;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bcasas
 */
@Local
public interface BarrioRNLocal {
    
     public void create(Barrio b,Usuario usuario, String pantalla) throws Exception;
    public void edit(Barrio b,Usuario usuario, String pantalla) throws Exception;
    public void remove(Barrio b, Boolean bEstado,Usuario usuario, String pantalla) throws Exception;
    public void habilitar(Barrio b, Boolean bEstado,Usuario usuario, String pantalla) throws Exception;
    public List<Barrio> findAll() throws Exception;
    public List<Barrio> findByLocalidad(Long idLocalidad) throws Exception;
    public List<Barrio> findByLocalidadBorrado(Long idLocalidad, Boolean estado) throws Exception;
    public List<Barrio> findByBorrado(Boolean estado) throws Exception;
    public List<Barrio> findLike(String cadena, Boolean conBorrado) throws Exception;
    
}
