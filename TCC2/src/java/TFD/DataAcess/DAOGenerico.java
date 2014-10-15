/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DataAcess;

import TFD.DomainModel.Repositorio;
import TFD.DomainModel.Entidade;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.swing.JOptionPane;

/**
 *
 * @author Rosy
 *
 */
public abstract class DAOGenerico<T extends Entidade> implements Repositorio<T> {
  
    @PersistenceContext(name = "TCC2PU")
    protected EntityManager manager;
    
    
    private Class tipo;
    public DAOGenerico (Class t) {
        tipo = t;
    }
    
    
    @Override
    public T Refresh(Long id) {
        manager.flush();
        return (T) manager.getReference(tipo, id);
    }
 
    @Override
    public boolean Salvar(T obj) {
       try{
            if(manager.contains(obj) || (obj.getId() != null && obj.getId() > 0)) {
                obj = manager.merge(obj);
            }
            else {
                manager.persist(obj);
            }
            
            manager.flush();
            
            return true;
        }catch (Exception ex){
        System.out.println(ex.getMessage());
        return false;
        }
    }
    
          
    
    @Override
    public T Abrir(Long id) {
        try {
            T obj = (T) manager.find(tipo, id);
            return obj;
            //abrir
        } catch (Exception ex) {
            return null;
        }
    }
    
    
    @Override
      public abstract List<T> Buscar(T obj);

    @Override
    public boolean Apagar(T obj) {
        try {
            manager.remove(manager.merge(obj));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
   
    
    
}

