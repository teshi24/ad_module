/**
 * D2, A1:
 * a) Wurzel:                       a
 * b) Blätter:                      e, e, g, k, i
 * c) innere Knoten (Grad):         a (3) --> Wurzel ist auch ein innerer Knoten! b (3), c (0), d (2), h (1), j (1)
 * d) Niveau Knoten d:              Niveau 1
 * e) Anzahl Knoten auf Niveau 2:   5
 * f) Tiefe Knoten j:               3
 * g) Höhe vom Baum:                5
 * h) Ordnung vom Baum:             mind. 3
 * i) der Baum ist nicht ausgeglichen, da er nicht der folgenden Definition entspricht:
 * Ein Baum ist ausgeglichen, wenn sich die Höhen des linken und des rechten Teilbaumes jedes Knoten um maximal 1
 * unterscheiden.
 * z.B: Der linke Teilbaum vom Knoten d hat die Höhe 4, während der rechte Teilbaum nur die Höhe 2 hat, die Differenz
 * beträgt somit mindestens an einer Stelle 2 (> 1).
 *
 *
 *
 *
 *
 * D2, A2:
 * Binäre Bäume:
 * Beispiel:
 *                                       16
 *                    8                                      24
 *          4                  12                  20                  28
 *     2         6        10        14        18        22        26        30
 *   1   3     5   7     9  11    13  15    17  19    21  23    25  27    29  31
 *
 * a) Anzahl Wurzeln:                         1
 * b) Ordnung binäre Bäume:                   2
 * c) Minimale Anzahl Niveaus für 31 Knoten:  5
 *    Minimale Anzahl Niveaus = ld (Anzahl Knoten + 1) = ld(32) = 5
 * d) Maximale Anzahl Niveaus für 31 Knoten: 31
 *    Maximale Anzahl Niveaus = Anzahl Knoten = 31
 * e) Maximale Anzahl Knoten pro Niveau: (2^Niveau)
 *    N0:  1
 *    N1:  2
 *    N3:  4
 *    N4:  8
 *    N5: 16
 * f) voll = letztes Niveau rechts / links ausgerichtet, alle anderen Niveaus sind maximal gefüllt
 *    Binärer, voller Baum (links ausgerichtet
 *            4
 *        2       5
 *      1   3
 * g) (Allerbester Fall: Wurzel --> O(1))
 *    Suchaufwand im besten Fall (Baum ausgeglichen / balanciert): ld(n) -> O(ld n)
 *    Suchaufwand im schlechtesten Fall (Baum unausgeglichen => zur Liste degeneriert): n -> O(n)
 *
 *
 * D2, A3:
 * Binäre Suchbäume
 * a) für 15 Datenelemente brauchen wir mind. 4 Niveaus (log2(15 + 1) = 4)
 *    --> dann ist der Füllgrad des Baumes vollständig, resp. komplett
 *
 * b)
 *                         H
 *                 D               L
 *             B       F       J       N
 *           A   C   E   G   I   K   M   O
 *
 *
 * c) H != N --> H < N --> rechts
 *    L != N --> L < N --> rechts
 *    N == N
 *
 *    H != K --> H < K --> rechts
 *    L != K --> L > K --> links
 *    J != K --> J < K --> rechts
 *    K == K
 *
 *    H != O --> H < O --> rechts
 *    L != O --> L < O --> rechts
 *    N != O --> N < O --> rechts
 *    O == O
 *
 * d)
 *                     G
 *            B                 H
 *      A           F
 *                 E
 *                D
 *               C
 *
 * e) --> eine Liste
 *      A
 *        B
 *          C
 *            D
 *              E
 *                F
 *                  G
 *                    H
 *
 * f) Bei der Inorder-Traversierung folgt man der Sortierung
 * g)   traverse_inorder(Knoten k) {
 *         if (k == null) {
 *           log('endOfPath');
 *           return;
 *         }
 *         log('traverse ': k.getValue());
 *         traverse_inorder(k.getLeftChild());
 *         handle(k);
 *         traverse_inorder(k.getRightChild());
 *      }
 *      handle(Knoten k) {
 *        log('--> handle': k.getValue());
 *      }
 *
 *      Output b)            Output d)            Output e)
 *      traverse H           traverse G           traverse A
 *      traverse D           traverse B           endOfPath
 *      traverse B           traverse A           --> handle A
 *      traverse A           endOfPath            traverse B
 *      endOfPath            --> handle A         endOfPath
 *      --> handle A         endOfPath            --> handle B
 *      endOfPath            --> handle B         traverse C
 *      --> handle B         traverse F           endOfPath
 *      traverse C           traverse E           --> handle C
 *      endOfPath            traverse D           traverse D
 *      --> handle C         traverse C           endOfPath
 *      endOfPath            endOfPath            --> handle D
 *      traverse F           --> handle C         traverse E
 *      traverse E           endOfPath            endOfPath
 *      ....                 ...                  ...
 *
 *
 *
 *
 */
package ch.hslu.ad.sw03;