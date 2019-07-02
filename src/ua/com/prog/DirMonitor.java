package ua.com.prog;

	import java.io.File;
	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;
	import java.nio.file.attribute.BasicFileAttributes;

	public class DirMonitor implements Monitor{
	    String[] dir;
	    IDirEvents event;

	    public DirMonitor(String[] dir, IDirEvents event) {
	        this.dir = dir;
	        this.event = event;
	    }

	    public void start() {
	        for (int i = 0; i < dir.length; i++) {
	            while (true) {
	            	doDirProgress();
	            	
	                File f = new File(dir[i]);
	                Path path = Paths.get(f.getPath());
	                if (f.exists() && f.isDirectory()) {
	                    if (event != null)
	                        event.onDirectoryAdded(dir[i]);
	                    String[] list = f.list();
	                    for(String file: list){
	                        if(file.endsWith("txt"))
	                            System.out.println("In the " + f.getName() + " folder there is txt file");
	                    }
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

		private void doDirProgress() {
			if (event != null)
				event.onProgress();			
		}
	}


