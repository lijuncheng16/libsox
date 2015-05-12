package libsox;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.Subscription;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.sun.istack.internal.NotNull;

import edu.cmu.wise.sox.android.tools.SoxLibrary;

public class testConn {
	
	public static String parseXML(String originDoc) throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(originDoc);
		NodeList nodeList = document.getDocumentElement().getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i ++) {
			Node node = nodeList.item(i);
			System.out.println(node);
		}
		return null;
		
	}
	
	public static String extractValue(String xml) throws Exception
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    InputSource source = new InputSource(new StringReader(xml));
	    Document document = builder.parse(source);
//	    System.out.println((document.getElementsByTagName("item").item(0)));
//	    System.out.println((( ((Element) document.getElementsByTagName("item").item(0)).getElementsByTagName("transducerData").item(0))));  
	    NodeList nodeList= document.getDocumentElement().getChildNodes();
	    NamedNodeMap AttributeList = nodeList.item(0).getAttributes();
//	    int j;
//			for (j = 0; j < AttributeList.getLength(); j++){
//				System.out.println("1 "+nodeList.item(0).getAttributes().item(j));
//				String content = nodeList.item(0).getAttributes().item(j).getTextContent();
//				System.out.println("2 "+content);
//			}
	    
	    //Here item(index) key value pair is fixed.  0 is name, 1 is timestamp, and 2 is value;
		String result = nodeList.item(0).getAttributes().item(2).getTextContent();
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String xmppServer = "sensor.andrew.cmu.edu";
		int port = 5222;
		String userName = "billyli16";
		String password = "skynet";
		//XMPPConnection mXMPPConnection;
		
		System.out.println("Testing Connection...");
//		ConnectionConfiguration config = new ConnectionConfiguration(xmppServer,port);
//		mXMPPConnection = new XMPPConnection(config);
//
//		try {
//			mXMPPConnection.connect();
//		} catch (XMPPException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		SoxLibrary soxConn = new SoxLibrary(xmppServer, port, userName, password);
		
		try {
			soxConn.connectXMPPServer();
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connection established...");
		
		Map<String, String> hash = new HashMap<String, String>();
		hash.put("244E7900519C38F8", "Elevator");
		hash.put("244E7900519C3936", "Room 201");
		hash.put("244E7900519C3968", "Room 214");
		hash.put("244E7900519C3A0B", "Room 219");
		hash.put("244E7900519C3AA2", "Power Box");
		hash.put("244E7900519C3AED", "Stair 242");
		hash.put("244E7900519C3C0A", "Room 220");
		hash.put("244E7901519C394F", "Room 212");
		hash.put("244E7901519C395B", "Room 208");
		hash.put("244E7901519C399A", "Room 203");
		hash.put("244E7901519C3A70", "Stair 237");
		hash.put("244E7901519C3B13", "Room 222");
		hash.put("244E7901519C3C53", "Corridor");
		hash.put("0d01e49f5cd8d70e741c8716c9201a55", "Wistat 206");
		hash.put("1647587b0391cab7c466f54a5cc1db54", "Wistat 219");
		hash.put("2d9b1f311e8c669b23e0e1f7cfb6b8f9", "Wistat 220");
		hash.put("2eb4fe7f84f34ee09ae31b906474c032", "Wistat 202");
		hash.put("306e350155d759949605df9071415f39", "Wistat 212");
		hash.put("60b6e59a68cbec6817cfe0a9d399e367", "Wistat 222");
		hash.put("6ade0164756a6703c15617ba342d847f", "Wistat 203");
		hash.put("da0e7ed75cf65a800e1430149547da1a", "Wistat 214");
		hash.put("f593910a7d513a05ef3718530ee04b90", "Wistat 205");
		
		for (Entry<String, String> entry : hash.entrySet()) {
		    String k = entry.getKey();
		    String v = entry.getValue();
		    System.out.printf("%s %s\n", k, v);
//		    soxConn.subscribeToNode(k);
		}
		//soxConn.unsubscribeToNode("244E7900519C38F8", "597500A6176AA");
		@NotNull List<Subscription> NodeList = soxConn.getSubscribeNodeList();
		while(true){
		if (NodeList != null) {
			for (Subscription Node : NodeList) {
				//System.out.println(hash.get(Node.getNode()));
				//System.out.println(soxConn.getNodeItemList(Node.getNode()));
				
				String sensorData = soxConn.getTempItemXml(Node.getNode());
				
				//System.out.println("Original SensorData is:" + sensorData);
				//System.out.println("Temperature Reading: " + extractValue(sensorData));
				System.out.flush();
				}
			}
		try {
		    Thread.sleep(10000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		}
	}

}
