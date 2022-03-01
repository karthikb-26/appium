package TestScript;

import java.util.Arrays;

public class Anagram {
	public static void main(String[] args) {
		
	 
		String str1 ="abcd";
		String str2 ="cdab";
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str1.toCharArray();
		if(str1.length()==str2.length()) {
			Arrays.sort(arr1);
			System.out.println(arr1);
			Arrays.sort(arr2);
			System.out.println(arr2);
			
			if(Arrays.equals(arr1, arr2))
			{
				System.out.println("anagram");
			}
			else {
				System.out.println("not anagram");
		
			}
		}
		else {
			System.out.println("not anagram");
		}
	}
	}


