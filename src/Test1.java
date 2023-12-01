
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

// 测试鼠标监听事件
 class TestMouseListener {
    public static void main(String[] args) {
        new MyFrame("画图");
    }
}

class MyFrame extends Frame {
    ArrayList<Point> points; // 存点用的, 目前不知道有什么用
    // 画画需要画笔, 需要监听鼠标当前的位置, 需要用集合来存这个点
    public MyFrame(String title) {
        super(title);
        setBounds(200, 400, 400, 400);
        // 存鼠标点击的点
        points = new ArrayList<>();

        setVisible(true);
        // 鼠标监听器 : 正对这个窗口
        this.addMouseListener(new MyMouseListener());
    }

    @Override
    public void paint(Graphics g) {
        // 画画 : 监听鼠标的事件
        Iterator iterator = points.iterator();
        while (iterator.hasNext()) {
            Point point = (Point) iterator.next();
            g.setColor(Color.BLUE);
            g.fillOval(point.x, point.y, 10, 10);
        }
    }

    // 添加一个点到界面上
    public void addPaint(Point point) {
        points.add(point);
    }

    // 适配器设计模式
    private class MyMouseListener extends MouseAdapter {
        // 鼠标 的三个状态 按下, 弹起, 按住不放
        @Override
        public void mousePressed(MouseEvent e) {
            // 这里的e是鼠标事件
            MyFrame myFrame = (MyFrame) e.getSource();
            // 这里我们点击的时候, 屏幕上就会出现一个点 ! 画
            // 这个点就是鼠标的点 :
            myFrame.addPaint(new Point(e.getX(), e.getY()));

            // 每次点击鼠标都需要重画一遍
            myFrame.repaint(); // 刷新
//            System.out.println(points); // 把points打出来看看, 发现是一次渲染出points中所有的数据, 因为计算机处理速度非常快, 所以几乎察觉不出来
        }
    }
}