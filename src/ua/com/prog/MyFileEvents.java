package ua.com.prog;

public class MyFileEvents implements IFileEvents {
    @Override
    public void onFileAdded(String filePath) {
        System.out.println("File added: " + filePath);
    }

    @Override
    public void onProgress() {
        System.out.println("Waiting for a file...");
    }
}

