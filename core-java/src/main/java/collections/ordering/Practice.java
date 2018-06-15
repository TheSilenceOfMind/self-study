package collections.ordering;

import java.util.*;

public class Practice {

    public static void main(String[] args) {
//        tryEqualsAndHashCodeInAction();
        tryUsingComparators();
    }

    private static void trySortWithList() {
        Company c1 = new Company("Bell", "Stephenson R.");
        Company c2 = new Company("Microsoft", "Gaits B.");
        Company c3 = new Company("Apple", "Jobs S.");
        List<Company> list = new ArrayList<>(Arrays.asList(c1, c2, c3));
        System.out.println(list);

        Collections.sort(list);
        System.out.println("after sort: " + list);
    }

    private static void tryEqualsAndHashCodeInAction() {
        Company c1 = new Company("Bell", "Stephenson R.");
        Company c2 = new Company("Microsoft", "Gaits B.");
//        System.out.println("hashcode of c2: " + c2.hashCode());
        Company c3 = new Company("Microsoft", "Gaits B.");
//        System.out.println("hashcode of c3: " + c3.hashCode());
        Set<Company> set = new HashSet<>(Arrays.asList(c1, c2, c3));
        System.out.println("original set: " + set);
    }

    private static void tryUsingComparators() {
        Company c1 = new Company("Bell", "Stephenson R.");
        Company c2 = new Company("Microsoft", "Gaits B.");
        Company c3 = new Company("Apple", "Jobs S.");
        List<Company> list = new ArrayList<>(Arrays.asList(c1, c2, c3));
        System.out.println("before: " + list);

        // original code:
//        Collections.sort(list, (a, b) -> a.getOwner().compareTo(b.getOwner()));

        // after IntellijRefactoring suggestion:
        Collections.sort(list, Comparator.comparing(Company::getOwner));

        System.out.println("after: " + list);
    }
}
