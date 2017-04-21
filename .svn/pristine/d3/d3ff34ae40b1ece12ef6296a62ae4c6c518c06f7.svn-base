/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.GuiaEvaluacion2_1FacadeLocal;
import entidad.GuiaEvaluacion2_1;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class GuiaEvaluacion2_1RN implements GuiaEvaluacion2_1RNLocal {
    
     @EJB
    private GuiaEvaluacion2_1FacadeLocal guiaEvaluacion2_1_FacadeLocal;

    @Override
    public void create(GuiaEvaluacion2_1 c) throws Exception {
        this.guiaEvaluacion2_1_FacadeLocal.create(c);
    }

    @Override
    public void remove(GuiaEvaluacion2_1 c) throws Exception {
               this.guiaEvaluacion2_1_FacadeLocal.remove(c);

    }

    @Override
    public void edit(GuiaEvaluacion2_1 c) throws Exception {
               this.guiaEvaluacion2_1_FacadeLocal.edit(c);

    }

    @Override
    public List<GuiaEvaluacion2_1> findAll() throws Exception {
       return (this.guiaEvaluacion2_1_FacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
