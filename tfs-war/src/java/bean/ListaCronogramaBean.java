/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.CronogramaActividadRNLocal;
import RN.CronogramaRNLocal;
import RN.DocenteComisionRNLocal;
import entidad.Cronograma;
import entidad.CronogramaActividad;
import entidad.Docente;
import entidad.Proyecto;
import java.io.Serializable;
import java.text.SimpleDateFormat;
//import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Cristian PC
 */
@ManagedBean
@SessionScoped
public class ListaCronogramaBean implements Serializable {
    
    @ManagedProperty("#{envioMailsBean}")
    private EnvioMailsBean envioMailsBean;

    @EJB
    private CronogramaRNLocal cronogramaRNbeanLocal;
    @EJB
    private DocenteComisionRNLocal DocenteComisionRNbeanLocal;
    @EJB
    private CronogramaActividadRNLocal cronogramaActividadRNbeanLocal;
    private List<CronogramaActividad> lstCronogramaActividad;
    private List<SelectItem> lstSICronogramaActividad;
    private Cronograma cronograma;
    private  CronogramaActividad cronogramaActividadObj = new CronogramaActividad();
    private List<CronogramaActividad> listaCronActiv;
    private List<Docente> comisionSeg;
    int i = 1;
    private CronogramaActividad cronAct = new CronogramaActividad();
    
    private Date fechaActual;
    
    private List<String> mails;
    
    private String[] direccionesMails;
    
    private String correos;
   
    
    private Docente docComisionSeg;
    
    SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy"); 
    
    Calendar calendar = Calendar.getInstance(); 
    /**
     * Creates a new instance of ListaCronogramaBean
     */
    public ListaCronogramaBean() {
        System.out.println("Constructor ListaCronogramaBean");
         cronogramaActividadObj.setNumero(i);
        lstCronogramaActividad = new ArrayList<CronogramaActividad>();
        cronograma = new Cronograma();
        
        listaCronActiv = new ArrayList<CronogramaActividad>();
        comisionSeg = new ArrayList<Docente>();
        mails = new ArrayList<String>();
        correos = new String();
        
        System.out.println("cuando entra"+i);
    }

    @PostConstruct
    void init() {
        System.out.println("PostConstructor ListaDepartamentoBean");

       // this.cargar_SI_departamentos();
        // this.cargar_departamentos_activos();
        // this.cargar_SI_departamentos_activos();
        // System.out.println("Departamentos: " + this.getLstDepartamento());
        
       
    }

    public List<CronogramaActividad> getLstCronogramaActividad() {
        return lstCronogramaActividad;
    }

    public CronogramaActividad getCronogramaActividadObj() {
        return cronogramaActividadObj;
    }

    public void setCronogramaActividadObj(CronogramaActividad cronogramaActividadObj) {
        
        listaCronActiv.add(cronogramaActividadObj);
        
        System.out.println("asdassssssssssss" +cronogramaActividadObj);
        System.out.println("priiiiimeerooooooooooooooooo" +i);
    }

    public void setLstCronogramaActividad(List<CronogramaActividad> lstCronogramaActividad) {
        this.lstCronogramaActividad = lstCronogramaActividad;
    }

    public List<SelectItem> getLstSICronogramaActividad() {
        return lstSICronogramaActividad;
    }

    public void setLstSICronogramaActividad(List<SelectItem> lstSICronogramaActividad) {
        this.lstSICronogramaActividad = lstSICronogramaActividad;
    }

    public Cronograma getCronograma() {
        return cronograma;
    }

    public void setCronograma(Cronograma cronograma) {
        this.cronograma = cronograma;
    }

    public List<CronogramaActividad> getListaCronActiv() {
        return listaCronActiv;
    }

    public void setListaCronActiv(List<CronogramaActividad> listaCronActiv) {
        this.listaCronActiv = listaCronActiv;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) throws InstantiationException, IllegalAccessException {
       // this.fechaActual = Date.from(Instant.now());
        this.fechaActual  = Date.class.newInstance();
    }

    public List<Docente> getComisionSeg() {
        return comisionSeg;
    }

    public void setComisionSeg(List<Docente> comisionSeg) {
        this.comisionSeg = comisionSeg;
    }

    public List<String> getMails() {
        return mails;
    }

    public void setMails(List<String> mails) {
        this.mails = mails;
    }

    public Docente getDocComisionSeg() {
        return docComisionSeg;
    }

    public void setDocComisionSeg(Docente DocComisionSeg) {
        this.docComisionSeg = DocComisionSeg;
    }

    public String[] getDireccionesMails() {
        return direccionesMails;
    }

    public void setDireccionesMails(String[] direccionesMails) {
        this.direccionesMails = direccionesMails;
    }

    public String getCorreos() {
        return correos;
    }

    public void setCorreos(String correos) {
        this.correos = correos;
    }

    public EnvioMailsBean getEnvioMailsBean() {
        return envioMailsBean;
    }

    public void setEnvioMailsBean(EnvioMailsBean envioMailsBean) {
        this.envioMailsBean = envioMailsBean;
    }

    public CronogramaRNLocal getCronogramaRNbeanLocal() {
        return cronogramaRNbeanLocal;
    }

    public void setCronogramaRNbeanLocal(CronogramaRNLocal cronogramaRNbeanLocal) {
        this.cronogramaRNbeanLocal = cronogramaRNbeanLocal;
    }

    public CronogramaActividadRNLocal getCronogramaActividadRNbeanLocal() {
        return cronogramaActividadRNbeanLocal;
    }

    public void setCronogramaActividadRNbeanLocal(CronogramaActividadRNLocal cronogramaActividadRNbeanLocal) {
        this.cronogramaActividadRNbeanLocal = cronogramaActividadRNbeanLocal;
    }

   

    public void cargar_Cronograma(Proyecto pro) {
        try {
            this.setLstCronogramaActividad(new ArrayList<CronogramaActividad>());
            
            this.setCronograma(this.cronogramaRNbeanLocal.findByCronograma(pro));
            System.out.println("el croograma resultantes es " + cronograma);
            this.setLstCronogramaActividad(this.cronogramaActividadRNbeanLocal.findByCronogramaActividad(cronograma));
            System.out.println("las actividades de cronograma  resultantes es " + lstCronogramaActividad);
            cargar_SI_departamentos();
        } catch (Exception ex) {
            System.out.println("Error al cargar cronograma " + ex.toString());
        }
    }

    public void cargar_SI_departamentos() {
        this.setLstSICronogramaActividad(new ArrayList<SelectItem>());

        for (CronogramaActividad e : this.getLstCronogramaActividad()) {
            SelectItem si = new SelectItem(e, e.getDescripcion_act());
            this.getLstSICronogramaActividad().add(si);
        }
        System.out.println("el selectitem de cronograma tiene " + lstSICronogramaActividad);
    }//fin for

    public void agregar_objetivos() {
        listaCronActiv.add(new CronogramaActividad());
        System.out.println("hizo el add pero no paso nada parece");
        
        System.out.println("si lo hace da esto" + listaCronActiv);
        
    }

    public void quitar_objetivos() {
        listaCronActiv.remove(listaCronActiv.size());

        System.out.println("hizo el add pero no paso nada parece");

        System.out.println("si lo hace da esto" + listaCronActiv);
    }

    public void limpiar() {
        lstCronogramaActividad = new ArrayList<CronogramaActividad>();
    }

    public void deleteAction(CronogramaActividad actividad) {
        
        System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii:____" +(actividad.getNumero()));
        
        
        Iterator<CronogramaActividad> it = listaCronActiv.iterator();
            System.out.println("el archivo es " + listaCronActiv);

            while (it.hasNext()) {
                cronAct = it.next();
                System.out.println("hola" + cronAct.getDescripcion_act());
               if(cronAct.getNumero()>actividad.getNumero()){
                   cronAct.setNumero(cronAct.getNumero()-1);
               }

                //realiza el alta en la tabla relacional proy_alumno dependiendo de cuantos alumnos se han seleccionado
               
            }
            
        System.out.println("oooooooooooooooooooooooooooooo:____" +actividad.getDescripcion_act());
       System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiii:____" +(actividad.getNumero()-1));
       System.out.println("tamañoooooooooooooooooo11111111111111111" +listaCronActiv.size());
        listaCronActiv.remove(actividad.getNumero()-1);
        System.out.println("tamañooooooooouuooooooooo" +listaCronActiv.size());
        reinit();
    }

    public String reinit() {
        
        System.out.println("antes de sumar" +(listaCronActiv.size()+1));
        i=i+1;
        cronogramaActividadObj = new CronogramaActividad();
        cronogramaActividadObj.setNumero((listaCronActiv.size()+1));
         System.out.println("despues de sumar" +i);
        return null;
    }
    
     public String CronogramaStyleClassSolo(CronogramaActividad cro) throws InstantiationException, IllegalAccessException {
       //setFechaActual(Date.from(Instant.EPOCH));
       setFechaActual(Date.class.newInstance());
    if(fechaActual.after(cro.getFecha_fin()))
    {
          return "colored";
    }  
        return "null";
     }
    
    public String CronogramaStyleClass(CronogramaActividad cro) throws InstantiationException, IllegalAccessException {
        
        //setFechaActual(Date.from(Instant.EPOCH));
        setFechaActual(Date.class.newInstance());
       
        
    if(fechaActual.after(cro.getFecha_fin()))
         {
        calendar.setTime(fechaActual); 
        
        calendar.add(Calendar.DATE, 10);
        System.out.println("++++++++++++++++++" +fechaActual);
        System.out.println("------------------" + cro.getFecha_fin());
        
        System.out.println("LA FECHA ACTUAL + 10 dias es igual a ----->" +calendar.getTime());
        
        this.envioMailsBean.NotificarRetrasoActividad(cro);
          return "colored";
    }  
    
    return "null";
}
    
    

}
