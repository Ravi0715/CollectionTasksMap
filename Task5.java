package practice.collectiontasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Task5 {

	public static void main(String[] args) throws IOException {
		
		HashMap<String, HashMap<String, List<Double>>> hm = new HashMap<String, HashMap<String,List<Double>>>();
		FileReader fr=new FileReader("D:\\collectiondata\\task5.txt");
		BufferedReader br = new BufferedReader(fr);
		String line;
		while((line=br.readLine())!=null)
		{
			String arr[] =line.split(",");
			HashMap<String, List<Double>> ahm = new HashMap<String, List<Double>>();
			if(hm.containsKey(arr[0]))
			{
				ahm=hm.get(arr[0]);
				List<Double> ld = new ArrayList<Double>();
				for(int i=2;i<arr.length;i++)
				{
					ld.add(Double.parseDouble(arr[i]));
				}
				ahm.put(arr[1], ld);
				hm.put(arr[0], ahm);
			}
			else
			{
				List<Double> ld = new ArrayList<Double>();
				for(int i=2;i<arr.length;i++)
				{
					ld.add(Double.parseDouble(arr[i]));
				}
				ahm.put(arr[1], ld);
				hm.put(arr[0], ahm);
			}
		}
		
		double max=0.0;
		String bankName=null;
		for(Map.Entry<String, HashMap<String, List<Double>>> en:hm.entrySet())
		{
			HashMap<String, List<Double>> ahm=en.getValue();
			double total=0.0;
			for(String key:ahm.keySet())
			{
				List<Double> ld=ahm.get(key);
				for(double d:ld)
				{
					if(d>0)
						total+=d;
				}
			}
			
			if(total>max)
			{
				max=total;
				bankName=en.getKey();
			}
		}
		System.out.println("Highest Amount Deposited in "+bankName+" and amount is:"+max);
	}

}
