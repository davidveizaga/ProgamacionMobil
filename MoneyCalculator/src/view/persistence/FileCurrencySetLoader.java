package view.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import model.Currency;
import model.CurrencySet;

public class FileCurrencySetLoader implements CurrencySetLoader {

    private final String file;

    public FileCurrencySetLoader(String file) {
        this.file = file;
    }

    @Override
    public void load() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
            while (true) {
                String line = reader.readLine();
                if (line == null)
                    break;
                String[] currency = line.trim().split(",");
                CurrencySet.getInstance().add(new Currency(currency[2], currency[0], currency[1]));
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

}
