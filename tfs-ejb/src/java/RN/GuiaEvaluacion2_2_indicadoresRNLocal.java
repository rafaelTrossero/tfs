/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.GuiaEvaluacion2_2_indicadores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface GuiaEvaluacion2_2_indicadoresRNLocal {
      void create(GuiaEvaluacion2_2_indicadores c) throws Exception;

    void remove(GuiaEvaluacion2_2_indicadores c) throws Exception;

    void edit(GuiaEvaluacion2_2_indicadores c) throws Exception;

    List<GuiaEvaluacion2_2_indicadores> findAll() throws Exception;
}
