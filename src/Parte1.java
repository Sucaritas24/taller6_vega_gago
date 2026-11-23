import javax.swing.JOptionPane;

public class Parte1 {
    public static void main(String[] args) {

        // 1. DECLARACIÓN Y CREACIÓN del arreglo (modificado: 8 notas en vez de 5)
        int[] notas = new int[8];

        // 2. LLENADO: pedimos las notas al usuario
        for (int i = 0; i < notas.length; i++) {
            String entrada = JOptionPane.showInputDialog(
                "Ingresa la nota " + (i + 1) + " (0-100):"
            );
            notas[i] = Integer.parseInt(entrada);
        }

        // 3. CÁLCULO de suma y promedio
        int suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma = suma + notas[i];   // acumula cada nota
        }
        double promedio = (double) suma / notas.length;

        // 4. BÚSQUEDA de nota máxima y mínima
        int maximo = notas[0];   // asumimos que el primero es el mayor
        int minimo = notas[0];   // asumimos que el primero es el menor
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > maximo) maximo = notas[i];
            if (notas[i] < minimo) minimo = notas[i];
        }

        // 5. CONSTRUCCIÓN del reporte
        StringBuilder reporte = new StringBuilder();
        reporte.append("=== REPORTE DE NOTAS ===\n");
        reporte.append("Notas ingresadas: ");
        for (int i = 0; i < notas.length; i++) {
            reporte.append(notas[i]);
            if (i < notas.length - 1) reporte.append(", ");
        }
        reporte.append("\n");
        reporte.append(String.format("Suma     : %d%n", suma));
        reporte.append(String.format("Promedio : %.2f%n", promedio));
        reporte.append(String.format("Máxima   : %d%n", maximo));
        reporte.append(String.format("Mínima   : %d%n", minimo));

        JOptionPane.showMessageDialog(null, reporte.toString());
    }
}
