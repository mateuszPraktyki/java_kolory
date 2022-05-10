public class App {
    public static void main(String[] args) throws Exception {
        KolorRGB kRGB1 = new KolorRGB(118, 116, 235);
        KolorRGB kRGB2 = new KolorRGB(118,27,27);

        KolorCMYK kCMYK1  = new KolorCMYK(5, 15, 100, 5);
        KolorCMYK kCMYK2 = new KolorCMYK(55, 10, 30, 35);

        PorownanieJasnosci pJ1 = new PorownanieJasnosci(kRGB1.getRGB(), kRGB2.getRGB());
        PorownanieJasnosci pJ2 = new PorownanieJasnosci(kCMYK1.getCMYK(), kCMYK2.getCMYK());

        pJ1.porownajJasnosc();
        pJ2.porownajJasnosc();

        KolorPrzeciwny kp1 = new KolorPrzeciwny(kRGB1.getRGB());
        KolorPrzeciwny kp2 = new KolorPrzeciwny(kRGB2.getRGB());
        KolorPrzeciwny kp3 = new KolorPrzeciwny(kCMYK1.getCMYK());
        KolorPrzeciwny kp4 = new KolorPrzeciwny(kCMYK2.getCMYK());

        kp1.kolorPrzeciwny();
        kp2.kolorPrzeciwny();
        kp3.kolorPrzeciwny();
        kp4.kolorPrzeciwny();
    }
}

/**
 * Oczekiwane wyniki: 
 * 1.1)
 * rgb: 118, 116, 235
 * hex: #7674EB
 * lumin1:  22,3
 * dominant: Blue
 *
 * 1.2)
 * rgb: 118,27,27
 * hex: #761B1B
 * lumin2: 4,7
 * dominant: Red
 *
 * 1.3)
 * lumin - lumin: 17,6
 *
 * 2.1)
 * cmyk: 5, 15, 100, 5
 * rgb: 230, 206, 0
 * hex: #E6CE00
 * lumin3: 60,96
 * dominant: Yellow
 *
 * 2.2)
 * cmyk: 55, 10, 30, 35
 * rgb: 75, 149, 166
 * hex: #4B9574
 * lumin4: 24,2
 * dominant: Green
 *
 * 2.3)
 * lumin - lumin: 36%
 *
 * 3.1)
 * rgb1 comp: #898b14
 * rgb: 137, 139, 20
 *
 * 3.2)
 * cmyk1 comp: #1931ff
 * rgb: 25, 49, 255
 * cmyk: 90, 81, 0, 0
 */