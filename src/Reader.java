import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Reader 
{
	ArrayList<String> listOfInputStrings;
	
	public ArrayList<String> read(File targetDirectory)
	{
		File[] listOfInputFiles = targetDirectory.listFiles(); 
		
		listOfInputStrings = new ArrayList<String>();
		
		try{
			for (File inputFile : listOfInputFiles) 
			{
				if (inputFile.isFile() && inputFile.getName().endsWith(".txt")) 
				{
					FileReader inputFileReader = new FileReader(inputFile);
					BufferedReader inputBufferedReader = new BufferedReader(inputFileReader);
				
					String inputLine = null;
					while ((inputLine = inputBufferedReader.readLine()) != null)
					{
						System.out.println(inputLine); //debug
						listOfInputStrings.add(inputLine);
					} 
					inputBufferedReader.close();
				} 
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return listOfInputStrings;
	}
	public void readerTestPrint()
	{   
		System.out.println("Inside reader");
		for(String line : listOfInputStrings)
		{
			System.out.println(line);
		}
	}
}