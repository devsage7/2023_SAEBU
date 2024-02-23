package com.mycompany.saebu.gui.cobros;

import com.mycompany.saebu.logica.clases.PagoDeCuota;
import com.mycompany.saebu.logica.clases.PagoEquipo;
import com.mycompany.saebu.logica.managers.ManagerPagoDeCuota;
import com.mycompany.saebu.logica.managers.ManagerPagoEquipo;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class JPanelConsultarPago extends javax.swing.JPanel {

    private List<PagoDeCuota> pagosCuotas;
    private List<PagoEquipo> pagosEquipos;

    DefaultTableModel dm;

    public JPanelConsultarPago() {
        initComponents();
        try {
            traerPagos();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(JPanelConsultarPago.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void traerPagos() throws SQLException, ClassNotFoundException {

        //TOMAMOS TODAS LAS CUOTAS DE LOS ALUMNOS Y DE LOS EQUIPOS
        ManagerPagoDeCuota mPagoCuotas = new ManagerPagoDeCuota();
        pagosCuotas = mPagoCuotas.consultarCuotasPagos();
        ManagerPagoEquipo mPagoEquipo = new ManagerPagoEquipo();
        pagosEquipos = mPagoEquipo.consultarEquiposPagos();

        DefaultTableModel table = (DefaultTableModel) jTablePagos.getModel();
        table.setRowCount(0);

        for (int i = 0; pagosCuotas.size() > i; i++) {
            PagoDeCuota pago = pagosCuotas.get(i);
            Object fila[] = {
                pago.getNroPago(),
                pago.getCuotaMensual().getAlumno().getNomyApe(),
                pago.getFecha(),
                pago.getCuotaMensual().getDisciplina().getNombre(),
                pago.getImporte(),
                "Cuota Mensual"
            };
            table.addRow(fila);
        }
        for (int i = 0; pagosEquipos.size() > i; i++) {
            PagoEquipo pagoEquipo = pagosEquipos.get(i);
            Object fila[] = {
                pagoEquipo.getNroPago(),
                pagoEquipo.getEquipo().getNombre(),
                pagoEquipo.getFecha(),
                pagoEquipo.getDisciplina().getNombre(),
                pagoEquipo.getImporte(),
                "Equipo"
            };
            table.addRow(fila);
        }
        //jTablePagos.setDefaultRenderer(Object.class, cellRenderer);
        jTablePagos.getTableHeader().setReorderingAllowed(false);
    }

    private void filtro(String consulta, JTable tablaFiltrada, int columna) {
        dm = (DefaultTableModel) tablaFiltrada.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        tablaFiltrada.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta, columna));
    }

    private boolean muestraPagoCuota(PagoDeCuota pago) {
        String titulo = "Detalles de Pago";
        String mensaje = "Nro. de Pago " + pago.getNroPago()
                + "\nAlumno:  " + pago.getCuotaMensual().getAlumno().getNomyApe()
                + "\nImporte: " + pago.getImporte()
                + "\nHora: " + pago.getHora()
                + "\nCorrespondiente al mes: " + pago.getCuotaMensual().getMes()
                + "\nDisciplina: " + pago.getCuotaMensual().getDisciplina().getNombre()
                + "\nOperador: " + pago.getOperador().getNomyApe()
                + "\n\n ¿Desea Imprimirlo? ";
        int respuesta = JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
    }

    private boolean muestraPagoEquipo(PagoEquipo pago) {
        String titulo = "Detalles de Pago";
        String mensaje = "Nro. de Pago " + pago.getNroPago()
                + "\nEquipo:  " + pago.getEquipo().getNombre()
                + "\nImporte: " + pago.getImporte()
                + "\nFecha: " + pago.getFecha()
                + "\nDisciplina: " + pago.getDisciplina().getNombre()
                + "\nOperador: " + pago.getOperador().getNomyApe()
                + "\n\n ¿Desea Imprimirlo? ";
        int respuesta = JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePagos = new javax.swing.JTable();
        jTextFieldFiltroPorNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldFiltroPorNroPago = new javax.swing.JTextField();

        setBackground(new java.awt.Color(156, 196, 228));
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(156, 196, 228));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 530));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Consultar Pago");

        jTablePagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nro. de Pago", "Nombre", "Fecha", "Disciplina", "Importe", "Tipo"
            }
        ));
        jTablePagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePagosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePagos);

        jTextFieldFiltroPorNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldFiltroPorNombreMouseClicked(evt);
            }
        });
        jTextFieldFiltroPorNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldFiltroPorNombreKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Nro. de Pago:");

        jTextFieldFiltroPorNroPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldFiltroPorNroPagoMouseClicked(evt);
            }
        });
        jTextFieldFiltroPorNroPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldFiltroPorNroPagoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFiltroPorNroPagoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(188, 188, 188))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(88, 88, 88)
                                        .addComponent(jLabel3))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldFiltroPorNroPago, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                    .addComponent(jTextFieldFiltroPorNombre))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldFiltroPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldFiltroPorNroPago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 62;
        gridBagConstraints.ipady = 124;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jTablePagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePagosMouseClicked
        if (jTablePagos.getSelectedRow() != -1) {

            String tipo = (String) jTablePagos.getValueAt(jTablePagos.getSelectedRow(), 5);
            int nro_pago_tabla = (int) jTablePagos.getValueAt(jTablePagos.getSelectedRow(), 0);
            if (tipo.equals("Cuota Mensual")) {

                int i = 0;
                while (nro_pago_tabla != pagosCuotas.get(i).getNroPago()) {
                    i++;
                }
                if (muestraPagoCuota(pagosCuotas.get(i))) {
                    ManagerPagoDeCuota manager = new ManagerPagoDeCuota();
                    //GENERAR PDF
                    Time horaActual = new Time(System.currentTimeMillis());
                    String linea = "DEPORTES                                                                                                                   TRIPLICADO";
                    manager.generarPDF(pagosCuotas.get(i).getCuotaMensual().getAlumno().getNomyApe(),
                            pagosCuotas.get(i).getCuotaMensual().getDisciplina().getNombre(),
                            pagosCuotas.get(i).getNroPago(), pagosCuotas.get(i).getOperador().getNomyApe(),
                            pagosCuotas.get(i).getImporte(), pagosCuotas.get(i).getCuotaMensual().getMes(),
                            pagosCuotas.get(i).getCuotaMensual().getAnio(), horaActual, "Triplicado", linea);
                }
            } else {
                int i = 0;
                while (nro_pago_tabla != pagosEquipos.get(i).getNroPago()) {
                    i++;
                }
                if (muestraPagoEquipo(pagosEquipos.get(i))) {
                    ManagerPagoEquipo manager = new ManagerPagoEquipo();
                    //GENERAR PDF
                    Time horaActual = new Time(System.currentTimeMillis());
                    String linea = "DEPORTES                                                                                                                   TRIPLICADO";
                    manager.generarPDF(pagosEquipos.get(i).getEquipo().getNombre(),
                            pagosEquipos.get(i).getDisciplina().getNombre(),
                            pagosEquipos.get(i).getNroPago(),
                            pagosEquipos.get(i).getOperador().getNomyApe(),
                            pagosEquipos.get(i).getImporte(),
                            horaActual, "Triplicado",
                            linea
                    );
                }
            }
        }
    }//GEN-LAST:event_jTablePagosMouseClicked

    private void jTextFieldFiltroPorNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFiltroPorNombreKeyReleased
        filtro(jTextFieldFiltroPorNombre.getText(), jTablePagos, 1);
    }//GEN-LAST:event_jTextFieldFiltroPorNombreKeyReleased

    private void jTextFieldFiltroPorNroPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFiltroPorNroPagoKeyReleased
        filtro(jTextFieldFiltroPorNroPago.getText(), jTablePagos, 0);
    }//GEN-LAST:event_jTextFieldFiltroPorNroPagoKeyReleased

    private void jTextFieldFiltroPorNroPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFiltroPorNroPagoKeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTextFieldFiltroPorNroPagoKeyTyped

    private void jTextFieldFiltroPorNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldFiltroPorNombreMouseClicked
        jTextFieldFiltroPorNroPago.setText("");
        filtro(jTextFieldFiltroPorNombre.getText(), jTablePagos, 1);
    }//GEN-LAST:event_jTextFieldFiltroPorNombreMouseClicked

    private void jTextFieldFiltroPorNroPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldFiltroPorNroPagoMouseClicked
        jTextFieldFiltroPorNombre.setText("");
        filtro(jTextFieldFiltroPorNroPago.getText(), jTablePagos, 0);
    }//GEN-LAST:event_jTextFieldFiltroPorNroPagoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePagos;
    private javax.swing.JTextField jTextFieldFiltroPorNombre;
    private javax.swing.JTextField jTextFieldFiltroPorNroPago;
    // End of variables declaration//GEN-END:variables
}
