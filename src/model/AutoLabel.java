package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;


public class AutoLabel extends JLabel {
	String str;
	EtchedBorder eborder;
    public AutoLabel(String str) {
    	this.str = str;
        setHorizontalAlignment(SwingConstants.CENTER);
        setText(str);
        setOpaque(true);
        setBackground(new Color(0,0,0,170));
        setForeground(Color.WHITE);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resize();
            }
        });
    }
 
    public void resize() {
        int i=0;
        while(true) {
            Font before = getFont();
            Font font = new Font(before.getName(), before.getStyle(), i);
            setFont(font);
            if(getPreferredSize().getWidth()>getWidth() || getPreferredSize().getHeight()>getHeight()) {
                font = new Font(before.getName(), before.getStyle(), i-1);
                setFont(font);
                break;
            }
            i++;    
        }
    }
    
   
 
}