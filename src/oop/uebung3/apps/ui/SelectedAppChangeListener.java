package oop.uebung3.apps.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import oop.uebung3.apps.App;

/**
 * Ein Listener für das Auswahfeld der Apps.
 */
public class SelectedAppChangeListener implements ActionListener {

	private Map<String, App> apps;
	private JLabel appDescriptionField;

	public SelectedAppChangeListener(Map<String, App> apps, JLabel appDescriptionField) {
		this.apps = apps;
		this.appDescriptionField = appDescriptionField;
	}

	/**
	 * Setzt die Beschreibung der ausgewählten App.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		App selectedApp = apps.get(((JComboBox<String>) e.getSource()).getSelectedItem());
		appDescriptionField.setText(selectedApp.getDescription());
	}

}
