package ru.ldwx.crm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Парсер api.tinkoff.ru с целью получения курса доллара.
 * api.tinkoff.ru предоставляет свежие обменные курсы. Периодичность обновления - раз в минуту (вероятно)
 * основной метод возвращает строку типа JSON))))
 * Но это временно
 */

public class TinkoffParser {

    public String getUSD() throws IOException {

        String url = "https://api.tinkoff.ru/v1/currency_rates";

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}
