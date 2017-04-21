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
public interface Horario_catedra_semanalRNLocal {
    
     void create(Horario_semanal_catedra c) throws Exception;

    void remove(Horario_semanal_catedra c) throws Exception;

    void edit(Horario_semanal_catedra c) throws Exception;

    List<Horario_semanal_catedra> findAll() throws Exception;
    List<Horario_semanal_catedra> buscarHorario(Horario_catedra hora_catedra) throws Exception;
}
