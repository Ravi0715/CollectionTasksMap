package practice.collectiontasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task9 {
	
	public static void main(String args[]) throws IOException
	{
		Map<String, Map<String, List<Integer>>> hm = new HashMap<String, Map<String,List<Integer>>>();
		FileReader fr=null;
		BufferedReader br =null;
		try
		{
			fr= new FileReader("D:\\collectiondata\\Task9.txt");
			br=new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null)
			{
				
				String arr[]= line.split(",");
				Map<String, List<Integer>> shm = new HashMap<String, List<Integer>>();
				if(hm.containsKey(arr[0]))
				{
					shm=hm.get(arr[0]);
					List<Integer> li = new ArrayList<Integer>();
					for(int i=2;i<arr.length;i++)
					{
						li.add(Integer.parseInt(arr[i]));
					}
					shm.put(arr[1], li);
					hm.put(arr[0], shm);
				}
				else
				{
					List<Integer> li = new ArrayList<Integer>();
					for(int i=2;i<arr.length;i++)
					{
						li.add(Integer.parseInt(arr[i]));
					}
					shm.put(arr[1], li);
					hm.put(arr[0], shm);
				}
			}
			
			for(Map.Entry<String, Map<String, List<Integer>>> en:hm.entrySet())
			{
				Map<String, List<Integer>> shm=en.getValue();
				for(String key:shm.keySet())
				{
					List<Integer> li =shm.get(key);
					int count=0,c1=0;
					/*for(int x:li)
					{
						if(count==0)
						{
							if(x>11)
								c1++;
								
						}
						if(count==1)
						{
							if(x>13)
								c1++;
						}
						if(count==2)
						{
							if(x>8)
								c1++;
						}
						count++;
						
					}*/
					for(int pos=0;pos<li.size();pos++)
					{
						if(pos==0)
						{
							if(li.get(pos)>11)
								c1++;
						}
						else if(pos==1)
						{
							if(li.get(pos)>13)
								c1++;
						}
						else
						{
							if(li.get(pos)>8)
								c1++;
						}
					}
					if(c1==3)
						System.out.println("College Name:"+en.getKey()+" Student ID:"+key+" Marks:"+li);
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
