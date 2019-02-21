package regularExpersions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpersionsEmail {
	static Pattern compile;
	public static void main(String[] args) {
		compile = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = compile.matcher("sekharfly@gmail.com");
		System.out.println(matcher.find());
	}

}
