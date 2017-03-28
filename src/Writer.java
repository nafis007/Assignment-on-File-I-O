import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Writer 
{
	File targetDirectory;
	public Writer(File Directory)
	{
		targetDirectory = Directory;
	}
	void write(ArrayList<String> allInputStrings, int threadId)
	{
		try
		{
			File outputFile = new File(targetDirectory+"\\output"+threadId+".txt");  
			FileWriter outputFileWriter = new FileWriter(outputFile);
			BufferedWriter outputBufferedWriter = new BufferedWriter(outputFileWriter);
			

			for(String line : allInputStrings)
			{
				outputBufferedWriter.write(line);
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