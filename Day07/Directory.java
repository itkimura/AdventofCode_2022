import java.util.HashMap;
import java.util.Map;

public class Directory{
	private String name;
	private Directory parent;
	private long size;
	private Map<String, Directory> child;

	Directory(String name, long size)
	{
		this.name = name;
		this.size = size;
		this.child = new HashMap<>();
	}

	Directory(String name, long size, Directory parent)
	{
		this.name = name;
		this.size = size;
		this.parent = parent;
		this.child = new HashMap<>();
	}

	public String getName(){
		return (this.name);
	}

	public long totalSize(){
		long	total_size;

		total_size = 0;
		for(Map.Entry<String, Directory> child: this.child.entrySet())
			total_size += child.getValue().totalSize();
		return (total_size + this.size);
	}

	public long getSize(){
		return (this.size);
	}
	
	public Directory getChild(String key){
		return (this.child.get(key));
	}
	
	public void addSize(long add){
		this.size = this.size + add;
	}

	public void addChild(String name, Directory child){
		this.child.put(name, child);
	}

	public void printChild(){
		int	index;

		index = 0;
		for(Map.Entry<String, Directory> child: this.child.entrySet())
		{
			System.out.println("child[" + index + "]:\t" + child.getValue().getName() + "\ttotal_size + " + child.getValue().totalSize());
					index++;
		}
	}
	
	public void setParent(Directory parent){
		this.parent = parent;
	}

	public Directory getParent(){
		return (this.parent);
	}

	public void printDir(){
		System.out.println("Name:\t" + this.name);
		System.out.println("Size:\t" + this.size);
		if (this.parent != null)
			System.out.println("Parent:\t" + this.parent.getName());
		System.out.println("Total.size:\t" + totalSize());
		printChild();
		System.out.println();
	}
}

