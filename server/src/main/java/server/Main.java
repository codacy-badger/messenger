package server;

import common.message.Message;
import common.message.MessageStatus;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.xml.sax.SAXException;
import server.room.Room;
import server.room.RoomProcessing;

import javax.xml.bind.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.xpath.*;
import java.io.*;
import java.net.Socket;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

@Log4j
public class Main {

    //private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XMLStreamException, JAXBException, XPathExpressionException, URISyntaxException {
        /*Client client = new Client();
        client.setLogin("login");
        client.setPassword("password");
        client.setClientId("login".hashCode());
        JAXBContext jaxbContext = JAXBContext.newInstance(Client.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(client,System.out);*/
        
        /*DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setValidating(true);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        documentBuilder.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {
                throw exception;
            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                throw exception;
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                throw exception;
            }
        });
        Document document = documentBuilder.parse("src/server.xml");
        Element root = document.getDocumentElement();
        System.out.println(root.getTextContent());*/
        /*Message message = new Message(MessageStatus.AUTH).setLogin("leader228228").setPassword("12345");
        XMLMessageBuilder xmlMessageBuilder = new XMLMessageBuilder(message);

        Message message1 = new Message(MessageStatus.REGISTRATION).setLogin("leader228228").setPassword("12345");
        xmlMessageBuilder = new XMLMessageBuilder(message1);

        Message message2 = new Message(ResponseStatus.ERROR).setText(new IllegalStateException("some test info").getText());
        xmlMessageBuilder = new XMLMessageBuilder(message2);

        Message message3 = new Message(ResponseStatus.ACCEPTED);
        xmlMessageBuilder = new XMLMessageBuilder(message3);*/

        /*Message message = new Message(ResponseStatus.ERROR).setException(new NullPointerException("some info"));
        XMLMessageBuilder xmlMessageBuilder = new XMLMessageBuilder(message);
        xmlMessageBuilder.buildXML();
        String xml = xmlMessageBuilder.getXmlText();
        XMLMessageParser xmlMessageParser = new XMLMessageParser(xml);
        xmlMessageParser.parseInput();
        Message message1 = xmlMessageParser.getMessage();
        System.out.println(message1);*/
        /*String s1 = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n").append("<!DOCTYPE server [\n").append("        <!ELEMENT server (port)>\n").append("        <!ELEMENT port ANY>\n").append("        ]>\n").append("<server>\n").append("    <port>5940</port>\n").append("</server>").toString();
        String s2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE server [\n" +
                "        <!ELEMENT server (port)>\n" +
                "        <!ELEMENT port ANY>\n" +
                "        ]>\n" +
                "<server>\n" +
                "    <port>5940</port>\n" +
                "</server>";
        System.out.println(s1.equals(s2));*/

        /*XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(
                new BufferedReader(new FileReader("D:\\Java projects\\Messenger\\messenger\\server\\src\\main\\res\\xml\\server.xml")));
        while (xmlStreamReader.hasNext()){
            int event = xmlStreamReader.next();
            if(event == XMLStreamConstants.START_ELEMENT && xmlStreamReader.getLocalName().equals("port")){
                xmlStreamReader.next();
                System.out.println(xmlStreamReader.getText());
            }
        }*/

        //System.out.println(Server.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        /*Message message = new Message(MessageStatus.REGISTRATION).setLogin("Mike").setPassword("1234");

        JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(message, new File("myMessage.txt"));*/

        /*Room room = new Room();
        room.setRoomId(1);
        room.setAdminId(2);
        room.setMessageHistory(FXCollections.observableArrayList());

        room.getMessageHistory().add(new Message(MessageStatus.MESSAGE).setText("hello"));
        room.getMessageHistory().add(new Message(MessageStatus.MESSAGE).setText("world"));
        room.getMessageHistory().add(new Message(MessageStatus.MESSAGE).setText("everything will be ok"));

        room.setAllClients(new HashSet<>());
        room.getAllClients().add(1);
        room.getAllClients().add(2);
        room.getAllClients().add(3);
        room.getAllClients().add(4);

        JAXBContext jaxbContext = JAXBContext.newInstance(Room.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File myRoom = new File("myRoom.xml");
        File myRoom1 = new File("myRoom.xml");
        marshaller.marshal(room, myRoom);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        System.out.println(unmarshaller);
        Room unmarshRoom = (Room) unmarshaller.unmarshal(myRoom1);
        System.out.println(unmarshRoom);*/






        /*Room room = new Room();
        room.getMessageHistory().add(new Message(MessageStatus.MESSAGE).setText("Hello").setFromId(1));
        room.getMessageHistory().add(new Message(MessageStatus.MESSAGE).setText("World").setFromId(1));
        room.getMessageHistory().add(new Message(MessageStatus.MESSAGE).setText("Everything will be ok").setFromId(2));
        room.getMembers().add(777);
        room.getMembers().add(123);
        room.getMembers().add(65);
        room.getMembers().add(93);
        JAXBContext jaxbContext = JAXBContext.newInstance(Room.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = new File("myRoom.xml");
        marshaller.marshal(room,file);


        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Room room1 = (Room) unmarshaller.unmarshal(file);
        System.out.println(room1);*/






        /*int clientId = 777;

        XPath xPath = XPathFactory.newInstance().newXPath();
        XPathExpression xPathExpression = null;
        try {
            xPathExpression = xPath.compile("room/members/clientId");
        } catch (XPathExpressionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        NodeList resultNodeList = (NodeList) xPathExpression.evaluate(
                new InputSource(new BufferedReader(new FileReader(file))), XPathConstants.NODESET);
        for(int i = 0; i < resultNodeList.getLength(); i++) {
            if(clientId == Integer.parseInt(resultNodeList.item(i).getTextContent())) {
                System.err.println(true);
                return;
            }
        }
        System.err.println(false);
        */

        /*for (int i = 0; i < 9999; i++){
            logger.debug(i + " debug");
            logger.warn(i + " warn");
            logger.error(i + " error");
        }*/

        /*File file = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
        System.out.println(file.getAbsolutePath());*/

        /*Properties properties = new Properties();
        properties.setProperty("first", "первая пропертя");
        properties.setProperty("second", "вторая пропертя");
        properties.setProperty("third", "третья пропертя");

        Properties properties1 = new Properties();
        properties1.setProperty("second", "вторая пропертя");
        properties1.setProperty("first", "первая пропертя");


        System.err.println(properties.equals(properties1));*/

        // REGISTRATION
        JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        StringWriter stringWriter = new StringWriter();

        Message message = new Message(MessageStatus.REGISTRATION).setLogin("Puser").setPassword("password");
        Socket socket = new Socket("localhost", 5940);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        marshaller.marshal(message, stringWriter);

        dataOutputStream.writeUTF(stringWriter.toString());
        dataOutputStream.flush();

        System.out.println(dataInputStream.readUTF());

        // AUTHORIZATION + ROOM CREATING
        /*JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        StringWriter stringWriter = new StringWriter();

        Message message = new Message(MessageStatus.AUTH).setLogin("Puser").setPassword("password");
        Socket socket = new Socket("localhost", 5940);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        marshaller.marshal(message, stringWriter);

        dataOutputStream.writeUTF(stringWriter.toString());
        dataOutputStream.flush();
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

        System.out.println(dataInputStream.readUTF());

        message = new Message(MessageStatus.CREATE_ROOM).setFromId("Puser".hashCode());
        stringWriter = new StringWriter();
        marshaller.marshal(message, stringWriter);
        dataOutputStream.writeUTF(stringWriter.toString());

        System.out.println(dataInputStream.readUTF());

        message = new Message(MessageStatus.MESSAGE).setText("Hello world :)")
                .setFromId("Puser".hashCode()).setRoomId(408753972);
        stringWriter = new StringWriter();
        marshaller.marshal(message, stringWriter);
        dataOutputStream.writeUTF(stringWriter.toString());

        System.out.println(dataInputStream.readUTF());*/

        /*Socket socket1 = new Socket("localhost", 5940);
        DataOutputStream dataOutputStream1 = new DataOutputStream(socket1.getOutputStream());
        DataInputStream dataInputStream1 = new DataInputStream(socket1.getInputStream());

        message = new Message(MessageStatus.STOP_SERVER).setLogin("God").setPassword("change_me");

        stringWriter = new StringWriter();
        marshaller.marshal(message, stringWriter);
        dataOutputStream1.writeUTF(stringWriter.toString());

        System.out.println(dataInputStream1.readUTF());*/

        // TESTING MESSAGE MARSHALLING - OK
        /*JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        StringWriter stringWriter = new StringWriter();

        Message message = new Message(MessageStatus.AUTH).setLogin("Puser").setPassword("password");
        stringWriter = new StringWriter();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(message, stringWriter);
        System.out.println(stringWriter.toString());*/



        // TESTING ROOM MARSHALLING
        /*try {
            Room room = new Room();
            Message message1 = new Message(MessageStatus.MESSAGE).setFromId(1).setText("first");
            Message message2 = new Message(MessageStatus.MESSAGE).setFromId(1).setText("second");
            Message message3 = new Message(MessageStatus.MESSAGE).setFromId(1).setText("third");
            room.getMessageHistory().add(message1);
            room.getMessageHistory().add(message2);
            room.getMessageHistory().add(message3);

            JAXBContext jaxbContext = JAXBContext.newInstance(Room.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter stringWriter = new StringWriter();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(room, stringWriter);
            System.out.println(stringWriter.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }*/


        // TESTING BAN
        /*try (Socket socket = new Socket("localhost", 5940);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream())) {

            JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter stringWriter = new StringWriter();

            Message message = new Message(MessageStatus.CLIENTBAN).setLogin("God").setPassword("change_me").setToId(3329)
                    .setText(ServerProcessing.DATE_TIME_FORMATTER.format(LocalDateTime.now().plusHours(1)));

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(message, stringWriter);
            System.out.println(stringWriter.toString());
            dataOutputStream.writeUTF(stringWriter.toString());

            System.out.println(dataInputStream.readUTF());

        } catch (JAXBException e) {
            e.printStackTrace();
        }*/


        // AUTH + UNBAN
        /*JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        StringWriter stringWriter = new StringWriter();

        Message message = new Message(MessageStatus.AUTH).setLogin("Puser").setPassword("password");
        Socket socket = new Socket("localhost", 5940);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

        marshaller.marshal(message, stringWriter);
        dataOutputStream.writeUTF(stringWriter.toString());
        System.out.println(dataInputStream.readUTF());

        message = new Message(MessageStatus.CLIENTUNBAN).setToId(3329).setFromId(77480987);
        stringWriter = new StringWriter();
        marshaller.marshal(message, stringWriter);
        dataOutputStream.writeUTF(stringWriter.toString());

        System.out.println(dataInputStream.readUTF());*/


    }
}