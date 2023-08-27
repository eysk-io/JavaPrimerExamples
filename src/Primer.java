import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Primer {
    public static class Lambda {
        public static void main(String[] args) {
            new Lambda().runExamples();
        }

        public void runExamples() {
            List<Integer> myList = new ArrayList<>(List.of(3, 5, 1, 4, 7, 194, 4));
            System.out.println("My unsorted list: " + myList);

            // Default sort
            Collections.sort(myList);
            System.out.println("My sorted list (in asc order): " + myList);

            // Default sort with functional interface
            Collections.sort(myList, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
            System.out.println("My sorted list (in asc order | using an anonymous class): " + myList);

            // Default sort with lambda
            Collections.sort(myList, (Integer o1, Integer o2) -> {
                return o1.compareTo(o2);
            });
            System.out.println("My sorted list (in asc order | using a lambda): " + myList);

            Collections.sort(myList, (o1, o2) -> o1.compareTo(o2));
            System.out.println("My sorted list (in asc order | using a cleaner lambda): " + myList);

            // Default sort with method reference
            Collections.sort(myList, Integer::compareTo);
            System.out.println("My sorted list (in asc order | using a method reference): " + myList);

            // Default sort with method reference
            Collections.sort(myList, this::compareTo);
            System.out.println("My sorted list (in asc order | using a method reference): " + myList);

            // Lambdas as closures
            final int POINTLESS_NUM = 7;
            Collections.sort(myList, (o1, o2) -> o1.compareTo(o2 + POINTLESS_NUM));
            System.out.println("My weird list: " + myList);
        }

        private int compareTo(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }

    public static class Streams {
        public static void main(String[] args) {
            new Streams().runExamples();
        }

        public void runExamples() {
            List<Integer> myList = new ArrayList<>(List.of(3, 5, 1, 4, 7, 194, 4));
            System.out.println("My unsorted list: " + myList);

            List<Integer> newList =
                    myList.stream()
                            .sorted(Integer::compareTo)
                            .collect(Collectors.toList());
            System.out.println("Sorted via stream: " + newList);

            System.out.println("My still unsorted list: " + myList);
        }
    }
}

