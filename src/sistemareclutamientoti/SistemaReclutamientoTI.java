package sistemareclutamientoti; // Asegurate de que esto coincida con el nombre de tu paquete raiz

import vista.*;
import controlador.*;

public class SistemaReclutamientoTI {

    public static void main(String[] args) {
        // 1. Instanciamos las Vistas
        FrmLogin vistaLogin = new FrmLogin();
        FrmPostulante vistaPostulante = new FrmPostulante();
        FrmEmpresa vistaEmpresa = new FrmEmpresa();

        // 2. Instanciamos el Controlador y le pasamos las vistas
        ControladorGeneral controlador = new ControladorGeneral(vistaLogin, vistaPostulante, vistaEmpresa);

        // 3. Arrancamos el sistema
        controlador.iniciar();
    }
}