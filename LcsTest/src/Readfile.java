
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Readfile {

	public void method() {
		try {

			FileReader fr = new FileReader("E:\\Eclipse Files\\LcsTest\\src\\input.txt");
			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine();
			// System.out.print(line);
			String s[] = new String[1];
			s = line.split(" ");
			String a = s[0];
			String b = s[1];
			while (line != null) {

				line = br.readLine();

				if (line == null) {
					break;
				}
			}

			Lcs object = new Lcs();
			object.compute(a, b);
			object.printComputeForExtraCredit(a, b);
			br.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Readfile.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Readfile.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
