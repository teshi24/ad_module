/**
 * Quicksort: instabil, Average Case in O(n log(n))
 *            Rekursiv
 *            1. Trennelement identifizieren: letztes Element ist Trennelement (um Datenmenge zu spalten)
 *            2. von Links beginnen, 1.Stelle merken, die nach rechts verschoben werden muss, weil >=
 *            3. von Rechts beginnen, 1. Element, das nach links verschoben werden muss finden
 *            4. Element aus Step 2 mit Element aus Step 3 vertauschen
 *            5. Steps 2 bis 4 wiederholen, bis die Sondierketten zusammentreffen
 *            6. Trennelement mit Stelle von Step 5 vertauschen
 *            7. 2 Arrays links und rechts von Trennelement als neue Arrays trennen
 *
 *            Worstcase: T ist bereits kleinstes / grösstes Element
 *            Bestcase: T passt genau in die Mitte, sodass die neuen Arrays beide gleich gross sind
 *            --> um das zu verbessern werden 3 Elemente angeschaut, z.b. 1., mittleres, letztes Element
 *                angeschaut und das mittlere Wert der 3 Elemente genommen und ans Ende der Folge getauscht
 *
 *            für Nebenläufigkeit - kleinere Steps müssten eigentlich nicht synchronisiert werden, weil es ja nicht auf denselben Arrayindexen arbeitet
 *
 *            Problematik: gleiche Elemente
 *            --> Wenn viele gleich grosse Elemente vorhanden sind, werden die alle nach rechts verschoben mit den grösseren
 *            --> Gefahr: asymmetrische Auftrennung
 *            Optimierung: auftrennen so vornehmen, dass die, die grösser gleich nach links, grösser gleich nach rechts
 *            Optimierung mit 3-Wege-Auftrennung: links < T, Mitte T, rechts > T --> kompliziert + mehr Vertauschungen, dafür weniger Methodenaufrufe
 *
 *            DualPivot --> 2 Pivot-Elemente, komplex, aber halt schneller
 *
 *            Optimierung mit Quick-Insertion-Sort --> ab M elemente z.b. auf insertionSort springen
 *            --> Optimum für M = bei ca. 25 Elementen
 */
package ch.hslu.ad.sw09;