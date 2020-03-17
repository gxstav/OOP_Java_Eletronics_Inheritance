import Eletronic.*;

public class Exec {
  public static void main(String[] args) throws Exception {
    Television samsung = new Television();
    samsung.setBrand("Samsung");
    samsung.setModel("SMART TV 50\" LED UHD 4K");
    System.out.println(samsung.brand());
    System.out.println(samsung.model());
    System.out.println(samsung.isOn());
    System.out.println(samsung.turnOn());
    System.out.println(samsung.gotoChannel(20));
    System.out.println(samsung.channelUp());
    System.out.println(samsung.favoriteIt());
    System.out.println(samsung.gotoChannel(57));
    System.out.println(samsung.favoriteIt());
    System.out.println(samsung.favorites());
    System.out.println(samsung.volumeUp(50));

    /********************************************/

    Radio jbl = new Radio();
    jbl.setBrand("JBL");
    jbl.setModel("Tuner AM/FM Portable USB");
    System.out.println(jbl.brand());
    System.out.println(jbl.model());
    System.out.println(jbl.isOn());
    System.out.println(jbl.turnOn());
    System.out.println(jbl.gotoFrequency(107.10, "FM"));
    System.out.println(jbl.freqUp(0.10));
    System.out.println(jbl.freqDown(0.10));
    System.out.println(jbl.favoriteIt());
    System.out.println(jbl.favorites());
    System.out.println(jbl.switchType());
    System.out.println(jbl.gotoFrequency(710.4, "AM"));
    System.out.println(jbl.favoriteIt());
    System.out.println(jbl.favorites());
  }
}
