package com.mycompany.saebu.gui.Alumno;

import com.mycompany.saebu.gui.cobros.JPanelRealizarPagoMensualidad;
import com.mycompany.saebu.logica.clases.Alumno;
import com.mycompany.saebu.logica.clases.TipoAlumno;
import com.mycompany.saebu.logica.clases.TipoSeguro;
import com.mycompany.saebu.logica.managers.ManagerAlumno;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultarAlumno extends javax.swing.JFrame {

    public JPanelRealizarPagoMensualidad panel_aux;
    public JPanelAlumnoInscripcion panel_aux2 = null;
    public String var;

    public ConsultarAlumno() {
        initComponents();
        jTable1.getTableHeader().setReorderingAllowed(false);
        llenarlista();
    }

    public final void llenarlista() {
        ManagerAlumno ma = new ManagerAlumno();
        List<Alumno> listita = null;
        DefaultTableModel table =(DefaultTableModel) jTable1.getModel();
        table.setRowCount(0);
        String txt = jTextField1.getText();
        try {
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            if (jTextField1.getText().isEmpty() && jTextField2.getText().isEmpty()) {
                listita = ma.consultarAlumnos();
                for (int i = 0; i < listita.size(); i++) {
                    Object fila[] = {listita.get(i).getNomyApe(),listita.get(i).getTipoDoc(), listita.get(i).getNroDoc(), listita.get(i).getTel(), listita.get(i).getDomicilio(),listita.get(i).getBarrio(),listita.get(i).getLocalidad(),listita.get(i).getProvincia(),listita.get(i).getSexo(),formateador.format(listita.get(i).getFecNac()),listita.get(i).getTipoAlumno(),listita.get(i).getTipoSeguro(),listita.get(i).getObservaciones(),listita.get(i).getId_a()};
                    table.addRow(fila);
                }
            } else if (!jTextField1.getText().isEmpty()) {
                listita = ma.consultarAlumnos(txt);
                for (int i = 0; i < listita.size(); i++) {
                    Object fila[] = {listita.get(i).getNomyApe(),listita.get(i).getTipoDoc(), listita.get(i).getNroDoc(), listita.get(i).getTel(),listita.get(i).getDomicilio(),listita.get(i).getBarrio(),listita.get(i).getLocalidad(),listita.get(i).getProvincia(),listita.get(i).getSexo(),formateador.format(listita.get(i).getFecNac()),listita.get(i).getTipoAlumno(),listita.get(i).getTipoSeguro(),listita.get(i).getObservaciones(),listita.get(i).getId_a()};
                    table.addRow(fila);

                }
            } else {
                int txt2 = Integer.parseInt(jTextField2.getText());
                listita = ma.consultarAlumnos(txt2);
                for (int i = 0; i < listita.size(); i++) {
                    Object fila[] = {listita.get(i).getNomyApe(),listita.get(i).getTipoDoc(), listita.get(i).getNroDoc(), listita.get(i).getTel(),listita.get(i).getDomicilio(),listita.get(i).getBarrio(),listita.get(i).getLocalidad(),listita.get(i).getProvincia(),listita.get(i).getSexo(),formateador.format(listita.get(i).getFecNac()),listita.get(i).getTipoAlumno(),listita.get(i).getTipoSeguro(),listita.get(i).getObservaciones(),listita.get(i).getId_a()};
                    table.addRow(fila);
                }
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(235, 235, 235));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 50, 95), 2));

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre y apellido:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel2.setText("DNI:");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre y apellido", "Tipo de documento", "DNI", "Teléfono", "Domicilio", "Barrio", "Localidad", "Provincia", "Sexo", "Fecha de nacimiento", "Tipo", "Seguro", "Observaciones", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1))))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        jTextField2.setText("");
        llenarlista();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        jTextField1.setText("");
        llenarlista();
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Alumno alu = null;
        try {
            alu= traeralumno();
        } catch (ParseException ex) {
            Logger.getLogger(ConsultarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (panel_aux != null) {
                if (alu!=null) {
                    panel_aux.rellenarcombobox(alu);
                    panel_aux.getjComboBox1().setEnabled(true);
                    panel_aux.crearTabla();
                }
            }
            if (panel_aux2 != null) {
                if (alu!= null) {
                    panel_aux2.rellenarcombobox(alu);
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    public Alumno traeralumno() throws ParseException{
        Alumno alum = null;
        if (jTable1.getSelectedRow() != -1) {
            String nombre, tipodoc, telefono, dom, barrio, localidad, provincia, sexo, obser;
            int documento, id;
            Date fecha;
            TipoAlumno tipoAlumno;
            TipoSeguro tipoSeguro;
            nombre= (String) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            tipodoc= (String) jTable1.getValueAt(jTable1.getSelectedRow(), 1);
            documento= (int) jTable1.getValueAt(jTable1.getSelectedRow(), 2);
            telefono= (String) jTable1.getValueAt(jTable1.getSelectedRow(), 3);
            dom= (String) jTable1.getValueAt(jTable1.getSelectedRow(), 4);
            barrio= (String) jTable1.getValueAt(jTable1.getSelectedRow(), 5);
            localidad= (String) jTable1.getValueAt(jTable1.getSelectedRow(), 6);
            provincia= (String) jTable1.getValueAt(jTable1.getSelectedRow(), 7);
            sexo= (String) jTable1.getValueAt(jTable1.getSelectedRow(), 8);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Object valor= jTable1.getValueAt(jTable1.getSelectedRow(), 9);
            String dat = valor.toString();     
            fecha= new java.sql.Date((sdf.parse(dat)).getTime());   
            tipoAlumno= (TipoAlumno) jTable1.getValueAt(jTable1.getSelectedRow(), 10);
            tipoSeguro= (TipoSeguro) jTable1.getValueAt(jTable1.getSelectedRow(), 11);
            obser= (String) jTable1.getValueAt(jTable1.getSelectedRow(), 12);
            id= (int) jTable1.getValueAt(jTable1.getSelectedRow(), 13);
            alum= new Alumno(id,tipoAlumno,tipoSeguro,nombre,tipodoc,documento,dom,barrio,localidad,provincia,telefono,fecha,sexo,obser);
            this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un alumno.", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        return alum;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
