package corejava.ch06.innerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class InnerClassTest {
	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock(1000, true);
		clock.start();

		// 保持程序运行，直到用户选择“Ok”
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

// 按一定时间间隔打印时间的时钟。
class TalkingClock {
	private int interval;
	private boolean beep;

	// 构造一个会说话的钟
	public TalkingClock(int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
	}

	// 启动时钟
	public void start() {
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();

	}

	public class TimePrinter implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("At the tone,the time is" + new Date());
			if (beep)
				Toolkit.getDefaultToolkit().beep();
		}
	}
}
