/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.EspecialidadFacadeLocal;
import entidad.Especialidad;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cristian
 */
@Stateless
public class EspecialidadRN implements EspecialidadRNLocal {
 @EJB
 private EspecialidadFacadeLocal especialidadFacadeLocal;
    @Override
    public void create(Especialidad p) throws Exception {
      this.especialidadFacadeLocal.create(p);
    }

    @Override
    public void remove(Especialidad p) throws Exception {
this.especialidadFacadeLocal.remove(p);    }

    @Override
    public void edit(Especialidad p) throws Exception {
   this.especialidadFacadeLocal.edit(p);
    }

    @Override
    public List<Especialidad> findAll() throws Exception {
   return(this.especialidadFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Especialidad> findByProfesion(Long idProfesion) throws Exception {
        
        return especialidadFacadeLocal.findByProfesion(idProfesion);
       
    }

   
}
