package libsox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.applet.*;
import java.awt.*;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.Subscription;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.sun.istack.internal.NotNull;

import edu.cmu.wise.sox.android.tools.*;

public class testSox extends Applet{
	List<String> SensorList = new ArrayList<String>();
	
	public void init() {
		setBackground(Color.WHITE);
		
	}
	
	public static String extractValue(String xml) throws Exception
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    InputSource source = new InputSource(new StringReader(xml));
	    Document document = builder.parse(source);
	    NodeList nodeList= document.getDocumentElement().getChildNodes();
	    NamedNodeMap AttributeList = nodeList.item(0).getAttributes();

	    //Here item(index) key value pair is fixed.  0 is name, 1 is timestamp, and 2 is value;
		String result = nodeList.item(0).getAttributes().item(2).getTextContent();
		return result;
	}
	
	public void start() {
		String xmppServer = "sensor.andrew.cmu.edu";
		int port = 5222;
		String userName = "billyli16";
		String password = "skynet";
		
		
		System.out.println("Testing Connection...");

		SoxLibrary soxConn = new SoxLibrary(xmppServer, port, userName, password);
		try {
			soxConn.connectXMPPServer();
		} catch (XMPPException e) {
			e.printStackTrace();
		}
		System.out.println("Connection established...");
		
		HashMap<String, String> hash = new HashMap<String, String>();
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
		
		@NotNull List<Subscription> NodeList = new ArrayList<Subscription>();
		try {
			NodeList = soxConn.getSubscribeNodeList();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		if (NodeList != null) {
			int listSize = NodeList.size();
			for (int i = 0; i < listSize; ++i) {
				String roomName = hash.get(NodeList.get(i).getNode());
				String sensorData = soxConn.getTempItemXml(NodeList.get(i).getNode());
				try {
					SensorList.add(roomName + "  Temperature: " + extractValue(sensorData));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		}
	}
	
	
	public void paint(Graphics g) {
		
		super.paintComponents(g);
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.RED);
		g2.drawOval(17, 17, 50, 50);
		g2.drawArc(25, 27, 30, 30, 90, 180);
		g2.drawArc(30, 27, 30, 30, -90, 180);
		g2.drawLine(40, 27, 40, 57);
		g2.drawLine(45, 27, 45, 57);
		g2.drawLine(40, 38, 45, 38);
		g2.drawLine(40, 46, 45, 46);
		g2.setFont(new Font("BLACK", Font.PLAIN, 30)); 
		g2.drawString("Bosch",100,50);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 14)); 
		int sensorNum = SensorList.size();
		for (int i = 0; i < sensorNum; ++i) {
			g.drawString(SensorList.get(i), 10 ,150+20*i);
		}
		
	}
	
	public void stop() {
	}
	
}
