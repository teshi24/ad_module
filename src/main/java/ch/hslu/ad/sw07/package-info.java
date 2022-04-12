/**
 * aus Besprechung:
 * PrimeChecker = 1 Thread, der so lange sucht, bis eine Primzahl gefunden wird
 * dann 100 Threads starten, so findet man 100 primzahlen
 *
 * Unterschied ExecutorService mit newCachedThreadPool vs newFixedThreadPool (availableProcessors() + 1)
 * --> 2. geht gut einen 3tel schneller
 * Handling mit der richtigen Anzahl Threads ist für den Scheduler einfacher als mit 100 Cached Threads
 * - auch weil der Rechner so immer 100%ig ausgelastet und der PrimeChecker kriegt so viele Ressourcen wie möglich
 *
 * ConcurentList - 1x LinkedBlockingQueue, einmal Synchronisierten Liste
 *
 * möglichst nicht mit geraden Zahlen testen, weil sonst die JWM zu viel optimiert
 *
 * Blocking Queue ist langsamer als Synchronized List - warum ist das so?
 * Blocking Queue ist deutlich komplexer als die synchronized list
 * --> weil ja je nach dem jemand warten muss (Consumer / Producer) - also schreiben und leeren ist gemischt und mehrere Producer / Reader möglich sind
 * --> wenn aber nur einer gleichzeitig zugreifen muss, sollte synchronized verwendet werden
 *
 *
 * Atomic Counter ist ca. ein 3tel schneller als beim SynchronizedCounter
 * --> das liegt daran, dass der AtomicCounter auf HW level schaltet und dadurch schneller ist
 *
 *
 * Diehl Trx org.multiverse.api.references.TxnInteger
 * --> atomicGet da auch möglich
 * mit StmUtils ist es nätig die atomic Bereiche zu definieren, um so den Bereich zu synchronisieren
 * --> vorallem gut im GameDesign, damit man hier atomar auf HW-Level schliessen kann, aber dass nicht jede Operation synchronisiert wird
 * --> dementsprechend muss halt multiverse package im pom hinzugefügt werden
 */
package ch.hslu.ad.sw07;