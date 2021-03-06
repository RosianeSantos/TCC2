/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TFD.DataAcess;

import TFD.DomainModel.Funcionario;
import TFD.DomainModel.FuncionarioRepositorio;
import java.util.HashMap;
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
        implements FuncionarioRepositorio {

    public FuncionarioDAO() {
        super(Funcionario.class);
    }

    @Override
    public List<Funcionario> Buscar(Funcionario obj) {
        // Corpo da consulta
        String consulta = "select f from Funcionario f";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            if (obj.getNome() != null && obj.getNome().length() > 0) {
                filtro += " lower(f.nome) like lower('%" + obj.getNome() + "%')";
            }

            if (obj.getLogin() != null && obj.getLogin().length() > 0) {
                if (filtro.length() > 0) {
                    filtro += " and ";
                }
                filtro += " f.login=:login ";
                parametros.put("login", obj.getLogin());
            }

            if (obj.getIdFuncionario() != null && obj.getIdFuncionario() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " f.funcionario.idFuncionario =:idFuncionario";
                parametros.put("idFuncionario", obj.getIdFuncionario());
            }

            if (obj.getSenha() != null && obj.getSenha().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " f.senha=:senha";
                parametros.put("senha", obj.getSenha());
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

//    public Funcionario Validar(Funcionario obj) {
//
//        String Consulta = "select f from Funcionario f";
//
//        if (obj != null) {
//            Consulta = Consulta + " where f.login like '" + obj.getLogin() + "'"
//                    + " and f.senha like '" + obj.getSenha() + "'";
//        }
//        Query q = manager.createQuery(Consulta);
//        return (Funcionario) q.getSingleResult();
//
//    }

    @Override
    public Funcionario Validar(String login) {
       String sql = "select f from Funcionario f where f.login=:s";

         // Cria a consulta no JPA
        Query consulta = manager.createQuery(sql);

        // Aplica os parâmetros da consulta
        consulta.setParameter("s", login);

        // Executa a consulta
       
        try{
        return (Funcionario)consulta.getSingleResult();
       }catch(Exception e){
           return null;
       }
    
}


}

