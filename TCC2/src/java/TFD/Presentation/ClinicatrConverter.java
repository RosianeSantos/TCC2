/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;


import TFD.DomainModel.Clinicatr;
import TFD.DomainModel.ClinicatrRepositorio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author Rosy
 */
@Named(value = "clinicatrConverter")
@SessionScoped
public class ClinicatrConverter implements Serializable, Converter {
    
     public ClinicatrConverter() {
    }

     @EJB
     ClinicatrRepositorio daoClinicatr;

  
    public List<Clinicatr> AutoCompleteFuncionario (String query){
        Clinicatr filtro = new Clinicatr();
        filtro.setNomeClinicatr(query);
        return daoClinicatr.Buscar(filtro);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      if (value == null || value.toString().equals("")){
          return "";
      } else{
          Clinicatr cl = (Clinicatr)value;
          return cl.getIdClinicatr().toString();
      } 
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")){
            return null;
        }else{
            Long id= Long.parseLong(value);
            return daoClinicatr.Abrir(id);
        }
    }
    
    
}
