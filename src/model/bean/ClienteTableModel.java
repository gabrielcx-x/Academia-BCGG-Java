
package model.bean;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClienteTableModel extends AbstractTableModel {
    
    private List<Cliente> dados = new ArrayList<>();
    private String[] colunas = {"Nome","CPF","Email","Telefone","Endereço"};
    
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
            case 0 -> {
                return dados.get(linha).getNome();
            } 
            case 1 -> {
                return dados.get(linha).getCPF();
            }
            case 2 -> {
                return dados.get(linha).getEmail();
            }
            case 3 -> {
                return dados.get(linha).getTelefone();
            }
            case 4 -> {
                return dados.get(linha).getEndereco();
            }
        }
        return null;
    }
    @Override
     public void setValueAt(Object valor,int linha,int coluna){
        switch(coluna){
            case 0 -> {
                dados.get(linha).setNome((String)valor);
                break;
            } 
            case 1 -> {
                dados.get(linha).setCPF((String)valor);
                break;
            }
            case 2 -> {
                dados.get(linha).setEmail((String)valor);
                break;
            }
            case 3 -> {
                dados.get(linha).setTelefone((String)valor);
                break;
            }
            case 4 -> {
                dados.get(linha).setEndereco((String)valor);
                break;
            }
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    public void addRow(Cliente c){
        this.dados.add(c);
        this.fireTableDataChanged();
    }
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha,linha);
    } 
}
