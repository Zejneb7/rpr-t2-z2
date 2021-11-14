package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    private double pocTacka, krajTacka; //treba li inic? (ne treba)
    private boolean pocTackaPripadaIntervalu, krajTackaPripadaIntervalu;

    //public konstruktor? //treba li baciti izuzetak prije dodjele
    public Interval(double pocTacka, double krajTacka, boolean pocTackaPripadaIntervalu, boolean krajTackaPripadaIntervalu) {
        if (pocTacka > krajTacka) throw new IllegalArgumentException("Pocetna tacka ne smije biti veca od krajnje!"); //catch
        this.pocTacka = pocTacka;
        this.krajTacka = krajTacka;
        this.pocTackaPripadaIntervalu = pocTackaPripadaIntervalu;
        this.krajTackaPripadaIntervalu = krajTackaPripadaIntervalu;
    }

    public Interval() {
        pocTacka = 0; //da li je ovo neophdono s obzirom da ej vec inic
        krajTacka = 0;
        pocTackaPripadaIntervalu = false;
        krajTackaPripadaIntervalu = false;
    }

    public boolean isNull() { //geter oznaka?
        if (pocTacka == 0 && krajTacka == 0 && pocTackaPripadaIntervalu == false && krajTackaPripadaIntervalu == false) return true;
        return false;
    }

    public boolean isIn(double tacka) {
        if (tacka > pocTacka && tacka < krajTacka) return true;
        if (pocTackaPripadaIntervalu) if (tacka == pocTacka) return true;
        if (krajTackaPripadaIntervalu) if (tacka == krajTacka) return true;
        return false;
    }

    public Interval intersect (Interval i) {
        Interval interval = new Interval();
        if (pocTacka < i.pocTacka && krajTacka < i.pocTacka) return interval;
        if (i.pocTacka < pocTacka && i.krajTacka < pocTacka) return interval;

        if (pocTacka > i.pocTacka) {
            interval.pocTacka = pocTacka;
            if (pocTackaPripadaIntervalu) interval.pocTackaPripadaIntervalu = true;
        }
        else {
            interval.pocTacka = i.pocTacka;
            if (i.pocTackaPripadaIntervalu) interval.pocTackaPripadaIntervalu = true;
        }

        if (krajTacka < i.krajTacka) {
            interval.krajTacka = krajTacka;
            if (krajTackaPripadaIntervalu) interval.krajTackaPripadaIntervalu = true;
        }
        else {
            interval.krajTacka = i.krajTacka;
            if (i.krajTackaPripadaIntervalu) interval.krajTackaPripadaIntervalu = true;
        }

        return interval;
    }

    public static Interval intersect (Interval interval1, Interval interval2) {
        Interval interval = new Interval();
        if (interval1.pocTacka < interval2.pocTacka && interval1.krajTacka < interval2.pocTacka) return interval;
        if (interval2.pocTacka < interval1.pocTacka && interval2.krajTacka < interval1.pocTacka) return interval;

        if (interval1.pocTacka > interval2.pocTacka) {
            interval.pocTacka = interval1.pocTacka;
            if (interval1.pocTackaPripadaIntervalu) interval.pocTackaPripadaIntervalu = true;
        }
        else {
            interval.pocTacka = interval2.pocTacka;
            if (interval2.pocTackaPripadaIntervalu) interval.pocTackaPripadaIntervalu = true;
        }

        if (interval1.krajTacka < interval2.krajTacka) {
            interval.krajTacka = interval1.krajTacka;
            if (interval1.krajTackaPripadaIntervalu) interval.krajTackaPripadaIntervalu = true;
        }
        else {
            interval.krajTacka = interval2.krajTacka;
            if (interval2.krajTackaPripadaIntervalu) interval.krajTackaPripadaIntervalu = true;
        }

        return interval;
    }

    @Override //stvara se novi string svaki put
    public String toString() {
        if (isNull()) return "()";
        if (pocTackaPripadaIntervalu && krajTackaPripadaIntervalu) return "[" + pocTacka + "," + krajTacka + "]";
        if (pocTackaPripadaIntervalu) return "[" + pocTacka + "," + krajTacka + ")";
        if (krajTackaPripadaIntervalu) return "(" + pocTacka + "," + krajTacka + "]";
        return "(" + pocTacka + "," + krajTacka + ")";
    }

    @Override
    public boolean equals(Object o) { //da li prima interval ili objekat //treba li se koristiti equals
        Interval i = (Interval) o;
        if (pocTacka == i.pocTacka && krajTacka == i.krajTacka && pocTackaPripadaIntervalu == i.pocTackaPripadaIntervalu && krajTackaPripadaIntervalu == i.krajTackaPripadaIntervalu) return true;
        return false;
    }
}
