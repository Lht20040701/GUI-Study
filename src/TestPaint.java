import java.awt.*;

public class TestPaint {
    public static void main(String[] args) {
        new MyPaint().lordFrame();
    }
}

class MyPaint extends Frame {
    public void lordFrame() {
        setVisible(true);
        setBounds(300, 300, 800, 800);
    }
    @Override
    public void paint(Graphics g) {
        // 画笔 : 需要有颜色
        g.setColor(Color.red);
        g.drawOval(100, 100, 200, 200); // 空心圆
        g.fillOval(200, 200, 200, 200); // 实心圆

        g.setColor(Color.green);
        g.fillRect(0, 0, 100, 100); // 实心矩形

        // 养成习惯, 画笔用完以后尽量把他还原成最初的颜色
        // 以后会说到让一个东西动起来, 就是不停的改变位置, 然后不停的画
    }
}