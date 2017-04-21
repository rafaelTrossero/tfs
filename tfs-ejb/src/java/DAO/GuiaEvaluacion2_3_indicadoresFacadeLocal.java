/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.GuiaEvaluacion2_3_indicadores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface GuiaEvaluacion2_3_indicadoresFacadeLocal {

    void create(GuiaEvaluacion2_3_indicadores guiaEvaluacion2_3_indicadores);

    void edit(GuiaEvaluacion2_3_indicadores guiaEvaluacion2_3_indicadores);

    void remove(GuiaEvaluacion2_3_indicadores guiaEvaluacion2_3_indicadores);

    GuiaEvaluacion2_3_indicadores find(Object id);

    List<GuiaEvaluacion2_3_indicadores> findAll();

    List<GuiaEvaluacion2_3_indicadores> findRange(int[] range);

    int count();
    
}
