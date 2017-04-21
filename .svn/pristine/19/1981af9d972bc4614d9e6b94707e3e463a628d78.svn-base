/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.personaFacadeLocal;
import entidad.Persona;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jmoreno
 */
@Stateless
public class personaRN implements personaRNLocal {

    @EJB
    private personaFacadeLocal personaFacadeLocal;

    @Override
    public void create(Persona p) throws Exception {

        personaFacadeLocal.create(p);
    }

    @Override
    public void remove(Persona p) throws Exception {
        personaFacadeLocal.remove(p);
    }

    @Override
    public void edit(Persona p) throws Exception {
        personaFacadeLocal.edit(p);
    }

    @Override
    public List<Persona> findAll() throws Exception {
        return (personaFacadeLocal.findAll());
    }
}
