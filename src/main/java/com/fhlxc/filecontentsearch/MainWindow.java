package com.fhlxc.filecontentsearch;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
* @author Xingchao Long
* @date 2020年3月30日 下午8:55:03
* @classname MainWindow
* @description 程序的主界面
*/

@SuppressWarnings("serial")
@PropertySource("ui.properties")
@Component("mainWindow")
public class MainWindow extends JFrame {

    /*
     * 主界面相关的参数
     * width: 界面的宽
     * height: 界面的长
     */
    @Value("${main_window.width}")
    private int width;
    @Value("${main_window.height}")
    private  int height;
    
    /*
     * w: 屏幕的宽
     * h: 屏幕的高
     */
    private static int w = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static int h = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    
    private JPanel contenJPanel = new JPanel();
    
    public void setMainWindow() {
        setBounds((w - width) / 2, (h - height) / 2, width, height);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contenJPanel);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
}
