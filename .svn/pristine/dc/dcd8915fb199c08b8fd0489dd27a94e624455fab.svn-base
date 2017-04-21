/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Depto;
import entidad.ProyectosInvestigacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author WalterVergara
 */
@Local
public interface ProyectosInvestigacionFacadeLocal {
    
    void create(ProyectosInvestigacion proyecto);

    void edit(ProyectosInvestigacion proyecto);

    void remove(ProyectosInvestigacion proyecto);

    ProyectosInvestigacion find(Object id);

    List<ProyectosInvestigacion> findAll();
    
     List<ProyectosInvestigacion> findRange(int[] range);

    int count();
    
    List<ProyectosInvestigacion> findAllActivo();
    
      public void activate(ProyectosInvestigacion c, Boolean bEstado) throws Exception;
}
