/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 *
 * @author USUARIO
 */
@Entity
public class upload_image implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long image_id;
    private String image_name;
    @Lob
    private byte[] image;

    public Long getImage_id() {
        return image_id;
    }

    public void setImage_id(Long image_id) {
        this.image_id = image_id;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
    
    
   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (image_id != null ? image_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof upload_image)) {
            return false;
        }
        upload_image other = (upload_image) object;
        if ((this.image_id == null && other.image_id != null) || (this.image_id != null && !this.image_id.equals(other.image_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.upload_image[ id=" + image_id + " ]";
    }
    
}
