package practice.collectiontasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task7 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the String:");
		String s=in.nextLine();
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(ch==' ')
				continue;
			else if(hm.containsKey(ch))
			{
				hm.put(ch, hm.get(ch)+1);
			}
			else
				hm.put(ch, 1);
		}
		//System.out.println(hm);
		char ch = 0;int max=0;
		for(Map.Entry<Character, Integer> en:hm.entrySet())
		{
			if(en.getValue()>max)
			{
				max=en.getValue();
				ch=en.getKey();
			}
		}
		System.out.println("The most appeared character in the string is:"+ch+"\nNo. of times appeared:"+max);
	}

}
