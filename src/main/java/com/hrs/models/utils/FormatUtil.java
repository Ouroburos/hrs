package com.hrs.models.utils;

import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class FormatUtil {
	
	public static String getFormattedTs(Timestamp ts) {
		return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(ts);
	}
	
	public static String getFormattedCurrency(Double d) {
		return NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(d);
	}

}
