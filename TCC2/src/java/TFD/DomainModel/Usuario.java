/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DomainModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

/**
 *
 * @author Rosy
 */
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
public class Usuario implements Entidade, Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //Dados Aluno/Orientador    
  
    private String nome;
    
    private String senha;
    
    //Verificar RELACIONAMENTOS    
    
    @ManyToMany(cascade= CascadeType.ALL) 
    private List<Email> email;
    
    
    public Usuario() {
        id = 0L;
        this.email = new ArrayList<Email>();
    }

    
    public void addEmail(Email e){
        if(email == null)
            email = new ArrayList<Email>();
        if(!email.contains(e)){
            email.add(e);
        }
        
    }
    
    public void removeEmail(Email e){
        if(email.contains(e)){
            email.remove(e);
        }
    }
    
    
  
   //GETTER E SETTER

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Email> getEmail() {
        return email;
    }

    public void setEmail(List<Email> email) {
        this.email = email;
    }

    
      
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {        
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
}
