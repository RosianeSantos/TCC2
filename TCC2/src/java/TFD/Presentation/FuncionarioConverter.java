/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;

import TFD.DomainModel.Funcionario;
import TFD.DomainModel.FuncionarioRepositorio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import static javax.management.Query.value;
import org.primefaces.component.autocomplete.AutoComplete;

/**
 *
 * @author Rosy
 */
@Named(value = "funcionarioConverter")
@SessionScoped
public class FuncionarioConverter implements Serializable, Converter {
    
   
    /**
     * Creates a new instance of FuncionarioConverter
     */
    public FuncionarioConverter() {
    }

     @EJB
    FuncionarioRepositorio daoFuncionario;

  
    public List<Funcionario> AutoCompleteFuncionario (String query){
        Funcionario filtro = new Funcionario();
        filtro.setNome(query);
        return daoFuncionario.Buscar(filtro);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      if (value == null || value.toString().equals("")){
          return "";
      } else{
          Funcionario f = (Funcionario)value;
          return f.getIdFuncionario().toString();
      } 
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")){
            return null;
        }else{
            Long id= Long.parseLong(value);
            return daoFuncionario.Abrir(id);
        }
    }

}