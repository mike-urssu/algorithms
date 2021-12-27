package interviewQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement the uniqueNames method. When passed two arrays of names, it will return an array containing the names that appear in either or both arrays. The returned array should have no duplicates.
 * <p>
 * For example, calling MergeNames.uniqueNames(new String[]{'Ava', 'Emma', 'Olivia'}, new String[]{'Olivia', 'Sophia', 'Emma'}) should return an array containing Ava, Emma, Olivia, and Sophia in any order.
 */
public class MergeNames {
    public static String[] uniqueNames(String[] names1, String[] names2) {
        List<String> names = new ArrayList<>();
        for (String name : names1) {
            if (!names.contains(name))
                names.add(name);
        }
        for (String name : names2) {
            if (!names.contains(name))
                names.add(name);
        }
        return names.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] names1 = new String[]{"Ava", "Emma", "Olivia"};
        String[] names2 = new String[]{"Olivia", "Sophia", "Emma"};
        // should print Ava, Emma, Olivia, Sophia
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2)));
    }
}
