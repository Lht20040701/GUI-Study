package Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

// 游戏的面板
public class GamePanel extends JPanel implements KeyListener, ActionListener {
    // 定义蛇的数据结构
    int len; // 蛇的长度
    int[] snakeX =  new int[600]; // 蛇的X坐标 25 * 25
    int[] snakeY = new int[500]; // 蛇的Y坐标 25 * 25
    String fx; // 小蛇头的方向
    int foodx, foody; // 食物的坐标
    Random r = new Random(); // 食物随机化

    // 游戏当前的状态 : 开始, 停止, 失败
    boolean isStart = false;
    boolean isFail = false;

    // 游戏分数
    int score = 0;


    // 定时器 以ms为单位, 1000ms = 1s
    Timer timer = new Timer(50, this);

    // 构造器
    public GamePanel() {
        init();
        // 获得焦点和键盘事件
        this.setFocusable(true); // 获得焦点事件
        this.addKeyListener(this);
    }

    // 初始化方法
    public void init() {
        len = 3;
        snakeX[0] = 100; snakeY[0] = 100; // 脑袋的坐标
        snakeX[1] = 75; snakeY[1] = 100; // 第一个身体的坐标
        snakeX[2] = 50; snakeY[2] = 100; // 第二个身体的坐标
        fx = "R"; // 头的初始方向向右
        timer.start(); // 刚开始就让定时器开始

        // 食物的坐标
        foodx = 25 + 25 * r.nextInt(34); // 这个数据是算出来的
        foody = 75 + 25 * r.nextInt(24);

        // 初始化分数
        score = 0;
    }

    // 绘制面板， 我们游戏中的所有东西， 都是用这个画笔画的
    @Override
    protected  void paintComponent(Graphics g) {
        super.paintComponent(g); // 清屏, 然后重新画整个面板
        // 绘制静态的面板
        this.setBackground(Color.WHITE);

        Data.header1.paintIcon(this, g, 25, 11); // 把广告放上去
        g.fillRect(25, 75, 850, 600); // 默认的游戏界面

        Data.fooder.paintIcon(this, g, foodx, foody); // 把食物画上去, 这里先画的食物, 因为先画蛇可能会重叠

        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑", Font.BOLD, 18));
        g.drawString("长度 : " + len, 750, 35);
        g.drawString("分数 : " + score, 750, 55);


        // 把小蛇的头放上去
        if ("R".equals(fx)) Data.righter.paintIcon(this, g,  snakeX[0], snakeY[0]); // 蛇头方向初始化向右, 需要通过方向判断
        else if ("L".equals(fx)) Data.lefter.paintIcon(this, g,  snakeX[0], snakeY[0]);
        else if ("U".equals(fx)) Data.uper.paintIcon(this, g,  snakeX[0], snakeY[0]);
        else if ("D".equals(fx)) Data.downer.paintIcon(this, g,  snakeX[0], snakeY[0]);
        // 把身体放上去
        for (int i = 1; i < len; i ++ ) Data.bodyer.paintIcon(this, g, snakeX[i], snakeY[i]); // 身体的下标从1 => len - 1

        // 游戏状态, 把暂停的字放上去
        if (!isStart) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            // 设置字体
            g.drawString("按下空格开始游戏", 300, 300);
        }

        // 把失败的字放上去
        if (isFail) {
            g.setColor(Color.red);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("你死了, 按下空格重新开始", 200, 300);
        }
    }

    // 键盘按下事件
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode(); // 获得键盘按键是哪一个
        if (keyCode == KeyEvent.VK_SPACE) { // 如果按下的是空格
            if (isFail) { // 如果是游戏结束的话, 那就重新开始
                // 重新开始
                isFail = false;
                init();
            }
            else isStart = !isStart; // 否则就是正常游戏暂停, 状态就取反
            repaint();
        }

        // 小蛇头部方向的改变
        if (keyCode == KeyEvent.VK_UP && !"D".equals(fx)) fx = "U";
        else if (keyCode == KeyEvent.VK_DOWN && !"U".equals(fx)) fx = "D";
        else if (keyCode == KeyEvent.VK_LEFT && !"R".equals(fx)) fx = "L";
        else if (keyCode == KeyEvent.VK_RIGHT && !"L".equals(fx)) fx = "R";
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

            // 吃食物
            if (snakeX[0] == foodx && snakeY[0] == foody) {
                // 长度 + 1, 因为我们小蛇的移动采用一种直接覆盖的方式, 所以这里直接长度加1就好了
                len ++ ;
                // 分数 + 10
                score += 10;
                // 再次生成食物
                foodx = 25 + 25 * r.nextInt(34);
                foody = 75 + 25 * r.nextInt(24);
            }

            // 头部的移动, 根据头部的方向来决定移动方向
            if ("R".equals(fx)) snakeX[0] += 25;
            else if ("L".equals(fx)) snakeX[0] -= 25;
            else if ("U".equals(fx)) snakeY[0] -= 25;
            else if ("D".equals(fx)) snakeY[0] += 25;

            // 边界判断
            if (snakeX[0] > 850) snakeX[0] = 25; // 走出边界了就从另一边回来
            if (snakeX[0] < 25) snakeX[0] = 850;
            if (snakeY[0] > 650) snakeY[0] = 75;
            if (snakeY[0] < 75) snakeY[0] = 650;

            // 失败判定, 撞到自己
            for (int i = 1; i < len; i ++ )
                if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i])
                    isFail = true;

            repaint(); // 重画页面
        }
//        timer.start(); // 定时器开始 !
    }

    // 没有用
    @Override
    public void keyReleased(KeyEvent e) { }
    @Override
    public void keyTyped(KeyEvent e) { }
}