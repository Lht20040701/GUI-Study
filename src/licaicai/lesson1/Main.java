package licaicai.lesson1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        // 一定要动脑构思, 构思占了80%, 代码只占20%
        Frame fr = new Frame("练习");
        // 给大窗口设置网格布局
        fr.setLayout(new GridLayout(2, 1));

        // 添加东南西北中布局的两个面板给上面和下面
        Panel pt = new Panel(new BorderLayout());
        Panel pd = new Panel(new BorderLayout());
        fr.add(pt);
        fr.add(pd);

        fr.pack();

        // 给上面的面板添加四个按钮
        Button b1 = new Button("bt1");
        Button b2 = new Button("bt2");
        Button b3 = new Button("bt3");
        Button b4 = new Button("bt4");

        // 先把上面面板中左右两个but放好
        pt.add(b1, BorderLayout.WEST);
        pt.add(b2, BorderLayout.EAST);

        // 然后给中间再放一个网格布局的面板, 然后把剩下的两个but放好
        Panel ptc = new Panel(new GridLayout(2, 1));
        pt.add(ptc, BorderLayout.CENTER);
        ptc.add(b3);
        ptc.add(b4);

        // 下面的面板同理
        Button b5 = new Button("bt5");
        Button b6 = new Button("bt6");

        pd.add(b5, BorderLayout.WEST);
        pd.add(b6, BorderLayout.EAST);

        Panel pdc = new Panel(new GridLayout(2, 2));
        pd.add(pdc, BorderLayout.CENTER);
        for (int i = 7; i < 7 + 4; i ++ ) pdc.add(new Button("bt" + i));

        // 设置大小
        fr.setSize(400, 400);
        // 设置可见
        fr.setVisible(true);

        fr.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
