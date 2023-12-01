import javax.swing.*;
import java.awt.*;

public class JFrameDemo {
    // init(); 初始化
    public void init() {
        // 顶级窗口
        JFrame jframe = new JFrame("这是一个JFrame窗口");
        jframe.setVisible(true);
        jframe.setBounds(100, 100, 200, 200);

        // 设置文字 Jlabel
        JLabel jlabel = new JLabel("这是一个JLabel标签");
        jframe.add(jlabel);

        jlabel.setHorizontalAlignment(SwingConstants.CENTER);

        // 关闭事件
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //
        // 获得一个容器然后改变背景颜色
        Container container = jframe.getContentPane();
        container.setBackground(Color.BLUE);
    }
    public static void main(String[] args) {
        // 建立一个窗口
        new JFrameDemo().init();
    }
}
