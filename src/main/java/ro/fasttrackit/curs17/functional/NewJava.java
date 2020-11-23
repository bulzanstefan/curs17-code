package ro.fasttrackit.curs17.functional;

public class NewJava {
    public static void main(String[] args) {
        System.out.println(
                processString("java", s -> s.toUpperCase()));
        System.out.println(
                processString("java", s -> {
                    String newString = s + " altceva";
                    return newString;
                })
        );
    }

    public static String processString(String word, Lambda behavior) {
        return behavior.apply(word);
    }
}

@FunctionalInterface
interface Lambda {
    String apply(String word);
}
