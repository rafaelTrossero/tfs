/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.DirectorFacadeLocal;
import entidad.Director;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cristian
 */
@Stateless
public class DirectorRN implements DirectorRNLocal {
 @EJB
 private DirectorFacadeLocal directorFacadeLocal;
    @Override
    public void create(Director p) throws Exception {
   this.directorFacadeLocal.create(p);
    }

    @Override
    public void remove(Director p) throws Exception {
   this.directorFacadeLocal.remove(p);
    }

    @Override
    public void edit(Director p) throws Exception {
        this.directorFacadeLocal.edit(p);
       }

    @Override
    public List<Director> findAll() throws Exception {
     return(this.directorFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
