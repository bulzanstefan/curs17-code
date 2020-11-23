package ro.fasttrackit.curs17.functional;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TryStreams {
    public static void main(String[] args) {
        List<String> names = List.of("Serban", "Costel", "Ana", "Grigore", "Gheorghe", "Maria", "Dana", "Alexandru");

        List<String> gStartingNames = names.stream()
                .filter(name -> name.startsWith("G"))
                .collect(toList());

        System.out.println(gStartingNames);

        List<String> longNames = names.stream()
                .filter(name -> name.length() > 5)
                .map(name -> name + " LONG")
                .collect(toList());

        System.out.println(longNames);
    }
}
