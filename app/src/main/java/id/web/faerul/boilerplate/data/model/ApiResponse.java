package id.web.faerul.boilerplate.data.model;

/**
 * Created by faerulsalamun(faerulsalamun@gmail.com) on 11/21/16.
 */

public class ApiResponse<T> {
  private Meta meta;
  private T data;

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Meta getMeta() {
    return meta;
  }

  public void setMeta(Meta meta) {
    this.meta = meta;
  }
}
