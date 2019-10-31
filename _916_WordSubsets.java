/*
* We are given two arrays A and B of words.  Each word is a string of lowercase letters.

Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".

Now say a word a from A is universal if for every b in B, b is a subset of a.

Return a list of all universal words in A.  You can return the words in any order.



Example 1:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
Output: ["apple","google","leetcode"]
Example 3:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
Output: ["facebook","google"]
Example 4:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
Output: ["google","leetcode"]
Example 5:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
Output: ["facebook","leetcode"]


Note:

1 <= A.length, B.length <= 10000
1 <= A[i].length, B[i].length <= 10
A[i] and B[i] consist only of lowercase letters.
All words in A[i] are unique: there isn't i != j with A[i] == A[j].
* */

//Solution:
//For each word b in B,
//we use function counter to count occurrence of each letter.
//We take the maximum occurrences of counts, and use it as a filter of A.

import java.util.LinkedList;
import java.util.List;

public class _916_WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new LinkedList<>();
        int[] count = new int[26], temp;


        for (String b : B) {
            temp = counter(b);
            for (int i = 0; i < 26; i++) {
                count[i] = Math.max(count[i], temp[i]);
            }
        }

        int i;
        for (String a : A) {
            temp = counter(a);
            for (i = 0; i < 26; i++) {
                if (temp[i] < count[i]) {
                    break;
                }
            }
            if (i == 26) {
                res.add(a);
            }
        }

        return res;
    }

    private int[] counter(String b) {
        int[] temp = new int[26];
        for (int j = 0; j < b.length(); j++) {
            temp[b.charAt(j) - 'a']++;
        }
        return temp;
    }
}
