/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.EvaluacionAspectosFacadeLocal;
import entidad.EvaluacionAspectos;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class EvaluacionAspectosRN implements EvaluacionAspectosRNLocal {

    @EJB
    private EvaluacionAspectosFacadeLocal evaluacionAspectosFacadeLocal;

    @Override
    public void create(EvaluacionAspectos p) throws Exception {
        this.evaluacionAspectosFacadeLocal.create(p);
    }

    @Override
    public void remove(EvaluacionAspectos p) throws Exception {
        this.evaluacionAspectosFacadeLocal.remove(p);
    }

    @Override
    public void edit(EvaluacionAspectos p) throws Exception {
        this.evaluacionAspectosFacadeLocal.edit(p);
    }

    @Override
    public List<EvaluacionAspectos> findAll() throws Exception {
       return(this.evaluacionAspectosFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
