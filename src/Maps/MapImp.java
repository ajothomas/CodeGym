package Maps;

/**
 * Created by ajothomas on 3/17/17.
 */

class MyEntry {
    private int key;
    private int value;
    private MyEntry next;

    MyEntry(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public int getKey(){
        return this.key;
    }

    public int getValue(){
        return this.value;
    }

    public MyEntry getNext(){
        return (MyEntry)this.next;
    }

    public void setNext(MyEntry entry){
        this.next = entry;
    }
}

class MyMap {
    private int size;
    MyEntry[] mapArr;

    MyMap(int size){
        this.size = size;
        mapArr = new MyEntry[size];
        for(int i=0; i<size; i++)
            mapArr[i] = null;
    }

    int hashCode(int key){
        int index=0;
        if(key>=0){
            index = (key)*999 % size;
        }
        else
         return 0;

        return index;
    }

    void set(int key, int value){
        int index = hashCode(key);
        if(mapArr[index]==null){
            mapArr[index] = new MyEntry(key, value);
        }
        else {
            MyEntry curr = mapArr[index];
            while(curr.getNext()!=null)
                curr = curr.getNext();

            curr.setNext(new MyEntry(key, value));
        }
    }

    int get(int key){
        int index = hashCode(key);
        if(mapArr[index]==null)
            return -1;
        else {
            MyEntry curr = mapArr[index];
            while(curr.getNext()!=null && curr.getKey() != key)
                curr = curr.getNext();

            if(curr.getKey() == key)
                return curr.getValue();

            return -1;
        }
    }
}
public class MapImp {
}
