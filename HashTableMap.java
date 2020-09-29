// --== CS400 File Header Information ==--
// Name: Lucas Nguyen
// Email:lfnguyen@wisc.edu
// Team: NE
// TA: Daniel
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
//

import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.LinkedList;

public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
  private LinkedList<HashLinkedNode<KeyType, ValueType>>[] hashTable;
  private int capacity;
  private int size;
  private final static double LOAD_THRESHOLD = .8;

  public HashTableMap(int capacity) {
    this.capacity = capacity;

    hashTable = (LinkedList<HashLinkedNode<KeyType, ValueType>>[]) new LinkedList[this.capacity];
    this.size = 0;
  }

  public HashTableMap() {
    this.capacity = 10;
    hashTable = (LinkedList<HashLinkedNode<KeyType, ValueType>>[]) new LinkedList[this.capacity];
    this.size = 0;
  }// with default capacity = 10

  /**
   * Checks if the load factor is greater than or equal to 80%
   * 
   * @return true if it is greater, false if it is not.
   */
  private boolean checkLoadFactor() {
    return (double) size / (double) capacity >= LOAD_THRESHOLD;
  }

  private int hashFunction(KeyType key) {
    return (key.hashCode() & 0x7fffffff) % capacity;
  }

  private void resizeTable() {
    LinkedList<HashLinkedNode<KeyType, ValueType>>[] temp = hashTable;
    hashTable = (LinkedList<HashLinkedNode<KeyType, ValueType>>[]) new LinkedList[capacity *= 2];
    size = 0;
    for (int i = 0; i < temp.length; i++) {
      if (temp[i] == null)
        continue;
      for (HashLinkedNode<KeyType, ValueType> o : temp[i]) {
        this.put(o.getKey(), o.getData());
      }
    }

  }

  @Override
  public boolean put(KeyType key, ValueType value) {
    if (this.containsKey(key))
      return false;

    if (hashTable[hashFunction(key)] != null) {
      hashTable[hashFunction(key)].add(new HashLinkedNode<KeyType, ValueType>(key, value));
      size++;
      if (this.checkLoadFactor())
        this.resizeTable();
      return true;
    }
    hashTable[hashFunction(key)] = new LinkedList<HashLinkedNode<KeyType, ValueType>>();
    hashTable[hashFunction(key)].add(new HashLinkedNode<KeyType, ValueType>(key, value));
    size++;
    if (this.checkLoadFactor())
      this.resizeTable();
    return true;
  }
  
  

  @Override
  public ValueType get(KeyType key) throws NoSuchElementException {
    if (hashTable[hashFunction(key)] == null) {
      throw new NoSuchElementException();
    }
    for (HashLinkedNode<KeyType, ValueType> i : hashTable[hashFunction(key)]) {
      if (i.getKey().equals(key)) {
        return i.getData();
      }
    }
    throw new NoSuchElementException();
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean containsKey(KeyType key) {
    if (hashTable[hashFunction(key)] == null) {
      return false;
    }
    for (HashLinkedNode<KeyType, ValueType> i : hashTable[hashFunction(key)]) {
      if (i.getKey().equals(key)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public ValueType remove(KeyType key) {
    if (this.containsKey(key)) {
      for (HashLinkedNode<KeyType, ValueType> node : hashTable[hashFunction(key)]) {
        if (node.getKey().equals(key)) {
          size--;
          hashTable[hashFunction(key)].remove(node);
          return node.getData();
        }
      }
    }
    return null;
  }

  @Override
  public void clear() {
    hashTable = (LinkedList<HashLinkedNode<KeyType, ValueType>>[]) new LinkedList[this.capacity];
    size = 0;
  } 

  public static void main(String[] args) {
    HashTableMap<Integer, String> h = new HashTableMap<Integer, String>();
    h.put(8, "hello");
    h.put(7, "helli");
    h.put(88, "ey");
    h.put(3, "hey");
    h.put(5, "kek");
    System.out.println(h.size());
    h.put(7, "kek");
    // System.out.println(h.size());
    h.put(77, "kek2");
    h.put(888, "kek3"); 
    h.put(99999, "heh");
    System.out.println(h.size());
    System.out.println(h.capacity);
    h.put(7777777, "resize");
    System.out.println(h.capacity);
    System.out.println(h.get(7777777));
    h.remove(7777777);
    System.out.println(h.size());
    System.out.println(h.containsKey(7777777));

  }

}
