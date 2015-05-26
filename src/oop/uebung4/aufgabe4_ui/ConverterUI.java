package oop.uebung4.aufgabe4_ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.io.IOException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import oop.uebung4.aufgabe1.CurrencyConverterApp;
import oop.uebung4.aufgabe2_jackson.ListCurrenciesApp;
import oop.uebung4.aufgabe2_jackson.model.Currency;
import oop.uebung4.aufgabe3_caching.CachingCurrencyConverterApp;

public class ConverterUI extends JFrame {

	private static final long serialVersionUID = -993272720602194542L;

	private JPanel contentPane;
	private JTable currenciesTable;
	private JTextField targetValueTextField;
	private JPanel panel_1;
	private JButton btnWhrungenNeuladen;
	private JSpinner sourceValueSpinner;
	private JProgressBar progressBar;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JPanel panel_3;
	private JComboBox<String> sourceCurrencyComboBox;
	private JComboBox<String> targetCurrencyComboBox;

	private ListCurrenciesApp listCurrenciesApp = new ListCurrenciesApp();
	private CurrencyConverterApp converterApp = new CachingCurrencyConverterApp();

	/**
	 * Dieser Listener aktuelisiert die Umrechnung, sobald sich der Wert oder
	 * die ausgewählten Währungen ändern.
	 */
	private ActionListener convertCurrencyListener = (event) -> {
		try {
			String sourceCurrency = (String) sourceCurrencyComboBox.getSelectedItem().toString();
			String targetCurrency = (String) targetCurrencyComboBox.getSelectedItem().toString();
			if (sourceCurrency == null || targetCurrency == null) {
				return;
			}
			int value = (Integer) sourceValueSpinner.getValue();
			double rate = converterApp.getRate(sourceCurrency, targetCurrency);
			targetValueTextField.setText(value * rate + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterUI frame = new ConverterUI();
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
	public ConverterUI() {
		setTitle("CurrencyConverter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		progressBar = new JProgressBar();
		panel.add(progressBar, BorderLayout.SOUTH);

		panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);

		sourceValueSpinner = new JSpinner();
		panel_2.add(sourceValueSpinner);
		sourceValueSpinner.setModel(new SpinnerNumberModel(10, 1, 100000000, 1));
		sourceValueSpinner.addChangeListener((event) -> {
			convertCurrencyListener.actionPerformed(null);
		});

		sourceCurrencyComboBox = new JComboBox<>();
		sourceCurrencyComboBox.addActionListener(convertCurrencyListener);
		panel_2.add(sourceCurrencyComboBox);

		JLabel label = new JLabel("=");
		panel_2.add(label);

		targetValueTextField = new JTextField();
		panel_2.add(targetValueTextField);
		targetValueTextField.setEditable(false);
		targetValueTextField.setColumns(10);

		targetCurrencyComboBox = new JComboBox<>();
		targetCurrencyComboBox.addActionListener(convertCurrencyListener);
		panel_2.add(targetCurrencyComboBox);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnWhrungenNeuladen = new JButton("W\u00E4hrungen neuladen");
		btnWhrungenNeuladen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new Thread(() -> {
					progressBar.setIndeterminate(true);
					sourceCurrencyComboBox.removeAllItems();
					targetCurrencyComboBox.removeAllItems();
					DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Symbol",
					        "Name", "Kurs" });
					try {
						Collection<Currency> currencies = listCurrenciesApp.getCurrencies();
						progressBar.setMaximum(currencies.size());
						progressBar.setIndeterminate(false);
						int counter = 1;
						for (Currency currency : currencies) {
							try {
								model.addRow(new String[] {
								        currency.getId(),
								        currency.getCurrencySymbol(),
								        currency.getCurrencyName(),
								        "1 EUR = " + converterApp.getRate("EUR", currency.getId()) + " "
								                + currency.getId() });
								sourceCurrencyComboBox.addItem(currency.getId());
								targetCurrencyComboBox.addItem(currency.getId());
								currenciesTable.setModel(model);
							} catch (NumberFormatException e) {
								e.printStackTrace();
							}
							progressBar.setValue(counter++);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}).start();
			}
		});
		panel_1.add(btnWhrungenNeuladen);

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		panel_3 = new JPanel();
		scrollPane.setViewportView(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		currenciesTable = new JTable();
		currenciesTable.setCellSelectionEnabled(true);
		panel_3.add(currenciesTable);
		currenciesTable.setModel(new DefaultTableModel(new Object[][] {},
		        new String[] { "Id", "Symbol", "Name", "Kurs" }));
	}
}
