package creational;

public class Client {

  public static void main(String[] args) {
    Singleton singleton1 = Singleton.getInstance("Version-1");
    Singleton singleton2 = Singleton.getInstance("Version-2");

    System.out.println(singleton1.equals(singleton2));

    System.out.println(singleton1.value);
    System.out.println(singleton2.value);

  }
  
}
