package depo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UrunTanimlama {

    static Scanner input = new Scanner(System.in);

    static Map<Integer , UrunTanimlama> urunler = new HashMap<>();

    private static int urunId;
    private String urunIsmi;
    private String uretici;
    private int miktar=0;
    private String birim;
    private String raf = null;
    public static int idRakam = 100;

    public UrunTanimlama(String urunIsmi, String uretici, String birim) {
        this.urunId = idRakam;
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.birim = birim;
        miktar=0;
        idRakam++;
    }

    public static Object urunBilgileriniAl() {
        System.out.println("URUN ISMINI GIRINIZ");
        String isim = input.next();
        System.out.println("URETICI ISMINI GIRINIZ");
        String uretici = input.next();
        System.out.println("BIRIMI GIRINIZ = ");
        String birim = input.next();

        UrunTanimlama urunObje = new UrunTanimlama(isim, uretici, birim);
        urunler.put(getUrunId(), urunObje);

        do{
            System.out.println("URUN EKLEMEGE DEVAM ETMEK ICIN 1 \n ANASYFAYA DONMEK ICIN 2 BASINIZ ");
            int secim = input.nextInt();
            if(secim==1){
                urunBilgileriniAl();
                break;
            } else if(secim==2){
                AnaMenu.anaMenu();
                break;
            }else{
                System.out.println("YANLIS BIR SECIM YAPTINIZ");

            }
        }while (true);
        return urunObje;


    }

    public static Map<Integer,UrunTanimlama>  urunListesiOlustur(){
        return urunler;
    }

    public static Integer getUrunId() {
        return urunId;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    @Override
    public String toString() {
        return "UrunTanimlama{" +
                "urunIsmi='" + urunIsmi + '\'' +
                ", uretici='" + uretici + '\'' +
                ", miktar=" + miktar +
                ", birim='" + birim + '\'' +
                ", raf='" + raf + '\'' +
                '}';
    }
}
