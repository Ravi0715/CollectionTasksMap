package practice.collectiontasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Task6 {
	
	
	public static void printUpto75Words(Map<String, List<String>> hm)
	{
		//System.out.println("\n"+hm+"\n");
		for(Map.Entry<String, List<String>> en:hm.entrySet())
		{
			int wordCount = 0;
			System.out.println("Student ID:"+en.getKey());
			List<String> ls =en.getValue();
			for(String s:ls)
			{
				StringTokenizer st = new StringTokenizer(s," ");
				while(st.hasMoreTokens())
				{
					if(wordCount<75)
					{
						String token=st.nextToken();
						if(token.contains(","))
						{
							String arr[] =token.split(",");
							for(int j=0;j<arr.length;j++)
							{
								if(j>=1)
									System.out.print(","+arr[j]+" ");
								else
									System.out.print(arr[j]);
							}
							wordCount+=arr.length;
						}
						else if(token.contains("."))
						{
							String arr[] =token.split(".");
							for(int j=0;j<arr.length;j++)
							{
								if(j>=1)
									System.out.print("."+arr[j]+" ");
								else
									System.out.print(arr[j]);
							}
							wordCount+=arr.length;
						}
						else
						{
							System.out.print(token+" ");
							wordCount++;
						}
					}
				}
				System.out.println();
			}
		}
		System.out.println();
	}
	
	public static void articleCount(Map<String, List<String>> hm)
	{
		for(Map.Entry<String, List<String>> en:hm.entrySet())
		{
			List<String> ls =en.getValue();
			int articleCount=0;
			for(String s:ls){
				StringTokenizer st = new StringTokenizer(s," ");
				while(st.hasMoreTokens())
				{
					
						String token=st.nextToken();
						if(token.contains(","))
						{
							String arr[] =token.split(",");
							for(int j=0;j<arr.length;j++)
							{
								if(arr[j].equals("an")||arr[j].equals("a")||arr[j].equals("the"))
									articleCount++;
							}
						}
						else if(token.contains("."))
						{
							String arr[] =token.split(".");
							for(int j=0;j<arr.length;j++)
							{
								if(arr[j].equals("an")||arr[j].equals("a")||arr[j].equals("the"))
									articleCount++;
							}
							
						}
						else
						{
							String arr[] =token.split(",");
							for(int j=0;j<arr.length;j++)
							{
								if(arr[j].equals("an")||arr[j].equals("a")||arr[j].equals("the"))
									articleCount++;
							}
						}
					}
				
				
			}
			System.out.println("\nStudtent ID:"+en.getKey());
			System.out.println("Total no. of articles are:"+articleCount+"\n");
		}
	}

	public static void changeCharacter(){
		
	}
	public static void main(String[] args) throws IOException {
		
		FileReader fr=null;
		BufferedReader br =null;
		try
		{
			Scanner in = new Scanner(System.in);
			System.out.println("Enter size:");
			int n=in.nextInt();
			Map<String, List<String>> hm = new HashMap<String, List<String>>();
			for(int i=0;i<n;i++)
			{
				fr=new FileReader("D:\\collectiondata\\task6\\student"+(i+1)+".txt");
				br = new BufferedReader(fr);
				String line;
				List<String> ls= new ArrayList<String>();
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
						ls.add(line);
				}
				hm.put(sId, ls);
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
