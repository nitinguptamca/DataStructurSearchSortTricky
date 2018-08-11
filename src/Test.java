import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	
	/*public static void main() {
		System.out.println("ww");
	}*/

	public static void main(String[] args) {
		LocalDate localDate= LocalDate.of(2015, 4, 4);
	System.out.println(localDate.format(DateTimeFormatter.ISO_ORDINAL_DATE));
	}

}
