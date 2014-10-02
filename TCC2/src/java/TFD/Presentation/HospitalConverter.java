/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;

import TFD.DomainModel.Funcionario;
import TFD.DomainModel.FuncionarioRepositorio;
import TFD.DomainModel.Hospital;
import TFD.DomainModel.HospitalRepositorio;
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
@Named(value = "hospitalConverter")
@SessionScoped
public class HospitalConverter implements Serializable, Converter{
    
    
    /**
     * Creates a new instance of HospitalConverter
     */
    public HospitalConverter() {
    }

     @EJB
     HospitalRepositorio daoHospital;
     
     
     public List<Hospital> AutoCompleteHospitals (String query){
        Hospital filtro = new Hospital();
        filtro.setNome(query);
        return daoHospital.Buscar(filtro);
    }
     
      @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      if (value == null || value.toString().equals("")){
          return "";
      } else{
          Hospital h = (Hospital)value;
          return h.getId().toString();
      } 
    }

     
      @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")){
            return null;
        }else{
            Long id= Long.parseLong(value);
            return daoHospital.Abrir(id);
        }
    }
     
     
}
