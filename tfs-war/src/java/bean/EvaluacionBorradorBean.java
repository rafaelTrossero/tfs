/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.BorradorRNLocal;
import RN.BorradorEvaluacionRNLocal;
import RN.DocenteRNLocal;
import RN.EvaluacionAspectosRNLocal;
import RN.GuiaEvaluacion2_3_indicadoresRNLocal;
import RN.ObjetivosRNLocal;
import RN.ProyectoAlumnoRNLocal;
import RN.ProyectoDirectorRNLocal;
import RN.ProyectoTribunalRNLocal;
import RN.ProyectoRNbeanLocal;
import entidad.BorradorEvaluacion;
import entidad.Docente;
import entidad.Estado;
import entidad.EvaluacionAspectos;
import entidad.GuiaEvaluacion2_3_indicadores;
import entidad.Objetivos;
import entidad.ProyectoAlumno;
import entidad.ProyectoDirector;
import entidad.Proyecto;
import entidad.ProyectoTribunal;
import entidad.Tribunal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Trossero
 */
@ManagedBean
@RequestScoped
public class EvaluacionBorradorBean {

    @ManagedProperty("#{listaProyectoBean}")
    private ListaProyectoBean listaProyectoBean;
    @ManagedProperty("#{listaCalificacionBean}")
    private ListaCalificacioBean listaCalificacionBean;
    @ManagedProperty("#{listaObjetivosBean}")
    private ListaObjetivosBean listaObjetivosBean;
    @ManagedProperty("#{navegarBean}")
    private navegarBean navegarBean;
    @ManagedProperty("#{listaAlumnoBean}")
    private ListaAlumnoBean listaAlumnoBean;
    @ManagedProperty("#{envioMailsBean}")
    private EnvioMailsBean envioMailsBean;
    @ManagedProperty("#{listaIndicadores23Bean}")
    private ListaIndicadores23Bean listaIndicadores23Bean;
    private Proyecto proyecto;
    private BorradorEvaluacion brr_evaluacion;
    private Tribunal comision_evaluadora;
    private Estado estado;

    private List<ProyectoAlumno> lstProyAlumno;
    private List<ProyectoDirector> lstProyDirector;

    @EJB
    private ProyectoAlumnoRNLocal proy_alumnoRNbeanLocal;
    @EJB
    private ProyectoDirectorRNLocal proy_directorRNbeanLocal;

    @EJB
    private BorradorRNLocal borradorRNbeanLocal;

    @EJB
    private ProyectoTribunalRNLocal proy_tribunalRNbeanLocal;

    @EJB
    private DocenteRNLocal docenteRNbeanLocal;

    @EJB
    private BorradorEvaluacionRNLocal brr_evaluacionRNbeanLocal;
    @EJB
    private ProyectoRNbeanLocal proyectoRNbeanLocal;
    
    @EJB
    private ObjetivosRNLocal objetivosRNLocal;
    
    @EJB
    private EvaluacionAspectosRNLocal evaluacionAspectosRNLocal;
    
     @EJB
    private GuiaEvaluacion2_3_indicadoresRNLocal guiaEvaluacion2_3_indicadoresRNLocal;

    private Docente presidente;
    private Docente vocal1;
    private Docente vocal2;
    private Docente suplente1;
    private Docente suplente2;

    private boolean value1;
    private boolean value2;
    private boolean value3;
    private boolean value4;
    private boolean value5;

    private ArrayList<Boolean> tribunal;

    private List<Docente> tribunalViejo; // aca voy a tener los id de los docentes de la comision evaluadora
    private List<Docente> tribunalNuevo; // aca voy a tener los id de los docentes que evaluaron el borrador
    // presidentes, vocalq y vocal2 

    private List<Docente> tribunalPropuesto;

    private boolean valor;
    
    private List<Objetivos> listaObjetivosEspProyecto;
    
     private Objetivos ObjetivoGralProyecto;
     
     private ArrayList<Boolean> checkAspectos;
     
     boolean[] booleanCheck = new boolean[20];
     
     

      private Map<Long, Boolean> checked = new HashMap<Long, Boolean>();
    private List<Objetivos> aspectos;
    
    private EvaluacionAspectos evaluacionAspectos;
   
     private GuiaEvaluacion2_3_indicadores ind;
     
     
    public EvaluacionBorradorBean() {

        this.brr_evaluacion = new BorradorEvaluacion();
        this.tribunal = new ArrayList();
        this.tribunalNuevo = new ArrayList();
        this.tribunalViejo = new ArrayList();
        this.presidente = new Docente();
        this.vocal1 = new Docente();
        this.vocal2 = new Docente();
        this.suplente1 = new Docente();
        this.suplente2 = new Docente();
        this.comision_evaluadora = new Tribunal();
        this.listaObjetivosEspProyecto = new ArrayList();
        this.ObjetivoGralProyecto = new Objetivos();
        this.checked = new HashMap();
        this.evaluacionAspectos = new EvaluacionAspectos();

    }

    public ListaProyectoBean getListaProyectoBean() {
        return listaProyectoBean;
    }

    public void setListaProyectoBean(ListaProyectoBean listaProyectoBean) {
        this.listaProyectoBean = listaProyectoBean;
    }

    public ListaCalificacioBean getListaCalificacionBean() {
        return listaCalificacionBean;
    }

    public void setListaCalificacionBean(ListaCalificacioBean listaCalificacionBean) {
        this.listaCalificacionBean = listaCalificacionBean;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public List<ProyectoAlumno> getLstProyAlumno() {
        return lstProyAlumno;
    }

    public void setLstProyAlumno(List<ProyectoAlumno> lstProyAlumno) {
        this.lstProyAlumno = lstProyAlumno;
    }

    public List<ProyectoDirector> getLstProyDirector() {
        return lstProyDirector;
    }

    public void setLstProyDirector(List<ProyectoDirector> lstProyDirector) {
        this.lstProyDirector = lstProyDirector;
    }

    public Docente getPresidente() {
        return presidente;
    }

    public void setPresidente(Docente presidente) {
        this.presidente = presidente;
    }

    public Docente getVocal1() {
        return vocal1;
    }

    public void setVocal1(Docente vocal1) {
        this.vocal1 = vocal1;
    }

    public Docente getVocal2() {
        return vocal2;
    }

    public void setVocal2(Docente vocal2) {
        this.vocal2 = vocal2;
    }

    public Docente getSuplente1() {
        return suplente1;
    }

    public void setSuplente1(Docente suplente1) {
        this.suplente1 = suplente1;
    }

    public Docente getSuplente2() {
        return suplente2;
    }

    public void setSuplente2(Docente suplente2) {
        this.suplente2 = suplente2;
    }

    public BorradorEvaluacion getBrr_evaluacion() {
        return brr_evaluacion;
    }

    public void setBrr_evaluacion(BorradorEvaluacion brr_evaluacion) {
        this.brr_evaluacion = brr_evaluacion;
    }

    public boolean isValue1() {
        return value1;
    }

    public void setValue1(boolean value1) {
        this.value1 = value1;
    }

    public boolean isValue2() {
        return value2;
    }

    public void setValue2(boolean value2) {
        this.value2 = value2;
    }

    public boolean isValue3() {
        return value3;
    }

    public void setValue3(boolean value3) {
        this.value3 = value3;
    }

    public boolean isValue4() {
        return value4;
    }

    public void setValue4(boolean value4) {
        this.value4 = value4;
    }

    public boolean isValue5() {
        return value5;
    }

    public void setValue5(boolean value5) {
        this.value5 = value5;
    }

    public ArrayList<Boolean> getTribunal() {
        return tribunal;
    }

    public void setTribunal(ArrayList<Boolean> tribunal) {
        this.tribunal = tribunal;
    }

    public List<Docente> getTribunalViejo() {
        return tribunalViejo;
    }

    public void setTribunalViejo(List<Docente> tribunalViejo) {
        this.tribunalViejo = tribunalViejo;
    }

    public List<Docente> getTribunalNuevo() {
        return tribunalNuevo;
    }

    public void setTribunalNuevo(List<Docente> tribunalNuevo) {
        this.tribunalNuevo = tribunalNuevo;
    }

    public List<Docente> getTribunalPropuesto() {
        return tribunalPropuesto;
    }

    public void setTribunalPropuesto(List<Docente> tribunalPropuesto) {
        this.tribunalPropuesto = tribunalPropuesto;
    }

    public Tribunal getComision_evaluadora() {
        return comision_evaluadora;
    }

    public void setComision_evaluadora(Tribunal comision_evaluadora) {
        this.comision_evaluadora = comision_evaluadora;
    }

    public List<Objetivos> getListaObjetivosEspProyecto() {
        return listaObjetivosEspProyecto;
    }

    public void setListaObjetivosEspProyecto(List<Objetivos> listaObjetivosProyecto) {
        this.listaObjetivosEspProyecto = listaObjetivosProyecto;
    }

    public Objetivos getObjetivoGralProyecto() {
        return ObjetivoGralProyecto;
    }

    public void setObjetivoGralProyecto(Objetivos ObjetivoGralProyecto) {
        this.ObjetivoGralProyecto = ObjetivoGralProyecto;
    }

    public ListaObjetivosBean getListaObjetivosBean() {
        return listaObjetivosBean;
    }

    public void setListaObjetivosBean(ListaObjetivosBean listaObjetivosBean) {
        this.listaObjetivosBean = listaObjetivosBean;
    }

    public navegarBean getNavegarBean() {
        return navegarBean;
    }

    public void setNavegarBean(navegarBean navegarBean) {
        this.navegarBean = navegarBean;
    }

    public ListaAlumnoBean getListaAlumnoBean() {
        return listaAlumnoBean;
    }

    public void setListaAlumnoBean(ListaAlumnoBean listaAlumnoBean) {
        this.listaAlumnoBean = listaAlumnoBean;
    }

    public ArrayList<Boolean> getCheckAspectos() {
        return checkAspectos;
    }

    public void setCheckAspectos(ArrayList<Boolean> checkAspectos) {
        this.checkAspectos = checkAspectos;
    }

   

    public boolean[] getBooleanCheck() {
        return booleanCheck;
    }

    public void setBooleanCheck(boolean[] booleanCheck) {
        this.booleanCheck = booleanCheck;
    }

    public Map<Long, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<Long, Boolean> checked) {
        this.checked = checked;
    }

    public List<Objetivos> getAspectos() {
        return aspectos;
    }

    public void setAspectos(List<Objetivos> aspectos) {
        this.aspectos = aspectos;
    }

    public EvaluacionAspectos getEvaluacionAspectos() {
        return evaluacionAspectos;
    }

    public void setEvaluacionAspectos(EvaluacionAspectos evaluacionAspectos) {
        this.evaluacionAspectos = evaluacionAspectos;
    }

    public GuiaEvaluacion2_3_indicadores getInd() {
        return ind;
    }

    public void setInd(GuiaEvaluacion2_3_indicadores ind) {
        this.ind = ind;
    }

    public ListaIndicadores23Bean getListaIndicadores23Bean() {
        return listaIndicadores23Bean;
    }

    public void setListaIndicadores23Bean(ListaIndicadores23Bean listaIndicadores23Bean) {
        this.listaIndicadores23Bean = listaIndicadores23Bean;
    }

    public EnvioMailsBean getEnvioMailsBean() {
        return envioMailsBean;
    }

    public void setEnvioMailsBean(EnvioMailsBean envioMailsBean) {
        this.envioMailsBean = envioMailsBean;
    }


    public void crear() throws Exception {

        System.out.println("hoooooooooooooooooooooooooooooooooooooooooooooollllllllllllllaaaaaaaaaaa");

        this.setLstProyAlumno(proy_alumnoRNbeanLocal.findByProyAlumno(proyecto));
        if (lstProyAlumno == null) {
            System.out.println("hoooooooooooooooooooooooooooooooooooooooooooooollllllllllllllaaaaaaaaaaa" + lstProyAlumno + proyecto.getId());

        } else {
            System.out.println(" else llllllllllllllaaaaaaaaaaa" + lstProyAlumno + proyecto.getId());

        }

        System.out.println("ahora para el proyecto");
        this.setLstProyDirector(proy_directorRNbeanLocal.findByProyDirector(proyecto));
        if (lstProyDirector == null) {
            System.out.println("h proyecto  no tiene nadallllllllllllllaaaaaaaaaaa" + lstProyDirector + proyecto.getId());

        } else {
            System.out.println(" si hay un proyecto" + lstProyDirector + proyecto.getId());
        }

        setear_miembros_tribunal_propuesto();
       // listaObjetivosBean.setearObjetivoGeneralProyecto(proyecto);
       // listaObjetivosBean.setearObjetivosEspecificosProyecto(proyecto);
      //  listaObjetivosBean.setearAspectosEvaluados(proyecto);
        
        System.out.println("------------- la cantidad de cosas en la lista aspectos es " +listaObjetivosBean.getListaAspectos().size());
        
        
        System.out.println("------------- la cantidad de cosas en el array boolean es " +booleanCheck.length);
        
         System.out.println("-------------AHORA EL RENDERED DEL SELECT ES  " +listaObjetivosBean.isAprobado());
        
    }
    
      public void controlCalificacion() {
          
           System.out.println("------------- la cantidad de cosas en el array boolean CHECKASPECTOS es " +booleanCheck.length);
          
          
      }
      
    
       

    public void setear_miembros_tribunal_propuesto() {

        try {

            System.out.println("hoooooooooooooooooooooooooooooooooooooooooooooooollllllllllllllaaaaaaaaaaa");
            this.setComision_evaluadora(proy_tribunalRNbeanLocal.findTribunal(proyecto, true));

            if (comision_evaluadora == null) {
                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dlgSinTribunal').show();");
            } else {
                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dlgEvaProy').show();");
            }
            System.out.println("esta es la comisino evaluadora:::;::::::" + comision_evaluadora);

            this.setPresidente(docenteRNbeanLocal.findById(comision_evaluadora.getPresidente()));
            this.setVocal1(docenteRNbeanLocal.findById(comision_evaluadora.getVocal1()));
            this.setVocal2(docenteRNbeanLocal.findById(comision_evaluadora.getVocal2()));
            this.setSuplente1(docenteRNbeanLocal.findById(comision_evaluadora.getSuplente1()));
            this.setSuplente2(docenteRNbeanLocal.findById(comision_evaluadora.getSuplente2()));

            System.out.println("estaasdasdasd::;::::::" + presidente + vocal1 + vocal2 + suplente1 + suplente2);

            tribunalViejo.add(presidente);
            tribunalViejo.add(vocal1);
            tribunalViejo.add(vocal2);
            tribunalViejo.add(suplente1);
            tribunalViejo.add(suplente2);
            System.out.println("estaasdasdasd::;:::::: TRIBUNAL VIEJO 2222" + tribunalViejo);

        } catch (Exception ex) {
            Logger.getLogger(EvaluacionBorradorBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /*
    public void setearObjetivosEspecificosProyecto() throws Exception{
        
        this.setListaObjetivosEspProyecto(objetivosRNLocal.findObjEspecificoslByProyectoId(proyecto));
    }
     public void setearObjetivoGeneralProyecto() throws Exception{
        
         this.setObjetivoGralProyecto(objetivosRNLocal.findObjGeneralByProyectoId(proyecto));
    }
*/
    public void setear_tribunal() {
        int i = 0;
        int j = 0;
        System.out.println("asdasd" + value1);
        System.out.println("jdjdfjdjdjdjd" + value2 + value3 + value4 + value5);
        System.out.println("asdasd" + tribunal);

        /*
         Agrego los values que se apretaron en los checkBoolean
         */
        tribunal.add(value1);
        tribunal.add(value2);
        tribunal.add(value3);
        tribunal.add(value4);
        tribunal.add(value5);
        this.setTribunal(tribunal);
        System.out.println("asdasd" + tribunal);

        /*
         Agrego los id de los docentes de la comision evaluadora
         */
        System.out.println("el archivo es " + tribunal.get(1));
        System.out.println("jdjdfjdjdjdjd" + tribunalViejo);

        /*
         Recorro el arrayList de los CheckBoolean (tribunal)
         */
        Iterator<Boolean> it = tribunal.iterator();
        System.out.println("el archivo es " + tribunal);

        while (it.hasNext()) {
            valor = it.next();
            System.out.println("hola" + valor + i);
            /*
             Cada vez que encuentra valor= true, es decir un checkBoolean seleccionado
             entra al if, el valor de la posicion i de tribunal viejo, se añade a la 
             posicion j del tribunal nuevo.
             */
            if (valor != false) {

                System.out.println("guasaaaa" + valor + i);
                System.out.println("chauuu" + valor + j);
                tribunalNuevo.add(tribunalViejo.get(i));
                j++;
            }
            i++;
        }
        System.out.println("el tribunal viejo es " + tribunalViejo);
        System.out.println("el tribunal nuevo es " + tribunalNuevo);
    }
    
    public void setear_aspectos_evaluados(){
        
          System.out.println("CREATEEEEEEEEEEEEEEEEEEEEEEEE" +listaObjetivosBean.getChecked());
            List<Objetivos> checkedItems = new ArrayList<Objetivos>();
            List<Objetivos> NOcheckedItems = new ArrayList<Objetivos>();
            for (Objetivos item : listaObjetivosBean.listaAspectos) {
            if (listaObjetivosBean.getChecked().get(item.getId())) {
                checkedItems.add(item);
                System.out.println("||||||||||°°°°||||°°°||||°°°||||°°°°|||" +listaObjetivosBean.getChecked().get(item.getId()));
                System.out.println("------------- lo que tiene CHECKASPECTOOOOOOoooOOOOOOOOOOOS es " +checkedItems);
            }else{
                System.out.println("||||||||||¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬|||||||||¬¬¬¬¬¬¬¬¬¬¬" +listaObjetivosBean.getChecked().get(item.getId()));
                NOcheckedItems.add(item);
                System.out.println("------------- lo que tiene NOcheckedItem es ********--> " +NOcheckedItems);
            }
        }
           /*
            Guardo los aspectos que fueron seleccionados como aprobados = TRUE
            */
            Iterator<Objetivos> obj = checkedItems.iterator();

            while (obj.hasNext()) {
              try {
                  Objetivos aspectosEvaluados = obj.next();
                  
                  evaluacionAspectos.setBorradorEvaluacion(brr_evaluacion);
                  evaluacionAspectos.setObjetivos(aspectosEvaluados);
                  evaluacionAspectos.setCalificacion(Boolean.TRUE);
                  
                  //realiza el alta en la tabla relacional proy_asesor dependiendo de cuantos asesores se han seleccionado
                  evaluacionAspectosRNLocal.create(evaluacionAspectos);
              } catch (Exception ex) {
                  Logger.getLogger(EvaluacionBorradorBean.class.getName()).log(Level.SEVERE, null, ex);
              }

            }
            
             /*
            Guardo los aspectos que fueron seleccionados como desaprobados = FALSE
            */
            
               Iterator<Objetivos> obj2 = NOcheckedItems.iterator();

            while (obj2.hasNext()) {
              try {
                  Objetivos aspectosEvaluados = obj2.next();
                  
                  evaluacionAspectos.setBorradorEvaluacion(brr_evaluacion);
                  evaluacionAspectos.setObjetivos(aspectosEvaluados);
                  evaluacionAspectos.setCalificacion(Boolean.FALSE);
                  
                  //realiza el alta en la tabla relacional proy_asesor dependiendo de cuantos asesores se han seleccionado
                  evaluacionAspectosRNLocal.create(evaluacionAspectos);
              } catch (Exception ex) {
                  Logger.getLogger(EvaluacionBorradorBean.class.getName()).log(Level.SEVERE, null, ex);
              }

            }
    }

    public void create() {
        String sMensaje = "";
        String sDetalle = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {

          
            setear_miembros_tribunal_propuesto();
            setear_tribunal();
            
           
            System.out.println("si pasa x aca chango" + proyecto.getTitulo());
            System.out.println("estaasdasdasd::;::::::" + presidente + vocal1 + vocal2 + suplente1 + suplente2);
            brr_evaluacion.setProyecto(proyecto);

            Long id_borrador = borradorRNbeanLocal.findByProyecto(proyecto);
            System.out.println("hhhhhhhhhaaaaaaaaaaaaaahhhhhhhhhh" + id_borrador);
            brr_evaluacion.setBorrador(borradorRNbeanLocal.findById(id_borrador));

            try {
                brr_evaluacion.setPresidente(tribunalNuevo.get(0).getId()); //presidente    

            } catch (Exception ex) {
                severity = FacesMessage.SEVERITY_ERROR;
                sMensaje = "Debe seleccionar el presidente del tribunal ";
            }
            try {
                brr_evaluacion.setVocal1(tribunalNuevo.get(1).getId()); // vocal1
            } catch (Exception ex) {
                severity = FacesMessage.SEVERITY_ERROR;
                sMensaje = "Debe seleccionar el vocal N°1 del tribunal";
            }
            try {
                brr_evaluacion.setVocal2(tribunalNuevo.get(2).getId()); // vocal2
            } catch (Exception ex) {
                severity = FacesMessage.SEVERITY_ERROR;
                sMensaje = "Debe seleccionar el vocal N°2 del tribunal";
            }

            brr_evaluacion.setTribunal(comision_evaluadora);

            brr_evaluacionRNbeanLocal.create(brr_evaluacion);
            
            
            
            //si la  calificacion es: APROBADO el proyecto cambia el estado a: Aceptado para defensa
            if (brr_evaluacion.getCalificacion().getCalificacion().equals("Aprobado")
                    || brr_evaluacion.getCalificacion().getCalificacion().equals("APROBADO")
                    || brr_evaluacion.getCalificacion().getId().equals(1L)) {

                estado = proyectoRNbeanLocal.findByEstado(9);
                System.out.println("El estado esw:" + estado.getEstado());
                proyecto.setEstado(estado);
                System.out.println("hasta aca nomaaooooooojojojoojojojo :(" + proyecto.getEstado().getEstado());
                proyectoRNbeanLocal.edit(proyecto);
                System.out.println("la calificacion seleccionada es  " + brr_evaluacion.getCalificacion().getCalificacion());
                sDetalle = "El estado del proyecto es ahora : " + estado.getEstado();

            }
            //si la  calificacion es: APROBADO CON MODIFICACIONES el proyecto cambia el estado a: Se debe modificar borrador
            if (brr_evaluacion.getCalificacion().getCalificacion().equals("Aprobado con modificaciones")
                    || brr_evaluacion.getCalificacion().getCalificacion().equals("APROBADO CON MODIFICACIONES")
                    || brr_evaluacion.getCalificacion().getId().equals(2L)) {

                estado = proyectoRNbeanLocal.findByEstado(10);
                System.out.println("El estado esw:" + estado.getEstado());
                proyecto.setEstado(estado);
                System.out.println("hasta aca nomaaooooooojojojoojojojo :(" + proyecto.getEstado().getEstado());
                proyectoRNbeanLocal.edit(proyecto);
                System.out.println("la calificacion seleccionada es  " + brr_evaluacion.getCalificacion().getCalificacion());
                sDetalle = "El estado del proyecto es ahora : " + estado.getEstado();
            }
            //si la  calificacion es: SE REQUIERE UNA NUEVA PRESENTACION el proyecto cambia el estado a: Se requiere una nueva presentación del Borrador

            if (brr_evaluacion.getCalificacion().getCalificacion().equals("Se requiere una nueva presentacion")
                    || brr_evaluacion.getCalificacion().getCalificacion().equals("SE REQUIERE UNA NUEVA PRESENTACION")
                    || brr_evaluacion.getCalificacion().getId().equals(2L)) {
                estado = proyectoRNbeanLocal.findByEstado(10);
                System.out.println("El estado esw:" + estado.getEstado());
                proyecto.setEstado(estado);
                System.out.println("hasta aca nomaaooooooojojojoojojojo :(" + proyecto.getEstado().getEstado());
                proyectoRNbeanLocal.edit(proyecto);
                System.out.println("la calificacion seleccionada es " + brr_evaluacion.getCalificacion().getCalificacion());
                sDetalle = "El estado del proyecto es ahora : " + estado.getEstado();
            }
            //si la  calificacion es: RECHAZADO el proyecto cambia el estado a: Se requiere una nueva presentación del Borrador
            if (brr_evaluacion.getCalificacion().getCalificacion().equals("Rechazado")
                    || brr_evaluacion.getCalificacion().getCalificacion().equals("RECHAZADO")
                    || brr_evaluacion.getCalificacion().getId().equals(4L)) {
                estado = proyectoRNbeanLocal.findByEstado(11);
                System.out.println("El estado esw:" + estado.getEstado());
                proyecto.setEstado(estado);
                System.out.println("hasta aca nomaaooooooojojojoojojojo :(" + proyecto.getEstado().getEstado());
                proyectoRNbeanLocal.edit(proyecto);
                System.out.println("la calificacion seleccionada es  " + brr_evaluacion.getCalificacion().getCalificacion());
                sDetalle = "El estado del proyecto es ahora : " + estado.getEstado();
            }
            listaIndicadores23Bean.CargarListaIndicadores();
            
             // setear_aspectos_evaluados();
              System.out.println("LLego hasta antes de cargar los indicadores");
               
                System.out.println("LISTA DE INDICADORES EN EvaluacionBorradorBean---->" + listaIndicadores23Bean.getListaIndicadores());
                 setear_indicadores(brr_evaluacion);
              
                 listaIndicadores23Bean.limpiar();
            sMensaje = "Evaluacion de Borrador guardada exitosamente";
            severity = FacesMessage.SEVERITY_INFO;

            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgEvaProy').hide();");
          //  limpiar();
            this.envioMailsBean.ReporteCambioDeEstado(proyecto);
             navegarBean.entrarFormEvaluacionBorradoresProyecto();
            //agregar a la lista
            //limpiar campos
            // this.limpiar();
        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, sDetalle);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }
    
    public void setear_indicadores(BorradorEvaluacion BorrEval) {

        System.out.println("ENTRO A SETEAR INDICADORES; LOS IINDICADORES QUE TIENE QUE SETEAR SON: --->" + listaIndicadores23Bean.getListaIndicadores());
        int i = 1;

        System.out.println("LLego al iterator");
        /*
         Se recorre la lista que tiene los indicadores insertados y se hace un create en la tabla
         por cada indicador de la lista
         */
        Iterator<GuiaEvaluacion2_3_indicadores> it = listaIndicadores23Bean.getListaIndicadores().iterator();

        while (it.hasNext()) {
            ind = it.next();

            this.ind.setNumero(i);
            this.ind.setBorrador_evaluacion(BorrEval);
            

            try {
                this.guiaEvaluacion2_3_indicadoresRNLocal.create(ind);

            } catch (Exception ex) {
                Logger.getLogger(EvaluacionProyectoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }

    }

}
