package practice.collectiontasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import practice.collectionpojos.Student;
import practice.comparators.AggregateComprator;

public class Task3 {
	
	
	public static void findGirlToppers(HashMap<String, List<Student>> hm)
	{
		Set<Entry<String, List<Student>>> sess=hm.entrySet();
		Iterator<Entry<String, List<Student>>> iess=sess.iterator();
		//TreeMap for Aggregate Comparator
		SortedMap< Student,String> tms = new TreeMap< Student,String>(new AggregateComprator());
		
		while(iess.hasNext())
		{
			Entry<String, List<Student>> es =iess.next();
			List<Student> ls =es.getValue();
			
			for(Student s:ls){
				//Checking the gender
				if(s.getGender().equals("F"))
				{
					tms.put(s,es.getKey());
				}
			}
		}
		System.out.println();
		for(Map.Entry<Student, String> en:tms.entrySet())
		{
			Student st=en.getKey();
			System.out.println(st.getsId()+" "+st.getsName()+" "+st.getAgg()+" "+en.getValue()+"\n");
		}
		System.out.println();
	}

	public static void deptTopTwo(HashMap<String, List<Student>> hm)
	{
		for(Map.Entry<String, List<Student>> en:hm.entrySet())
		{
			List<Student> ls =en.getValue();
			String id=null,name=null,id1=null,name1=null;
			double max=0.0,max1=0.0;
			for(Student s:ls)
			{
				if(s.getAgg()>max)//Calculating Top Two
				{
					max1=max;
					max=s.getAgg();
					id1=id;
					name1=name;
					id=s.getsId();
					name=s.getsName();
				}
			}
			System.out.println("\nTop 1 in "+en.getKey()+" "+id+" "+name+" "+max);
			System.out.println("Top 2 in "+en.getKey()+" "+id1+" "+name1+" "+max1+"\n");
		}
		System.out.println();
	}
	//Finding Pass Percentage
	public static void passPercentage(HashMap<String, List<Student>> hm)
	{
		for(String s:hm.keySet())
		{
			List<Student> ls =hm.get(s);
			int count=0;
			for(Student st:ls)
			{
				if(st.getAgg()>40)//Checking the students how many having aggregate > 40
					count++;
			}
			double passper=((double)count/(double)ls.size())*100;
			System.out.println("Pass percentage of "+s+":"+passper);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		FileReader fr=null;
		BufferedReader br = null;
		try
		{
			fr =new FileReader("D:\\collectiondata\\task3.txt");
			br=new BufferedReader(fr);
			String line;
			HashMap<String, List<Student>> hm = new HashMap<String, List<Student>>();
			while((line=br.readLine())!=null)
			{
				String arr[] = line.split(" ");
				Student st= new Student();
				List<Student> ls = new ArrayList<Student>();
				if(hm.containsKey(arr[4]))
				{
					ls=hm.get(arr[4]);
					st.setsId(arr[0]);
					st.setsName(arr[1]);
					st.setAgg(Double.parseDouble(arr[2]));
					st.setGender(arr[3]);
					ls.add(st);
					hm.put(arr[4],ls);
				}
				else
				{
					st.setsId(arr[0]);
					st.setsName(arr[1]);
					st.setAgg(Double.parseDouble(arr[2]));
					st.setGender(arr[3]);
					ls.add(st);
					hm.put(arr[4],ls);
				}
			}
			//System.out.println(hm);
			Scanner in = new Scanner(System.in);
			int n;
			do
			{
				System.out.println("Enter options to select:\n1.Find out girl topper from each branch");
				System.out.println("2.Find department wise top 2 student both men and women");
				System.out.println("3.Find Pass percentages of all branches");
				System.out.println("4.exit");
				n=in.nextInt();
				switch(n)
				{
					case 1:
							findGirlToppers(hm);
							break;
					case 2:
							deptTopTwo(hm);
							break;
					case 3:
							passPercentage(hm);
							break;
					case 4:
							System.exit(0);
							break;
					default:
						System.out.println("Invalid option entered..");
				}
				
			}
			while(n<5);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				br.close();
				fr.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

}
