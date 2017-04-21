/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.GuiaEvaluacion2_3_indicadoresFacadeLocal;
import entidad.GuiaEvaluacion2_3_indicadores;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class GuiaEvaluacion2_3_indicadoresRN implements GuiaEvaluacion2_3_indicadoresRNLocal {

      @EJB
    private GuiaEvaluacion2_3_indicadoresFacadeLocal guiaEvaluacion2_3_indicadoresFacadeLocal;
      
    @Override
    public void create(GuiaEvaluacion2_3_indicadores c) throws Exception {
        this.guiaEvaluacion2_3_indicadoresFacadeLocal.create(c);
    }

    @Override
    public void remove(GuiaEvaluacion2_3_indicadores c) throws Exception {
      this.guiaEvaluacion2_3_indicadoresFacadeLocal.remove(c);
    }

    @Override
    public void edit(GuiaEvaluacion2_3_indicadores c) throws Exception {
       this.guiaEvaluacion2_3_indicadoresFacadeLocal.edit(c);
    }

    @Override
    public List<GuiaEvaluacion2_3_indicadores> findAll() throws Exception {
        return(this.guiaEvaluacion2_3_indicadoresFacadeLocal.findAll());
    }
}
