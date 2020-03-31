package com.fhlxc.filecontentsearch;

import java.awt.EventQueue;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fhlxc.filecontentsearch.ui.MainWindow;

/**
* @author Xingchao Long
* @date 2020年3月30日 下午9:25:14
* @classname Main
* @description 应用程序入口
*/

public class Main {
    
    private static MainWindow mainWindow;

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                ApplicationContext context = new ClassPathXmlApplicationContext(new String("file_content_search.xml"));
                mainWindow = (MainWindow) context.getBean("mainWindow");
                mainWindow.setMainWindow();
                mainWindow.setVisible(true);
            }
        });
    }

}
