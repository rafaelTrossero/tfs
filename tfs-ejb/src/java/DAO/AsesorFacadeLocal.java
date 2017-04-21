/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Asesor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface AsesorFacadeLocal {

    void create(Asesor asesor);

    void edit(Asesor asesor);

    void remove(Asesor asesor);

    Asesor find(Object id);

    List<Asesor> findAll();

    List<Asesor> findRange(int[] range);

    int count();
    
}
