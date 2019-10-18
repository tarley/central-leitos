/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.newtonpaiva.centralleitos.modelos;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Tarley
 */
@Entity
public class Procedimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private Long duracaoMediaEmMinutos;
    @ManyToMany(mappedBy = "procedimentos")
    private List<Ocupacao> ocupacoes;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the duracaoMediaEmMinutos
     */
    public Long getDuracaoMediaEmMinutos() {
        return duracaoMediaEmMinutos;
    }

    /**
     * @param duracaoMediaEmMinutos the duracaoMediaEmMinutos to set
     */
    public void setDuracaoMediaEmMinutos(Long duracaoMediaEmMinutos) {
        this.duracaoMediaEmMinutos = duracaoMediaEmMinutos;
    }

    /**
     * @return the ocupacoes
     */
    public List<Ocupacao> getOcupacoes() {
        return ocupacoes;
    }

    /**
     * @param ocupacoes the ocupacoes to set
     */
    public void setOcupacoes(List<Ocupacao> ocupacoes) {
        this.ocupacoes = ocupacoes;
    }
    
    
}
