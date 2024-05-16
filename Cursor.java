public class Cursor implements Comparable<Cursor> {
    protected TextEditor e;
    protected int x;
    protected int y;
    protected int pos;
    protected int selX;
    protected int selY;
    protected int selPos;
    protected boolean selecting;
    protected boolean hasSelection;
    public Cursor(TextEditor e, int x, int y, int selX, int selY) {
        this.e = e;
        this.x = x;
        this.y = y;
        this.pos = this.e.getPos(x, y);
        this.selX = selX;
        this.selY = selY;
        this.selPos = this.e.getPos(selX, selY);
        this.selecting = false;
        this.hasSelection = (x != selX) || (y != selY);
    }
    public Cursor(TextEditor e, int x, int y) {
        this(e, x, y, 0, 0);
    }
    public Cursor(TextEditor e) {
        this(e, 0, 0, 0, 0);
    }
    private boolean isOnSelector() {
        return (this.x == this.selX) && (this.y == this.selY);
    }
    public void moveLeft(int amount) {
        this.setPos(this.pos - amount);
    }
    public void moveRight(int amount) {
        this.setPos(this.pos + amount);
    }
    public void moveUp(int amount) {
        this.setY(this.y - amount);
    }
    public void moveDown(int amount) {
        this.setY(this.y + amount);
    }
    private void updateSelection() {
        if (this.selecting) {
            this.hasSelection = !isOnSelector();
        } else {
            this.hasSelection = false;
        }
    }
    public void moveLeft() {
        this.moveLeft(1);
        updateSelection();
    }
    public void moveRight() {
        this.moveRight(1);
        updateSelection();
    }
    public void moveUp() {
        this.moveUp(1);
        updateSelection();
    }
    public void moveDown() {
        this.moveDown(1);
        updateSelection();
    }
    public int insert(String value) {
        int offset = 0;
        if (this.hasSelection) {
            offset += this.deleteSelection();
        }
        offset += value.length();
        this.e.insert(this.pos, value);
        this.movePos(value.length());
        return offset;
    }
    public int deleteSelection() {
        if (!this.hasSelection) {
            return 0;
        }
        int offset = -this.getSelectionSize();
        this.e.remove(this.getSelectionStart(), this.getSelectionSize());
        this.setPos(this.getSelectionStart());
        this.hasSelection = false;
        return offset;
    }
    public int del() {
        if (this.hasSelection) {
            return this.deleteSelection();
        }
        if (this.pos == 0) {
            return 0;
        }
        this.e.remove(this.pos - 1, 1);
        this.movePos(-1);
        return -1;
    }
    public void startSelecting() {
        this.selecting = true;
        this.selX = this.x;
        this.selY = this.y;
        this.selPos = this.pos;
    }
    public void stopSelecting() {
        this.selecting = false;
    }
    public int getSelectionSize() {
        return Math.abs(this.selPos - this.pos);
    }
    public int getSelectionStart() {
        return Math.min(this.pos, this.selPos);
    }
    public int getSelectionEnd() {
        return Math.max(this.pos, this.selPos);
    }
    public void setPos(int pos) {
        if (pos < 0) {
            pos = 0;
        } else if (pos > this.e.getSize()) {
            pos = this.e.getSize();
        }
        this.pos = pos;
        this.x = this.e.getX(pos);
        this.y = this.e.getY(pos);
    }
    public void movePos(int amount) {
        this.setPos(this.pos + amount);
    }
    public void setY(int y) {
        if (y < 0) {
            this.setPos(0);
            return;
        } else if (y >= this.e.getLineCount()) {
            this.setPos(this.e.getSize());
            return;
        }
        this.y = y;
        this.pos = this.e.getLineStart(y) + Math.min(this.x, this.e.getLineWidth(y));
    }
    public void setX(int x) {
        if (x < 0) {
            x = 0;
        } else if (x >= this.e.getLineWidth(this.y)) {
            x = this.e.getLineWidth(this.y) - 1;
        }
        this.x = x;
        this.pos = this.e.getLineStart(y) + x;
    }
    @Override
    public int compareTo(Cursor other) {
        return Integer.compare(this.pos, other.pos);
    }
    @Override
    public int hashCode() {
        return this.pos;
    }
    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        return this.pos == ((Cursor) other).pos;
    }
}
