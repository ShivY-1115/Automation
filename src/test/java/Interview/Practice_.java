package Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.print.DocFlavor.CHAR_ARRAY;

import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;

public class Practice_ {
	public static void main(String[] args) {
//		int[] array1 = new int[5];
//		System.out.println(array1.length);
//		for (int i = 0;i<array1.length;i++) {
//			array1[i]=i;
//			System.out.println(array1[i]);	
//		}
//		System.out.println(array1);
//		
//		for (int i=0;i<array1.length;i++) {
//			System.out.print(array1[i] + " ");
//		}
//		
//		System.out.println();
//		int index = Arrays.binarySearch(array1, 2);
//		System.out.println(index);
//		
//		String str = "Hello, World!";
//		char[] chrarray = str.toCharArray();
//		String new_char = "";
//		for (int i=(chrarray.length-1);i>=0;i--) {
//			StringBuilder sb = new StringBuilder();
//			sb.append(chrarray[i]);
//			String str2 = sb.toString();
//			new_char = new_char + str2;			
//			
//		}
//		System.out.println(new_char);
//		
//		LinkedList<Integer> list1 = new LinkedList<Integer>();
//		list1.add(1);
//		list1.add(2);
//		list1.add(3);
//		
//		System.out.println(list1);
//		
//		for(int i = 0;i<list1.size();i++) {
//			System.out.println(list1.get(i));
//		}
//		
//		
//		
//		
//		

	
	/*HashSet<Object> duplicates = new HashSet<>(array1);
	System.out.println(duplicates);
	for(Object item : duplicates) {
		if (!array1.contains(item)) {
			System.out.println(item);
		}
	}*/
	
	
	//Finding Duplicates in the array
	  ArrayList<Object> array1 = new ArrayList<>(Arrays.asList(1,3,4,5,6,7,1,1,2,4,4,5,5));
	  ArrayList<Object> newarray = new ArrayList<>(); 
	  ArrayList<Object> DUplicates = new ArrayList<>();
	  
	  //newarray[0] = array1[0]; 
	  for(Object item : array1) 
	  {
		  if (!newarray.contains(item)) {
			  newarray.add(item);	  
		  }
		  else {
			  DUplicates.add(item);
		  }
	  
	  }
	  Set<Object> Duplicates = new HashSet<Object>(DUplicates);
	  for(Object item : Duplicates) {
		  System.out.println(item);
		  
	  }
	         //another approach of removing duplicates
	  ArrayList<Integer> array111 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,1,1,1,3));
		List<Integer> array2223 = new ArrayList<Integer>();
		
		
		for(Integer item:array111) {
			if(!array2223.contains(item)) {
				array2223.add(item);
			}
			
		}
		System.out.println(array2223);
		for(Integer item:array2223) {
			if (array111.contains(item)) {
				array111.remove(Integer.valueOf(item));
			}
		}
		System.out.println(array111);
		
		HashSet<Object> set1 = new HashSet<Object>(array111);
	  
	  
	  //Reverse a String
	  String Str = "Hello! World";
	  String NewCHar = "";
	  for(int i= (Str.length()-1); i>=0; i--) 
	  {
		  NewCHar += Str.charAt(i);  
		  
	  }
	  System.out.println(NewCHar);
	  
	  
	  //Palindrome check
	  Scanner scanner = new Scanner(System.in);

      System.out.print("Enter the String ");
      String name = scanner.nextLine();
      String newstr = "";
      for (int i = (name.length()-1);i>=0;i--) {
    	  newstr += name.charAt(i);
      }
      if (name.contentEquals(newstr)) {
    	  System.out.println("Palindrome");
      }else {
    	  System.out.println("False");
      }
      
      //Find the missing number in an array
      ArrayList<Integer> array23 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,8,9));
		int j=array23.get(0);
		for(int item:array23) {
			if (item!=j) {
				System.out.println("missing number is "+j);
				break;
			}
			j++;
		}
		             //or
		
		ArrayList<Integer> array247 = new ArrayList<>(Arrays.asList(11,1,2,3,4,9,10));
		ArrayList<Integer> missing = new ArrayList<Integer>();
		Collections.sort(array247);
		int last = array247.size()-1;
		for(int i=array247.get(0);i<array247.get(last);i++) {
			if (!array247.contains(i)) {
				missing.add(i);
			}
		}
		System.out.println(missing);
		
	  //Count of occurences of a charecter in the String
		String Str2 = "Helloooo Wooorld!";

	    System.out.print("Enter the String ");
	    char name2 = scanner.next().charAt(0);
	    int count = 0;
	    for(char item:Str2.toCharArray()) {
	    	if (item == name2) {
	    		count++;
	    	}
	    }
	    System.out.println(count);
	    
	    
	    //Sum of digits
	      System.out.print("Enter the String ");
	      String num = scanner.nextLine();
	      int sum = 0;
	      for(char item:num.toCharArray()) 
	      {
	    	  sum += Character.getNumericValue(item);
	    	  
	      }
	      
	      System.out.println(sum);
	      
	      //finding the largest number in an array1
	      ArrayList<Integer> array13 = new ArrayList<Integer>(Arrays.asList(1,2,33,444,55555,66,0,1));
			 Collections.sort(array13);
			 System.out.println(array13.get(0));
			 System.out.println(array13.get((array13.size())-1));
			
			 
	     //Sort the array without bubble sort
			 ArrayList<Integer> array15 = new ArrayList<Integer>(Arrays.asList(1,2,33,444,55555,66,0,1));
		      ArrayList<Integer> array14 = new ArrayList<Integer>();
		      while(array15.size() != 0){
			      int min = array15.get(0);
		    	  for(Integer item:array15) {
		    		  if (min>item) {
		    			  min = item;
		    		  }
		    	  }
		    	  array14.add(min);
				  array15.remove(Integer.valueOf(min));
		    	  
		      }
		      System.out.println(array14);
		  
		      
		      
		   //find the second maximum in the array without sorting
		      ArrayList<Integer> array16 = new ArrayList<Integer>(Arrays.asList(1,2,33,444,55555,66,0,1));
		      //Collections.sort(array16);
		      int max=array16.get(0);
		      for (Integer item:array16) {
		    	  if (max<item){
		    		  max=item;  
		    	  }
		      }
		      array16.remove(Integer.valueOf(max));
		      int max1=array16.get(0);
		      for (Integer item:array16) {
		    	  if (max1<item){
		    		  max1=item;  
		    	  }
		      }
		      System.out.println(max1);
		      
		      
		      //find the larger number without using if-else condition
		      int a= 10;
		      int b=30;
		      int larger= (a>b) ? a:b;
		      System.out.println(larger);
		      
		      
		      //split the string 
		      String str1 = "Hello! World";
		      String[] new1 = str1.split(" ");
		      for(String item:new1) {
		    	  System.out.println(item);
		      }
		      
		      
		      //write a string and find how many lower and higher characters are there?
		      String str = "GGGGw Hqqq iww";
		      int lower = 0;
		      int Higher = 0;
		      for(char item:str.toCharArray()) {
		    	  if(Character.isLowerCase(item)) {
		    		  lower++;  
		    	  }
		    	  else if(Character.isUpperCase(item)){
		    		  Higher++;
		    	  }
		      }
		      System.out.println("Higher charecter count is: "+Higher+" Lower charecter count is: "+lower);
		      
		      
		      
		      //Remove duplicates from a String
		      String name234 = "Hackerearth";
				String new_char= "";

				LinkedHashSet<Character> set11 = new LinkedHashSet<>();

				for (char item : name234.toCharArray()) 
				{
					set11.add(item); 
				}
				System.out.println(set11); 
				for(char item:set11) {
					new_char += item;
				}
				System.out.println(new_char);
				
				
				//different approach with whole string
				String str_1 = "Helloo Woooorld Vaaaamsi Sreeekar";
				String new_String = "";
				String[] stri = str_1.split(" ");
				for(String item:stri) {
					LinkedHashSet<Object> set_23 = new LinkedHashSet<Object>();
					for(char jtem:item.toCharArray()) {
						set_23.add(jtem);
					}
					for(Object ktem:set_23) {
						new_String +=ktem;
					}
					new_String+= " ";
				}
				System.out.println(new_String);
				
				
				
		     //String count of non-space chracter
				String str12 = "This is a string";
				String Str_new1= str12.replaceAll(" ", "");
				System.out.println(Str_new1.length());
				
				//swap two strings using SubString
				String str11 = "Hello!";
			     String str222 = "World";
			     
			     String string = str11+str222;
			     str11 = string.substring(str1.length());
			     str222 = string.substring(0,(string.length()-str222.length()));
			     System.out.println(str11+","+str222);
			     
			   //swap two strings using temp
			     String str111 = "Hello!";
			     String str2222 = "World";
			     String temp=str2222;
			     str2222= str111;
			     str111=temp;
			     System.out.println(str111+", "+str2222);
			     
			     //swap without using temp variable
			     int aa = 5;
			     int bb = 10;

			     // Before swap
			     System.out.println("Before swap: a = " + aa + ", b = " + bb);

			     // Swap using arithmetic
			     a = a + b;  // a becomes 15
			     b = a - b;  // b becomes 5 (15 - 10)
			     a = a - b;  // a becomes 10 (15 - 5)

			     // After swap
			     System.out.println("After swap: a = " + a + ", b = " + b);
			     
			     
			     
		      //assigning elements to an ArrayList
			     final ArrayList<Object> array121 = new ArrayList<Object>();
					array121.add("Vamsi");
					array121.add("Srikar");
					
					array121.set(0, "Jogi");
					System.out.println(array121);
					
					
		      
		      //prime number
					Scanner scan2 = new Scanner(System.in);
				      System.out.print("Enter the number ");
					int number = scan2.nextInt();
					int count22 = 0;
					for(int i=1;i<=number;i++) {
						if(number%i == 0) {
							count22++;
						}
						
					}
					if(count22==2) {
						System.out.println("GIven num is prime number");
					}else {
						System.out.println("Not a prime number");
					}
			 
		  //prime numbers in a given range
					int num__ = 100;
					for(int i=1;i<=num__;i++) {
						int count_1 = 0;
						for(int j_=1;j_<=i;j_++) {
							if(i%j_==0) {
								count_1++;
							}
						}
						if(count_1==2) {
							System.out.println(i+" is a prime number");
						}
					}
      
      
           //rotate an array using an element
					ArrayList<Object> array = new ArrayList<Object>(Arrays.asList(1,2,3,4,5,6,7,8));
					List<Object> sublist1 = new ArrayList<Object>();
					


					int index = array.indexOf(6);
					sublist1.addAll(array.subList(index, (array.size())));
					sublist1.addAll(array.subList(0, index));
					System.out.println(sublist1);
					
			
	       //Armstrong number
					int nume = 153;
					String numbere = String.valueOf(num);
					int sizee = numbere.length();
					int sume = 0;
					for(char item:numbere.toCharArray()) {
						int indi = Character.getNumericValue(item);
						sum += Math.pow(indi, sizee);
					}
					System.out.println(sume);
					
			
	           //check if two strings are anagrams 
					String strii = "silent";
					String strii2= "listen";
					ArrayList<Character> stringsii = new ArrayList<>();
					ArrayList<Character> strings2ii = new ArrayList<>();
					for(char item:strii.toCharArray()) {
						stringsii.add(item);
					}
					for(char item:strii2.toCharArray()) {
						strings2ii.add(item);
					}
					Collections.sort(stringsii);
					Collections.sort(strings2ii);
					System.out.println(stringsii);
					System.out.println(strings2ii);
					if (stringsii.equals(strings2ii)) {
						System.out.println("Anagram");
					}else {
						System.out.println();
					}
					
					
					//intersection of teo arrays
					ArrayList<Object> tree = new ArrayList<Object>(Arrays.asList(1,2,3,4,5,6));
					ArrayList<Object> Man = new ArrayList<Object>(Arrays.asList(55,66,6,7,5,22,1));
					ArrayList<Object> intersect = new ArrayList<>();
					for(Object item:tree) {
						if(Man.contains(item)) {
							intersect.add(item);
						}
					}
					System.out.println(intersect);
					
					
					//Find the First Non-Repeated Character in a String
					String s = "Hellooo WorldwH!";
					ArrayList<Object> stringss = new ArrayList<Object>();
					for(char item:s.toCharArray()) {
						stringss.add(item);
					}
					for(Object ktem:stringss) {
						int count23 = Collections.frequency(stringss, ktem);
						if (count23==1) {
							System.out.println(ktem);
							break;
						}
					}
					
					
					          //second approach
					String input = "swiss";
			        HashMap<Character, Integer> charCount = new HashMap<>();

			        for (char c : input.toCharArray()) {
			            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
			        }

			        for (char c : input.toCharArray()) {
			            if (charCount.get(c) == 1) {
			                System.out.println("First non-repeated character: " + c);
			                return;
			            }
			        }
			        
			                 //third approach
			        String str__ = "Vamsi Srikarrrrrrrrrrrr JogiVVma";
					for(char item:str__.toCharArray()) {
						int count_0 = 0;
						for(char jtem:str__.toCharArray()) {
							if(Character.toLowerCase(item)==Character.toLowerCase(jtem)) {
								count_0++;
							}
							if(count_0>=2) {
								break;
							}
						}
						if(count_0==1) {
							System.out.println("First non-repeated charecter is: "+item);
							break;
						}
					}
			        
					
			        //Check if a string contains only digits
					
			        String s4="12344";
					boolean value = true;
					for(char item:s4.toCharArray()) {
						if(!Character.isDigit(item)) {
							value = false;
							break;
						}
					}
					if(value) {
						System.out.println("All are digits");
					}else {
						System.out.println("All are not digits");
					}
					
					
					//sort the HashMap
					HashMap<String, Integer> obj1 = new HashMap<>();
					obj1.put("Name", 123);
					obj1.put("LastName", 456);
					obj1.put("D.No", 9);
					
					for(Map.Entry<String, Integer> entry: obj1.entrySet()) {
						System.out.println(entry.getKey());
					}
					System.out.println(obj1.get("Name"));
					
					List<Map.Entry<String, Integer>> for_sorting = new ArrayList<Map.Entry<String, Integer>>(obj1.entrySet());
					
					for_sorting.sort(Map.Entry.comparingByValue());
					
					System.out.println(for_sorting);
					
					
			        //balanced string
					System.out.print("Enter the balanced String: ");
			        String system = scanner.nextLine();
			        
			        int balance = 0; // Keeps track of the balance between L and R
			        int count__ = 0;   // Counts the number of balanced substrings
			        
			        for (char ch : system.toCharArray()) {
			            // Increment or decrement balance based on character
			            if (ch == 'L') {
			                balance++;
			            } else if (ch == 'R') {
			                balance--;
			            }
			            
			            // If balance becomes zero, we have a balanced substring
			            if (balance == 0) {
			                count__++;
			            }
			        }
			        System.out.println("Number of balanced substrings: " + count__);
			        
			        //leap year
			        System.out.println("Enter the year: ");
					int year = scanner.nextInt();
					if((year%4==0 && year%100!=0) || (year%400==0)){
						System.out.println(year+" is a leap year ");
					}else {
						System.out.println(year+" is not a leap year, stfu ");

					}
					
					//fibonacci series
					int start__ = 0;
					int sum__=1;
					for(int i=0;i<=100;i++) {
						int temp__=start__+sum__;
						System.out.println(start__);
						start__=sum__;
						sum__=temp__;
					}
			        
			        
			        //getting random number
			        Random random = new Random();
					System.out.println(random.nextInt(100));
					
					
					//calling of gcd method
					System.out.println(gcd(56, 98));
					
					//factorial using recursion
					int n=5;
					System.out.println(factorial(n));
					
	
	}	
	public static int factorial(int number) {
		if(number == 1 || number == 0) {
			return 1;
		}else {
			return number*factorial(number-1);
		}
	}
	
	
	//gcd of two numbers
	public static int gcd(int num1,int num2) {
		LinkedHashSet<Integer> gcd1 = new LinkedHashSet<Integer>();
		LinkedHashSet<Integer> gcd2 = new LinkedHashSet<Integer>();
		for(int i=1;i<=num1;i++) 
		{
			if(num1%i==0) {
				gcd1.add(i);
		}
			
		}
		for(int j=1;j<=num2;j++) 
		{
			if(num2%j==0) {
				gcd2.add(j);
		}
			
		}
		gcd1.retainAll(gcd2);
		return Collections.max(gcd1);
		
	}

}







/*
 * public class Practice_1 {
 * 
 * public static String AccNo = "12345678"; public static String
 * Account_Balanace = "1234"; private static String PinNo= "7890";
 * 
 * 
 * public static void main(String[] args) {
 * 
 * 
 * } public static void fetchbalance(String Num, String pin) { if
 * (Num.equals(AccNo) && pin.equals(PinNo)) {
 * System.out.println("Account balance is: "+Account_Balanace);
 * 
 * }
 * 
 * }
 * 
 * public static void setpin(String Num, String pin,String New_Pin) {
 * 
 * if (Num == AccNo && pin == PinNo) { PinNo = New_Pin;
 * 
 * }
 * 
 * }
 * 
 * 
 * public static void display_pin(String Num) { if (Num.equals(AccNo)) {
 * System.out.println(PinNo); }
 * 
 * 
 * }
 * 
 * public void test() { fetchbalance("12345678", "7890"); setpin("12345678",
 * "7890","1234");
 * 
 * }
 * 
 * 
 * 
 * 
 * }
 */

