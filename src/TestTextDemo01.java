import javax.swing.*;
import java.awt.*;

public class TestTextDemo01 extends JFrame {
    public TestTextDemo01() {
        Container container = this.getContentPane();

        JTextField tf1 = new JTextField("hello");
        JTextField tf2 = new JTextField("world", 20);

        container.add(tf1, BorderLayout.NORTH);
        container.add(tf2, BorderLayout.SOUTH);

        this.setVisible(true);
        this.setSize(300, 180);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new TestTextDemo01();
    }
}
