/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DataAcess;

import TFD.DomainModel.Funcionario;
import TFD.DomainModel.FuncionarioRepositorio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rosy
 */
@Stateless(name = "FuncionarioRepositorio")
public class FuncionarioDAO 

    extends DAOGenerico<Funcionario>
    implements FuncionarioRepositorio{
    
     public FuncionarioDAO() {
        super(Funcionario.class);
    }

    public FuncionarioDAO(Class t) {
        super(t);
    }
    @Override
    public List<Funcionario> Buscar(Funcionario obj) {
        String sql = "select f from Funcionario f";
        
        String filtros = "";
        
        if(obj != null ){
            if(obj.getId() != null && obj.getId() > 0 ){
                filtros += "f.id = " + obj.getId();
            }
            if(obj.getNome() != null){
                if(filtros.length() > 0)
                    filtros += " and ";
                filtros += "f.nome like '%" + obj.getNome() + "%'"; 
            }
    }
         if(filtros.length() > 0){
            sql += " where " + filtros;

    }
  
         Query consulta = manager.createQuery(sql);
        
        return consulta.getResultList();
}
}