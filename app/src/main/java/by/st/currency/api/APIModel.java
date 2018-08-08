package by.st.currency.api;

import by.st.currency.main.table.data.DailyExRates;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface APIModel {

    @GET("XmlExRates.aspx")
    Single<DailyExRates> getDailyExRates();
}
