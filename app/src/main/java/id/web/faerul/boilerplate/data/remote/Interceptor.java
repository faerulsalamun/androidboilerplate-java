package id.web.faerul.boilerplate.data.remote;

import android.util.Base64;
import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by faerulsalamun(faerulsalamun@gmail.com) on 11/21/16.
 */

public class Interceptor implements okhttp3.Interceptor {

  @Override public Response intercept(Chain chain) throws IOException {
    Response response = chain.proceed(chain.request());

    Request original = chain.request();

    String method = original.method();
    HttpUrl.Builder httpBuilder = original.url().newBuilder();

    // Request customization: add request headers
    Request.Builder requestBuilder = original.newBuilder()
        .header("Accept", "application/json")
        .header("Content-Type", "application/json")
        .method(method, original.body());

    //String basicAuth = ConstantUtil.Api.BASIC_AUTH_ID + ":" + ConstantUtil.Api.BASIC_AUTH_SECRET;

    //requestBuilder.addHeader("Authorization",
    //    "Basic " + Base64.encodeToString(basicAuth.getBytes(), Base64.NO_WRAP));

    //if (Hawk.get("access_token") != null && !Hawk.get("access_token").equals("")) {
    //  httpBuilder.addQueryParameter("access_token", Hawk.get("access_token"));
    //}

    Request request = requestBuilder.url(httpBuilder.build()).build();

    response.body().close();

    return chain.proceed(request);
  }
}

