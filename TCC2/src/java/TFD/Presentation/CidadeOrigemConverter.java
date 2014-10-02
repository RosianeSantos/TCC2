/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Presentation;

import TFD.DomainModel.Cidade;
import TFD.DomainModel.Funcionario;
import TFD.DomainModel.FuncionarioRepositorio;
import TFD.DomainModel.ICidadeRepositorio;
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
@Named(value = "cidadeorigemConverter")
@SessionScoped
public class CidadeOrigemConverter implements Serializable, Converter{
    
    /**
     * Creates a new instance of CidadeConverter
     */
    public CidadeOrigemConverter(){
    }

     @EJB
     ICidadeRepositorio daoCidade;
    
     
     public List<Cidade> AutoCompleteFuncionario (String query){
        Cidade filtro = new Cidade();
        filtro.setNome(query);
        return daoCidade.Buscar(filtro);
    }
     
     
     @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      if (value == null || value.toString().equals("")){
          return "";
      } else{
          Cidade c = (Cidade)value;
          return c.getIdCidade().toString();
      } 
    }
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")){
            return null;
        }else{
            Long id= Long.parseLong(value);
            return daoCidade.Abrir(id);
        }
    }
}
