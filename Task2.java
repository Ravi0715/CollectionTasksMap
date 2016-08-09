package practice.collectiontasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Task2 {

	public static void main(String[] args) throws IOException {
		
		
		//Finding persons who have the  HOBBIES 
		
		FileReader fr=null;
		
		BufferedReader br=null;
		
		try
		{
		
			fr = new FileReader("D:\\aaa\\hobbies.txt");
			br = new BufferedReader(fr);
			String line;
			HashMap<String, Set<String>> hm = new HashMap<String, Set<String>>();
			while((line=br.readLine())!=null)
			{
				String arr[] = line.split(",");
				Set<String> ss = new HashSet<String>();
				for(int i=1;i<arr.length;i++)
				{
					if(hm.containsKey(arr[0]))
					{
						ss=hm.get(arr[0]);
						ss.add(arr[i]);
						hm.put(arr[0], ss);
					}
					else
					{
						ss.add(arr[i]);
						hm.put(arr[0],ss);
					}
				}
			}
			System.out.println("Enter the hobby");
			String hobby=new Scanner(System.in).nextLine();
			Set<Entry<String, Set<String>>> sess=hm.entrySet();
			Iterator<Entry<String, Set<String>>> iess=sess.iterator();
			System.out.println("The Persons who have hobbies are:");
			while(iess.hasNext())
			{
				Entry<String, Set<String>> en=iess.next();
				Set<String> ss= en.getValue();
				for(String s:ss)
				{
					if(s.equals(hobby))
						System.out.print(en.getKey()+",");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			br.close();
			fr.close();
		}
	}

}
