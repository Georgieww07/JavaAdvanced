package Generics.GenericScale_03;

public class Main {
    public static void main(String[] args) {


        Scale<Integer> scale = new Scale<>(1, 2);

        System.out.println(scale.getHeavier());
    }
}
