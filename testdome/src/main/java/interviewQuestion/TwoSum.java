package interviewQuestion;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function that, when passed a list and a target sum, returns, efficiently with respect to time used, two distinct zero-based indices of any two of the numbers, whose sum is equal to the target sum. If there are no two numbers, the function should return null.
 * <p>
 * For example, findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10) should return a single dimensional array with two elements and contain any of the following pairs of indices:
 * <p>
 * 0 and 3 (or 3 and 0) as 3 + 7 = 10
 * 1 and 5 (or 5 and 1) as 1 + 9 = 10
 * 2 and 4 (or 4 and 2) as 5 + 5 = 10
 */
public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        if (list == null || list.length < 2)
            return null;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            if (map.containsKey(list[i]))
                return new int[]{i, map.get(list[i])};
            map.put(sum - list[i], i);
        }

//        for (int i = 0; i < list.length; i++) {
//            for (int j = i + 1; j < list.length; j++) {
//                if (list[i] + list[j] == sum) {
//                    return new int[]{i, j};
//                }
//            }
//        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[]{3, 1, 5, 7, 5, 9}, 10);
        if (indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
