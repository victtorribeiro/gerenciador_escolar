/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.conexao.FactoryConnection;
import br.com.gerenciador.controller.Criptografar;
import br.com.gerenciador.entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 */
public class UsuarioDao {

    FactoryConnection fc = new FactoryConnection();
    PreparedStatement pst = null;
    ResultSet rs;

    public void cadastraUsuarios(Usuario u) throws Exception {
        String sql = "INSERT INTO USUARIOS(nome_usuario,usuario,senha,cargo) VALUES(?,?,?,?)";
        //Usuarios usu = new Usuarios();
        try {
            pst = fc.getConexao().prepareCall(sql);

            pst.setString(1, u.getNome());
            pst.setString(2, u.getUsuario());
            pst.setString(3, Criptografar.encriptografar(u.getSenha()));
            pst.setString(4, u.getCargo());

            pst.execute();

        } catch (Exception e) {

            System.out.println(e);

        } finally {

            pst.close();
        }
    }

    public List<Usuario> readUsuario() throws SQLException {

        List<Usuario> u = new ArrayList<>();

        try {
            pst = fc.getConexao().prepareStatement("SELECT * FROM USUARIOS WHERE ID_USUARIO > 1 ORDER BY ID_USUARIO");

            rs = pst.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt("ID_USUARIO"));
                usuario.setNome(rs.getString("NOME_USUARIO"));
                usuario.setUsuario(rs.getString("USUARIO"));
                usuario.setCargo(rs.getString("CARGO"));

                u.add(usuario);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            pst.close();
        }

        return u;
    }

    public void updateUsuario(Usuario u) throws SQLException {
        String sql = "UPDATE USUARIOS SET NOME_USUARIO = ?, USUARIO = ?, SENHA = ?, CARGO = ? WHERE ID_USUARIO = ?";

        pst = fc.getConexao().prepareCall(sql);

        pst.setString(1, u.getNome());
        pst.setString(2, u.getUsuario());
        pst.setString(3, Criptografar.encriptografar(u.getSenha()));
        pst.setString(4, u.getCargo());
        pst.setInt(5, u.getId_usuario());

        pst.executeUpdate();

    }

    public boolean verificaUsu(Usuario u) throws SQLException {
        String sql = "SELECT USUARIO FROM USUARIOS";
        boolean v = true;
        pst = fc.getConexao().prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            if (u.getUsuario().equals(rs.getString("USUARIO"))) {
                v = false;
            }
        }
        return v;
    }

    public boolean verificaUsuAlter(Usuario u) throws SQLException {
        String sql = "SELECT * FROM USUARIOS WHERE ID_USUARIO != ?";
        boolean v = true;
        pst = fc.getConexao().prepareStatement(sql);
        pst.setInt(1, u.getId_usuario());
        rs = pst.executeQuery();
        while (rs.next()) {
            if (u.getUsuario().equals(rs.getString("USUARIO"))) {
                v = false;
            }
        }
        return v;
    }

    public String[] preencherComboBoxProf() {
        String sql = "SELECT * FROM USUARIOS";
        String prof[];
        int cont = 0;
        int tamanho = 0;
        try {
            pst = fc.getConexao().prepareStatement(sql);
            pst.executeQuery();
            rs = pst.getResultSet();
            while (rs.next()) {
                tamanho++;
            }
            prof = new String[tamanho];
            pst = fc.getConexao().prepareStatement(sql);
            pst.executeQuery();
            rs = pst.getResultSet();
            while (rs.next()) {
                if (rs.getString("CARGO").equals("Professor")) {
                    prof[cont] = rs.getString("USUARIO");
                    cont++;
                }
            }

        } catch (SQLException ex) {
            prof = null;
            System.out.println(ex);
        }
        return prof;
    }

    public int buscaIdProfessor(String usu) throws SQLException {

        String sql = "SELECT * FROM USUARIOS WHERE USUARIO = ?";
        int v = 0;
        pst = fc.getConexao().prepareStatement(sql);
        pst.setString(1, usu);
        rs = pst.executeQuery();

        while (rs.next()) {
            v = rs.getInt("ID_USUARIO");
        }

        return v;
    }

    public String buscaNomeProfessor(int id) throws SQLException {

        String sql = "SELECT * FROM USUARIOS WHERE ID_USUARIO = ?";
        String v = "";
        pst = fc.getConexao().prepareStatement(sql);
        pst.setInt(1, id);
        rs = pst.executeQuery();

        while (rs.next()) {
            v = rs.getString("USUARIO");
        }

        return v;
    }

    public Usuario buscaDadosUsuario(int id) throws SQLException {
        Usuario usu = new Usuario();
        
        String sql = "SELECT * FROM USUARIOS WHERE ID_USUARIO = ?";

        pst = fc.getConexao().prepareStatement(sql);
        
        pst.setInt(1, id);
        
        rs = pst.executeQuery();
        while (rs.next()){
            usu.setId_usuario(id);
            usu.setNome(rs.getString("NOME_USUARIO"));
            usu.setUsuario(rs.getString("USUARIO"));
            usu.setCargo(rs.getString("CARGO"));
        }
        
        
        return usu;
    }
    
    public void updateUsuario2(Usuario u) throws SQLException {
        String sql = "UPDATE USUARIOS SET NOME_USUARIO = ?, USUARIO = ?, SENHA = ? WHERE ID_USUARIO = ?";

        pst = fc.getConexao().prepareCall(sql);

        pst.setString(1, u.getNome());
        pst.setString(2, u.getUsuario());
        pst.setString(3, Criptografar.encriptografar(u.getSenha()));
        pst.setInt(4, u.getId_usuario());

        pst.executeUpdate();

    }

}
