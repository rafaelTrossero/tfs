/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.AceptacionObservacionesFacadeLocal;
import entidad.AceptacionObservaciones;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Trossero
 */
@Stateless
public class AceptacionObservacionesRN implements AceptacionObservacionesRNLocal {
    @EJB
    private AceptacionObservacionesFacadeLocal aceptacion_obsFacadeLocal;
    
    @Override
    public void create(AceptacionObservaciones a) throws Exception {
        this.aceptacion_obsFacadeLocal.create(a);
    }

    @Override
    public void remove(AceptacionObservaciones a) throws Exception {
        this.aceptacion_obsFacadeLocal.remove(a);
    }

    @Override
    public void edit(AceptacionObservaciones a) throws Exception {
        this.aceptacion_obsFacadeLocal.edit(a);
    }

    @Override
    public List<AceptacionObservaciones> findAll() throws Exception {
       return(this.aceptacion_obsFacadeLocal.findAll());
    }

    
}
