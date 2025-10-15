package Interview.Algorithms;

public class printing_number_without_loop {

    public static void main(String[] args) {
        recoursion(0);

    }

    public static void recoursion(int num){
        if(num>100){
            return;
        }
        System.out.print(num+" ");
        recoursion(num+2);
    }
}
