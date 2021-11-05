/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.conexao.FactoryConnection;
import br.com.gerenciador.entidades.PermutaAulas;
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
public class PermutaAulasDao {

    FactoryConnection fc = new FactoryConnection();
    PreparedStatement pst = null;
    ResultSet rs;

    public List<PermutaAulas> readHorarioPermuta1(PermutaAulas pa) throws SQLException {

        List<PermutaAulas> permAulas = new ArrayList<>();
        String sql = "SELECT * FROM HORARIO_AULAS WHERE TURMA = ? ORDER BY NUM_AULA";
        try {

            pst = fc.getConexao().prepareStatement(sql);
            //pst.setString(1, pa.getDiaSemana());
            pst.setString(1, pa.getTurma());

            rs = pst.executeQuery();

            while (rs.next()) {
                PermutaAulas p = new PermutaAulas();
                p.setAula(rs.getString("NUM_AULA"));
                p.setPorfMat(rs.getString(pa.getDiaSemana()));

                permAulas.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            pst.close();
        }

        return permAulas;
    }

    public void cadastraPermuta(PermutaAulas pa) throws Exception {
        String sql = "INSERT INTO PERMUTAS(ID_PROFESSOR1, TURMA, AULA, ID_PROFESSOR2, DATA_TROCA, DATA_REPOSICAO, OBSERVACAO, RESPOSTA) VALUES(?,?,?,?,?,?,?,?)";
        UsuarioDao usuD = new UsuarioDao();

        String[] usuario = pa.getPorfMat().split("/");
        //usuD.buscaIdProfessor(usuario[0]);

        try {
            pst = fc.getConexao().prepareCall(sql);

            pst.setInt(1, Principal_Professor.idProfessor);
            pst.setString(2, pa.getTurma());
            pst.setString(3, pa.getAula());
            pst.setInt(4, usuD.buscaIdProfessor(usuario[0]));
            pst.setString(5, pa.getData1());
            pst.setString(6, pa.getData2());
            pst.setString(7, pa.getObs());
            pst.setString(8, "Pendente");
            pst.execute();

        } catch (Exception e) {

            System.out.println(e);

        } finally {

            pst.close();
        }
    }

    public boolean solicitacaoPermuta() throws SQLException {
        String sql = "SELECT * FROM PERMUTAS WHERE RESPOSTA = 'Pendente'";
        boolean retorno = false;
        pst = fc.getConexao().prepareStatement(sql);

        rs = pst.executeQuery();

        while (rs.next()) {
            if (Principal_Professor.idProfessor == rs.getInt("ID_PROFESSOR2")) {
                retorno = true;
            }
        }

        return retorno;
    }

    public PermutaAulas consultaPermutas() throws SQLException {
        String sql = "SELECT * FROM PERMUTAS WHERE RESPOSTA = 'Pendente' AND ID_PROFESSOR2 = ?";

        PermutaAulas pa = new PermutaAulas();

        UsuarioDao usuD = new UsuarioDao();

        pst = fc.getConexao().prepareStatement(sql);

        pst.setInt(1, Principal_Professor.idProfessor);

        rs = pst.executeQuery();

        while (rs.next()) {
            pa.setIdPermuta(rs.getInt("ID_PERMUTA"));
            pa.setProf1(usuD.buscaNomeProfessor(rs.getInt("ID_PROFESSOR1")));
            pa.setProf2(usuD.buscaNomeProfessor(rs.getInt("ID_PROFESSOR2")));
            pa.setTurma(rs.getString("TURMA"));
            pa.setAula(rs.getString("AULA"));
            pa.setData1(rs.getString("DATA_TROCA"));
            pa.setData2(rs.getString("DATA_REPOSICAO"));
            pa.setObs(rs.getString("OBSERVACAO"));
        }

        return pa;
    }

    public void respostaPermuta(PermutaAulas pa) throws SQLException {
        String sql = "UPDATE PERMUTAS SET RESPOSTA = ? WHERE ID_PERMUTA = ?";

        pst = fc.getConexao().prepareCall(sql);
        pst.setString(1, pa.getResposta());
        pst.setInt(2, pa.getIdPermuta());

        pst.executeUpdate();

    }

    public List<PermutaAulas> readPermutas() throws SQLException {

        List<PermutaAulas> p = new ArrayList<>();
        UsuarioDao usuD = new UsuarioDao();
        try {
            pst = fc.getConexao().prepareStatement("SELECT * FROM PERMUTAS WHERE RESPOSTA = 'Aceitar' ORDER BY ID_PERMUTA");

            rs = pst.executeQuery();

            while (rs.next()) {

                PermutaAulas perm = new PermutaAulas();
                perm.setProf1(usuD.buscaNomeProfessor(rs.getInt("ID_PROFESSOR1")));
                perm.setProf2(usuD.buscaNomeProfessor(rs.getInt("ID_PROFESSOR2")));
                perm.setTurma(rs.getString("TURMA"));
                perm.setAula(rs.getString("AULA"));
                perm.setData1(rs.getString("DATA_TROCA"));
                perm.setData2(rs.getString("DATA_REPOSICAO"));
                perm.setObs(rs.getString("OBSERVACAO"));

                p.add(perm);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            pst.close();
        }

        return p;
    }

    public List<PermutaAulas> readHorarioPermuta2(PermutaAulas pa) throws SQLException {

        List<PermutaAulas> permAulas = new ArrayList<>();
        String sql = "SELECT * FROM HORARIO_AULAS WHERE TURMA = ? ORDER BY NUM_AULA";
        try {
            UsuarioDao ud = new UsuarioDao();
            
            pst = fc.getConexao().prepareStatement(sql);
            //pst.setString(1, pa.getDiaSemana());
            pst.setString(1, pa.getTurma());

            rs = pst.executeQuery();

            while (rs.next()) {
                String v = rs.getString(pa.getDiaSemana());
                String[] v1 = new String[1];
                v1 = v.split("/");
                String v2 = ud.buscaNomeProfessor(Principal_Professor.idProfessor);
                if (v1[0].equals(v2)) {

                    PermutaAulas p = new PermutaAulas();
                    p.setAula(rs.getString("NUM_AULA"));
                    p.setPorfMat(rs.getString(pa.getDiaSemana()));
                    permAulas.add(p);
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            pst.close();
        }

        return permAulas;
    }

}
