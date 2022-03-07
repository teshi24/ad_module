/**
 * Kriterien für Beurteilung von Datenstrukturen:
 * ------------------------------------------------
 * Reihenfolge und Sortierung
 * - Reine Sammlung, einzelne Elemente ungeordnet abgelegt, Reihenfolge nicht deterministisch
 * (Steinhaufen)
 * --> Einfügen ist sehr schnell
 * --> dafür Suche ineffizient / unbrauchbar
 * - Elemente in bestimmter Reihenfolge (Folge des Einfügens), die dann diese implizit beibehalten
 * (Stapel Bücher)
 * --> Einfügen ist sehr schnell
 * --> dafür Suche ineffizient / unbrauchbar
 * - Datenstrukturen mit Sortierung (typisch beim einfügen)
 * (Vollautomatisches Hochregallager)
 * --> Einfügen nicht so schnell
 * --> dafür Suche sehr effizient
 *
 * Operationen auf Datenstrukturen
 * elementar:
 * - Einfügen
 * - Suchen
 * - Entfernen
 * - Ersetzen (auch mit Entfernen und Einfügen realisierbar)
 *
 * zusätzlich: abhängig von Reihenfolge / Sortierung
 * - Nachfolger
 * - Vorgänger
 * - Sortierung
 * - Maxima / Minima
 *
 * Statisch / Dynamische Datenstruktur
 * - statisch, nach Initialisierung Grösse unveränderlich, kann nur beschränkte Anzahl Elemente aufnehmen
 * (Getränkeflasche)
 * --> typischerweise schneller, dafür Platzintensiv, auch wenn leer
 * - dynamisch, nach Initialisierung Grössenveränderbar
 * (Luftballon)
 * --> dynamik kostet Zeit, dafür Speichereffizient
 *
 * Explizite / implizite Beziehungen
 * - Beziehung explizit mit Referenzen festgehalten
 * (Fahrradkette)
 * - Beziehung implizit, von aussen extern nummeriert, aber die Elemente kennen die Nachbarn nicht
 * (Büecherregal)
 *
 * Direkter / indirekter resp. sequenzieller Zugriff
 * - direkten Zugriff
 * (Festplatte, Bücherregal, Bandlaufwerk, Kassetten)
 * - indirekter Zugriff über nachfolge
 *
 * Aufwand von Operationen
 * Aufwand von Rechen- oder Speicherkomplexität variiert, meist interessiert uns aber nur die Ordnung
 * --> O(n) und so weiter --> uns interessiert nämlich nur, was passiert, wenn man viele Dinge hinzufügt
 * --> aber Achtung, O(1) heisst nicht, das ist super schnell, sondern einfach nur dass der Aufwand konstant ist
 *
 * Binäres Suchen --> immer Halbieren und dann nur noch in der Hälfte suchen suchen
 *
 *
 * SW01, E1 file:///D:/OneDrive%20-%20Hochschule%20Luzern/AD/Modulunterlagen/SW01%20-%20KW08%20-%20[E0]%20E1/E1_EX_Einfuehrung.pdf
 * ----------------
 * A3 - Ordnung
 * a)
 * |  log n  |   ld n  |  n  |  n log n  |   n^2  |    n^3    |      2^n     |      3^n     |       n!      |
 * | 0       | 0       |   1 |   0       |      1 |         1 |            2 |            3 |             1 |
 * | 0.30103 | 1       |   2 |   0.60206 |      4 |         8 |            4 |            9 |             2 |
 * | 0.69897 | 2.32193 |   5 |   3.49485 |     25 |       125 |           32 |          243 |           120 |
 * | 1       | 3.32193 |  10 |  10       |    100 |     1 000 |        1 024 |       59 049 |     3 628 800 |
 * | 1.30103 | 4.32193 |  20 |  26.0206  |    400 |     8 000 |    1 048 576 | 3.48 * 10^ 9 | 2.43 * 10^ 18 |
 * | 1.69897 | 5.64386 |  50 |  84.9485  |  2 500 |   125 000 | 1.13 * 10^15 | 7.18 * 10^23 | 3.04 *  e^ 64 |
 * | 2       | 6.64386 | 100 | 200       | 10 000 | 1 000 000 | 1.26 * 10^30 | 5.15 *  e^47 | 9.33 *  e^157 |
 *
 * b) Bestimmen Sie von folgenden Funktionen deren Ordnung:
 * (1) f(n) = n^3 + 0.1·2^n           -> O(2^n) - exponential
 * (2) f(n) = 5326 + ln(n)            -> O(ln(n)) - logarithmisch
 * (3) f(n) = 2 + 37 n^3 + 0.01 n^4   -> O(n^4) - potenz
 * (4) f(n) = 1000 n + n^3            -> O(n^3) - potenz
 * (5) f(n) = n^7 + n!                -> O(n!) - fakultät
 * (6) f(n) = ln(n) + 1000·n          -> O(n) - nominal
 *
 * c) Ordnen Sie die resultierenden Ordnungen von b) gemäss ihrer Wachstumsrate, d.h. zuerst die
 *    kleinste, dann aufsteigend die grösseren.
 *    O(ln(n)) < O(n) < O(n^3) < O(n^4) < O(2^n) < O(n!)
 *
 * d) Die Rechenzeit t betrage jeweils 0.1s, und zwar bei drei verschiedenen Algorithmen im Falle von
 *    n = 10'000. Für dieses n verhalten sich die drei Algorithmen gemäss ihrer Ordnung. Geben Sie an,
 *    was für Rechenzeiten für n = 100'000 etwa zu erwarten sind?
 *    --> 10x so viel
 *    (1) O(1)        ->  0.1s
 *    (2) O(n^2)      -> 10  s   weil: 0.1s = x * 10'000^2
 *                                        x = 0.1s / 10'000^2
 *                                        y = x * 100'000^2 = 0.1s / 10'000^2 * 100'000^2 = 0.1s * 100 = 10s
 *                                        --> (100'000/10'000)^2 --> 10^2 = 100 --> 100 * 0.1s = 10
 *    (3) O(n log n)  ->  Achtung, logikfehler: faktor vom resultat nehmen, nicht von rg 1  s   weil: 10 log 10 = 10 --> 10 * 0.1s = 1s
 *                    -->   100/m * log(100/m) geteilt durch 10/m * log (10/m) => faktor von 12.5 --> 1.25s
 *
 * e) Zeigen Sie auf, weshalb bei O(logB n) der Wert der Basis keine Rolle spielt. Tipp: Wie lässt sich
 *    schon wieder der Logarithmuswert für eine beliebige Basis B ausrechnen?
 *    https://alda.iwr.uni-heidelberg.de/index.php/Effizienz
 *     a, b > 1
 *     logA(x) E O(logB(x))
 *     Die Basis des Logarithmus spielt also keine Rolle.
 *     Beweis hierfür:
 *      Basiswechsel --> logA(x) = logB(x)/logB(a)
 *      Mit c = 1/logB(a), gilt: logA(x) = c logB(x).
 *      Wird hier die (zweite) Regel für Multiplikation mit einer Konstanten angewendet, fällt der konstante Faktor weg, also logA(x) E O(logB(x)).
 *      Insbesondere gilt auch logA(x) E O(log2(x)), es kann also immer der 2er Logarithmus verwendet werden.
 *
 * f) doA = doB = O(1)
 *    doC(n) = O(n)
 *    doD(n) = O(n^2)
 *    1 -> doA + doB + doC(n) = 2 O(1) + O(n) = O(n)
 *    2 -> doA*n + doC(5)*2n = n O(1) + 2n * O(1) = O(n) + 2 * O(n) = O(n)
 *    3 -> doA*n + doC(n)*n*n = n O(1) + O(n) * n^2 = O(n) + O(n^3) = O(n^3)
 *    4 -> doD(n)*n + doA*n*(n+5) = O(n^2) * n + O(1) * (n^2 + 5n) = O(n^3) + O(n^2) + 5 O(n) = O(n^3)
 *
 */
package ch.hslu.ad.sw01;