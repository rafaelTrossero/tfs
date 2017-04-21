/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.Doc_Comisiones;
import entidad.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface Doc_ComisionesRNbeanLocal {
     void create(Doc_Comisiones p) throws Exception;

    void remove(Doc_Comisiones p) throws Exception;

    void edit(Doc_Comisiones p) throws Exception;

    List<Doc_Comisiones> findAll() throws Exception;
}
