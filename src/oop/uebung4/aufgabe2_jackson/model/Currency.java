package oop.uebung4.aufgabe2_jackson.model;

/**
 * Model element to represent a currency of freecurrencyconverterapi.com.
 */
public class Currency {

	private String currencyName;
	private String currencySymbol;
	private String id;

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
