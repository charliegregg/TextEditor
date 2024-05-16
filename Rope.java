

public class Rope {
    private int leftChars;
    private int leftNewLines;
    private String value;
    private Rope left;
    private Rope right;

    private static final int KNOT_THRESHOLD = 10;

    public Rope(Rope left, Rope right) {
        this.leftChars = left.length();
        this.leftNewLines = left.newLines();
        this.left = left;
        this.right = right;
    }
    public Rope(String value) {
        if (value.length() <= KNOT_THRESHOLD) {
            this.leftChars = value.length();
            this.leftNewLines = value.split("\n", -1).length - 1;
            this.value = value;
        } else {
            this.leftChars = value.length() / 2;
            this.left = new Rope(value.substring(0, this.leftChars));
            this.right = new Rope(value.substring(this.leftChars));
            this.leftNewLines = this.left.newLines();
        }
    }
    public int length() {
        if (this.right == null) {
            return this.leftChars;
        }
        return this.leftChars + this.right.length();
    }
    public int newLines() {
        if (this.right == null) {
            return this.leftNewLines;
        }
        return this.leftNewLines + this.right.newLines();
    }
    public Rope concat(Rope other) {
        return new Rope(this, other);
    }
    public char get(int index) {
        if (this.value != null) {
            return this.value.charAt(index);
        }
        if (index >= this.leftChars) {
            return this.right.get(index - this.leftChars);
        }
        return this.left.get(index);
    }
    public int findNewLine(int lineIndex) {
        if (this.value != null) {
            int at = -1;
            while (lineIndex >= 0) {
                at = this.value.indexOf("\n", at + 1);
                lineIndex--;
            }
            return at;
        }
        if (lineIndex >= this.leftNewLines) {
            return this.leftChars + this.right.findNewLine(lineIndex - this.leftNewLines);
        }
        return this.left.findNewLine(lineIndex);
    }
    public int findLineStart(int lineIndex) {
        if (lineIndex == 0) {
            return 0;
        }
        return this.findNewLine(lineIndex - 1) + 1;
    }
    public int findLineEnd(int lineIndex) {
        if (lineIndex == newLines()) {
            return length();
        }
        return this.findNewLine(lineIndex);
    }
    public int getLineAt(int index) {
        if (this.value != null) {
            return this.value.substring(0, index).split("\n", -1).length - 1;
        }
        if (index >= this.leftChars) {
            return this.leftNewLines + this.right.getLineAt(index - this.leftChars);
        }
        return this.left.getLineAt(index);
    }
    public Rope copy() {
        if (this.value != null) {
            return new Rope(this.value);
        }
        return new Rope(this.left.copy(), this.right.copy());
    }

    public String sliceString(int start, int size) {
        char[] str = new char[size];
        this.collateChars(str, -start);
        return new String(str);
    }
    public String sliceStringTo(int start, int end) {
        return this.sliceString(start, end - start);
    }

    public void collateChars(char[] str, int offset) {
        if (this.value != null) {
            for (int i = Math.max(0, -offset); i < Math.min(this.leftChars, str.length - offset); i++) {
                str[offset + i] = this.value.charAt(i);
            }
            return;
        }
        if (offset + this.leftChars > 0) {
            this.left.collateChars(str, offset);
        }
        if (str.length - offset > 0) {
            this.right.collateChars(str, offset + this.leftChars);
        }
    }

    public Rope sliceRope(int start, int size) {
        if (this.value != null) {
            return new Rope(this.value.substring(start, start + size));
        }
        boolean includeLeft = start < this.leftChars;
        boolean includeRight = start + size > this.leftChars;
        if (includeLeft && includeRight) {
            return new Rope(
                this.left.sliceRope(start, this.leftChars - start),
                this.right.sliceRope(0, size - this.leftChars + start)
            );
        }
        if (includeRight) {
            return this.right.sliceRope(start - this.leftChars, size);
        }
        // includeLeft
        return this.left.sliceRope(start, size);
    }
    public Rope sliceRopeTo(int start, int end) {
        return this.sliceRope(start, end - start);
    }

    public Rope insert(int index, Rope value) {
        return new Rope(
            new Rope(
                this.sliceRope(0, index), 
                value
            ), 
            this.sliceRope(index, this.length() - index)
        );
    }

    public Rope insert(int index, String value) {
        return this.insert(index, new Rope(value));
    }
    public Rope remove(int index, int size) {
        return new Rope(
            this.sliceRope(0, index), 
            this.sliceRope(index + size, this.length() - index - size)
        );
    }
    public Rope removeTo(int start, int end) {
        return this.remove(start, end - start);
    }
    public Rope reshape() {
        return new Rope(this.toString());
    }
    public int depth() {
        if (this.value != null) {
            return 1;
        }
        if (this.right == null) {
            return this.left.depth() + 1;
        }
        return Math.max(this.left.depth(), this.right.depth()) + 1;
    }
    public int nodes() {
        if (this.value != null) {
            return 1;
        }
        if (this.right == null) {
            return this.left.nodes() + 1;
        }
        return this.left.nodes() + this.right.nodes() + 1;
    }

    public String stringRep() {
        if (this.value != null) {
            return "\"" + this.value.replace("\n", "\\n") + "\"";
        }
        return "(" + this.left.stringRep() + " <- " + this.leftChars + "," + this.leftNewLines + " -> " + this.right.stringRep() + ")";
    }

    public String toString() {
        return this.sliceString(0, this.length());
    }
}