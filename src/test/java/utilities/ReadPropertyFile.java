package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader(
				"D:\\EclipseWorkspace1\\com.medsol.ms\\src\\test\\resources\\configfiles\\config.properties");

		Properties p = new Properties();
		p.load(fr);

		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("testurl"));

	}

}
