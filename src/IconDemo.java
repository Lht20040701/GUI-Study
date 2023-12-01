import javax.swing.*;
import java.awt.*;

// 图标, 需要实现类, JFrame继承, 这个类本身就是一个完整的图标, 把Icon和JLabel绑一起了
public class IconDemo extends JFrame implements Icon {
    private int width;
    private int height;

    public IconDemo() {} // 无参构造
    public IconDemo(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void init() {
        IconDemo iconDemo = new IconDemo(15, 15); // new自己, 产生一个根据自己重写的Icon接口中的方法生成的图标
        // 图标放在标签上, 也可以放在按钮上, 可以试试哪些可以放标签上
        JLabel label = new JLabel("icontest", iconDemo, SwingConstants.CENTER); // 把Icon和JLabel捆一起

        Container container = getContentPane();
        container.add(label);

        this.setVisible(true);
        this.setBounds(200, 200, 200, 200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new IconDemo().init(); // 调用这个就是一个完整的图标(Icon + JLabel)的
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) { // 重写的用画笔画图标的方法
        g.fillOval(x, y, width, height);
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }
}
