public class Main {

  public static void main(String[] args) {
    Queue queue = new Queue();
    queue.push(1);
    queue.push(2);
    queue.push(3);
    System.out.println(queue);
    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue);

  }
}
