package interviewQuestion;

/**
 * Implement function countNumbers that accepts a sorted array of unique integers and, efficiently with respect to time used, counts the number of array elements that are less than the parameter lessThan.
 * <p>
 * For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4) should return 2 because there are two array elements less than 4.
 */
public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int count = 0;
        for (int number : sortedArray) {
            if (number < lessThan)
                count++;
            else
                break;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[]{1, 3, 5, 7}, 4));
    }
}
