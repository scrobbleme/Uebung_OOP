package oop.vorlesung.array;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;

import org.junit.Test;

public class SortedArrayTest {

	public int[] sortiereArray(int[] arrayToSort) {
		Set<Integer> sortedSet = new TreeSet<Integer>();
		for (int i : arrayToSort) {
			sortedSet.add(i);
		}

		int index = 0;
		for (Integer i : sortedSet) {
			arrayToSort[index] = i;
			index++;
		}
		return arrayToSort;
	}

	// Normalerweise befindet sich der Test in einer separaten Datei
	@Test
	public void testSortedArray() {
		int[][] arrays = new int[][] { 
				{ 1, 2, 3, 4 },
				{ 10, 0, 6, 5, 11 }, 
				{ 0, 9, 7, -1, 9 } };

		for (int[] array : arrays) {
			array = sortiereArray(array);

			// Prüfe, dass das Array korrekt sortiert ist
			for (int i = 0; i < array.length - 1; i++) {
				Assert.assertTrue(array[i] < array[i + 1]);
			}
		}
	}
}
