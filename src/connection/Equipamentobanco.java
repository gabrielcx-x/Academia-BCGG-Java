/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Equipamento;
import model.bean.EquipamentoTableModel;
/**
 *
 * @author user
 */
public class Equipamentobanco {
    public static void insertEquipamento (Equipamento equipamento){ 
            String jdbcURL = "jdbc:mysql://localhost:3306/academiajs";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = con.prepareStatement(
  "insert into cadastroequipamentos (nomeequipamento,codigoequipamento,pesosuportado,grupomuscular,datamanutencao) values (?,?,?,?,?)"
        );
            // preenche os valores
            preparedStatement.setString(1, equipamento.getNomeequipamento());
            preparedStatement.setString(2, equipamento.getCodigoequipamento());
            preparedStatement.setString(3, equipamento.getPesosuportado());
            preparedStatement.setString(4, equipamento.getGrupomuscular());
            preparedStatement.setString(5, equipamento.getDatamanutencao());


            // executa
            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Inserido no Banco de Dados!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Equipamentobanco.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
   public static void updateEquipamento(Equipamento equipamento) {
            String jdbcURL = "jdbc:mysql://localhost:3306/academiajs";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);


        PreparedStatement preparedStatement = con.prepareStatement(
                 "update cadastroequipamentos set nomeequipamento=?,pesosuportado=?,grupomuscular=?,datamanutencao=? where codigoequipamento=?"
        );

        preparedStatement.setString(1, equipamento.getNomeequipamento());
        preparedStatement.setString(2, equipamento.getPesosuportado());
        preparedStatement.setString(3, equipamento.getGrupomuscular());
        preparedStatement.setString(4, equipamento.getDatamanutencao());


        preparedStatement.setString(5, equipamento.getCodigoequipamento());

        preparedStatement.executeUpdate();
        preparedStatement.close();

        System.out.println("Atualizado!");

        con.close();

         } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Equipamentobanco.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
   public static void DeleteEquipamento(Equipamento equipamento) {
            String jdbcURL = "jdbc:mysql://localhost:3306/academiajs";
            String jdbcUsername = "root";
            String jdbcPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = con.prepareStatement("delete from cadastroequipamentos WHERE Codigoequipamento = ?");

            preparedStatement.setString(1, equipamento.getCodigoequipamento());

            preparedStatement.executeUpdate();

            System.out.println("Excluido no Banco de Dados!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Equipamentobanco.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
}
