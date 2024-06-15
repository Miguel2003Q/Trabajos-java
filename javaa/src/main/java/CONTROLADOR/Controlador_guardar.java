/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.ProductoDao;
import MODELO.ListarProductos;
import MODELO.Producto;
import VISTA.guardar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

/**
 * @author JHONIER ARIAS
 */
public class Controlador_guardar implements ActionListener, ListSelectionListener {
    guardar guardar1;

    public Controlador_guardar(guardar guardar1) {
        this.guardar1 = guardar1;
        this.guardar1.btnGuardar.addActionListener(this);
        this.guardar1.btnCerrarventanas.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guardar1.btnGuardar) {
            guardar1.btnActualizar.setEnabled(false);
            String nombre = guardar1.txtNombre.getText();
            int precio = Integer.parseInt(guardar1.txtPrecio.getText());
            int idCategoria = Integer.parseInt(guardar1.txtCategoria.getText());

            Producto p = new Producto(nombre, precio, idCategoria);
            ProductoDao crear1 = new ProductoDao();
            crear1.crearProducto(p);

            ListarProductos lp = new ListarProductos();
            lp.MostrarTable(guardar1.tablaProductos);

            JOptionPane.showMessageDialog(null, " PRODUCTO GUARDADO");
            limpiarEntradas();
        }

        if (e.getSource() == guardar1.btnCerrarventanas) {

            guardar1.btnActualizar.setEnabled(true);

        }
        if (e.getSource() == guardar1.btnMostrar) {


        }

    }


    private void limpiarEntradas() {//metodo para que se borren los campos del panel
        //se llaman todos los txt y se le da el valor null.. cuando se llame en otro metodo el borra los campos
        // una vez ya se corre el metodo.
        guardar1.txtID.setText("");
        guardar1.txtNombre.setText(null);
        guardar1.txtPrecio.setText(null);
        guardar1.txtCategoria.setText(null);

    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (e.getSource() == guardar1.tablaProductos.getSelectionModel()) ;
            int filas = guardar1.tablaProductos.getSelectedRow();
            if (filas >= 0) {
                TableModel modelo = guardar1.tablaProductos.getModel();
                Object id = modelo.getValueAt(filas, 0);
                Object nombre = modelo.getValueAt(filas, 1);
                Object precio = modelo.getValueAt(filas, 2);
                Object idCategoria = modelo.getValueAt(filas, 3);

                guardar1.txtID.setText(id.toString());
                guardar1.txtNombre.setText(nombre.toString());
                guardar1.txtPrecio.setText(precio.toString());
                guardar1.txtCategoria.setText(idCategoria.toString());
            }
            System.out.println("fila: " + filas);
        }
    }
}
