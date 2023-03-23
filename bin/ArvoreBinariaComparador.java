/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria.lib;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author victoriocarvalho
 */
public class ArvoreBinariaComparador<T> {
    
    protected No<T> raiz;
 
    protected Comparator<T> comparador;    


    public ArvoreBinariaComparador(Comparator<T> comp) {
        comparador = comp;
    }

    //Método implementado apenas como exemplo de método não recursivo
    public void adicionarElemento(T novoValor) {
        No<T> novoNo = new No<T>(novoValor);
        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No<T> atual = raiz;
            boolean inserido = false;
            while (!inserido) {
                //Se o novo elemento for melnor do que o atual vou pra esquerda
                if(comparador.compare(novoNo.getValor(),atual.getValor()) < 0){
                
                    if (atual.getFilhoEsquerda() == null) {
                        atual.setFilhoEsquerda(novoNo);
                        inserido = true;
                    } else {
                        atual = atual.getFilhoEsquerda();
                    }
                } //Se o novo elemento for maior ou igual vou pra direita
                else {
                    if (atual.getFilhoDireita() == null) {
                        atual.setFilhoDireita(novoNo);
                        inserido = true;
                    } else {
                        atual = atual.getFilhoDireita();
                    }
                }
            }
        }
    }
    
    public void caminhaEmNivel(){
        ArrayList<No<T>> fila = new ArrayList<No<T>>();
        if (this.raiz == null)
            System.out.println("Caminhamento por Nível - Árvore Vazia");
        else{
            System.out.println("Caminhamento por Nível: ");
            No<T> atual;
            fila.add(this.raiz);
            while (fila.size() >0 ){
                
                atual = fila.get(0);
                fila.remove(0);
                System.out.println(atual.getValor() + " - " + atual.obterAltura());
                if (atual.getFilhoEsquerda() != null)
                    fila.add(atual.getFilhoEsquerda());
                if (atual.getFilhoDireita() != null){
                    fila.add(atual.getFilhoDireita());
                }
                    
                

            }
        }
    }

    public void caminhaEmOrdem(){
        System.out.println("Saída do Caminhamento em Ordem");
        caminhaEmOrdem(this.raiz);
        System.out.println("Fim da Saída do Caminhamento em Ordem");
    }

    private void caminhaEmOrdem(No<T> raiz) {
        if(raiz!=null){
            caminhaEmOrdem(raiz.getFilhoEsquerda());
            System.out.println(raiz.getValor());
            caminhaEmOrdem(raiz.getFilhoDireita());
        }
    }
 
    
}
