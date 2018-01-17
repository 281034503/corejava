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

		// ���ֳ������У�ֱ���û�ѡ��Ok��
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

// ��һ��ʱ������ӡʱ���ʱ�ӡ�
class TalkingClock {
	private int interval;
	private boolean beep;

	// ����һ����˵������
	public TalkingClock(int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
	}

	// ����ʱ��
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
