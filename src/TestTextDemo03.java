import javax.swing.*;
import java.awt.*;

public class TestTextDemo03 extends JFrame {
    public TestTextDemo03() {
        Container container = this.getContentPane();

        JTextArea textArea = new JTextArea();
        textArea.setText("hello world");

        container.add(textArea);

        this.setVisible(true);
        this.setSize(300, 180);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo03();
    }
}
