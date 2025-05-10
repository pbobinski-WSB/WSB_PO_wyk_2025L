package wsb.po.siedem.nio;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;


public class PathExample {

	public static void main (String [] args) {
	
		PathExample example = new PathExample();
		example.createPath();
		example.getPathInfo();
		example.convertPaths();
		example.comparePaths();
		example.readWrite();
	}

	private void readWrite() {
		Path path = Paths.get("file/niofile.txt");
		try {
			Files.writeString(path, "Zapis z NIO");
			String content = Files.readString(path);
			System.out.println("NIO odczyt: " + content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Path path;
	
	private void createPath() {
	
		path = Paths.get("file/file1.txt");
		System.out.println("Path created: " + path.toString());
	
	}

	private void getPathInfo() {
	
		Path filename = path.getFileName();
		System.out.println("Filename: " + filename);
		
		Path name0 = path.getName(0);
		System.out.println("Name 0: " + name0);
		
		Path sub = path.subpath(0, 2);
		System.out.println("Sub path: " + sub);
	}
	
	private void convertPaths() {
	
		Path relative = Paths.get("file2.txt");
		System.out.println("Relative path: " + relative);
	
		Path absolute = relative.toAbsolutePath();
		System.out.println("Absolute path: " + absolute);
	
		Path real = null;
		path = Paths.get("file/realfile.txt");
		
		try {
			real = path.toRealPath();
		}
		catch (IOException e) {

			System.out.println("Real path could not be created !");
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.println("Real path: " + real);

	}
	
	private void comparePaths() {
	
		Path path2 = Paths.get("file/file1.txt");
		
		boolean equal = path2.equals(path);
		System.out.println("Paths equal? " + equal);
	}

} // class


