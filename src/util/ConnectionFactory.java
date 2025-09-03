package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public static final String PATH = "jdbc:postgresql://localhost:5432/banco";
    public static final String USER = "postgres";
    public static final String PASSWORD = "postgres";

    public static Connection getConnection() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Banco conectado com sucesso.");
            return DriverManager.getConnection(PATH,USER,PASSWORD);
        }catch (Exception e){
            throw new Exception("Erro de conecxão com o banco de dados."+e.getMessage());
        }
    }



}
