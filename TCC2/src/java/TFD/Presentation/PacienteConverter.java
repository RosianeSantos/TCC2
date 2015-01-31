/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;


import TFD.DomainModel.Paciente;
import TFD.DomainModel.PacienteRepositorio;
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
@Named(value = "pacienteConverter")
@SessionScoped
public class PacienteConverter implements Serializable, Converter  {
    
    
    public PacienteConverter() {
    }

     @EJB
     PacienteRepositorio daoPaciente;

  
    public List<Paciente> AutoCompletePaciente (String query){
        Paciente filtro = new Paciente();
        filtro.setNomePaciente(query);
        return daoPaciente.Buscar(filtro);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      if (value == null || value.toString().equals("")){
          return "";
      } else{
          Paciente p = (Paciente)value;
          return p.getIdPaciente().toString();
      } 
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")){
            return null;
        }else{
            Long id= Long.parseLong(value);
            return daoPaciente.Abrir(id);
        }
    }
}
