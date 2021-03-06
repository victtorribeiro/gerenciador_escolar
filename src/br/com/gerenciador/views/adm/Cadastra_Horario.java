/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.views.adm;

import br.com.gerenciador.dao.Horario_AulasDao;
import br.com.gerenciador.dao.TurmasDao;
import br.com.gerenciador.entidades.Horario_Aulas;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raquel
 */
public class Cadastra_Horario extends javax.swing.JInternalFrame {

    /**
     * Creates new form Cadastra_Horario
     */
    boolean v;

    public Cadastra_Horario() {
        initComponents();

        preencherTurmas();
        v = false;
        //jButtonSalvar.setEnabled(false);
    }

    public Cadastra_Horario(String turma, int num) throws SQLException {
        initComponents();

        preencherTurmas();
        //jButtonSalvar.setEnabled(false);
        jComboBoxTurma.setSelectedIndex(num);
        jComboBoxTurma.setEnabled(false);
        readJTableHorario(turma);
        v = true;
    }

    public void readJTableHorario(String turma) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jTableHorario.getModel();

        modelo.setNumRows(0);
        Horario_AulasDao had = new Horario_AulasDao();
        for (Horario_Aulas ha : had.readHorario(turma)) {
            modelo.addRow(new Object[]{
                ha.getNum_aula(),
                ha.getSegunda(),
                ha.getTerca(),
                ha.getQuarta(),
                ha.getQuinta(),
                ha.getSexta()
            });
        }
        modelo.addRow(new Object[]{});
    }

    public void setPosition() {

        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);

    }

    public void preencherTurmas() {
        TurmasDao td = new TurmasDao();
        String turma[] = td.preencherComboBoxTurma();
        jComboBoxTurma.removeAllItems();
        jComboBoxTurma.addItem("Selecione");
        for (int i = 0; i < turma.length; i++) {
            jComboBoxTurma.addItem(turma[i]);
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
        jComboBoxTurma = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxDiaSemana = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHorario = new javax.swing.JTable();
        jButtonOk = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();

        setIconifiable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jComboBoxTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxTurmaMouseClicked(evt);
            }
        });
        jComboBoxTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTurmaActionPerformed(evt);
            }
        });

        jLabel1.setText("Turma:");

        jLabel2.setText("Dia da semana:");

        jComboBoxDiaSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Segunda-feira", "Ter??a-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira" }));

        jTableHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Aula", "Segunda-feira", "Ter??a-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableHorario);

        jButtonOk.setText("Ok");
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

        jButtonSalvar.setBackground(new java.awt.Color(144, 198, 144));
        jButtonSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOk))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Principal_Diretor.jMenuItemCadastraHorario.setEnabled(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed

        if (v) {
            Horario_Aulas ha = new Horario_Aulas();
            
            ha.setTurma(jComboBoxTurma.getSelectedItem().toString());
            
            ha.setDiaSemana(jComboBoxDiaSemana.getSelectedItem().toString());
            
            Horario_AulasDao had = new Horario_AulasDao();
            int linha = jTableHorario.getSelectedRow();
            int coluna = jTableHorario.getSelectedColumn();
            Cadastra_Horario_2 ch2 = new Cadastra_Horario_2(coluna, linha);
            
            Principal_Diretor.jDesktopPane_Diretor.add(ch2);
            
            ch2.setVisible(true);
            
            ch2.setPosition();
            
            jComboBoxTurma.setEnabled(false);
            jComboBoxDiaSemana.setEditable(false);
            jButtonOk.setEnabled(false);
        } else {

            try {
                Horario_Aulas ha = new Horario_Aulas();

                ha.setTurma(jComboBoxTurma.getSelectedItem().toString());
                ha.setDiaSemana(jComboBoxDiaSemana.getSelectedItem().toString());

                Horario_AulasDao had = new Horario_AulasDao();
                if (had.verificaTurma(ha.getTurma())) {
                    JOptionPane.showMessageDialog(null, "J?? existe um hor??rio de aulas cadastrado para esta turma!");
                    preencherTurmas();
                } else {
                    try {
                        Cadastra_Horario_2 ch2 = new Cadastra_Horario_2(had.qtdAulas(ha), ha.diaSemana(ha.getDiaSemana()));
                        Principal_Diretor.jDesktopPane_Diretor.add(ch2);
                        ch2.setVisible(true);
                        ch2.setPosition();
                    } catch (SQLException ex) {
                        Logger.getLogger(Cadastra_Horario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jComboBoxTurma.setEnabled(false);
                    jComboBoxDiaSemana.setEditable(false);
                    jButtonOk.setEnabled(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cadastra_Horario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed

        if (v) {
            int qtd = 0;
            int qtdT = 0;
            int i;
            Horario_Aulas ha = new Horario_Aulas();

            String[] turma = new String[600];

            //String[] mat_prof = new String[600];
            String[] segunda = new String[600];
            String[] terca = new String[600];
            String[] quarta = new String[600];
            String[] quinta = new String[600];
            String[] sexta = new String[600];

            while (jTableHorario.getValueAt(qtd, 0) != null) {
                qtd++;
            }
            int x = qtd * 5;
            String[] num_aula = new String[qtd];
            if (qtd == 0) {
                JOptionPane.showMessageDialog(null, "Insira os dados para os hor??rios", "Informa????o", 1);
            } else {
                for (i = 0; i < qtd; i++) {
                    //for (int y = 1; y <= 5; y++) {
                    turma[i] = jComboBoxTurma.getSelectedItem().toString();
                    num_aula[i] = jTableHorario.getValueAt(i, 0).toString();
                    if (jTableHorario.getValueAt(i, 1) == null) {
                        segunda[i] = "";
                    } else {
                        segunda[i] = jTableHorario.getValueAt(i, 1).toString();
                    }
                    if (jTableHorario.getValueAt(i, 2) == null) {
                        terca[i] = "";
                    } else {
                        terca[i] = jTableHorario.getValueAt(i, 2).toString();
                    }
                    if (jTableHorario.getValueAt(i, 3) == null) {
                        quarta[i] = "";
                    } else {
                        quarta[i] = jTableHorario.getValueAt(i, 3).toString();
                    }
                    if (jTableHorario.getValueAt(i, 4) == null) {
                        quinta[i] = "";
                    } else {
                        quinta[i] = jTableHorario.getValueAt(i, 4).toString();
                    }
                    if (jTableHorario.getValueAt(i, 5) == null) {
                        sexta[i] = "";
                    } else {
                        sexta[i] = jTableHorario.getValueAt(i, 5).toString();
                    }

                }
                Horario_AulasDao had = new Horario_AulasDao();
                try {
                        had.updateHorario(turma, num_aula, segunda, terca, quarta, quinta, sexta);
                    if (had.verificaHorario(turma, num_aula, segunda, terca, quarta, quinta, sexta) == "") {
                        had.cadastraHorario(turma, num_aula, segunda, terca, quarta, quinta, sexta);
                        JOptionPane.showMessageDialog(null, "Hor??rio alterado com sucesso", "Informa????o", 1);
                        for (i = 0; i <= num_aula.length; i++) {
                            jTableHorario.setValueAt(null, i, 0);
                            jTableHorario.setValueAt(null, i, 1);
                            jTableHorario.setValueAt(null, i, 2);
                            jTableHorario.setValueAt(null, i, 3);
                            jTableHorario.setValueAt(null, i, 4);
                            jTableHorario.setValueAt(null, i, 5);
                        }
                        qtd = 0;
                        jComboBoxTurma.setEnabled(true);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Cadastra_Horario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {

            int qtd = 0;
            int qtdT = 0;
            int i;
            Horario_Aulas ha = new Horario_Aulas();

            String[] turma = new String[600];

            //String[] mat_prof = new String[600];
            String[] segunda = new String[600];
            String[] terca = new String[600];
            String[] quarta = new String[600];
            String[] quinta = new String[600];
            String[] sexta = new String[600];

            while (jTableHorario.getValueAt(qtd, 0) != null) {
                qtd++;
            }
            int x = qtd * 5;
            String[] num_aula = new String[qtd];
            if (qtd == 0) {
                JOptionPane.showMessageDialog(null, "Insira os dados para os hor??rios", "Informa????o", 1);
            } else {
                for (i = 0; i < qtd; i++) {
                    //for (int y = 1; y <= 5; y++) {
                    turma[i] = jComboBoxTurma.getSelectedItem().toString();
                    num_aula[i] = jTableHorario.getValueAt(i, 0).toString();
                    if (jTableHorario.getValueAt(i, 1) == null) {
                        segunda[i] = "";
                    } else {
                        segunda[i] = jTableHorario.getValueAt(i, 1).toString();
                    }
                    if (jTableHorario.getValueAt(i, 2) == null) {
                        terca[i] = "";
                    } else {
                        terca[i] = jTableHorario.getValueAt(i, 2).toString();
                    }
                    if (jTableHorario.getValueAt(i, 3) == null) {
                        quarta[i] = "";
                    } else {
                        quarta[i] = jTableHorario.getValueAt(i, 3).toString();
                    }
                    if (jTableHorario.getValueAt(i, 4) == null) {
                        quinta[i] = "";
                    } else {
                        quinta[i] = jTableHorario.getValueAt(i, 4).toString();
                    }
                    if (jTableHorario.getValueAt(i, 5) == null) {
                        sexta[i] = "";
                    } else {
                        sexta[i] = jTableHorario.getValueAt(i, 5).toString();
                    }

                    System.out.print(turma[i] + " | ");
                    System.out.print(num_aula[i] + " | ");
                    System.out.print(segunda[i] + " | ");
                    System.out.print(terca[i] + " | ");
                    System.out.print(quarta[i] + " | ");
                    System.out.print(quinta[i] + " | ");
                    System.out.println(sexta[i]);

                }
                Horario_AulasDao had = new Horario_AulasDao();
                try {
                    if (had.verificaHorario(turma, num_aula, segunda, terca, quarta, quinta, sexta) == "") {
                        had.cadastraHorario(turma, num_aula, segunda, terca, quarta, quinta, sexta);
                        JOptionPane.showMessageDialog(null, "Hor??rio cadastrado com sucesso", "Informa????o", 1);
                        for (i = 0; i <= num_aula.length; i++) {
                            jTableHorario.setValueAt(null, i, 0);
                            jTableHorario.setValueAt(null, i, 1);
                            jTableHorario.setValueAt(null, i, 2);
                            jTableHorario.setValueAt(null, i, 3);
                            jTableHorario.setValueAt(null, i, 4);
                            jTableHorario.setValueAt(null, i, 5);
                        }
                        qtd = 0;
                        jComboBoxTurma.setEnabled(true);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Cadastra_Horario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jComboBoxTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTurmaActionPerformed

    }//GEN-LAST:event_jComboBoxTurmaActionPerformed

    private void jComboBoxTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxTurmaMouseClicked

    }//GEN-LAST:event_jComboBoxTurmaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public static javax.swing.JButton jButtonOk;
    public static javax.swing.JButton jButtonSalvar;
    public static javax.swing.JComboBox<String> jComboBoxDiaSemana;
    public static javax.swing.JComboBox<String> jComboBoxTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableHorario;
    // End of variables declaration//GEN-END:variables
}
