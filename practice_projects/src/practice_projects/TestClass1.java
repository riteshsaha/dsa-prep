package practice_projects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * 
 * 
 * file1.txt (size: 100)
file2.txt (size: 200) in collection "collection1"
file3.txt (size: 200) in collection "collection1"
file4.txt (size: 300) in collection "collection2"
file5.txt (size: 10)
 * Input 1 : FileName, size, CollectionName
 * Output 1 : Total File Size 
 * Input 2 : N
 * Output 2 : Top N Collections - Collection Name and Collection size
 */
public class TestClass1 {
	
	Map<String, FileSystem> systemDetails = new HashMap<>();
	PriorityQueue<Collection> collectionQueue = new PriorityQueue<>((a,b) -> b.size - a.size); 
	Set<String> collectionSet = new HashSet<>();
	int totalSize = 0;
	
	public void addFileToCollection(String fileName, int size, String collectionName) {
		File file;
		if(collectionName.equals("")) {
			file = new File(fileName, size);
			systemDetails.put(fileName, file);
		} else {
			Collection collection = (Collection) systemDetails.getOrDefault(collectionName, new Collection(collectionName));
			file = new File(fileName, size, collectionName);
			collection.size += size;
			collection.files.add(file);
			
			if(!collectionSet.contains(collectionName)) {
				collectionQueue.add(collection);
				collectionSet.add(collectionName);
			}
			
			systemDetails.put(collectionName, collection);
		}
		totalSize += size;
	}
	
	public List<Collection> getTopNCollection(int n) {
		
		if(collectionQueue.size() < n) {
			return new ArrayList<>();
		}
		
		List<Collection> results = new ArrayList<>();
		PriorityQueue<Collection> tempCollectionQueue = new PriorityQueue<>((a,b) -> b.size - a.size);
		
		for(int i = 0; i < n; i++) {
			Collection collection = collectionQueue.poll();
			results.add(collection);
			tempCollectionQueue.add(collection);
		}
		
		for(int i = 0; i < n; i++) {
			collectionQueue.add(tempCollectionQueue.poll());
		}
		
		return results;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestClass1 obj = new TestClass1();
		obj.addFileToCollection("f1.txt", 100, "");
		obj.addFileToCollection("f2.txt", 200, "f1");
		obj.addFileToCollection("f3.txt", 200, "f1");
		obj.addFileToCollection("f4.txt", 400, "f2");
		obj.addFileToCollection("f5.txt", 10, "");
		
		System.out.println("Total Size = " + obj.totalSize);
		
		List<Collection> results = obj.getTopNCollection(1);
		
		for(int i = 0; i < results.size(); i++) {
			System.out.println("Collection Name :" +results.get(i).collectionName + "; Size : " + results.get(i).size);
		}
		
	}

}
