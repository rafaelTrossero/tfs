/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Docente;
import entidad.Proyecto;
import entidad.ProyectoAsesor;
import entidad.ProyectoCodirector;
import entidad.ProyectoDirector;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cristian
 */
@Local
public interface ProyectoCodirectorFacadeLocal {

    void create(ProyectoCodirector proy_codirector);

    void edit(ProyectoCodirector proy_codirector);

    void remove(ProyectoCodirector proy_codirector);

    ProyectoCodirector find(Object id);

    List<ProyectoCodirector> findAll();

    List<ProyectoCodirector> findRange(int[] range);

    int count();
    
    public List<ProyectoCodirector> findCodirectorActivo(Proyecto pro, boolean active) throws Exception;
    
    public List<ProyectoCodirector> findByProyCodirector(Proyecto pro, boolean active ) throws Exception;
     public List<ProyectoCodirector> findByProyectoCodirector (long idDoc) throws Exception;
     public List<ProyectoCodirector> findProyCodirector(long docente);
    
}
