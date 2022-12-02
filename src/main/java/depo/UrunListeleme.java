package depo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UrunListeleme {


    static Scanner input = new Scanner(System.in);


    public static void urunListesi() {

        System.out.println("========URUN LISTELEME SAYFASI=========");
        System.out.println("_____________________________________________________________________________________");
        System.out.println("\tID\t\t\tİSİM\t\t\tURETİCİ\t\t\tMİKTAR\t\t\tBİRİM\t\t\tRAF\t");
        System.out.println("-------------------------------------------------------------------------------------");

        Map<Integer, UrunTanimlama> rrr = UrunTanimlama.urunListesiOlustur();

        Set<Map.Entry<Integer, UrunTanimlama>> urunlerSet = rrr.entrySet();

        for (Map.Entry<Integer, UrunTanimlama> w : urunlerSet) {

            System.out.print("\t" + w.getKey() + " " + w.getValue());
            System.out.println("\n");

        }

        System.out.println("ANA MENUYE DONMEK ICIN 1 BASINIZ");
        int secim = input.nextInt();
        do {
            if (secim == 1) {
                AnaMenu.anaMenu();
                break;
            } else {
                System.out.println("YANLIS SECIM YAPTINIZ. ANA MENU ICIN 1 BASINIZ");
            }
        } while (true);

    }
}