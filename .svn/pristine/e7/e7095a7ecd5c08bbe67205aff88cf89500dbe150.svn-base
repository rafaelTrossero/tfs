/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.Horario_semanal_catedraFacadeLocal;
import entidad.Horario_catedra;
import entidad.Horario_semanal_catedra;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cris
 */
@Stateless
public class Horario_catedra_semanalRN implements Horario_catedra_semanalRNLocal {
@EJB
    private Horario_semanal_catedraFacadeLocal horario_semanal_catedraFacadeLocal;
    @Override
    public void create(Horario_semanal_catedra c) throws Exception {
   this.horario_semanal_catedraFacadeLocal.create(c);
    
    }

    @Override
    public void remove(Horario_semanal_catedra c) throws Exception {

    this.horario_semanal_catedraFacadeLocal.remove(c);
    }

    @Override
    public void edit(Horario_semanal_catedra c) throws Exception {
  this.horario_semanal_catedraFacadeLocal.edit(c);
    
    }

    @Override
    public List<Horario_semanal_catedra> findAll() throws Exception {
             return (this.horario_semanal_catedraFacadeLocal.findAll());
    
    }

    @Override
    public List<Horario_semanal_catedra> buscarHorario(Horario_catedra hora_catedra) throws Exception {
    return (this.horario_semanal_catedraFacadeLocal.findHorarios(hora_catedra));
    }

    
}
