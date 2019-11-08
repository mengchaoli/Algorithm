/*
* A string of '0's and '1's is monotone increasing if it consists of some number of '0's (possibly 0), followed by some number of '1's (also possibly 0.)

We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.

Return the minimum number of flips to make S monotone increasing.



Example 1:

Input: "00110"
Output: 1
Explanation: We flip the last digit to get 00111.
Example 2:

Input: "010110"
Output: 2
Explanation: We flip to get 011111, or alternatively 000111.
Example 3:

Input: "00011000"
Output: 2
Explanation: We flip to get 00000000.
* */

//Explanation:
//This is a typical case of DP.
//
//Let's see the sub-question of DP first.
//
//Suppose that you have a string s, and the solution to the mono increase question is already solved. That is, for string s, counter_flip flips are required for the string, and there were counter_one '1's in the original string s.
//
//Let's see the next step of DP.
//
//Within the string s, a new incoming character, say ch, is appended to the original string. The question is that, how should counter_flip be updated, based on the sub-question? We should discuss it case by case.
//
//When '1' comes, no more flip should be applied, since '1' is appended to the tail of the original string.
//When '0' comes, things become a little bit complicated. There are two options for us: flip the newly appended '0' to '1', after counter_flip flips for the original string; or flip counter_one '1' in the original string to '0'.
// Hence, the result of the next step of DP, in the '0' case, is flipCount = oneCount.

public class _926_FlipStringtoMonotoneIncreasing {
    public int minFlipsMonoIncr(String S) {
        int oneCount = 0;
        int flipCount = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0') {
                if (oneCount == 0) continue;
                else {
                    flipCount++;
                }
            } else {
                oneCount++;
            }

            if (flipCount > oneCount) {
                flipCount = oneCount;
            }
        }
        return flipCount;
    }
}
