/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.Asesor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface AsesorRNLocal {
   
    void create(Asesor a) throws Exception;

    void remove(Asesor a) throws Exception;

    void edit(Asesor a) throws Exception;

    List<Asesor> findAll() throws Exception;   
}
