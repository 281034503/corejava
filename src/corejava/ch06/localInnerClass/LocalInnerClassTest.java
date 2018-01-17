package corejava.ch06.localInnerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;


//�����ڲ����ʹ��
public class LocalInnerClassTest {
	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock();
		clock.start(1000, true);

		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}

//��һ��ʱ������ӡʱ���ʱ��
class TalkingClock {

	//����ʱ��
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
