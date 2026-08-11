import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el tamaño base en px:");
        double base = scanner.nextDouble();

        System.out.println("Ingrese la cantidad de px a convertir a em: ");
        double px = scanner.nextDouble();

        double resultadoEm = ConversorUnidades.pxToEm(px, base);

        System.out.println("Ingrese la cantidad de em a convertir a px");
        double em = scanner.nextDouble();

        double resultadoPx = ConversorUnidades.emToPx(em, base);

        System.out.println("Tu resultado de px a em es: " + resultadoEm);
        System.out.println("Tu resultado de em a px es: " + resultadoPx);

        scanner.close();
    }
}
