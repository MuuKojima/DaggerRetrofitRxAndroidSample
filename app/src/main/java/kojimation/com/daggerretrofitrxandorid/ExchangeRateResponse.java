package kojimation.com.daggerretrofitrxandorid;

/**
 * Created by muukojima on 2016/11/10.
 */

public class ExchangeRateResponse {
    private String base;
    private String date;
    private CountryCode rates;

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public CountryCode getRates() {
        return rates;
    }
}