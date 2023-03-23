/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria.principal;

import java.util.Comparator;

/**
 *
 * @author victoriocarvalho
 */
public class ComparadorAlunoPorMatricula implements Comparator<Aluno> {

    @Override
    public int compare(Aluno arg0, Aluno arg1) {
        return Integer.compare(arg0.getMatricula(), arg1.getMatricula());
    }

    
    
}
