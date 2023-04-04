 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria.lib;

/**
 *
 * @author victoriocarvalho
 */
public class No<T> {

    
//    private int altura;
    private T valor;
    private No<T> filhoEsquerda, filhoDireita;
    
    
    public No(T valor){
        this.valor = valor;
        this.filhoEsquerda = null;
        this.filhoDireita = null;
//        this.altura=0;
    }
    
    public No(){
        this.valor = null;
        this.filhoEsquerda = null;
        this.filhoDireita = null;
//        this.altura=0;
    }


    public int obterAltura(){
        return obterAltura(this);       
    }
    
    private int obterAltura(No<T> r){
        if(r==null)
            return -1;
        else{
            int hd = obterAltura(r.getFilhoDireita());
            int he = obterAltura(r.getFilhoEsquerda());
            if (hd > he)
                return hd+1;
            else
                return he+1;
        }
    }
    
    
    public int fatorBalanceamento(){
        return obterAltura(this.filhoDireita) - obterAltura(this.filhoEsquerda);
    }
    /**
     * @return the valor
     */
    public T getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(T valor) {
        this.valor = valor;
    }

    /**
     * @return the esq
     */
    public No<T> getFilhoEsquerda() {
        return filhoEsquerda;
    }

    /**
     * @param esq the esq to set
     */
    public void setFilhoEsquerda(No<T> esq) {
        this.filhoEsquerda = esq;
    }

    /**
     * @return the dir
     */
    public No<T> getFilhoDireita() {
        return filhoDireita;
    }

    /**
     * @param dir the dir to set
     */
    public void setFilhoDireita(No<T> dir) {
        this.filhoDireita = dir;
    }

    /**
     * @return the alturaNo
     */
 //   public int getAltura() {
 //       return altura;
 //   }

    /**
     * @param alturaNo the alturaNo to set
     */
//    public void setAltura(int alturaNo) {
//        this.altura = alturaNo;
//    }
    
    
}
