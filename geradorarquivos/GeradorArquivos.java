/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorarquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victoriocarvalho
 */
public class GeradorArquivos {
    
    final char vogais[] = {'a', 'e', 'i', 'o','u','A','E','I','O','U'};
    final Random rand = new Random();
    final int matriculaBase = 2000000000;
    
    private enum TipoArquivo{ORDENADO, BALANCEADO;};
    
    private boolean ehVogal (char c){
        for (char l: vogais){
            if (l==c) return true;
        }
        return false;
    }
    
    private char geraVogal(boolean min){
        if (min)
            return vogais[rand.nextInt(5)];
        else
            return vogais[5+rand.nextInt(5)];       
    }

    private char geraLetra(boolean min){
        if (min)
            return (char) ('a'+rand.nextInt(26));
        else
            return (char) ('A'+rand.nextInt(26));
    }

    
    private String geraPalavra(int tam){
        int cont;
        String palavra = "";

        palavra+= geraLetra(false);
        for(cont=1;cont<tam;cont++){
            if (ehVogal(palavra.charAt(cont-1)))
                palavra+=geraLetra(true);
            else
                palavra+=geraVogal(true);        
        }
        return palavra;
    }
    
    private String geraNomeCompleto(){
        String nome="";
        nome+= geraPalavra(3+rand.nextInt(6));
        nome+=" ";
        nome+= geraPalavra(3+rand.nextInt(6));
        return nome;
    }
    
    public void geraArqOrdenado(int n){
        int i,nota,matricula= matriculaBase;
        String nome;
        
        FileWriter arq;
        try {
            arq = new FileWriter("geradorarquivos\\entradaBalanceada"+n+".txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(n);
            for(i=1;i<=n;i++){
                matricula++;
                nome = geraNomeCompleto();
                nota = 10 + rand.nextInt(91);
                gravarArq.printf("%d;%s;%d%n",matricula, nome, nota);
            }
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(GeradorArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void geraArqBalanceado(int n){
        int i,nota,matricula= 2000000000;
        String nome;
        
        FileWriter arq;
        try {
            arq = new FileWriter("geradorarquivos\\entradaBalanceada"+n+".txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(n);
            geraBalanceado(1,n,gravarArq);
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(GeradorArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
    
    private void geraBalanceado(int min, int max,PrintWriter gravarArq){
        if (min <= max){
            int media = (min+max)/2;
            int matricula = matriculaBase+media; 
            String nome = geraNomeCompleto();
            int nota = 10 + rand.nextInt(91);
            gravarArq.printf("%d;%s;%d%n",matricula, nome, nota);
            geraBalanceado(min,media-1,gravarArq);
            geraBalanceado(media+1,max,gravarArq);
        }
    }
    
    public void geraArquivo(int tam, TipoArquivo t){
       switch (t){
           case ORDENADO: 
               geraArqOrdenado(tam);
               break;
           case BALANCEADO: 
               geraArqBalanceado(tam);
               break;   
       }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        GeradorArquivos g = new GeradorArquivos();
        
        /*Para configurar o arquivo que deseja gerar basta colocar na variável 
        tam a quantidade de registros que deseja e passar definir o tipo de arquivo
        que pode ser ORDENADO ou BALANCEADO*/
        
        int TAM = 1000;
        long tempoInicial = System. currentTimeMillis();        
        g.geraArquivo(TAM,TipoArquivo.ORDENADO);
        long tempoFinal = System. currentTimeMillis();
        
        System.out.println("Tempo Total de geração do arquivo em ms: " + (tempoFinal - tempoInicial));
    }
    
}
