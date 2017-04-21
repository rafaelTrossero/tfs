/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.FechasExamenFacadeLocal;
import entidad.FechasExamen;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class FechasExamenRN implements FechasExamenRNLocal {

    @EJB
    private FechasExamenFacadeLocal fechasExamenFacadeLocal;
    
    @Override
    public void create(FechasExamen p) throws Exception {
       fechasExamenFacadeLocal.create(p);
    }

    @Override
    public void remove(FechasExamen p) throws Exception {
      fechasExamenFacadeLocal.remove(p);
    }

    @Override
    public void edit(FechasExamen p) throws Exception {
       fechasExamenFacadeLocal.edit(p);
    }

    @Override
    public List<FechasExamen> findAll() throws Exception {
        return(fechasExamenFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
