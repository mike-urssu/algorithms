package interviewQuestion;

import java.util.ArrayList;
import java.util.List;

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
