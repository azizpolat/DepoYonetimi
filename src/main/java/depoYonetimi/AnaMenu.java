package depoYonetimi;

import java.util.*;

public class AnaMenu {

    static Scanner input;


    static Map<Integer,UrunlerPojoo> urunler = new HashMap<>();



//    static Set<Map.Entry<Integer, UrunlerPojo>> urunlerListeSet = urunler.entrySet();



    static int id = 1000;


    static int raf1 = 15;

    public static void panel(){
        input = new Scanner(System.in);

        System.out.println("========================== İŞLEMLER =======================\r\n"
                + "   ____________________             ____________________    \n"
                + "   | 1-URUN TANIMLAMA  |            | 2-MİKTAR GUNCELLEME|  \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯    \n"
                + "   ____________________             ____________________    \n"
                + "   | 3-RAF GUNCELLEME  |            | 4-URUN CIKISI     |   \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯    \n"
                + "   ____________________             ____________________    \n"
                + "   | 5-URUN LİSTELE    |            | 6-CIKIS           |   \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯       " );

        System.out.println("bir islem seciniz");
        String secim = input.next();

        switch (secim){

            case "1":
                urunTanimlama();
                break;
            case "2":
                miktarGuncelleme();
                break;
            case "3":
                rafGuncelleme();
                break;
            case "4":
                urunCikisi();
                break;
            case "5":
                urunListele();
                break;
            case "6":
                cikis();
                break;
            default:
                System.out.println("gecersiz islem");
                panel();
                break;
        }

    }

    private static void cikis() {

        System.out.println("cikis yaptiniz tesekkurler");
    }

    private static void urunListele() {

        System.out.println(" id          ismi         ureticisi         miktari          birimi         raf\n" +
                "-----------------------------------------------------------------------------------------");
        Set<Map.Entry<Integer, UrunlerPojoo>> entries = urunler.entrySet();
        for(Map.Entry<Integer, UrunlerPojoo> w : entries) {
            System.out.println(w);
        }
        //urunleri duzgun siralama nasil yapilir?
        panel();
    }

    private static void urunCikisi() {
        //get set kullan

        System.out.println("azaltmak istediginiz urunun id sini giriniz.");
        int id = input.nextInt();
        if (urunler.containsKey(id)){
            System.out.println("raf1 = " + raf1);
            if (urunler.get(id).getMiktar()==0){
                System.out.println("urun zaten stokta bulunmuyor.");
                panel();
            }else {
                System.out.println("cikarmak istediginiz urunun miktari: " +
                        urunler.get(id).getMiktar());

                System.out.println("ne kadar cikis yapmak istiyorsunuz?");
                int cikis = input.nextInt();

                int son = urunler.get(id).getMiktar()-cikis;


                if (son<0){
                    System.out.println("cikis yapmak istediginiz kadar urun zaten bulunmamaktadir ");
                    System.out.println("cikarmak istediginiz urunun miktari: " +
                            urunler.get(id).getMiktar());
                    panel();
                }else {
                    urunler.get(id).setMiktar(son);

                    if (urunler.get(id).getRaf().equals("raf1")){
                        raf1 = raf1+cikis;
                        System.out.println(raf1);

                    }

                    System.out.println("kalan " +
                            urunler.get(id).getMiktar() + " " +
                            urunler.get(id).getBirim() + " " +
                            urunler.get(id).getUrunAdi());
                    urunListele();
                }

            }



        }else {
            System.out.println("Yanlis id girdiniz");
            rafGuncelleme();
        }
    }

    private static void rafGuncelleme() {

        System.out.println("raf girmek istediginiz urunun id sini giriniz.");
        int id = input.nextInt();
        if (urunler.containsKey(id)){
            System.out.println("girmek istediginiz rafin numarasini giriniz");
            int rafNo = input.nextInt();
            String son = "raf" + rafNo;



            int count = 0;

            Collection<UrunlerPojoo> values = urunler.values();
            for (UrunlerPojoo w: values){

                if (w.getRaf() == null){

                    continue;

                }

                if (w.getRaf().equalsIgnoreCase(son)){


                    System.out.println("bu raf kullaniliyor");
                    count++;
                    break;
                }

            }

            if (count>0){
                rafGuncelleme();

            }else {
                urunler.get(id).setRaf(son);
                urunListele();
            }


        }else {
            System.out.println("Yanlis id girdiniz");
            rafGuncelleme();
        }
    }

    private static void miktarGuncelleme() {

        System.out.println("miktarini girmek istediginiz urunun id sini giriniz.");
        int id = input.nextInt();
        if (urunler.containsKey(id)){
            System.out.println("raf1 = " + raf1);
            System.out.println("girmek istediginiz miktari yaziniz.");
            int miktar = input.nextInt();
            urunler.get(id).setMiktar(miktar+urunler.get(id).getMiktar());


            if (urunler.get(id).getRaf().equals("raf1")){
                raf1 = raf1-miktar;
                System.out.println(raf1);

            }
            urunListele();



        }else {
            System.out.println("Yanlis id girdiniz");
            panel();
        }
    }

    private static void urunTanimlama() {

        input = new Scanner(System.in);
        System.out.println("urunun ismini giriniz");
        String urunIsmi = input.nextLine();
//        input.nextLine(); //dummy
        System.out.println("ureticiyi giriniz");
        String uretici = input.nextLine();
//        input.nextLine();
        System.out.println("birim giriniz");
        String birim = input.nextLine();
//        input.nextLine();
        int miktar = 0;
        String raf = null;

        UrunlerPojoo obj = new UrunlerPojoo(urunIsmi,uretici,birim,miktar,raf);
        urunler.put(id,obj);


        id++;

        System.out.println(urunler);
        panel();




    }
}
