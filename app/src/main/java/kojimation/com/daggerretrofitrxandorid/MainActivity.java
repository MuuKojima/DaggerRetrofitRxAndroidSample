package kojimation.com.daggerretrofitrxandorid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    @Inject
    ExchangeRateApi mExchangeRateApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((AppApplication) getApplication()).getAppComponent().inject(this);

        mExchangeRateApi.getExchangeRate("USD", "JPY")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ExchangeRateResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("通信 -> ", "失敗" + e.toString());
                    }

                    @Override
                    public void onNext(ExchangeRateResponse exchangeRateResponse) {
                        Log.d("通信 -> ", "成功");
                        TextView textView = (TextView) findViewById(R.id.txt_jpy);
                        textView.setText("JPY: " + String.valueOf(exchangeRateResponse.getRates().getJPY()));
                    }
                });
    }
}
