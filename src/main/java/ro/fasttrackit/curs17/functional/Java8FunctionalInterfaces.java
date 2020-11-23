package ro.fasttrackit.curs17.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8FunctionalInterfaces {
    public static void main(String[] args) {
        System.out.println(processString("word", String::toUpperCase));
        System.out.println(processString("word", String::toLowerCase));
        System.out.println(processString("word", Java8FunctionalInterfaces::doSomething));
        System.out.println(processString("word", w -> "" + w.charAt(0)));
        System.out.println(processString("word", w -> w + " anonymous"));

        trySupply(() -> 30);
        trySupply(() -> 2 + 1);

        tryConsume(a -> System.out.println(a + 1));
        tryConsume(a -> System.out.println("Value is " + a));

        tryPredicate(a -> a % 2 == 0);

    }

    private static String doSomething(String s) {
        return s.substring(3);
    }

    public static String processString(String word, Function<String, String> behavior) {
        return behavior.apply(word);
    }

    public static void trySupply(Supplier<Integer> intSupplier) {
        Integer value = intSupplier.get();
        System.out.println("Value supplied : " + value);
    }

    public static void tryConsume(Consumer<Integer> consumer) {
        consumer.accept(2);
    }

    public static void tryPredicate(Predicate<Integer> predicate) {
        System.out.println(predicate.test(2));
    }
}
