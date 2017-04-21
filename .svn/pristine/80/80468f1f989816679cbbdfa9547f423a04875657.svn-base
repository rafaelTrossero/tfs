/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.ProfesionFacadeLocal;
import entidad.Profesion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Trossero
 */
@Stateless
public class ProfesionRN implements ProfesionRNLocal {

    @EJB
    private ProfesionFacadeLocal profesionFacadeLocal;

    @Override
    public void create(Profesion p) throws Exception {
        this.profesionFacadeLocal.create(p);
    }

    @Override
    public void remove(Profesion p) throws Exception {
        this.profesionFacadeLocal.remove(p);
    }

    @Override
    public void edit(Profesion p) throws Exception {
        this.profesionFacadeLocal.edit(p);
    }

    @Override
    public List<Profesion> findAll() throws Exception {
        return (this.profesionFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
