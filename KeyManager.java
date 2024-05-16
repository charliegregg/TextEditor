import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyManager extends KeyAdapter {
    private Window win;
    private TextEditor e;
    private boolean[] mods = new boolean[Modifiers.values().length];
    enum Modifiers {
        SHIFT,
        ALT,
        CTRL
    }

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
            case KeyEvent.VK_ENTER:
                this.e.doType("\n");
                break;
            case KeyEvent.VK_SHIFT:
                mods[Modifiers.SHIFT.ordinal()] = true;
                this.e.doStartSelecting();
                break;
            case KeyEvent.VK_ALT:
                mods[Modifiers.ALT.ordinal()] = true;
                this.e.doStartMultiplying();
                break;
            case KeyEvent.VK_CONTROL:
                mods[Modifiers.CTRL.ordinal()] = true;
                break;
            case KeyEvent.VK_C:
                if (mods[Modifiers.CTRL.ordinal()]) {
                    this.e.doCopy();
                    break;
                }
            case KeyEvent.VK_V:
                if (mods[Modifiers.CTRL.ordinal()]) {
                    this.e.doPaste();
                    break;
                }
            case KeyEvent.VK_X:
                if (mods[Modifiers.CTRL.ordinal()]) {
                    this.e.doCut();
                    break;
                }
            default:
                if (event.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {
                    this.e.doType(new String(new char[] {event.getKeyChar()}));
                }
                break;
        }
        win.updateText();
        System.out.println(win.getFile().getEditor().getCursorManager().getCursors());
    }
    @Override
    public void keyReleased(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_SHIFT:
                mods[Modifiers.SHIFT.ordinal()] = false;
                this.e.doStopSelecting();
                break;
            case KeyEvent.VK_ALT:
                mods[Modifiers.ALT.ordinal()] = false;
                this.e.doStopMultiplying();
                break;
            case KeyEvent.VK_CONTROL:
                mods[Modifiers.CTRL.ordinal()] = false;
                break;
            default:
                break;
        }
        System.out.println(win.getFile().getEditor().getCursorManager().getCursors());
    }
}
