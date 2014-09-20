/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;

import TFD.DomainModel.Funcionario;
import TFD.DomainModel.FuncionarioRepositorio;
import java.io.Serializable;
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
@Named(value = "funcionarioConverter")
@SessionScoped
public class FuncionarioConverter implements Serializable, Converter {
    
    @EJB
    FuncionarioRepositorio daoFuncionario;

    /**
     * Creates a new instance of FuncionarioConverter
     */
    public FuncionarioConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return daoFuncionario.Abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      if (value == null || value.toString().equals("")){
          return "";
      } else{
          Funcionario f = (Funcionario)value;
          return f.getId().toString();
      } 
    }
}
