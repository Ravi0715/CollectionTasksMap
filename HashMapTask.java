package practice.ravi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class HashMapTask {
	
	public static void printUpto75Words(Map<String, StringBuffer> hm)
	{
		
		for(Map.Entry<String, StringBuffer> en:hm.entrySet())
		{
			int wordcount=0;
			System.out.println(en.getKey());
			StringBuffer sb=en.getValue();
			String arr[] =sb.toString().split(" ");
			for(int i=0;i<arr.length;i++)
			{
				if(wordcount<=75)
				{
					if(arr[i].contains("."))
					{
						String word1[]=arr[i].split(".");
						for(int j=0;j<word1.length;j++)
							wordcount++;
						System.out.print(arr[i]+" ");
					}
					else if(arr[i].contains(","))
					{
						String word1[]=arr[i].split(",");
						for(int j=0;j<word1.length;j++)
							wordcount++;
						System.out.print(arr[i]+" ");
					}
					else
					{
						System.out.print(arr[i]+" ");
						wordcount++;
					}
				}
			}
	
			System.out.println();
		}
		System.out.println();
	}
	
	
	public static void articleCount(Map<String, StringBuffer> hm)
	{
		for(String key:hm.keySet())
		{
			System.out.println("Student ID:"+key);
			StringBuffer sb=hm.get(key);
			int articleCount=0;
			String arr[] =sb.toString().split(" ");
			for(int i=0;i<arr.length;i++)
			{
				if(arr[i].contains("."))
				{
					String word1[]=arr[i].split(".");
					for(int j=0;j<word1.length;j++)
					{
						if(word1[j].equals("an")||word1[j].equals("a")||word1[j].equals("the"))
							articleCount++;
					}
				
				}
				else if(arr[i].contains(","))
				{
					String word1[]=arr[i].split(",");
					for(int j=0;j<word1.length;j++)
					{
						if(word1[j].equals("an")||word1[j].equals("a")||word1[j].equals("the"))
							articleCount++;
					}
				}
				else
				{
					if(arr[i].equals("an")||arr[i].equals("a")||arr[i].equals("the"))
						articleCount++;
				}
			}
			System.out.println("No. of Articles:"+articleCount);
		}
	}
	
	public static void changeCharacter(Map<String, StringBuffer> hm)
	{
		Set<Entry<String, StringBuffer>> se=hm.entrySet();
		Iterator<Entry<String, StringBuffer>> ie=se.iterator();
		while(ie.hasNext())
		{
			Entry<String, StringBuffer> en =ie.next();
			System.out.println("Student Id:"+en.getKey());
			StringBuffer sb =en.getValue();
			char ch[]=sb.toString().toCharArray();
			char c[] = new char[sb.length()+500];
			int p=0;
			for(int i=0;i<ch.length;i++)
			{
				if(ch[i]=='.')
				{
					c[p++]=ch[i];
					ch[i+1]=Character.toUpperCase(ch[i+1]);
				}
				else if(ch[i]==',')
				{
					c[p++]=ch[i];
					c[p++]=' ';
				}
				else
				{
					c[p++]=ch[i];
				}
			}
			for(int i=0;i<c.length;i++)
				System.out.print(c[i]);
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String args[]) throws IOException
	{
		FileReader fr=null;
		BufferedReader br = null;
		try
		{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter size:");
		int n=in.nextInt();
		Map<String,StringBuffer> hm = new HashMap<String, StringBuffer>();
		for(int i=0;i<n;i++)
		{
			fr=new FileReader("D:\\collectiondata\\task6\\student"+(i+1)+".txt");
			br = new BufferedReader(fr);
			String line;
			StringBuffer sb = new StringBuffer();
			int c=0;
			String sId=null;
			while((line=br.readLine())!=null)
			{
				
				c++;
				if(c<=1)
				{
					sId=line;
				}
				else
					sb.append(line+" ");
			}
			hm.put(sId, sb);
		}
		//System.out.println(hm);
		int choice = 0;
		do
		{
			System.out.println("Enter the choice:\n1.Print Data Upto 75 Words");
			System.out.println("2.Article Count\n3.Change of Character(After Full Stop) and keep space(After Comma)");
			System.out.println("4.Exit");
			choice=in.nextInt();
			switch(choice)
			{
				case 1:
						printUpto75Words(hm);
						break;
				case 2:
						articleCount(hm);
						break;
				case 3:
						changeCharacter(hm);
						break;
				case 4:
					System.exit(0);
				default:
					System.out.println("Invalid Option Entered...");
			}
		}
		while(choice<5);
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
