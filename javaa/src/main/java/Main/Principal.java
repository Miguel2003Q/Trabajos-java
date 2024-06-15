/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import CONTROLADOR.Controlador_guardar;
import VISTA.guardar;

/**
 *
 * @author JHONIER ARIAS
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    
    public static guardar guardar1;
    public static CONTROLADOR.Controlador_guardar registrarproducto;
    public static void main(String[] args) {
        guardar1 = new  guardar();
        
        guardar1.setVisible(true);
        guardar1.setLocationRelativeTo(null);//para central el panel en medio de la pantalla
        registrarproducto= new Controlador_guardar(guardar1);
        
                
        
        }
    
}
