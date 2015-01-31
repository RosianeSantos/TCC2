/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DataAcess;

import TFD.DomainModel.Usuario;
import TFD.DomainModel.UsuarioRepositorio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rosy
 */
@Stateless(name="UsuarioRepositorio")
public class UsuarioDAO

    extends DAOGenerico<Usuario>
    implements UsuarioRepositorio{
    
     public UsuarioDAO() {
        super(Usuario.class);
    }
    
     @Override
    public List<Usuario> Buscar(Usuario obj) {
        String sql = "select u from Usuario u";
        
        String filtros = "";
        
        if(obj != null ){
            if(obj.getId() != null && obj.getId() > 0 ){
                filtros += "u.id = " + obj.getId();
            }
            if(obj.getNome() != null){
                if(filtros.length() > 0)
                    filtros += " and ";
                filtros += "u.nome like '%" + obj.getNome() + "%'"; 
            }
            //if(obj.getCpf() != null){
              //  if(filtros.length() > 0)
                //    filtros += " and ";
               // filtros += "a.cpf like '%" + obj.getCpf() + "%'"; 
           // }
        }
        
        if(filtros.length() > 0){
            sql += " where " + filtros;
        }
        
        Query consulta = manager.createQuery(sql);
        
        return consulta.getResultList();
    }
}
