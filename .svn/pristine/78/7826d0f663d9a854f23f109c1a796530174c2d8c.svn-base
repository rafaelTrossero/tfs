/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.ProyectoTagsFacadeLocal;
import entidad.ProyectoTags;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class ProyectoTagsRN implements ProyectoTagsRNLocal {

    @EJB
    private ProyectoTagsFacadeLocal proyectoTagsFacadeLocal;
    
    
    @Override
    public void create(ProyectoTags proyectoTags) {
        this.proyectoTagsFacadeLocal.create(proyectoTags);
    }

    @Override
    public void edit(ProyectoTags proyectoTags) {
        this.proyectoTagsFacadeLocal.edit(proyectoTags);
    }

    @Override
    public void remove(ProyectoTags proyectoTags) {
        this.proyectoTagsFacadeLocal.remove(proyectoTags);
    }

   
    @Override
    public List<ProyectoTags> findAll() {
        return(this.proyectoTagsFacadeLocal.findAll());
    }

    @Override
    public List<ProyectoTags> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
