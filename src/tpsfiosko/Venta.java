
package tpsfiosko;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Venta 
{
    private static int contadorId = 1;
    private int idVenta;
    private LocalDateTime fecha;
    private Producto producto;
    private float monto;
    
    public Venta(Producto producto, float monto)
    {
        idVenta = contadorId++;
        fecha = LocalDateTime.now();
        this.producto = producto;
        this.monto = monto;
    }
    public Venta(int idVenta, LocalDateTime fecha, Producto producto, float monto)
    {
        fecha = LocalDateTime.now();
        this.producto = producto;
        this.monto = monto;
    }
    
    public int getId()
    {
        return idVenta;
    }
    
    public Producto getProducto()
    {
        return producto;
    }
    
    public float getMonto()
    {
        return monto;
    }
    
    public String getFecha()
    {
        return fecha.format(DateTimeFormatter.ofPattern("dd/mm/yyyy"));
    }
    
    public String getHora()
    {
        return fecha.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
