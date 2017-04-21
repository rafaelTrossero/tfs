/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.CorreoElectronico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface CorreoElectronicoFacadeLocal {

    void create(CorreoElectronico correoElectronico);

    void edit(CorreoElectronico correoElectronico);

    void remove(CorreoElectronico correoElectronico);

    CorreoElectronico find(Object id);

    List<CorreoElectronico> findAll();

    List<CorreoElectronico> findRange(int[] range);

    int count();
    
}
