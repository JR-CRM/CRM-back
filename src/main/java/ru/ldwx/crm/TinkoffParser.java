package ru.ldwx.crm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Парсер api.tinkoff.ru с целью получения курса доллара.
 * api.tinkoff.ru предоставляет свежие обменные курсы. Периодичность обновления - раз в минуту (вероятно)
 * Основной метод возвращает строку типа JSON))))
 * Но это временно. Будет возвращать Double
 *
 * метод getUSD() пробрасывает IOException
 *
 * Добавлен таймер на обновление. Теперь метод не будет дергать тинькофф чаще раза в 30 секунд.
 */

public class TinkoffParser {

    LocalDateTime usdLastResp; //возраст курса доллара
    String usdToRub; //курс доллара
    String rubToUsd; //обратный курс

    public String getUSD() throws IOException{ //возвращаем актуальный курс

        return timeChecker() ? usdToRub : usdReNewer(); //если курс старше 30 секунд, обновляем и возвращаем новый
    }

    private boolean timeChecker (){

        LocalDateTime nowDateTime = LocalDateTime.now(); //получаем текущее время системы nowDateTime
        Duration p = Duration.between(usdLastResp, nowDateTime); //получаем разницу между последним обновлением курса usd и текущей nowDateTime


        //TODO:
        // - убедиться что Duration возвращает именно то что написано

        return Math.abs(p.getSeconds()) > 30L; //если разница p превышает 30 секунд, то возвращаем false
    }

    private String usdReNewer () throws IOException{ //обновлятель курса доллара и его возраста
            usdToRub = tinkRespUsdToRub(); //курс
            usdLastResp = LocalDateTime.now(); //обновляем возраст

            return usdToRub;
    }

    //Метод, запрашивающий api.tinkoff.ru, получающий и парсящий ответный JSON на предмет актуального курса доллара

    private String tinkRespUsdToRub () throws IOException {

        String url = "https://api.tinkoff.ru/v1/currency_rates";

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //TODO:
        // - парсинг строки

        return response.toString();
    }
}
