import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Writer 
{
	public void write(File targetDirectory, ArrayList<String> allInputStrings)
	{
		try
		{
			File outputFile = new File(targetDirectory+"\\output.txt");  
			FileWriter outputFileWriter = new FileWriter(outputFile);
			BufferedWriter outputBufferedWriter = new BufferedWriter(outputFileWriter);
			
			for(String inputString : allInputStrings)
			{
				outputBufferedWriter.write(inputString);
				outputBufferedWriter.newLine();
			}
			outputBufferedWriter.close();
		} 
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
}