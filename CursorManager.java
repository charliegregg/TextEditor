import java.util.ArrayList;
import java.util.Collections;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class CursorManager {
    protected TextEditor e;
    protected ArrayList<Cursor> cursors;

    public CursorManager(TextEditor e) {
        this.e = e;
        this.cursors = new ArrayList<>();
        this.cursors.add(new Cursor(e));
    }
    public void left() {
        for (Cursor cursor : this.cursors) {
            cursor.moveLeft();
        }
        removeDuplicates();
    }
    public void right() {
        for (Cursor cursor : this.cursors) {
            cursor.moveRight();
        }
        removeDuplicates();
    }
    public void up() {
        for (Cursor cursor : this.cursors) {
            cursor.moveUp();
        }
        removeDuplicates();
    }
    public void down() {
        for (Cursor cursor : this.cursors) {
            cursor.moveDown();
        }
        removeDuplicates();
    }
    public void type(String text) {
        if (text.split("\n", -1).length == this.cursors.size()) {
            String[] lines = text.split("\n", -1);
            this.shiftingOperation((Integer i, Cursor cursor) -> {
                return cursor.insert(lines[i]);
            });
        } else {
            this.shiftingOperation((Integer i, Cursor cursor) -> {
                return cursor.insert(text);
            });
        }
        removeDuplicates();
    }
    public void del() {
        this.shiftingOperation((Integer i, Cursor cursor) -> {
            return cursor.del();
        });
        removeDuplicates();
    }
    public void startSelecting() {
        for (Cursor cursor : this.cursors) {
            cursor.startSelecting();
        }
    }
    public void stopSelecting() {
        for (Cursor cursor : this.cursors) {
            cursor.stopSelecting();
        }
    }
    public void shiftingOperation(BiFunction<Integer, Cursor, Integer> op) {
        sortCursors();
        int shift = 0;
        for (int i = 0; i < this.cursors.size(); i++) {
            this.cursors.get(i).movePos(shift);
            shift += op.apply(i, this.cursors.get(i));
        }
    }
    public void addCursor(int x, int y) {
        this.cursors.add(new Cursor(e, x, y));
        removeDuplicates();
    }
    public void sortCursors() {
        Collections.sort(this.cursors);
    }
    public void removeDuplicates() {
        this.cursors = this.cursors.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
    }
}
