
package tpsfiosko;

public class Main {

    public static void main(String[] args) 
    {
        V_principal v = new V_principal();
        v.setVisible(true);
        ExcelWriter ew = new ExcelWriter();
        ew.CrearPlanilla();
    }
}
