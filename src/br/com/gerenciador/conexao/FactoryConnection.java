/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class FactoryConnection {
    private Connection conn;
    
    private void conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //conn = DriverManager.getConnection("jdbc:mysql://sql158.main-hosting.eu/u904983886_geren", "u904983886_root","131213");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/u904983886_geren", "root","123456");
        } catch (ClassNotFoundException e) {
            System.out.println("Classe não encontrada, adicione o driver jdbc nas biblioteca");
            Logger.getLogger(FactoryConnection.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
    
    public Connection getConexao(){
        conectar();
        
        return conn;
    }
    
}

