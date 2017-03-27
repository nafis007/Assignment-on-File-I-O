import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main 
{
	
	static ArrayList<Thread> listOfReadWriteThreads = new ArrayList<Thread>();
	
	static ArrayList<ReadWriteRunnable> listOfRunnables = new ArrayList<ReadWriteRunnable>();
	
	static int numberOfInputFiles;
	static int numberOfThreads;
	
	static File targetInputDirectory;
	static File targetOutputDirectory;
	static File masterOutputDirectory;
	
		
	public static void main(String[] args) {
		
		int InputFileNumber = 17;
		int ThreadNumber = 5;
		
		new Initializer(InputFileNumber, ThreadNumber);

		ThreadManager threadManager = new ThreadManager(numberOfInputFiles, numberOfThreads, targetInputDirectory, targetOutputDirectory);
		
		threadManager.threadReadWrite();
		threadManager.masterReadWrite(targetOutputDirectory, masterOutputDirectory);

	}
}
