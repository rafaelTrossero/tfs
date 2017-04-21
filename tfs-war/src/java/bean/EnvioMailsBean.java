/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.DocenteComisionRNLocal;
import RN.ProyectoAlumnoRNLocal;
import RN.ProyectoAsesorRNLocal;
import RN.ProyectoCodirectorRNLocal;
import RN.ProyectoDirectorRNLocal;
import entidad.CronogramaActividad;
import entidad.Docente;
import entidad.Proyecto;
import entidad.ProyectoAlumno;
import entidad.ProyectoAsesor;
import entidad.ProyectoCodirector;
import entidad.ProyectoDirector;
import java.io.File;
import java.io.Serializable;
//import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author RafaTrossero
 */
@ManagedBean
@SessionScoped
public class EnvioMailsBean implements Serializable {

    /**
     * Creates a new instance of EnvioMailsBean
     */
    @EJB
    private DocenteComisionRNLocal DocenteComisionRNbeanLocal;

    @EJB
    private ProyectoAlumnoRNLocal proyAluRNLocal;

    @EJB
    private ProyectoAsesorRNLocal proyAsesRNLocal;

    @EJB
    private ProyectoCodirectorRNLocal proyCodRNLocal;

    @EJB
    private ProyectoDirectorRNLocal proyDirRNLocal;

    private List<Docente> comisionSeg;
    private Docente docComisionSeg;
    private List<String> mails;

    private List<ProyectoAlumno> proyAlu;
    private List<ProyectoAsesor> proyAse;
    private List<ProyectoCodirector> proyCod;
    private ProyectoDirector proyDir;
    private String correos;
    private String cuerpoMensaje;
    private Date fechaActual;

    // Variables para el envio de mail con formato html
    /**
     * Variables.
     */
    private Properties props = new Properties();

    private String from, to, subject;
    private final String logoDepto = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/Imagenes/logo_deptoxs.jpg");
    /**
     * MultiPart para crear mensajes compuestos.
     */
    MimeMultipart multipart = new MimeMultipart("related");

    // fin
    public EnvioMailsBean() {

        this.proyAlu = new ArrayList<ProyectoAlumno>();
        this.proyDir = new ProyectoDirector();
        this.proyAse = new ArrayList<ProyectoAsesor>();
        this.proyCod = new ArrayList<ProyectoCodirector>();
        mails = new ArrayList<String>();
        this.docComisionSeg = new Docente();
        correos = new String();
    }

    public List<Docente> getComisionSeg() {
        return comisionSeg;
    }

    public void setComisionSeg(List<Docente> comisionSeg) {
        this.comisionSeg = comisionSeg;
    }

    public ProyectoDirectorRNLocal getProyDirRNLocal() {
        return proyDirRNLocal;
    }

    public void setProyDirRNLocal(ProyectoDirectorRNLocal proyDirRNLocal) {
        this.proyDirRNLocal = proyDirRNLocal;
    }

    public Docente getDocComisionSeg() {
        return docComisionSeg;
    }

    public void setDocComisionSeg(Docente docComisionSeg) {
        this.docComisionSeg = docComisionSeg;
    }

    public List<String> getMails() {
        return mails;
    }

    public void setMails(List<String> mails) {
        this.mails = mails;
    }

    public List<ProyectoAlumno> getProyAlu() {
        return proyAlu;
    }

    public void setProyAlu(List<ProyectoAlumno> proyAlu) {
        this.proyAlu = proyAlu;
    }

    public List<ProyectoAsesor> getProyAse() {
        return proyAse;
    }

    public void setProyAse(List<ProyectoAsesor> proyAse) {
        this.proyAse = proyAse;
    }

    public List<ProyectoCodirector> getProyCod() {
        return proyCod;
    }

    public void setProyCod(List<ProyectoCodirector> proyCod) {
        this.proyCod = proyCod;
    }

    public ProyectoDirector getProyDir() {
        return proyDir;
    }

    public void setProyDir(ProyectoDirector proyDir) {
        this.proyDir = proyDir;
    }

    public String getCorreos() {
        return correos;
    }

    public void setCorreos(String correos) {
        this.correos = correos;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) throws InstantiationException, IllegalAccessException {
        this.fechaActual = Date.class.newInstance();
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public MimeMultipart getMultipart() {
        return multipart;
    }

    public void setMultipart(MimeMultipart multipart) {
        this.multipart = multipart;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCuerpoMensaje() {
        return cuerpoMensaje;
    }

    public void setCuerpoMensaje(String cuerpoMensaje) {
        this.cuerpoMensaje = cuerpoMensaje;
    }

    public void ReporteCambioDeEstado(Proyecto pro) {

        try {

            /*
             Buscar comision de seguimiento
             */
            System.out.println("++++++++++++ENTRO A REPORTE CAMBIO DE ESTADOOOOOOOO++++++");
            try {
                this.setComisionSeg(this.DocenteComisionRNbeanLocal.findDocentesbyComision(1));
            } catch (Exception ex) {
                Logger.getLogger(ListaCronogramaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("LA COMISION ES ###############" + comisionSeg);
            /*
             Recuperar mail de docentes de la comision de seguimiento
             */
            Iterator<Docente> mailDoc = comisionSeg.iterator();

            while (mailDoc.hasNext()) {
                docComisionSeg = mailDoc.next();
                this.mails.add(docComisionSeg.getEmail());
            }

            /*
             Recuperar mail de alumnos del proyecto
             */
            this.setProyAlu(this.proyAluRNLocal.findByProyAlumno(pro));

            Iterator<ProyectoAlumno> mailAlu = proyAlu.iterator();

            while (mailAlu.hasNext()) {

                ProyectoAlumno aluProyecto = mailAlu.next();

                this.mails.add(aluProyecto.getAlumno().getEmail());
            }

            /*
             Recuperar mail de direcotr del proyecto
             */
            this.setProyDir(this.proyDirRNLocal.findProyDirectorActivo(pro, true));

            this.mails.add(proyDir.getDocente().getEmail());

            /*
             Recuperar mail de Co-direcotr del proyecto
             */
            this.setProyCod(this.proyCodRNLocal.findByProyCodirector(pro, true));

            Iterator<ProyectoCodirector> mailCod = proyCod.iterator();

            while (mailCod.hasNext()) {

                ProyectoCodirector codProyecto = mailCod.next();

                this.mails.add(codProyecto.getProfesional().getEmail());
            }

            /*
             Recuperar mail de asesores del proyecto
             */
            this.setProyAse(this.proyAsesRNLocal.findByProyAsesor(pro, true));

            Iterator<ProyectoAsesor> mailAse = proyAse.iterator();

            while (mailAse.hasNext()) {

                ProyectoAsesor aseProyecto = mailAse.next();

                this.mails.add(aseProyecto.getProfesional().getEmail());
            }

            System.out.println("LOS MAILS SOOON!!!! --->" + mails + pro.getEstado().getEstado());
            System.out.println("LOS MAILS CON EL toString() SOOON!!!! --->" + mails.toString());

        } catch (Exception ex) {
            Logger.getLogger(EnvioMailsBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

                System.out.println("POR ENTRAR A CARGAR LOS MAILS!!!" + mails.size() +"rutaaaaaaaaa" + pro.getRuta());
            for (int i = 0; i < mails.size(); i++) {
                System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii!!!" + i);
                correos = correos.concat(mails.get(i));

                System.out.println("ENTRO A CARGAR LOS MAILS!!!" + mails.get(i));
                if (i != mails.size() - 1) {
                    correos = correos.concat(", ");
                }
                System.out.println("LOS MAILS SONNNN!!!" + correos);
            }
            // Propiedades de la conexión
            System.out.println("DURANTE de enviar mail");

           /*Contruimos el texto del mensaje*/
            if(pro.getEstado().getId().equals(1L)){
                this.setCuerpoMensaje("Estimado, le informamos que el proyecto <br><b>"
                        + pro.getTitulo() + "</b>,  del cual forma parte ha sido dado de alta en el "
                        + "sistema de seguimiento de trabajos finales. <br> Actualmente su estado es: <b>" 
                        + pro.getEstado().getEstado() + "</b>. <br> Se adjunta el archivo pdf del proyecto presentado. Saludos");
               
            }else{
                this.setCuerpoMensaje("Estimado, le informamos que el proyecto <b>" + pro.getTitulo() + "</b> del cual forma parte ha cambiado su estado a: <b>" + pro.getEstado().getEstado() +"</b>");
            }
            
            
            
            List<String> adjuntos = new ArrayList<String>();
            adjuntos.add(pro.getRuta());
            enviarMailHtml("tfs.tecno@gmail.com", correos, "Prueba", cuerpoMensaje, adjuntos);
            System.out.println("La lista de adjuntos es " + adjuntos  );
            limpiar();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("DESPUES de enviar mail");

    }

    public void NotificarRetrasoActividad(CronogramaActividad crono) throws InstantiationException, IllegalAccessException {
        //setFechaActual(Date.from(Instant.EPOCH));
        setFechaActual(Date.class.newInstance());
        System.out.println("++++++++++++ENTRO A NOTIFICAR RETRASO++++++" + this.fechaActual.getTime());

        System.out.println("++++++++++++ENTRO A NOTIFICAR RETRASO++++++" + crono.getFecha_fin().getTime());

        int diferencia = (int) (this.fechaActual.getTime() - crono.getFecha_fin().getTime());
        try {
            this.setComisionSeg(this.DocenteComisionRNbeanLocal.findDocentesbyComision(1));
        } catch (Exception ex) {
            Logger.getLogger(ListaCronogramaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("aaaaaaaaaaaaaaaaaaaaaa" + crono.getFecha_fin());
        System.out.println("LA COMISION ES ###############" + comisionSeg);
        /*
         Recuperar mail de docentes de la comision de seguimiento
         */
        Iterator<Docente> mailDoc = comisionSeg.iterator();

        while (mailDoc.hasNext()) {
            docComisionSeg = mailDoc.next();
            this.mails.add(docComisionSeg.getEmail());
        }
        try {

            // Propiedades de la conexión
            System.out.println("DURANTE de enviar mail");

            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "departamentoinformaticaunca@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("departamentoinformaticaunca@gmail.com"));

            System.out.println("POR ENTRAR A CARGAR LOS MAILS!!!" + mails.size());
            for (int i = 0; i < mails.size(); i++) {
                System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii!!!" + i);
                correos = correos.concat(mails.get(i));

                System.out.println("ENTRO A CARGAR LOS MAILS!!!" + mails.get(i));
                if (i != mails.size() - 1) {
                    correos = correos.concat(", ");
                }
                System.out.println("LOS MAILS SONNNN!!!" + correos);
            }
            message.addRecipients(Message.RecipientType.TO, correos);

            message.setSubject("Departamento Informatica");
            message.setText("Hola hay un retraso de " + diferencia + " en la actividad N° " + crono.getNumero() + ": " + crono.getDescripcion_act() + " del proyecto: " + crono.getCronograma().getProyecto().getTitulo() + ".");

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("departamentoinformaticaunca@gmail.com", "LabUnca2011");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
            limpiar();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("DESPUES de enviar mail");
    }

    

    public void enviarMailHtml(String from, String to, String subject, String body, List<String> adjuntos) throws Exception {
        // propiedades de conexion al servidor de correo
        this.from = from;
        this.subject = subject;
        this.to = to;

        // para envio de formulario
        String ipServidor = "170.210.142.40";
        String puertoServidor = "8080";
        String nombreAplicacion = "tfs-war";
        String pagina = "login.xhtml";
        // fin

        String cabecera = "<HTML><BODY><img src='cid:cidcabecera' /> <br/> <br/>";
        String pie = "<br/> <br/> <img src='cid:cidpie' /></BODY></HTML>";

        String boton = "<table><tr><td><form method='post' target='blank' action='http://" + ipServidor + ":" + puertoServidor + "/" + nombreAplicacion + "/" + pagina + "'> <input name='miBoton' type='submit' value='Ir al sistema' /></form>";
        String formulario = String.format("%s%s%s%s%s", cabecera, body, "<br/> <br/>", boton, pie);

        addContent(formulario);

        //añadir imagenes
      //  addCID("cidcabecera", "c:/logo_depto.jpg");
        System.out.println("+++++++++++++++------>" +logoDepto);
        addCID("cidpie", logoDepto);

        // enviar adjuntos
        if (adjuntos != null) {
            for (String adjunto : adjuntos) {
                addAttach(adjunto); //ruta donde se encuentra el fichero que queremos adjuntar.
            }
        }

        // enviar el correo MULTIPART
        sendMultipart();
    }

    public void addContent(String htmlText) throws Exception {
        // first part (the html)
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(htmlText, "text/html");
        // add it
        this.multipart.addBodyPart(messageBodyPart);
    }

    public void addCID(String cidname, String pathname) throws Exception {
        DataSource fds = new FileDataSource(pathname);
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setHeader("Content-ID", "<" + cidname + ">");
        this.multipart.addBodyPart(messageBodyPart);
    }

    public void addAttach(String pathname) throws Exception {
        File file = new File(pathname);
        BodyPart messageBodyPart = new MimeBodyPart();
        DataSource ds = new FileDataSource(file);
        messageBodyPart.setDataHandler(new DataHandler(ds));
        messageBodyPart.setFileName(file.getName());
        messageBodyPart.setDisposition(Part.ATTACHMENT);
        this.multipart.addBodyPart(messageBodyPart);
    }

    public void sendMultipart() throws Exception {

        Properties props1 = new Properties();
        props1.setProperty("mail.smtp.host", "smtp.gmail.com");
        props1.setProperty("mail.smtp.starttls.enable", "true");
        props1.setProperty("mail.smtp.port", "587");
        props1.setProperty("mail.smtp.user", "departamentoinformaticaunca@gmail.com");
        props1.setProperty("mail.smtp.auth", "true");

        // Preparamos la sesion
        Session session = Session.getInstance(props1);
        // Construimos el mensaje
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("tfs.tecno@gmail.com"));

        message.addRecipients(Message.RecipientType.TO, correos);

        message.setSubject("Departamento Informatica");

        // Send the complete message parts
        message.setContent(multipart);
        // Lo enviamos.
        Transport t = session.getTransport("smtp");
        t.connect("tfs.tecno@gmail.com", "tfs123456");
        
        System.out.println("Las direcciones de los destinatarios son:" + message.getAllRecipients().toString());
        t.sendMessage(message, message.getAllRecipients());

        t.close();
        
      limpiar();
        
    }

    private void limpiar() {
        this.proyAlu = new ArrayList<ProyectoAlumno>();
        this.proyDir = new ProyectoDirector();
        this.proyAse = new ArrayList<ProyectoAsesor>();
        this.proyCod = new ArrayList<ProyectoCodirector>();
        mails = new ArrayList<String>();
        this.docComisionSeg = new Docente();
        correos = new String();
        cuerpoMensaje = new String();
        
    }
 
}
