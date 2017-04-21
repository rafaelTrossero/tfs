/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entidad.AceptacionObservaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface AceptacionObservacionesFacadeLocal {

    void create(AceptacionObservaciones aceptacion_obs);

    void edit(AceptacionObservaciones aceptacion_obs);

    void remove(AceptacionObservaciones aceptacion_obs);

    AceptacionObservaciones find(Object id);

    List<AceptacionObservaciones> findAll();

    List<AceptacionObservaciones> findRange(int[] range);

    int count();
    
}
