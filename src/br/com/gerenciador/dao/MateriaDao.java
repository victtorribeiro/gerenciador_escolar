/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.conexao.FactoryConnection;
import br.com.gerenciador.entidades.Materia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 */
public class MateriaDao {

    FactoryConnection fc = new FactoryConnection();
    PreparedStatement pst = null;
    ResultSet rs;

    public void cadastraMateria(Materia m) throws Exception {
        String sql = "INSERT INTO MATERIAS(MATERIA) VALUES(?)";
        //Usuarios usu = new Usuarios();
        try {
            pst = fc.getConexao().prepareCall(sql);

            pst.setString(1, m.getMateria());

            pst.execute();

        } catch (SQLException e) {

            System.out.println(e);

        } finally {

            pst.close();
        }
    }

    public List<Materia> readMateria() throws SQLException {

        List<Materia> m = new ArrayList<>();

        try {
            pst = fc.getConexao().prepareStatement("SELECT * FROM MATERIAS ORDER BY ID_MATERIA");

            rs = pst.executeQuery();

            while (rs.next()) {

                Materia materia = new Materia();
                materia.setId_materia(rs.getInt("ID_MATERIA"));
                materia.setMateria(rs.getString("MATERIA"));

                m.add(materia);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            pst.close();
        }

        return m;
    }

    public void updateMateria(Materia m) throws SQLException {
        String sql = "UPDATE MATERIAS SET MATERIA = ? WHERE ID_MATERIA = ?";

        pst = fc.getConexao().prepareCall(sql);

        pst.setString(1, m.getMateria());
        pst.setInt(2, m.getId_materia());

        pst.executeUpdate();

    }

    public boolean VerificaMateria(Materia m) throws SQLException {
        String sql = "SELECT * FROM MATERIAS";
        boolean v = true;
        pst = fc.getConexao().prepareStatement(sql);

        rs = pst.executeQuery();

        while (rs.next()) {
            if (m.getMateria().equals(rs.getString("MATERIA"))) {
                v = false;
            }

        }
        return v;
    }

    public boolean VerificaMateriaAlter(Materia m) throws SQLException {
        String sql = "SELECT * FROM MATERIAS WHERE ID_MATERIA != ?";
        boolean v = true;
        pst = fc.getConexao().prepareStatement(sql);
        pst.setInt(1, m.getId_materia());
        rs = pst.executeQuery();

        while (rs.next()) {
            if (m.getMateria().equals(rs.getString("MATERIA"))) {
                v = false;
            }

        }
        return v;
    }

    public String[] preencherComboBoxMat() {
        String sql = "SELECT * FROM MATERIAS";
        String mat[];
        int cont = 0;
        int tamanho = 0;
        try {
            pst = fc.getConexao().prepareStatement(sql);
            pst.executeQuery();
            rs = pst.getResultSet();
            while (rs.next()) {
                tamanho++;
            }
            mat = new String[tamanho];
            pst = fc.getConexao().prepareStatement(sql);
            pst.executeQuery();
            rs = pst.getResultSet();
            while (rs.next()) {
                mat[cont] = rs.getString("MATERIA");
                cont++;
            }

        } catch (SQLException ex) {
            mat = null;
            System.out.println(ex);
        }
        return mat;
    }

}
