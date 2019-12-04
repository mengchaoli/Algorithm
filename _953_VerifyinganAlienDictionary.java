//Explanation:
//Build a transform mapping from order,
//Find all alien words with letters in normal order.
//
//For example, if we have order = "xyz..."
//We can map the word "xyz" to "abc" or "123"
//
//Then we check if all words are in sorted order.
//
//Complexity
//Time O(NS)
//Space O(1)

public class _953_VerifyinganAlienDictionary {
    int[] mapping = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            mapping[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (bigger(words[i - 1], words[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean bigger(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        for (int i = 0; i < len1 && i < len2; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return mapping[s1.charAt(i) - 'a'] > mapping[s2.charAt(i) - 'a'];
            }
        }
        return len1 > len2;
    }
}
