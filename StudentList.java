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
				BufferedReader fileStream = new BufferedReader(
				new InputStreamReader(
				new FileInputStream("students.txt"))); 
				String reader = fileStream.readLine(); 
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
				BufferedReader fileStream = new BufferedReader(
				new InputStreamReader(
				new FileInputStream("students.txt"))); 
				String reader = fileStream.readLine(); 
				System.out.println(reader);
				String words[] = reader.split(",");	
				Random rand = new Random();
				int randIndex = rand.nextInt();
				System.out.println(words[randIndex]);
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
	        	String dateF = "dd/mm/yyyy-hh:mm:ss a";
	        	DateFormat dateFormat = new SimpleDateFormat(dateF);
	        	String fullDate= dateFormat.format(dateF);
				fileStream.write(", "+argValue+"\nList last updated on "+fullDate);
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
				BufferedReader fileStream = new BufferedReader(
				new InputStreamReader(
				new FileInputStream("students.txt"))); 
				String reader = fileStream.readLine();
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
				BufferedReader fileStream = new BufferedReader(
				new InputStreamReader(
				new FileInputStream("students.txt"))); 
				String fileContents = fileStream.readLine();
				char Characters[] = fileContents.toCharArray();			
				boolean in_word = false;
				int count=0;
				for(char Character :Characters) 
				{
					if(Characters.equals(' ')) 
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
}