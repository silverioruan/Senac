/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf3n2012.carro;

import Controller.CCarro;
import Controller.CPessoa;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Carro;
import model.Pessoa;
import sun.security.provider.VerificationProvider;
import util.Validadores;

/**
 *
 * @author jbferraz
 */
public class INF3N212Carro {

    public static CPessoa cadPessoa = new CPessoa();
    public static CCarro cadCarro = new CCarro();
    static Scanner leia = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        cadPessoa.mockPessoas();
        cadCarro.mockCarros();
        int opM = 99;
        int opSM = 99;
        do {
            System.out.println("-- Sistema de Cadastro --");
            menuP();
            opM = leiaNumInt();
            switch (opM) {
                case 1:
                case 2:
                    do {
                        subMenu(opM);
                        opSM = leiaNumInt();
                        switch (opSM) {
                            case 1:
                                if (opM==1) {
                                    cadastrarPessoa();
                                }else{
                                    cadastrarCarro();
                                }
                                break;
                            case 2:
                                System.out.println("-- Editar --");
                                if (opM==1) {
                                    editarPessoa();
                                }else{
                                    editarCarro();
                                }
                                break;
                            case 3:
                                if (opM==1) {
                                    listarPessoa();
                                }else{
                                    listarCarro();
                                }
                                break;
                            case 4:
                                System.out.println("-- Deletar --");
                                if (opM==1) {
                                    deletarPessoa();
                                }else{
                                    deletarCarro();
                                }
                                break;
                            case 0:

                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente!");
                        }
                    } while (opSM != 0);
                    break;
                case 0:
                    System.out.println("Aplicação encerrada pelo usuário!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
            }
        } while (opM != 0);

    }//fim método main

    public static int leiaNumInt() {
        Scanner leiaNum = new Scanner(System.in);
        try {
            return leiaNum.nextInt();
        } catch (InputMismatchException i) {
            System.out.println("Erro: " + i.getMessage() + "\nTente novamente!");
            leiaNumInt();
        }
        return 99;
    }

    public static void menuP() {
        System.out.println("-- Menu Principal --");
        System.out.println("1 - Ger. Pessoa");
        System.out.println("2 - Ger. Carro");
        System.out.println("0 - Sair");
        System.out.print("Digite aqui: ");
    }//fim menuP

    public static void subMenu(int opM) {
        String subM = null;
        if (opM == 1) {
            subM = "Pessoa";
        }
        if (opM == 2) {
            subM = "Carro";
        }
        System.out.println("-- Ger. " + subM + " --");
        System.out.println("1 - Cadastrar " + subM);
        System.out.println("2 - Editar " + subM);
        System.out.println("3 - Listar " + subM + "s");
        System.out.println("4 - Deletar " + subM);
        System.out.println("0 - Voltar");
        System.out.print("Digite aqui: ");
    }// fim subMenu

    private static void cadastrarPessoa() {
        System.out.println("-- Cadastro de Pessoa --");
        int idPessoa;
        String nome;
        String cpf;
        String endereco;
        String telefone;
        boolean tcpf = true;
        
        do {            
            System.out.print("Informe o CPF: ");
            cpf = leia.nextLine();
            tcpf = Validadores.isCPF(cpf);
            if (tcpf){
                if (cadPessoa.getPessoaCPF(cpf)!=null){
                    System.out.println("CPF já cadastrado!");
                    System.out.println("1 - Tentar novamente");
                    System.out.println("2 - Cancelar cadastro");
                    System.out.println("Digite aqui: ");
                    int op = leiaNumInt();
                    if (op==2) {
                        return;
                    }
                }else{
                    tcpf = false;
                }
            }else{
                System.out.println("CPF inválido!");
                tcpf = true;
            }
        } while (tcpf);
        System.out.print("Informe o nome: ");
        nome = leia.nextLine();
        System.out.print("Informe o endereço: ");
        endereco = leia.nextLine();
        System.out.print("Informe o telefone: ");
        telefone = leia.nextLine();
        idPessoa = cadPessoa.geraID();
        Pessoa p = new Pessoa(idPessoa, nome, cpf, endereco, telefone);
        cadPessoa.addPessoa(p);
        System.out.println(p.getNome()+ "Cadastrado com sucesso!");
    }

    private static void cadastrarCarro() {
        System.out.println("Carro");
    }

    private static void editarPessoa() {
        System.out.println("-- Editar Pessoa --");
        boolean isCPF;
        do{
            System.out.println("Informe o CPF da pessoa a ser editado: ");
            String cpf = leia.nextLine();
            isCPF = Validadores.isCPF(cpf);
            if (isCPF) {
                Pessoa p = cadPessoa.getPessoaCPF(cpf);
                if (p != null) {
                    System.out.println("Quais dados de " + p.getNome() + " Dseja alterar?");
                    System.out.println("1 - Nome");
                    System.out.println("2 - Endereço");
                    System.out.println("3 - Telefone");
                    System.out.println("4 - Todos");
                    System.out.println("0 - Cancelar");
                }else{
                    System.out.println("CPF não encontrado!");
                    isCPF = false;
                }
            }else{
                System.out.println("CPF inválido!");
                System.out.println("Deseja tentar novamente? \n 1 - Sim | 2 - Não: ");
                int op = leiaNumInt();
                if (op == 1) {
                    isCPF = true;
                }else{
                    isCPF = false
                }
            }
    }while (isCPF);

    private static void editarCarro() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private static void listarPessoa() {
        System.out.println("--Lista de Pessoas--"); 
        for (Pessoa pessoa : cadPessoa.getPessoas()){
            System.out.println(pessoa.toString());
    }
    }
    private static void listarCarro() {
        System.out.println("-- Lista de Carros --");
        for (Carro carro : cadCarro.getCarros()){
            System.out.println(carro.toString());       
        }
    }

    private static void deletarPessoa() {
        System.out.println("-- Deletar Pessoa --");
        boolean delCPF = false;
        do {
            System.out.println("Informe o CPF da Pessoa a ser deletada ");
            String cpf = leia.nextLine();
            delCPF = Validadores.isCPF(cpf);
            if(delCPF){
                Pessoa p = cadPessoa.getPessoaCPF(cpf);
                if (p != null){
                    System.out.println("Deseja realmente deletar" + p.getNome() + "?");
                    System.out.println("1 - Sim | 2 - Não:");
                    int op = leiaNumInt();
                    if (op == 1) {
                        cadPessoa.removePessoa(p);
                        System.out.println("Pessoa deletada com sucesso!");
                        delCPF = false;
                    }else{
                        System.out.println("Operação cancelada pelo usuário!");
                        delCPF = false;
                    }
                }else{
                    System.out.println("CPF não cadastrado!");
                    System.out.println("Deseja tentar novamente?");
                    System.out.println("1 - Sim | 2 - Não: ");
                    int op = leiaNumInt();
                    if (op == 1) {
                        delCPF = true;
                    }else{
                        delCPF = false;
                    }
                }
            }else{
                System.out.println("CPF inválido!"
                + "\nTente novamente.1");
                delCPF = true;
            }
        } while (delCPF);
        
       
    }

    private static void deletarCarro() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}//fim classe