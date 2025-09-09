package controller;

import DAO.FuncionarioDAO;
import DAO.GenericDAO;
import DAO.ProdutoDAO;
import model.Funcionario;
import model.Produto;

import java.util.Scanner;

public class FuncionarioController {
    private static final Scanner scanner = new Scanner(System.in);
    private FuncionarioDAO dao;

    public String cadastrar() throws Exception {
        System.out.println("Nome funcionário:");
        String nome = scanner.nextLine().trim();
        System.out.println("Cargo funcionário:");
        String cargo = scanner.nextLine().trim();
        System.out.println("Salário:R$");
        double salario = Double.parseDouble(scanner.nextLine().trim());
        Funcionario funcionario1 = new Funcionario(nome,cargo,salario);
        FuncionarioDAO dao = new FuncionarioDAO();
        boolean isCadastrado = dao.cadastrar(funcionario1);
        if (isCadastrado) {
            return "Cadastro efetuado com sucesso.";
        } else {
            return "Erro ao cadastrar produto";
        }
    }

}
