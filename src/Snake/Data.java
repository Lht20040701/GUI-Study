package Snake;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.net.URL;

// 数据中心
public class Data {
    // 需要对 绝对路径 相对路径 有一定的了解
    public static URL headURL = Data.class.getResource("/statics/header.png"); // 从src开始找
    public static URL head1URL = Data.class.getResource("/statics/header1.png"); // 从src开始找
    public static ImageIcon header = new ImageIcon(headURL);
    public static ImageIcon header1 = new ImageIcon(head1URL);
    public static URL upURL = Data.class.getResource("/statics/up.png");
    public static URL downURL = Data.class.getResource("/statics/down.png");
    public static URL leftURL = Data.class.getResource("/statics/left.png");
    public static URL rightURL = Data.class.getResource("/statics/right.png");
    public static ImageIcon uper = new ImageIcon(upURL);
    public static ImageIcon downer = new ImageIcon(downURL);
    public static ImageIcon lefter = new ImageIcon(leftURL);
    public static ImageIcon righter = new ImageIcon(rightURL);

    public static URL bodyURL = Data.class.getResource("/statics/body.png");
    public static URL body2URL = Data.class.getResource("/statics/body2.png");
    public static ImageIcon bodyer = new ImageIcon(bodyURL);
    public static ImageIcon bodyer2 = new ImageIcon(body2URL);
    public static URL foodURL = Data.class.getResource("/statics/food.png");
    public static ImageIcon fooder = new ImageIcon(foodURL);
}
