package kojimation.com.daggerretrofitrxandorid;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by muukojima on 2016/11/10.
 */

public interface ExchangeRateApi {
    String URL = "/latest";

    @GET(URL)
    Observable<ExchangeRateResponse> getExchangeRate(@Query("base") String base,
                                                     @Query("symbols") String symbols);
}