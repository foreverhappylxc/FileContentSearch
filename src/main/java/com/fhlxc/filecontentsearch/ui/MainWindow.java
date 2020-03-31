package com.fhlxc.filecontentsearch.ui;

import java.awt.Color;
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
     * wth: 界面的宽
     * hght: 界面的长
     */
    
    @Value("${main_window.width}")
    private int wth = 100;
    @Value("${main_window.height}")
    private  int hght = 100;
    
    
    /*
     * w: 屏幕的宽
     * h: 屏幕的高
     */
    private static int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    
    private JPanel contenJPanel = new JPanel();
    
    public void setMainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds((screenWidth - wth) / 2, (screenHeight - hght) / 2, wth, hght);
        setAlwaysOnTop(true);
        setTitle("搜索");
        
        contenJPanel.setBackground(Color.red);
        setContentPane(contenJPanel);
    }

    public int getWth() {
        return wth;
    }

    public void setWth(int wth) {
        this.wth = wth;
    }

    public int getHght() {
        return hght;
    }

    public void setHght(int hght) {
        this.hght = hght;
    }

}
