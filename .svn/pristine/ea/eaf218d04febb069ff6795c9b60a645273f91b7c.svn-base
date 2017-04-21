/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.ProyectoBorradorEvaluacionObservacionesFacadeLocal;
import entidad.ProyectoBorradorEvaluacionObservaciones;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jorge
 */
@Stateless
public class ProyectoBorradorEvaluacionObservacionesRN implements ProyectoBorradorEvaluacionObservacionesRNLocar {

    @EJB
    private ProyectoBorradorEvaluacionObservacionesFacadeLocal proy_brr_evaluacion_obsFacadeLocal;
    
    @Override
    public void create(ProyectoBorradorEvaluacionObservaciones borradorEvaluacionObs) throws Exception {
        this.proy_brr_evaluacion_obsFacadeLocal.create(borradorEvaluacionObs);
    }

    @Override
    public void remove(ProyectoBorradorEvaluacionObservaciones borradorEvaluacionObs) throws Exception {
        this.proy_brr_evaluacion_obsFacadeLocal.remove(borradorEvaluacionObs);
    }

    @Override
    public void edit(ProyectoBorradorEvaluacionObservaciones borradorEvaluacionObs) throws Exception {
       this.proy_brr_evaluacion_obsFacadeLocal.edit(borradorEvaluacionObs);
        }

    @Override
    public List<ProyectoBorradorEvaluacionObservaciones> findAll() throws Exception {
        return(this.proy_brr_evaluacion_obsFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
