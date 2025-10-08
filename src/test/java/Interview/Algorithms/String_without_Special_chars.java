package Interview.Algorithms;

public class String_without_Special_chars {

    public static void main(String[] args) {
        String email = "Ab,c,de!$";
        int left = 0;
        int right=email.length()-1;
        char[] chars = email.toCharArray();
        while(left<right)
        {
            if(!Character.isLetter(chars[left])){
                left++;
            }else if(!Character.isLetter(chars[right])){
                right--;
            }else{
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println(chars);
    }
}
