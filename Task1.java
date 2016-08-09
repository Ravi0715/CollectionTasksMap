package practice.collectiontasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



import practice.pojos.EmployeePojo;

public class Task1 {

	public static void main(String[] args) throws IOException {
		
		// TELEPHONE DIRECTORY
		
		Map<String, List<EmployeePojo>> hm= new TreeMap<String, List<EmployeePojo>>();
		Scanner in = new Scanner(System.in);
		FileReader fr = null;
		BufferedReader br=null;
		try
		{
			fr=new FileReader("D:\\collectiondata\\task1.txt");
			br=new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null)
			{
				String arr[]=line.split(",");
				List<EmployeePojo> li = new ArrayList<EmployeePojo>();
				EmployeePojo ep = new EmployeePojo();
				if(hm.containsKey(arr[0]))
				{
					li=hm.get(arr[0]);
					ep.setEmailId(arr[1]);
					ep.setPhoneNumber(arr[2]);
					li.add(ep);
					hm.put(arr[0], li);
				}
				else
				{
					ep.setEmailId(arr[1]);
					ep.setPhoneNumber(arr[2]);
					li.add(ep);
					hm.put(arr[0], li);
				}
			}
			System.out.println("Enter the string you want to check ?");
			String check=in.next();
			String val=null;
			TreeMap<String, String> tm = new TreeMap<String, String>();
			for(Map.Entry<String, List<EmployeePojo>> en:hm.entrySet())
			{
				if(en.getKey().startsWith(check))
				{
					List<EmployeePojo> le =en.getValue();
					for(EmployeePojo eep:le)
					{
						tm.put(eep.getPhoneNumber(), en.getKey());
					}
				}
			}
			for(Map.Entry<String, String> en:tm.entrySet())
			{
				System.out.println(en.getValue()+" "+en.getKey());
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
