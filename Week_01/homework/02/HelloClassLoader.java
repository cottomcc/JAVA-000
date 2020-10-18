import java.io.*;
import java.nio.file.Files;
import java.lang.reflect.*;

public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Class<?> clz = new HelloClassLoader().findClass("Hello");
            Object ins = clz.newInstance();
            Method method = clz.getMethod("hello");
            method.invoke(ins);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Class<?> findClass(String className) throws ClassNotFoundException {
        String byteCodePath = this.getClass().getResource("/Hello.xlass").getPath();
        File byteFile = new File(byteCodePath);
        try {
            byte[] fileContent = Files.readAllBytes(byteFile.toPath());
            for (int i = 0; i < fileContent.length; i++) {
                fileContent[i] = (byte) (255 - fileContent[i]);
            }
            return defineClass(className, fileContent, 0, fileContent.length);
        } catch (IOException e) {
            e.printStackTrace();
            return super.findClass(className);
        }
    }
}

