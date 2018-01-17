package corejava.ch06.localInnerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;


//本地内部类的使用
public class LocalInnerClassTest {
	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock();
		clock.start(1000, true);

		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}

//按一定时间间隔打印时间的时钟
class TalkingClock {

	//启动时钟
	public void start(int interval, boolean beep) {
		class TimePrinter implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				System.out.println("At the tone,the time is" + new Date());
				if (beep)
					Toolkit.getDefaultToolkit().beep();
			}
		}
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
	}

}
