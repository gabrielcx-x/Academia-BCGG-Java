/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Treino;
import model.bean.TreinoTableModel;
/**
 *
 * @author user
 */
public class Treinobanco {
     public static void insertTreino (Treino treino){ 
            String jdbcURL = "jdbc:mysql://localhost:3306/academiajs";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = con.prepareStatement(
  "insert into fichatreino (objetivo,cpf,treinoa,treinob,treinoc) values (?,?,?,?,?)"
        );
            // preenche os valores
              preparedStatement.setString(1, treino.getObjetivo());
            preparedStatement.setString(2, treino.getCpf());
            preparedStatement.setString(3, treino.getTreinoa());
            preparedStatement.setString(4, treino.getTreinob());
            preparedStatement.setString(5, treino.getTreinoc());


            // executa
            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Inserido no Banco de Dados!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Treinobanco.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
   public static void updateTreino (Treino treino) {
            String jdbcURL = "jdbc:mysql://localhost:3306/academiajs";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);


        PreparedStatement preparedStatement = con.prepareStatement(
                 "update fichatreino set objetivo=?,treinoa=?,treinob=?,treinoc=? where cpf=?"
        );

      preparedStatement.setString(1, treino.getObjetivo());
            preparedStatement.setString(2, treino.getTreinoa());
            preparedStatement.setString(3, treino.getTreinob());
            preparedStatement.setString(4, treino.getTreinoc());
            preparedStatement.setString(5, treino.getCpf());
        preparedStatement.executeUpdate();
        preparedStatement.close();

        System.out.println("Atualizado!");

        con.close();

         } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Treinobanco.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
   public static void DeleteTreino (Treino treino) {
            String jdbcURL = "jdbc:mysql://localhost:3306/academiajs";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = con.prepareStatement("delete from fichatreino WHERE Cpf = ?");

            preparedStatement.setString(1, treino.getCpf());

            preparedStatement.executeUpdate();

            System.out.println("Excluido no Banco de Dados!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Treinobanco.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
}

