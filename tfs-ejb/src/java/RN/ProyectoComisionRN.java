/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.ProyectoComisionFacadeLocal;
import entidad.ProyectoComision;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jorge
 */
@Stateless
public class ProyectoComisionRN implements ProyectoComisionRNLocal {

    @EJB
    private ProyectoComisionFacadeLocal proy_comisionFacadeLocal;
    
    @Override
    public void create(ProyectoComision comision) throws Exception {
        this.proy_comisionFacadeLocal.create(comision);
      }

    @Override
    public void remove(ProyectoComision comision) throws Exception {
        this.proy_comisionFacadeLocal.remove(comision);
      }

    @Override
    public void edit(ProyectoComision comision) throws Exception {
        this.proy_comisionFacadeLocal.edit(comision);
       }

    @Override
    public List<ProyectoComision> findAll() throws Exception {
        return(this.proy_comisionFacadeLocal.findAll());
        }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
