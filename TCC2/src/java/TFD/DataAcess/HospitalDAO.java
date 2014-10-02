/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.DataAcess;



import TFD.DomainModel.Hospital;
import TFD.DomainModel.HospitalRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rosy
 */

@Stateless(name = "HospitalRepositorio")
public class HospitalDAO 
            extends DAOGenerico<Hospital>
        implements HospitalRepositorio{
    
    
    public HospitalDAO() {
        super(Hospital.class);
    }
    
    
     @Override
    public List<Hospital> Buscar(Hospital obj) {
        // Corpo da consulta
        String consulta = "select h from Hospital h";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            if (obj.getNome() != null && obj.getNome().length() > 0) {
                filtro += " lower(h.nome) like lower('%" + obj.getNome() + "%')";                
            }

            if (obj.getEndereço()!= null && obj.getEndereço().length() > 0) {
                if (filtro.length() > 0) {
                    filtro += " and ";
                }
                filtro += " h.endereço=:endereço ";
                parametros.put("endereço", obj.getEndereço());
            }

            if (obj.getIdHospital()!= null && obj.getIdHospital()> 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " h.idHospital =:idHospital";
                parametros.put("idHospital", obj.getIdHospital());
            }

            if (obj.getTelefone1()!= null && obj.getTelefone1().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " t.telefone1=:telefone1";
                parametros.put("telefone1", obj.getTelefone1());
            }
            
            if (obj.getTelefone2()!= null && obj.getTelefone2().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " t.telefone2=:telefone2";
                parametros.put("telefone", obj.getTelefone2());
            }
            
            if (obj.getTelefone3()!= null && obj.getTelefone3().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " t.telefone3=:telefone3";
                parametros.put("telefone3", obj.getTelefone3());
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
