/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.ObjetivosRNLocal;
import entidad.Objetivos;
import entidad.Proyecto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Trossero
 */
@ManagedBean
@SessionScoped
public class ListaObjetivosBean {

    private List<String> objetivosProy;
    private List<Objetivos> listaObjetivos;
    private Objetivos ObjetivosProyecto = new Objetivos();

    private String SelectedTipo = new String();
    private Boolean general;
    private Boolean aprobado=true;
    private List<Objetivos> listaObjetivosEspProyecto;
    
    List<Objetivos> listaAspectos;
     private Map<Long, Boolean> checked = new HashMap<Long, Boolean>();

    private List<Objetivos> ObjetivoGralProyecto;
    @EJB
    private ObjetivosRNLocal objetivosRNLocal;

    public ListaObjetivosBean() {
        this.objetivosProy = new ArrayList<String>();
        listaObjetivos = new ArrayList<Objetivos>();
        this.listaObjetivosEspProyecto = new ArrayList();
        this.ObjetivoGralProyecto = new ArrayList<Objetivos>();
        this.listaAspectos = new ArrayList<Objetivos>();
        this.checked = new HashMap <Long, Boolean>();
    }

    public List<String> getObjetivosProy() {
        return objetivosProy;
    }

    public void setObjetivosProy(List<String> objetivosProy) {
        this.objetivosProy = objetivosProy;
    }

    public List<Objetivos> getListaObjetivos() {
        return listaObjetivos;
    }

    public void setListaObjetivos(List<Objetivos> listaObjetivos) {
        this.listaObjetivos = listaObjetivos;
    }

    public Objetivos getObjetivosProyecto() {
        return ObjetivosProyecto;
    }

    public void setObjetivosProyecto(Objetivos objetivosProyecto) {

        if (objetivosProyecto.getTipo().equals("OBJETIVO GENERAL")) {
            System.out.println("SIIIIIIIIIIIIIIIIIIIIIIIIIIII");
            this.setGeneral(Boolean.TRUE);
        }

        listaObjetivos.add(objetivosProyecto);

    }

    public String getSelectedTipo() {
        return SelectedTipo;
    }

    public void setSelectedTipo(String SelectedTipo) {
        this.SelectedTipo = SelectedTipo;
    }

    public Boolean isGeneral() {
        return general;
    }

    public void setGeneral(Boolean general) {
        this.general = general;
    }

     public Boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }
    
    public List<Objetivos> getListaObjetivosEspProyecto() {
        return listaObjetivosEspProyecto;
    }

    public void setListaObjetivosEspProyecto(List<Objetivos> listaObjetivosEspProyecto) {
        this.listaObjetivosEspProyecto = listaObjetivosEspProyecto;
    }

    public List<Objetivos> getObjetivoGralProyecto() {
        return ObjetivoGralProyecto;
    }

    public void setObjetivoGralProyecto(List<Objetivos> ObjetivoGralProyecto) {
        this.ObjetivoGralProyecto = ObjetivoGralProyecto;
    }

    public List<Objetivos> getListaAspectos() {
        return listaAspectos;
    }

    public void setListaAspectos(List<Objetivos> listaAspectos) {
        this.listaAspectos = listaAspectos;
    }

    public Map<Long, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<Long, Boolean> checked) {
        this.checked = checked;
    }

   

    public void agregar_objetivos() {
        objetivosProy.add(new String());
        System.out.println("hizo el add pero no paso nada parece");

        System.out.println("si lo hace da esto" + objetivosProy);
    }

    public void deleteAction(Objetivos obj) {

        listaObjetivos.remove(obj);

        reinit();
    }

    public String reinit() {

        ObjetivosProyecto = new Objetivos();

        return null;
    }

    public void setearObjetivosEspecificosProyecto(Proyecto proyecto) throws Exception {

        this.setListaObjetivosEspProyecto(objetivosRNLocal.findObjEspecificoslByProyectoId(proyecto));
        System.out.println("+++++++++++++++++++++++++++++ OBJETIVOS ESPECIFICOS +++++++++++++++++++" +listaObjetivosEspProyecto);
    }

    public void setearObjetivoGeneralProyecto(Proyecto proyecto) throws Exception {

        this.setObjetivoGralProyecto(objetivosRNLocal.findObjGeneralByProyectoId(proyecto));
         System.out.println("+++++++++++++++++++++++++++++ OBJETIVO GENERAL +++++++++++++++++++" +ObjetivoGralProyecto);
    }
    
     public void setearAspectosEvaluados  (Proyecto proyecto) throws Exception {

         this.setListaAspectos(objetivosRNLocal.findAllById(proyecto));
         System.out.println("+++++++++++++++++++++++++++++ ASPECTOS +++++++++++++++++++" +listaAspectos);
    }
     
      public void submit() {
         
           
            System.out.println("-------------ENTROOOOOOOOOO " +isAprobado());
            
        List<Objetivos> checkedItems = new ArrayList<Objetivos>();

          System.out.println("checkedddddddddddddddddddddddddDDDDDDD--->>>>>" +checked);
        for (Objetivos item : listaAspectos) {
            if (checked.get(item.getId())) {
                checkedItems.add(item);
                System.out.println("||||||||||°°°°||||°°°||||°°°||||°°°°|||" +checked.get(item.getId()));
            }else{
                System.out.println("||||||||||¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬|||||||||¬¬¬¬¬¬¬¬¬¬¬" +checked.get(item.getId()));
            }
        }

        System.out.println("------------- la cantidad de cosas en el array boolean CHECKASPECTOOOOOOoooOOOOOOOOOOOS es " +checkedItems.size());
        
        for(Objetivos obj : checkedItems){
            System.out.println("------------- lo que tiene CHECKASPECTOOOOOOoooOOOOOOOOOOOS es " +obj +"----" + obj.getObjetivo());
        }
        System.out.println("------------- lo que tiene CHECKASPECTOOOOOOoooOOOOOOOOOOOS es " +checkedItems);
     //   checked.clear(); // If necessary.

        if (checkedItems.size() == listaAspectos.size()){
             System.out.println("SIIIIIIIIIIIIIIIIIIIIIIIIIIII");
             this.setAprobado(Boolean.FALSE);
              System.out.println("SIIIIIIIIIIIIIIIIIIIIIIIIIIII" +isAprobado());
              
        }else{
             this.setAprobado(Boolean.TRUE);
        }
        // Now do your thing with checkedItems.
    }
}
