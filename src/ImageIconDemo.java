import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageIconDemo extends JFrame {
    public ImageIconDemo() {
        // 获取图片地址
        JLabel label = new JLabel("ImageIcon");
        URL url = ImageIconDemo.class.getResource("tx.png");
        System.out.println(ImageIconDemo.class.getResource("tx.png"));

        ImageIcon img = new ImageIcon(url); // 命名不要冲突了
        label.setIcon(img);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        Container container = getContentPane();
        container.add(label);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 200, 200);
    }

    public static void main(String[] args) {
        new ImageIconDemo();
    }
}
