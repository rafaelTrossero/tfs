/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.OperacionFacadeLocal;
import entidad.Operacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cristian
 */
@Stateless
public class OperacionRN implements OperacionRNLocal {

    @EJB
    private OperacionFacadeLocal operacionFacadeLocal;

    @Override
    public void create(Operacion p) throws Exception {
        this.operacionFacadeLocal.create(p);
    }

    @Override
    public void remove(Operacion p) throws Exception {
        this.operacionFacadeLocal.remove(p);
    }

    @Override
    public void edit(Operacion p) throws Exception {
        this.operacionFacadeLocal.edit(p);
    }

    @Override
    public List<Operacion> findAll() throws Exception {
        return (this.operacionFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
