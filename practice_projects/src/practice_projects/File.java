package practice_projects;

public class File implements FileSystem {
	String fileName;
	int size;
	String collectionName;
	
	public File(String fileName, int size) {
		super();
		this.fileName = fileName;
		this.size = size;
	}

	public File(String fileName, int size, String collectionName) {
		this.fileName = fileName;
		this.size = size;
		this.collectionName = collectionName;
	}
	
	
}
