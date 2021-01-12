package String;

public class _415_AddStrings {
    public String addStrings(String num1, String num2) {
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (idx1 >= 0 || idx2 >= 0 || carry > 0) {
            int p1 = idx1 >= 0 ? num1.charAt(idx1) - '0' : 0;
            int p2 = idx2 >= 0 ? num2.charAt(idx2) - '0' : 0;
            int sum = p1 + p2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;

            idx1--;
            idx2--;
        }

        return sb.reverse().toString();
    }
}
