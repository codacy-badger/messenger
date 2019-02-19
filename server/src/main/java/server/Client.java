package server;

import javafx.collections.FXCollections;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.xpath.*;
import java.io.*;
import java.util.*;


@XmlRootElement(name="client")
public class Client {
    @XmlElement
    private int clientId;
    @XmlJavaTypeAdapter(SetAdapter.class)
    private Set<Integer> rooms;
    @XmlJavaTypeAdapter(SetAdapter.class)
    private Set<Integer> friends;
    @XmlElement
    private String login;
    @XmlElement
    private String password;
    @XmlElement
    private boolean isAdmin;
    private Properties privacy;

    public Client() {
        friends = FXCollections.synchronizedObservableSet(FXCollections.observableSet(new HashSet<>()));
        rooms = FXCollections.synchronizedObservableSet(FXCollections.observableSet(new HashSet<>()));
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Set<Integer> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Integer> rooms) {
        this.rooms = rooms;
    }

    public Set<Integer> getFriends() {
        return friends;
    }

    public void setFriends(Set<Integer> friends) {
        this.friends = friends;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private static class SetAdapter extends XmlAdapter<HashSet<Integer>, Set<Integer>> {
        @Override
        public Set<Integer> unmarshal(HashSet<Integer> v) throws Exception {
            return FXCollections.synchronizedObservableSet(FXCollections.observableSet(v));
        }

        @Override
        public HashSet<Integer> marshal(Set<Integer> v) throws Exception {
            return new HashSet<>(v);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientId == client.clientId &&
                Objects.equals(rooms, client.rooms) &&
                Objects.equals(friends, client.friends) &&
                Objects.equals(login, client.login) &&
                Objects.equals(password, client.password);
    }

    @Override
    public int hashCode() {
        return clientId;
    }

    /**
     * The method that informs if there is a member {@code clientId} in the room {@code roomId}
     *
     * @param clientId The client's clientId to be searched for
     * @param roomId The room clientId where {@code clientId} will be searched
     *
     * @return {@code true} if and only if there are a registered account with such {@code clientId}
     *          and created room that has the specified {@code roomId}
     *          {@code false} otherwise.
     * @throws FileNotFoundException // TODO decide what exception will be thrown and describe the cases when it will occur
     *
     * */
    // TODO remove the exceptions
    public static boolean isMember(Properties serverConfig, int clientId, int roomId) throws FileNotFoundException, XPathExpressionException {
        File roomFile = new File(new StringBuilder(serverConfig.getProperty("roomsDir"))
                .append(File.pathSeparator).append(roomId).append(".xml").toString());
        if (!roomFile.exists()){
            return false;
        }
        XPath xPath = XPathFactory.newInstance().newXPath();
        XPathExpression xPathExpression = null;
        try {
            xPathExpression = xPath.compile("room/members/clientId");
        } catch (XPathExpressionException e) {

            throw new RuntimeException(e);
        }
        NodeList resultNodeList = (NodeList) xPathExpression.evaluate(
                new InputSource(new BufferedReader(new FileReader(roomFile))), XPathConstants.NODESET);
        for(int i = 0; i < resultNodeList.getLength(); i++) {
            if(clientId == Integer.parseInt(resultNodeList.item(i).getTextContent())) {
                return true;
            }
        }
        return false;
    }
}