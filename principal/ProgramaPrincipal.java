/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria.principal;

import arvorebinaria.lib.ArvoreAVL;
import arvorebinaria.lib.ArvoreBinaria;
import arvorebinaria.lib.ArvoreBinariaComparador;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victoriocarvalho
 */
public class ProgramaPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //ArvoreAVL arv = new ArvoreAVL();
        ArvoreBinaria arv2 = new ArvoreBinaria<Aluno>();
        ArvoreBinariaComparador arv3 = new ArvoreBinariaComparador<Aluno>(new ComparadorAlunoPorNome());
        ArvoreBinariaComparador arv4 = new ArvoreBinariaComparador<Aluno>(new ComparadorAlunoPorMatricula());
        ArrayList lista = new ArrayList<Aluno>();
       
        
        /*
        Aluno a = new Aluno(10, "Ze", 100);
        arv2.adicionarElemento(a);
        arv3.adicionarElemento(a);
        lista.add(a);
        
        
        a = new Aluno(2, "Maria", 90);
        arv2.adicionarElemento(a);
        arv3.adicionarElemento(a);
        lista.add(a);
        
        a = new Aluno(20, "Ana", 90);
        arv2.adicionarElemento(a);
        arv3.adicionarElemento(a);
        lista.add(a);
        
        a = new Aluno(15, "Toin", 90);
        arv2.adicionarElemento(a);
        arv3.adicionarElemento(a);
        lista.add(a);
        
        System.out.println(lista);
        lista.sort(new ComparadorAlunoPorNome());
        System.out.println(lista);
        lista.sort(new ComparadorAlunoPorMatricula());
        System.out.println(lista);


        System.out.println(arv2.obterMaiorElemento());
        System.out.println(arv2.f());
        */
        Scanner in = new Scanner(new FileReader("entradaBalanceada40.txt"));
        String partes[] = new String[3];
        String line = in.nextLine();
        Aluno a;
        long tempoInicial = System. currentTimeMillis();
        while (in.hasNextLine()) {
            line = in.nextLine();
            partes = line.split(";");
            a = new Aluno(Integer.parseInt(partes[0]),partes[1],Integer.parseInt(partes[2]));
            arv2.adicionarElemento(a);
            arv3.adicionarElemento(a);
            arv4.adicionarElemento(a);
            //lista.add(a);
       }
 /*    
       long tempoFinal = System. currentTimeMillis();
       System.out.println("Tempo de Carga do Arquivo: "+ (tempoFinal-tempoInicial));
       //System.out.println("Arvore AVL - Altura = " + arv.obterAltura());
       //arv.testaFB();
       
       //Buscar pelo primeiro elemento inserido na lista considerando o arquivo aleatorio 30000 - matricula 2009881746
       tempoInicial = System.currentTimeMillis();
       int i = lista.indexOf(new Aluno(2047478819,"Teste",10));
       tempoFinal = System. currentTimeMillis();
       System.out.println("Encontrou o objeto no indice: "+ i + " em "+ (tempoFinal-tempoInicial)+ " ms - usando currentMillis");
      
        //Buscar pelo primeiro elemento inserido na lista considerando o arquivo aleatorio 30000 - matricula 2009881746
       tempoInicial = System.currentTimeMillis();
       i = lista.indexOf(new Aluno(2047478819,"Teste",10));
       tempoFinal = System. currentTimeMillis();
       System.out.println("Encontrou o objeto no indice: "+ i + " em "+ (tempoFinal-tempoInicial)+ " ms usando currentMillis");
      
        //Buscar pelo primeiro elemento inserido na lista considerando o arquivo aleatorio 30000 - matricula 2009881746
       ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
       Aluno a1 =new Aluno(2047478819,"Teste",10);
       tempoInicial = threadMXBean.getCurrentThreadCpuTime();
       i = lista.indexOf(a1);
       tempoFinal = threadMXBean.getCurrentThreadCpuTime();
       System.out.println("Encontrou o objeto no indice: "+ i + " em "+ (tempoFinal-tempoInicial)+ " ms - usando thread");
      
       tempoInicial = threadMXBean.getCurrentThreadCpuTime();
       i = lista.indexOf(a1);
       tempoFinal = threadMXBean.getCurrentThreadCpuTime();
       System.out.println("Encontrou o objeto no indice: "+ i + " em "+ (tempoFinal-tempoInicial)+ " ms - usando thread");
       
       tempoInicial = threadMXBean.getCurrentThreadUserTime();
       i = lista.indexOf(a1);
       tempoFinal = threadMXBean.getCurrentThreadUserTime();
       System.out.println("Encontrou o objeto no indice: "+ i + " em "+ (tempoFinal-tempoInicial)+ " ms - usando thread");
      
       tempoInicial = threadMXBean.getCurrentThreadUserTime();
       i = lista.indexOf(a1);
       tempoFinal = threadMXBean.getCurrentThreadUserTime();
       System.out.println("Encontrou o objeto no indice: "+ i + " em "+ (tempoFinal-tempoInicial)+ " ms - usando thread");
       
       System.out.println(threadMXBean.getAllThreadIds().length);
       System.out.println(threadMXBean.isCurrentThreadCpuTimeSupported());
       System.out.println(threadMXBean.isThreadCpuTimeEnabled());
       
       long l,c;
       tempoInicial = threadMXBean.getCurrentThreadCpuTime();
       for(l=0;l<1000000;l++)
           //for(c=0;c<10;c++)
       tempoFinal = threadMXBean.getCurrentThreadCpuTime();
       System.out.println("Inicio " + tempoInicial +" Fim "+ tempoFinal+ " Diferenca "+ (tempoFinal-tempoInicial) );
       
       tempoInicial = threadMXBean.getCurrentThreadCpuTime();
       for(l=0;l<1000000;l++)
           //or(c=0;c<10;c++)
       tempoFinal = threadMXBean.getCurrentThreadCpuTime();
       System.out.println("Inicio " + tempoInicial +" Fim "+ tempoFinal+ " Diferenca "+ (tempoFinal-tempoInicial) );
    */
        //  System.out.println("Arvore Nao balanceada - Altura = " + arv2.obterAltura());
       //arv2.caminhaEmNivel();
       //System.out.println(arv.obterAltura());
       //System.out.println(arv2.obterAltura());
       /*a = new Aluno(2000000008, "", 10);
       Integer quantComp = 0;
       tempoInicial = System. currentTimeMillis();
       quantComp = arv.buscarElemento(a);
       tempoFinal = System. currentTimeMillis();
       System.out.println("Quatidade de Comparações: "+ quantComp + " - tempo de Busca: "+ (tempoFinal-tempoInicial));
       System.out.println("Excluindo o elemento "+ a);
       arv.remover(a);
       a = new Aluno(2000000012, "", 10);
       arv.adicionarElemento(a);*/
       System.out.println("--Arvore com Comparable--");
       arv2.caminhaEmOrdem();
       System.out.println("--Arvore com Comparator por nome--");
       arv3.caminhaEmOrdem();
       System.out.println("--Arvore com Comparator por matricula--");
       arv4.caminhaEmOrdem();

    }
    
}

class MyThread extends Thread {

    public void run() {
        int sum = 0;
        for (int i = 0; i < 1000000; ++i) {
            sum += i;
        }
        sum = sum + 1;
    }

}