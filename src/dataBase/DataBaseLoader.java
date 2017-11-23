package dataBase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class DataBaseLoader
{
	// Singleton Design Pattern
	private DataBaseLoader() {}
	private static DataBaseLoader db = new DataBaseLoader();
	
	// These are use for 8-bit bytes
	private FileInputStream  in   = null;
	private FileOutputStream out  = null;
	
	// These are for 16bit unicode 
	private FileReader fileReader = null;
	private BufferedReader reader = null;
	private FileWriter fileWriter = null;
	private BufferedWriter writer = null;
	
	// File and Path's 
	private File file             = new File("");
	private String pathToDatabase = "/dataBase/";
	private String databaseFile   = "final.txt";
	
	// Getters & Setters 
	public static DataBaseLoader getDataBaseLoader() { return db; }
	//public void setDataBaseFile(String fileName) { this.databaseFile = fileName; }
	
	public String[] getDataFromDataBase(String dataId)
	{
		String currentDir = file.getAbsolutePath() + pathToDatabase;
		
		String[] lines = new String[50];
		try {
			fileReader = new FileReader(currentDir + databaseFile);
			reader = new BufferedReader(fileReader);
			String line = null; int index = 0;
			while((line = reader.readLine()) != null) {
					  System.out.println(line);
					  lines[index++] = line;
			}   
			reader.close();
			fileReader.close();
		}catch (IOException e) { e.printStackTrace(); }
		
		return lines;
	}
	
	public void connectToFilesOnDisk()
	{
		String currentDir = file.getAbsolutePath();
		//System.out.println(currentDir + pathToDatabase + databaseFile);
		
		String line = null;
		
		String[] temp1 = new String[50];
		String[] temp2 = new String[50];
		int index = 0;
		try {
			fileReader = new FileReader(currentDir + pathToDatabase + "likes.txt");
			reader = new BufferedReader(fileReader);
			
			while((line = reader.readLine()) != null) {
				  System.out.println(line);
				  temp1[index++] = line;
			}   
			System.out.println("DISLIKES.........");
			index = 0;
			fileReader = new FileReader(currentDir + pathToDatabase + "dislikes.txt");
			reader = new BufferedReader(fileReader);
			while((line = reader.readLine()) != null) {
				  System.out.println(line);
				  temp2[index++] = line;
			}   
			
			fileWriter = new FileWriter(currentDir + pathToDatabase + "newFile.txt");
			writer = new BufferedWriter(fileWriter);
			
			for(int i = 0; i < temp1.length; i++) {
				writer.write(temp1[i] + "," + temp2[i]);
				writer.newLine();
			}
			
			
			writer.close();
			reader.close();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//			//fileWriter = new FileWriter(currentDir + pathToDatabase + "final.txt");
//			
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			while((line = bufferedReader.readLine()) != null) {
//			  //System.out.println(line);
//			  temp1[index] = line;
//			  index++;
//			}   
//			
//			index = 0;
//			fileReader = new FileReader(currentDir + pathToDatabase + "output.txt");
//			 bufferedReader = new BufferedReader(fileReader);
//			while((line = bufferedReader.readLine()) != null) {
//			  //System.out.println(line);
//			  temp2[index] = line;
//			  index++;
//			}   
//
//			BufferedWriter br = new BufferedWriter(fileWriter);
//			
//			for(int i = 0; i < temp1.length; i++) {
//				System.out.println(temp1[i] + "," + temp2[i]);
//				br.write(temp1[i] + "," + temp2[i]);
//				br.newLine();			
//				}
//			br.flush();
//			br.close();
			
			// Always close files.
			//bufferedReader.close();   
			 } catch (IOException e) { e.printStackTrace(); }

	}
}

//	     		if((char)c == '/') {
//		fileWriter.write(',');
//		continue;
//	}
//	fileWriter.write(c);

//fileWriter = new FileWriter(currentDir + pathToDatabase + "output.txt");
//System.out.println( "Printing.......");
//int c;
//String temp1 = "";
//String temp2 = "";
//while ((c = fileReader.read()) != -1) {
//	System.out.print( (char) c);
//
// }
//c = 0; 
//fileReader = new FileReader(currentDir + pathToDatabase + "output.txt");
//while ((c = fileReader.read()) != -1) {
//	System.out.print( (char) c);
//
//
// }

//    	 	fileReader.close();
//    	 	//fileWriter.close();





//// Always wrap FileReader in BufferedReader.
//BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//while((line = bufferedReader.readLine()) != null) {
//  System.out.println(line);
//  
//}   
//// Always close files.
//bufferedReader.close();   
//	 	
		/*This could be good 
		 * File classpathRoot = new File(classLoader.getResource("").getPath());
			File[] csvFiles = classpathRoot.listFiles(new FilenameFilter() {
			    @Override public boolean accept(File dir, String name) {
			        return name.endsWith(".csv");
			    }
			}); */
