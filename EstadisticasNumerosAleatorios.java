import java.util.*;

public class EstadisticasNumerosAleatorios {

    public static int[] generarNumerosAleatorios(int cantidad, int valorMinimo, int valorMaximo) {
        int[] Numeros = new int[cantidad];
        Random random = new Random();
        
        if (valorMinimo > valorMaximo) {
            throw new IllegalArgumentException("Error al generar: Rango invalido");
        }
        
        for (int i = 0; i < cantidad; i++) {
            Numeros[i] = random.nextInt(valorMaximo - valorMinimo + 1) + valorMinimo;
        }
        return Numeros;
    }

    public static double[] calcularEstadisticas(int[] Numeros) {
        if (Numeros.length == 0) {
            throw new IllegalArgumentException("No se puede calcular para una lista vacia");
        }
        
        int sumaTotal = 0;
        for (int num : Numeros) {
            sumaTotal += num;
        }
        double promedio = (double) sumaTotal / Numeros.length;
        
        return new double[]{sumaTotal, promedio};
    }

    public static String formatearNumero(double numero) {
        return String.format("%,.2f", numero);
    }

    public static void main(String[] args) {
        final int CANTIDAD = 500;
        final int VALOR_MINIMO = 10;
        final int VALOR_MAXIMO = 1000;
        
        try {
            System.out.println("\n=== Generador de estadisticas de numeros aleatorios ===\n");
            System.out.printf("Generando %d numeros aleatorios entre %d y %d...%n", CANTIDAD, VALOR_MINIMO, VALOR_MAXIMO);
            
            int[] Numeros = generarNumerosAleatorios(CANTIDAD, VALOR_MINIMO, VALOR_MAXIMO);
            double[] estadisticas = calcularEstadisticas(Numeros);
            
            System.out.println("\nResultados:");
            System.out.println("-".repeat(40));
            System.out.printf("Suma:     %s%n", formatearNumero(estadisticas[0]));
            System.out.printf("Promedio: %s%n", formatearNumero(estadisticas[1]));
            System.out.println("-".repeat(40));
            
            System.out.println("\nMuestra de numeros generados:");
            Random rand = new Random();
            for (int i = 0; i < 10; i++) {
                int index = rand.nextInt(CANTIDAD);
                System.out.print(Numeros[index] + ", ");
            }
            System.out.println("...");
        } catch (Exception e) {
            System.err.println("\nError: " + e.getMessage());
            System.exit(1);
        }
    }
}
