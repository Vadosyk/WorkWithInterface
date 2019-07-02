package ua.com.prog;

public class Main {

	public static void main(String[] args) {
		String[] file = {"C:\\Users\\Vados\\test.txt",
		"C:\\Users\\Vados\\test2.txt"};
String[] dir = {"C:\\Users\\Vados\\dir1",
		"C:\\Users\\Vados\\dir2"};
Monitor[] list = {new FileMonitor(file, new MyFileEvents()), new DirMonitor(dir, new MyDirEvents())};
for(Monitor monitor: list){
	monitor.start();
		}
	}

}
