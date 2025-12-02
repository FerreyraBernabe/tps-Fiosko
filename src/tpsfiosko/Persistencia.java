package tpsfiosko;

import java.util.ArrayList;
import java.util.Random;

public  class Persistencia 
{
    private static ArrayList<Producto> productos = new ArrayList<Producto>();
    private static ArrayList<Venta> ventas = new ArrayList<Venta>();
    

    public static void inicializarProductos()
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
    
    public static void inicializarVentas()
    {
        Random random = new Random();
        for(int i=0;i<productos.size()-1;i++)
        {
            ventas.add(new Venta(productos.get(i), random.nextInt(5)+1));
        }
    }
    
    public static ArrayList<Producto> getProductos() {
        System.out.println("elemtos: "+ productos.size());
        return productos;
    }
    public static ArrayList<Venta> getVentas() {return ventas;}
    
    public Producto buscarProducto(String nombre)
    {
        for(Producto p : productos)
        {
            if(p.getNombre().equals(nombre))
            {
                return p;
            }
        }
        return null;
    }
    
    public void addProducto(Producto p){productos.add(p);}
    public void addVenta(Venta v)
    {
        ventas.add(v);
        ExcelWriter.agregarVenta(v);
    }
}