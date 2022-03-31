/**
 *
 * Notes aus Übungsbesprechung:
 * ----------------------------
 * A1 so aufteilen wie in der Aufgabenstellung und nicht kombinieren
 *
 * IF - boolean add,
 * boolean remove,
 * boolean contains,
 * int size
 *
 *
 * 1. Kollisionen ignorieren
 * size --> wie viele werte da wirklich drin sind
 * addToIndex als private methode implementieren
 *
 * contains - berechnet den index, und checkt dann ob das übergebene Value darin ist
 * contains --> private methode, die einen index zurückliefert
 * remove - referenz bewusst löschen, wenn wir arrays nutzen, wegen carbage collector
 *
 */

package ch.hslu.ad.sw04;