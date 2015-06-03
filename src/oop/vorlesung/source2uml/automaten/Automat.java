package oop.vorlesung.source2uml.automaten;

import oop.vorlesung.source2uml.produkte.Produkt;

public interface Automat<T extends Produkt> {

	public T frageNachWare();

	public T frageNachGeld();

	public void gibWareAus(T ware);
}
