/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.Catedra;
import entidad.Horario_catedra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cris
 */
@Local
public interface Horario_catedraFacadeLocal {

    void create(Horario_catedra horario_catedra);

    void edit(Horario_catedra horario_catedra);

    void remove(Horario_catedra horario_catedra);

    Horario_catedra find(Object id);

    List<Horario_catedra> findAll();

    List<Horario_catedra> findRange(int[] range);

    int count();
    Horario_catedra buscar_horario(Catedra catedra);
    
}
