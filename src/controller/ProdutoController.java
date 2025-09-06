package controller;

import DAO.GenericDAO;
import DAO.ProdutoDAO;
import model.Produto;

public class ProdutoController {

    private ProdutoDAO dao;

    public String cadastrar(Produto produto) throws Exception {
        GenericDAO dao = new ProdutoDAO();
        boolean isCadastrado = dao.cadastrar(produto);
        if (isCadastrado) {
            return "Cadastro efetuado com sucesso.";
        } else {
            return "Erro ao cadastrar produto";
        }
    }

}
