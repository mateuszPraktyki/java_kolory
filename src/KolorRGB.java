public class KolorRGB {
    private int r;
    private int g;
    private int b;

    public KolorRGB(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int[] getRGB() {
        int[] rgb = {this.r, this.g, this.b};
        return rgb;
    }
}

