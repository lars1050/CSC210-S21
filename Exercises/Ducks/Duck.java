/** Basic information about a car and its gas mileage. */
public class Duck {
  private String name;
  private String personality;
  private int speed = 10;
  private String sound = "quack";

  public Duck() {
        /* this(_______) */
    name = "No Name";
    personality = "flat";
  }
  public Duck(String name, String personality) {
    name = name;
    personality = personality;
    System.out.println("Hi "+name+". You fly "+speed+" mph and say "+sound+".");
  }

  public void describe() {
    System.out.println(name+" has a "+personality+" personality.");
  }

  public void speak() {
    System.out.println(name+" says "+sound+".");
  }

  public void fly() {
    System.out.println(name+" flies "+speed+" mph.");
  }

  public void name(String value) { name = value; }
  public String name() { return name; }

  public void personality(String value) { personality = value; }
  public String personality() { return personality; }
  
  public void sound(String value) { sound = value; }
  public String sound() { return sound; }

  public void speed(int value) { speed = value; }
  public int speed() { return speed; }
}
