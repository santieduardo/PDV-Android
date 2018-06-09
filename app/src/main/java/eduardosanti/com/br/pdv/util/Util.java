package eduardosanti.com.br.pdv.util;

import java.text.NumberFormat;
import java.util.Locale;

public class Util {

    public static String currencyFormat(Double value) {
        Locale locale = new Locale("pt", "BR");
        return NumberFormat.getCurrencyInstance(locale).format(value);
    }
}
