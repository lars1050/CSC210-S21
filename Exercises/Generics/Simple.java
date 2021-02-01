public class Simple {
    String alpha;
    Integer numeric;
    public Simple() {
        this("a",0);
    }
    public Simple(String a, Integer i) {
        alpha = a;
        numeric = i;
    }
    
    @Override
    public String toString() {
        return "{"+alpha+", "+numeric+"}";
    }
}