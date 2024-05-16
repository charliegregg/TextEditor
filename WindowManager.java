import java.io.File;
import java.util.ArrayList;

public class WindowManager {
    private ArrayList<Window> windows;
    public WindowManager() {
        this.windows = new ArrayList<>();
    }
    public void openFile(String path) {
        this.windows.add(new Window(this, new TextFile(new File(path))));
    }
    public void openBlank() {
        this.windows.add(new Window(this, new TextFile()));
    }
    public void removeWindow(Window win) {
        if (!this.windows.contains(win)) {
            return;
        }
        this.windows.remove(win);
        this.checkClosed();
    }
    public void checkClosed() {
        if (this.windows.size() == 0) {
            System.exit(0);
        }
    }
}