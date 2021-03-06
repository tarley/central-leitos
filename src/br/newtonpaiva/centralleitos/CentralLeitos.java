/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.newtonpaiva.centralleitos;

import br.newtonpaiva.centralleitos.modelos.Leito;
import br.newtonpaiva.centralleitos.modelos.Ocupacao;
import br.newtonpaiva.centralleitos.modelos.Paciente;
import br.newtonpaiva.centralleitos.modelos.Procedimento;
import br.newtonpaiva.centralleitos.modelos.Sexo;
import br.newtonpaiva.centralleitos.modelos.TipoSanguineo;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Tarley
 */
public class CentralLeitos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManager em = Persistence
                                .createEntityManagerFactory("CentralLeitosPU")
                                .createEntityManager();
        
        em.getTransaction().begin();
        
        // Tela 1
        Leito leito = new Leito();
        leito.setAla("CTI");
        
        em.persist(leito);
        
        // Tela 2
        Ocupacao ocup = new Ocupacao();
        ocup.setDataEntrada(GregorianCalendar.getInstance());
        ocup.setDataSaida(GregorianCalendar.getInstance());
        ocup.setLeito(leito);
        
        em.persist(ocup);
        
        Procedimento proc1 = new Procedimento();
        proc1.setDescricao("Exame de sangue");
        proc1.setDuracaoMediaEmMinutos(90L);
        
        em.persist(proc1);
        
        // Associa uma lista de procedimentos a uma ocupação especifica
        //List<Procedimento> procedimentos = new ArrayList<>();
        //procedimentos.add(proc1);
        
        //ocup.setProcedimentos(procedimentos);
        ocup.addProcedimento(proc1);
        em.persist(ocup);
        
        
        
        Paciente p = new Paciente();
        p.setNome("Tarley Lana");
        p.setAltura(1.79);
        p.setCpf("000.444.888-68");
        p.setEmail("tarley.lana@gmail.com");
        p.setSexo(Sexo.M);
        p.setTipoSanguineo(TipoSanguineo.O);
        
        em.persist(p);
        
        
        em.getTransaction().commit();
        
        em.close();
        
    }
    
}
