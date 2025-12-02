package tpsfiosko;

import java.util.ArrayList;

public class Persistencia 
{
    private ArrayList<Producto> productos;
    private ArrayList<Venta> Ventas;
    
    public Persistencia()
    {
        inicializarProductos();
    }
    
    public void inicializarProductos()
    {
        productos.add(new Producto("Gaseosa 500ml", 750.0f));
        productos.add(new Producto("Galletitas", 520.0f));
        productos.add(new Producto("Caramelo", 50.0f));
        productos.add(new Producto("Chocolate", 890.0f));
        productos.add(new Producto("Chicle", 80.0f));
        productos.add(new Producto("Agua mineral 500ml", 600.0f));
        productos.add(new Producto("Snack salado", 700.0f));
        productos.add(new Producto("Cigarrillos", 2500.0f));
        productos.add(new Producto("Alfajor", 650.0f));
        productos.add(new Producto("Energética 473ml", 1200.0f));
    }
}
