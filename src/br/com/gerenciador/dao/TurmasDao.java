/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.conexao.FactoryConnection;
import br.com.gerenciador.entidades.Turmas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 */
public class TurmasDao {

    FactoryConnection fc = new FactoryConnection();
    PreparedStatement pst = null;
    ResultSet rs;

    public void cadastrarTurmas(Turmas t) throws SQLException {

        String sql = "INSERT INTO TURMAS(SERIE, TURMA, TURNO, DATA, SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA) VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            pst = fc.getConexao().prepareCall(sql);

            pst.setString(1, t.getSerie());
            pst.setString(2, t.getTurma());
            pst.setString(3, t.getTurno());
            pst.setString(4, t.getData1());
            pst.setInt(5, t.getSegunda());
            pst.setInt(6, t.getTerca());
            pst.setInt(7, t.getQuarta());
            pst.setInt(8, t.getQuinta());
            pst.setInt(9, t.getSexta());

            pst.execute();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pst.close();
        }

    }

    public List<Turmas> readTurmas() throws SQLException {

        List<Turmas> t = new ArrayList<>();

        try {
            pst = fc.getConexao().prepareStatement("SELECT * FROM TURMAS ORDER BY SERIE");

            rs = pst.executeQuery();

            while (rs.next()) {

                Turmas turmas = new Turmas();
                turmas.setId_Turma(rs.getInt("ID_TURMA"));
                turmas.setSerie(rs.getString("SERIE"));
                turmas.setTurma(rs.getString("TURMA"));
                turmas.setTurno(rs.getString("TURNO"));
                turmas.setData1(rs.getString("DATA"));

                t.add(turmas);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            pst.close();
        }

        return t;
    }

    public void updateTurmas(Turmas t) throws SQLException {
        String sql = "UPDATE TURMAS SET SERIE = ?, TURMA = ?, TURNO = ?, DATA = ?, SEGUNDA = ?, TERCA = ?,"
                + "QUARTA = ?, QUINTA = ?, SEXTA = ? WHERE ID_TURMA = ?";

        pst = fc.getConexao().prepareCall(sql);

        pst.setString(1, t.getSerie());
        pst.setString(2, t.getTurma());
        pst.setString(3, t.getTurno());
        pst.setString(4, t.getData1());
        pst.setInt(5, t.getSegunda());
        pst.setInt(6, t.getTerca());
        pst.setInt(7, t.getQuarta());
        pst.setInt(8, t.getQuinta());
        pst.setInt(9, t.getSexta());
        pst.setInt(10, t.getId_Turma());
        pst.executeUpdate();

    }

    public void deleteTurmas(int idTurma) throws SQLException {
        String sql = "DELETE FROM TURMAS WHERE ID_TURMA = ?";

        pst = fc.getConexao().prepareCall(sql);

        pst.setInt(1, idTurma);

        pst.execute();

    }
    public boolean verificaTurmas(Turmas t) throws SQLException{
        boolean v = true;
        String sql = "SELECT * FROM TURMAS";
        
        pst = fc.getConexao().prepareStatement(sql);
        
        rs = pst.executeQuery();
        
        while (rs.next()) {
            if (t.getSerie().equals(rs.getString("SERIE")) &&
                    t.getTurma().equals(rs.getString("TURMA")) &&
                    t.getData1().equals(rs.getString("DATA")) &&
                    t.getTurno().equals(rs.getString("TURNO"))) {
                
                v = false;
            }
            
        }
        return v;
    }
    
    public boolean verificaTurmasAlter(Turmas t) throws SQLException{
        boolean v = true;
        String sql = "SELECT * FROM TURMAS WHERE ID_TURMA != ?";
        
        pst = fc.getConexao().prepareStatement(sql);
        
        pst.setInt(1, t.getId_Turma());
        rs = pst.executeQuery();
        
        while (rs.next()) {
            if (t.getSerie().equals(rs.getString("SERIE")) &&
                    t.getTurma().equals(rs.getString("TURMA")) &&
                    t.getData1().equals(rs.getString("DATA")) &&
                    t.getTurno().equals(rs.getString("TURNO"))) {
                
                v = false;
            }
            
        }
        return v;
    }
    
    public String[] preencherComboBoxTurma(){
        String sql = "SELECT * FROM TURMAS";
        String turmas[];
        int cont = 0;
        int tamanho = 0;
        try{
            pst = fc.getConexao().prepareStatement(sql);
            pst.executeQuery();
            rs = pst.getResultSet();
            while(rs.next()){
                tamanho++;
            }
            turmas = new String[tamanho];
            pst = fc.getConexao().prepareStatement(sql);
            pst.executeQuery();
            rs = pst.getResultSet();
            while(rs.next()){
                turmas[cont] = rs.getString("SERIE") + " " + rs.getString("TURMA");
                cont++;
            }
            
        }catch(SQLException ex){
            turmas = null;
            System.out.println(ex);
        }
        return turmas;
    }

}



