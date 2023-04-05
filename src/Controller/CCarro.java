/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static inf3n2012.carro.INF3N212Carro.cadPessoa;
import java.util.ArrayList;
import model.Carro;

/**
 *
 * @author 182120044
 */
public class CCarro {

    ArrayList<Carro> carros = new ArrayList();

    public void addCarro(Carro c) {
        this.carros.add(c);
    }

    public void removeCarro(Carro c) {
        this.carros.remove(c);
    }

    public ArrayList<Carro> getCarros() {
        return this.carros;
    }

    public Carro getCarroPlaca(String placa) {
        Carro c = null;
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                c = carro;
                break;
            }

        }
        return c;
    }

    public void mockCarros() {
      Carro c1 = new Carro();
      
      c1.setAnoFab(2023);
      c1.setAnoMod(2023);
      c1.setMarca("Fiat");
      c1.setModelo("Pallio");
      c1.setTpCambio("Manual");
      c1.setCombustivel("Fiex");
      c1.setCor("Bege");
      c1.setProprietario(cadPessoa.getPessoaCPF("91023736020"));
      addCarro(c1);
    }
}
