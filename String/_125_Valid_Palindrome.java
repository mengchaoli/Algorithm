package String;

public class _125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int head = 0, tail = s.length() - 1;
        char cHead, cTail;

        while (head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);

            if (!Character.isLetterOrDigit(head)) {
                head++;
            } else if (!Character.isLetterOrDigit(tail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }

                head++;
                tail--;
            }
        }
        return true;
    }
}
