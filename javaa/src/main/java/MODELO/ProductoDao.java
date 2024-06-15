package MODELO;

import CONEXION.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProductoDao {
    private final Connection conexion;
    private final ConexionDB conexionDB;


    public ProductoDao() {
        conexionDB = new ConexionDB();
        conexion = ConexionDB.getConexion();
    }


    public void crearProducto(Producto producto) {
        String sql = "INSERT INTO productos (nombre, precio, idCategoria) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setInt(2, producto.getPrecio());
            preparedStatement.setInt(3, producto.getIdCategoria());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
        conexionDB.closeConexion(conexion);
    }

    public void mostrar(JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("nombre");
        modelo.addColumn("precio");
        modelo.addColumn("idCategoria");
        String sql = "Select*from productos";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Object[] lista = {
                resultSet.getInt("id"),
                resultSet.getString("nombre"),
                resultSet.getInt("precio"),
                resultSet.getInt("idCategoria"),
                  };
                modelo.addRow(lista);
            } tabla.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error" + e.getMessage());
        }

    }
}
