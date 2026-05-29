package controlador;

import modelo.*;
import vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorGeneral implements ActionListener {
    private FrmLogin vistaLogin;
    private FrmPostulante vistaPostulante;
    private FrmEmpresa vistaEmpresa;

    public ControladorGeneral(FrmLogin vistaLogin, FrmPostulante vistaPostulante, FrmEmpresa vistaEmpresa) {
        this.vistaLogin = vistaLogin;
        this.vistaPostulante = vistaPostulante;
        this.vistaEmpresa = vistaEmpresa;

        // Conectamos los botones a los eventos con sus nombres correctos
        this.vistaLogin.btnIngresar.addActionListener(this);
        this.vistaPostulante.btnPostular.addActionListener(this);
        this.vistaEmpresa.btnRegistrar.addActionListener(this);
    }

    public void iniciar() {
        vistaLogin.setTitle("Sistema de Reclutamiento TI - Inicio");
        vistaLogin.setLocationRelativeTo(null);
        vistaLogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // --- LOGICA DEL LOGIN ---
        if (e.getSource() == vistaLogin.btnIngresar) {
            try {
                String email = vistaLogin.txtEmail.getText();
                String clave = vistaLogin.txtClave.getText();

                // Aplicando teoria de Excepciones
                if (email.isEmpty() || clave.isEmpty()) {
                    throw new Exception("Los campos de email y clave no pueden estar vacios. Por favor, completelos.");
                }

                // Simulacion rapida: Si el correo tiene la palabra "empresa", va a la vista de empresa
                if (email.contains("empresa")) {
                    vistaLogin.setVisible(false);
                    vistaEmpresa.setLocationRelativeTo(null);
                    vistaEmpresa.setVisible(true);
                } else {
                    vistaLogin.setVisible(false);
                    vistaPostulante.setLocationRelativeTo(null);
                    vistaPostulante.setVisible(true);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vistaLogin, "Error de validacion: " + ex.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }

        // --- LOGICA DE REGISTRAR OFERTA (EMPRESA) ---
        if (e.getSource() == vistaEmpresa.btnRegistrar) {
            try {
                String puesto = vistaEmpresa.txtPuesto.getText();
                
                if (puesto.isEmpty()) {
                    throw new Exception("El nombre del puesto es obligatorio para registrar la oferta.");
                }
                
                JOptionPane.showMessageDialog(vistaEmpresa, "Oferta de trabajo registrada con exito en el sistema!");
                
                // Limpiar campos
                vistaEmpresa.txtPuesto.setText("");
                vistaEmpresa.txtArea.setText("");
                vistaEmpresa.txtDescripcion.setText("");
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vistaEmpresa, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}