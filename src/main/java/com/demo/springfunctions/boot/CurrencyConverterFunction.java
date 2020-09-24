package com.demo.springfunctions.boot;

import com.serverless.businesslogic.Currency;
import com.serverless.businesslogic.CurrencyConverter;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author TAYYAB
 */
@Component("currency-converter")
public class CurrencyConverterFunction implements Function<Currency, Currency> {
    @Override
    public Currency apply(Currency inputCurrency) {
        Currency outputCurrency = null;
        try {
            System.out.println("INSIDE TRY " + inputCurrency);
            if (inputCurrency != null) {
                //Business Logic
                CurrencyConverter logic = new CurrencyConverter();
                outputCurrency = logic.convert(inputCurrency);
                System.out.println("ALMOST FINISHED " + outputCurrency);
            } else {
                throw new Exception("INVALID INPUT REQUEST");
            }

        } catch (Exception e) {
            System.out.println("EXCEPTION " + e.getMessage());
        }
        return outputCurrency;
    }
}
