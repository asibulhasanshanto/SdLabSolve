//File Name StudentList.java
import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
public static void main(String[] args) 
{
//		Check arguments
		if(args.length == 0 || args.length > 1)
		{
			System.out.println("Program terminated.\nPlease Enter a valid argument");
			return;
		}
		else if(args[0].equals("a")) 
		{
			System.out.println("Loading data ...");		
			try 
			{
				 
				String reader = loadData("students.txt");
				String words[] = reader.split(",");			
				for(String word : words) 
				{ 
					System.out.println(word); 
				}
			} 
			catch (Exception e)
			{

			} 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try 
			{
				
				String reader = loadData("students.txt"); 
				System.out.println(reader);
				String words[] = reader.split(",");	
				Random random = new Random();
				int randomIndex = random.nextInt();
				System.out.println(words[randomIndex]);
			} 
			catch (Exception e)
			{

			} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+"))
		{
			System.out.println("Loading data ...");			
			try 
			{
				BufferedWriter fileStream = new BufferedWriter(
				new FileWriter("students.txt", true));
				String argValue = args[0].substring(1);
	        	Date date = new Date();
	        	String dateForm = "dd/mm/yyyy-hh:mm:ss a";
	        	DateFormat dateFormat = new SimpleDateFormat(dateForm);
	        	String finalDate = dateFormat.format(date);
				fileStream.write(", "+argValue+"\nList last updated on "+finalDate);
				fileStream.close();
			} 
			catch (Exception e)
			{

			}							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try 
			{
				 
				String reader = loadData("students.txt");
				String words[] = reader.split(",");	
				boolean done = false;
				String argValue = args[0].substring(1);
				for(int idx = 0; idx<words.length && !done; idx++) 
				{
					if(words[idx].equals(argValue)) 
					{
						System.out.println("We found it!");
						done=true;
					}
				}
			} 
			catch (Exception e)
			{

			} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try 
			{
				
				String fileContents = loadData("students.txt");
				char Characters[] = fileContents.toCharArray();			
				boolean in_word = false;
				int count=0;
				for(char Cha : Characters) 
				{
					if(Cha ==' ') 
					{
						if(!in_word) 
						{	
							count++; 
							in_word =true;	
						}
					else 
					{ 
						in_word=false;
					}			
				}
			}
			System.out.println(count +" word(s) found " );
			} 
			catch (Exception e)
			{

			} 
			System.out.println("Data Loaded.");				
		}
	}

	public static String loadData(String filename)
	{
		String line;
		try
		{
			BufferedReader fileStream = new BufferedReader(
			new InputStreamReader(
			new FileInputStream(filename))); 

			line = fileStream.readLine();
			return line;

		}
		catch(Exception e)
		{

		}
		return "";
	}
}
