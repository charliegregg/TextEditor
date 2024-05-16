import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile {
    private File file;
    private TextEditor e;
    public TextFile() {
        this.e = new TextEditor();
    }
    public TextFile(File file) {
        this.file = file;
        this.e = new TextEditor(loadText(file));
    }
    public void save() {
        if (this.file == null) {
            return;
        }
        try {
            FileWriter writer = new FileWriter(this.file);
            writer.write(this.e.toString());
            writer.close();
        } catch (IOException e) {
            System.err.println("Couldn't open the file '" + file.getPath() + "'. " + e.getMessage());
        }
    }
    public void setFile(File file) {
        this.file = file;
    }
    public TextEditor getEditor() {
        return this.e;
    }
    public String getName() {
        if (this.file == null) {
            return "Untitled";
        }
        return this.file.getName();
    }
    public static String loadText(File file) {
        try {
            FileReader reader = new FileReader(file);
            char[] chars = new char[(int) file.length()]; // UNSAFE FOR LARGE FILE?
            reader.read(chars);
            reader.close();
            return new String(chars);
        } catch (IOException e) {
            System.err.println("Couldn't open the file '" + file.getPath() + "'. " + e.getMessage());
            return "";
        }
    }
}
