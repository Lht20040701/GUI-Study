package Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartGame {
    static JFrame frame = new JFrame();
    public static void main(String[] args) {
        frame.setBounds(30, 30, 900, 720);
        frame.setResizable(false); // 窗口不可变
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        JFrame st = new JFrame();
        st.setBounds(30, 30, 570, 200);

        Container contentPane = st.getContentPane();

        MyJButton b1 = new MyJButton("单人模式 ~", 50, 50, 200, 50);
        MyJButton b2 = new MyJButton("多人对战 !", 300, 50, 200, 50);

        contentPane.setLayout(null);
        contentPane.add(b1);
        contentPane.add(b2);
        contentPane.setVisible(true);
        st.setVisible(true);
    }

    static class MyJButton extends JButton {
        private int x, y, w, h;
        public MyJButton(String text, int x, int y, int w, int h) {
            super(text);
            setBounds(x, y, w, h);
            setVisible(true);
            addMouseListener(new MyMouseListener());
        }
    }

    static class MyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            MyJButton mb = (MyJButton) e.getSource();
            if (mb.getText().equals("单人模式 ~")) frame.add(new GamePanel());
            else frame.add(new GamePanel2());
            frame.setVisible(true);
        }
    }
}

