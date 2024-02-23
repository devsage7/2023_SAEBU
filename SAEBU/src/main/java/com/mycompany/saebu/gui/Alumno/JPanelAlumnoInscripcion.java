package com.mycompany.saebu.gui.Alumno;

import com.mycompany.saebu.logica.clases.*;
import com.mycompany.saebu.logica.managers.*;
import static java.lang.String.valueOf;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

public class JPanelAlumnoInscripcion extends javax.swing.JPanel {

    private Alumno alumno;
    private List<Disciplina> d;
    private Disciplina d_selecc;

    public JPanelAlumnoInscripcion() {
        initComponents();
        jComboBox1.addItem("Seleccionar");
        jComboBox2.addItem("Seleccionar");
    }

    public void rellenarcombobox(Alumno alu) throws SQLException, ClassNotFoundException {
        jTextField1.setText(alu.getNomyApe());
        alumno = alu;
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        jComboBox1.addItem("Seleccionar");
        jComboBox2.addItem("Seleccionar");
        jComboBox2.addItem("RECREATIVO");
        jComboBox2.addItem("COMPETITIVO");

        ManagerDisciplina md = new ManagerDisciplina();
        d = md.consultarDisciplina();
        for (int i=0; i< d.size(); i++){
            String nom = d.get(i).getNombre();
            jComboBox1.addItem(nom);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jMonthChooser2 = new com.toedter.calendar.JMonthChooser();
        jYearChooser2 = new com.toedter.calendar.JYearChooser();

        setBackground(new java.awt.Color(156, 196, 228));
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(156, 196, 228));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 500));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Inscripción Alumnos");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Tipo:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Desde:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Hasta:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Alumno:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Disciplina:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Importe:");

        jTextField2.setEditable(false);
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField2.setText("$ 0,0");

        jButton2.setText("Realizar Inscripcion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jMonthChooser2.setYearChooser(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(192, 192, 192))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jMonthChooser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jYearChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))))
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(4, 4, 4)))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jMonthChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jYearChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.ipady = 56;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarDatos(){
        jTextField1.setText("");
        jTextField2.setText("$0,0");
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Seleccionar");
        jComboBox2.setSelectedIndex(0);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConsultarAlumno vb = new ConsultarAlumno();
        vb.panel_aux2 = this;
        vb.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if (jComboBox1.getSelectedItem() != null) {
            if (jComboBox1.getSelectedItem().equals("Seleccionar")) {
                return;
            }
            String nomDisciplina = (String) jComboBox1.getSelectedItem();
            ManagerDisciplina md = new ManagerDisciplina();
            try {
                d_selecc = (md.consultarDisciplina(nomDisciplina)).get(0);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTextField1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un alumno", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (jComboBox1.getSelectedItem().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una disciplina", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (jComboBox2.getSelectedItem().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar el tipo de inscripción", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if ((jMonthChooser1.getMonth() >= jMonthChooser2.getMonth() && jYearChooser2.getYear() <= jYearChooser1.getYear())
                || (jYearChooser2.getYear() < jYearChooser1.getYear()) ) {
            JOptionPane.showMessageDialog(null, "Seleccionó una fecha de fin anterior o igual a la de inicio", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
  
        try {
            ManagerInscripcion mi = new ManagerInscripcion();
            if (mi.consultarInscripciones(alumno, d_selecc, String.valueOf(jComboBox2.getSelectedItem()))){
                JOptionPane.showMessageDialog(null, "El alumno ya tiene una inscripción vigente en esa disciplina", "ERROR", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            TipoInscripcion ti = TipoInscripcion.valueOf(valueOf(jComboBox2.getSelectedItem()));
            float importe = mi.calcularImporte(alumno,valueOf(jComboBox2.getSelectedItem()),d_selecc);
            
            if (!pantallaConfirmacion(importe)){
                JOptionPane.showMessageDialog(null, "Operación cancelada", "Inscripción", JOptionPane.INFORMATION_MESSAGE);
                limpiarDatos();
                return;
            }
            
            Date fecInscr = new Date();
            fecInscr.setDate(1);
            fecInscr.setMonth(jMonthChooser1.getMonth());
            fecInscr.setYear(jYearChooser1.getYear() - 1900);

            Date fecVenc = new Date();
            fecVenc.setDate(1);
            fecVenc.setMonth(jMonthChooser2.getMonth());
            fecVenc.setYear(jYearChooser2.getYear() - 1900);

            Operador operador = new Operador(1, "PEDRO PEREZ", 345673221); /////////////////
                       
            int id = mi.registrarInscripcion(fecInscr, fecVenc, importe, ti, alumno, d_selecc,operador);

            JOptionPane.showMessageDialog(null, "El alumno fue inscripto exitosamente", "Inscripción", JOptionPane.INFORMATION_MESSAGE);
            mi.generarPDF(alumno,id,d_selecc,ti,fecInscr,fecVenc,importe,operador);
            limpiarDatos();
            
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private boolean pantallaConfirmacion(float importe) {
        ManagerInscripcion mi = new ManagerInscripcion();
        String titulo = "Verificación de datos";
       
        String datos = mi.obtenerDatos(alumno,d_selecc,jComboBox2.getSelectedItem().toString(),
                (jMonthChooser1.getMonth()+1),(jYearChooser1.getYear()-2000),
                (jMonthChooser2.getMonth()+1),(jYearChooser2.getYear()-2000),
                importe);
        // Mostrar el cuadro de diálogo y obtener la respuesta del usuario
        int respuesta = JOptionPane.showConfirmDialog(null, datos, titulo, JOptionPane.OK_CANCEL_OPTION);
        return respuesta == JOptionPane.OK_OPTION;
    }
    
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        if (jComboBox2.getSelectedItem() != null) {
            if (jComboBox1.getSelectedItem().equals("Seleccionar")) {
                return;
            }
        }
        if (jComboBox2.getSelectedItem() != null) {
            if (!jComboBox2.getSelectedItem().equals("Seleccionar")) {
                ManagerInscripcion mi = new ManagerInscripcion();
                float importe = mi.calcularImporte(alumno, jComboBox2.getSelectedItem().toString(), d_selecc);
                if (importe == 0)
                    jTextField2.setText("Sin costo.");
                else
                    jTextField2.setText("$" + importe);
            }
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private com.toedter.calendar.JMonthChooser jMonthChooser2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private com.toedter.calendar.JYearChooser jYearChooser2;
    // End of variables declaration//GEN-END:variables
}
