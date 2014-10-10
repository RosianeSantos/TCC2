/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;


import TFD.DomainModel.Especialidade;
import TFD.DomainModel.EspecialidadeRepositorio;
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
@Named(value = "especialidadeConverter")
@SessionScoped
public class EspecialidadeConverter implements Serializable, Converter {
    
    
    public EspecialidadeConverter() {
    }

     @EJB
     EspecialidadeRepositorio daoEspecialidade;

  
    public List<Especialidade> AutoCompleteFuncionario (String query){
        Especialidade filtro = new Especialidade();
        filtro.setNome(query);
        return daoEspecialidade.Buscar(filtro);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      if (value == null || value.toString().equals("")){
          return "";
      } else{
          Especialidade e = (Especialidade)value;
          return e.getIdEspecialidade().toString();
      } 
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")){
            return null;
        }else{
            Long id= Long.parseLong(value);
            return daoEspecialidade.Abrir(id);
        }
    }
    
}
