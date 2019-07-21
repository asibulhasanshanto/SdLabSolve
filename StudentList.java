//File Name StudentList.java
import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
public static void main(String[] args) 
{
//		Check arguments
		Constants cons = new Constants();
		if(args.length == 0 || args.length > 1)
		{
			System.out.println("Program terminated.\nPlease Enter a valid argument");
			return;
		}
		else if(args[0].equals(cons.showAll)) 
		{
			System.out.println(cons.dLoading);		
			try 
			{
				 
				String reader = loadData(cons.StList);
				String words[] = reader.split(cons.StudentEntryDelimite);			
				for(String word : words) 
				{ 
					System.out.println(word); 
				}
			} 
			catch (Exception e)
			{

			} 
			System.out.println(cons.dLoaded);
		}
		else if(args[0].equals(cons.showRandom)) 
		{
			System.out.println(cons.dLoading);			
			try 
			{
				
				String reader = loadData(cons.StList); 
				System.out.println(reader);
				String words[] = reader.split(cons.StudentEntryDelimite);	
				Random random = new Random();
				int randomIndex = random.nextInt();
				System.out.println(words[randomIndex]);
			} 
			catch (Exception e)
			{

			} 
			System.out.println(cons.dLoaded);			
		}
		else if(args[0].contains(cons.addEntry))
		{
			System.out.println(cons.dLoading);			
			try 
			{
				BufferedWriter fileStream = new BufferedWriter(
				new FileWriter(cons.StList, true));
				String argValue = args[0].substring(1);
	        	Date date = new Date();
	        	DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a");
	        	String finalDate = dateFormat.format(date);
				fileStream.write(", "+argValue+"\nList last updated on "+finalDate);
				fileStream.close();
			} 
			catch (Exception e)
			{

			}							
			System.out.println(cons.dLoaded);	
		}
		else if(args[0].contains(cons.findEntry)) 
		{
			System.out.println(cons.dLoading);			
			try 
			{
				 
				String reader = loadData(cons.StList);
				String words[] = reader.split(cons.StudentEntryDelimite);	
				String argValue = args[0].substring(1);
				int index=-1;
				for(int idx = 0; idx<words.length; idx++) 
				{
					if(words[idx].equals(argValue)) 
					{
						index = idx ;
						break;
					}
				}
				if(index >= 0)
				{
					System.out.println("Entry " + argValue +" found in index " + index);
				}
				else
				{
					System.out.println("Entry " + argValue +" does not exist ");
				}
			} 
			catch (Exception e)
			{

			} 
			System.out.println(cons.dLoaded);				
		}
		else if(args[0].contains(cons.showCount)) 
		{
			System.out.println(cons.dLoading);			
			try 
			{
				
				String fileContents = loadData(cons.StList);
				String words[] = fileContents.split(cons.StudentEntryDelimite);
				System.out.println(words.length +" word(s) found " );
			} 
			catch (Exception e)
			{

			} 
			System.out.println(cons.dLoaded);				
		}
	}

	public static String loadData(String filename)
	{
		try
		{
			BufferedReader fileStream = new BufferedReader(
			new InputStreamReader(
			new FileInputStream(filename))); 

			return fileStream.readLine();
			

		}
		catch(Exception e)
		{

		}
		return "";
	}
}
