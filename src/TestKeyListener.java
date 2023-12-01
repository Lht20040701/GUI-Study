import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TestKeyListener {
    public static void main(String[] args) {
        new KeyFrame();
    }
}

class KeyFrame extends Frame {
    public KeyFrame() {
        setBounds(1, 2, 300, 400);
        setVisible(true);

        this.addKeyListener(new KeyAdapter() {
            // 最常用的就只有 键盘按下 这一个
            @Override
            public void keyPressed(KeyEvent e) {
                // 获得键盘按下的键是哪一个, 得到当前的码
                int keyCode = e.getKeyCode();
                System.out.println("keyCode -> " + keyCode);
                // 不需要去记这个数值, 直接用静态属性VK_XXX, 比如 :
                if (keyCode == KeyEvent.VK_DOWN) System.out.println("下键");
            }
        });
    }
}
