public class PorownanieJasnosci {
    private int[] color1;
    private int[] color2;

    public PorownanieJasnosci(int[] color1, int[] color2){
        this.color1 = color1;
        this.color2 = color2;
    }

    public void porownajJasnosc(){
        System.out.println("\n\nPorownanie jasnosci:\n");
        double lumin1 = 0, lumin2 = 0;
        if(this.color1.length == 4 && this.color2.length == 4)
        {
            lumin1 = toRGB(this.color1[0], this.color1[1], this.color1[2], this.color1[3]);
            //System.out.println("Kolor cmyk2 przed konwersja: " + this.color2[0] + " " + this.color2[1] + " " + this.color2[2] + " " + this.color2[3]);
            lumin2 = toRGB(this.color2[0], this.color2[1], this.color2[2], this.color2[3]);
        }
        else {
            lumin1 = lumin(this.color1[0], this.color1[1], this.color1[2]);
            lumin2 = lumin(this.color2[0], this.color2[1], this.color2[2]);

            System.out.println(dominant(this.color1[0], this.color1[1], this.color1[2]));
            System.out.println(dominant(this.color2[0], this.color2[1], this.color2[2]));
        }

        if(lumin1 > lumin2)
        {
            System.out.println("Kolor 1 jest jasniejszy o " + Math.floor((lumin1-lumin2)*100) + "%");
        }
        else if(lumin2 > lumin1){
            System.out.println("Kolor 2 jest jasniejszy o " + Math.floor((lumin2-lumin1)*100) + "%");
        }
        else {
            System.out.println("Kolory maja taka sama jasnosc");
        }
    }

    public double toRGB(double c, double m, double y, double k)
    {
        c = c / 100;
        m = m / 100;
        y = y / 100;
        k = k / 100;

        double r = 0, g = 0, b = 0;

        r = 255 * (1 - k) * (1 - c);
        g = 255 * (1 - k) * (1 - m);
        b = 255 * (1 - k) * (1 - y);

        //System.out.println("po konwersji: " + r + " " + g + " " + b);

        System.out.print(dominant(r, g, b) + "\n");

        return lumin(r, g, b);
    }

    public double lumin(double r, double g, double b)
    {
        //https://www.w3.org/WAI/GL/wiki/Relative_luminance
        r = r / 255;
        g = g / 255;
        b = b / 255;

        double[] colorChannel = {r, g, b};

        for(int i = 0; i <= 2; i++)
        {
            if ( colorChannel[i] <= 0.3928 ) {
                colorChannel[i] /= 12.92;
            }
            else {
                colorChannel[i] = Math.pow((( colorChannel[i] + 0.055)/1.055),2.4);
            }
        }

        return (0.2126 * colorChannel[0] + 0.7152 * colorChannel[1] + 0.0722 * colorChannel[2]);
    }

    public String dominant(double r, double g, double b)
    {
        /**
            https://en.wikipedia.org/wiki/List_of_colors_by_shade

            hue (w stopniach):
                red: 0-18 i 306-359
                orange: 19 - 41
                yellow: 42 - 69
                green: 70 - 166
                blue: 167 - 251
                violet: 252 - 305
         */

        if(r == g && r == b) {
            if(r <= 17)
            {
                return "black";
            }
            else if(r >= 18 && r <= 215)
            {
                return "gray";
            }
            else {
                return "white"; }
        }
        else {
            double h = rgbToHSV(r, g, b);
            if((h >= 0 && h <= 18) || (h >= 306 && h <= 360)){
                return "red";
            }
            else if(h >= 19 && h <= 41){
                return "orange";
            }
            else if(h >= 42 && h <= 69){
                return "yellow";
            }
            else if(h >= 70 && h <= 166){
                return "green";
            }
            else if(h >= 167 && h <= 251){
                return "blue";
            }
            else if(h >= 252 && h <= 305){
                return "violet";
            }
        }
        return " ";
    }

    public double rgbToHSV(double r, double g, double b) {
        System.out.print("kolor dominujacy: ");

        r = r / 255.0;
        g = g / 255.0;
        b = b / 255.0;

        double cmax = Math.max(r, Math.max(g, b));
        double cmin = Math.min(r, Math.min(g, b));
        double diff = cmax - cmin;
        double h = 0;

        if (cmax == cmin)
            h = 0;

        else if (cmax == r)
            h = (60 * ((g - b) / diff) + 360) % 360;

        else if (cmax == g)
            h = (60 * ((b - r) / diff) + 120) % 360;

        else if (cmax == b)
            h = (60 * ((r - g) / diff) + 240) % 360;

        return h;
    }
}

    /*
    public double toHSL(double r, double g, double b)
    {
        //System.out.println(r + " " + g + " " + b);

        r = r / 255;
        g = g / 255;
        b = b / 255;

        //System.out.println(r + " " + g + " " + b);

        double max = Math.max(Math.max(r, g), b);
        double min = Math.min(Math.min(r, g), b);

        double luminance = (min + max) / 2;
        System.out.println("\nL: " + luminance + "\n");

        return luminance;
    }

    public void rgbToHSV(int rK, int gK, int bK) {
        double r = rK / 255.0;
        double g = gK / 255.0;
        double b = bK / 255.0;

        System.out.println(r + " " + g + " " + b);

        double cmax = Math.max(r, Math.max(g, b));
        double cmin = Math.min(r, Math.min(g, b));
        double diff = cmax - cmin;
        double h = -1, s = -1;

        if (cmax == cmin)
            h = 0;

        else if (cmax == r)
            h = (60 * ((g - b) / diff) + 360) % 360;

        else if (cmax == g)
            h = (60 * ((b - r) / diff) + 120) % 360;

        else if (cmax == b)
            h = (60 * ((r - g) / diff) + 240) % 360;

        if (cmax == 0)
            s = 0;
        else
            s = (diff / cmax) * 100;

        double v = cmax * 100;
        System.out.println("(h: " + h + " s: " + s + " v: " + v + ")");
    }

    public void jasnoscRGB(int[] color1, int[] color2){
        String rgba = "rgb(" + color1[0] + ", " + color1[1] + ", " + color1[2] + ")";
        String rgbb = "rgb(" + color2[0] + ", " + color2[1] + ", " + color2[2] + ")";
        double jasnosc1 = 0.2126 * this.color1[0] + 0.7152 * this.color1[1] + 0.0722 * this.color1[2];
        double jasnosc2 = 0.2126 * this.color2[0] + 0.7152 * this.color2[1] + 0.0722 * this.color2[2];
        if(jasnosc1 > jasnosc2)
        {
            System.out.println("Kolor 1: " + rgba + " jest jasniejszy od koloru 2: " + rgbb + " w przyblizeniu o " + Math.floor(jasnosc1 - jasnosc2));

        }
        else if(jasnosc1 < jasnosc2)
        {
            System.out.println("Kolor 2: " + rgbb + " jest jasniejszy od koloru 1: " + rgba + " w przyblizeniu o " + Math.floor(jasnosc2 - jasnosc1));

        }
        else
        {
            System.out.println("Kolory maja taka sama jasnosc");
        }
    }

    public void jasnoscCMYK(int[] color1, int[] color2)
    {

    }
    */

//(0.2126*R + 0.7152*G + 0.0722*B)


