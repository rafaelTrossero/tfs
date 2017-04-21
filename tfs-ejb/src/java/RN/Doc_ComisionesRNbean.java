/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.Doc_ComisionesFacadeLocal;
import entidad.Doc_Comisiones;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cristian
 */
@Stateless
public class Doc_ComisionesRNbean implements Doc_ComisionesRNbeanLocal {
@EJB
 private Doc_ComisionesFacadeLocal doc_ComisionesFacadeLocal;
    @Override
    public void create(Doc_Comisiones p) throws Exception {
      this.doc_ComisionesFacadeLocal.create(p);
    }

    @Override
    public void remove(Doc_Comisiones p) throws Exception {
   this.doc_ComisionesFacadeLocal.remove(p);
    }

    @Override
    public void edit(Doc_Comisiones p) throws Exception {
    this.doc_ComisionesFacadeLocal.edit(p);
    }

    @Override
    public List<Doc_Comisiones> findAll() throws Exception {
      return(this.doc_ComisionesFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
