package depo;

import java.util.Scanner;
import java.util.Set;

public class UrunRaf {


    static Set<Integer> urunId = UrunTanimlama.urunler.keySet();

    static Scanner input = new Scanner(System.in);


    public static void urunRafaKoy() {
        System.out.println("=======URUN RAFA KOYMA BOLUMU=========");
        System.out.println("RAFA EKLEMEK ISTEDIGINIZ URUNUN ID NOSUNU GIRINIZ :");
        int id = input.nextInt();

        UrunTanimlama obje = UrunTanimlama.urunler.get(urunId);

        do{
            if(urunId.contains(id)){
                System.out.println("URUN ICIN RAF SECINIZ");
                String istenilenRaf = input.next();
                obje.setRaf(istenilenRaf);

                System.out.println("Rafa Koymaya devam etmek icin 1'e \n Anasayfaya donmek icin herhangi bir tusa basiniz...");
                int secim = input.nextInt();

                if(secim==1){
                    urunRafaKoy();
                }else {
                    AnaMenu.anaMenu();
                }
            }else{
                System.out.println("YANLIS ID GIRDINIZ. TEKRAR ID GIRNIZ");
                id = input.nextInt();
            }
        }while (true);


    }
}
