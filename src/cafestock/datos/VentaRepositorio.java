package cafestock.datos;

import cafestock.modelo.Venta;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Guarda y lee las ventas en datos/ventas.csv (ruta relativa, junto al .jar).
 * Formato por línea: numero;fecha(yyyy-MM-dd);codigoProducto;cantidad;total (punto decimal)
 */
public class VentaRepositorio {
    private static final String SEP = ";";
    private final Path archivo;

    public VentaRepositorio() {
        this(Paths.get("datos", "ventas.csv"));
    }

    public VentaRepositorio(Path archivo) {
        this.archivo = archivo;
    }

    public List<Venta> listar() throws IOException {
        List<Venta> ventas = new ArrayList<>();
        if (!Files.exists(archivo)) {
            return ventas;
        }
        for (String linea : Files.readAllLines(archivo, StandardCharsets.UTF_8)) {
            if (linea.trim().isEmpty()) {
                continue;
            }
            String[] p = linea.split(SEP);
            ventas.add(new Venta(
                    Integer.parseInt(p[0]),
                    LocalDate.parse(p[1]),
                    p[2],
                    Integer.parseInt(p[3]),
                    Double.parseDouble(p[4])));
        }
        return ventas;
    }

    /** Número consecutivo: el mayor existente + 1 (empieza en 1). */
    public int siguienteNumero() throws IOException {
        int max = 0;
        for (Venta v : listar()) {
            max = Math.max(max, v.getNumero());
        }
        return max + 1;
    }

    public Venta guardar(LocalDate fecha, String codigoProducto, int cantidad, double total) throws IOException {
        Files.createDirectories(archivo.toAbsolutePath().getParent());
        Venta venta = new Venta(siguienteNumero(), fecha, codigoProducto, cantidad, total);
        String linea = venta.getNumero() + SEP + venta.getFecha() + SEP + codigoProducto + SEP
                + cantidad + SEP + String.format(Locale.US, "%.2f", total) + System.lineSeparator();
        Files.write(archivo, linea.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        return venta;
    }
}
