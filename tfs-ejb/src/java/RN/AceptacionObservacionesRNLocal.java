/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import entidad.AceptacionObservaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Trossero
 */
@Local
public interface AceptacionObservacionesRNLocal {
    
    void create(AceptacionObservaciones a) throws Exception;

    void remove(AceptacionObservaciones a) throws Exception;

    void edit(AceptacionObservaciones a) throws Exception;

    List<AceptacionObservaciones> findAll() throws Exception;   
}
