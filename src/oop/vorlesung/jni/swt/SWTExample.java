package oop.vorlesung.jni.swt;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SWTExample {

	public static void main(String[] args) {
		// SWT
		new Thread(new Runnable() {
			@Override
			public void run() {
				Display display = new Display();
				Shell shell = new Shell(display);
				shell.setLayout(new RowLayout(2));
				shell.setText("GUI");

				Text text = new Text(shell, SWT.NONE);
				text.setText("Hello SWT");
				text.pack();

				Button button = new Button(shell, SWT.NONE);
				button.setText("Button");
				button.addMouseListener(new MouseListener() {

					@Override
					public void mouseUp(MouseEvent arg0) {
						new ColorDialog(shell, SWT.NONE).open();
					}

					@Override
					public void mouseDown(MouseEvent arg0) {
					}

					@Override
					public void mouseDoubleClick(MouseEvent arg0) {
					}
				});
				button.pack();

				Combo combobox = new Combo(shell, SWT.NONE);
				combobox.add("AAAAAA");
				combobox.add("BBBBBB");
				combobox.add("CCCCCC");
				combobox.pack();

				shell.pack();
				shell.open();
				while (!shell.isDisposed()) {
					if (!display.readAndDispatch())
						display.sleep();
				}
				display.dispose();
			}
		}).start();

		// Swing
		new Thread(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame("GUI");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new FlowLayout());

				frame.add(new JTextField("Hello Swing"));
				frame.add(new JButton("Button"));
				frame.add(new JComboBox<String>(new String[] { "AAAAAA", "BBBBBB", "CCCCCC" }));
				frame.add(new JColorChooser());

				frame.pack();
				frame.setVisible(true);
			}
		}).start();
	}
}