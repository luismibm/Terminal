import java.io.File;
import java.util.Date;

public class FileManager {

    public FileManager() {
    }

    File path = new File(System.getProperty("user.dir"));

    public void pwd() {
        System.out.println(path);
    }

    public void cd(String dir) {
        if (dir.equals("..")) {
            if (path.getParentFile() != null) {
                path = path.getParentFile();
            } else {
                System.out.println("Already at the root directory");
            }
        } else {
            File newPath = new File(path, dir);
            if (newPath.exists() && newPath.isDirectory()) {
                path = newPath;
            } else {
                System.out.println("Directory does not exist or is not a directory");
            }
        }
    }

    public void ls() {
        File[] files = path.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("[D] " + file.getName());
            }
        }
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("[A] " + file.getName());
            }
        }
    }

    public void ll() {
        File[] files = path.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("[D] " + file.getName() + " | " + file.length() + " bytes | Modified: " +  new Date(file.lastModified()));
            }
        }
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("[A] " + file.getName() + " | " + file.length() + " bytes | Modified: " + new Date(file.lastModified()));
            }
        }
    }

    public void mkdir(String dirName) {
        File newDir = new File(path, dirName);
        boolean isCrated = newDir.mkdir();
        if (isCrated) {
            System.out.println("Directory created successfully");
        } else {
            System.out.println("Failed to create directory");
        }
    }

    public void rm(String fileName) {
        File fileToDelete = new File(path, fileName);
        if (!fileToDelete.exists()) {
            System.out.println("File or directory does not exist");
        } else {
            if (fileToDelete.isDirectory() && fileToDelete.list().length > 0) {
                System.out.println("Directory is not empty");
            } else {
                boolean isDeleted = fileToDelete.delete();
                if (isDeleted) {
                    System.out.println("File or directory deleted successfully");
                } else {
                    System.out.println("Failed to delete file or directory");
                }
            }
        }
    }

    public void mv(String oldFileName, String newFileName) {
        File oldFile = new File(path, oldFileName);
        if (!oldFile.exists()) {
            System.out.println("File or directory does not exist");
        } else {
            File newFile = new File(path, newFileName);
            boolean isMoved = oldFile.renameTo(newFile);
            if (isMoved) {
                System.out.println("File or directory moved or renamed successfully");
            } else {
                System.out.println("Failed to move or rename file or directory");
            }
        }
    }

    public void help() {
        System.out.println("- - pwd - -\nMuestra la carpeta actual.");
        System.out.println("- - cd <DIR> - -\nCambia la carpeta actual a ‘DIR’. Con .. cambia a la carpeta superior.");
        System.out.println("- - ls - -\nMuestra la lista de directorios y archivos de la carpeta actual (primero directorios, luego archivos, ambos ordenados alfabéticamente).");
        System.out.println("- - ll - -\nComo ls pero muestra también el tamaño y la fecha de última modificación.");
        System.out.println("- - mkdir <DIR> - -\nCrea el directorio ‘DIR’ en la carpeta actual.");
        System.out.println("- - rm <FILE> - -\nBorra ‘FILE’. Si es una carpeta, borrará primero sus archivos y luego la carpeta. Si tiene subcarpetas, las dejará intactas y mostrará un aviso al usuario.");
        System.out.println("- - mv <FILE1> <FILE2> - -\nMueve o renombra ‘FILE1’ a ‘FILE2’ ");
    }

}