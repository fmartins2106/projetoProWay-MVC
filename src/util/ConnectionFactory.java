package util;

import java.sql.*;

public class ConnectionFactory {

    public static final String PATH = "jdbc:postgresql://localhost:5432/superdev_db";
    public static final String USER = "fmartins";
    public static final String PASSWORD = "masterkey";

    public static Connection getConnection() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Conexão realizada com sucesso.");
            return DriverManager.getConnection(PATH,USER,PASSWORD);
        }catch (Exception e){
            throw new Exception("Erro de conecxão com o banco de dados."+e.getMessage());
        }
    }

    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet) throws Exception{
        close(connection,statement,resultSet);
    }

    public static void closeConnection(Connection connection, Statement statement) throws Exception{
        close(connection,statement, null);
    }

    public static void closeConnection(Connection connection) throws Exception{
        close(connection,null,null);
    }

    private static void close(Connection connection, Statement statement, ResultSet resultSet) throws Exception {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
