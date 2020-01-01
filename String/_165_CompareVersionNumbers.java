package String;

public class _165_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\."); //. means any character, "\." means "."
        String[] s2 = version2.split("\\.");

        for (int i = 0; i < Math.max(s1.length, s2.length); i++) {
            Integer i1 = i < s1.length ? Integer.parseInt(s1[i]) : 0;
            Integer i2 = i < s2.length ? Integer.parseInt(s2[i]) : 0;

            if (i1 < i2) {
                return -1;
            }
            if (i1 > i2) {
                return 1;
            }
        }
        return 0;
    }
}
