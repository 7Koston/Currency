package by.st.currency.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;

import java.util.Arrays;

import by.st.currency.Constants;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class RetrofitClient {

    private static APIModel APIModel;

    private static ConnectivityManager connectivityManager;

    private static OkHttpClient okHttpClient;

    public static void initialize(Context context) {
        connectivityManager =
                (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
        if (okHttpClient == null)
            buildHttpClient();

        Retrofit.Builder rBuilder = new Retrofit.Builder().
                baseUrl("http://www.nbrb.by/Services/")
                .addConverterFactory(TikXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

        rBuilder.client(okHttpClient);

        APIModel = rBuilder.build().create(APIModel.class);
    }

    private static void buildHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1))
                .addNetworkInterceptor(
                        chain -> {
                            Request request = chain.request();
                            if (isOnline()) {
                                request = request.newBuilder()
                                        .header("x-apikey",
                                                "2c5a02e9ca0a055021d8b861899d122da637e")
                                        .header("cache-control", "no-cache")
                                        .header("User-Agent",
                                                Constants.USER_AGENT)
                                        .build();
                                return chain.proceed(request);
                            } else {
                                return chain.proceed(request.newBuilder()
                                        .header("x-apikey",
                                                "2c5a02e9ca0a055021d8b861899d122da637e")
                                        .header("Cache-Control",
                                                "public, only-if-cached, max-stale=604800")
                                        .build()
                                );
                            }
                        }
                )
                .addNetworkInterceptor(logging)
                .hostnameVerifier((hostname, session) -> true)
                .build();
    }

    private static boolean isOnline() {
        NetworkInfo netInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return netInfo != null && netInfo.isConnected();
    }

    public static APIModel get() {
        return APIModel;
    }
}
