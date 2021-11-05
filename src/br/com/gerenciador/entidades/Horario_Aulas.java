/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.entidades;

/**
 *
 * @author Victor
 */
public class Horario_Aulas {
    
    private String turma, professor, num_aula, materia, prof_mat, dia_semana, diaSemana;
    private String segunda, terca, quarta, quinta, sexta;

    public String getSegunda() {
        return segunda;
    }

    public void setSegunda(String segunda) {
        this.segunda = segunda;
    }

    public String getTerca() {
        return terca;
    }

    public void setTerca(String terca) {
        this.terca = terca;
    }

    public String getQuarta() {
        return quarta;
    }

    public void setQuarta(String quarta) {
        this.quarta = quarta;
    }

    public String getQuinta() {
        return quinta;
    }

    public void setQuinta(String quinta) {
        this.quinta = quinta;
    }

    public String getSexta() {
        return sexta;
    }

    public void setSexta(String sexta) {
        this.sexta = sexta;
    }
    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public String getProf_mat() {
        return prof_mat;
    }

    public void setProf_mat(String prof_mat) {
        this.prof_mat = prof_mat;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String prof) {
        this.professor = prof;
    }

    public String getNum_aula() {
        return num_aula;
    }

    public void setNum_aula(String num_aula) {
        this.num_aula = num_aula;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Horario_Aulas() {
    }
    
    
    
    public String diaSemana(String diaSemana){
        if(diaSemana.equals("Segunda-feira")){
            return "SEGUNDA";
        }else if(diaSemana.equals("Terça-feira")){
            return "TERCA";
        }else if(diaSemana.equals("Quarta-feira")){
            return "QUARTA";
        }else if(diaSemana.equals("Quinta-feira")){
            return "QUINTA";
        }else if(diaSemana.equals("Sexta-feira")){
            return "SEXTA";
        }else{
            return null;
        }
    }
    
    
}
