import javax.swing.*;
import java.awt.*;

public class JButtonDemo03 extends JFrame {
    public JButtonDemo03() {
        Container container = getContentPane();

        // 单选按钮
        JRadioButton rb1 = new JRadioButton("rb1");
        JRadioButton rb2 = new JRadioButton("rb2");
        JRadioButton rb3 = new JRadioButton("rb3");

        // 分组后同一组内单选按钮的只能选一个
        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        group.add(rb3);

        // 把按钮添加到容器中
        container.add(rb1, BorderLayout.NORTH);
        container.add(rb2, BorderLayout.CENTER);
        container.add(rb3, BorderLayout.SOUTH);

        this.setVisible(true);
        this.setSize(300, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

    }
}
