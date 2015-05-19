package oop.uebung3.apps.ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import oop.uebung3.apps.AbstractApp;
import oop.uebung3.apps.App;

/**
 * Die UIApp stellt eine einfache graphische Oberfläche zur Auswahl und
 * Ausführung unserer Apps bereit.
 */
public class UIApp extends AbstractApp {

	private Map<String, App> apps;

	public UIApp(Map<String, App> apps) {
		super("gui", "Diese Anwendung bietet eine einfache Oberfläche zum Starten von Apps.");
		this.apps = apps;
	}

	@Override
	public void process(String... args) {
		JFrame frame = new JFrame("AppStarter GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		JLabel label = new JLabel("Bitte wählen Sie eine Applikation");

		panel.setLayout(new GridLayout(10, 1));

		JComboBox<String> appSelectionField = new JComboBox<String>(apps.keySet().toArray(new String[apps.size()]));
		JTextArea appParametersField = new JTextArea();
		appParametersField.setBorder(new LineBorder(Color.BLACK));
		JLabel appDescriptionField = new JLabel(apps.entrySet().iterator().next().getValue().getDescription());
		JTextArea appResultField = new JTextArea();
		appResultField.setBorder(new LineBorder(Color.BLACK));
		JButton processButton = new JButton("Berechne");

		// Alle notwendigen Listener registrieren
		appSelectionField.addActionListener(new SelectedAppChangeListener(apps, appDescriptionField));
		processButton.addActionListener(new ProcessAppListener(apps, appSelectionField, appParametersField,
		        appResultField));

		// Alle Elemente dem Panel hinzufügen
		panel.add(label);
		panel.add(appSelectionField);
		panel.add(appDescriptionField);
		panel.add(new JLabel("Parameter:"));
		panel.add(appParametersField);
		panel.add(processButton);
		panel.add(new JLabel("Ergebnis:"));
		panel.add(appResultField);

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
