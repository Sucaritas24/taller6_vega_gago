import javax.swing.JOptionPane;

public class Parte2 {
    public static void main(String[] args) {

        // Dimensiones de la tabla (modificado: 4 estudiantes)
        int filas    = 4;  // estudiantes
        int columnas = 3;  // materias

        // Declaración del arreglo 2D
        int[][] calificaciones = new int[filas][columnas];

        // Nombres de materias (arreglo 1D paralelo)
        String[] materias = {"Matematica", "Español", "Ciencias"};

        // Nombres de estudiantes
        String[] estudiantes = {"Ana", "Luis", "Carla", "Pedro"};

        // LLENADO con datos fijos (sin pedir al usuario para enfocarnos en el 2D)
        calificaciones[0][0] = 85;  calificaciones[0][1] = 72;  calificaciones[0][2] = 90;
        calificaciones[1][0] = 60;  calificaciones[1][1] = 88;  calificaciones[1][2] = 75;
        calificaciones[2][0] = 95;  calificaciones[2][1] = 70;  calificaciones[2][2] = 80;
        calificaciones[3][0] = 78;  calificaciones[3][1] = 65;  calificaciones[3][2] = 92;

        // IMPRIMIR la tabla
        StringBuilder reporte = new StringBuilder();
        reporte.append("=== TABLA DE CALIFICACIONES ===\n");
        reporte.append(String.format("%-10s", "Alumno"));
        for (String m : materias) {
            reporte.append(String.format("%-12s", m));
        }
        reporte.append("Promedio\n");
        reporte.append("-".repeat(50)).append("\n");

        // Recorrer FILAS (estudiantes)
        for (int f = 0; f < filas; f++) {
            int sumaFila = 0;
            reporte.append(String.format("%-10s", estudiantes[f]));

            // Recorrer COLUMNAS (materias) de este estudiante
            for (int c = 0; c < columnas; c++) {
                reporte.append(String.format("%-12d", calificaciones[f][c]));
                sumaFila += calificaciones[f][c];
            }
            double promedioFila = (double) sumaFila / columnas;
            reporte.append(String.format("%.2f\n", promedioFila));
        }

        // Promedio por COLUMNA (materia)
        reporte.append("-".repeat(50)).append("\n");
        reporte.append(String.format("%-10s", "Prom.mat"));
        for (int c = 0; c < columnas; c++) {
            int sumaCol = 0;
            for (int f = 0; f < filas; f++) {
                sumaCol += calificaciones[f][c];
            }
            reporte.append(String.format("%-12.2f", (double) sumaCol / filas));
        }

        JOptionPane.showMessageDialog(null, reporte.toString());
    }
}
