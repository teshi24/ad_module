/**
 * Aufgabe 1: (war mal ne Aufgabe bei der MEP)
 * - Lock-Pool und wait-pool müssen vom gleichen Objekt sein
 * - wait und notify dürfen nicht ausserhalb eines synchronized Blocks aufgerufen werden
 * -- man könnte auch das MyTask-Objekt locken, statt das LOCK, das ist aber nur die 2.-beste Läsung
 *
 * Aufgabe 2:
 * - 1. Latch -> hier gibt es einen Spezialfall, hier könnte man auch ein if-Aufruf machen
 * --> gibt nur ein open = false setzen bei einem neuen Latch (einmal offen, immer offen)
 * (while geht aber auch)
 *
 * synchornisierter Block mit synchronisierter Methode --> rentrance or nested monitor
 * -- rentrance monitor
 * --- heisst, der synchronisierte Abschnitt stellt lock pool und dann nochmals den release
 * --- gibt keinen Deadlock, aber Turf funktioniert auch nicht so ganz, Start kommt dann nicht immer richtig
 * --> es fehlt einen kurzen Moment, um auf die Zustandänderungen der Threads von "new" auf "ready" zu stellen
 * im main-Thread gibt es eine kurze Zeitverzögerung, um den Lock zu holen --> aber diese kurze Zeitverzögerung reicht nicht aus, um die Rennpferde zu starten
 *
 * private static final Object LOCK = new Object();
 * --> das ist gut, wenn die Klasse selber dieses LOCK-Pool handeln sollte, wenn es also ein globales Latch sein sollte
 * --> sonst müsste es halt doch besser ein final Object nur sein, wenn es mehrere Latches gibt
 * ----> für Pferderennen absolut perfekt
 * - deshalb kurz warten im main, bis die Pferde bereit sind
 * --> bei Thread sleep: grosse Unbekannte --> letzter Thread muss nach 500 ms ready sein => das ist eine Annahme, was gefährlich ist
 *
 * stattdessen müsste man wirklich auf die Pferde warten, bis sie bereit sind -> Flag in Latch
 *
 * mit notifyAll kriegen nicht alle gleichzeitig den LOCK, sondern nur 1, darum ist das Rennen nicht ganz fair,
 * aber das kann gar nicht anders gelöst werden
 *
 * Aufgabe 3:
 * Semaphore
 * limit = MAX_VALUE --> also eigentlich nach oben offenes Semaphore per Default
 * mit anderen Konstruktoren dann möglich ein eigenes Limit zu setzen
 *
 * 1 permit nacheinander ab arbeiten --> loop mit 1x pro permit die funktionen aquire / release aufrufen
 * achtung - sema + permits müssen zusammengezählt werden (siehe Doku wie ein Sema funktioniert)
 *
 */
package ch.hslu.ad.sw06;