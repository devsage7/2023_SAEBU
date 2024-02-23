package com.mycompany.saebu.gui.cobros;

import com.mycompany.saebu.logica.clases.*;
import com.mycompany.saebu.logica.managers.ManagerCuotaMensual;
import com.mycompany.saebu.logica.managers.ManagerDisciplina;
import com.mycompany.saebu.logica.managers.ManagerPagoDeCuota;
import java.awt.Color;
import java.awt.Component;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;

public class JDialogConsultarDeudas extends javax.swing.JDialog {

    private List<String> nombre_disciplinas = null;
    private List<Integer> nro_inscripciones = null;
    private final String nombreAlumno;

    public JDialogConsultarDeudas(java.awt.Frame parent, boolean modal, List<Inscripcion> inscripcion, String nomAlu) throws SQLException, ClassNotFoundException {
        super(parent, modal);
        initComponents();

        this.nombre_disciplinas = new ArrayList<>();
        this.nro_inscripciones = new ArrayList<>();
        this.nombreAlumno = nomAlu;
        traerDeudas(inscripcion);
    }

    private void traerDeudas(List<Inscripcion> inscripcion) throws SQLException, ClassNotFoundException {
        List<CuotaMensual> cuotas;
        ManagerCuotaMensual manager_cuotas = new ManagerCuotaMensual();
        ManagerDisciplina disc = new ManagerDisciplina();
        Disciplina disciplina;

        DefaultTableModel table = (DefaultTableModel) jTableCuotas.getModel();
        table.setRowCount(0);

        for (int i = 0; inscripcion.size() > i; i++) {
            cuotas = manager_cuotas.consultarCuotas(inscripcion.get(i).getNroInscripcion());
            disciplina = disc.consultarDisciplina(inscripcion.get(i).getDisciplina().getId_d());
            cargar_cuotas(table, cuotas, disciplina.getNombre(), disciplina.getImporteCuota());

            nro_inscripciones.add(inscripcion.get(i).getNroInscripcion());
            nombre_disciplinas.add(disciplina.getNombre());
        }
        jTableCuotas.setDefaultRenderer(Object.class, cellRenderer);
        jTableCuotas.getTableHeader().setReorderingAllowed(false);
    }

    private void cargar_cuotas(DefaultTableModel table, List<CuotaMensual> cuotas, String nom_disciplina, float importe_cuota) {
        for (int i = 0; i < cuotas.size(); i++) {
            if (cuotas.get(i).getPnum() == -1) {
                Object fila[] = {
                    nom_disciplina,
                    cuotas.get(i).getMes(),
                    cuotas.get(i).getAnio(),
                    importe_cuota,
                    "PENDIENTE"
                };
                table.addRow(fila);
            }
        }
    }

    DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            Object anioValue = table.getValueAt(row, 2);
            if (anioValue instanceof Integer) {
                int anio = (int) anioValue;
                int anioActual = getAnioActual();
                int mesActual = getMesActual();
                Object mesValue = table.getValueAt(row, 1);
                if (mesValue instanceof Integer) {
                    int mes = (int) mesValue;
                    if (anio < anioActual || (anio == anioActual && mes <= mesActual)) {
                        c.setForeground(Color.RED);
                    } else {
                        c.setForeground(Color.LIGHT_GRAY);
                    }
                } else {
                    c.setForeground(Color.LIGHT_GRAY);
                }
            } else {
                c.setForeground(Color.LIGHT_GRAY);
            }
            return c;
        }
    };

    private int getMesActual() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(calendar.getTime());
        int mes = calendar.get(Calendar.MONTH) + 1;
        return mes;
    }

    private int getAnioActual() {
        Calendar calendar = Calendar.getInstance();
        int anio = calendar.get(Calendar.YEAR);
        return anio;
    }

    private void generarPago(float importe, int mes, int anio, int nroInscripcion, String disciplina) throws SQLException, ClassNotFoundException {
        Time horaActual = new Time(System.currentTimeMillis());
        Date fechaActual = new Date(System.currentTimeMillis());
        Operador operador = new Operador(1, "PEDRO PEREZ", 345673221);
        ManagerPagoDeCuota manager_pago = new ManagerPagoDeCuota();
        Inscripcion ins = new Inscripcion(nroInscripcion);
        if (verConfirmacionDePago(mes, anio, importe, disciplina)) {
            int num_pago = manager_pago.ingresarPagoDeCuota(new PagoDeCuota(fechaActual, horaActual, importe, new CuotaMensual(mes, anio, ins), operador), mes, anio, nroInscripcion);
            if (num_pago != -1) {
                //GENERAR EL PDF CORRESPONDIENTE AL PAGO NUEVO
                String linea = "DEPORTES                                                                                                                   ORIGINAL";
                manager_pago.generarPDF(nombreAlumno, disciplina, num_pago, operador.getNomyApe(), importe, mes, anio, horaActual, "Pago", linea);
            }
        }
    }

    private boolean verConfirmacionDePago(int mes, int anio, float importe, String disciplina) {
        String titulo = "Confirmación de Pago";
        String mensaje = "¿Deseas realizar el pago de " + disciplina + " para el mes " + mes + " del " + anio + " por $" + importe + "?";
        // Mostrar el cuadro de diálogo y obtener la respuesta del usuario
        int respuesta = JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
    }

    private boolean verSiNoHayCuotaAnterior(int mes, String disciplina, int anio) {
        boolean esMasAntigua = true;
        DefaultTableModel modelo = (DefaultTableModel) jTableCuotas.getModel();
        int numRows = modelo.getRowCount();
        for (int i = 0; i < numRows; i++) {
            String disciplina_tabla = (String) modelo.getValueAt(i, 0); // 0 es el índice de la columna "Disciplina"
            int mes_tabla = (int) modelo.getValueAt(i, 1); // 1 es el índice de la columna "Mes"
            int anio_tabla = (int) modelo.getValueAt(i, 2); // 2 es el índice de la columna "Año"
            if (disciplina.equals(disciplina_tabla)) {
                if (anio > anio_tabla || (anio == anio_tabla && mes > mes_tabla) || (anio < anio_tabla && mes > getMesActual())) {
                    esMasAntigua = false;
                }
            }
        }
        return esMasAntigua;
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCuotas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(156, 196, 228));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Cuotas Pendientes");

        jTableCuotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Disciplina", "Mes", "Año", "Importe", "A Pagar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableCuotas);
        if (jTableCuotas.getColumnModel().getColumnCount() > 0) {
            jTableCuotas.getColumnModel().getColumn(0).setHeaderValue("DISCIPLINA");
            jTableCuotas.getColumnModel().getColumn(1).setHeaderValue("MES");
            jTableCuotas.getColumnModel().getColumn(2).setHeaderValue("AÑO");
            jTableCuotas.getColumnModel().getColumn(3).setHeaderValue("IMPORTE");
            jTableCuotas.getColumnModel().getColumn(4).setHeaderValue("A PAGAR");
        }

        jButton1.setText("PAGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonVolver.setText("VOLVER");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Adeuda");

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("No Disponible");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(185, 185, 185))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButtonVolver))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //*****************************************EVENTOS*****************************************

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTableCuotas.getSelectedRow() != -1) {
            int mes = (int) jTableCuotas.getValueAt(jTableCuotas.getSelectedRow(), 1);
            String disciplina_tabla = (String) jTableCuotas.getValueAt(jTableCuotas.getSelectedRow(), 0);
            int anio = (int) jTableCuotas.getValueAt(jTableCuotas.getSelectedRow(), 2);

            if (verSiNoHayCuotaAnterior(mes, disciplina_tabla, anio)) {

                float importe = (float) jTableCuotas.getValueAt(jTableCuotas.getSelectedRow(), 3);
                int i = 0;
                while (!disciplina_tabla.equals(nombre_disciplinas.get(i))) {
                    i++;
                }
                int nro_inscripcion = (int) nro_inscripciones.get(i);
                try {
                    generarPago(importe, mes, anio, nro_inscripcion, disciplina_tabla);
                    dispose();

                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(JDialogConsultarDeudas.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No está permitido pagar esta cuota aún.", "PAGO NO DISPONIBLE", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una cuota.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCuotas;
    // End of variables declaration//GEN-END:variables

}
