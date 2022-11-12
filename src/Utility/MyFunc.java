package Utility;

public class MyFunc {
    public static int ilk;
    public static int ikinci;
    public static void Bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static int randomNumber(){
        int random=(int) (Math.random()*100);
        return random;
    }
    public static String asert(int a,int ilk,int ikinci){
        int conclusion=0;
        switch (a){
            case 0:conclusion= ikinci+ilk;break;
            case 1:conclusion= ilk-ikinci;break;
            case 2:conclusion= ilk*ikinci;break;
            case 3:conclusion= ilk/ikinci;break;
            case 4:return ilk+""+ikinci;
        }String sonuc= String.valueOf(conclusion);
        return sonuc;
    }
}
