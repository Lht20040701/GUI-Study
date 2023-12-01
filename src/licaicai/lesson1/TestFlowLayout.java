package licaicai.lesson1;

import java.awt.*;

public class TestFlowLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        // 组件 - 按钮
        Button bu1 = new Button("button1");
        Button bu2 = new Button("button2");
        Button bu3 = new Button("button3");

        // 设置为流式布局
//        frame.setLayout(new FlowLayout()); // flowlayout不写参数默认是center, 同理还有left和right等参数
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));


        frame.setSize(200, 200);

        // 把按钮添加上去
        frame.add(bu1);
        frame.add(bu2);
        frame.add(bu3);

        frame.setVisible(true);
    }
}
