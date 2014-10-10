/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DataAcess;

import TFD.DomainModel.Paciente;
import TFD.DomainModel.PacienteRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rosy
 */
@Stateless(name = "PacienteRepositorio")
public class PacienteDAO 
            extends DAOGenerico<Paciente>
        implements PacienteRepositorio{
    
    
    public PacienteDAO() {
        super(Paciente.class);
    }

    
    @Override
    public List<Paciente> Buscar(Paciente obj) {
        // Corpo da consulta
        String consulta = "select p from Paciente p";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            if (obj.getNome() != null && obj.getNome().length() > 0) {
                filtro += " lower(f.nome) like lower('%" + obj.getNome() + "%')";                
            }

            if (obj.getEndereco()!= null && obj.getEndereco().length() > 0) {
                if (filtro.length() > 0) {
                    filtro += " and ";
                }
                filtro += " p.endereco=:endereco ";
                parametros.put("endereco", obj.getEndereco());
            }

            if (obj.getIdPaciente()!= null && obj.getIdPaciente()> 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " p.idPaciente =:idPaciente";
                parametros.put("idPaciente", obj.getIdPaciente());
            }

            if (obj.getComplemento()!= null && obj.getComplemento().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " p.complemento=:complemento";
                parametros.put("complemento", obj.getComplemento());
            }
            
            if (obj.getNumero()!= null && obj.getNumero().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " p.numero=:numero";
                parametros.put("numero", obj.getNumero());
            }
            
            if (obj.getCep()!= null && obj.getCep().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " p.cep=:cep";
                parametros.put("cep", obj.getCep());
            }
            
            if (obj.getTelefoneR()!= null && obj.getTelefoneR().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " p.telefoneR=:telefoneR";
                parametros.put("telefoneR", obj.getTelefoneR());
            }
            
            if (obj.getTelefoneC()!= null && obj.getTelefoneC().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " p.telefoneC=:telefoneC";
                parametros.put("telefoneC", obj.getTelefoneC());
            }
            
            
            if (obj.getTelefoneCelular()!= null && obj.getTelefoneCelular().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " p.telefoneCelular=:telefoneCelular";
                parametros.put("telefone", obj.getTelefoneCelular());
            }
            
            
            if (obj.getSexo()!= null && obj.getSexo().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " p.sexo=:sexo";
                parametros.put("sexo", obj.getSexo());
            }
            
            
            if (obj.getCpf()!= null && obj.getCpf().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " p.cpf=:cpf";
                parametros.put("cpf", obj.getCpf());
            }
            
            if (obj.getRg()!= null && obj.getRg().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " p.rg=:rg";
                parametros.put("rg", obj.getRg());
            }

           // Se houver filtros, coloca o "where" na consulta
            if (filtro.length() > 0) {
                consulta = consulta + " where " + filtro;
            }
        }

        // Cria a consulta no JPA
        Query query = manager.createQuery(consulta);

        // Aplica os parâmetros da consulta
        for (String par : parametros.keySet()) {
            query.setParameter(par, parametros.get(par));
        }

        // Executa a consulta
        return query.getResultList();

    }
    
   
   
}
