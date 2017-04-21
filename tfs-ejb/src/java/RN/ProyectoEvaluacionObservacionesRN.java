/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.ProyectoEvaluacionObservacionesFacadeLocal;
import entidad.ProyectoEvaluacionObservaciones;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jorge
 */
@Stateless
public class ProyectoEvaluacionObservacionesRN implements ProyectoEvaluacionObservacionesRNLocal {

    @EJB
    private ProyectoEvaluacionObservacionesFacadeLocal proy_evaluacion_obsFacadeLocal;
    @Override
    public void create(ProyectoEvaluacionObservaciones evaluacion) throws Exception {
        this.proy_evaluacion_obsFacadeLocal.create(evaluacion);
    }

    @Override
    public void remove(ProyectoEvaluacionObservaciones evaluacion) throws Exception {
        this.proy_evaluacion_obsFacadeLocal.remove(evaluacion);
     }

    @Override
    public void edit(ProyectoEvaluacionObservaciones evaluacion) throws Exception {
        this.proy_evaluacion_obsFacadeLocal.edit(evaluacion);
     }

    @Override
    public List<ProyectoEvaluacionObservaciones> findAll() throws Exception {
        return(this.proy_evaluacion_obsFacadeLocal.findAll());
     }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
