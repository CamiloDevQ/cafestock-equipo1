package cafestock.modelo;

import java.time.LocalDate;

/** Una venta registrada en CaféStock (HU-A3). */
public class Venta {
    private final int numero;
    private final LocalDate fecha;
    private final String codigoProducto;
    private final int cantidad;
    private final double total;

    public Venta(int numero, LocalDate fecha, String codigoProducto, int cantidad, double total) {
        this.numero = numero;
        this.fecha = fecha;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getNumero() { return numero; }
    public LocalDate getFecha() { return fecha; }
    public String getCodigoProducto() { return codigoProducto; }
    public int getCantidad() { return cantidad; }
    public double getTotal() { return total; }
}
