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
 * @author GABRIEL 
 */
public class EquipamentoTableModel extends AbstractTableModel{

   private final List<Equipamento> dados = new ArrayList<>();
    private final String[] colunas = {"Nome Equipamento", "Codigo Equipamento", "Peso Suportado", "Grupo Muscular", "Data Manutenção"};
    
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
            case 0 -> {
                return dados.get(linha).getNomeequipamento();
           }
            case 1 -> {
                return dados.get(linha).getCodigoequipamento();
           }
            case 2 -> {
                return dados.get(linha).getPesosuportado();
           }
            case 3 -> {
                return dados.get(linha).getGrupomuscular();
           }
            case 4 -> {
                return dados.get(linha).getDatamanutencao();
           }
        }
        
        return null;
        
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna){
            case 0:
                 dados.get(linha).setNomeequipamento((String) valor);
            case 1:
                 dados.get(linha).setCodigoequipamento((String) valor);
            case 2:
                 dados.get(linha).setPesosuportado((String) valor);
            case 3:
                 dados.get(linha).setGrupomuscular((String) valor);
            case 4:
                 dados.get(linha).setDatamanutencao((String) valor);
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    
    
    
    public void addRow(Equipamento e){
        this.dados.add(e);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
}
