/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria.principal;

/**
 *
 * @author victoriocarvalho
 */
public class Aluno implements Comparable<Aluno> {

    private String nome;
    private int matricula;
    private int nota;
    
    
    public Aluno(int matricula ,String nome, int nota){
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
    }
    
    @Override
    public boolean equals(Object a){
        if (a instanceof Aluno)
            return this.matricula==((Aluno)a).matricula;
        else
            return false;
    }
    
    @Override
    public int compareTo(Aluno a) {
       /* if (this.matricula < a.matricula)
            return -1;
        else
            if (this.matricula > a.matricula)
                return 1;
                else return 0;*/
        
        return Integer.compare(this.matricula, a.matricula);
        
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nota
     */
    public int getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(int nota) {
        this.nota = nota;
    }
    
    public String toString(){
        return Integer.toString(matricula);
    }

   
    
}
