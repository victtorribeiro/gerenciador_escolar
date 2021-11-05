/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.conexao.FactoryConnection;
import br.com.gerenciador.entidades.Calendario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class CalendarioDao {
    FactoryConnection fc = new FactoryConnection();
    PreparedStatement pst = null;
    ResultSet rs;
    
    public void cadastraData(Calendario c) throws SQLException{
        
        String sql = "INSERT INTO CALENDARIO_ACADEMICO(DATA, DESCRICAO, EDITAVEL) VALUES(?,?,?)";

        try {
            pst = fc.getConexao().prepareCall(sql);
            
            pst.setString(1, c.getData());
            pst.setString(2, c.getDescricao());
            pst.setBoolean(3, true);
            
            pst.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(CalendarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pst.close();
        }
        
    }
    
    public List<Calendario> read() throws SQLException {

        List<Calendario> c = new ArrayList<>();

        try {
            pst = fc.getConexao().prepareStatement("SELECT * FROM CALENDARIO_ACADEMICO ORDER BY DATA");

            rs = pst.executeQuery();

            while (rs.next()) {

                Calendario calendario = new Calendario();
                
                calendario.setId_data(rs.getInt("ID_DATA"));
                calendario.setDescricao(rs.getString("DESCRICAO"));
                calendario.setData(rs.getString("DATA"));
                calendario.setEditavel(rs.getBoolean("EDITAVEL"));
                
                if(calendario.isEditavel()){
                    calendario.setEditavelS("Sim");
                }else{
                    calendario.setEditavelS("Não");
                }
                c.add(calendario);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            pst.close();
        }

        return c;
    }
    
    
    public void updateCalendario(Calendario c) throws SQLException {
        String sql = "UPDATE CALENDARIO_ACADEMICO SET DATA = ?, DESCRICAO = ?, EDITAVEL = ? WHERE ID_DATA = ?";

        pst = fc.getConexao().prepareCall(sql);

        pst.setString(1, c.getData());
        pst.setString(2, c.getDescricao());
        pst.setBoolean(3, true);
        pst.setInt(4, c.getId_data());

        pst.executeUpdate();

    }
    public void deleteData(int idData) throws SQLException{
        String sql = "DELETE FROM CALENDARIO_ACADEMICO WHERE ID_DATA = ?";
        
        pst = fc.getConexao().prepareCall(sql);
        
        pst.setInt(1, idData);
        
        pst.execute();
    }
    public String verificaData(String data) throws SQLException{
        String sql = "SELECT * FROM CALENDARIO_ACADEMICO WHERE DATA = ?";
        String retorno = "";
        pst = fc.getConexao().prepareCall(sql);
        
        pst.setString(1, data);
        
        rs = pst.executeQuery();
        
        while(rs.next()){
            retorno = rs.getString("DESCRICAO");
        }
        
        return retorno;
    }
    
}
