package TripFinderAlgorithm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TripGenerator {
	public static void main(String[] args) {
		
		File folder = new File("C:\\Users\\Admin\\Desktop\\iteratedLocalSearch-main.zip_expanded\\iteratedLocalSearch-main\\instances\\Files1");
		File[] listOfFiles = folder.listFiles();
		
		for (int i = 0; i < listOfFiles.length; i++) {
			for (int j = 1; j < 2; j++) {
		String instancePath = "C:\\Users\\Admin\\Desktop\\iteratedLocalSearch-main.zip_expanded\\iteratedLocalSearch-main\\instances\\Files1\\"+listOfFiles[i].getName();  //"F:\\instances\\MCTOPP-Cordeau\\MCTOPMTWP-1-pr02-out.txt"; //args[0];
		System.out.println(instancePath);
		ProblemInput problemInput = null;

		try {
			problemInput = ProblemInput.getProblemInputFromFile(instancePath);
		} catch (FileNotFoundException ex) {
			System.out.println("Could not find file. " + ex.getMessage());
			System.exit(1);
		}

		IteratedLocalSearch ILSAlgorithm = new IteratedLocalSearch();
		ILSAlgorithm.solve(problemInput);
		Solution bestSolution = ILSAlgorithm.getBestSolution();
		if(bestSolution.isValid()) {
			System.out.println("BEST SOLUTION: ");
			System.out.println(bestSolution);
			
			try(FileWriter fw = new FileWriter("C:\\Users\\Admin\\Desktop\\iteratedLocalSearch-main.zip_expanded\\Zgjidhjet2\\Zgjidhjet"+i+".txt", true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
					out.println(instancePath);
				    out.println(bestSolution);				    
				    out.println("-------------------------------------------");
				   
				} catch (IOException e) {
				   
				}
			
			
			    Path path = Paths.get(instancePath);	  
		       
		        Path fileName = path.getFileName();
		  			
			try(FileWriter fw = new FileWriter("C:\\Users\\Admin\\Desktop\\iteratedLocalSearch-main.zip_expanded\\Zgjidhjet2\\Solution "+fileName, true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
					//out.println(instancePath);
				    out.println(bestSolution.toStringCustom());				    
				    //out.println("-------------------------------------------");
				   
				} catch (IOException e) {
				   
				}
			
			try(FileWriter fw = new FileWriter("C:\\Users\\Admin\\Desktop\\iteratedLocalSearch-main.zip_expanded\\Zgjidhjet2\\Rezultatet"+i+".txt", true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{					
				    out.println(bestSolution.getScore());							
				    } catch (IOException e) {
				    
				}
			
//			try(FileWriter fw = new FileWriter("C:\\Users\\Lenovo\\Desktop\\OP solution files\\Kategorite"+i+".txt", true);
//				    BufferedWriter bw = new BufferedWriter(fw);
//				    PrintWriter out = new PrintWriter(bw))
//				{	
//				for (int l = 0; l < 10; l++) 
//				    out.println(bestSolution.getVisitCountOfType(l));							
//				    } catch (IOException e) {
//				    
//				}
			
			
		}
	   }
	  }
	}
}
