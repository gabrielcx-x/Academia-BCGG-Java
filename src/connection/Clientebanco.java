package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Cliente;
import model.bean.ClienteTableModel;

public class Clientebanco {

        public static void insertCliente (Cliente c){ 
            String jdbcURL = "jdbc:mysql://localhost:3306/academiajs";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = con.prepareStatement(
                    "insert into cliente(nome,cpf,email,telefone,endereco) values (?,?,?,?,?)"
            );
                        // preenche os valores
            preparedStatement.setString(1,c.getNome());
            preparedStatement.setString(2,c.getCPF());
            preparedStatement.setString(3,c.getEmail());
            preparedStatement.setString(4,c.getTelefone());
            preparedStatement.setString(5,c.getEndereco());
            

            // executa
            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Inserido no Banco de Dados!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Clientebanco.class.getName()).log(Level.SEVERE, null, ex);
        }  
       }
        public static void updateCliente(Cliente c) {
            String jdbcURL = "jdbc:mysql://localhost:3306/academiajs";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);


        PreparedStatement preparedStatement = con.prepareStatement(
                "UPDATE cliente SET nome=?, email=?, telefone=?, endereco=? WHERE cpf=?"
        );

        preparedStatement.setString(1, c.getNome());
        preparedStatement.setString(2, c.getEmail());
        preparedStatement.setString(3, c.getTelefone());
        preparedStatement.setString(4, c.getEndereco());


        preparedStatement.setString(5, c.getCPF());

        preparedStatement.executeUpdate();
        preparedStatement.close();

        System.out.println("Atualizado!");

        con.close();

        } catch (SQLException e) {
        e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Clientebanco.class.getName()).log(Level.SEVERE, null, ex);
    }
 }
    public static void DeleteCliente(Cliente c){ 
            String jdbcURL = "jdbc:mysql://localhost:3306/academiajs";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = con.prepareStatement("delete from cliente WHERE cpf = ?");

            preparedStatement.setString(1, c.getCPF());

            preparedStatement.executeUpdate();

            System.out.println("Excluido no Banco de Dados!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
             } catch (ClassNotFoundException ex) {
            Logger.getLogger(Clientebanco.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
}

