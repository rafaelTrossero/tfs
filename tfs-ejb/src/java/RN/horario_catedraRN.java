/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.Horario_catedraFacadeLocal;
import entidad.Catedra;
import entidad.Horario_catedra;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cris
 */
@Stateless
public class horario_catedraRN implements horario_catedraRNLocal {
@EJB
    private Horario_catedraFacadeLocal horario_catedraFacadeLocal;
    @Override
    public void create(Horario_catedra c) throws Exception {
      this.horario_catedraFacadeLocal.create(c);
    
    }

    @Override
    public void remove(Horario_catedra c) throws Exception {
       this.horario_catedraFacadeLocal.remove(c);
    
    }

    @Override
    public void edit(Horario_catedra c) throws Exception {
    this.horario_catedraFacadeLocal.edit(c);
    
    }

    @Override
    public List<Horario_catedra> findAll() throws Exception {
return (this.horario_catedraFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Horario_catedra buscarHorario(Catedra catedra) throws Exception {

    return horario_catedraFacadeLocal.buscar_horario(catedra);
    }
}
