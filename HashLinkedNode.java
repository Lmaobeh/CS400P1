import java.util.Iterator;
import java.util.LinkedList;
public class HashLinkedNode<KeyType, ValueType> extends Object{
  private ValueType data;
  private KeyType key;
  public HashLinkedNode(KeyType key, ValueType data) {
    this.data = data;
    this.key = key;
  }
  /**
   * @return the data
   */
  public ValueType getData() {
    return data;
  }
  /**
   * @param data the data to set
   */
  public void setData(ValueType data) {
    this.data = data;
  }
  /**
   * @return the key
   */
  public KeyType getKey() {
    return key;
  }
  /**
   * @param key the key to set
   */
  public void setKey(KeyType key) {
    this.key = key;
  }
  public static void main(String[] args) {
    LinkedList<HashLinkedNode<Integer,String>> l = new LinkedList<HashLinkedNode<Integer,String>>();
    l.add(new HashLinkedNode<Integer, String>(1, "string" ));
    l.add(new HashLinkedNode<Integer, String>(2, "hey"));
    
    LinkedList<HashLinkedNode<Integer, String>>[] n =(LinkedList<HashLinkedNode<Integer, String>>[]) new LinkedList[10];
    n[0] = l;
    Iterator<HashLinkedNode<Integer,String>> itr = n[0].iterator();
    while(itr.hasNext()){
      System.out.println(itr.next().getData());
    }
    
    
    
  }

}
