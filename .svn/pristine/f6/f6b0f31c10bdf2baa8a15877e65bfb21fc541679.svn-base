/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.ProyectoTribunalFacadeLocal;
import entidad.ProyectoTribunal;
import entidad.Proyecto;
import entidad.Tribunal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Trossero
 */
@Stateless
public class ProyectoTribunalRN implements ProyectoTribunalRNLocal {
    
    @EJB
    private ProyectoTribunalFacadeLocal proy_tribunalFacadeLocal;

    @Override
    public void create(ProyectoTribunal proy_tribunal) throws Exception {
        this.proy_tribunalFacadeLocal.create(proy_tribunal);
    }

    @Override
    public void remove(ProyectoTribunal proy_tribunal) throws Exception {
        this.proy_tribunalFacadeLocal.remove(proy_tribunal);
    }

    @Override
    public void edit(ProyectoTribunal proy_tribunal) throws Exception {
        this.proy_tribunalFacadeLocal.edit(proy_tribunal);
    }

    @Override
    public List<ProyectoTribunal> findAll() throws Exception {
        return(this.proy_tribunalFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Tribunal findTribunal(Proyecto proyecto, Boolean active) {
       return(this.proy_tribunalFacadeLocal.findTribunal(proyecto, active));
    }

    @Override
    public Proyecto findProyectoByTribunal(long tribunal) throws Exception {
        return (this.proy_tribunalFacadeLocal.findProyectoByTribunal(tribunal));
    }
}
