public class TextEditor {
    private Rope text;
    private CursorManager cm;

    public TextEditor(String text) {
        this.text = new Rope(text);
        this.cm = new CursorManager(this);
    }
    public TextEditor() {
        this("");
    }
    public int getPos(int x, int y) {
        return this.text.findLineStart(y) + x;
    }
    public int getX(int pos) {
        return pos - this.text.findLineStart(this.text.getLineAt(pos));
    }
    public int getY(int pos) {
        return this.text.getLineAt(pos);
    }
    public int getSize() {
        return this.text.length();
    }
    public int getLineCount() {
        return this.text.newLines() + 1;
    }
    public int getLineStart(int lineIndex) {
        return this.text.findLineStart(lineIndex);
    }
    public int getLineWidth(int lineIndex) {
        return this.text.findLineEnd(lineIndex) - this.text.findLineStart(lineIndex);
    }
    public void insert(int index, String value) {
        this.text = this.text.insert(index, value);
    }
    public void remove(int index, int size) {
        this.text = this.text.remove(index, size);
    }
    public TextEditor doLeft() {
        this.cm.left();
        return this;
    }
    public TextEditor doRight() {
        this.cm.right();
        return this;
    }
    public TextEditor doUp() {
        this.cm.up();
        return this;
    }
    public TextEditor doDown() {
        this.cm.down();
        return this;
    }
    public TextEditor doType(String text) {
        this.cm.type(text);
        return this;
    }
    public TextEditor doDelete() {
        this.cm.del();
        return this;
    }
    public TextEditor doStartSelecting() {
        this.cm.startSelecting();
        return this;
    }
    public TextEditor doStopSelecting() {
        this.cm.stopSelecting();
        return this;
    }
    public TextEditor doStartMultiplying() {
        this.cm.startMultiplying();
        return this;
    }
    public TextEditor doStopMultiplying() {
        this.cm.stopMultiplying();
        return this;
    }
    public TextEditor doCopy() {
        this.cm.copy();
        return this;
    }
    public TextEditor doPaste() {
        this.cm.paste();
        return this;
    }
    public TextEditor doCut() {
        this.cm.cut();
        return this;
    }
    public CursorManager getCursorManager() {
        return this.cm;
    }
    public Rope getRope() {
        return this.text;
    }
    public String toString() {
        return this.text.toString();
    }
}
