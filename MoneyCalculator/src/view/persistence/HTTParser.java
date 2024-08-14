package view.persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HTTParser {

    private static HTTParser instance;

    private HTTParser() {
    }

    public static HTTParser getInstance() {
        if (instance == null)
            instance = new HTTParser();
        return instance;
    }

    public String getHTTPAnswer(URL url) throws IOException {
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String answer = readAnswer(in);
        return answer;
    }

    private String readAnswer(BufferedReader in) throws IOException {
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);

        return response.toString();
    }

}
