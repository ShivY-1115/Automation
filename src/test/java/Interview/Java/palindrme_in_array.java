package Interview.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class palindrme_in_array {
    public static void main(String[] args)
    {
        Integer[] arr = {1, 1, 2, 2, 3, 3};
        System.out.println(ispalindrome_unordered(arr));
    }

    public static boolean ispalindrome(String[] arr)
    {
        int mid = arr.length/2;
        System.out.println(mid);
        int j = arr.length-1;
        int count = 0;
        for(int i=0;i<mid;i++)
        {
            if(arr[i]==arr[j])
            {
                count++;
            }
            j--;
        }
        if(count==mid)
        {
            return true;
        }
        return false;
    }

    public  static  boolean ispalindrome_unordered(Integer[] arr){

        if(arr.length%2==0){
            ArrayList<Object> list1 = new ArrayList<>(Arrays.asList(arr));
            for(Object item:list1){
                int freq = Collections.frequency(list1,item);
                if(freq==1){
                    return false;
                }
            }
            return true;
        }else{
            ArrayList<Object> list1 = new ArrayList<>(Arrays.asList(arr));
            int count =0;
            int mid = arr.length/2;
            for(Object item:list1){
                int freq = Collections.frequency(list1,item);
                if(freq==1){
                    count++;
                }
            }
            if(count<=1){
                return true;
            }else{
                return false;
            }

        }

    }
}
