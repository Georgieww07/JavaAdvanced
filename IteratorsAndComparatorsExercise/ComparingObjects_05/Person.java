package IteratorsAndComparatorsExercise.ComparingObjects_05;

public class Person implements Comparable<Person>{

    public String name;
    public int age;
    String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person person) {
        if (this.name.equals(person.name)) {
            if (this.age == person.age) {
                if (this.town.equals(person.town)) {
                    return 0;
                }
                return 1;
            }
            return 1;
        }
        return 1;
    }
}
