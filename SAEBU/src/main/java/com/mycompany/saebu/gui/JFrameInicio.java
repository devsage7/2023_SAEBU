package com.mycompany.saebu.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class JFrameInicio extends javax.swing.JFrame {

    private int num_bool;
    private final boolean menu_desplegado = false;
    private final Color AZUL_OSCURO = new Color(27, 50, 95);
    private final Color CELESTE_CLARO = new Color(156, 196, 228);
    private final Color CELESTE = new Color(58, 137, 201);

    public JFrameInicio() {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        jPanelMenuLateral = new javax.swing.JPanel();
        jPanelAlumno = new javax.swing.JPanel();
        jLabelAlumnoImg = new javax.swing.JLabel();
        jLabelAlumnoText = new javax.swing.JLabel();
        jPanelProfesor = new javax.swing.JPanel();
        jLabelProfesorImg = new javax.swing.JLabel();
        jLabelProfesorText = new javax.swing.JLabel();
        jPanelCobro = new javax.swing.JPanel();
        jLabelCobroImg = new javax.swing.JLabel();
        jLabelCobroText = new javax.swing.JLabel();
        jPanelDisciplina = new javax.swing.JPanel();
        jLabelDisciplinaImg = new javax.swing.JLabel();
        jLabelDisciplinaText = new javax.swing.JLabel();
        jPanelEquipo = new javax.swing.JPanel();
        jLabelEquipoImg = new javax.swing.JLabel();
        jLabelEquipoText = new javax.swing.JLabel();
        jPanelUsuario = new javax.swing.JPanel();
        jLabelUsuarioImg = new javax.swing.JLabel();
        jLabelUsuarioText = new javax.swing.JLabel();
        jPanelSubMenu = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jPanelBarra = new javax.swing.JPanel();
        jPanelMinimizar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelMaximizar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanelCerrar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        menu.setBackground(new java.awt.Color(255, 153, 255));
        menu.setPreferredSize(new java.awt.Dimension(270, 530));
        menu.setLayout(new java.awt.BorderLayout());

        jPanelMenuLateral.setBackground(new java.awt.Color(27, 50, 95));
        jPanelMenuLateral.setPreferredSize(new java.awt.Dimension(50, 540));
        jPanelMenuLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelAlumno.setBackground(new java.awt.Color(27, 50, 95));
        jPanelAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelAlumnoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelAlumnoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelAlumnoMouseExited(evt);
            }
        });
        jPanelAlumno.setLayout(new java.awt.BorderLayout());

        jLabelAlumnoImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAlumnoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/alumnos_blanco.png"))); // NOI18N
        jPanelAlumno.add(jLabelAlumnoImg, java.awt.BorderLayout.CENTER);

        jLabelAlumnoText.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAlumnoText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAlumnoText.setText("Alumno");
        jLabelAlumnoText.setToolTipText("");
        jPanelAlumno.add(jLabelAlumnoText, java.awt.BorderLayout.PAGE_END);

        jPanelMenuLateral.add(jPanelAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 60));

        jPanelProfesor.setBackground(new java.awt.Color(27, 50, 95));
        jPanelProfesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelProfesorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelProfesorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelProfesorMouseExited(evt);
            }
        });
        jPanelProfesor.setLayout(new java.awt.BorderLayout());

        jLabelProfesorImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProfesorImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/profesor_blanco.png"))); // NOI18N
        jPanelProfesor.add(jLabelProfesorImg, java.awt.BorderLayout.PAGE_START);

        jLabelProfesorText.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProfesorText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProfesorText.setText("Profesor");
        jPanelProfesor.add(jLabelProfesorText, java.awt.BorderLayout.PAGE_END);

        jPanelMenuLateral.add(jPanelProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 50, 60));

        jPanelCobro.setBackground(new java.awt.Color(27, 50, 95));
        jPanelCobro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelCobroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelCobroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelCobroMouseExited(evt);
            }
        });
        jPanelCobro.setLayout(new java.awt.BorderLayout());

        jLabelCobroImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCobroImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pagos_blanco.png"))); // NOI18N
        jPanelCobro.add(jLabelCobroImg, java.awt.BorderLayout.CENTER);

        jLabelCobroText.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCobroText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCobroText.setText("Pago");
        jPanelCobro.add(jLabelCobroText, java.awt.BorderLayout.PAGE_END);

        jPanelMenuLateral.add(jPanelCobro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 50, 60));

        jPanelDisciplina.setBackground(new java.awt.Color(27, 50, 95));
        jPanelDisciplina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelDisciplinaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelDisciplinaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelDisciplinaMouseExited(evt);
            }
        });
        jPanelDisciplina.setLayout(new java.awt.BorderLayout());

        jLabelDisciplinaImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDisciplinaImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/disciplina_blanco.png"))); // NOI18N
        jPanelDisciplina.add(jLabelDisciplinaImg, java.awt.BorderLayout.CENTER);

        jLabelDisciplinaText.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelDisciplinaText.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDisciplinaText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDisciplinaText.setText("Disciplina");
        jPanelDisciplina.add(jLabelDisciplinaText, java.awt.BorderLayout.PAGE_END);

        jPanelMenuLateral.add(jPanelDisciplina, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 50, 60));

        jPanelEquipo.setBackground(new java.awt.Color(27, 50, 95));
        jPanelEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelEquipoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelEquipoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelEquipoMouseExited(evt);
            }
        });
        jPanelEquipo.setLayout(new java.awt.BorderLayout());

        jLabelEquipoImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEquipoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/equipo_blanco.png"))); // NOI18N
        jPanelEquipo.add(jLabelEquipoImg, java.awt.BorderLayout.CENTER);

        jLabelEquipoText.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEquipoText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEquipoText.setText("Equipo");
        jPanelEquipo.add(jLabelEquipoText, java.awt.BorderLayout.PAGE_END);

        jPanelMenuLateral.add(jPanelEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 50, -1));

        jPanelUsuario.setBackground(new java.awt.Color(27, 50, 95));
        jPanelUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelUsuarioMouseExited(evt);
            }
        });
        jPanelUsuario.setLayout(new java.awt.BorderLayout());

        jLabelUsuarioImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUsuarioImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario_blanco.png"))); // NOI18N
        jPanelUsuario.add(jLabelUsuarioImg, java.awt.BorderLayout.CENTER);

        jLabelUsuarioText.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuarioText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUsuarioText.setText("Usuario");
        jPanelUsuario.add(jLabelUsuarioText, java.awt.BorderLayout.PAGE_END);

        jPanelMenuLateral.add(jPanelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 50, -1));

        menu.add(jPanelMenuLateral, java.awt.BorderLayout.LINE_START);

        jPanelSubMenu.setBackground(new java.awt.Color(58, 137, 201));
        jPanelSubMenu.setPreferredSize(new java.awt.Dimension(220, 530));

        javax.swing.GroupLayout jPanelSubMenuLayout = new javax.swing.GroupLayout(jPanelSubMenu);
        jPanelSubMenu.setLayout(jPanelSubMenuLayout);
        jPanelSubMenuLayout.setHorizontalGroup(
            jPanelSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelSubMenuLayout.setVerticalGroup(
            jPanelSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        menu.add(jPanelSubMenu, java.awt.BorderLayout.CENTER);

        getContentPane().add(menu, java.awt.BorderLayout.LINE_START);

        header.setBackground(new java.awt.Color(76, 132, 189));
        header.setPreferredSize(new java.awt.Dimension(868, 40));
        header.setLayout(new java.awt.BorderLayout());

        jPanelBarra.setBackground(new java.awt.Color(27, 50, 95));
        jPanelBarra.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanelBarra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMinimizar.setBackground(new java.awt.Color(27, 50, 95));
        jPanelMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelMinimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelMinimizarMouseExited(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/minimizar_negro.png"))); // NOI18N

        javax.swing.GroupLayout jPanelMinimizarLayout = new javax.swing.GroupLayout(jPanelMinimizar);
        jPanelMinimizar.setLayout(jPanelMinimizarLayout);
        jPanelMinimizarLayout.setHorizontalGroup(
            jPanelMinimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMinimizarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelMinimizarLayout.setVerticalGroup(
            jPanelMinimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMinimizarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelBarra.add(jPanelMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jPanelMaximizar.setBackground(new java.awt.Color(27, 50, 95));
        jPanelMaximizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelMaximizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelMaximizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelMaximizarMouseExited(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/achicar_negro.png"))); // NOI18N

        javax.swing.GroupLayout jPanelMaximizarLayout = new javax.swing.GroupLayout(jPanelMaximizar);
        jPanelMaximizar.setLayout(jPanelMaximizarLayout);
        jPanelMaximizarLayout.setHorizontalGroup(
            jPanelMaximizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaximizarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelMaximizarLayout.setVerticalGroup(
            jPanelMaximizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaximizarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelBarra.add(jPanelMaximizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 50, 40));

        jPanelCerrar.setBackground(new java.awt.Color(27, 50, 95));
        jPanelCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelCerrarMouseExited(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar_negro.png"))); // NOI18N

        javax.swing.GroupLayout jPanelCerrarLayout = new javax.swing.GroupLayout(jPanelCerrar);
        jPanelCerrar.setLayout(jPanelCerrarLayout);
        jPanelCerrarLayout.setHorizontalGroup(
            jPanelCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCerrarLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelCerrarLayout.setVerticalGroup(
            jPanelCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCerrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelBarra.add(jPanelCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 50, 40));

        header.add(jPanelBarra, java.awt.BorderLayout.LINE_END);

        jPanel1.setBackground(new java.awt.Color(27, 50, 95));
        jPanel1.setPreferredSize(new java.awt.Dimension(718, 40));

        jPanel2.setBackground(new java.awt.Color(27, 50, 95));
        jPanel2.setPreferredSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SAEBU - Departamento de Educación Física y Deporte");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(0, 246, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        header.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        body.setBackground(new java.awt.Color(156, 196, 228));
        body.setLayout(new java.awt.BorderLayout());
        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void changeColor(JPanel panel, Color color) {
        panel.setBackground(color);
    }

    private void clickmenu() {
        jPanelAlumno.setBackground(AZUL_OSCURO);
        jPanelProfesor.setBackground(AZUL_OSCURO);
        jPanelCobro.setBackground(AZUL_OSCURO);
        jPanelDisciplina.setBackground(AZUL_OSCURO);
        jPanelEquipo.setBackground(AZUL_OSCURO);
        jPanelUsuario.setBackground(AZUL_OSCURO);

        switch (num_bool) {
            case 1:
                jPanelAlumno.setBackground(CELESTE);
                break;
            case 2:
                jPanelProfesor.setBackground(CELESTE);
                break;
            case 3:
                jPanelCobro.setBackground(CELESTE);
                break;
            case 4:
                jPanelDisciplina.setBackground(CELESTE);
                break;
            case 5:
                jPanelEquipo.setBackground(CELESTE);
                break;
            case 6:
                jPanelUsuario.setBackground(CELESTE);
                break;
        }
        changeSubmenu();
    }

    private void changeSubmenu() {
        switch (num_bool) {
            case 1:
                JPanelSubMenuAlumno p1 = new JPanelSubMenuAlumno();
                p1.aux = body;
                showPanel(p1);
                break;
            case 2:
                JPanelSubMenuProfesor p2 = new JPanelSubMenuProfesor();
                p2.aux = body;
                showPanel(p2);
                break;
            case 3:
                JPanelSubMenuCobro p3 = new JPanelSubMenuCobro();
                p3.aux = body;
                showPanel(p3);
                break;
            case 4:
                JPanelSubMenuDisciplina p4 = new JPanelSubMenuDisciplina();
                p4.aux = body;
                showPanel(p4);
                break;
            case 5:
                JPanelSubMenuEquipo p5 = new JPanelSubMenuEquipo();
                p5.aux = body;
                showPanel(p5);
                break;
            case 6:
                JPanelSubMenuUsuario p6 = new JPanelSubMenuUsuario();
                p6.aux = body;
                showPanel(p6);
                break;
        }
    }

    private void showPanel(JPanel p) {
        p.setSize(220, jPanelSubMenu.getHeight());
        p.setLocation(0, 0);
        jPanelSubMenu.removeAll();
        jPanelSubMenu.add(p, BorderLayout.CENTER);
        jPanelSubMenu.revalidate();
        jPanelSubMenu.repaint();
    }


    private void jPanelMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMinimizarMouseEntered
        changeColor(jPanelMinimizar, new Color(156, 196, 228));
    }//GEN-LAST:event_jPanelMinimizarMouseEntered

    private void jPanelMaximizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMaximizarMouseEntered
        changeColor(jPanelMaximizar, new Color(156, 196, 228));
    }//GEN-LAST:event_jPanelMaximizarMouseEntered

    private void jPanelCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCerrarMouseEntered
        changeColor(jPanelCerrar, new Color(229, 1, 1));
    }//GEN-LAST:event_jPanelCerrarMouseEntered

    private void jPanelMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMinimizarMouseExited
        changeColor(jPanelMinimizar, AZUL_OSCURO);
    }//GEN-LAST:event_jPanelMinimizarMouseExited

    private void jPanelMaximizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMaximizarMouseExited
        changeColor(jPanelMaximizar, AZUL_OSCURO);
    }//GEN-LAST:event_jPanelMaximizarMouseExited

    private void jPanelCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCerrarMouseExited
        changeColor(jPanelCerrar, AZUL_OSCURO);
    }//GEN-LAST:event_jPanelCerrarMouseExited

    private void jPanelMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMinimizarMouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jPanelMinimizarMouseClicked

    private void jPanelMaximizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMaximizarMouseClicked
        if (this.getExtendedState() != JFrameInicio.MAXIMIZED_BOTH) {
            this.setExtendedState(MAXIMIZED_BOTH);
        } else {
            this.setExtendedState(NORMAL);
        }
    }//GEN-LAST:event_jPanelMaximizarMouseClicked

    private void jPanelCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanelCerrarMouseClicked

    //EVENTOS DE LOS BOTONES 

    private void jPanelAlumnoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAlumnoMouseEntered
        changeColor(jPanelAlumno, CELESTE);
    }//GEN-LAST:event_jPanelAlumnoMouseEntered

    private void jPanelAlumnoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAlumnoMouseExited
        if (num_bool != 1) {
            changeColor(jPanelAlumno, AZUL_OSCURO);
        }
    }//GEN-LAST:event_jPanelAlumnoMouseExited

    private void jPanelAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAlumnoMouseClicked
        num_bool = 1;
        clickmenu();
    }//GEN-LAST:event_jPanelAlumnoMouseClicked

    private void jPanelProfesorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelProfesorMouseEntered
        changeColor(jPanelProfesor, CELESTE);
    }//GEN-LAST:event_jPanelProfesorMouseEntered

    private void jPanelProfesorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelProfesorMouseExited
       if (num_bool != 2) {
            changeColor(jPanelProfesor, AZUL_OSCURO);
        }
    }//GEN-LAST:event_jPanelProfesorMouseExited

    private void jPanelProfesorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelProfesorMouseClicked
        num_bool = 2;
        clickmenu();
    }//GEN-LAST:event_jPanelProfesorMouseClicked

    private void jPanelCobroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCobroMouseEntered
        changeColor(jPanelCobro, CELESTE);
    }//GEN-LAST:event_jPanelCobroMouseEntered

    private void jPanelCobroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCobroMouseExited
        if (num_bool != 3) {
            changeColor(jPanelCobro, AZUL_OSCURO);
        }
    }//GEN-LAST:event_jPanelCobroMouseExited

    private void jPanelCobroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCobroMouseClicked
        num_bool = 3;
        clickmenu();
    }//GEN-LAST:event_jPanelCobroMouseClicked

    private void jPanelDisciplinaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelDisciplinaMouseEntered
        changeColor(jPanelDisciplina, CELESTE);
    }//GEN-LAST:event_jPanelDisciplinaMouseEntered

    private void jPanelDisciplinaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelDisciplinaMouseExited
        if (num_bool != 4) {
            changeColor(jPanelDisciplina, AZUL_OSCURO);
        }
    }//GEN-LAST:event_jPanelDisciplinaMouseExited

    private void jPanelDisciplinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelDisciplinaMouseClicked
        num_bool = 4;
        clickmenu();
    }//GEN-LAST:event_jPanelDisciplinaMouseClicked

    private void jPanelEquipoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelEquipoMouseEntered
        changeColor(jPanelEquipo, CELESTE);
    }//GEN-LAST:event_jPanelEquipoMouseEntered

    private void jPanelEquipoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelEquipoMouseExited
        if (num_bool != 5) {
            changeColor(jPanelEquipo, AZUL_OSCURO);
        }
    }//GEN-LAST:event_jPanelEquipoMouseExited

    private void jPanelEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelEquipoMouseClicked
        num_bool = 5;
        clickmenu();
    }//GEN-LAST:event_jPanelEquipoMouseClicked

    private void jPanelUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelUsuarioMouseEntered
        changeColor(jPanelUsuario, CELESTE);
    }//GEN-LAST:event_jPanelUsuarioMouseEntered

    private void jPanelUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelUsuarioMouseExited
        if (num_bool != 6) {
            changeColor(jPanelUsuario, AZUL_OSCURO);
        }
    }//GEN-LAST:event_jPanelUsuarioMouseExited

    private void jPanelUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelUsuarioMouseClicked
        num_bool = 6;
        clickmenu();
    }//GEN-LAST:event_jPanelUsuarioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelAlumnoImg;
    private javax.swing.JLabel jLabelAlumnoText;
    private javax.swing.JLabel jLabelCobroImg;
    private javax.swing.JLabel jLabelCobroText;
    private javax.swing.JLabel jLabelDisciplinaImg;
    private javax.swing.JLabel jLabelDisciplinaText;
    private javax.swing.JLabel jLabelEquipoImg;
    private javax.swing.JLabel jLabelEquipoText;
    private javax.swing.JLabel jLabelProfesorImg;
    private javax.swing.JLabel jLabelProfesorText;
    private javax.swing.JLabel jLabelUsuarioImg;
    private javax.swing.JLabel jLabelUsuarioText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelAlumno;
    private javax.swing.JPanel jPanelBarra;
    private javax.swing.JPanel jPanelCerrar;
    private javax.swing.JPanel jPanelCobro;
    private javax.swing.JPanel jPanelDisciplina;
    private javax.swing.JPanel jPanelEquipo;
    private javax.swing.JPanel jPanelMaximizar;
    private javax.swing.JPanel jPanelMenuLateral;
    private javax.swing.JPanel jPanelMinimizar;
    private javax.swing.JPanel jPanelProfesor;
    private javax.swing.JPanel jPanelSubMenu;
    private javax.swing.JPanel jPanelUsuario;
    private javax.swing.JPanel menu;
    // End of variables declaration//GEN-END:variables
}
