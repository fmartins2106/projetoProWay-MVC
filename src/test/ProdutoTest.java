package test;

import controller.FuncionarioController;
import controller.ProdutoController;
import model.Funcionario;
import model.Produto;

import javax.swing.*;
import java.util.Locale;
import java.util.Scanner;

public class ProdutoTest {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        ProdutoController controller = new ProdutoController();
        FuncionarioController funcionarioController = new FuncionarioController();
        while (true){
            int opcao = 0;
            menu();
            opcao = opcao();
            switch (opcao){
                case 1:
                    controller.cadastrar();
                    break;
                case 2:
                    funcionarioController.cadastrar();
                    break;
                default:
            }
        }
    }

    private static void menu(){
        System.out.println("[1] Cadastro produto.");
        System.out.println("[2] Cadastro funcionário.");
    }

    private static int opcao(){
        while (true){
            try {
                System.out.println("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Erro digite um número válido.");
            }
        }
    }


}
