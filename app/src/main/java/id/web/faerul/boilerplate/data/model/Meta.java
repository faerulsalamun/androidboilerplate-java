package id.web.faerul.boilerplate.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by faerulsalamun(faerulsalamun@gmail.com) on 11/21/16.
 */

public class Meta {
  @SerializedName("status") @Expose private String status;
  @SerializedName("code") @Expose private Integer code;
  @SerializedName("message") @Expose private String message;

  /**
   * @return The status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status The status
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * @return The code
   */
  public Integer getCode() {
    return code;
  }

  /**
   * @param code The code
   */
  public void setCode(Integer code) {
    this.code = code;
  }

  /**
   * @return The message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message The message
   */
  public void setMessage(String message) {
    this.message = message;
  }
}
