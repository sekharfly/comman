package files;

import java.io.File;

public class FileExmp {

	public static void main(String[] args) {
		File file = new File("/home/sekharv/Desktop");
		String[] list = file.list();
		for (String x : list) {
			System.out.println(x);
		}
	}
	
}
