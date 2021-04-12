package ru.ldwx.crm;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.Charset;
import java.time.Duration;
import java.time.LocalDateTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Парсер api.tinkoff.ru с целью получения курса доллара.
 * api.tinkoff.ru предоставляет свежие обменные курсы. Периодичность обновления - раз в минуту (вероятно)
 *
 * метод getUsdToRub() - покупаем доллары за рубли у банка
 * метод getRubToUsd() - покупаем рубли за доллары у банка
 *
 * !!!МЕТОДЫ КИДАЮТ ОШИБКИ!!!
 * !!!НЕОБХОДИМА ИНИЦИАЛИЗАЦИЯ ПЕРЕД ИСПОЛЬЗОВАНИЕМ!!!
 *
 * TODO: Дописать обработчик и возврат false
 *
 * Добавлен таймер на обновление. Теперь метод не будет дергать тинькофф чаще раза в 30 секунд.
 */

public class TinkoffParser {

    private static LocalDateTime usdLastResp; //возраст курса доллара
    private static BigDecimal usdToRub; //курс доллара
    private static BigDecimal rubToUsd; //обратный курс

    public static void init(){
        usdLastResp = LocalDateTime.now();
        try {
            tinkRespUsdToRub();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BigDecimal getUsdToRub() throws Exception{ //возвращаем актуальный курс
        if(!timeChecker()){
            return usdToRub;
        } else {
            usdReNewer();
            return usdToRub;
        }
    }

    public static BigDecimal getRubToUsd() throws Exception{ //возвращаем актуальный курс

        if(!timeChecker()){
            return rubToUsd;
        } else {
            usdReNewer();
            return rubToUsd;
        }
    }

    private static boolean timeChecker (){

        LocalDateTime nowDateTime = LocalDateTime.now(); //получаем текущее время системы nowDateTime
        Duration p = Duration.between(usdLastResp, nowDateTime); //получаем разницу между последним обновлением курса usd и текущей nowDateTime

        return Math.abs(p.getSeconds()) > 30L; //если разница p превышает 30 секунд, то возвращаем false
    }

    private static void usdReNewer () throws Exception{ //обновлятель курса доллара и его возраста
        tinkRespUsdToRub(); //курс
        usdLastResp = LocalDateTime.now(); //обновляем возраст
    }

    //Метод, запрашивающий api.tinkoff.ru, получающий и парсящий ответный JSON на предмет актуального курса доллара

    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private static void tinkRespUsdToRub() throws Exception {

        JSONObject json = readJsonFromUrl("https://api.tinkoff.ru/v1/currency_rates");
        JSONArray arr = json.getJSONObject("payload").getJSONArray("rates");

        for (int i = 0; i < arr.length(); i++){
            JSONObject a = arr.getJSONObject(i);

            if(a.get("category").equals("DebitCardsTransfers") & a.getJSONObject("toCurrency").get("name").equals("RUB") & a.getJSONObject("fromCurrency").get("name").equals("USD")){
                if (a.has("buy")){
                    usdToRub = new BigDecimal(a.get("buy").toString());
                    //System.out.println("buy " + usdToRub);
                }
                if (a.has("sell")){
                    rubToUsd = new BigDecimal(a.get("sell").toString());
                    //System.out.println("sell " + rubToUsd);
                }
            }
        }
    }
}
