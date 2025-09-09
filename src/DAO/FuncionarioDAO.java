package DAO;

import model.Funcionario;
import model.Produto;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioDAO implements GenericDAO{

    private Connection connection;

    public FuncionarioDAO() throws Exception{
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
        Funcionario funcionario = (Funcionario) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO funcionario(nome,cargo,salario)VALUES(?,?,?)";
        try {
            stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.execute();
            return true;
        }catch (SQLException e){
            System.out.println("Problemas ao inserir dados funcionário. Erro:"+e.getMessage());
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
