package libsox;

import java.util.ArrayList;
import java.util.List;
import java.applet.*;
import java.awt.*;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.Subscription;

import com.sun.istack.internal.NotNull;

import edu.cmu.wise.sox.android.tools.*;

public class testSox extends Applet{
	List<String> SensorList = new ArrayList<String>();
	
	public void init() {
		setBackground(Color.BLACK);
		
	}
	public void start() {
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
		@NotNull
		List<Subscription> NodeList = new ArrayList<Subscription>();
		try {
			NodeList = soxConn.getSubscribeNodeList();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (NodeList != null) {
			int listSize = NodeList.size();
			for (int i = 0; i < listSize; ++i) {
				System.out.println(NodeList.get(i));
				//System.out.println(soxConn.getLastItemPayload(Node.getNode()));
				System.out.println(soxConn.getLastItemXml(NodeList.get(i).getNode()));
				String sensorData = soxConn.getLastItemXml(NodeList.get(i).getNode());
				System.out.println(sensorData);
				SensorList.add(sensorData);
			}
		}
	}
	
	
	public void paint(Graphics g) {
		
		g.setColor(Color.RED);
		g.drawOval(20, 20, 50, 50);
		g.drawArc(25, 25, 35, 35, 90, 180);
		g.drawArc(25, 25, 35, 35, -90, 180);
		g.drawString("Bosch",100,50);
		
		g.setColor(Color.GREEN);
		int sensorNum = SensorList.size();
		for (int i = 0; i < sensorNum; ++i) {
			g.drawString(SensorList.get(i), 10 ,150+20*i);
		}
		
	}
	
	public void stop() {
	}
	
}
