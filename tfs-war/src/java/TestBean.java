
import entidad.Catedra;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "mbean")
@ViewScoped
public class TestBean implements Serializable {

  
    private Catedra selectedCatedra;

    public TestBean() {
        

    }

   

    public Catedra getSelectedCatedra() {
        return selectedCatedra;
    }

    public void setSelectedCatedra(Catedra selectedCatedra) {
        System.out.println("selected" + selectedCatedra);
        this.selectedCatedra = selectedCatedra;
    }

}