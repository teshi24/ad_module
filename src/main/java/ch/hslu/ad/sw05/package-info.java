/**
 * Infos von Besprechung
 *
 * Ball implements Runnable
 * Min Max radius & gravity, ausserdem random werte
 *
 * Ball vom Circle abgeleitet? what? keine musterlösung
 *
 * while (thread not interupted)
 *  ball visible
 *  while (ball nicht am ende)
 *    move nach unten mit gravity
 *  ball invisible
 * Thread interrupt ->  interrupten um Thread zu beenden
 *
 * new Thread(ball)
 *
 * --> flackern wegen dem sheduler, der hat dann anderes zu tun
 *
 *
 * Bankaufgabe --> Anliegen von Roger Diehl --> die absolut wichtigste Aufgabe
 * weil grösster Effekt
 * -> deposit und transfer gab es noch keine synchronisation, daher gab es einen Konflikt
 * --> nicht die ganze Methode Synchornisieren sondern nur den kritischen Teil, sonst gibt es einen Dead-Lock
 *     (wegen den Nested Montiores)
 * --> this und target sind 2 verschiedene this synchronisiert --> beide haben ein andenderen lock-pool, das blockiert dann
 * ---> deposit muss ein offener Aurfruf sein (nicht synchronized!)
 * --> neben nebenläufigkeit wird ausserdem auch ein bisschen besser
 *
 * tüpfelchen auf dem I wäre ein eigenes Objekt für den Lockpool und nicht this
 *
 * synchronized (AccountTask.class) statt this.balance
 * und dann den aufruf des anderen Abschnitt zu schützen
 * --> ist dann ein statischer Lock über die Klasse
 * --> Nachteil: dann muss ich ja jeden Aufruf synchronizen
 * --> das ist dann ein reentrend Monitor -> weil man da in 2 synchronisierte Abschnitte ineinander kommt mit dem gleichen Lockpool
 * ----> Zufälligerweise geschützt, weil AccountTask systemweit geschützt ist -> damit Nebenläufigkeit eigentlich ausgeschaltet
 * -> die Klasse gibts ja nur einmal, Objekte gibt es ja mehrere dann
 *
 * sleep() kann InterruptedException generieren -> wir brauchen hier mind ein LOG im catch
 * anzahl Addtitionen wurden erhöht, dann wurde festgestellt, ein interrupt wird gesendet, aber ist nicht rechtzeitig aufgetreten
 *
 * interruptFlag wird wieder zurückgesetzt
 *
 * join and sleep
 * --> wenn Threads von aussen nicht abgebrochen wird, braucht es nicht nochmal ein intterupt()
 * --> Empfehlung von Roger Diehl: Wenn catch InterruptedException catcht immer im catch Thread.currentThread().interrupt(); aufrufen, damit das Flag sicher richtig gesetzt ist.
 *
 * --> wenn auf einen Thread gewartet wird könnte man sagen "wenn Objects.nonNull() abfragt, könnte man auch noch !threadToWaitFor.isAlive() checken
 *
 */
package ch.hslu.ad.sw05;