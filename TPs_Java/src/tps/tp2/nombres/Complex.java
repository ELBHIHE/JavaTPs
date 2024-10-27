package tps.tp2.nombres;

public class Complex  {

    private Double re, im;
    public double   getRe()          { return re;}
    public double   getIm()          { return im; }
    public void     setIm(double im)  {
          this.im = im;
    }
    public void     setRe(double re) {
        this.re = re;
    }

    public Complex  ()                          {}
    public Complex  (Double im)                 { 
        setIm(im);
    }

    public Complex  (Double re, Double im)      { 
        setRe(re); 
        setIm(im); 
    }

    public Complex  (Complex other)             { 
        setRe(other.re); setIm(other.im);
    }


    @Override
    public String toString() {
        // Round the precision value of re and im to two number
          re = (double)Math.round(re*100)/100;
          im = (double)Math.round(im*100)/100;

        if(re == 0)             return              im           + " * i";
        else    {
                    if(im >= 0) return re + " + " + im           + " * i";
                    else        return re + " - " + Math.abs(im) + " * i";
                }
    }

    public      Complex add         (Complex other) {

        var re = this.getRe() + other.getRe();
        var im = this.getIm() + other.getIm();

        return new Complex(re, im);
    }
    public      Complex mines       (Complex other) {

        var re = this.getRe() - other.getRe();
        var im = this.getIm() - other.getIm();

        return new Complex(re, im);
    }
    public      Complex multiply    (Complex other) {

        var re = this.getRe() * other.getRe() - this.getIm() * other.getIm();
        var im = this.getIm()*other.getRe() + other.getIm()*this.getRe();

        return new Complex(re, im);
    }
    public      Complex divides     (Complex other) { return this.multiply( other.reciprocal()); }
    public      Complex reciprocal  ()              {

        var re = this.getRe()/Math.pow(module(), 2);
        var im = -this.getIm()/Math.pow(module(), 2);

        return new Complex(re, im);
    }
    private     double  module      ()              { return Math.hypot(this.getRe(), this.getIm());}
    public      Complex conjugate   (Complex other) {

        var re = this.getRe();
        var im = -this.getIm();

        return new Complex(re, im);
    }

}
