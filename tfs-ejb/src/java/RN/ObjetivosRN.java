/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.ObjetivosFacadeLocal;
import entidad.Objetivos;
import entidad.Proyecto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cristian
 */
@Stateless
public class ObjetivosRN implements ObjetivosRNLocal {

    @EJB
    private ObjetivosFacadeLocal objetivosFacadeLocal;

    @Override
    public void create(Objetivos p) throws Exception {
        this.objetivosFacadeLocal.create(p);
    }

    @Override
    public void remove(Objetivos p) throws Exception {
        this.objetivosFacadeLocal.remove(p);
    }

    @Override
    public void edit(Objetivos p) throws Exception {
        this.objetivosFacadeLocal.edit(p);
    }

    @Override
    public List<Objetivos> findAll() throws Exception {
        return (this.objetivosFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Objetivos> findObjGeneralByProyectoId(Proyecto proy)  throws Exception {
       return (this.objetivosFacadeLocal.findObjGeneralByProyectoId(proy));
    }

    @Override
    public List<Objetivos> findObjEspecificoslByProyectoId(Proyecto proy)  throws Exception{
       return (this.objetivosFacadeLocal.findObjEspecificoslByProyectoId(proy));
    }

    @Override
    public List<Objetivos> findAllById(Proyecto proy) throws Exception {
        return (this.objetivosFacadeLocal.findAllById(proy));
    }
}
