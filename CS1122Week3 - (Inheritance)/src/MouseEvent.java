/**
 * @author SiddheshDM
 */

public abstract class MouseEvent { // because class is abstract, end programmer is going to have to extend it.
    private boolean clicked = false;

    public boolean isClicked () {
        return clicked;
    }
//    public abstract void mouseClicked ();
    public abstract void mouseMoved ();
    protected abstract void mouseClicked ();

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }


}
