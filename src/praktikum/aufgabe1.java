package praktikum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class aufgabe1 {

	
	static Scanner scanner;
	static OutputStream stream;
	
	public static void main(String[] args) {
		if(args.length!=2)
			throw new IllegalArgumentException("Ungültige Anzahl an Argumenten! 1. Argument Source 2. Argument aim-Datei ");
		File input = new File(args[0]);
		File output = new File(args[1]);
		if(!input.exists()) 
		{
			throw new IllegalArgumentException("Die Source-Datei konnte nicht gefunden werden!");
		}
		if(!output.exists()) {
			try {
				output.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			scanner = new Scanner(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StringBuffer text = new StringBuffer();
		while(scanner.hasNext()) {
			String nWord = scanner.next();
			if(nWord==System.lineSeparator()) {
				text.append(System.lineSeparator());
			}
			else if(nWord == "dr."|| nWord == "Docktor" || nWord=="Doktor")
			{
				text.append("Dr.");
			}
			else if(nWord == "Dipling") {
				text.append("Dipl.-Ing.");
			}
			else {
				text.append(scanner.next());
				
			}
		
		
		}
		scanner.close();
		try {
			stream = new FileOutputStream(output);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			stream.write(text.toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	}
	
	
	
	
	
}
