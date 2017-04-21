/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.Carrera;
import entidad.ProyectosInvestigacion;
import java.util.List;
import javax.ejb.Local;





/**
 *
 * @author WalterVergara
 */
@Local
public interface ProyectosInvestigacionRNLocal {
    
    void create (ProyectosInvestigacion operacion) throws Exception;
    
    void remove (ProyectosInvestigacion operacion) throws Exception;
    
    void edit (ProyectosInvestigacion operacion) throws Exception;
    
    List<ProyectosInvestigacion> findAll() throws Exception;
    
     List<ProyectosInvestigacion> findAllActivo() throws Exception;
     
     public void activate(ProyectosInvestigacion c, Boolean bEstado) throws Exception;
}
