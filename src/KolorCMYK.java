public class KolorCMYK {
    private int c;
    private int m;
    private int y;
    private int k;

    public KolorCMYK(int c, int m, int y, int k){
        this.c = c;
        this.m = m;
        this.y = y;
        this.k = k;
    }

    public int[] getCMYK() {
        int[] cmyk = {this.c, this.m, this.y, this.k};
        return cmyk;
    }
}

