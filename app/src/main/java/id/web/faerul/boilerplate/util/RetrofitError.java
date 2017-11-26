package id.web.faerul.boilerplate.util;

import id.web.faerul.boilerplate.data.model.ApiResponse;

/**
 * Created by faerulsalamun(faerulsalamun@gmail.com) on 12/4/16.
 */

public class RetrofitError {

  public static String handleError(Throwable e) {
    try {
      RetrofitException error = (RetrofitException) e;
      ApiResponse response = error.getErrorBodyAs(ApiResponse.class);

      if (response != null) {
        return response.getMeta().getMessage();
      } else {
        return "Network Error, Please Try Again";
      }
    } catch (Exception ex) {
      return e.getMessage();
    }
  }
}

