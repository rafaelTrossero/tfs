/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Borrador;
import entidad.Proyecto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface BorradorFacadeLocal {

    void create(Borrador borrador);

    void edit(Borrador borrador);

    void remove(Borrador borrador);

    Borrador find(Object id);

    List<Borrador> findAll();

    List<Borrador> findRange(int[] range);

    int count();
    
    public Long findByProyecto (Proyecto proyecto) throws Exception;
    public Borrador findById (Long id) throws Exception;
}
