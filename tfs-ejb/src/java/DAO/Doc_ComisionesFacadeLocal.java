/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Doc_Comisiones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface Doc_ComisionesFacadeLocal {

    void create(Doc_Comisiones doc_Comisiones);

    void edit(Doc_Comisiones doc_Comisiones);

    void remove(Doc_Comisiones doc_Comisiones);

    Doc_Comisiones find(Object id);

    List<Doc_Comisiones> findAll();

    List<Doc_Comisiones> findRange(int[] range);

    int count();
    
}
