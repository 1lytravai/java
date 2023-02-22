public class Fraction {
    private int numer;
    private int denom;

    public Fraction(){
        this.numer = 0;
        this.denom = 1;
    }

    public Fraction(int x, int y){
        this.numer = x;
        this.denom = y;
    }

    public Fraction(Fraction f){
        this.denom = f.denom;
    }

    public String toString(){
        //eturn "Fraction: numer ="+this.numer+", denom ="+this.denom;
        return this.numer+"/"+this.denom;
    }

    public boolean equals(Object f){
        if(this == f){
            return true;
        }
        else {
            if(f instanceof Fraction){
                Fraction tmp = (Fraction) f;
                if ((tmp.numer == this.numer && tmp.denom == this.denom) || ((tmp.numer / tmp.denom == this.numer / this.denom) && (tmp.denom / tmp.numer == this.denom / this.numer))){
                    return true;
                }
            }
        }
        return false;
    }
}