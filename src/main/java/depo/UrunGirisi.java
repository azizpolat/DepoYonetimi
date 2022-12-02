package depo;

import java.util.Scanner;
import java.util.Set;

public class UrunGirisi {

    static Set<Integer> urunId = UrunTanimlama.urunler.keySet();

    static Scanner input = new Scanner(System.in);
    public static void urunGirisi(){
        System.out.println("=======URUN GIRIS PANELI=======");
        System.out.println("GIRMEK ISTEDIGINIZ URUNUN ID NOSUNU GIRINIZ");
        int id  = input.nextInt();
        UrunTanimlama obje = UrunTanimlama.urunler.get(urunId);

        do{
            if(urunId.contains(id)){
                System.out.println("MIKTARI GIRINIZ");
                int miktar = input.nextInt();
                obje.setMiktar(obje.getMiktar() + miktar);
                System.out.println("Urun eklemeye devam etmek icin 1'e \n Anasayfaya donmek icin herhangi bir tusa basiniz...");
                int secim = input.nextInt();

                if(secim==1){
                    urunGirisi();
                }else {
                    AnaMenu.anaMenu();
                }
            }else {
                System.out.println("URUN ID YANLIS. TEKRAR ID GIRINUIZ");
                id = input.nextInt();
            }
        }while (true);


    }

}
