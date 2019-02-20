

public class Main {
    public static void main(String[] args) {
        SpinnerEvent event = new MyMouseEvent();
        ((MouseEvent)event).setClicked(true);
        event.mouseClicked();
        event.mouseClicked();

        }
    }
