/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf3n2012.carro;

import Controller.CCarro;
import Controller.CPessoa;
import java.util.InputMismatchException;
import java.util.Scanner;
        
/**
 *
 * @author 182120044
 */
public class INF3N2012Carro {
    
    public static CPessoa cadPessoa = new CPessoa();
    public static CCarro cadCarro = new CCarro();
    static Scanner leia = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cadPessoa.mockPessoas();
        cadCarro.mockCarros();
        
        System.out.println(cadPessoa.getPessoas());
        System.out.println("---");
        System.out.println(cadCarro.getCarros());
    }//Método Main ( principal que faz a chamada )
    
    public static int leiaNumInt(){
        Scanner leiaNum = new Scanner(System.in);
        try{
            return leiaNum.nextInt();
        }catch(InputMismatchException i){
            System.out.println("Erro:"+i.getMessage()+ "\nTente novamente!");
            leiaNumInt();
        }
        return 99;       
    }
    
    public static void menu(){
        System.out.println("--Menu Principal--");
        System.out.println("1 - Ger. Pessoa");
        System.out.println("2 - Ger. Carro");
        System.out.println("0 - Sair");
        System.out.println("Digite aqui: ");
    }// fim menuP
    
    public static void subMenu(int opM) {
        String subM = null;
        if (opM == 1){
            subM = "Pessoa";
        }
        if (opM == 2) {
            subM = "Carro";
        }
        
        System.out.println("--Ger."+subM);
    }
    
}//fim classe
