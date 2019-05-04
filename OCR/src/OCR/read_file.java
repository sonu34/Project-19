package OCR;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class read_file {

	
	public String read_file(String file_name)  {
		String FILENAME = "C:\\\\Users\\\\ravindra\\\\Tesseract-OCR\\\\" +file_name+ ".txt";
		BufferedReader br = null;
		FileReader fr = null;
		String read_string="";
		try {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;
			

			while ((sCurrentLine = br.readLine()) != null) {
				read_string=read_string+sCurrentLine;
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		return read_string;
	} 

}