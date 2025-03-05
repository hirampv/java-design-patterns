package creational;

public class Singleton {

  private static Singleton instance = null;
  public String value;
 
  private Singleton(String value) {
    this.value = value;
  }

  static Singleton getInstance(String value) {
    if(instance == null) {
      instance = new Singleton(value);
    }
    return instance;
  }

}