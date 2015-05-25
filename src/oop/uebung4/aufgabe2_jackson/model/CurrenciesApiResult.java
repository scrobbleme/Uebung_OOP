package oop.uebung4.aufgabe2_jackson.model;

import java.util.Map;

/**
 * A wrapper object for the API result for getting all currencies.
 */
public class CurrenciesApiResult {
	private Map<String, Currency> results;

	public Map<String, Currency> getResults() {
		return results;
	}

	public void setResults(Map<String, Currency> results) {
		this.results = results;
	}
}
