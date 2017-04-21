/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.GuiaEvaluacion2_1_indicadores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface GuiaEvaluacion2_1_indicadoresFacadeLocal {

    void create(GuiaEvaluacion2_1_indicadores guiaEvaluacion2_1_indicadores);

    void edit(GuiaEvaluacion2_1_indicadores guiaEvaluacion2_1_indicadores);

    void remove(GuiaEvaluacion2_1_indicadores guiaEvaluacion2_1_indicadores);

    GuiaEvaluacion2_1_indicadores find(Object id);

    List<GuiaEvaluacion2_1_indicadores> findAll();

    List<GuiaEvaluacion2_1_indicadores> findRange(int[] range);

    int count();
    
}
