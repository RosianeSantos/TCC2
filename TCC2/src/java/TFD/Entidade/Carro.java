/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TFD.Entidade;

/**
 *
 * @author Rosy
 */
public class Carro {
    private Long Id;
    private String Nome;
    private int Tipo;

    /**
     *
     * @return
     */
    public Long getId() {
        return Id;
    }

    /**
     *
     * @param Id
     */
    public void setId(Long Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return Nome;
    }

    /**
     *
     * @param Nome
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     *
     * @return
     */
    public int getTipo() {
        return Tipo;
    }

    /**
     *
     * @param Tipo
     */
    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    /**
     *
     * @return
     */
    public int getVagas() {
        return Vagas;
    }

    /**
     *
     * @param Vagas
     */
    public void setVagas(int Vagas) {
        this.Vagas = Vagas;
    }

    /**
     *
     * @return
     */
    public int getPlca() {
        return Plca;
    }

    /**
     *
     * @param Plca
     */
    public void setPlca(int Plca) {
        this.Plca = Plca;
    }
    private int Vagas;
    private int Plca;
}
