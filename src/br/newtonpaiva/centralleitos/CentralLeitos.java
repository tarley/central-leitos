/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.newtonpaiva.centralleitos;

import br.newtonpaiva.centralleitos.modelos.Leito;
import br.newtonpaiva.centralleitos.modelos.Ocupacao;
import java.util.GregorianCalendar;
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
        
        
        em.getTransaction().commit();
        
        em.close();
        
    }
    
}
