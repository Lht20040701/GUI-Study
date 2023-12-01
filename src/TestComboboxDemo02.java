import javax.swing.*;
import java.awt.*;

public class TestComboboxDemo02 extends JFrame {
    public TestComboboxDemo02() {
        Container container = this.getContentPane();

        // 生成列表的内容
        String[] contents = {"hello", "world", "nihao"};

        JList jlist = new JList(contents);

        container.add(jlist);

        this.setVisible(true);
        this.setSize(300, 180);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new TestComboboxDemo02();
    }
}
