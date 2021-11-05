/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.conexao.FactoryConnection;
import br.com.gerenciador.entidades.Horario_Aulas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class Horario_AulasDao {

    FactoryConnection fc = new FactoryConnection();
    PreparedStatement pst = null;
    ResultSet rs;

    public int qtdAulas(Horario_Aulas ha) throws SQLException {
        Horario_Aulas horarioAulas = new Horario_Aulas();
        String[] v = ha.getTurma().split(" ");
        String dia = horarioAulas.diaSemana(ha.getDiaSemana());
        int r = 0;
        String sql = "SELECT * FROM TURMAS WHERE SERIE = ? AND TURMA = ?";
        try {
            pst = fc.getConexao().prepareCall(sql);

            //pst.setString(1, dia);
            pst.setString(1, v[0] + " " + v[1]);
            pst.setString(2, v[2]);

            rs = pst.executeQuery();

            while (rs.next()) {
                r = rs.getInt(dia);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pst.close();
        }

        return r;
    }

    public void cadastraHorario(String[] turma, String[] num_aula, String[] segunda, String[] terca, String[] quarta, String[] quinta, String[] sexta) throws SQLException {

        String sql = "INSERT INTO HORARIO_AULAS(TURMA, NUM_AULA, SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA)"
                + "VALUES(?,?,?,?,?,?,?)";
        String profMat[];
        try {
            pst = fc.getConexao().prepareStatement(sql);

            for (int i = 0; i < num_aula.length; i++) {
                pst.setString(1, turma[i]);
                pst.setString(2, num_aula[i]);
                pst.setString(3, segunda[i]);
                pst.setString(4, terca[i]);
                pst.setString(5, quarta[i]);
                pst.setString(6, quinta[i]);
                pst.setString(7, sexta[i]);

                pst.execute();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            pst.close();
        }

    }

    public List<Horario_Aulas> readHorario(String turma) throws SQLException {

        List<Horario_Aulas> haList = new ArrayList<>();
        String sql = "SELECT * FROM HORARIO_AULAS WHERE TURMA = ? ORDER BY NUM_AULA";
        String compara = "";
        try {
            pst = fc.getConexao().prepareStatement(sql);

            pst = fc.getConexao().prepareStatement(sql);
            pst.setString(1, turma);

            rs = pst.executeQuery();

            while (rs.next()) {
                Horario_Aulas ha = new Horario_Aulas();
                ha.setNum_aula(rs.getString("NUM_AULA"));
                ha.setSegunda(rs.getString("SEGUNDA"));
                ha.setTerca(rs.getString("TERCA"));
                ha.setQuarta(rs.getString("QUARTA"));
                ha.setQuinta(rs.getString("QUINTA"));
                ha.setSexta(rs.getString("SEXTA"));

                haList.add(ha);
                compara = rs.getString("NUM_AULA");
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            pst.close();
        }

        return haList;
    }

    public String verificaHorario(String[] turma, String[] num_aula, String[] segunda, String[] terca, String[] quarta,
            String[] quinta, String[] sexta) throws SQLException {

        // =============================================
        String sql = "SELECT * FROM HORARIO_AULAS WHERE SEGUNDA = ? AND NUM_AULA = ?";
        String verifica = "";
        pst = fc.getConexao().prepareStatement(sql);
        for (int i = 0; i < num_aula.length; i++) {
            //pst.setString(1, turma[i]);
            pst.setString(1, segunda[i]);
            pst.setString(2, num_aula[i]);
            //pst.setString(4, terca[i]);
            //pst.setString(5, quarta[i]);
            //pst.setString(6, quinta[i]);
            //pst.setString(7, sexta[i]);

            pst.execute();

            rs = pst.executeQuery();

            while (rs.next()) {
                verifica = rs.getString("TURMA") + " / " + rs.getString("SEGUNDA") + " / " + rs.getString("NUM_AULA") + " / SEGUNDA";
                JOptionPane.showMessageDialog(null, "Choque de horário na Segunda-feira!\n"
                        + "Turma: " + rs.getString("TURMA") + "\n"
                        + "Aula: "+ rs.getString("NUM_AULA") + "\n"
                        + "Prof/Matéria: " + rs.getString("SEGUNDA"));
            }

        }

        if (verifica.equals("")) {
            sql = "SELECT * FROM HORARIO_AULAS WHERE TERCA = ? AND NUM_AULA = ?";
            pst = fc.getConexao().prepareStatement(sql);
            for (int i = 0; i < num_aula.length; i++) {
                //pst.setString(1, turma[i]);
                //pst.setString(1, segunda[i]);
                pst.setString(1, terca[i]);
                pst.setString(2, num_aula[i]);
                //pst.setString(5, quarta[i]);
                //pst.setString(6, quinta[i]);
                //pst.setString(7, sexta[i]);

                pst.execute();

                rs = pst.executeQuery();

                while (rs.next()) {
                    verifica = rs.getString("TURMA") + " / " + rs.getString("TERCA") + " / " + rs.getString("NUM_AULA") + " / TERCA";
                    JOptionPane.showMessageDialog(null, "Choque de horário na Terça-feira!\n"
                        + "Turma: " + rs.getString("TURMA") + "\n"
                        + "Aula: "+ rs.getString("NUM_AULA") + "\n"
                        + "Prof/Matéria: " + rs.getString("TERCA"));
                }

            }
        } if (verifica.equals("")) {
            sql = "SELECT * FROM HORARIO_AULAS WHERE QUARTA = ? AND NUM_AULA = ?";
            pst = fc.getConexao().prepareStatement(sql);
            for (int i = 0; i < num_aula.length; i++) {
                //pst.setString(1, turma[i]);
                //pst.setString(1, segunda[i]);
                //pst.setString(1, terca[i]);
                pst.setString(1, quarta[i]);
                pst.setString(2, num_aula[i]);
                //pst.setString(6, quinta[i]);
                //pst.setString(7, sexta[i]);

                pst.execute();

                rs = pst.executeQuery();

                while (rs.next()) {
                    verifica = rs.getString("TURMA") + " / " + rs.getString("QUARTA") + " / " + rs.getString("NUM_AULA") + " / QUARTA";
                    JOptionPane.showMessageDialog(null, "Choque de horário na Quarta-feira!\n"
                        + "Turma: " + rs.getString("TURMA") + "\n"
                        + "Aula: "+ rs.getString("NUM_AULA") + "\n"
                        + "Prof/Matéria: " + rs.getString("QUARTA"));
                }

            }
        } if (verifica.equals("")) {
            sql = "SELECT * FROM HORARIO_AULAS WHERE QUINTA = ? AND NUM_AULA = ?";
            pst = fc.getConexao().prepareStatement(sql);
            for (int i = 0; i < num_aula.length; i++) {
                //pst.setString(1, turma[i]);
                //pst.setString(1, segunda[i]);
                //pst.setString(1, terca[i]);
                pst.setString(1, quinta[i]);
                pst.setString(2, num_aula[i]);
                //pst.setString(5, quarta[i]);
                //pst.setString(7, sexta[i]);

                pst.execute();

                rs = pst.executeQuery();

                while (rs.next()) {
                    verifica = rs.getString("TURMA") + " / " + rs.getString("QUINTA") + " / " + rs.getString("NUM_AULA") + " / QUINTA";
                    JOptionPane.showMessageDialog(null, "Choque de horário na Quinta-feira!\n"
                        + "Turma: " + rs.getString("TURMA") + "\n"
                        + "Aula: "+ rs.getString("NUM_AULA") + "\n"
                        + "Prof/Matéria: " + rs.getString("QUINTA"));
                }

            }
        } if (verifica.equals("")) {
            sql = "SELECT * FROM HORARIO_AULAS WHERE SEXTA = ? AND NUM_AULA = ?";
            pst = fc.getConexao().prepareStatement(sql);
            for (int i = 0; i < num_aula.length; i++) {
                //pst.setString(1, turma[i]);
                //pst.setString(1, segunda[i]);
                //pst.setString(1, terca[i]);
                //pst.setString(1, quinta[i]);
                //pst.setString(5, quarta[i]);
                pst.setString(1, sexta[i]);
                pst.setString(2, num_aula[i]);

                pst.execute();

                rs = pst.executeQuery();

                while (rs.next()) {
                    verifica = rs.getString("TURMA") + " / " + rs.getString("SEXTA") + " / " + rs.getString("NUM_AULA") + " / SEXTA";
                    JOptionPane.showMessageDialog(null, "Choque de horário na Sexta-feira!\n"
                        + "Turma: " + rs.getString("TURMA") + "\n"
                        + "Aula: "+ rs.getString("NUM_AULA") + "\n"
                        + "Prof/Matéria: " + rs.getString("SEXTA"));
                }

            }
        }
        return verifica;
    }
    
    public boolean verificaTurma(String turma) throws SQLException{
        String sql = "SELECT * FROM HORARIO_AULAS WHERE TURMA = ?";
        boolean v = false;
        pst = fc.getConexao().prepareStatement(sql);
        
        pst.setString(1, turma);
        rs = pst.executeQuery();
        while(rs.next()){
            v = true;
        }
        return v;
    }
    
    public void updateHorario(String[] turma, String[] num_aula, String[] segunda, String[] terca, String[] quarta,
            String[] quinta, String[] sexta) throws SQLException{
        
        int[] id = new int[num_aula.length + 1];
        int i = 0;
        int y = 0;
        String sql = "SELECT * FROM HORARIO_AULAS WHERE TURMA = ?";
        
        pst = fc.getConexao().prepareStatement(sql);
        pst.setString(1, turma[0]);
        rs = pst.executeQuery();
        
        while(rs.next()){
            i = rs.getInt("ID_HORARIO");
            y++;
            id[y] = i;
            deleteHorario(i);
            //System.out.println(id[i]);
        }
        
    }
    
    public void deleteHorario(int id) throws SQLException{
        String sql = "DELETE FROM HORARIO_AULAS WHERE ID_HORARIO = ?";
        
        pst = fc.getConexao().prepareStatement(sql);
        pst.setInt(1, id);
        pst.execute();
        
    }
    public void excluirHorario(String turma) throws SQLException{
        
        int i = 0;
        String sql = "SELECT * FROM HORARIO_AULAS WHERE TURMA = ?";
        
        pst = fc.getConexao().prepareStatement(sql);
        pst.setString(1, turma);
        rs = pst.executeQuery();
        
        while(rs.next()){
            i = rs.getInt("ID_HORARIO");
            deleteHorario(i);
            //System.out.println(id[i]);
        }
        
    }

}
