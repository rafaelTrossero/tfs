/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.GuiaEvaluacion2_1_indicadoresFacadeLocal;
import entidad.GuiaEvaluacion2_1_indicadores;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class GuiaEvaluacion2_1_indicadoresRN implements GuiaEvaluacion2_1_indicadoresRNLocal {

     @EJB
    private GuiaEvaluacion2_1_indicadoresFacadeLocal guiaEvaluacion2_1_indicadoresFacadeLocal;
    
    @Override
    public void create(GuiaEvaluacion2_1_indicadores c) throws Exception {
       this.guiaEvaluacion2_1_indicadoresFacadeLocal.create(c);
    }

    @Override
    public void remove(GuiaEvaluacion2_1_indicadores c) throws Exception {
       this.guiaEvaluacion2_1_indicadoresFacadeLocal.remove(c);
    }

    @Override
    public void edit(GuiaEvaluacion2_1_indicadores c) throws Exception {
       this.guiaEvaluacion2_1_indicadoresFacadeLocal.edit(c);
    }

    @Override
    public List<GuiaEvaluacion2_1_indicadores> findAll() throws Exception {
        return(this.guiaEvaluacion2_1_indicadoresFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
