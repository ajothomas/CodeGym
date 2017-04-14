package Tries;

import sun.text.normalizer.Trie;

import java.util.HashMap;

/**
 * Created by ajothomas on 3/16/17.
 */

class TrieNode{
    char value;
    HashMap <Character, TrieNode> children;
    boolean isCompleteWord;

    TrieNode(char value){
        this.value = value;
        this.children = new HashMap<Character, TrieNode>();
        this.isCompleteWord = false;
    }

    public void putNode(char c){
        TrieNode temp = new TrieNode(c);
        this.children.put(c, temp);
    }

    public TrieNode getNode(char c){
        return (TrieNode) children.get(c);
    }

    public boolean checkNode(char c){
        return  children.containsKey(c);
    }
}

public class SampleTrie {
    public static void insert(TrieNode head, String word){

        TrieNode crawl = head;

        for(int j=0; j<word.length(); j++){
            char currChar = word.charAt(j);
            if(crawl.checkNode(currChar))
                crawl = crawl.getNode(currChar);
            else {
                crawl.putNode(currChar);
            }
        }
    }

    public static void main(String args[]){
        TrieNode head = new TrieNode('*');
        String arr[] = {"cat","cats","dog","cart","card","cards"};



        for(int i=0; i<arr.length; i++){

        }


    }
}
