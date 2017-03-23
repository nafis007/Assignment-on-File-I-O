import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class mainClass 
{
	public static void ReadWrite(Reader inputReader, Writer outputWriter)
	{
		//String assignmentFileDirectory = "D:\\targetInputFolder";
		int numberOfInputFiles = 10;
		
		File randomInputFolder = new File("D:\\randomFolder");
		new RandomInputGenerator(randomInputFolder,numberOfInputFiles);
		
		
		File targetInputDirectory = new File("D:\\randomFolder");
		
		File targetOutputDirectory = new File("D:\\targetOutputFolder");
		
		ArrayList<String> allInputStrings;
		allInputStrings = inputReader.read(targetInputDirectory);
		
		inputReader.readerTestPrint(); //debug print
		
		outputWriter.write(targetOutputDirectory, allInputStrings);
	}

	public static void main(String[] args)
	{
		Reader inputReader = new Reader();
		Writer outputWriter = new Writer();
		
		ReadWrite(inputReader, outputWriter);
	}
}
