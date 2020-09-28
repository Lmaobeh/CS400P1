import java.util.NoSuchElementException;

// Name: Sam Hossain
// Email: sdhossain@wisc.edu
// Team: NE
// TA: Daniel Finer
// Lecturer: Florian Heimerl
public class HashTableMapOne implements MapADT<String, User>{
    
    private int capacity;
    private LinkedKeys[] hashTable;
    private int size;
    
/**
 * Helper class for the hashTable implementation
 * @author samhossain
 *
 */
public class LinkedKeys {
    private KeyNode head;
    

    public class KeyNode{
        private String key;
        private User val;
        private KeyNode next;
        public KeyNode(String key, User val, KeyNode next) {
            this.key = key;
            this.val = val;
            this.next = next;             
        }
        public KeyNode(String key, User val) {
            this.key = key;
            this.val = val;
        }
        
        public String getKey() {
            return key;
        }
        
        public User getVal() {
            return val;
        }      
    }
    
    public LinkedKeys(String key, User val) {
        head = new KeyNode(key, val);
    }
    public LinkedKeys() {
        head = null;
    }
    
    public boolean insert(String key, User val) {
        KeyNode node = new KeyNode(key, val);
        if (head == null)
            head = node;
        
        KeyNode temp = head;
        while(temp != null) {
            if (temp.getKey().equals(key))
                return false;
            if (temp.next != null)
                temp = temp.next;
            else {
                temp.next = node;
                break;
            }
        }
        return true;
    }
    
    public User remove(String key) {
        if (head == null)
            return null;
        KeyNode temp = head;
        User ret = null;
        if (temp.getKey().equals(key)) { //checks if the head was what is getting removed
            ret = head.val;
            head = head.next;
            return ret;
        }
        
        while (temp.next != null) { //iterate through list to check if next is key
            if (temp.next.getKey().equals(key))
                if (temp.next.next == null) {
                    ret = temp.next.val;
                    temp.next = null;
                    return ret;
                    }
                else {
                    ret = temp.next.val;
                    temp.next = temp.next.next;
                    return ret;
                    }
            temp = temp.next;    
        }
        return null;
    }
    
    public User get(String key) {
        KeyNode temp = head;
        while (temp != null) {
            if (temp.getKey().equals(key))
                return temp.getVal();
            temp = temp.next;

        }
        return null;
    }
    
    public boolean contains(String key) {
        KeyNode temp = head;
        if (temp == null)
            return false;
        
        while (temp != null) {
            if (temp.getKey().equals(key))
                return true;
            temp = temp.next;
        }
        return false;
    }

}

    








    /**
     * Constructs table
     * @param capacity
     */
    public HashTableMapOne(int capacity) {
        hashTable = new LinkedKeys[capacity];
        this.capacity = capacity;
        size = 0;
    }
    
    public HashTableMapOne() {
        hashTable = new LinkedKeys[10];
        this.capacity = 10;
        size = 0;
    }
    /**
     * private method to resize our table
     * will creaate new refrence and add all old K,V pairs into new table with
     * new capacity
     */
    private void resize(){
        capacity *= 2;
        LinkedKeys[] update = new LinkedKeys[capacity];
        
        for(int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] == null)
                continue;
            
            HashTableMapOne.LinkedKeys.KeyNode temp = hashTable[i].head;
            while (temp != null) {
                if (update[Math.abs(temp.getKey().hashCode()%capacity)] == null)
                    update[Math.abs(temp.getKey().hashCode()%capacity)] = new LinkedKeys(temp.getKey(), temp.getVal());
                else
                    update[Math.abs(temp.getKey().hashCode()%capacity)].insert(temp.getKey(), temp.getVal());
                
                temp = temp.next;
            }
            
        } 
            
        
        hashTable = update;
    }
    
    /**
     * puts a given key value pair into our table, given the key is not already
     * present
     * @param key, and its associated value
     * @return true if able to put in K, V false otherwise
     */
    public boolean put(String key, User value) {
        double s = size;
        double cap = capacity;
        if (s >= .8*(cap)) //check if we are at capicity
            resize();
        
        if (hashTable[Math.abs(key.hashCode()%capacity)] == null) {
            hashTable[Math.abs(key.hashCode()%capacity)] = new LinkedKeys(key, value);
            size++;
            return true;
        } 
        else if (hashTable[Math.abs(key.hashCode()%capacity)].insert(key, value)) { 
            //our LinkedKeys insert will return true if sucessfully inserted
             size++;
             return true;
    }
        return false;

    }

    /**
     * finds the object associated with the key given as input
     * @param key, of the value we are trying to find
     * @throws NoSuchElementException if key not in table
     * @return Object if found 
     */
    public User get(String key) throws NoSuchElementException {
        if (!containsKey(key))
            throw new NoSuchElementException();
        //System.out.println(hashTable[Math.abs(key.hashCode()%capacity)].get(key));
        return hashTable[Math.abs(key.hashCode()%capacity)].get(key);
    }

    /**
     * @return int number of elements present
     */
    public int size() {
        return size;
    }

    /**
     * Checks if a key is present by first checking the index of the hash then
     * iterating through the linked list
     * @param key, of the value we are trying to find
     * @return boolean true if found false else
     */
    public boolean containsKey(String key) {
        if (hashTable[Math.abs(key.hashCode()%capacity)] == null)
            return false;
        
        return hashTable[Math.abs(key.hashCode()%capacity)].contains(key);
        
    }

   /**
    * Removes object associated with a given key
    * @param key, of the value we are trying to find
    * @return Object if found, null else
    */
    public User remove(String key) {
        if (containsKey(key)) {
            size--;
            return hashTable[Math.abs(key.hashCode()%capacity)].remove(key);
        }
        return null;
        
    }

   /**
    * Clears the current hashTable and creates a new one with with current cap
    */
    public void clear() {
        hashTable = new LinkedKeys[capacity];
        size = 0;
    }    
}

