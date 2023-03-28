/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author 182120044
 */
public class cPessoa {

    ArrayList<Pessoa> pessoas = new ArrayList<>();
    int idPessoa = 1;

    public int geraID() { //Auto-increment
        return this.idPessoa++;
    }
//Void é uma ação
    /**
     * Método addPessoa adiciona Pessoa no ArrayList pessoas
     *
     * @param p
     */
    public void addPessoa(Pessoa p) {
        this.pessoas.add(p);
    }

    /**
     * Método removePessoa remove pessoa do ArrayList pessoa
     *
     * @param p
     */
    public void removePessoa(Pessoa p) {
        this.pessoas.remove(p);
    }

    public ArrayList<Pessoa> getPessoas() {
        return this.pessoas;
    }

    /**
     * Método getPessoaCPF retorna uma pessoa caso encontre correspondência no
     * cpf do ArrayList pessoas caso contrário, retorna null.
     *
     * @param CPF
     * @return
     */

    public Pessoa getPessoaCPF(String CPF) {
        Pessoa p = null;
        for (Pessoa pes : pessoas) { //escopo do for ( para verificar o CPF )
            if (pes.getCpf().equals(CPF)) {
                p = pes;
                break;
            }// fim do '' if ''
        }// fim do ''for''

        return p;
    }//fim public pessoa getPessoaCPF

    public void mockPessoas() {
        Pessoa p1 = new Pessoa();
        p1.setIdPessoa(geraID());
        p1.setCpf("93581792010");
        p1.setNome("Jigolo Santos Buteco");
        p1.setTelefone("51982543545");
        p1.setEndereco("Rua das Flores");
        Pessoa p2 = new Pessoa();
        p2.setIdPessoa(geraID());
        p2.setCpf("90189188065");
        p2.setNome("Jigolo Igor Rodrigues");
        p2.setTelefone("51982547584");
        p2.setEndereco("Rua Heralyto Kile");
        addPessoa(p2);
    }

}//fim classe controller
