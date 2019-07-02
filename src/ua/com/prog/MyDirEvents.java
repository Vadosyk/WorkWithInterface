package ua.com.prog;

public class MyDirEvents implements IDirEvents {
	
    public void onDirectoryAdded(String filePath) {
        System.out.println("Directory added: " + filePath);
    }

	@Override
	public void onProgress() {
		System.out.println("Waiting for a directory...");
		
	}
    
    
}
