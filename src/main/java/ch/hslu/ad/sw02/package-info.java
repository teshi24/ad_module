/**
 * Modell einfach verkettete Liste
 * -------------------------------
 * class AllocationList extends Collection:
 *   - root: AllocationNode
 *   - size: int
 *   + push(allocation: Allocation) : void
 *   + pop() : Allocation
 *   + remove(allocation: Allocation) : void
 *   + contains(allocation: Allocation): boolean
 *   + size(): int
 *
 * class AllocationNode:
 *   - allocation; Allocation
 *   - nextNode: AllocationNode
 *   # get(): Allocation
 *   # getNextNode(): AllocationNode
 *   # setNextNode(allocation: Allocation): void
 *
 *
 *
 * Modellierung Schnitstelle für einen Stack, welcher Strings ernthalten kann (mit Array implementiert)
 * interface StringStack
 * + push(): void
 * + pop(): String
 *
 */
package ch.hslu.ad.sw02;