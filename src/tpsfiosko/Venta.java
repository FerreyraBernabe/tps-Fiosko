
package tpsfiosko;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Venta 
{
    private static int contadorId = 18293000;
    private int idVenta;
    private LocalDateTime fecha;
    private Producto producto;  
    private int cantidad;
    private float monto;
    private String medioDePago;
    
    public Venta(Producto producto, int cantidad, String medioDePago)
    {
        idVenta = contadorId++;
        fecha = LocalDateTime.now();
        this.producto = producto;
        this.cantidad = cantidad;
        this.monto = producto.getPrecio()*cantidad;
        this.medioDePago = medioDePago;
    }
    public Venta(int idVenta, LocalDateTime fecha, Producto producto, float monto, int cantidad)
    {
        fecha = LocalDateTime.now();
        this.producto = producto;
        this.monto = monto;
        this.cantidad = cantidad;
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
    
    public int getCantidad()
    {
        return cantidad;
    }
    
    public String getFecha()
    {
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    public String getHora()
    {
        return fecha.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
    
    public String getMedio()
    {
        return this.medioDePago;
    }
}
