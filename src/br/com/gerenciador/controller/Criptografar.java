/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.controller;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author Victor
 */
public class Criptografar {
    public static String encriptografar(String senha){
        String retorno = "";
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1,md.digest(senha.getBytes()));
            retorno = hash.toString(15);
        } catch (Exception e) {
            System.out.println("Erro Encriptografar!" + e);
        }
        
        
        return retorno;
    }
}
