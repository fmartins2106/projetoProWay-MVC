package test;

import util.ConnectionFactory;

import java.sql.Connection;

public class ConnectionTest {


    public static void main(String[] args) throws Exception {

        Connection connection = ConnectionFactory.getConnection();

        if (connection != null){
            System.out.println("A conexão foi estabelecimento");
            return;
        }
        System.out.println("Erro na conexão...");

        connection.close();

    }



}
