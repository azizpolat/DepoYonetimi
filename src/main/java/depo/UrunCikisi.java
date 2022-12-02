package depo;

import java.util.Scanner;
import java.util.Set;

public class UrunCikisi {


    static Set<Integer> urunId = UrunTanimlama.urunler.keySet();

    static Scanner input = new Scanner(System.in);
    public static void urunCikis() {

        System.out.println("=======URUN CIKIS SAYFASI======== ");
        System.out.println("CIKIS YAPACAGINIZ URUNUN ID NOSUNU GIRINIZ");
        int id = input.nextInt();
        UrunTanimlama obje = UrunTanimlama.urunler.get(id);

        do{
            if(urunId.contains(id)){
                System.out.println("CIKIS YAPACAGINIZ MIKTARI SECIN");
                int cikisMiktari = input.nextInt();
                if (obje.getMiktar()>=cikisMiktari){
                    obje.setMiktar(obje.getMiktar()-cikisMiktari);
                    System.out.println("Urun cikartmaya devam etmek icin 1'e \n Anasayfaya donmek icin herhangi bir tusa basiniz...");
                    int secim = input.nextInt();

                    if (secim == 1) {
                        urunCikis();
                    } else {
                       AnaMenu.anaMenu();
                }
            }else{
                    System.out.println("STOKTA BU KADAR URUN YOKTUR\n" +
                                    "DEPODAKI TUM URUNU CIKARMAK ICIN 1 BASIN\n"+
                            "CIKIS YAPMAK ISTEDIGINIZ MIKTARI GIRMEK ICIN 2 BASINIZ\n" +
                            "ANA MENUYE DONMEK ICIN BIR TUSA BASIN");
                    int islem = input.nextInt();

                    switch (islem){
                        case 1:
                            System.out.println("DEPODAN CIKAN MIKTAR = " + obje.getMiktar());
                            obje.setMiktar(0);
                            System.out.println( "ANA MENUYE DONMEK ICIN BIR TUSA BASIN");
                            input.nextInt();
                            AnaMenu.anaMenu();
                            break;

                        case 2 :
                           urunCikis();
                           break;
                        default:

                            AnaMenu.anaMenu();
                            break;

                    }
                }

        }else{
                System.out.println("GECERLI ID GIRINIZ");
                id= input.nextInt();
            }

    }while (true);
}
    }
