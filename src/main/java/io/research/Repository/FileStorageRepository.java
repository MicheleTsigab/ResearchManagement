package io.research.Repository;


import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Repository
public class FileStorageRepository {


    private final Path location;

    FileStorageRepository(){
    this.location = Paths.get("C:\\Users\\Ketemaw\\Desktop\\RM\\ResearchManagement\\src\\main\\resources\\files").toAbsolutePath().normalize();
//        try {
//            if(!Files.exists(location)){
//                Files.createDirectory(location);
//            }
//            } catch (IOException e) {
//            throw new RuntimeException("Can't Create Directory to save file");
//        }
    }

    public void save(MultipartFile file, String fileName){
        Path targetLocation = this.location.resolve(fileName);
        try {
            Files.copy(file.getInputStream(),targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Resource load(String filename){
        try {
            Path filePath = location.resolve(filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists())
                return resource;
            throw new RuntimeException("File not Found dud");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
