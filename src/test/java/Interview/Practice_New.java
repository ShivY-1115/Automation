package Interview;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Practice_New {
	
	public static void main(String[] args) {


		//generate alphanumeric string with size of 6
		Random rando = new Random();
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrtuvxyz0123456789";
		String new_str = "";


		for(int i=0;i<6;i++) {
			new_str += (chars.charAt(rando.nextInt(chars.length())));

		}

		System.out.println(new_str);
		
		//amicable numbers
		for(int i=1;i<500;i++) {
			int count1= 0;
			int count2 = 0;
			for(int j=1;j<i;j++) {
				if(i%j==0) {
					count1+=j;
				}
			}
			for(int k=1;k<count1;k++) {
				if(count1%k==0) {
					count2+=k;
				}
			}
			if(count2==i && count1!=count2) {
				System.out.println(count1+" , "+count2);
			}
		}
		
		//remove elements from linked list
		LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(3,3,6,9,3,null));
		Iterator<Integer> iter = list.iterator();
		Integer key =3;
		while(iter.hasNext()) {
			if(iter.next()==key) {
			    iter.remove();
			}
		}
		System.out.println(list);


	}

}
