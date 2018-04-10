package Tries;

import sun.text.normalizer.Trie;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ajothomas on 3/16/17.
 */

class TrieNode{
    char value;
    HashMap <Character,TrieNode> children;
    boolean isCompleteWord;

    TrieNode(char value){
        this.value = value;
        this.children = new HashMap<>();
        this.isCompleteWord = false;
    }
    public HashMap<Character, TrieNode> getChildren() {
        return this.children;
    }

    public void put(char c) {
        children.put(c, new TrieNode(c));
    }
}

public class SampleTrie {
    public static void insert(TrieNode head, String word){
        TrieNode crawl = head;


        int wordLength = word.length();
        for(int i=0; i<wordLength; i++) {
            // extract current character
            char c = word.charAt(i);
            HashMap<Character, TrieNode> children = crawl.getChildren();
            // get the trienode corresponding to that
            if(children.containsKey(c)) {
                crawl = children.get(c);
            }
            else {
                TrieNode child = new TrieNode(c);
                children.put(c,child);
                crawl = children.get(c);
            }
        }
        // when the world is completed
        crawl.isCompleteWord = true;
    }

    public static void main(String args[]){
        TrieNode head = new TrieNode('*');
        String arr[] = {"cat","cats","dog","cart","card","cards"};


        for(int i=0; i<arr.length; i++){

        }


    }
}
