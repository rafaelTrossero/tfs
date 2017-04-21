/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.ProyectoOperacionFacadeLocal;
import entidad.ProyectoOperacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jorge
 */
@Stateless
public class ProyectoOperacionRN implements ProyectoOperacionRNLocal {

    @EJB
    private ProyectoOperacionFacadeLocal proy_operacionFacadeLocal;
    
    @Override
    public void create(ProyectoOperacion operacion) throws Exception {
        this.proy_operacionFacadeLocal.create(operacion);
      }

    @Override
    public void remove(ProyectoOperacion operacion) throws Exception {
        this.proy_operacionFacadeLocal.remove(operacion);
     }

    @Override
    public void edit(ProyectoOperacion operacion) throws Exception {
        this.proy_operacionFacadeLocal.edit(operacion);
     }

    @Override
    public List<ProyectoOperacion> findAll() throws Exception {
        return(this.proy_operacionFacadeLocal.findAll());
          }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
