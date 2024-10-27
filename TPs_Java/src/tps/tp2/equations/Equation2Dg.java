package tps.tp2.equations;

public class Equation2Dg {
    private double a, b, c, delta;

    public double   getA    () {
        return a;
    }
    public void     setA    (double a) {
        this.a = a;
    }
    public double   getB    () {
        return b;
    }
    public void     setB    (double b) {
        this.b = b;
    }
    public double   getC    () {
        return c;
    }
    public void     setC    (double c) {
        this.c = c;
    }
    public double   getDelta()         { return Math.pow(b, 2) - 4 * a * c; }

    public Equation2Dg() {}
    public Equation2Dg(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.delta = Math.pow(b, 2) - 4 * a * c;
    }

    @Override
    public String toString() {
        return "Equation : " + a + " * X'2 + " + b + "* X + " + c + " = 0 ";
    }
}
