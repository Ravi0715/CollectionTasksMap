package practice.collectiontasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task10 {

	public static void main(String[] args) throws IOException {

		
		FileReader fr=null;
		BufferedReader br=null;
		try
		{
			fr= new FileReader("D:\\collectiondata\\task10.txt");
			br=new BufferedReader(fr);
			String line;
			List<String> li = new ArrayList<String>();
			while((line=br.readLine())!=null)
				li.add(line);
			int wordCount=0;
			for(String s:li)
			{
				String arr[] =s.split(" ");
				for(int i=0;i<arr.length;i++)
				{		
					if((wordCount%15)==0)
						System.out.println();
					if(arr[i].equals("a")||arr[i].equals("an")||arr[i].equals("the"))
						System.out.print("."+arr[i]+" ");
					else
						System.out.print(arr[i]+" ");
					wordCount++;
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
