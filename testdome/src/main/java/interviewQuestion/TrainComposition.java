package interviewQuestion;

public class TrainComposition {
    Wagon head;

    static class Wagon {
        int data;
        Wagon previous;
        Wagon next;

        public Wagon(int data) {
            this.data = data;
        }
    }

    public void attachWagonFromLeft(int wagonId) {
        if (head == null) {
            head = new Wagon(wagonId);
        } else {
            Wagon current = head;
            while (current.previous != null)
                current = current.previous;
            current.previous = new Wagon(wagonId);
        }
    }

    public void attachWagonFromRight(int wagonId) {
        if (head == null) {
            head = new Wagon(wagonId);
        } else {
            Wagon current = head;
            while (current.next != null)
                current = current.next;
            current.next = new Wagon(wagonId);
        }
    }

    public int detachWagonFromLeft() {
        Wagon current = head;
        while (current.previous != null)
            current = current.previous;
        int data = current.data;
        current.next.previous = null;
        return data;
    }

    public int detachWagonFromRight() {
        Wagon current = head;
        while (current.next != null)
            current = current.next;
        int data = current.data;
        current.previous.next = null;
        return data;
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7
        System.out.println(train.detachWagonFromLeft()); // 13
    }
}
