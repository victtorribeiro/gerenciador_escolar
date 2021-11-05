/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.entidades;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Victor
 */
public class PermutaAulas {

    private String turma, diaSemana, aula, porfMat;
    private String data1, data2, obs, prof1, prof2;
    private String resposta;
    private int idPermuta;
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdPermuta() {
        return idPermuta;
    }

    public void setIdPermuta(int idPermuta) {
        this.idPermuta = idPermuta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getProf1() {
        return prof1;
    }

    public void setProf1(String prof1) {
        this.prof1 = prof1;
    }

    public String getProf2() {
        return prof2;
    }

    public void setProf2(String prof2) {
        this.prof2 = prof2;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }
public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getPorfMat() {
        return porfMat;
    }

    public void setPorfMat(String porfMat) {
        this.porfMat = porfMat;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String checaDia(Calendar data) {
        // se for domingo
        String checaDia = "";
        if (data.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {//segunda
            checaDia = "SEGUNDA";
        } else if (data.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {//terça
            checaDia = "TERCA";
        } else if (data.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {//terça
            checaDia = "QUARTA";
        } else if (data.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {//terça
            checaDia = "QUINTA";
        } else if (data.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {//terça
            checaDia = "SEXTA";
        }
        return checaDia;
    }

}
