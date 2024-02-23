package SetsAndMaps;

import java.util.*;

public class SoftUniParty_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Set<String> regular = new TreeSet<>();
        Set<String> vip = new TreeSet<>();


        String input = scanner.nextLine();
        while (!"PARTY".equals(input)){

            if (Character.isDigit(input.charAt(0))){
                vip.add(input);
            }else {
                regular.add(input);
            }
            input = scanner.nextLine();
        }


        String guest = scanner.nextLine();
        while (!"END".equals(guest)){

            if (Character.isDigit(guest.charAt(0))){
                vip.remove(guest);
            }else {
                regular.remove(guest);
            }

            guest = scanner.nextLine();
        }

        System.out.println(vip.size() + regular.size());

        for (String vipGuest : vip) {
            System.out.println(vipGuest);
        }

        for (String regularGuest : regular) {
            System.out.println(regularGuest);
        }
    }
}
