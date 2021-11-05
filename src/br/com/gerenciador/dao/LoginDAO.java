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

public class LoginDAO {

    public Usuario validaLogin(Usuario u) throws SQLException {

        u.setCargo("");

        FactoryConnection fc = new FactoryConnection();

        String sql = "SELECT * FROM USUARIOS";

        PreparedStatement ps = fc.getConexao().prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            if (u.getUsuario().equals(rs.getString("usuario"))) {
                if (Criptografar.encriptografar(u.getSenha()).equals(rs.getString("senha"))) {
                    u.setId_usuario(rs.getInt("ID_USUARIO"));
                    u.setCargo(rs.getString("CARGO"));
                }
            }
        }

        return u;
    }
}
