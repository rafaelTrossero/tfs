/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidad.GuiaEvaluacion2_2_indicadores;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author RafaTrossero
 */
@ManagedBean
@SessionScoped
public class ListaIndicadores22Bean {

    private List<GuiaEvaluacion2_2_indicadores> listaIndicadores;

    GuiaEvaluacion2_2_indicadores indicador = new GuiaEvaluacion2_2_indicadores();
    GuiaEvaluacion2_2_indicadores indicador2 = new GuiaEvaluacion2_2_indicadores();
    GuiaEvaluacion2_2_indicadores indicador3 = new GuiaEvaluacion2_2_indicadores();
    GuiaEvaluacion2_2_indicadores indicador4 = new GuiaEvaluacion2_2_indicadores();
    GuiaEvaluacion2_2_indicadores indicador5 = new GuiaEvaluacion2_2_indicadores();
    GuiaEvaluacion2_2_indicadores indicador6 = new GuiaEvaluacion2_2_indicadores();
    GuiaEvaluacion2_2_indicadores indicador7 = new GuiaEvaluacion2_2_indicadores();
    GuiaEvaluacion2_2_indicadores indicador8 = new GuiaEvaluacion2_2_indicadores();
    GuiaEvaluacion2_2_indicadores indicador9 = new GuiaEvaluacion2_2_indicadores();
    GuiaEvaluacion2_2_indicadores indicador10 = new GuiaEvaluacion2_2_indicadores();
    GuiaEvaluacion2_2_indicadores indicador11 = new GuiaEvaluacion2_2_indicadores();
    GuiaEvaluacion2_2_indicadores indicador12 = new GuiaEvaluacion2_2_indicadores();
    GuiaEvaluacion2_2_indicadores indicador13 = new GuiaEvaluacion2_2_indicadores();
    
    int numeroIndicador = 1;
    private Boolean indAprobado = true;
    private Boolean indObservado = true;
    private Boolean indRechazado = false;
    private String ind4 ;
   
    
    private List<String> listaCondicionInd;
    
    public ListaIndicadores22Bean() {
        
        listaIndicadores = new ArrayList<GuiaEvaluacion2_2_indicadores>();
        
        indAprobado = true;
        indObservado = true;
        indRechazado = false;
       
       
        listaCondicionInd = new ArrayList<String>();
    }

    public List<GuiaEvaluacion2_2_indicadores> getListaIndicadores() {
        return listaIndicadores;
    }

    public void setListaIndicadores(List<GuiaEvaluacion2_2_indicadores> listaIndicadores) {
        this.listaIndicadores = listaIndicadores;
    }

    public GuiaEvaluacion2_2_indicadores getIndicador() {
        return indicador;
    }

    public void setIndicador(GuiaEvaluacion2_2_indicadores indicador) {
        this.indicador = indicador;
    }

    public GuiaEvaluacion2_2_indicadores getIndicador2() {
        return indicador2;
    }

    public void setIndicador2(GuiaEvaluacion2_2_indicadores indicador2) {
        this.indicador2 = indicador2;
    }

    public GuiaEvaluacion2_2_indicadores getIndicador3() {
        return indicador3;
    }

    public void setIndicador3(GuiaEvaluacion2_2_indicadores indicador3) {
        this.indicador3 = indicador3;
    }

    public GuiaEvaluacion2_2_indicadores getIndicador4() {
        return indicador4;
    }

    public void setIndicador4(GuiaEvaluacion2_2_indicadores indicador4) {
        this.indicador4 = indicador4;
    }

    public GuiaEvaluacion2_2_indicadores getIndicador5() {
        return indicador5;
    }

    public void setIndicador5(GuiaEvaluacion2_2_indicadores indicador5) {
        this.indicador5 = indicador5;
    }

    public GuiaEvaluacion2_2_indicadores getIndicador6() {
        return indicador6;
    }

    public void setIndicador6(GuiaEvaluacion2_2_indicadores indicador6) {
        this.indicador6 = indicador6;
    }

    public GuiaEvaluacion2_2_indicadores getIndicador7() {
        return indicador7;
    }

    public void setIndicador7(GuiaEvaluacion2_2_indicadores indicador7) {
        this.indicador7 = indicador7;
    }

    public GuiaEvaluacion2_2_indicadores getIndicador8() {
        return indicador8;
    }

    public void setIndicador8(GuiaEvaluacion2_2_indicadores indicador8) {
        this.indicador8 = indicador8;
    }

    public GuiaEvaluacion2_2_indicadores getIndicador9() {
        return indicador9;
    }

    public void setIndicador9(GuiaEvaluacion2_2_indicadores indicador9) {
        this.indicador9 = indicador9;
    }

    public GuiaEvaluacion2_2_indicadores getIndicador10() {
        return indicador10;
    }

    public void setIndicador10(GuiaEvaluacion2_2_indicadores indicador10) {
        this.indicador10 = indicador10;
    }

    public GuiaEvaluacion2_2_indicadores getIndicador11() {
        return indicador11;
    }

    public void setIndicador11(GuiaEvaluacion2_2_indicadores indicador11) {
        this.indicador11 = indicador11;
    }

    public GuiaEvaluacion2_2_indicadores getIndicador12() {
        return indicador12;
    }

    public void setIndicador12(GuiaEvaluacion2_2_indicadores indicador12) {
        this.indicador12 = indicador12;
    }

    public GuiaEvaluacion2_2_indicadores getIndicador13() {
        return indicador13;
    }

    public void setIndicador13(GuiaEvaluacion2_2_indicadores indicador13) {
        this.indicador13 = indicador13;
    }
    

    public int getNumeroIndicador() {
        return numeroIndicador;
    }

    public void setNumeroIndicador(int numeroIndicador) {
        this.numeroIndicador = numeroIndicador;
    }

    public Boolean getIndAprobado() {
        return indAprobado;
    }

    public void setIndAprobado(Boolean indAprobado) {
        this.indAprobado = indAprobado;
    }

    public Boolean getIndObservado() {
        return indObservado;
    }

    public void setIndObservado(Boolean indObservado) {
        this.indObservado = indObservado;
    }

    public Boolean getIndRechazado() {
        return indRechazado;
    }

    public void setIndRechazado(Boolean indRechazado) {
        this.indRechazado = indRechazado;
    }

    public String getInd4() {
        return ind4;
    }

    public void setInd4(String ind4) {
        this.ind4 = ind4;
    }

    public List<String> getListaCondicionInd() {
        return listaCondicionInd;
    }

    public void setListaCondicionInd(List<String> listaCondicionInd) {
        this.listaCondicionInd = listaCondicionInd;
    }

    
     public void CargarListaIndicadores() {

        System.out.println("ENTRO A CARGAR INDICADORES .................-------.-.-..-.-.-...-.-.-.-");
        listaIndicadores.add(indicador);
        listaIndicadores.add(indicador2);
        listaIndicadores.add(indicador3);
        listaIndicadores.add(indicador4);
        listaIndicadores.add(indicador5);
        listaIndicadores.add(indicador6);
        listaIndicadores.add(indicador7);
        listaIndicadores.add(indicador8);
        listaIndicadores.add(indicador9);
        listaIndicadores.add(indicador10);
        listaIndicadores.add(indicador11);
        listaIndicadores.add(indicador12);
        listaIndicadores.add(indicador13);

        System.out.println("La lista de indicadores es ---> " + listaIndicadores);
        System.out.println("La lista de indicadores es ---> " + listaIndicadores.get(1).getNumero());

    }
     
  public void limpiar() {

        indicador = new GuiaEvaluacion2_2_indicadores();
        this.listaIndicadores = new ArrayList<GuiaEvaluacion2_2_indicadores>();
        this.indicador = new GuiaEvaluacion2_2_indicadores();
        this.indicador2 = new GuiaEvaluacion2_2_indicadores();
        this.indicador3 = new GuiaEvaluacion2_2_indicadores();
        this.indicador4 = new GuiaEvaluacion2_2_indicadores();
        this.indicador5 = new GuiaEvaluacion2_2_indicadores();
        this.indicador6 = new GuiaEvaluacion2_2_indicadores();
        this.indicador7 = new GuiaEvaluacion2_2_indicadores();
        this.indicador8 = new GuiaEvaluacion2_2_indicadores();
        this.indicador9 = new GuiaEvaluacion2_2_indicadores();
        this.indicador10 = new GuiaEvaluacion2_2_indicadores();
        this.indicador11 = new GuiaEvaluacion2_2_indicadores();
        this.indicador12 = new GuiaEvaluacion2_2_indicadores();
        this.listaCondicionInd = new ArrayList<String>();
        
        

    }    
     
  public void control_indicadores22(String ind, int i) {
         int ban= 0;
         if(listaCondicionInd.isEmpty()){
             for(int j=1; j<=13; j++){
            listaCondicionInd.add("MALO");
        }
         }
        System.out.println("Entro a control indicadores ---> " + ind);
         System.out.println("La lista cumple es ---> " + listaCondicionInd);

         
        if(listaCondicionInd.size() == 13){
        this.listaCondicionInd.remove(i);
        }
        
        this.listaCondicionInd.add(i, ind);
        
       
        
        if(listaCondicionInd.size() == 13){
            
                Iterator<String> it = listaCondicionInd.iterator();

        while (it.hasNext() && ban != 2) {
            ind4 = it.next();
            System.out.println("ind4 este en  ---> " + ind4);
            if(!ind4.equals("MALO") && !ind4.equals("REGULAR")){
                
                ban=1;
            }else{
                ban=2;
            }          
        }
        System.out.println("LA Bandera esta en  ---> " + ban);
        if(ban==1){
            this.setIndAprobado(false);
            this.setIndRechazado(true);
            this.setIndObservado(true);
        }else{
            this.setIndAprobado(true);
            this.setIndRechazado(false);
            this.setIndObservado(false);
        }
        
        
        }

        System.out.println("Salio de control disable  ---> " + listaCondicionInd + "-..... IndAprobado esta en ----->" +indAprobado + "El tamaño de la listaCumple es ---->" + listaCondicionInd.size());
    }
     
}


