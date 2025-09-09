package controller;

import DAO.GenericDAO;
import DAO.ProdutoDAO;
import model.Funcionario;
import model.Produto;

import java.util.Scanner;

public class ProdutoController {
    private static final Scanner scanner = new Scanner(System.in);
    private ProdutoDAO dao;

    public String cadastrar() throws Exception {
        System.out.println("Nome descricao:");
        String descricao = scanner.nextLine().trim();
        System.out.println("Preço:R$:");
        double preco = Double.parseDouble(scanner.nextLine().trim());
        Produto produto1 = new Produto(descricao,preco);
        GenericDAO dao = new ProdutoDAO();
        boolean isCadastrado = dao.cadastrar(produto1);
        if (isCadastrado) {
            return "Cadastro efetuado com sucesso.";
        } else {
            return "Erro ao cadastrar produto";
        }
    }


}
