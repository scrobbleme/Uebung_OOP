package oop.uebung3.apps.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

import oop.uebung3.apps.App;
import oop.uebung3.apps.StreamableApp;

public class ProcessAppListener implements ActionListener {

	private Map<String, App> apps;
	private JComboBox<String> appSelectionField;
	private JTextArea appParametersField;
	private JTextArea appResultField;

	public ProcessAppListener(Map<String, App> apps, JComboBox<String> appSelectionField, JTextArea appParametersField,
	        JTextArea appResultField) {
		this.apps = apps;
		this.appSelectionField = appSelectionField;
		this.appParametersField = appParametersField;
		this.appResultField = appResultField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		App selectedApp = apps.get(appSelectionField.getSelectedItem());
		if (selectedApp instanceof StreamableApp) {
			String parametersText = selectedApp.getName() + " " + appParametersField.getText();
			String[] parameters = parametersText.split("\\s+");
			try (ByteArrayOutputStream result = new ByteArrayOutputStream()) {
				PrintStream oldOutputStream = ((StreamableApp) selectedApp).getOutputStream();
				((StreamableApp) selectedApp).setOutputStream(new PrintStream(result));
				selectedApp.process(parameters);
				((StreamableApp) selectedApp).setOutputStream(oldOutputStream);
				appResultField.setText(result.toString());
			} catch (IOException e1) {
				appResultField.setText("Es gab einen Fehler: " + e1.getMessage());
			}

		} else {
			appResultField.setText("Diese App unterstützt leider kein graphisches Frontend.");
		}

	}
}
