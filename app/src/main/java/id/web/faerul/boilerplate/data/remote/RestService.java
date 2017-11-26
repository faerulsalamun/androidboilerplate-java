package id.web.faerul.boilerplate.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import id.web.faerul.boilerplate.BuildConfig;
import id.web.faerul.boilerplate.data.model.Ribot;
import id.web.faerul.boilerplate.util.RxErrorHandlingCallAdapterFactory;
import io.reactivex.Observable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface RestService {

  String ENDPOINT = "https://api.ribot.io/";

  @GET("ribots") Observable<List<Ribot>> getRibots();

  /******** Helper class that sets up a new services *******/
  class Creator {

    public static RestService newRibotsService() {
      Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
      OkHttpClient.Builder httpClientBuilder = new OkHttpClient().newBuilder();

      HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
      logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
          : HttpLoggingInterceptor.Level.NONE);
      httpClientBuilder.addInterceptor(logging).build();

      httpClientBuilder.addInterceptor(new Interceptor());
      httpClientBuilder.connectTimeout(30, TimeUnit.SECONDS);
      httpClientBuilder.readTimeout(30L, TimeUnit.SECONDS);
      httpClientBuilder.writeTimeout(30L, TimeUnit.SECONDS);

      Retrofit retrofit = new Retrofit.Builder().baseUrl(RestService.ENDPOINT)
          .addConverterFactory(GsonConverterFactory.create(gson))
          .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
          .build();
      return retrofit.create(RestService.class);
    }
  }
}
