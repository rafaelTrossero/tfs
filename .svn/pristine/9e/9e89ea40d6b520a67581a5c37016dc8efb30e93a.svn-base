/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.Catedra;
import entidad.Horario_catedra;
import entidad.Horario_semanal_catedra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cris
 */
@Local
public interface horario_catedraRNLocal {
     void create(Horario_catedra c) throws Exception;

    void remove(Horario_catedra c) throws Exception;

    void edit(Horario_catedra c) throws Exception;

    List<Horario_catedra> findAll() throws Exception;
    
     Horario_catedra buscarHorario(Catedra catedra) throws Exception;
}
