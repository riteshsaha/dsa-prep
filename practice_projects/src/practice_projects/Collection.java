package practice_projects;

import java.util.ArrayList;
import java.util.List;

public class Collection implements FileSystem {
	String collectionName;
	List<File> files;
	int size;
	
	public Collection(String collectionName) {
		this.collectionName = collectionName;
		this.files = new ArrayList<>();
	}
}
