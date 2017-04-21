/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Provincia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan Pablo
 */
@Local
public interface ProvinciaFacadeLocal {

    void create(Provincia provincia);

    void edit(Provincia provincia);

    void remove(Provincia provincia);

    Provincia find(Object id);

    List<Provincia> findAll();

    List<Provincia> findRange(int[] range);

    int count();

    public void updateBorrado(Boolean borrado, Long id) throws Exception;

    public void updateHabilitado(Boolean habilitado, Long id) throws Exception;

    public Boolean bFindByCodigoProvincia(Provincia p, int op) throws Exception;

    public Boolean bFindByNombreProvincia(Provincia p, int op) throws Exception;

    public List<Provincia> findByPais(Long idPais) throws Exception;

    public List<Provincia> findByPaisBorrado(Long idPais, Boolean borrado) throws Exception;

    public List<Provincia> findByBorrado(Boolean borrado) throws Exception;

    public List<Provincia> findLike(String cadena, Boolean conBorrados) throws Exception;

    public Provincia findByIdNombreProvincia(Long id, String nombre) throws Exception;
}
