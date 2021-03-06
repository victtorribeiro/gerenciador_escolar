/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.views.adm;

import br.com.gerenciador.dao.MateriaDao;
import br.com.gerenciador.dao.UsuarioDao;
import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor M
 */
public class Cadastra_Horario_2 extends javax.swing.JInternalFrame {

    /**
     * Creates new form Cadastra_Horario_2
     */
    int linha = 100, coluna = 100;

    public Cadastra_Horario_2(int coluna, int linha) {
        initComponents();
        this.linha = linha;
        this.coluna = coluna;
        preencherProf();
        preencherMat();
    }

    public Cadastra_Horario_2() {
        initComponents();
        preencherProf();
        preencherMat();
        preencheQtdAulas(this.qtd);
        jLabelAula.setText(i + 1 + "º Aula");
    }
    int i = 0, qtd;
    String dia;

    public Cadastra_Horario_2(int qtdAula, String diaSemana) {
        initComponents();

        this.qtd = qtdAula;
        this.dia = diaSemana;
        preencherProf();
        preencherMat();
        preencheQtdAulas(qtdAula);

        jLabelAula.setText(i + 1 + "º Aula");
    }

    public void preencheQtdAulas(int qtd) {
        if (Cadastra_Horario.jTableHorario.getValueAt(5, 0) == null) {
            for (int i = 0; i < qtd; i++) {
                Cadastra_Horario.jTableHorario.setValueAt(i + 1 + "º", i, 0);
            }
        }
    }

    public void setPosition() {

        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);

    }

    public void preencherProf() {
        UsuarioDao ud = new UsuarioDao();
        String prof[] = ud.preencherComboBoxProf();
        jComboBoxProfessor.removeAllItems();
        for (int i = 0; i < prof.length; i++) {
            jComboBoxProfessor.addItem(prof[i]);
        }
    }

    public void preencherMat() {
        MateriaDao md = new MateriaDao();
        String mat[] = md.preencherComboBoxMat();
        jComboBoxMateria.removeAllItems();
        for (int i = 0; i < mat.length; i++) {
            jComboBoxMateria.addItem(mat[i]);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelAula = new javax.swing.JLabel();
        jComboBoxProfessor = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxMateria = new javax.swing.JComboBox<>();
        jButtonOk = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro Professor/Matéria ");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jComboBoxProfessor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Professor:");

        jLabel2.setText("Matéria:");

        jComboBoxMateria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonOk.setBackground(new java.awt.Color(144, 198, 144));
        jButtonOk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonOk.setText("Ok");
        jButtonOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonOkMouseClicked(evt);
            }
        });
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(231, 140, 140));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAula, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxMateria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAula, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        if (coluna != 100 && linha != 100) {
            Cadastra_Horario.jTableHorario.setValueAt(jComboBoxProfessor.getSelectedItem().toString() + "/"
                    + jComboBoxMateria.getSelectedItem().toString(), linha, coluna);
            Cadastra_Horario.jButtonOk.setEnabled(true);
            dispose();
        } else {

            if (this.i < this.qtd && this.dia.equals("SEGUNDA")) {

                Cadastra_Horario.jTableHorario.setValueAt(jComboBoxProfessor.getSelectedItem().toString() + "/"
                        + jComboBoxMateria.getSelectedItem().toString(), this.i, 1);
                this.i++;
            } else if (this.i < this.qtd && this.dia.equals("TERCA")) {

                Cadastra_Horario.jTableHorario.setValueAt(jComboBoxProfessor.getSelectedItem().toString() + "/"
                        + jComboBoxMateria.getSelectedItem().toString(), this.i, 2);
                this.i++;
            } else if (this.i < this.qtd && this.dia.equals("QUARTA")) {

                Cadastra_Horario.jTableHorario.setValueAt(jComboBoxProfessor.getSelectedItem().toString() + "/"
                        + jComboBoxMateria.getSelectedItem().toString(), this.i, 3);
                this.i++;
            } else if (this.i < this.qtd && this.dia.equals("QUINTA")) {

                Cadastra_Horario.jTableHorario.setValueAt(jComboBoxProfessor.getSelectedItem().toString() + "/"
                        + jComboBoxMateria.getSelectedItem().toString(), this.i, 4);
                this.i++;
            } else if (this.i < this.qtd && this.dia.equals("SEXTA")) {

                Cadastra_Horario.jTableHorario.setValueAt(jComboBoxProfessor.getSelectedItem().toString() + "/"
                        + jComboBoxMateria.getSelectedItem().toString(), this.i, 5);

                Cadastra_Horario.jButtonSalvar.setEnabled(true);
                this.i++;
            }
            if (this.i == this.qtd) {
                Cadastra_Horario.jButtonOk.setEnabled(true);
                Cadastra_Horario.jComboBoxDiaSemana.setEnabled(true);
                dispose();
            }
            jLabelAula.setText(i + 1 + "º Aula");
            JOptionPane.showMessageDialog(null, "Aula inserida no horário!","Informação",1);
        }
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOkMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonOkMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Cadastra_Horario.jButtonOk.setEnabled(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JComboBox<String> jComboBoxMateria;
    private javax.swing.JComboBox<String> jComboBoxProfessor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAula;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
