/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.AsesorFacadeLocal;
import entidad.Asesor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Trossero
 */
@Stateless
public class AsesorRN implements AsesorRNLocal {

    @EJB
    private AsesorFacadeLocal asesorFacadeLocal;
    @Override
    public void create(Asesor a) throws Exception {
        this.asesorFacadeLocal.create(a);
    }

    @Override
    public void remove(Asesor a) throws Exception {
        this.asesorFacadeLocal.remove(a);
    }

    @Override
    public void edit(Asesor a) throws Exception {
        this.asesorFacadeLocal.edit(a);
    }

    @Override
    public List<Asesor> findAll() throws Exception {
        return (this.asesorFacadeLocal.findAll());
    }

   
}
