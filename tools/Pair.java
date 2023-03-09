package lab6.tools;

import lab6.state.Kunder;

public class Pair {
    private Kunder kund;
    private double tid;

    /*Constructs en object av som består av tid och kund
    * */
    public Pair(Kunder kund, double tid) {
        this.kund = kund;
        this.tid = tid;
    }

    public Kunder kund() {
        return this.kund;
    }

    public double tid() {
        return this.tid;
    }

    @Override
    public String toString() {
        return "(" + this.kund + "," + this.tid + ")";
    }

}
