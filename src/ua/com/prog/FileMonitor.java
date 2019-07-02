package ua.com.prog;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Files;

public class FileMonitor implements Monitor {
	String[] file;
	IFileEvents event;
	
	public FileMonitor(String[] file, IFileEvents event) {
		this.file = file;
		this.event = event;
	}
	
	public void start() {
		for (int i = 0; i < file.length; i++) {
		 while (true) {
			 doFileProgress();
				File f = new File(file[i]);
				Path path = Paths.get(f.getPath());
				if (f.exists() && f.isFile()) {
					if (event != null)
						event.onFileAdded(file[i]);
					try {
						BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
						System.out.println("Creation time: " + attrs.creationTime());
					} catch (IOException e) {
						System.out.println("err:");
					}
					break;
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					;
				}

			}
		}
	}

	private void doFileProgress() {
		if (event != null)
			event.onProgress();
		
	}
}