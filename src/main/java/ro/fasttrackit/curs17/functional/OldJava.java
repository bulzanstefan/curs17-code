package ro.fasttrackit.curs17.functional;

public class OldJava {
    public static void main(String[] args) {
        System.out.println(processString("java", new UppercaseBehavior()));
        System.out.println(processString("java", new FirstLetterBehavior()));
        System.out.println(processString("java", new Behavior() {
            @Override
            public String apply(String word) {
                return word + " anonymous";
            }
        }));
    }

    public static String processString(String word, Behavior behavior) {
        return behavior.apply(word);
    }
}

interface Behavior {
    String apply(String word);
}

class UppercaseBehavior implements Behavior {
    @Override
    public String apply(String word) {
        return word.toUpperCase();
    }
}

class FirstLetterBehavior implements Behavior {
    @Override
    public String apply(String word) {
        return "" + word.charAt(0);
    }
}
