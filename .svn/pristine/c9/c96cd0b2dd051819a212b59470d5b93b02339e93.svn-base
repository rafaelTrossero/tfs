/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.DedicacionFacadeLocal;
import entidad.Dedicacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Trossero
 */
@Stateless
public class DedicacionRN implements DedicacionRNLocal {

    @EJB
    private DedicacionFacadeLocal dedicacionesFacadeLocal;
    
    @Override
    public void create(Dedicacion d) throws Exception {
        
        this.dedicacionesFacadeLocal.create(d);
        
    }

    @Override
    public void remove(Dedicacion d) throws Exception {
        this.dedicacionesFacadeLocal.remove(d);
    }

    @Override
    public void edit(Dedicacion d) throws Exception {
        this.dedicacionesFacadeLocal.edit(d);
    }

    @Override
    public List<Dedicacion> findAll() throws Exception {
        return(this.dedicacionesFacadeLocal.findAll());
        
    }

    
    
}
