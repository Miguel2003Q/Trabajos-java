/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import CONEXION.ConexionDB;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JHONIER ARIAS
 */
public class ListarProductos {
    private final Connection conexion;
    private final ConexionDB conexionDB;
    
    public ListarProductos(){
        conexionDB = new ConexionDB();
        conexion = ConexionDB.getConexion();
    }
    
    
    public void MostrarTable(JTable tabla){
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("nombre");
        modelo.addColumn("precio");
        modelo.addColumn("idCategoria");
        String sql= "SELECT * FROM productos";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Object [] lista = {
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)
                }; modelo.addRow(lista);
            }
            tabla.setModel(modelo);
        }catch (SQLException e){
            System.out.println("Error "+ e.getMessage());
        }
    }
}
