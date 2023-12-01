import javax.swing.*;
import java.awt.*;

public class JButtonDemo02 extends JFrame {
    public JButtonDemo02() {
        Container container = getContentPane();

        // 多选按钮
        JCheckBox jc1 = new JCheckBox("jc1");
        JCheckBox jc2 = new JCheckBox("jc2");

        // 把按钮添加到容器中
        container.add(jc1, BorderLayout.NORTH);
        container.add(jc2, BorderLayout.CENTER);

        this.setVisible(true);
        this.setSize(300, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JButtonDemo02();
    }
}
