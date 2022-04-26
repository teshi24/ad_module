/**
 * Aufgabe 1 - Grundlegende Zusammenhänge
 * 1.3
 * a) Triangle Klasse - Dreieck-Objekte, definiert durch 3 Eckpunkte (x/y)-Koordinaten
 *    Mögliche Totale Ordnungen:
 *    - Fläche absteigend, aufsteigend (kann mit den Eckpunkten berechnet werden)
 *    - Umfang / längste Seite, kürzeste Seite
 *    - Punkte - Entfernung vom Ursprung des Koordinatensystem
 *    - evtl. Tiefstes Dreieck bis Höhestes Dreieck / Dreiecke von Links nach Rechts im Koordinatensystem
 *    - Vorgeschlagene natürliche Ordnung: sortieren nach Fläche von Kleinstem zum Grössten
 *      Note: dann muss in der Dok einfach erwähnt werden, dass die natürliche Ordnung nicht zwingend equals entspricht!
 * b) Triangle muss {@link java.lang.Comparable<Triangle>} implementieren und damit compareTo
 *    Parameter:    Triangle triangle - ein Triangle Objekt (sichergestellt durch Typing beim importieren
 *    Rückgabewert: int
 *                  -> negative integer = this object is less than given object
 *                  -> zero = this object is equal to given object
 *                  -> positive integer = this object is greater than given object
 *    Expectations: - signum(x.compareTo(y)) == -signum(y.compareTo(x)) is always true
 *                  - when x.compareTo(y) throws an Exception, y.compareTo(x) throws an exception as well
 *                  - (x.compareTo(y) > 0 && y.compareTo(z) > 0) implies that x.compareTo(z) > 0.
 *                  - x.compareTo(y)==0 implies that signum(x.compareTo(z)) == signum(y.compareTo(z)), for all z.
 *                  - strongly recommended but not strictly required that (x.compareTo(y)==0) == (x.equals(y))
 *                    - if not, it must be indicated, e.g. "Note: this class has a natural ordering that is inconsistent with equals."
 *    Exceptions: - NullPointerException – if the specified object is null
 *                - ClassCastException – if the specified object's type prevents it from being compared to this object.
 * c) neben equals() muss hashCode() überschrieben werden (beides Methoden von {@link java.lang.Object}
 * d) für die spezielle Ordnung muss {@link java.util.Comparator<Triangle>} implementiert werden
 *    -> zur Implementation würde ich eine statische Variable machen mit einem lambda-Comparator
 *    @see <a href="https://www.baeldung.com/java-8-sort-lambda#sort-lambda">Java 8 sort lambda</a>
 * e) von {@link java.util.Arrays} würden sich folgende Methoden für das Sortieren eignen:
 *    - {@link java.util.Arrays#sort(java.lang.Object[])}
 *      -> Sorts the specified array of objects into ascending order, according to the natural ordering of its elements.
 *    - {@link java.util.Arrays#sort(java.lang.Object[], int, int)} )}
 *      -> Sorts the specified range of the specified array of objects into ascending order, according to the natural ordering of its elements.
 *    - {@link java.util.Arrays#sort(java.lang.Object[], java.util.Comparator)}
 *      -> Sorts the specified array of objects according to the order induced by the specified comparator.
 *    - {@link java.util.Arrays#sort(java.lang.Object[], int, int, java.util.Comparator)}
 *      -> Sorts the specified range of the specified array of objects according to the order induced by the specified comparator.
 *    -> alle sind stabile, iterative mergesorts
 *
 * Aufgabe 2 - Entscheidungsbaum
 * 2.3
 * geg: n = 3
 *
 * a)                                         D1 < D2
 *              D2 < D3                                      D1 < D3
 *    [D1, D2, D3]             D1 < D3             [D2, D1, D3]             D2 < D3
 *                   [D1, D3, D2]   [D3, D1, D2]                  [D2, D3, D1]   [D3, D2, D1]
 *
 *
 * a2)                                        D1 < D2
 *              D2 < D3                                                     D2 < D3
 *    [D1, D2, D3]             D1 < D3                       D1 < D3             [D3, D2, D1]
 *                  [D1, D3, D2]    [D3, D1, D2]   [D2, D1, D3]   [D2, D3, D1]
 *
 *
 * b) B Blätter = 6
 *    h Höhe    = 4
 *    h >= ld(B) + 1
 *    4 >= ld(6) + 1
 *    4 >= 2.585 + 1
 *    4 >= 3.585     --> korrekt
 *
 * c) AS mögliche Ausgangssituationen = n! = 3! = 6
 *    mind. Anzahl Vergleiche für alle AS = t Tiefe des Baumes = 3
 *
 * A4 - Direktes Auswählen
 * 4.3
 * b)                    [8(1),    5, 8(2),    1]
 *    1 kleinster ->     [   1,    5, 8(2), 8(1)]
 *    sortiert gemäss Kriterien, aber das 1. 8 ist nach der 2. 8
 * c) nein, die Unterscheidung zwischen Best Case, Worst Case und Average Case ist nicht sinnvoll beim
 *    direkten Auswählen. Egal, wie die Anordnung ist, es muss immer der gesamte unsortierte Array durchsucht werden,
 *    um den kleinsten Schlüssel zu finden. Die Aufwände für die Verschiebungen, die die Cases noch unterscheiden,
 *    sind verhältnismässig klein und daher vernachlässigbar.
 *
 *
 *
 *
 *
 *   Aus Repetition in Woche 9
 *    Stabile Sortieralgorithmen:
 *    - Insertion Sort
 *    - Bubble Sort
 *
 *    Instabile Sortieralgorithmen:
 *    - Selection Sort
 *    - Shell Sort
 *
 *    --> also halt wenn man über grössere Distanzen vertauscht, ohne die Daten dazwischen zu berücksichtigen
 *        ist die Stabilität nicht mehr fix gewährleistet
 *
 *   Vergleichsbasierte Sortieralgorithmen besitzen bestenfalls (ohne Nebenläufigkeit) die Zeitkomplexität
 *   O(n * log(n)) oder O(n * ld(n))
 *
 */
package ch.hslu.ad.sw08;