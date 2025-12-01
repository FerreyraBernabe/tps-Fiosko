
package tpsfiosko;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Venta 
{
    private static int contadorId = 1;
    private int idVenta;
    private LocalDateTime fecha;
    private String producto;
    private float monto;
    
    public Venta(String producto, float monto)
    {
        idVenta = contadorId++;
        fecha = LocalDateTime.now();
        this.producto = producto;
        this.monto = monto;
    }
    public Venta(int idVenta, LocalDateTime fecha, String producto, float monto)
    {
        fecha = LocalDateTime.now();
        this.producto = producto;
        this.monto = monto;
    }
    
    public int getId()
    {
        return idVenta;
    }
    
    public String getProducto()
    {
        return producto;
    }
    
    public float getMonto()
    {
        return monto;
    }
    
    public String getFecha()
    {
        return fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    
    public String getHora()
    {
        return fecha.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
