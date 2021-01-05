package String;

public class _1138_AlphabetBoardPath {
    public String alphabetBoardPath(String target) {
        char[] charArray = target.toCharArray();
        StringBuilder sb = new StringBuilder();
        int yAxis = 0, xAxis = 0;

        for (int i = 0; i < charArray.length; i++) {
            if (i > 0 && charArray[i] == charArray[i - 1]) {
                sb.append("!");
                continue;
            }

            int yPosition = (charArray[i] - 'a') / 5;
            int xPosition = (charArray[i] - 'a') % 5;

            int yStep = yPosition - yAxis;
            int xStep = xPosition - xAxis;

            yAxis = yPosition;
            xAxis = xPosition;

            if (yStep >= 0) {
                while (xStep > 0) {
                    sb.append("R");
                    xStep--;
                }
                while (xStep < 0) {
                    sb.append("L");
                    xStep++;
                }
                while (yStep > 0) {
                    sb.append("D");
                    yStep--;
                }
            } else {
                while (yStep < 0) {
                    sb.append("U");
                    yStep++;
                }
                while (xStep > 0) {
                    sb.append("R");
                    xStep--;
                }
                while (xStep < 0) {
                    sb.append("L");
                    xStep++;
                }
            }

            sb.append("!");
        }

        return sb.toString();
    }
}
