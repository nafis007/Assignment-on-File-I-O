import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class RandomInputGenerator 
{
	
	public RandomInputGenerator(File Directory, int numberOfFiles){
		String possibleChoices = "abcdefghij0123456789";
		try
		{
			for(int i = 0; i < numberOfFiles; i++)
			{
				int  randomLineLength = new Random().nextInt(10) + 1;
				
				int singleStringRandomLength = new Random().nextInt(30)+1;
				
				File randomInputFiles = new File(Directory+"\\"+i+".txt");  
				FileWriter randomInputFileWriter = new FileWriter(randomInputFiles);
				BufferedWriter randomInputBufferedWriter = new BufferedWriter(randomInputFileWriter);
				
				randomInputBufferedWriter.newLine();
				randomInputBufferedWriter.write("this is input file: "+i);
				randomInputBufferedWriter.newLine();
				randomInputBufferedWriter.newLine();
				
				for(int j = 0; j < randomLineLength; j++)
				{
					String randomStr=generateRandom(possibleChoices,singleStringRandomLength);
					randomInputBufferedWriter.write(randomStr);
					randomInputBufferedWriter.newLine();
				}
				
				randomInputBufferedWriter.close();
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	private static String generateRandom(String choices, int length) {
	    Random rand=new Random();
	    StringBuilder sb=new StringBuilder();
	    for (int i = 0; i < length; i++) {
	       int randIndex=rand.nextInt(choices.length()); 
	       sb.append(choices.charAt(randIndex));            
	    }
	    return sb.toString();
	}
}