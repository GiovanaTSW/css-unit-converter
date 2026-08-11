public class ConversorUnidades {
    
    public static double pxToEm(double px, double basePx) {
        return px/basePx;
    }

    public static double emToPx(double em, double basePx) {
        return em * basePx;
    }
}
