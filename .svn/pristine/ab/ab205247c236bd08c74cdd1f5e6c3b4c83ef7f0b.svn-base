/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.EvaluacionAspectos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface EvaluacionAspectosFacadeLocal {

    void create(EvaluacionAspectos evaluacionAspectos);

    void edit(EvaluacionAspectos evaluacionAspectos);

    void remove(EvaluacionAspectos evaluacionAspectos);

    EvaluacionAspectos find(Object id);

    List<EvaluacionAspectos> findAll();

    List<EvaluacionAspectos> findRange(int[] range);

    int count();
    
}
