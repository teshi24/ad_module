package ch.hslu.ad.sw01;

/**
 * Input AD SW02 - Speicherverwaltung --> 2 Datenstrukturen, 1 zeigt freie Plätze an und die andere die belegten Stellen
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
    return address;
  }

  @Override
  public String toString() {
    return "Allocation[" + "address=" + address + "; sizeInBytes=" + sizeInBytes + ']';
  }
}
