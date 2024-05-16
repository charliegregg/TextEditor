import java.awt.TextArea;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Window {
    private WindowManager manager;
    private TextFile file;
    private JFrame frame;
    private TextArea textArea;
    public Window(WindowManager manager, TextFile file) {
        this.manager = manager;
        this.file = file;
        this.frame = new JFrame(file.getName());
        this.frame.setSize(1600, 800);
        this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.addKeyListener(new KeyManager(this, file.getEditor()));
        this.frame.addWindowListener(new ExitManager(this));
        this.textArea = new TextArea(file.getEditor().toString());
        this.textArea.setEditable(false);
        this.textArea.setFocusable(false);
        this.frame.add(this.textArea);
    }
    public void updateText() {
        this.textArea.setText(this.file.getEditor().toString());
        this.file.save();
    }
    public void windowClosing(WindowEvent e) {
        this.frame.setVisible(false);
        this.frame.dispose();
        manager.removeWindow(this);
    }
    public TextFile getFile() {
        return this.file;
    }
}
