package DAO;

import model.Produto;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProdutoDAO implements GenericDAO{

    private Connection connection;

    public ProdutoDAO() throws Exception{
        try {
            this.connection = ConnectionFactory.getConnection();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Object> listaTodos() {
        return List.of();
    }

    @Override
    public Object buscarPorId(int id) {
        return null;
    }

    @Override
    public Boolean cadastrar(Object object) {
        Produto produto = (Produto) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO produto(descricao,preco,status)VALUES(?,?,?)";
        try {
            stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPreco());
            stmt.setBoolean(3, produto.isStatus());
            stmt.execute();
            return true;
        }catch (SQLException e){
            System.out.println("Problemas ao inserir produto. Erro:"+e.getMessage());
            e.printStackTrace();
            return false;
        }finally {
            try {
                ConnectionFactory.closeConnection(connection, stmt);
            }catch (Exception exception){
                System.out.println("Problemas ao fechar conexão. Erro:"+exception.getMessage());
            }
        }
    }

    @Override
    public Boolean alterar(Object object) {
        return null;
    }

    @Override
    public void excluir(int id) {

    }
}
