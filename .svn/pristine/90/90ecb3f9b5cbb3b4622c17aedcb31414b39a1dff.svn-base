/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.DefensaFinalObservacionesFacadeLocal;
import entidad.DefensaFinalObservaciones;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Trossero
 */
@Stateless
public class DefensaFinalObservacionesRN implements DefensaFinalObservacionesRNLocal {
    @EJB
    private DefensaFinalObservacionesFacadeLocal def_final_obsFacadeLocal;
    
    @Override
    public void create(DefensaFinalObservaciones d) throws Exception {
        this.def_final_obsFacadeLocal.create(d);
    }

    @Override
    public void remove(DefensaFinalObservaciones d) throws Exception {
        this.def_final_obsFacadeLocal.remove(d);
    }

    @Override
    public void edit(DefensaFinalObservaciones d) throws Exception {
        this.def_final_obsFacadeLocal.edit(d);
    }

    @Override
    public List<DefensaFinalObservaciones> findAll() throws Exception {
        return (this.def_final_obsFacadeLocal.findAll());
    }

    
}
