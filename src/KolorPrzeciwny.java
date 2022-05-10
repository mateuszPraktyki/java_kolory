public class KolorPrzeciwny {
    private int[] color;

    public KolorPrzeciwny(int[] color){
        this.color = color;
    }

    public void kolorPrzeciwny()
    {
        System.out.println("\n\nKolory przeciwne:\n");
        if(this.color.length == 4)
        {
            kpCMYK(this.color[0], this.color[1], this.color[2], this.color[3]);
        }
        else if(this.color.length == 3)
        {
            kpRGB(this.color[0], this.color[1], this.color[2]);
        }
    }

    public void kpRGB(double r, double g, double b)
    {
        // https://en.wikipedia.org/wiki/Complementary_colors
        double rB = 255 - r;
        double gB = 255 - g;
        double bB = 255 - b;

        System.out.println("kolor oryginalny: " + r + " " + g + " " + b);
        System.out.println("kolor przeciwny: " + rB + " " + gB + " " + bB);
    }

    public void kpCMYK(double c, double m, double y, double k)
    {
        System.out.println("kolor oryginalny: " + c + "% " + m + "% " + y + "% " + k + "%");

        c = c / 100;
        m = m / 100;
        y = y / 100;
        k = k / 100;

        double r = 0, g = 0, b = 0;

        //double tr = 255 * (1 - k) * (1 - c);
        //double tg = 255 * (1 - k) * (1 - m);
        //double tb = 255 * (1 - k) * (1 - y);

        //System.out.println("rgb: " + tr + " " + tg + " " + tb);

        r = (255 - (255 * (1 - k) * (1 - c))) / 255;
        g = (255 - (255 * (1 - k) * (1 - m))) / 255;
        b = (255 - (255 * (1 - k) * (1 - y))) / 255;

        k = 1 - Math.max(r, Math.max(g, b));
        c = (1 - r - k)/(1 - k) * 100;
        m = (1 - g - k)/(1 - k) * 100;
        y = (1 - b - k)/(1 - k) * 100;

        System.out.println("kolor przeciwny: " + Math.floor(c) + "% " + Math.floor(m) + "% " + Math.floor(y)  + "% " + Math.floor(k) + "%");
    }
}
