package oop.uebungx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WeepsMiner extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeepsMiner frame = new WeepsMiner();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WeepsMiner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(10, 10, 0, 0));

		for (int i = 0; i < 100; i++) {
			JButton button = new BombButton();
			button.addMouseListener(markHelpActionLister);
			contentPane.add(button);
		}

	}

	public class BombButton extends JButton {
		private final boolean hasBomb = Math.random() > 0.8;

		public boolean isHasBomb() {
			return hasBomb;
		}

	}

	/*
	 * Hilfsklassen
	 */

	MouseListener markHelpActionLister = new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent e) {
			// Do nothing
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// Do nothing
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// Do nothing
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// Do nothing
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (!(e.getSource() instanceof BombButton)) {
				// Kein Button
				return;
			}
			BombButton button = (BombButton) e.getSource();
			if (!button.isEnabled()) {
				// Bereits deaktivert.
				return;
			}
			switch (e.getButton()) {
			case 3:
				if (button.getText().equals("?")) {
					button.setText("");
				} else {
					button.setText("?");
				}
				break;
			default:
				if (button.hasBomb) {
					button.setBackground(Color.red);
					button.setText("x");
					JDialog dialog = new JDialog();
					dialog.add(new JLabel("Sie haben leider verloren"));
					dialog.setTitle("Verloren");
					dialog.pack();
					dialog.setVisible(true);
				} else {
					button.setBackground(Color.green);
				}
				button.setEnabled(false);
			}
		}
	};
}
