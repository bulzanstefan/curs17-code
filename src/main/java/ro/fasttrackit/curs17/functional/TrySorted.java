package ro.fasttrackit.curs17.functional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;

public class TrySorted {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Maria", 3),
                new Person("Ionel", 13),
                new Person("Georgel", 23),
                new Person("Mihai", 22),
                new Person("Carl", 35),
                new Person("Magdalena", 50),
                new Person("Alexandrescu", 60),
                new Person("Ana", 11),
                new Person("Ion", 12)
        );

        persons.stream()
                .map(Person::getName)
                .sorted()
                .forEach(System.out::println);

        persons.stream()
                .map(Person::getName)
                .sorted(reverseOrder())
                .forEach(System.out::println);

        List<Person> sortedByName = persons.stream()
                .filter(person -> person.getAge() > 17)
                .sorted(comparing(Person::getName))
                .collect(Collectors.toList());
        System.out.println(sortedByName);

    }
}

class Person {
    private final String name;
    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
