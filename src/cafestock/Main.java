package cafestock;

import cafestock.datos.ProductoRepositorio;
import cafestock.ui.FormularioProductos;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new FormularioProductos(new ProductoRepositorio()).setVisible(true));
    }
}
