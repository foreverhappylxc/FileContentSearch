package com.fhlxc.filecontentsearch;

import java.awt.EventQueue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* @author Xingchao Long
* @date 2020年3月30日 下午9:25:14
* @classname Main
* @description 
*/

public class Main {
    
    private static MainWindow mainWindow;

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String("file_content_search.xml"));
        mainWindow = (MainWindow) context.getBean("mainWindow");
        
        EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                mainWindow.setMainWindow();
                mainWindow.setVisible(true);
            }
        });
    }

}
