package bean;


import java.io.Serializable;
import org.primefaces.model.UploadedFile;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

@ManagedBean(name="UPLOADController")
@SessionScoped
public class FileUploadManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private UploadedFile file;
	
	public void handleFileUpload(FileUploadEvent event) {
		System.out.println("Uploaded: {}" + event.getFile().getFileName()) ;

		FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		System.out.println("Uploaded: {}" ) ;
		this.file = file;
	}
}
