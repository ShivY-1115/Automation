package Interview.Strings;

public class permutation_of_All_Strings {

    public static void main(String[] args) {
        permute("abc", "");
    }

    static void permute(String str, String result) {
        if (str.length() == 0) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            permute(remaining, result + currentChar);
        }
    }

}
