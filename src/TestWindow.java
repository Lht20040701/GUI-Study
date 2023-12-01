import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestWindow {
    public static void main(String[] args) {
        new WindowFrame();
    }
}

class WindowFrame extends Frame {
    public WindowFrame() {
        setBackground(Color.green);
        setBounds(100, 100, 200, 200);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            // 下面这两个窗口事件是我们最常用的
            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("窗口已激活");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("正在关闭中");
                System.exit(0);
            }
        });
    }
}