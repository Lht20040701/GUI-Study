import javax.swing.*;
import java.awt.*;

public class TestComboboxDemo01 extends JFrame {
    public TestComboboxDemo01() {
        Container container = this.getContentPane();
        JComboBox status = new JComboBox();

        status.addItem(null);
        status.addItem("李菜菜");
        status.addItem("hello world");
        status.addItem("niubi");
        status.addItem("can i help you");

        container.add(status);

        this.setVisible(true);
        this.setSize(300, 60);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestComboboxDemo01();
    }
}
