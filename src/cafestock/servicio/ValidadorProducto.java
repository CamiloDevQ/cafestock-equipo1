package cafestock.servicio;

import cafestock.modelo.Producto;
import java.util.List;

public class ValidadorProducto {

    /**
     * HU-A1 (Tarjeta 1):
     * Valida campos vacíos, letras en campos numéricos, precio > 0 y stock/stockMinimo >= 0.
     * Retorna null si todo es válido, o el mensaje de error listo para mostrar en JOptionPane.
     */
    public static String validarDatosProducto(String codigo, String nombre, String precioTexto,
                                              String stockTexto, String stockMinimoTexto) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return "El código del producto es obligatorio.";
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            return "El nombre del producto es obligatorio.";
        }
        if (precioTexto == null || precioTexto.trim().isEmpty()) {
            return "El precio es obligatorio.";
        }
        if (stockTexto == null || stockTexto.trim().isEmpty()) {
            return "El stock actual es obligatorio.";
        }
        if (stockMinimoTexto == null || stockMinimoTexto.trim().isEmpty()) {
            return "El stock mínimo es obligatorio.";
        }

        double precio;
        try {
            precio = Double.parseDouble(precioTexto.trim().replace(",", "."));
        } catch (NumberFormatException e) {
            return "El precio debe ser un número válido (no se permiten letras).";
        }
        if (Double.isNaN(precio) || Double.isInfinite(precio) || precio <= 0) {
            return "El precio debe ser mayor que 0.";
        }

        int stock;
        try {
            stock = Integer.parseInt(stockTexto.trim());
        } catch (NumberFormatException e) {
            return "El stock actual debe ser un número entero (sin letras ni decimales).";
        }
        if (stock < 0) {
            return "El stock actual no puede ser negativo (debe ser 0 o mayor).";
        }

        int stockMinimo;
        try {
            stockMinimo = Integer.parseInt(stockMinimoTexto.trim());
        } catch (NumberFormatException e) {
            return "El stock mínimo debe ser un número entero (sin letras ni decimales).";
        }
        if (stockMinimo < 0) {
            return "El stock mínimo no puede ser negativo (debe ser 0 o mayor).";
        }

        return null;
    }

    /**
     * HU-A1 (Tarjeta 2):
     * Valida que el código no esté repetido en la lista de productos existentes.
     * Retorna null si el código está disponible, o el mensaje de error si ya existe.
     */
    public static String validarCodigoUnico(String codigo, List<Producto> listaProductos) {
        if (codigo == null || listaProductos == null) {
            return null;
        }
        String codigoLimpio = codigo.trim();
        for (Producto p : listaProductos) {
            if (p.getCodigo() != null && p.getCodigo().trim().equalsIgnoreCase(codigoLimpio)) {
                return "El código '" + codigoLimpio + "' ya existe. Ingrese un código diferente.";
            }
        }
        return null;
    }
}