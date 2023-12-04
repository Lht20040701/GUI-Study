package Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

// 游戏的面板
public class GamePanel2 extends JPanel implements KeyListener, ActionListener {
    int len; // 蛇的长度
    int len2;

    String winner;
    int[] snakeX =  new int[600]; // 蛇的X坐标 25 * 25
    int[] snakeX2 = new int[600];
    int[] snakeY = new int[500]; // 蛇的Y坐标 25 * 25
    int[] snakeY2 = new int[600];
    String fx; // 小蛇头的方向
    String fx2;
    int foodx, foody; // 食物的坐标
    Random r = new Random(); // 食物随机化

    // 游戏当前的状态 : 开始, 停止, 失败
    boolean isStart = false;
    boolean isFail = false;


    // 定时器 以ms为单位, 1000ms = 1s
    Timer timer = new Timer(50, this);

    // 构造器
    public GamePanel2() {
        init();
        // 获得焦点和键盘事件
        this.setFocusable(true); // 获得焦点事件
        this.addKeyListener(this);
    }

    // 初始化方法
    public void init() {
        len = 3;
        len2 = 3; // 蛇蛇2的长度

        snakeX[0] = 100; snakeY[0] = 100; // 脑袋的坐标
        snakeX2[0] = 300; snakeY2[0] = 100; // 蛇蛇2头的坐标

        // 两个蛇蛇的身体
        snakeX[1] = 75; snakeY[1] = 100;
        snakeX[2] = 50; snakeY[2] = 100;

        snakeX2[1] = 275; snakeY2[1] = 100;
        snakeX2[2] = 250; snakeY2[2] = 100;

        fx = "R";
        fx2 = "R"; // 蛇蛇2头的方向
        timer.start(); // 刚开始就让定时器开始

        // 食物的坐标
        foodx = 25 + 25 * r.nextInt(34); // 这个数据是算出来的
        foody = 75 + 25 * r.nextInt(24);
    }

    // 绘制面板， 我们游戏中的所有东西， 都是用这个画笔画的
    @Override
    protected  void paintComponent(Graphics g) {
        super.paintComponent(g); // 清屏, 然后重新画整个面板
        // 绘制静态的面板
        this.setBackground(Color.WHITE);

        Data.header.paintIcon(this, g, 25, 11); // 把广告放上去
        g.fillRect(25, 75, 850, 600); // 默认的游戏界面

        Data.fooder.paintIcon(this, g, foodx, foody); // 把食物画上去, 这里先画的食物, 因为先画蛇可能会重叠

        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑", Font.BOLD, 18));
        g.drawString("齐名阳 长度 : " + len, 740, 35);
        g.drawString("谢一璞 长度 : " + len2, 740, 55);


        // 把小蛇的头放上去
        if ("R".equals(fx)) Data.righter.paintIcon(this, g,  snakeX[0], snakeY[0]); // 蛇头方向初始化向右, 需要通过方向判断
        else if ("L".equals(fx)) Data.lefter.paintIcon(this, g,  snakeX[0], snakeY[0]);
        else if ("U".equals(fx)) Data.uper.paintIcon(this, g,  snakeX[0], snakeY[0]);
        else if ("D".equals(fx)) Data.downer.paintIcon(this, g,  snakeX[0], snakeY[0]);

        if ("R".equals(fx2)) Data.righter.paintIcon(this, g,  snakeX2[0], snakeY2[0]); // 蛇头2方向初始化向右, 需要通过方向判断
        else if ("L".equals(fx2)) Data.lefter.paintIcon(this, g,  snakeX2[0], snakeY2[0]);
        else if ("U".equals(fx2)) Data.uper.paintIcon(this, g,  snakeX2[0], snakeY2[0]);
        else if ("D".equals(fx2)) Data.downer.paintIcon(this, g,  snakeX2[0], snakeY2[0]);


        for (int i = 1; i < len; i ++ ) Data.bodyer.paintIcon(this, g, snakeX[i], snakeY[i]); // 身体的下标从1 => len - 1
        for (int i = 1; i < len2; i ++ ) Data.bodyer2.paintIcon(this, g, snakeX2[i], snakeY2[i]); // 蛇蛇2的身体

        // 游戏状态, 把暂停的字放上去
        if (!isStart) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑", Font.BOLD, 20));
            // 设置字体
            g.drawString("按下空格开始游戏, 齐明阳是绿色上下左右操作, 谢一璞是粉色WASD操作", 130, 300);
        }

        // 把失败的字放上去
        if (isFail) {
            g.setColor(Color.red);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString(winner + " 获胜 ! 按下空格重新开始 !", 150, 300);
        }
    }

    // 键盘按下事件
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) { // 如果按下的是空格
            if (isFail) { // 如果是游戏结束的话, 那就重新开始
                // 重新开始
                isFail = false;
                init();
            }
            else isStart = !isStart; // 否则就是正常游戏暂停, 状态就取反
            repaint();
        }
        new Thread(new MyKeyEvent(e)).start();
        new Thread(new MyKeyEvent(e)).start();
    }

    // 事件监听, 需要通过固定时间来刷新, 1s = 10次
    @Override
    public void actionPerformed(ActionEvent e) { // 英文名字 : 动画演示
        if (isStart && !isFail) { // 如果游戏是开始状态, 且游戏没有失败, 就让小蛇动起来
            // 身体的移动 -> 直接覆盖
            for (int i = len - 1; i >= 1; i -- ) {
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }

            // 蛇蛇2的移动
            for (int i = len2 - 1; i >= 1; i -- ) {
                snakeX2[i] = snakeX2[i - 1];
                snakeY2[i] = snakeY2[i - 1];
            }

            // 吃食物
            if (snakeX[0] == foodx && snakeY[0] == foody) {
                // 长度 + 1, 因为我们小蛇的移动采用一种直接覆盖的方式, 所以这里直接长度加1就好了
                len ++ ;
                // 分数 + 10
                // 再次生成食物
                foodx = 25 + 25 * r.nextInt(34);
                foody = 75 + 25 * r.nextInt(24);
            }

            // 蛇蛇2吃到了
            if (snakeX2[0] == foodx && snakeY2[0] == foody) {
                len2 ++ ;
                foodx = 25 + 25 * r.nextInt(34);
                foody = 75 + 25 * r.nextInt(24);
            }

            // 头部的移动, 根据头部的方向来决定移动方向
            if ("R".equals(fx)) snakeX[0] += 25;
            else if ("L".equals(fx)) snakeX[0] -= 25;
            else if ("U".equals(fx)) snakeY[0] -= 25;
            else if ("D".equals(fx)) snakeY[0] += 25;

            // 蛇蛇2头部的移动, 根据头部的方向来决定移动方向
            if ("R".equals(fx2)) snakeX2[0] += 25;
            else if ("L".equals(fx2)) snakeX2[0] -= 25;
            else if ("U".equals(fx2)) snakeY2[0] -= 25;
            else if ("D".equals(fx2)) snakeY2[0] += 25;

            // 边界判断
            if (snakeX[0] > 850) snakeX[0] = 25; // 走出边界了就从另一边回来
            if (snakeX[0] < 25) snakeX[0] = 850;
            if (snakeY[0] > 650) snakeY[0] = 75;
            if (snakeY[0] < 75) snakeY[0] = 650;

            // 蛇蛇2边界判断
            if (snakeX2[0] > 850) snakeX2[0] = 25; // 走出边界了就从另一边回来
            if (snakeX2[0] < 25) snakeX2[0] = 850;
            if (snakeY2[0] > 650) snakeY2[0] = 75;
            if (snakeY2[0] < 75) snakeY2[0] = 650;

            // 失败判定
            for (int i = 1; i < len; i ++ ) // 先看撞到自己了吗
                if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                    isFail = true;
                    winner = "谢一璞"; // 对手是谢一璞
                } else {
                    for (int j = 1; j < len2; j ++ ) // 再看撞别人了吗
                        if (snakeX[0] == snakeX2[j] && snakeY[0] == snakeY2[j]) {
                            isFail = true;
                            winner = "谢一璞";
                        }
                }

            for (int i = 1; i < len2; i ++ )
                if (snakeX2[0] == snakeX2[i] && snakeY2[0] == snakeY2[i]) { // 先看撞到自己了吗
                    isFail = true;
                    winner = "齐明阳"; // 对手是齐明阳
                } else {
                    for (int j = 1; j < len; j ++ ) // 再看撞别人了吗
                        if (snakeX2[0] == snakeX[j] && snakeY2[0] == snakeY[j]) {
                            isFail = true;
                            winner = "齐明阳";
                        }
                }

            repaint(); // 重画页面
        }
//        timer.start(); // 定时器开始 !
    }

    // 没有用
    @Override
    public void keyReleased(KeyEvent e) { }
    @Override
    public void keyTyped(KeyEvent e) { }

    class MyKeyEvent implements Runnable {
        private KeyEvent e;
        public MyKeyEvent(KeyEvent e) {
            this.e = e;
        }

        @Override
        public void run() {
            int keyCode = e.getKeyCode(); // 获得键盘按键是哪一个

            // 小蛇头部方向的改变
            if (keyCode == KeyEvent.VK_UP && !"D".equals(fx)) fx = "U";
            else if (keyCode == KeyEvent.VK_DOWN && !"U".equals(fx)) fx = "D";
            else if (keyCode == KeyEvent.VK_LEFT && !"R".equals(fx)) fx = "L";
            else if (keyCode == KeyEvent.VK_RIGHT && !"L".equals(fx)) fx = "R";

            // 蛇蛇2头部方向改变
            if (keyCode == KeyEvent.VK_W && !"D".equals(fx2)) fx2 = "U";
            else if (keyCode == KeyEvent.VK_S && !"U".equals(fx2)) fx2 = "D";
            else if (keyCode == KeyEvent.VK_A && !"R".equals(fx2)) fx2 = "L";
            else if (keyCode == KeyEvent.VK_D && !"L".equals(fx2)) fx2 = "R";
        }
    }
}