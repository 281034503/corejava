package corejava.ch7.except;

import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.swing.*;

public class ExceptTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new ExceptTestFrame();
			frame.setTitle("ExceptTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});

	}

}

class ExceptTestFrame extends JFrame {
	public ExceptTestFrame() {
		ExceptTestPanel panel = new ExceptTestPanel();
		add(panel);
		pack();

	}

}

class ExceptTestPanel extends Box {

	private ButtonGroup group;
	private JTextField textField;
	private double[] a = new double[10];

	public ExceptTestPanel() {
		super(BoxLayout.X_AXIS);
		group = new ButtonGroup();

		// 为代码片段添加单选按钮

		addRadioButton("Integer divide vy zero", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				a[1] = 1 / (a.length - a.length);
			}
		});

		addRadioButton("Floating point divide by zero", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				a[1] = a[2] / (a[3] - a[3]);
			}
		});

		addRadioButton("Array bounds", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				a[1] = a[10];
			}
		});

		addRadioButton("Bad cast", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				a = (double[]) event.getSource();
			}
		});

		addRadioButton("Null pointer", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println(textField.getAction().toString());
			}
		});

		addRadioButton("sqrt(-1)", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				a[1] = Math.sqrt(-1);
			}
		});

		addRadioButton("Overflow", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				a[1] = 1000 * 1000 * 1000 * 1000;
				int n = (int) a[1];
				System.out.println(n);
			}
		});

		addRadioButton("No such file", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					System.out.println(new Scanner(Paths.get("woozle.txt"), "UTF-8").next());
				} catch (IOException e) {
					textField.setText(e.toString());
				}
			}
		});

		addRadioButton("Throw unknown", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				throw new UnknownError();

			}
		});

		// 添加用于异常显示的文本字段。

		textField = new JTextField(30);
		add(textField);

	}

	// 在面板中添加一个带有给定监听器的单选按钮
	// 捕获任何异常

	private void addRadioButton(String s, ActionListener listener) {
		JRadioButton button = new JRadioButton(s, false) {
			// 按钮调用这个方法来触发一个
			// 动作事件。我们重写它以捕获异常

			protected void fireActionPerformed(ActionEvent event) {
				try {
					textField.setText("No exception");
					super.fireActionPerformed(event);
				} catch (Exception e) {
					textField.setText(e.toString());

				}
			}
		};
		button.addActionListener(listener);
		add(button);
		group.add(button);
	}
}
