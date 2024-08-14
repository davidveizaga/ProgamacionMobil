package view.persistence;

import model.Currency;
import model.ExchangeRate;
import model.Number;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InternetChangeRateLoader implements ChangeRateLoader {

    private static final String URL = "http://currencies.apps.grandtrunk.net/getrate/";

    public InternetChangeRateLoader() {
    }

    @Override
    public ExchangeRate load(Currency fromCurrency, Currency toCurrency, Date date) {
        HTTParser parser = HTTParser.getInstance();

        String answer = "";

        try {
            answer = parser.getHTTPAnswer(generateURL(fromCurrency, toCurrency, date));
        } catch (IOException ex) {
        }

        return new ExchangeRate(new Number(Double.valueOf(answer)), fromCurrency, toCurrency, date);
    }

    @Override
    public ExchangeRate load(Currency fromCurrency, Currency toCurrency) {
        return load(fromCurrency, toCurrency, new Date());

    }

    private URL generateURL(Currency fromCurrency, Currency toCurrency, Date date) {
        try {
            return new URL(URL + formatDate(date) + "/" + fromCurrency.getCode() + "/" + toCurrency.getCode());
        } catch (MalformedURLException ex) {
            Logger.getLogger(InternetChangeRateLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String formatDate(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
    }
}
