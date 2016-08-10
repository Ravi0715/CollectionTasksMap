package practice.collectiontasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Task8 {

	public static void main(String[] args) throws IOException {

		FileReader fr=null;
		BufferedReader br=null;
		try
		{
			System.out.println("Enter the size:");
			Scanner in = new Scanner(System.in);
			int n=in.nextInt();
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			for(int j=0;j<n;j++)
			{
				
				fr= new FileReader("D:\\collectiondata\\Task 8\\task"+(j+1)+".txt");
				br= new BufferedReader(fr);
				String line,email = null;
				
				int c1=0,count=0;
				while((line=br.readLine())!=null)
				{
					
					c1++;
					if(c1<=1)
						email=line;
					else
					{	
						for(int i=0;i<line.length();i++)
						{
							if(line.charAt(i)=='~'||line.charAt(i)=='`'||line.charAt(i)=='!'||line.charAt(i)=='@'||line.charAt(i)=='#'||line.charAt(i)=='$'||line.charAt(i)=='^'||line.charAt(i)=='&'||line.charAt(i)=='?')
								count++;
						}
					}
				}
				hm.put(email, count);
			}
			String email=null;
			int max=0;
			for(String s:hm.keySet())
			{
				int val=hm.get(s);
				if(val>max)
				{
					max=val;
					email=s;
				}
			}
			System.out.println("Mail contains more special symbols:"+email+"\nNo. of special symbols in the mail are:"+max);
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
