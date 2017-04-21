/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.GuiaEvaluacion2_3_indicadores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface GuiaEvaluacion2_3_indicadoresRNLocal {
      void create(GuiaEvaluacion2_3_indicadores c) throws Exception;

    void remove(GuiaEvaluacion2_3_indicadores c) throws Exception;

    void edit(GuiaEvaluacion2_3_indicadores c) throws Exception;

    List<GuiaEvaluacion2_3_indicadores> findAll() throws Exception;
}
