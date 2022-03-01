package ch.hslu.ad.sw01;

import java.util.Objects;

/**
 * Input AD SW02 --> 2 Datenstrukturen, 1 zeigt freie Plätze an und die andere die belegten Stellen
 * effizient in Speicher schreiben will --> soll ja effizient sein, also fortlaufend, können so arithmetisch startposition wählen
 * -> Fragmentierung gäbe noch freie Plätze, das heisst mehr Objekte zum Verwalten
 *
 * --> Kinoproblematik: 10er Gruppe, kann man nicht in Lücken reinhüpfen
 * --> Kann auch Gruppen nicht verschoben werden, der muss freigegeben werden und wieder neu alloziieren
 *    --> wenn sonst diese Speicheradressen von einem Programm verwendet werden, wäre das recht mühsam
 *
 * --> wenn Block zwischen 2 Lücken gelöscht werden, sollen diese Plätze verschmolzen werden
 *     --> die Verschmelzung braucht aber Zeit, darum wird die Verschmelzung nicht bei der Speicherfreigabe gemacht,
 *         sondern bei einer erneuten Abfrage, die eine zu grosse Speicherplatzanforderung stellt (kein so grosser Platz mehr vorhanden)
 *         (Free muss ganz schnell sein)
 *
 *
 * Belegt - soll nach Adressen sortiert sein --> dann kann man nach ""
 * Frei - soll nach Grösse sortiert sein --> fürs schnellen Suchen einer entsprechend grossen Speicherstelle
 *  --> Versuch nach Verschmelzung wird schneller, wenn man die grössten zuerst nimmt
 *
 *  Reihenfolge und Sortierung
 *  - Reine Sammlung, einzelne Elemente ungeordnet abgelegt, Reihenfolge nicht deterministisch
 *    (Steinhaufen)
 *    --> Einfügen ist sehr schnell
 *    --> dafür Suche ineffizient / unbrauchbar
 *  - Elemente in bestimmter Reihenfolge (Folge des Einfügens), die dann diese implizit beibehalten
 *    (Stapel Bücher)
 *    --> Einfügen ist sehr schnell
 *    --> dafür Suche ineffizient / unbrauchbar
 *  - Datenstrukturen mit Sortierung (typisch beim einfügen)
 *    (Vollautomatisches Hochregallager)
 *    --> Einfügen nicht so schnell
 *    --> dafür Suche sehr effizient
 *
 *  Operationen auf Datenstrukturen
 *  elementar:
 *  - Einfügen
 *  - Suchen
 *  - Entfernen
 *  - Ersetzen (auch mit Entfernen und Einfügen realisierbar)
 *
 *  zusätzlich: abhängig von Reihenfolge / Sortierung
 *  - Nachfolger
 *  - Vorgänger
 *  - Sortierung
 *  - Maxima / Minima
 *
 *  Statisch / Dynamische Datenstruktur
 *  - statisch, nach Initialisierung Grösse unveränderlich, kann nur beschränkte Anzahl Elemente aufnehmen
 *    (Getränkeflasche)
 *    --> typischerweise schneller, dafür Platzintensiv, auch wenn leer
 *  - dynamisch, nach Initialisierung Grössenveränderbar
 *    (Luftballon)
 *    --> dynamik kostet Zeit, dafür Speichereffizient
 *
 *  Explizite / implizite Beziehungen
 *  - Beziehung explizit mit Referenzen festgehalten
 *    (Fahrradkette)
 *  - Beziehung implizit, von aussen extern nummeriert, aber die Elemente kennen die Nachbarn nicht
 *    (Büecherregal)
 *
 *  Direkter / indirekter resp. sequenzieller Zugriff
 *  - direkten Zugriff
 *    (Festplatte, Bücherregal, Bandlaufwerk, Kassetten)
 *  - indirekter Zugriff über nachfolge
 *
 *  Aufwand von Operationen
 *  Aufwand von Rechen- oder Speicherkomplexität variiert, meist interessiert uns aber nur die Ordnung
 *  --> O(n) und so weiter --> uns interessiert nämlich nur, was passiert, wenn man viele Dinge hinzufügt
 *  --> aber Achtung, O(1) heisst nicht, das ist super schnell, sondern einfach nur dass der Aufwand konstant ist
 *
 *  Binäres Suchen --> immer Halbieren und dann nur noch in der Hälfte suchen suchen
 */
public final class Allocation implements Comparable<Allocation> {
  private final int address;
  private final int sizeInBytes;

  public Allocation(final int address, final int sizeInBytes) {
    this.address = address;
    this.sizeInBytes = sizeInBytes;
  }

  @Override
  public int compareTo(final Allocation allocation) {
    if (this == allocation) {
      return 0;
    }
    return Integer.compare(address, allocation.address);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o instanceof Allocation allocation) {
      return address == allocation.address;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(address);
  }

  @Override
  public String toString() {
    return "Allocation[" + "address=" + address + "; sizeInBytes=" + sizeInBytes + ']';
  }
}
