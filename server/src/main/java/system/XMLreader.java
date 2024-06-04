package system;

import data.Route;
import exception.ArgumentException;
import exception.RootException;
import managers.CollectionManager;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class XMLreader { //чтение данных формата XML

    public static CollectionManager read(String path, boolean firstStart, CollectionManager collectionManager) throws ParserConfigurationException, IOException, SAXException, RootException {
        File file = new File(path);
        if (!file.canRead()){
            throw new RootException("Недостаточно прав для чтения файла");
        }
        // Чтение из файла
        var br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        String line;
        StringBuilder text = new StringBuilder();
        while ((line = br.readLine()) != null) {
            text.append(line);
        }
        if (text.isEmpty()){
            System.out.println("Не осталось элементов, коллекция пуста");
            return new CollectionManager();
        }

        InputSource in = new InputSource(new StringReader(text.toString()));

        // Получение фабрики для получения билдера документов.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Получил из фабрики билдер. парс XML, создание структуры Document в виде иерархии.
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Запарсил XML, создал структуру Document. Теперь у нас есть доступ ко всем необходимым элементам.
        Document document = builder.parse(in);

        NodeList routeElements = document.getDocumentElement().getElementsByTagName("route");
        if (firstStart){
            if (routeElements.getLength() == 0){
                System.out.println("Не осталось элементов, коллекция пуста");
            }
        } else {
            // Перебор всех элементов
            for (int i = 0; i < routeElements.getLength(); i++) {
                Node routes = routeElements.item(i);

                // Получение атрибутов каждого элемента
                NamedNodeMap attributes = routes.getAttributes();
                String[] data = {
                        attributes.getNamedItem("key").getNodeValue(),
                        attributes.getNamedItem("id").getNodeValue(),
                        attributes.getNamedItem("name").getNodeValue(),
                        attributes.getNamedItem("x").getNodeValue(),
                        attributes.getNamedItem("y").getNodeValue(),
                        attributes.getNamedItem("creationDate").getNodeValue(),
                        attributes.getNamedItem("FromX").getNodeValue(),
                        attributes.getNamedItem("FromY").getNodeValue(),
                        attributes.getNamedItem("FromZ").getNodeValue(),
                        attributes.getNamedItem("FromNAME").getNodeValue(),
                        attributes.getNamedItem("ToX").getNodeValue(),
                        attributes.getNamedItem("ToY").getNodeValue(),
                        attributes.getNamedItem("ToZ").getNodeValue(),
                        attributes.getNamedItem("ToNAME").getNodeValue(),
                        attributes.getNamedItem("distance").getNodeValue(),
                };

                String key = data[0];
                System.out.println(data);
                try {
                    Route route = new Route(data);
                    collectionManager.add(key, route);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return collectionManager;
    }
}
