import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MathUtils {
    public static double average(int a, int b) {
        return (double)(a + b) /2;

    }

    public static void main(String[] args) {
        boolean res = isOneEditAway("mengchao", "mengchaonn");

        System.out.println(res);
    }

    // question1 Write a program to convert binary format to decimal number using numeric operations.
    public static int binaryToDecimal(int n) {
        int num = n;
        int decValue = 0;

        // initial base value to 1;
        int base = 1;

        int temp = num;
        while (temp > 0) {
            int lastDigit = temp % 10;
            temp /= 10;

            decValue = lastDigit * base;

            base = base * 2;
        }

        return decValue;
    }

    // question2 Write a program to find the sum of the first 1000 prime numbers.
    public static int sumOfOneThousandPrimNumbers() {
        int num = 2;
        int counter = 0;
        int sum = 0;

        while (counter < 1000) {
            if (isPrime(num)) {
                sum += num;
                counter++;
            }
            num++;
        }

        return sum;
    }

    // question2 helper: detect if a number is prime number
    public static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    // question3
    /**
     * Write a program that given a string, find the longestt substrings withou repeating characters.
     * Iterate through the given string, find the longest maximum substrings.
     * */

    public static String findLongestSubstringWithoutRepeatingCharacters(String s) {
        int i;
        int n = s.length();

        // starting point of current substring
        int st = 0;

        // maximum length
        int maxLen = 0;

        // lenght of current
        int currLen = 0;


        // starting index of maximum length substring
        int start = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (i = 1; i < n; i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                if (map.get(s.charAt(i)) >= st) {
                    // find length of current substring and update maxlen and start accordingly
                    currLen = i - st;
                    if (maxLen < currLen) {
                        maxLen = currLen;
                        start = st;
                    }

                    st = map.get(s.charAt(i)) + 1;

                }

                map.replace(s.charAt(i), i);
            }
        }

        // compare length of last substring
        if (maxLen < i - st) {
            maxLen = i - st;
            start = st;
        }

        // ans is from s[start] to s[start+maxLen-1]
        return s.substring(start, start + maxLen);
    }

    // question4
    /**
     * A perfect number is a positive integer that is equal to the sum of its proper positive divisors,
     * that is, the sum of its positive divisors excluding the number itself. Equivalently,
     * a perfect number is a number that is half the sum of all of its positive divisors.
     * The first perfect number is 6, because 1, 2 and 3 are its proper positive divisors, and 1 + 2 + 3 = 6.
     * Equivalently, the number 6 is equal to half the sum of all its positive divisors: ( 1 + 2 + 3 + 6 ) / 2 = 6. 
     * Write a program that takes a positive number and returns its proper positive divisors.
     * */

    public static List<Integer> findProperPositiveDivisors(int n) {
        int sum = 0;
        List<Integer> res = new LinkedList<>();

        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                res.add(i);
                sum = sum + i;
            }
        }

        if (sum == n && n != 1) {
            return res;
        }

        return new LinkedList<>();
    }

    // question5
    /**
     * Write a function to return if two words are exactly "one edit" away, where an edit is: 
     * 1. Inserting one character anywhere in the word (including at the beginning and end) 
     * 2. Removing one character 
     * 3. Replacing exactly one character
     * */

    public static boolean isOneEditAway(String s1, String s2) {
        int m = s1.length(), n = s2.length();

        // if length1 and length2 difference is more than 1, return
        if (Math.abs(m - n) > 1) {
            return false;
        }

        // count of edits
        int count = 0;

        int i = 0, j = 0;
        while (i < m && j < n) {
            // if current character does not match:
            if (s1.charAt(i) != s2.charAt(j)) {
                if (count == 1) {
                    return false;
                }

                if (m > n) {
                    i++;
                } else if (m < n) {
                    j++;
                } else {
                    i++;
                    j++;
                }

                count++;
            } else { //if current characters match
                i++;
                j++;
            }
        }

        if (i < m || j < n) {
            count++;
        }

        return count == 1;
    }
}