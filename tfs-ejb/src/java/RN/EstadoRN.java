/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.EstadoFacadeLocal;
import entidad.Estado;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cristian
 */
@Stateless
public class EstadoRN implements EstadoRNLocal {
@EJB
private EstadoFacadeLocal estadoFacadeLocal;
    @Override
    public void create(Estado p) throws Exception {
   this.estadoFacadeLocal.create(p);
    }

    @Override
    public void remove(Estado p) throws Exception {
this.estadoFacadeLocal.remove(p);    }

    @Override
    public void edit(Estado p) throws Exception {
this.estadoFacadeLocal.edit(p);    }

    @Override
    public List<Estado> findAll() throws Exception {
return(this.estadoFacadeLocal.findAll());    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
