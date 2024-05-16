import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyManager extends KeyAdapter {
    private Window win;
    private TextEditor e;

    public KeyManager(Window win, TextEditor e) {
        super();
        this.win = win;
        this.e = e;
    }
    @Override
    public void keyPressed(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                this.e.doLeft();
                break;
            case KeyEvent.VK_RIGHT:
                this.e.doRight();
                break;
            case KeyEvent.VK_UP:
                this.e.doUp();
                break;
            case KeyEvent.VK_DOWN:
                this.e.doDown();
                break;
            case KeyEvent.VK_BACK_SPACE:
                this.e.doDelete();
                break;
            case KeyEvent.VK_SHIFT:
                this.e.doStartSelecting();
                break;
            case KeyEvent.VK_ENTER:
                this.e.doType("\n");
                break;
            case KeyEvent.VK_ALT:
                this.e.doStartMultiplying();
                break;
            default:
                if (event.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {
                    this.e.doType(new String(new char[] {event.getKeyChar()}));
                }
                break;
        }
        win.updateText();
    }
    @Override
    public void keyReleased(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_SHIFT:
                this.e.doStopSelecting();
                break;
            case KeyEvent.VK_ALT:
                this.e.doStopMultiplying();
                break;
            default:
                break;
        }
    }
}
