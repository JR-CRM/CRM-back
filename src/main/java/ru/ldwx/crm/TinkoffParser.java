package ru.ldwx.crm;

import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * Парсер api.tinkoff.ru с целью получения курса доллара.
 * api.tinkoff.ru предоставляет свежие обменные курсы. Периодичность обновления - раз в минуту (вероятно)
 *
 * метод getCostUsdBuy() - покупаем доллары за рубли у банка
 * метод getCostUsdSell() - покупаем рубли за доллары у банка
 *
 * !!!МЕТОДЫ КИДАЮТ ОШИБКИ!!!
 *
 * TODO: Дописать обработчик и возврат false
 *
 * Добавлен таймер на обновление. Теперь метод не будет дергать тинькофф чаще раза в 30 секунд.
 */

@Service
public class TinkoffParser {

    private LocalDateTime lastUsdCostUpdateTime; //возраст курса доллара
    private BigDecimal costUsdBuy; //курс доллара
    private BigDecimal costUsdSell; //обратный курс

    public TinkoffParser() {
        init();
    }

    private void init(){
       
        try {
            getTinkoffCurrencyExchangeRates();
            lastUsdCostUpdateTime = LocalDateTime.now();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BigDecimal getCostUsdBuy() throws Exception{ //возвращаем актуальный курс
        if(timeChecker()){
            usdReNewer();
        }
        return costUsdBuy;
    }

    public BigDecimal getCostUsdSell() throws Exception{ //возвращаем актуальный курс

        if(timeChecker()) {
            usdReNewer();
        }
        return costUsdSell;
    }

    private boolean timeChecker (){

        LocalDateTime nowDateTime = LocalDateTime.now(); //получаем текущее время системы nowDateTime
        Duration p = Duration.between(lastUsdCostUpdateTime, nowDateTime); //получаем разницу между последним обновлением курса usd и текущей nowDateTime

        return p.getSeconds() > 30L; //если разница p превышает 30 секунд, то возвращаем false
    }

    private void usdReNewer () throws Exception{ //обновлятель курса доллара и его возраста
        getTinkoffCurrencyExchangeRates(); //курс
        lastUsdCostUpdateTime = LocalDateTime.now(); //обновляем возраст
    }

    //Метод, запрашивающий api.tinkoff.ru, получающий и парсящий ответный JSON на предмет актуального курса доллара
    private void getTinkoffCurrencyExchangeRates() throws Exception {

        String url = "https://api.tinkoff.ru/v1/currency_rates";

        byte[] chars;
        try(InputStream inputStream = new URL(url).openStream()){
            chars = inputStream.readAllBytes();
        }

        JSONObject json = new JSONObject(new String(chars, StandardCharsets.UTF_8));

        JSONArray arr = json.getJSONObject("payload").getJSONArray("rates");

        for (int i = 0; i < arr.length(); i++){
            JSONObject a = arr.getJSONObject(i);

            if(a.get("category").equals("DebitCardsTransfers") & a.getJSONObject("toCurrency").get("name").equals("RUB") & a.getJSONObject("fromCurrency").get("name").equals("USD")){
                if (a.has("buy")){
                    costUsdBuy = new BigDecimal(a.get("buy").toString());
                    //System.out.println("buy " + usdToRub);
                }
                if (a.has("sell")){
                    costUsdSell = new BigDecimal(a.get("sell").toString());
                    //System.out.println("sell " + rubToUsd);
                }
            }
        }
    }
}
