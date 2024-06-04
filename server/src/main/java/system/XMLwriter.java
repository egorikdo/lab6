package system;

import data.Route;
import exception.RootException;
import managers.CollectionManager;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

public class XMLwriter { //запись в формате XML

    public static void write(String path, CollectionManager collectionManager) throws IOException, RootException {
        File file = new File(path);
        if (!file.canRead()){
            throw new RootException("Не достаточно прав для записи в файл");
        }
        StringBuilder xml = new StringBuilder("""
                <?xml version="1.0" encoding="UTF-8" ?>

                <collection>
                \t<routs>
                """);

        Hashtable<String, Route> table = collectionManager.getTable();
        for (String key: table.keySet()) {
            xml.append("\t\t<route ");
            xml.append("key=\"").append(key).append("\" ");
            Route route = table.get(key);
            xml.append(route.toXML()).append("/>\n");
        }

        xml.append("\t</routs>\n" + "</collection>");

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
        bufferedOutputStream.write(xml.toString().getBytes());
        bufferedOutputStream.close();
    }
}
