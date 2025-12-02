
package tpsfiosko;

public class Main {

    public static void main(String[] args) 
    {
        V_principal v = new V_principal();
        v.setVisible(true);
        Persistencia.inicializarProductos();
        Persistencia.inicializarVentas();
        ExcelWriter.initVentas(Persistencia.getVentas(),Config.LeerRutaVentas());
        ExcelWriter.initPagosDig(Persistencia.getVentas(),Config.LeerRutaPagos());

    }
}
