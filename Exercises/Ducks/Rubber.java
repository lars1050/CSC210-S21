/** Rubber ducks float and squeek. */
class Rubber extends Duck {

  String sound = "squeek";
  int speed = 0;
      
    public Rubber(String name, String personality) {
      /*super(_________);*/
    }

    @Override
    public void fly() {
      System.out.println(name+" floats at a speed of "+speed+" mph." );
    }
}