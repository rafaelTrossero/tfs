/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.CorreoElectronico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface CorreoElectronicoRNLocal {
    
    
     void create(CorreoElectronico c) throws Exception;

    void remove(CorreoElectronico c) throws Exception;

    void edit(CorreoElectronico c) throws Exception;

    List<CorreoElectronico> findAll() throws Exception;
}
