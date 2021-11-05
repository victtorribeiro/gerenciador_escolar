/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.conexao.FactoryConnection;
import br.com.gerenciador.entidades.Atividades_Avaliativas;
import br.com.gerenciador.views.prof.Principal_Professor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 */
public class Atividades_AvaliativasDao {

    FactoryConnection fc = new FactoryConnection();
    PreparedStatement pst = null;
    ResultSet rs;

    public void cadastraAtividade(Atividades_Avaliativas aa) throws SQLException {
        String sql = "INSERT INTO ATIVIDADES_AVALIATIVAS(ID_PROFESSOR, MATERIA, TURMA, DATA, OBSERVACAO)"
                + "VALUES(?,?,?,?,?)";
        try {
            pst = fc.getConexao().prepareStatement(sql);
            pst.setInt(1, aa.getId_professor());
            pst.setString(2, aa.getMateria());
            pst.setString(3, aa.getTurma());
            pst.setString(4, aa.getData());
            pst.setString(5, aa.getObservacao());

            pst.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            pst.close();
        }

    }

    public List<Atividades_Avaliativas> readAtividades() throws SQLException {

        List<Atividades_Avaliativas> aa = new ArrayList<>();

        try {
            pst = fc.getConexao().prepareStatement("SELECT * FROM ATIVIDADES_AVALIATIVAS WHERE ID_PROFESSOR = ? ORDER BY DATA");

            pst.setInt(1, Principal_Professor.idProfessor);

            rs = pst.executeQuery();
            while (rs.next()) {
                Atividades_Avaliativas atividades = new Atividades_Avaliativas();

                atividades.setId_atividade(rs.getInt("ID_ATIVIDADE"));
                atividades.setTurma(rs.getString("TURMA"));
                atividades.setMateria(rs.getString("MATERIA"));
                atividades.setData(rs.getString("DATA"));
                atividades.setObservacao(rs.getString("OBSERVACAO"));

                aa.add(atividades);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            pst.close();
        }

        return aa;
    }
    
    
    public void updateAtividade(Atividades_Avaliativas aa) throws SQLException {
        String sql = "UPDATE ATIVIDADES_AVALIATIVAS SET ID_PROFESSOR = ?, MATERIA = ?, DATA = ?, TURMA = ? , OBSERVACAO = ? WHERE ID_ATIVIDADE = ?";

        pst = fc.getConexao().prepareCall(sql);

        pst.setInt(1, aa.getId_professor());
        pst.setString(2, aa.getMateria());
        pst.setString(3, aa.getData());
        pst.setString(4, aa.getTurma());
        pst.setString(5, aa.getObservacao());
        pst.setInt(6, aa.getId_atividade());

        pst.executeUpdate();

    }
    
    public void deleteAtividade(int idAtividade) throws SQLException {
        String sql = "DELETE FROM ATIVIDADES_AVALIATIVAS WHERE ID_ATIVIDADE = ?";

        pst = fc.getConexao().prepareCall(sql);

        pst.setInt(1, idAtividade);
        
        pst.execute();
    }   
}
