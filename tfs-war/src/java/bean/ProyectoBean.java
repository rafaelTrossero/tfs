/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.DefensaFinalRNLocal;
import RN.PresentacionRNLocal;
import RN.ProyectoAlumnoRNLocal;
import RN.ProyectoAsesorRNLocal;
import RN.ProyectoDirectorRNLocal;
import RN.ProyectoRNbeanLocal;
import RN.ProyectoCodirectorRNLocal;
import RN.ProyectoTagsRNLocal;
import entidad.Alumno;
import entidad.Asesor;
import entidad.Carrera;
import entidad.Codirector;
import entidad.DefensaFinal;
import entidad.Director;
import entidad.Docente;
import entidad.Estado;
import entidad.Presentacion;
import entidad.Profesional;
import entidad.ProyectoAlumno;
import entidad.ProyectoAsesor;
import entidad.ProyectoCodirector;
import entidad.ProyectoDirector;
import entidad.Proyecto;
import entidad.ProyectoTags;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.time.Instant;
//import java.time.Instant;
import java.util.ArrayList;
import java.util.Date; 
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;



import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.context.RequestContext;
import reportes.bean.ReportsBean;

/**
 *
 * @author RafaTrossero
 */
@ManagedBean
@RequestScoped
public class ProyectoBean {

    @ManagedProperty("#{listaProyectosAprobadosBean}")
    private ListaProyectosAprobadosBean listaProyectosAprobadosBean;
    @ManagedProperty("#{listaProyectoBean}")
    private ListaProyectoBean listaProyectoBean;
    @ManagedProperty("#{envioMailsBean}")
    private EnvioMailsBean envioMailsBean;
     @ManagedProperty("#{fileUploadController}")
    private FileUploadController fileUploadController;
    private Proyecto proyecto;
    private DefensaFinal defensafinal;
    private Proyecto pro;
    private Alumno alumno;
    private Director director;
    private Director dir;
    private Codirector codirector;
    private Asesor asesor;
    private Profesional profesional;
    private Profesional profesionales;
    private Presentacion presentacion;
    private Estado estado;
    private ProyectoAlumno proy_alu;
    private ProyectoAsesor proy_ases;
    private ProyectoCodirector proy_codir;
    private List<Alumno> selectedAlu;
    private List<Profesional> selectedAses;
    private List<Profesional> selectedCodir;
    private ProyectoDirector proy_direc;
    private ProyectoTags proyTags;
    private String palabrasClaves;
    private String palabrasClaves2;
    private String palabrasClaves3;
    private ArrayList<String> tags;
    public Date fecha1;
    public Date fecha2;
    
     private List<DefensaFinal> lstProyectosAprobados;

    private CommandButton cbAction;
    private boolean certificado;
    private boolean notadeDirector;
    private boolean notadeAceptacion;
    private boolean notadeCodirector;
     private final String rutaReporte = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/");

    private Boolean hayCodirector;

    @EJB
    private ProyectoRNbeanLocal proyectoRNbeanLocal;
    @EJB
    private DefensaFinalRNLocal defensafinalRNbeanLocal;
    @EJB
    private ProyectoAlumnoRNLocal proy_alumnoRNbeanLocal;
    @EJB
    private ProyectoDirectorRNLocal proy_directorRNbeanLocal;
    @EJB
    private ProyectoAsesorRNLocal proy_asesorRNbeanLocal;
    @EJB
    private ProyectoCodirectorRNLocal proy_codirecRNbeanLocal;
    @EJB
    private PresentacionRNLocal presentacionRNbeanLocal;

    @EJB
    private ProyectoTagsRNLocal proyectoTagRNLocal;

    // private String[] requisitos={"0"}; 
    private String notaDirector;
    private String notaAceptacion;
    private String certificadoRegular;
    private String notaCodirector; // 0= Nota del director
    // 1= Nota de aceptacion
    // 2= Certificado de alumno regular   
    // 3= Nota de Codirector

    private ReportsBean reportsBean;
    private final String escudo1 = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/Imagenes/nuevoLogoFacultad2.jpg");
    private final String escudo2 = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/Imagenes/escudo.jpg");
      private final String sub_report1= FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports");
      private final String sub_report2= FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/proyecto_como_codirector");
       private final String sub_report3= FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/proyecto_como_asesor");


    public ProyectoBean() throws InstantiationException, IllegalAccessException {
        this.proyecto = new Proyecto();
        this.defensafinal = new DefensaFinal();
        this.estado = new Estado();
        this.proy_alu = new ProyectoAlumno();
        this.proy_direc = new ProyectoDirector();
        this.proy_ases = new ProyectoAsesor();
        this.proy_codir = new ProyectoCodirector();
        // proyecto.setFecha_ingreso(Date.class.newInstance());
        this.proyTags = new ProyectoTags();
        this.tags = new ArrayList();
       

    }

    public ListaProyectosAprobadosBean getListaProyectosAprobadosBean() {
        return listaProyectosAprobadosBean;
    }

    public void setListaProyectosAprobadosBean(ListaProyectosAprobadosBean listaProyectosAprobadosBean) {
        this.listaProyectosAprobadosBean = listaProyectosAprobadosBean;
    }

    public List<DefensaFinal> getLstProyectosAprobados() {
        return lstProyectosAprobados;
    }

    public void setLstProyectosAprobados(List<DefensaFinal> lstProyectosAprobados) {
        this.lstProyectosAprobados = lstProyectosAprobados;
    }

    public ReportsBean getReportsBean() {
        return reportsBean;
    }

    public void setReportsBean(ReportsBean reportsBean) {
        this.reportsBean = reportsBean;
    }

    
    public ListaProyectoBean getListaProyectoBean() {
        return listaProyectoBean;
    }

    public void setListaProyectoBean(ListaProyectoBean listaProyectoBean) {
        this.listaProyectoBean = listaProyectoBean;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public DefensaFinal getDefensafinal() {
        return defensafinal;
    }

    public void setDefensafinal(DefensaFinal defensafinal) {
        this.defensafinal = defensafinal;
    }

    public List<Alumno> getSelectedAlu() {
        return selectedAlu;
    }

    public List<Profesional> getSelectedCodir() {
        return selectedCodir;
    }

    public void setSelectedCodir(List<Profesional> selectedCodir) {
        this.selectedCodir = selectedCodir;
    }

    public void setSelectedAlu(List<Alumno> selectedAlu) {
        this.selectedAlu = selectedAlu;
    }

    public ProyectoRNbeanLocal getProyectoRNbeanLocal() {
        return proyectoRNbeanLocal;
    }

    public List<Profesional> getSelectedAses() {
        return selectedAses;
    }

    public void setSelectedAses(List<Profesional> selectedAses) {
        this.selectedAses = selectedAses;
    }

    public void setProyectoRNbeanLocal(ProyectoRNbeanLocal proyectoRNbeanLocal) {
        this.proyectoRNbeanLocal = proyectoRNbeanLocal;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public ProyectoDirector getProy_direc() {
        return proy_direc;
    }

    public void setProy_direc(ProyectoDirector proy_direc) {
        this.proy_direc = proy_direc;
    }

    public CommandButton getCbAction() {
        return cbAction;
    }

    public void setCbAction(CommandButton cbAction) {
        this.cbAction = cbAction;
    }

    public String getNotaDirector() {
        return notaDirector;
    }

    public void setNotaDirector(String notaDirector) {
        this.notaDirector = notaDirector;
    }

    public String getNotaAceptacion() {
        return notaAceptacion;
    }

    public void setNotaAceptacion(String notaAceptacion) {
        this.notaAceptacion = notaAceptacion;
    }

    public String getCertificadoRegular() {
        return certificadoRegular;
    }

    public String getNotaCodirector() {
        return notaCodirector;
    }

    public void setNotaCodirector(String notaCodirector) {
        this.notaCodirector = notaCodirector;
    }

    public void setCertificadoRegular(String certificadoRegular) {
        this.certificadoRegular = certificadoRegular;
    }

    public boolean isCertificado() {
        return certificado;
    }

    public void setCertificado(boolean certificado) {
        this.certificado = certificado;
    }

    public boolean isNotadeDirector() {
        return notadeDirector;
    }

    public void setNotadeDirector(boolean notadeDirector) {
        this.notadeDirector = notadeDirector;
    }

    public boolean isNotadeCodirector() {
        return notadeCodirector;
    }

    public void setNotadeCodirector(boolean notadeCodirector) {
        this.notadeCodirector = notadeCodirector;
    }

    public boolean isNotadeAceptacion() {
        return notadeAceptacion;
    }

    public void setNotadeAceptacion(boolean notadeAceptacion) {
        this.notadeAceptacion = notadeAceptacion;
    }

    public ProyectoTags getProyTags() {
        return proyTags;
    }

    public void setProyTags(ProyectoTags proyTags) {
        this.proyTags = proyTags;
    }

    public String getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(String palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getPalabrasClaves2() {
        return palabrasClaves2;
    }

    public void setPalabrasClaves2(String palabrasClaves2) {
        this.palabrasClaves2 = palabrasClaves2;
    }

    public String getPalabrasClaves3() {
        return palabrasClaves3;
    }

    public void setPalabrasClaves3(String palabrasClaves3) {
        this.palabrasClaves3 = palabrasClaves3;
    }

    public EnvioMailsBean getEnvioMailsBean() {
        return envioMailsBean;
    }

    public void setEnvioMailsBean(EnvioMailsBean envioMailsBean) {
        this.envioMailsBean = envioMailsBean;
    }

    public Boolean getHayCodirector() {
        return hayCodirector;
    }

    public void setHayCodirector(Boolean hayCodirector) {
        this.hayCodirector = hayCodirector;
    }

    public Date getFecha1() {
         System.out.println("seteaeeeerrrr ++++++++++++++++++++++++++++++++++++++++++++++++++"+ fecha1 );
        return fecha1;
        
    }

    public void setFecha1(Date fecha1) {
        System.out.println("setea ++++++++++++++++++++++++++++++++++++++++++++++++++"+ fecha1 );
        this.fecha1 = fecha1;
         System.out.println("setear *********///////////////************************"+ fecha1 );
        
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    public FileUploadController getFileUploadController() {
        return fileUploadController;
    }

    public void setFileUploadController(FileUploadController fileUploadController) {
        this.fileUploadController = fileUploadController;
    }

   

    public void actionBtn() {

        switch (this.getListaProyectoBean().getiActionBtnSelect()) {
            case 0:
                create();
                //limíar campos
                //this.limpiar();
                break;
            case 1:
                this.edit();
                break;
            case 2:
                //deshabilita el campo
                this.activate(Boolean.FALSE);
                break;
            case 3:
                //habilita el campo
                this.activate(Boolean.TRUE);
                break;

        }//fin switch
    }//fin actionBtn

    public void controlCodirector() {

        if (selectedCodir.isEmpty()) {
            this.setHayCodirector(Boolean.FALSE);
        } else {
            this.setHayCodirector(Boolean.TRUE);

        }
    }

    public void setearNotaDeCodirector() {

        this.setNotadeCodirector(Boolean.TRUE);
        System.out.println("LA NOTA DE CODIRECTOR ES ----->>>" + notadeCodirector);
    }

    public void CargarTags() {

        int i = 0;
        int j;

        while (!palabrasClaves2.isEmpty()) {

            System.out.println(":::::::::::::--lo que ingrese es  " + palabrasClaves2 + "--------");
            System.out.println(":::::::::::::--lo que ingrese con TRIM() queda  " + palabrasClaves2.trim() + "--------");
            this.palabrasClaves2 = this.palabrasClaves2.trim();
            System.out.println(":::::::::::::--lo que tiene palabrasClaves2 es  " + palabrasClaves2 + "--------");
            this.palabrasClaves2 = this.palabrasClaves2.concat(" ");
            System.out.println(":::::::::::::--Concatenado con espacio en blanco  " + palabrasClaves2 + "--------");
            j = this.palabrasClaves2.indexOf(" ");
            System.out.println("JJJJJJJJJJJJJJJJJJJJJJ ===" + j);
            // hacer un array y poner los string que se vayan sacando
            this.palabrasClaves3 = this.palabrasClaves2.substring(i, j);
            System.out.println(":::::::::::::--la primera palabra es  " + palabrasClaves3);
            System.out.println(":::::::::::::--lo que queda es  " + this.palabrasClaves2.substring(j));
            this.palabrasClaves2 = this.palabrasClaves2.substring(j + 1);
            this.tags.add(palabrasClaves3);

            System.out.println(":::::::::::::--lo que tiene tags es   " + tags);
        }
        System.out.println(":::::::::::::--NUNCA ENTRO AL FOR !!!!  " + palabrasClaves2);
    }

    public void GuardarTagsenBD() {

        Iterator<String> tag = tags.iterator();
        System.out.println("el archivo es " + tags);
        //System.out.println("el codigo del proyecto es " + proy_ases.getProyecto().getTitulo());

        while (tag.hasNext()) {
            palabrasClaves = tag.next();

            proyTags.setTag(palabrasClaves);
            proyTags.setProyecto(proyecto);
            proy_ases.setProfesional(profesional);
            //realiza el alta en la tabla relacional proy_asesor dependiendo de cuantos asesores se han seleccionado
            proyectoTagRNLocal.create(proyTags);

        }

    }

    public void mostrar1(String[] requisitos) {

        if (requisitos[0].equals("1") && requisitos[1].equals("1") && requisitos[2].equals("1")) {
            System.out.println("pasaasasasasasasassa");
        }
    }

    public void setBtnSelect(ActionEvent e) {
        CommandButton btnSelect = (CommandButton) e.getSource();
        System.out.println("boton select: " + btnSelect.getId());

        //0 crea
        //1: edit
        //2 delete
        //activo el boton
        this.getCbAction().setDisabled(false);

        if (btnSelect.getId().equals("cbNuevo")) {
            this.getCbAction().setValue("Guardar");
            this.getListaProyectoBean().setiActionBtnSelect(0);

            //campos requeridos
            //this.setbCamposRequeridos(true);
        } else if (btnSelect.getId().equals("cbEditar")) {
            this.getCbAction().setValue("Modificar");
            this.getListaProyectoBean().setiActionBtnSelect(1);

            System.out.println("valor del boton: " + listaProyectoBean.getiActionBtnSelect());

            //campos requeridos
            // this.setbCamposRequeridos(true);
        } else if (btnSelect.getId().equals("cbDeshabilitado")) {
            this.getListaProyectoBean().setiActionBtnSelect(2);

            //this.setbCamposEditables(true);
            this.getCbAction().setValue("Desactivar");

        } else if (btnSelect.getId().equals("cbHabilitado")) {
            this.getListaProyectoBean().setiActionBtnSelect(3);

            //this.setbCamposEditables(true);
            this.getCbAction().setValue("Reactivar");

        }

        //fin else
    }//fin setBtnSelect

    public void create() {
        String sMensaje = "";
        String sDetalle = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {

           
            this.CargarTags();
            
            proyecto.setActive(Boolean.TRUE);
             proyecto.setRuta(fileUploadController.destino);

            //selectedAlu = new ArrayList<Alumno>();
            pro = new Proyecto();
            alumno = new Alumno();
            profesional = new Profesional();
            profesionales = new Profesional();
            presentacion = new Presentacion();

            if (selectedAlu.isEmpty()) {
                throw new Exception("Se debe seleccionar al menos un Alumno");
            }
            /*
             if (selectedAses.isEmpty()) {
             throw new Exception("Se debe seleccionar al menos un asesor");
             }
             if (selectedCodir.isEmpty()) {
             throw new Exception("Se debe seleccionar al menos un codirector");
             }*/
            if (tags.isEmpty()) {
                throw new Exception("Se debe ingresar al menos una palabra clave");
            }

            proy_codirecRNbeanLocal.validar(proy_direc.getDocente(), selectedAses, selectedCodir);
           
            if (selectedAlu.isEmpty()) {
                throw new Exception("Ta maaaaaaaaaaaaaaaaaaaaaaaaaaaaal!!!!!!!!!!!!!!!!!!!");
            }

            /*
             --SI HAY UN CODIRECTOR EN EL PROYECTO, VERIFICA TODOS LOS REQUISISTOS INCLUYENDO LA NOTA DE CODIRECTOR
             --SI EL PROYECTO NO TIENE UN CODIRECTOR VERIFICA TODOS LOS REQUISITOS EXCEPTO LA NOTA DE CODIRECTOR
             */
            if (!selectedCodir.isEmpty()) {

               

                // si se cumplen con todos los requisitos el proyecto se da de alta con estado(en proceso de aceptacion de proyecto)
                if ((this.notadeDirector == true || this.notadeCodirector == true) && this.certificado == true && this.notadeAceptacion == true) {
                   //consulta me devuelve el registro del estado igual a 1
                    estado = proyectoRNbeanLocal.findByEstado(1);
                    
                    proyecto.setEstado(estado);
                    //Realiza el alta del proyecto
                    proyectoRNbeanLocal.create(proyecto);

                    presentacion.setProyecto(proyecto);
                    presentacion.setCertificados(this.certificado);
                    presentacion.setNota_aprobacion(this.notadeAceptacion);
                    presentacion.setNota_director(this.notadeDirector);
                    presentacion.setNota_codirector(this.notadeCodirector);
                    presentacion.setFecha(this.proyecto.getFecha_ingreso());
                    presentacion.setRuta(fileUploadController.destino);
                    presentacionRNbeanLocal.create(presentacion);

                    /*
                     Para la carga de las palabras Claves
                     */
                    GuardarTagsenBD();

                    /* --- */
                    sDetalle = "El estado del proyecto es ahora : " + estado.getEstado();
                    /*
                     TO DO
                     Carga de archivo del proyecto (soporte digital)
                     */
                }
            } else {
                if (this.notadeDirector == true && this.certificado == true && this.notadeAceptacion == true) {
                     //consulta me devuelve el registro del estado igual a 1
                    estado = proyectoRNbeanLocal.findByEstado(1);
                   
                    proyecto.setEstado(estado);
                    //Realiza el alta del proyecto
                    proyectoRNbeanLocal.create(proyecto);

                    presentacion.setProyecto(proyecto);
                    presentacion.setCertificados(this.certificado);
                    presentacion.setNota_aprobacion(this.notadeAceptacion);
                    presentacion.setNota_director(this.notadeDirector);
                    presentacion.setNota_codirector(Boolean.FALSE);
                    presentacion.setFecha(this.proyecto.getFecha_ingreso());
                    presentacion.setRuta(fileUploadController.destino);
                    presentacionRNbeanLocal.create(presentacion);

                    /*
                     Para la carga de las palabras Claves
                     */
                    GuardarTagsenBD();

                    /* --- */
                    sDetalle = "El estado del proyecto es ahora : " + estado.getEstado();
                    /*
                     TO DO
                     Carga de archivo del proyecto (soporte digital)
                     */
                }
            }

            // si NO se cumplen con todos los requisitos el proyecto se da de alta con estado(se requiere una nueva presentacion de proyecto)
            /*
             --SI HAY UN CODIRECTOR EN EL PROYECTO, VERIFICA TODOS LOS REQUISISTOS INCLUYENDO LA NOTA DE CODIRECTOR
             --SI EL PROYECTO NO TIENE UN CODIRECTOR VERIFICA TODOS LOS REQUISITOS EXCEPTO LA NOTA DE CODIRECTOR
             */
            if (!selectedCodir.isEmpty()) {
                if (this.notadeDirector == false || this.certificado == false || this.notadeAceptacion == false || this.notadeCodirector == false) {
                    //consulta me devuelve el registro del estado igual a 3
                    estado = proyectoRNbeanLocal.findByEstado(3);
                   
                    proyecto.setEstado(estado);
                    //Realiza el alta del proyecto
                    proyectoRNbeanLocal.create(proyecto);
                    presentacion.setProyecto(proyecto);
                    presentacion.setCertificados(this.certificado);
                    presentacion.setNota_aprobacion(this.notadeAceptacion);
                    presentacion.setNota_director(this.notadeDirector);
                    presentacion.setNota_codirector(this.notadeCodirector);
                    presentacion.setFecha(this.proyecto.getFecha_ingreso());
                    presentacion.setRuta(fileUploadController.destino);
                    presentacionRNbeanLocal.create(presentacion);

                    /*
                     Para la carga de las palabras Claves
                     */
                    GuardarTagsenBD();

                    /* --- */
                    sDetalle = "El estado del proyecto es ahora : " + estado.getEstado();
                    /*
                     TO DO
                     Carga de archivo del proyecto (soporte digital)
                     */
                    /*
                     TO DO
                     Carga de archivo del proyecto (soporte digital)
                     */
                }
            } else {
                if (this.notadeDirector == false || this.certificado == false || this.notadeAceptacion == false) {
                    //consulta me devuelve el registro del estado igual a 3
                    estado = proyectoRNbeanLocal.findByEstado(3);
                  
                    proyecto.setEstado(estado);
                    //Realiza el alta del proyecto
                    proyectoRNbeanLocal.create(proyecto);
                    presentacion.setProyecto(proyecto);
                    presentacion.setCertificados(this.certificado);
                    presentacion.setNota_aprobacion(this.notadeAceptacion);
                    presentacion.setNota_director(this.notadeDirector);
                    presentacion.setNota_codirector(Boolean.FALSE);
                    presentacion.setFecha(this.proyecto.getFecha_ingreso());
                    presentacion.setRuta(fileUploadController.destino);
                    presentacionRNbeanLocal.create(presentacion);

                    /*
                     Para la carga de las palabras Claves
                     */
                    GuardarTagsenBD();

                    /* --- */
                    sDetalle = "El estado del proyecto es ahora : " + estado.getEstado();

                }
            }

            //Consulta me devuelve el codigo del proyecto
            pro = proyectoRNbeanLocal.findProyectoName(proyecto);

            proy_alu.setProyecto(pro);
           

            //recorre el list de los alumnos afectados en el proyecto
            Iterator<Alumno> it = selectedAlu.iterator();
           

            while (it.hasNext()) {
                alumno = it.next();
                
                proy_alu.setAlumno(alumno);

                //realiza el alta en la tabla relacional proy_alumno dependiendo de cuantos alumnos se han seleccionado
                proy_alumnoRNbeanLocal.create(proy_alu);
            }
            //para el alta del registro proy_director************
            proy_direc.setActive(Boolean.TRUE);
            proy_direc.setProyecto(pro);
            proy_directorRNbeanLocal.create(proy_direc);

            //para el alta de registro proy_asesor **************
            proy_ases.setActive(Boolean.TRUE);
            proy_ases.setProyecto(pro);

            //recorre el list de los ascesores afectados en el proyecto
            if (!selectedAses.isEmpty()) {
               
                Iterator<Profesional> as = selectedAses.iterator();
                
               

                while (as.hasNext()) {
                                  

                    profesional = as.next();
                   
                    proy_ases.setProfesional(profesional);
                    //realiza el alta en la tabla relacional proy_asesor dependiendo de cuantos asesores se han seleccionado
                    proy_asesorRNbeanLocal.create(proy_ases);

                }
            }

            //para el alta de registro proy_codirector **************
            if (!selectedCodir.isEmpty()) {
                

                proy_codir.setActive(Boolean.TRUE);
                proy_codir.setProyecto(pro);
                //recorre el list de los codirectores afectados en el proyecto
                Iterator<Profesional> cod = selectedCodir.iterator();
                

                while (cod.hasNext()) {
                    
                    profesionales = cod.next();
                    
                    proy_codir.setProfesional(profesionales);
                    //realiza el alta en la tabla relacional proy_asesor dependiendo de cuantos asesores se han seleccionado
                    proy_codirecRNbeanLocal.create(proy_codir);

                }
            }

            sMensaje = "El Proyecto fue guardado exitosamente";
            severity = FacesMessage.SEVERITY_INFO;
            this.getCbAction().setDisabled(true);
            //agregar a la lista
            this.getListaProyectoBean().getLstProyecto().add(proyecto);

            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgProyecto').hide();");

            this.envioMailsBean.ReporteCambioDeEstado(pro);

            //limpiar campos
            this.limpiar();

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error Aqui: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, sDetalle);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }// fin crear

    public void edit() {
        System.out.println("Entro al edit");
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            //get la fila seleccionada   
            proyecto.setActive(Boolean.TRUE);

            proyectoRNbeanLocal.edit(this.getProyecto());

            sMensaje = "Datos actualizados correctamente";
            severity = FacesMessage.SEVERITY_INFO;

            //elimino y agrego el organismo modificado a la lista
            int iPos = this.getListaProyectoBean().getLstProyecto().indexOf(this.getProyecto());
            this.getListaProyectoBean().getLstProyecto().remove(iPos);
            this.getListaProyectoBean().getLstProyecto().add(iPos, this.getProyecto());

            //this.getCbAction().setValue("Update");
            this.getCbAction().setDisabled(true);

            //  this.setbCamposRequeridos(false);
        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Actualizacion error: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin edit

    public void activate(Boolean bEstado) {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;

        try {

            proyectoRNbeanLocal.activate(this.getProyecto(), bEstado);

            //elimino el organismo de la lista
            int iPos = this.getListaProyectoBean().getLstProyecto().indexOf(this.getProyecto());
            this.setProyecto(this.getListaProyectoBean().getLstProyecto().get(iPos));
            this.getProyecto().setActive(bEstado);
            this.getListaProyectoBean().getLstProyecto().remove(iPos);
            this.getListaProyectoBean().getLstProyecto().add(iPos, this.getProyecto());

            if (!bEstado) {
                sMensaje = "Proyecto deshabilitado correctamente";
            } else {
                sMensaje = "Proyecto habilitado correctamente";
            }
            severity = FacesMessage.SEVERITY_INFO;

            this.getCbAction().setDisabled(true);

            //limíar campos
            this.clear();
            // this.setbCamposRequeridos(false);

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Ocurrio un error durante la operacion: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin recuperar
    
     public void cargarProyectosAprobados() {
         
        try {
            
            this.setLstProyectosAprobados(this.defensafinalRNbeanLocal.findProyAprobados(this.fecha1, this.fecha2));
           
        } catch (Exception ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error: " + ex.getMessage(), null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }

    }
 public void setear(long idProyecto) {
        Connection conect;
        
        
        
        
        try {
            conect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tfs-ftyca", "postgres", "123456");
        String path;
        //List<Object[]> l = turnoRNLocal.findHistorialTurnosServicios(1, this.getFechaInicio(), this.getFechaFin());
        
        
            path = "reports\\reporteProyecto.jasper";
            FacesContext context = FacesContext.getCurrentInstance();
            System.out.println("entrooooooooooooooooooooooooooooooo1"+path);
            String reportPath = context.getExternalContext().getRealPath(path);
           
           

            HashMap parametro = new HashMap();
            System.out.println("entrooooooooooooooooooooooooooooooo3"+reportPath);
            parametro.put("titulo", "Estados");
            parametro.put("idProyecto",idProyecto);
            parametro.put("SUBREPORT_DIR", rutaReporte+"\\");

            System.out.println("entroooooooooooo000oooooooooooooooo4" + parametro);
        
            /*
            System.out.println("RUTA DE LA IMAGEN DEL ESCUDO --->" +this.getClass().getResourceAsStream(escudo));
            FacesContext context = FacesContext.getCurrentInstance();
            String reportPath = context.getExternalContext().getRealPath("/reportes/" + nombreReporte);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parametros, conect); //new JREmptyDataSource() si le pongo eso en vez de conect me devuelve null
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "filename=reporte.pdf");
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            servletOutputStream.flush();
            servletOutputStream.close();
            FacesContext.getCurrentInstance().responseComplete();
            */
            

            JRBeanCollectionDataSource beanCollectionDataSource = null;
            System.out.println("entroooooooooooooooooooooooooooo5" + parametro);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parametro, conect);
            System.out.println("entroooooooooooooooooooooooooooo5.1" + parametro);
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "filename=reporte.pdf");
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            servletOutputStream.flush();
            servletOutputStream.close();
            FacesContext.getCurrentInstance().responseComplete();
             
        } catch (Exception ex) {
             System.out.println(ex + "CAUSAaaaaaaaaaaaaaaaaaaaaaa: " + ex.getCause().getMessage());
        }

    }
 
 public void generar(String nombreReporte, Proyecto pro, Docente docente, Integer op, Integer num_estado,String estado, Carrera carrera, Date fecha_1, Date fecha_2) throws SQLException {

        Connection conect;
        conect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tfs-ftyca", "postgres", "AND2015belgrano");
        
        
       
        System.out.println("funcionando       ." +rutaReporte);

        try {
            System.out.println("NOOO entro al if---000" +rutaReporte +docente + nombreReporte + pro+ op+ num_estado+ estado +"carreraaa --->"+ carrera);
           HashMap parametro = new HashMap();
            parametro.put("escudo1",escudo1 );
            parametro.put("escudo2",escudo2 );
            System.out.println("0");
          if(op.equals(0)){
              System.out.println("1");
            parametro.put("titulo", "Estados");
            parametro.put("idProyecto",pro.getId());
            parametro.put("SUBREPORT_DIR", rutaReporte+"/");
          }
            if(op.equals(1)){
                 System.out.println("2");
                 System.out.println("entro al if---000" +rutaReporte +docente + nombreReporte + pro);
                parametro.put("Docente",docente.getId());
            parametro.put("nombre_docente",docente.getApellido() + " , " +docente.getNombre() );
            
            parametro.put("SUBREPORT_DIR",sub_report1+"/" );
           parametro.put("sub_report2",sub_report2 );
           parametro.put("sub_report3",sub_report3 );
          } 
          if(op.equals(2)){
               System.out.println("3");
              System.out.println("ENTROOOOOOOOOOOOOO AL IFFFFFFFFFFFFFFFF");
              parametro.put("numero_estado", num_estado);
            parametro.put("estado",estado );
            
          }
          if(op.equals(3)){
               System.out.println("4");
              parametro.put("nombre_carrera",carrera.getCarrera());
            parametro.put("carrera",carrera.getId());
            
          }
          if(op.equals(99)){
              parametro.put("fecha1",fecha_1);
            parametro.put("fecha2",fecha_2);
          }
       System.out.println("Hasta aca llegooo");
            FacesContext context = FacesContext.getCurrentInstance();
            String reportPath = context.getExternalContext().getRealPath("/reports/" + nombreReporte);
            System.out.println("funcionando reportPath es::       ." +rutaReporte);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parametro, conect); //new JREmptyDataSource() si le pongo eso en vez de conect me devuelve null
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "filename=reporte.pdf");
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            servletOutputStream.flush();
            servletOutputStream.close();
            FacesContext.getCurrentInstance().responseComplete();

        } catch (Exception ex) {
            System.out.println(ex + "CAUSA: " + ex.getCause());

        }
        //limpiar();
    }//fin generar  
    private void limpiar() {
        this.proyecto = new Proyecto();
    }

    private void clear() {
        this.setProyecto(new Proyecto());

    }//fin limpiar
}
