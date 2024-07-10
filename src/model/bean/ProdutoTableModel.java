/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bruno da Silva
 */
public class ProdutoTableModel extends AbstractTableModel {
    
    private List<Produto> dados = new ArrayList<>();
    private String[] colunas = {"Nome","Data","Cpf","Telefone","Cargo","Salario","Departamento"};

    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
      
        switch(coluna){
            case 0:
                return dados.get(linha).getNome();
            case 1:
                return dados.get(linha).getCpf();
            case 2:
                return dados.get(linha).getCargo();
            case 3:
                return dados.get(linha).getSalario();
            case 4:
                return dados.get(linha).getDepartamento();
        }
        
       return null; 
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        
        switch(coluna){
            case 0:
                 dados.get(linha).setNome((String) valor);
                 break;
            case 1:
                 dados.get(linha).setCpf((String) valor);
                 break;
            case 2:
                 dados.get(linha).setCargo((String) valor);
                  break;

            case 3:
                 dados.get(linha).setSalario((String) valor);
                 break;
            case 4:
                dados.get(linha).setDepartamento((String) valor);
                 break;

        }
        
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addRow(Produto p){
        
        this.dados.add(p);
        this.fireTableDataChanged();
        
        
    }

public void removeRow(int linha){
    this.dados.remove(linha);
    this.fireTableRowsDeleted(linha, linha);
    
}    
    
}
