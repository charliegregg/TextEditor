import java.util.ArrayList;
import java.util.Collections;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CursorManager {
    private TextEditor e;
    private ArrayList<Cursor> cursors;
    private boolean multiplying;

    public CursorManager(TextEditor e) {
        this.e = e;
        this.cursors = new ArrayList<>();
        this.cursors.add(new Cursor(e));
    }
    public void left() {
        this.move((Cursor cursor) -> {
            cursor.moveLeft();
        });
    }
    public void right() {
        this.move((Cursor cursor) -> {
            cursor.moveRight();
        });
    }
    public void up() {
        this.move((Cursor cursor) -> {
            cursor.moveUp();
        });
    }
    public void down() {
        this.move((Cursor cursor) -> {
            cursor.moveDown();
        });
    }
    public void move(Consumer<Cursor> mover) {
        ArrayList<Cursor> copied = new ArrayList<>();
        if (this.multiplying) {
            this.operation((Cursor cursor) -> {
                copied.add(cursor.duplicate());
            });
            this.operation(mover);
            this.cursors.addAll(copied);
        } else {
            this.operation(mover);
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
        this.operation((Cursor cursor) -> {
            cursor.startSelecting();
        });
    }
    public void stopSelecting() {
        this.operation((Cursor cursor) -> {
            cursor.stopSelecting();
        });
    }
    public void startMultiplying() {
        this.multiplying = true;
    }
    public void stopMultiplying() {
        this.multiplying = false;
    }
    public void shiftingOperation(BiFunction<Integer, Cursor, Integer> op) {
        sortCursors();
        int shift = 0;
        for (int i = 0; i < this.cursors.size(); i++) {
            this.cursors.get(i).movePos(shift);
            shift += op.apply(i, this.cursors.get(i));
        }
    }
    public void operation(Consumer<Cursor> op) {
        for (Cursor cursor : this.cursors) {
            op.accept(cursor);
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
        System.out.println(this.cursors);
        this.cursors = this.cursors.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(this.cursors);
    }
}
