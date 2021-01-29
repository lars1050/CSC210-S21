
public class Student {

    String last = null;
    String first = null;
    String major = null;
    int credits = 0;

    public Student() {

    }

    public void last(String s) {
        last = s;
    }

    public String last() {
        return last;
    }

    public void first(String s) {
        first = s;
    }

    public String first() {
        return first;
    }

    public void major(String s) {
        major = s;
    }

    public String major() {
        return major;
    }

    public void credits(int c) {
        credits = c;
    }

    public int credits() {
        return credits;
    }

    @Override
    public String toString() {
        return last + ", " + first + " (" + major + ") " + credits + " credits";
    }
}
