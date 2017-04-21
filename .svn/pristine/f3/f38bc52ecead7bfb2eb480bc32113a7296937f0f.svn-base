/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Horario_catedra;
import entidad.Horario_semanal_catedra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cris
 */
@Local
public interface Horario_semanal_catedraFacadeLocal {

    void create(Horario_semanal_catedra horario_semanal_catedra);

    void edit(Horario_semanal_catedra horario_semanal_catedra);

    void remove(Horario_semanal_catedra horario_semanal_catedra);

    Horario_semanal_catedra find(Object id);

    List<Horario_semanal_catedra> findAll();

    List<Horario_semanal_catedra> findRange(int[] range);

    int count();
    List<Horario_semanal_catedra> findHorarios(Horario_catedra hora_cated);
    
}
