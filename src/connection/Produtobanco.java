/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Produto;
import model.bean.ProdutoTableModel;
/**
 *
 * @author user
 */
public class Produtobanco {
     public static void insertProduto (Produto produto){ 
            String jdbcURL = "jdbc:mysql://localhost:3306/academiajs";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = con.prepareStatement(
 "insert into funcionario (nome,cpf,cargo,salario,departamento) values (?,?,?,?,?)"
        );
            // preenche os valores
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getCpf());
            preparedStatement.setString(3, produto.getCargo());
            preparedStatement.setString(4, produto.getSalario());
            preparedStatement.setString(5, produto.getDepartamento());

            // executa
            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Inserido no Banco de Dados!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Produtobanco.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
   public static void updateProduto(Produto produto) {
            String jdbcURL = "jdbc:mysql://localhost:3306/academiajs";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);


        PreparedStatement preparedStatement = con.prepareStatement(
                 "update funcionario set nome=?,cargo=?,salario=?,departamento=? where cpf=?"
        );
            // preenche os valores
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getCargo());
            preparedStatement.setString(3, produto.getSalario());
            preparedStatement.setString(4, produto.getDepartamento());
            preparedStatement.setString(5, produto.getCpf());

        preparedStatement.executeUpdate();
        preparedStatement.close();

        System.out.println("Atualizado!");

        con.close();

         } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Produtobanco.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
   public static void DeleteProduto(Produto produto) {
            String jdbcURL = "jdbc:mysql://localhost:3306/academiajs";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = con.prepareStatement("delete from cpf WHERE Cpf = ?");

            preparedStatement.setString(1, produto.getCpf());

            preparedStatement.executeUpdate();

            System.out.println("Excluido no Banco de Dados!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Produtobanco.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
}

