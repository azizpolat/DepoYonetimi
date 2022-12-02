package depo;

import java.util.Scanner;

public class AnaMenu {

    static Scanner input = new Scanner(System.in);

    public static void anaMenu(){
        System.out.println("=======DEPO ANA SAYFASINA HOSGELDINIZ========");
        System.out.println("1- Urun Tanimlama\n" +
                           "2- Urun Rafa Koy\n" +
                           "3- Urun Girisi\n" +
                           "4- urun Cikisi\n" +
                           "5- Urun Listele\n" +
                           "6- Cikis");

        System.out.println("YAPMAK ISTEDIGINIZ ISLEMIN NOSUNU GIRINIZ");
        int secim = input.nextInt();

        switch (secim){
            case 1 :
                UrunTanimlama.urunBilgileriniAl();
                break;
            case 2 :
                UrunRaf.urunRafaKoy();
                break;
            case 3 :
                UrunGirisi.urunGirisi();
                break;
            case 4 :
                UrunCikisi.urunCikis();
                break;
            case  5 :
                UrunListeleme.urunListesi();
                break;
            default:
                System.out.println("GECERLI BIR SECIM YAPINIZ");
                anaMenu();
                break;

        }



    }

}
