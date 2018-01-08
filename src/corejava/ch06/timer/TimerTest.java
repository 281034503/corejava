package corejava.ch06.timer;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTest {
	public static void main(String[] args) {
		ActionListener listener = new TimePrinter();
		
		//构造一个调用侦听器的计时器
		//每10秒一次
		Timer t = new Timer(10000, listener);
		t.start();

		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);

	}

}

class TimePrinter implements ActionListener {

	public void actionPerformed(ActionEvent event) {
		System.out.println("At the tone,the time is" + new Date());
		Toolkit.getDefaultToolkit().beep();

	}
}
