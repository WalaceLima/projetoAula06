package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeHelper {

	public static String formatDate(Date data) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(data);
	}
}
