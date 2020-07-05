package io.github.ungman.learnig.seleniumwithtestng.kwd;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadObject {
    Properties p = new Properties();
    @SneakyThrows
    public Properties getObjectRepository() {
        //Read object repository file
        String pathToResource=System.getProperty("user.dir")+"\\src\\main\\resources";
        InputStream stream = new FileInputStream(new File(pathToResource+"\\object.properties"));
        //load all objects
        p.load(stream);
        return p;
    }

}
