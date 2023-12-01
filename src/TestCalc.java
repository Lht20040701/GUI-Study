import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigInteger;

public class TestCalc {
    public static void main(String[] args) {
        new Calculator().loadFrame();
    }
}

// 计算器类
class Calculator extends Frame {
    TextField t1, t2, t3;

    public void loadFrame() {
        t1 = new TextField(20); // 字符数
        t2 = new TextField(20);
        t3 = new TextField(30);
        Button button = new Button("=");
        Label label = new Label("+");

        button.addActionListener(new MyCalculatorListener());
        // 设置布局
        setLayout(new FlowLayout());

        add(t1); add(label); add(t2); add(button); add(t3);

        pack();
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // 监听器类
    private class MyCalculatorListener implements ActionListener {
        // 内部类最大的好处, 就是可以畅通无阻的访问外部类的属性和方法 !
        @Override
        public void actionPerformed(ActionEvent e) {
            // 获取加数和被加数
            BigInteger n1 = new BigInteger(t1.getText());
            BigInteger n2 = new BigInteger(t2.getText());

            // 将这个值加运算后放到第三个框 -> 放到第三个框
            t3.setText(String.valueOf(n1.add(n2)));

            // 清除前两个框
            t1.setText("");
            t2.setText("");
        }
    }
}