/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.DocenteRNLocal;
import RN.EvaluacionProyectoRNLocal;
import RN.GuiaEvaluacion2_2_indicadoresRNLocal;
import RN.ObjetivosRNLocal;
import RN.PresentacionRNLocal;
import RN.ProyectoAlumnoRNLocal;
import RN.ProyectoDirectorRNLocal;
import RN.ProyectoEvaluacionObservacionesRNLocal;
import RN.ProyectoRNbeanLocal;
import RN.TribunalRNLocal;
import entidad.AceptacionObservaciones;
import entidad.Calificacion;
import entidad.Docente;
import entidad.Estado;
import entidad.EvaluacionProyecto;
import entidad.GuiaEvaluacion2_2_indicadores;
import entidad.Objetivos;
import entidad.Presentacion;
import entidad.ProyectoAlumno;
import entidad.ProyectoDirector;
import entidad.ProyectoEvaluacionObservaciones;
import entidad.ProyectoTribunal;
import entidad.Proyecto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
 * @author Cristian PC
 */
@ManagedBean
@RequestScoped
public class EvaluacionProyectoBean {

    @ManagedProperty("#{listaProyectoBean}")
    private ListaProyectoBean listaProyectoBean;
    @ManagedProperty("#{listaCalificacionBean}")
    private ListaCalificacioBean listaCalificacionBean;
    @ManagedProperty("#{listaObjetivosBean}")
    private ListaObjetivosBean listaObjetivosBean;
    @ManagedProperty("#{navegarBean}")
    private navegarBean navegarBean;
    @ManagedProperty("#{listaIndicadores22Bean}")
    private ListaIndicadores22Bean listaIndicadores22Bean;
    @ManagedProperty("#{envioMailsBean}")
    private EnvioMailsBean envioMailsBean;

    private Proyecto proyecto;
    private EvaluacionProyecto evaluacion_Proyecto;
    private EvaluacionProyecto eval_Proy;
    private List<ProyectoAlumno> lstProyAlumno;
    private List<ProyectoDirector> lstProyDirector;
    private AceptacionObservaciones aceptacion_obs;
    private Presentacion presentacion;
    private final boolean requisito = true;
    private Long presentacionCodigo;
    private Estado estado;
    private ProyectoTribunal proy_tribunal;
    private ProyectoEvaluacionObservaciones proy_evaluacion_obs;
    private List<String> objetivosProy;
    private Objetivos objetivo;
    public Docente presidente;
    public Docente vocal1;
    public Docente vocal2;
    public Docente suplente1;
    public Docente suplente2;
    public Docente docente;
    private Long presidente1;
    private final boolean active = true;
    private boolean value1;
    private boolean value2;
    private boolean value3;
    private boolean value4;
    private boolean value5;
    private Docente doc;
    int ban;
    
    private GuiaEvaluacion2_2_indicadores ind;

    public ArrayList<Boolean> tribunal;

    public ArrayList<Docente> tribunalViejo; // aca voy a tener los id de los docentes de la comision evaluadora
    public ArrayList<Docente> tribunalNuevo; // aca voy a tener los id de los docentes que evaluaron el borrador
    // presidentes, vocalq y vocal2 

    private boolean valor;

    private Objetivos obj;

    private List<Docente> lstDocenteTribunal;

    @EJB
    private ProyectoAlumnoRNLocal proy_alumnoRNbeanLocal;
    @EJB
    private DocenteRNLocal docenteRNLocal;
    @EJB
    private ProyectoDirectorRNLocal proy_directorRNbeanLocal;
    @EJB
    private EvaluacionProyectoRNLocal evaluacion_ProyectoRNeanLocal;
    @EJB
    private PresentacionRNLocal presentacionRNbeanLocal;
    @EJB
    private ProyectoRNbeanLocal proyectoRNbeanLocal;
    @EJB
    private TribunalRNLocal tribunalRNbeanLocal;
    @EJB
    private ProyectoEvaluacionObservacionesRNLocal proy_evaluacion_obsRNbeanLocal;
    @EJB
    private ObjetivosRNLocal objetivoRNbeanLocal;
    @EJB
    private GuiaEvaluacion2_2_indicadoresRNLocal guiaEvaluacion2_2_indicadoresRNLocal;

    /**
     * Creates a new instance of EvaluacionProyectoBean
     */
    public EvaluacionProyectoBean() {
        this.evaluacion_Proyecto = new EvaluacionProyecto();
        this.aceptacion_obs = new AceptacionObservaciones();
        this.estado = new Estado();
        this.objetivo = new Objetivos();
        this.proy_evaluacion_obs = new ProyectoEvaluacionObservaciones();
        this.tribunal = new ArrayList<Boolean>();
        this.tribunalViejo = new ArrayList<Docente>();
        this.tribunalNuevo = new ArrayList<Docente>();
        this.presidente = new Docente();
        this.vocal1 = new Docente();
        this.vocal2 = new Docente();
        this.suplente1 = new Docente();
        this.suplente2 = new Docente();
        this.doc = new Docente();
        this.objetivosProy = new ArrayList<String>();
        this.objetivosProy = new ArrayList<String>();

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

    public EvaluacionProyecto getEvaluacion_Proyecto() {
        return evaluacion_Proyecto;
    }

    public void setEvaluacion_Proyecto(EvaluacionProyecto evaluacion_Proyecto) {
        this.evaluacion_Proyecto = evaluacion_Proyecto;
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

    public AceptacionObservaciones getAceptacion_obs() {
        return aceptacion_obs;
    }

    public void setAceptacion_obs(AceptacionObservaciones aceptacion_obs) {
        this.aceptacion_obs = aceptacion_obs;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public ProyectoEvaluacionObservaciones getProy_evaluacion_obs() {
        return proy_evaluacion_obs;
    }

    public void setProy_evaluacion_obs(ProyectoEvaluacionObservaciones proy_evaluacion_obs) {
        this.proy_evaluacion_obs = proy_evaluacion_obs;
    }

    public Objetivos getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivos objetivo) {
        this.objetivo = objetivo;
    }

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
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

    public List<Docente> getLstDocenteTribunal() {
        return lstDocenteTribunal;
    }

    public void setLstDocenteTribunal(List<Docente> lstDocenteTribunal) {
        this.lstDocenteTribunal = lstDocenteTribunal;
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

    public ArrayList<Docente> getTribunalViejo() {
        return tribunalViejo;
    }

    public void setTribunalViejo(ArrayList<Docente> tribunalViejo) {
        this.tribunalViejo = tribunalViejo;
    }

    public ArrayList<Docente> getTribunalNuevo() {
        return tribunalNuevo;
    }

    public void setTribunalNuevo(ArrayList<Docente> tribunalNuevo) {
        this.tribunalNuevo = tribunalNuevo;
    }

    public Long getPresidente1() {
        return presidente1;
    }

    public void setPresidente1(Long presidente1) {
        this.presidente1 = presidente1;
    }

    public boolean isValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
    }

    public Docente getDoc() {
        return doc;
    }

    public void setDoc(Docente doc) {
        this.doc = doc;
    }

    public List<String> getObjetivosProy() {
        return objetivosProy;
    }

    public void setObjetivosProy(List<String> objetivosProy) {
        this.objetivosProy = objetivosProy;
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

    public ListaIndicadores22Bean getListaIndicadores22Bean() {
        return listaIndicadores22Bean;
    }

    public void setListaIndicadores22Bean(ListaIndicadores22Bean listaIndicadores22Bean) {
        this.listaIndicadores22Bean = listaIndicadores22Bean;
    }

    public GuiaEvaluacion2_2_indicadores getInd() {
        return ind;
    }

    public void setInd(GuiaEvaluacion2_2_indicadores ind) {
        this.ind = ind;
    }

    public EnvioMailsBean getEnvioMailsBean() {
        return envioMailsBean;
    }

    public void setEnvioMailsBean(EnvioMailsBean envioMailsBean) {
        this.envioMailsBean = envioMailsBean;
    }

    
    public void limpiar() {
        this.evaluacion_Proyecto = new EvaluacionProyecto();
        this.aceptacion_obs = new AceptacionObservaciones();
        this.estado = new Estado();
        this.objetivo = new Objetivos();
        this.proy_evaluacion_obs = new ProyectoEvaluacionObservaciones();
        this.tribunal = new ArrayList<Boolean>();
        this.tribunalViejo = new ArrayList<Docente>();
        this.tribunalNuevo = new ArrayList<Docente>();
        this.presidente = new Docente();
        this.vocal1 = new Docente();
        this.vocal2 = new Docente();
        this.suplente1 = new Docente();
        this.suplente2 = new Docente();
        this.doc = new Docente();
        this.objetivosProy = new ArrayList<String>();
        this.setValue1(false);
        this.setValue2(false);
        this.setValue3(false);
        this.setValue4(false);
        this.setValue5(false);
        this.listaObjetivosBean = new ListaObjetivosBean();

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
        setearAtributos();
    }

    public void setearAtributos() throws Exception {

        proy_tribunal = this.tribunalRNbeanLocal.findByProy_Tribunal(proyecto, active);
        System.out.println("el objeto proy_tribunal ESSS:::" + proy_tribunal);
        this.setLstDocenteTribunal(docenteRNLocal.findByDocenteTribunal(proy_tribunal.getTribunal().getPresidente(), proy_tribunal.getTribunal().getVocal1(), proy_tribunal.getTribunal().getVocal2(), proy_tribunal.getTribunal().getSuplente1(), proy_tribunal.getTribunal().getSuplente2()));
        // this.setLstDocenteTribunal(docenteRNLocal.findByDocenteTribunal(9, 6, 2, 4, 5)); 

        System.out.println(" lista docente tribunal " + lstDocenteTribunal);

        Iterator<Docente> it = lstDocenteTribunal.iterator();

        while (it.hasNext()) {
            docente = it.next();

            if (docente.getId().equals(proy_tribunal.getTribunal().getPresidente())) {
                System.out.println("pqpqpqpqppq" + docente.getId() + "asas" + proy_tribunal.getTribunal().getPresidente());
                this.setPresidente(docente);
                System.out.println("el presi essss" + evaluacion_Proyecto.getPresidente() + "presiTribunal" + proy_tribunal.getTribunal().getPresidente());
            }
            if (docente.getId().equals(proy_tribunal.getTribunal().getVocal1())) {
                this.setVocal1(docente);
            }
            if (docente.getId().equals(proy_tribunal.getTribunal().getVocal2())) {
                this.setVocal2(docente);
            }
            if (docente.getId().equals(proy_tribunal.getTribunal().getSuplente1())) {
                this.setSuplente1(docente);
            }
            if (docente.getId().equals(proy_tribunal.getTribunal().getSuplente2())) {
                this.setSuplente2(docente);
            }

        }
        tribunalViejo.add(this.getPresidente());

        tribunalViejo.add(this.getVocal1());
        tribunalViejo.add(this.getVocal2());
        tribunalViejo.add(this.getSuplente1());
        tribunalViejo.add(this.getSuplente2());
        System.out.println("CREEMOS QUE POR ACA SI PASA  Tribunal viejo" + tribunalViejo);

        tribunal.add(value1);
        System.out.println("asdasd" + tribunal);
        tribunal.add(value2);
        tribunal.add(value3);
        tribunal.add(value4);
        tribunal.add(value5);
        System.out.println("asdasd" + tribunal);
        this.setTribunal(tribunal);
        System.out.println("asdasd" + tribunal);
        System.out.println("el preseidente es" + presidente.getId());

        System.out.println("el objetivo es" + objetivo.getObjetivo());
    }

    public void create() {
        String sMensaje = "";
        String sDetalle = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            int j = 0;
            int i = 0;
            int f = 0;

            // setear_tribunal();
            /*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
             FRAGMENTO DE CODIGO QUE ME PERMITE SELECCIONAR LOS 3 MIEMBROS DE LA EVALUACION DE PROYECTO
             ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
            if (evaluacion_Proyecto.getCalificacion().getId().equals(1L) || evaluacion_Proyecto.getCalificacion().getId().equals(2L)) {

                setearAtributos();
                System.out.println("VAMOS LOCO" + tribunalViejo);

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
                        tribunalNuevo.add(j, tribunalViejo.get(i));
                        j++;
                    }
                    i++;
                }
                System.out.println("ESTO ANDA BIEN EL VIEJO ES" + tribunalViejo);
                System.out.println("ESTO ANDA BIEN EL nuevo ES" + tribunalNuevo);
                System.out.println("VAMOS LOCO" + tribunalViejo);

                Iterator<Docente> tribunaldefinitivo = tribunalNuevo.iterator();
                System.out.println("el archivo es " + tribunal);

                while (tribunaldefinitivo.hasNext()) {
                    doc = tribunaldefinitivo.next();

                    if (f == 0) {
                        evaluacion_Proyecto.setPresidente(doc.getId());
                    }
                    if (f == 1) {
                        evaluacion_Proyecto.setVocal1(doc.getId());
                    }
                    if (f == 2) {
                        evaluacion_Proyecto.setVocal2(doc.getId());
                    }

                    f++;

                }
            } else {
                proy_tribunal = this.tribunalRNbeanLocal.findByProy_Tribunal(proyecto, active);
                System.out.println("el objeto proy_tribunal ESSS:::" + proy_tribunal);
            }
            /*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
             FIN FRAGMENTO DE CODIGO
             ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
            evaluacion_Proyecto.setProyecto(proyecto);
            presentacionCodigo = this.presentacionRNbeanLocal.findPresCodigo(proyecto, requisito);
            System.out.println("EL CODIGO DE PRESENTACION ES......: " + presentacionCodigo);
            //consulta que devuelve el registro de presentacion de acuerdo al codigo que me devuelve la consulta anteriro
            presentacion = this.presentacionRNbeanLocal.findByPresentacion(presentacionCodigo);
            System.out.println("EL REGISTRO CON EL CODIGO DE PRESENTACION ES::" + presentacion);
            evaluacion_Proyecto.setPresentacion(presentacion);
            System.out.println("HASTA ACA 1");
            //CONSULTA QUE ME DEVUELVE EL OBJETO PROY_TRIBUNAL PARA USARLO PONER EL CODIGO DEL TRIBUNAL EN EVALUACION DE PROYECTO
            // proy_tribunal = this.tribunalRNbeanLocal.findByProy_Tribunal(proyecto, active);
            //System.out.println("el objeto proy_tribunal es:::" + proy_tribunal);
            evaluacion_Proyecto.setTribunal(proy_tribunal.getTribunal());
            System.out.println("HASTA ACA 2");

            evaluacion_ProyectoRNeanLocal.create(evaluacion_Proyecto);
            System.out.println("HASTA ACA 3");

            //CONSULTA QUE DEVUELVE EL OBJETO EVALUACION_PROYECTO DE ACUERDO AL PROYECTO Y LA PRESENTACION
            eval_Proy = this.evaluacion_ProyectoRNeanLocal.findByEvaluacionl(evaluacion_Proyecto.getProyecto(), evaluacion_Proyecto.getPresentacion());
            System.out.println("los objetos resultantes son  :::" + evaluacion_Proyecto.getProyecto() + "el otro" + evaluacion_Proyecto.getPresentacion());
            System.out.println("el resultado de la consulta es el objeto :::" + eval_Proy);
            this.proy_evaluacion_obs.setEvaluacion_proyecto(eval_Proy);

            this.proy_evaluacion_obsRNbeanLocal.create(proy_evaluacion_obs);
            //si la  calificacion es: APROBADO el proyecto cambia el estado a: Desarrollando el trabajo final
            if (evaluacion_Proyecto.getCalificacion().getCalificacion().equals("Aprobado")
                    || evaluacion_Proyecto.getCalificacion().getCalificacion().equals("APROBADO")
                    || evaluacion_Proyecto.getCalificacion().getId().equals(1L)) {
                //si la  calificacion es: APROBADO el proyecto cambia el estado a: en proceso de asignacion de comision evaluadora
                estado = proyectoRNbeanLocal.findByEstado(5);
                System.out.println("El estado esw:" + estado.getEstado());
                proyecto.setEstado(estado);
                System.out.println("hasta aca nomaaooooooojojojoojojojo :(" + proyecto.getEstado().getEstado());
                proyectoRNbeanLocal.edit(proyecto);
                System.out.println("la calificacion seleccionada es  " + evaluacion_Proyecto.getCalificacion().getCalificacion());

                setear_objetivos();
                sDetalle = "El estado del proyecto es ahora : " + estado.getEstado();
            }
            //si la  calificacion es: APROBADO con modificaciones el proyecto cambia el estado a: Se debe modificar proyecto
            if (evaluacion_Proyecto.getCalificacion().getCalificacion().equals("Aprobado con modificaciones")
                    || evaluacion_Proyecto.getCalificacion().getCalificacion().equals("APROBADO CON MODIFICACIONES")
                    || evaluacion_Proyecto.getCalificacion().getId().equals(2L)) {

                estado = proyectoRNbeanLocal.findByEstado(6);
                System.out.println("El estado esw:" + estado.getEstado());
                proyecto.setEstado(estado);
                System.out.println("hasta aca nomaaooooooojojojoojojojo :(" + proyecto.getEstado().getEstado());
                proyectoRNbeanLocal.edit(proyecto);
                System.out.println("la calificacion seleccionada es  " + evaluacion_Proyecto.getCalificacion().getCalificacion());
                setear_objetivos();
                sDetalle = "El estado del proyecto es ahora : " + estado.getEstado();
            }
            //si la  calificacion es: SE REQUIERE UNA NUEVA PRESENTACION el proyecto cambia el estado a: Se debe modificar proyecto

            if (evaluacion_Proyecto.getCalificacion().getCalificacion().equals("Se requiere una nueva presentacion")
                    || evaluacion_Proyecto.getCalificacion().getCalificacion().equals("SE REQUIERE UNA NUEVA PRESENTACION")
                    || evaluacion_Proyecto.getCalificacion().getId().equals(3L)) {
                estado = proyectoRNbeanLocal.findByEstado(6);
                System.out.println("El estado esw:" + estado.getEstado());
                proyecto.setEstado(estado);
                System.out.println("hasta aca nomaaooooooojojojoojojojo :(" + proyecto.getEstado().getEstado());
                proyectoRNbeanLocal.edit(proyecto);
                System.out.println("la calificacion seleccionada es " + evaluacion_Proyecto.getCalificacion().getCalificacion());
                sDetalle = "El estado del proyecto es ahora : " + estado.getEstado();
            }
            //si la  calificacion es: RECHAZADO el proyecto cambia el estado a: pROYECTO RECHAZADO
            if (evaluacion_Proyecto.getCalificacion().getCalificacion().equals("Rechazado")
                    || evaluacion_Proyecto.getCalificacion().getCalificacion().equals("RECHAZADO")
                    || evaluacion_Proyecto.getCalificacion().getId().equals(4L)) {
                estado = proyectoRNbeanLocal.findByEstado(7);
                System.out.println("El estado esw:" + estado.getEstado());
                proyecto.setEstado(estado);
                System.out.println("hasta aca nomaaooooooojojojoojojojo :(" + proyecto.getEstado().getEstado());
                proyectoRNbeanLocal.edit(proyecto);
                System.out.println("la calificacion seleccionada es  " + evaluacion_Proyecto.getCalificacion().getCalificacion());
                sDetalle = "El estado del proyecto es ahora : " + estado.getEstado();
            }
            
            listaIndicadores22Bean.CargarListaIndicadores();
            System.out.println("LISTA DE INDICADORES EN ACEPTACIONBEAN---->" + listaIndicadores22Bean.getListaIndicadores());
            setear_indicadores(evaluacion_Proyecto);
            
            listaIndicadores22Bean.limpiar();
             this.envioMailsBean.ReporteCambioDeEstado(proyecto);
            sMensaje = "Evaluacion guardada exitosamente";
            severity = FacesMessage.SEVERITY_INFO;
            limpiar();
            navegarBean.entrarFormEvaluacion();
            //agregar a la lista
            //limpiar campos
            // this.limpiar();
        } catch (Exception ex) {
            ban = 1;
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al crear Aceptacion de proyecto: " + ex.getMessage();

        } finally {
            System.out.println("ENTRO AL FINALLY");
            fm = new FacesMessage(severity, sMensaje, sDetalle);
            FacesContext fc = FacesContext.getCurrentInstance();
            if (ban==1){
                RequestContext context1 = RequestContext.getCurrentInstance();
                context1.execute("dlgEval.show()");
            }
            fc.addMessage(null, fm);
        }
    }

    public void abrir_cargar_objetivos(Calificacion calif) {

        System.out.println(" la calificacion seleccionada es: " + calif.getCalificacion());
        System.out.println(" entra a cargarObjetivosSelect: ");

        System.out.println(" calificacion: " + calif);

        if (calif.getId().equals(1L) || calif.getId().equals(2L)) {
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("dlgObjetivosProy.show()");

        }

    }

    public void setear_objetivos() {

        evaluacion_Proyecto.setProyecto(proyecto);
        this.objetivo.setProyecto(evaluacion_Proyecto.getProyecto());

        /*
         Se recorre la lista que tiene los objetivos insertados y se hace un create en la tabla
         por cada objetivo de la lista
         */
        Iterator<Objetivos> it = listaObjetivosBean.getListaObjetivos().iterator();

        while (it.hasNext()) {
            obj = it.next();

            this.objetivo.setObjetivo(obj.getObjetivo());
            this.objetivo.setTipo(obj.getTipo());
            try {
                this.objetivoRNbeanLocal.create(objetivo);
                System.out.println("se hizo el create de objetivos" + listaObjetivosBean.getObjetivosProy());
            } catch (Exception ex) {
                Logger.getLogger(EvaluacionProyectoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void agregar_objetivos() {
        objetivosProy.add(new String());
        System.out.println("hizo el add pero no paso nada parece EvaluacionProyectoBean");

        System.out.println("si lo hace da esto" + objetivosProy);
    }
    
    public void setear_indicadores(EvaluacionProyecto eval) {

        int i = 1;

        System.out.println("LLego al iterator");
        /*
         Se recorre la lista que tiene los indicadores insertados y se hace un create en la tabla
         por cada indicador de la lista
         */
        Iterator<GuiaEvaluacion2_2_indicadores> it = listaIndicadores22Bean.getListaIndicadores().iterator();

        while (it.hasNext()) {
            ind = it.next();

            this.ind.setNumero(i);
            this.ind.setEvaluacion_proyecto(eval);
            

            try {
                this.guiaEvaluacion2_2_indicadoresRNLocal.create(ind);

            } catch (Exception ex) {
                Logger.getLogger(EvaluacionProyectoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }

    }
}
