/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.entidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class Calendario {
    private int id_data;
    private String data, descricao;
    private boolean editavel;
    private String editavelS;
    

    public String getEditavelS() {
        return editavelS;
    }

    public void setEditavelS(String editavelS) {
        this.editavelS = editavelS;
    }

    public int getId_data() {
        return id_data;
    }

    public void setId_data(int id_data) {
        this.id_data = id_data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isEditavel() {
        return editavel;
    }

    public void setEditavel(boolean editavel) {
        this.editavel = editavel;
    }
    
    
    
    public boolean verificaData(Date dataD) {
        // pega a data e hora atual
        Date hoje = new Date();
        // faz uma verificação se a data selecionada é menor ou igual a data capturada acima
        if(dataD.compareTo(hoje) > 0){
            Calendar c = Calendar.getInstance();
            c.setTime(dataD);
            if(checaFDS(c)){
                /*AgendaProvaDao apd = new AgendaProvaDao();
                SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");
                if(true){
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "A data selecionada é feriado ou algum evento no campus.");
                    return false;
                }*/
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null, "Não é possivel utilizar fins de semana.");
                return false;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Não é possivel utilizar dias anteriores a hoje.");
            return false;
        }
    }
    public boolean checaFDS(Calendar data) {
        // se for domingo
        boolean checaFDS = true;
        if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            checaFDS = false;
        }
        // se for sábado
        else if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
            checaFDS = false;
        }
        return checaFDS;
    }
    
    
    
    
    
    
    
}
