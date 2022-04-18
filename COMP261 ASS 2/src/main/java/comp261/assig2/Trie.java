package comp261.assig2;


import java.util.*;

/**
 * This is an implementation of a trie, used for the search box.
 */

public class Trie {
	public TrieNode root = new TrieNode(); // the root node of the trie

	public Trie() {
	}

	/**
	 * Adds a given stop to the Trie.
	 */
	public void add(Stop stop) {
		// TODO
		// write the code to add a stop object into the trie
		int level;
		int length=stop.getName().length();
		int index;
		TrieNode traverse= root;

		for (char c:stop.getName().toCharArray()){
			if(!traverse.children.containsKey(c)){
				traverse.children.put(c,new TrieNode());
				traverse.data.add(stop);
			}
			
			traverse=traverse.children.get(c);
			
		}

		// END of TODO
	}

	/**
	 * Returns all the stops whose names start with a given prefix.
	 */
	public List<Stop> getAll(String prefix) {
		// TODO
		// write the code to get all the stops whose names match the prefix.
		
		
		List<Stop> results=new ArrayList<>();
		TrieNode traverse=root;
			
		

	

		  
		for(char c: prefix.toCharArray()){
			if(!traverse.children.containsKey(c)){
				return null;
			}
			traverse=traverse.children.get(c);
			
		} 
			
	
		

		//getAllFrom(traverse,results);

	/** 	for(Stop s : traverse.data){
			if(prefix.equals(s.getName())){
				ArrayList<Stop> temp =new ArrayList<>();
				temp.add(s);
				return temp;
			}
		} */
		return traverse.data;
	}

		
		

		// END of TODO
	public void getAllFrom(TrieNode node, List<Stop>results){
			for(Stop stop: node.data){
				results.add(stop);
			}
			for(Map.Entry<Character,TrieNode> set:node.children.entrySet()){
				getAllFrom(set.getValue(),results);
			}
	}

	//testing my tri 
	public void print(TrieNode n,String indent){
		TrieNode traverse=root;

		

		for(Map.Entry<Character,TrieNode> b:traverse.children.entrySet()){
			System.out.println("HARIANA ASD HOR SAJJASD "+b.getValue().data.size());
		}






		for(Map.Entry<Character, TrieNode> set:traverse.children.entrySet()){
			System.out.println(indent+set.getKey());
			TrieNode child = set.getValue();
			
			for(Map.Entry<Character, TrieNode> tis:child.children.entrySet()){
				System.out.println("VALUEEEEE"+tis.getKey());
			}
		}
	}


	/**
	 * Represents a single node in the trie. It contains a collection of the
	 * stops whose names are exactly the traversal down to this node.
	 */
	public class TrieNode {
		List<Stop> data = new ArrayList<>();
		Map<Character, TrieNode> children = new HashMap<>();
	}
}