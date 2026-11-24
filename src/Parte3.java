import javax.swing.JOptionPane;

public class Parte3 {
    public static void main(String[] args) {

        // 1. DECLARACIÓN Y CREACIÓN del arreglo de objetos (modificado: 5 productos)
        Producto[] productos = new Producto[5];

        // 2. CREACIÓN de cada objeto con su constructor
        productos[0] = new Producto("Laptop",    850.00, 5);
        productos[1] = new Producto("Mouse",      25.50, 20);
        productos[2] = new Producto("Teclado",    45.00, 15);
        productos[3] = new Producto("Monitor",   320.00, 8);
        productos[4] = new Producto("Audífonos",  75.00, 30);

        // 3. ACCESO y VISUALIZACIÓN de cada elemento
        StringBuilder reporte = new StringBuilder();
        reporte.append("=== INVENTARIO DE PRODUCTOS ===\n");
        reporte.append(String.format("%-12s  %-9s  %-11s  %s\n",
            "Nombre", "Precio", "Stock", "Valor Total"));
        reporte.append("-".repeat(55)).append("\n");

        double valorTotalInventario = 0;
        Producto masEconomico  = productos[0];
        Producto masValioso    = productos[0];

        for (int i = 0; i < productos.length; i++) {
            reporte.append(productos[i].toString()).append("\n");

            // Acumular valor total
            valorTotalInventario += productos[i].valorTotal();

            // Buscar más económico (menor precio)
            if (productos[i].precio < masEconomico.precio) {
                masEconomico = productos[i];
            }
            // Buscar más valioso (mayor valorTotal)
            if (productos[i].valorTotal() > masValioso.valorTotal()) {
                masValioso = productos[i];
            }
        }

        reporte.append("-".repeat(55)).append("\n");
        reporte.append(String.format("Valor total inventario: $%.2f\n", valorTotalInventario));
        reporte.append("Producto más económico : ").append(masEconomico.nombre).append("\n");
        reporte.append("Mayor valor inventario : ").append(masValioso.nombre).append("\n");

        // 4. MANIPULACIÓN (modificado): 15% de descuento al producto con MAYOR STOCK
        Producto mayorStock = productos[0];
        for (int i = 1; i < productos.length; i++) {
            if (productos[i].stock > mayorStock.stock) {
                mayorStock = productos[i];
            }
        }
        reporte.append("\n--- Descuento aplicado (15% al de mayor stock) ---\n");
        reporte.append("Producto afectado: ").append(mayorStock.nombre).append("\n");
        reporte.append("Antes : ").append(mayorStock.toString()).append("\n");
        mayorStock.precio = mayorStock.precio * 0.85;  // modifica el atributo directamente
        reporte.append("Después: ").append(mayorStock.toString()).append("\n");

        JOptionPane.showMessageDialog(null, reporte.toString());
    }
}
