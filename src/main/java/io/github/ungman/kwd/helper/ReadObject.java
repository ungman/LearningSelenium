package io.github.ungman.kwd.helper;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadObject {
    Properties p = new Properties();
    @SneakyThrows
    public Properties getObjectRepository() {
        String pathToResource=System.getProperty("user.dir")+"\\src\\main\\resources";
        InputStream stream = new FileInputStream(new File(pathToResource+"\\object.properties"));
        p.load(stream);
        return p;
    }

}
