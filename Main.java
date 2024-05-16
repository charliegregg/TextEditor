public class Main {
    public static void main(String[] args) {
        Tests.test();
        WindowManager wm = new WindowManager();
        wm.openBlank();
        wm.openFile("C:/Users/charl/OneDrive/Desktop/code/java/TextEditor/test.txt");
    }
}