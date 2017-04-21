/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Codirector;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface CodirectorFacadeLocal {

    void create(Codirector codirector);

    void edit(Codirector codirector);

    void remove(Codirector codirector);

    Codirector find(Object id);

    List<Codirector> findAll();

    List<Codirector> findRange(int[] range);

    int count();
    
}
