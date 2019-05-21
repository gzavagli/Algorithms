public class Strings {

    public static boolean isMadeOfUniqueASCIICharacters(String str) {

        boolean ascii[] = new boolean[255];
        for (int i = 0; i < 255; i++) {
            ascii[i] = false;
        }

        int index;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            index = (int) c;
            if (ascii[index]) {
                return false;
            } else {
                ascii[index] = true;
            }
        }
        return true;
    }

    public static boolean isPermutation(String a, String b) {

        //System.out.println("isPermutation of " + a + " and " + b);

        if (a.length() != b.length())
            return false;

        if (a.length() == 0)
            return true;

        int i = b.indexOf(a.charAt(0));
        //System.out.println("i: " + i);
        if (i == -1) {
            return false;
        } else {
            String newB = "";
            if (i == 0)
                newB = b.substring(1);
            else if (i == b.length() - 1)
                newB = b.substring(0, i);
            else
                newB = b.substring(0, i) + b.substring(i + 1);

            //System.out.println("newB: " + newB);

            return isPermutation(a.substring(1), newB);
        }
    }
}
