package id.web.faerul.boilerplate.data.model;

/**
 * Created by faerulsalamun on 26/11/17.
 */

public class Ribot {

  /**
   * profile : {"id":"c6c4a200-62a1-11e5-9d70-feff819cdc9f","email":"lindsay@ribot.co.uk","avatar":"https://s3-eu-west-1.amazonaws.com/api.ribot.io/lindsay_big.png","dateOfBirth":"1990-01-01T00:00:00.000Z","hexColor":"#ecc973","bio":"With a passion for people at her core, Lindsay rides around on her Vespa, organising, solving and fixing everything in her path, whilst singing about it all in sweet Motown style - she's in a cool band, y'know. Lindsay's driven by a need to help make the lives of others as easy as possible \u2014 no matter the task! L to the I-N-D-S-A-Y! Go Lindsay!! *CLAP*-*CLAP* *CLAP* Go Lindsay!!","isActive":true,"name":{"first":"Lindsay","last":"Scott"}}
   */

  private Profile profile;

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  public static class Profile {
    /**
     * id : c6c4a200-62a1-11e5-9d70-feff819cdc9f
     * email : lindsay@ribot.co.uk
     * avatar : https://s3-eu-west-1.amazonaws.com/api.ribot.io/lindsay_big.png
     * dateOfBirth : 1990-01-01T00:00:00.000Z
     * hexColor : #ecc973
     * bio : With a passion for people at her core, Lindsay rides around on her Vespa, organising, solving and fixing everything in her path, whilst singing about it all in sweet Motown style - she's in a cool band, y'know. Lindsay's driven by a need to help make the lives of others as easy as possible — no matter the task! L to the I-N-D-S-A-Y! Go Lindsay!! *CLAP*-*CLAP* *CLAP* Go Lindsay!!
     * isActive : true
     * name : {"first":"Lindsay","last":"Scott"}
     */

    private String id;
    private String email;
    private String avatar;
    private String dateOfBirth;
    private String hexColor;
    private String bio;
    private boolean isActive;
    private Name name;

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getAvatar() {
      return avatar;
    }

    public void setAvatar(String avatar) {
      this.avatar = avatar;
    }

    public String getDateOfBirth() {
      return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
    }

    public String getHexColor() {
      return hexColor;
    }

    public void setHexColor(String hexColor) {
      this.hexColor = hexColor;
    }

    public String getBio() {
      return bio;
    }

    public void setBio(String bio) {
      this.bio = bio;
    }

    public boolean isIsActive() {
      return isActive;
    }

    public void setIsActive(boolean isActive) {
      this.isActive = isActive;
    }

    public Name getName() {
      return name;
    }

    public void setName(Name name) {
      this.name = name;
    }

    public static class Name {
      /**
       * first : Lindsay
       * last : Scott
       */

      private String first;
      private String last;

      public String getFirst() {
        return first;
      }

      public void setFirst(String first) {
        this.first = first;
      }

      public String getLast() {
        return last;
      }

      public void setLast(String last) {
        this.last = last;
      }
    }
  }
}
