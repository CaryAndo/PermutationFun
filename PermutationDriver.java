import java.util.Arrays;

/**
* I'm bored, lets play with Arrays
* */
public class PermutationDriver {
    public static void main(String[] args) {
        int[] left = new int[0];
        int[] right = {1, 2, 3, 4, 5};
        permutation(left, right, 5); // Find all permutations of length 5
        powerset(left, right); // Print the powerset of right
    }

    /**
    * Given an array, find all permutations of a given length
    *
    * @param prefix Fixed portion that won't vary print will be prefix length - length
    * @param rest Everything you want to permute
    * @param length The length of the permutations to print
    * */
    public static void permutation(int[] prefix, int[] rest, int length) {
        int n = rest.length;
        if (prefix.length == length) {
            System.out.println(Arrays.toString(prefix));
            System.out.println("");
        } else {
            for (int i = 0; i < n; i++) {
                permutation(append(prefix, rest[i]), append(subArray(rest, 0, i), subArray(rest, i + 1, rest.length)), length);
            }
        }
    }

    /**
    * Given an array, print a powerset
    *
    * @param prefix
    * @param rest
    * */
    public static void powerset(int[] prefix, int[] rest) {
        System.out.println(Arrays.toString(prefix));

        for (int i = 0; i < rest.length; i++) {
            powerset(append(prefix, rest[i]), append(subArray(rest, 0, i), subArray(rest, i + 1, rest.length)));
        }
    }

    /**
    * Return a slice of the given array starting with i (inclusive) and ending with j (exclusive)
    *
    * @param arr The array to take a slice of
    * @param i The left index to slice from
    * @param j The right index to slice to
    * @return The sub-Array
    */
    public static int[] subArray(int[] arr, int i, int j) {
        if (j - i < 1) {
            return new int[0];
        }
        int[] ret = new int[j - i];
        for (int x = 0; x < ret.length; x++) {
            ret[x] = arr[i + x];
        }
        return ret;
    }

    /**
    * Append one array onto the end of the other
    *
    * @param a Left half to be appended to
    * @param b Right half to append to a
    * @return The concatenated array
    */
    public static int[] append(int[] a, int[] b) {
        int[] ret = new int[a.length + b.length];
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < a.length; j++) {
                ret[j] = a[j];
            }
            for (int j = 0; j < b.length; j++) {
                ret[j + a.length] = b[j];
            }
        }
        return ret;
    }

    /**
    * Append an int to the end of the array
    *
    * @param a Left half to be appended to
    * @param b integer to append to the end of a
    * @return the concatenated array
    */
    public static int[] append(int[] a, int b) {
        int[] ret = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            ret[i] = a[i];
        }
        ret[ret.length - 1] = b;
        return ret;
    }
}
