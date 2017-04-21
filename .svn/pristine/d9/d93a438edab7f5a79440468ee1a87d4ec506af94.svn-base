/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.GuiaEvaluacion2_2_indicadoresFacadeLocal;
import entidad.GuiaEvaluacion2_2_indicadores;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class GuiaEvaluacion2_2_indicadoresRN implements GuiaEvaluacion2_2_indicadoresRNLocal {

      @EJB
    private GuiaEvaluacion2_2_indicadoresFacadeLocal guiaEvaluacion2_2_indicadoresFacadeLocal;
      
    @Override
    public void create(GuiaEvaluacion2_2_indicadores c) throws Exception {
        this.guiaEvaluacion2_2_indicadoresFacadeLocal.create(c);
    }

    @Override
    public void remove(GuiaEvaluacion2_2_indicadores c) throws Exception {
      this.guiaEvaluacion2_2_indicadoresFacadeLocal.remove(c);
    }

    @Override
    public void edit(GuiaEvaluacion2_2_indicadores c) throws Exception {
       this.guiaEvaluacion2_2_indicadoresFacadeLocal.edit(c);
    }

    @Override
    public List<GuiaEvaluacion2_2_indicadores> findAll() throws Exception {
        return(this.guiaEvaluacion2_2_indicadoresFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
