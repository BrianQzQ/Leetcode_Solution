import java.util.*;

class LRUCache {
    //PriorityQueue<Integer>queue;
    LinkedHashMap<Integer, Map.Entry<Integer,Integer>>p;

    int CAPACITY=0;
    List<Integer>l;
    Map<Integer,Integer>m;
    int size;
    public LRUCache(int capacity) {
        //queue=new PriorityQueue<>(capacity);
        p=new LinkedHashMap<>();
        l=new ArrayList<>();
        m=new HashMap<>();
        CAPACITY=capacity;
        size=0;
    }

    public int get(int key) {
        int a=m.getOrDefault(key,-1);
        if(a==-1)return -1;
        else{
            l.remove((Integer)key);

            l.add(key);
            return a;
        }
    }

    public void put(int key, int value) {
      if(m.containsKey(key)){
          m.put(key,value);
          get(key);
      }
      else if(size<CAPACITY){
          m.put(key,value);
          l.add(key);
          size++;
      }
      else{
          int a=l.remove(0);
          m.remove(a);
          l.add(key);
          m.put(key,value);
      }


    }

}