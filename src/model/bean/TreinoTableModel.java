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
 * @author GUSTAVO
 */
public class TreinoTableModel extends AbstractTableModel{

   private List<Treino> dados = new ArrayList<>();
    private String[] colunas = {"Objetivo Cliente", "CPF", "Treino A", "Treino B", "Treino C"};
    
    @Override
    public String getColumnName (int column) {
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
        
        switch (coluna){
            case 0:
                return dados.get(linha).getObjetivo();
            case 1:
                return dados.get(linha).getCpf();
            case 2:
                return dados.get(linha).getTreinoa();
            case 3:
                return dados.get(linha).getTreinob();
            case 4:
                return dados.get(linha).getTreinoc();
        }
        
        return null;
        
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna){
            case 0:
                 dados.get(linha).setObjetivo((String) valor);
            case 1:
                 dados.get(linha).setCpf((String) valor);
            case 2:
                 dados.get(linha).setTreinoa((String) valor);
            case 3:
                 dados.get(linha).setTreinob((String) valor);
            case 4:
                 dados.get(linha).setTreinoc((String) valor);
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    
    
    
    public void addRow(Treino t){
        this.dados.add(t);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
}
