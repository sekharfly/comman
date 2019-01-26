package Counting.LogReading;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sekharv
 *
 */
public class LogReading

{
	public static void main(String[] args) {
		try {
			FileInputStream fstream = new FileInputStream("logFile.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			List<String> errors = new ArrayList<String>();

			while ((strLine = br.readLine()) != null) {

				if (strLine.contains("ERROR")) {
					errors.add(strLine);
				}
			}

			fstream.close();

			String[] expectedArrs = { "liquibase", "SpringApplication: Application startup failed",
					"ServletContextInitializerLifecycleListener: Error starting Tomcat context", "LoggingAspect",
					"dispatcherServlet" };
			List<LogPriority> logPriorities = new ArrayList<>();
			for (String str : expectedArrs) {

				logPriorities.add(new LogPriority(str,
						Long.valueOf(errors.stream().filter(x -> x.contains(str)).count()).intValue()));
			}

			logPriorities.sort((o1, o2) -> o2.getCount() - o1.getCount());
			logPriorities.forEach(System.out::println);

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
