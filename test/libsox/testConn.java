package libsox;

import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.Subscription;
import org.w3c.dom.Document;
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
	
	public static Node loadXMLFromString(String xml) throws Exception
	{
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    InputSource source = new InputSource(new StringReader(xml));
	    Document document = builder.parse(source);
	    NodeList nodeList = document.getDocumentElement().getChildNodes();
	    Node result = nodeList.item(0);
		for (int i = 0; i < nodeList.getLength(); i ++) {
			Node node = nodeList.item(i);
			System.out.println(node);
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String xmppServer = "sensor.andrew.cmu.edu";
		int port = 5222;
		String userName = "billyli16";
		String password = "skynet";
		XMPPConnection mXMPPConnection;
		
		System.out.println("Testing Connection...");
		ConnectionConfiguration config = new ConnectionConfiguration(xmppServer,port);
		mXMPPConnection = new XMPPConnection(config);

		try {
			mXMPPConnection.connect();
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SoxLibrary soxConn = new SoxLibrary(xmppServer, port, userName, password);
		
		try {
			soxConn.connectXMPPServer();
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connection established...");
		
		@NotNull List<Subscription> NodeList = soxConn.getSubscribeNodeList();
		if (NodeList != null) {
			for (Subscription Node : NodeList) {
				System.out.println(Node);
//				System.out.println(soxConn.getLastItemPayload(Node.getNode()));
				String sensorData = soxConn.getLastItemXml(Node.getNode());
				System.out.println(sensorData);
				System.out.println(loadXMLFromString(sensorData));
			}
		}
	}

}
