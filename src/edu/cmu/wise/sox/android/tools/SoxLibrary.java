/* Licensed under the Apache License, Version 2.0 (the "License"); you may not
* use this file except in compliance with the License. You may obtain a copy of
* the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
* WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
* License for the specific language governing permissions and limitations under
* the License.
* By Takuro Yonezawa
*/

package edu.cmu.wise.sox.android.tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.Roster.SubscriptionMode;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smackx.packet.DataForm;
import org.jivesoftware.smackx.packet.DiscoverInfo;
import org.jivesoftware.smackx.packet.DiscoverItems;
import org.jivesoftware.smackx.pubsub.ConfigureForm;
import org.jivesoftware.smackx.pubsub.FormType;
import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.Node;
import org.jivesoftware.smackx.pubsub.NodeType;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.jivesoftware.smackx.pubsub.Subscription;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;
import org.jivesoftware.smackx.pubsub.provider.SubscriptionProvider;


public class SoxLibrary {

	private String xmppServer;
	private int port = 5222;
	private String userName;
	private String password;
	private String resource;
	
	private XMPPConnection mXMPPConnection;
	private PubSubManager mPubSubManager;	

	public SoxLibrary(String _xmppServer,int _port, String _userName, String _password){
		configConnection(_xmppServer, _port, _userName, _password, null);
	}
	
	public SoxLibrary(String _xmppServer,int _port, String _userName, String _password, String _resource){
		configConnection(_xmppServer, _port, _userName, _password, _resource);
	}


	public void closeConnection(){
		mXMPPConnection.disconnect();
	}

	public String getBareJid()  {
		String full = mXMPPConnection.getUser();
		String bare = full.replaceAll("/.*$", "");
		return bare;
	}

	private void init(){
		ProviderManager pm = ProviderManager.getInstance();
		pm.addIQProvider(
				"query", "http://jabber.org/protocol/disco#items",
				new org.jivesoftware.smackx.provider.DiscoverItemsProvider()
				);

		pm.addIQProvider("query",
				"http://jabber.org/protocol/disco#info",
				new org.jivesoftware.smackx.provider.DiscoverInfoProvider());

		pm.addIQProvider("pubsub",
				"http://jabber.org/protocol/pubsub",
				new org.jivesoftware.smackx.pubsub.provider.PubSubProvider());

		pm.addExtensionProvider("subscription", PubSubNamespace.BASIC.getXmlns() , new SubscriptionProvider());

		pm.addExtensionProvider(
				"create",
				"http://jabber.org/protocol/pubsub",
				new org.jivesoftware.smackx.pubsub.provider.SimpleNodeProvider());

		pm.addExtensionProvider("items",
				"http://jabber.org/protocol/pubsub",
				new org.jivesoftware.smackx.pubsub.provider.ItemsProvider());

		pm.addExtensionProvider("item",
				"http://jabber.org/protocol/pubsub",
				new org.jivesoftware.smackx.pubsub.provider.ItemProvider());

		pm.addExtensionProvider("item", "",
				new org.jivesoftware.smackx.pubsub.provider.ItemProvider());

		pm.addExtensionProvider(
				"subscriptions",
				"http://jabber.org/protocol/pubsub",
				new org.jivesoftware.smackx.pubsub.provider.SubscriptionsProvider());

		pm.addExtensionProvider(
				"subscriptions",
				"http://jabber.org/protocol/pubsub#owner",
				new org.jivesoftware.smackx.pubsub.provider.SubscriptionsProvider());

		pm.addExtensionProvider(
				"affiliations",
				"http://jabber.org/protocol/pubsub",
				new org.jivesoftware.smackx.pubsub.provider.AffiliationsProvider());

		pm.addExtensionProvider(
				"affiliation",
				"http://jabber.org/protocol/pubsub",
				new org.jivesoftware.smackx.pubsub.provider.AffiliationProvider());

		pm.addExtensionProvider("options",
				"http://jabber.org/protocol/pubsub",
				new org.jivesoftware.smackx.pubsub.provider.FormNodeProvider());

		pm.addIQProvider("pubsub",
				"http://jabber.org/protocol/pubsub#owner",
				new org.jivesoftware.smackx.pubsub.provider.PubSubProvider());

		pm.addExtensionProvider("configure",
				"http://jabber.org/protocol/pubsub#owner",
				new org.jivesoftware.smackx.pubsub.provider.FormNodeProvider());

		pm.addExtensionProvider("default",
				"http://jabber.org/protocol/pubsub#owner",
				new org.jivesoftware.smackx.pubsub.provider.FormNodeProvider());


		pm.addExtensionProvider("event",
				"http://jabber.org/protocol/pubsub#event",
				new org.jivesoftware.smackx.pubsub.provider.EventProvider());

		pm.addExtensionProvider(
				"configuration",
				"http://jabber.org/protocol/pubsub#event",
				new org.jivesoftware.smackx.pubsub.provider.ConfigEventProvider());

		pm.addExtensionProvider(
				"delete",
				"http://jabber.org/protocol/pubsub#event",
				new org.jivesoftware.smackx.pubsub.provider.SimpleNodeProvider());

		pm.addExtensionProvider("options",
				"http://jabber.org/protocol/pubsub#event",
				new org.jivesoftware.smackx.pubsub.provider.FormNodeProvider());

		pm.addExtensionProvider("items",
				"http://jabber.org/protocol/pubsub#event",
				new org.jivesoftware.smackx.pubsub.provider.ItemsProvider());

		pm.addExtensionProvider("item",
				"http://jabber.org/protocol/pubsub#event",
				new org.jivesoftware.smackx.pubsub.provider.ItemProvider());

		pm.addExtensionProvider("headers",
				"http://jabber.org/protocol/shim",
				new org.jivesoftware.smackx.provider.HeaderProvider());

		pm.addExtensionProvider("header",
				"http://jabber.org/protocol/shim",
				new org.jivesoftware.smackx.provider.HeadersProvider());


		pm.addExtensionProvider(
				"retract",
				"http://jabber.org/protocol/pubsub#event",
				new org.jivesoftware.smackx.pubsub.provider.RetractEventProvider());

		pm.addExtensionProvider(
				"purge",
				"http://jabber.org/protocol/pubsub#event",
				new org.jivesoftware.smackx.pubsub.provider.SimpleNodeProvider());

		pm.addExtensionProvider(
				"x",
				"jabber:x:data",
				new org.jivesoftware.smackx.provider.DataFormProvider());

		SmackConfiguration.setKeepAliveInterval(-1);

	}

	private void configConnection(String _xmppServer,int _port, String _userName, String _password, String _resource){
		xmppServer = _xmppServer;
		port = _port;
		userName = _userName;
		password = _password;
		resource = _resource;
	}


	public XMPPConnection getXMPPConnection(){
		return mXMPPConnection;
	}

	public PubSubManager getPubSubManager(){
		return mPubSubManager;
	}

	public void connectXMPPServer() throws XMPPException
	{

//		org.jivesoftware.smackx.ConfigureProviderManager.configureProviderManager();

		init();

		ConnectionConfiguration config = new ConnectionConfiguration(xmppServer,port);


		config.setTruststoreType("BKS");
		config.setTruststorePath("/system/etc/security/cacerts.bks");

		mXMPPConnection = new XMPPConnection(config);

		mXMPPConnection.connect();
		if (resource == null) {
			mXMPPConnection.login(userName, password);
		} else {
			mXMPPConnection.login(userName, password, resource);
		}

		if(mXMPPConnection.isAuthenticated()){
			System.out.println("JID authenticated successfully!");
		}
		Roster.setDefaultSubscriptionMode(SubscriptionMode.manual);

		mPubSubManager = new PubSubManager(mXMPPConnection, "pubsub." + mXMPPConnection.getServiceName());

	}


	public void subscribeToNode(String nodeId) {
		Node node = null;
		try {
			node = mPubSubManager.getNode(nodeId);
		} catch (XMPPException e) {
			e.printStackTrace();
		}

		LeafNode lf = (LeafNode) node;

		try {
			Subscription sub = lf.subscribe(this.getBareJid());
		} catch (XMPPException e) {
			e.printStackTrace();
		}

	}


	public void unsubscribeToNode(String nodeId, String subid) throws SoxLibException {
		Node node = null;
		try {
			node = mPubSubManager.getNode(nodeId);
		} catch (XMPPException e) {
			throw new SoxLibException(e.getLocalizedMessage());
		}

		LeafNode lf = (LeafNode) node;

		try {
			lf.unsubscribe(this.getBareJid(), subid);
		} catch (XMPPException e) {
			throw new SoxLibException(e.getLocalizedMessage());
		}
	}


	public void publishToNode(String nodeId, String xml) throws SoxLibException {
		publishToNode(nodeId, "sox", "http://jabber.org/protocol/sox", xml);
	}


	public void publishToNode(String nodeId, String name, String ns, String xml)
			throws SoxLibException {
		// name and ns don't seem to do anything yet.
		SimplePayload payload = new SimplePayload(name, ns, xml);

		PayloadItem<SimplePayload> pi = new PayloadItem<SimplePayload>("data", payload);
		try {
			Node node = mPubSubManager.getNode(nodeId);			
			LeafNode lf = (LeafNode) node;
			lf.publish(pi);
		} catch (XMPPException e) {
			e.printStackTrace();
		}
	}

	public List<String> getTopLevelNodes() {
		List<String> nodeList = new ArrayList<String>();
		DiscoverItems items = null;
		try {
			items = mPubSubManager.discoverNodes(null);

		} catch (XMPPException e) {
			return nodeList;
		}

		Iterator<DiscoverItems.Item> i = items.getItems();
		while (i.hasNext()) {
			DiscoverItems.Item item = i.next();
			nodeList.add(item.getNode());
		}

		return nodeList;
	}

	public PubSubNodeInfo getNodeDetails(String nodeId) throws SoxLibException {
		PubSubNodeInfo result = new PubSubNodeInfo();
		DiscoverInfo di = null;
		try {
			Node node = mPubSubManager.getNode(nodeId);
			if (!(node instanceof LeafNode)) {
				throw new SoxLibException("Expecting leaf node, but got something else:" + nodeId);
			}
			LeafNode leaf = (LeafNode) node;
			di = leaf.discoverInfo();
		} catch (XMPPException e) {
			throw new SoxLibException("Problem accessing node list:" + nodeId);
		}

		// Expect one and only one identity.
		Iterator<DiscoverInfo.Identity> iter = di.getIdentities();
		if (iter.hasNext()) {
			DiscoverInfo.Identity info = iter.next();
			// logger.log(Level.FINER, "type:" + info.getType());
			// logger.log(Level.FINER, "cat:" + info.getCategory());
			result.nodeType = info.getType();
			// Assert iter.hasNext == false
		}

		// If no form data, returns null for this field.
		result.nodeForm = (DataForm) di.getExtension("jabber:x:data");

		return result;
	}

	public List<String> getNodeItemList(String nodeId) {
		List<String> result = new ArrayList<String>();
		DiscoverItems ni = null;
		try {
			Node node = mPubSubManager.getNode(nodeId);
			LeafNode leaf = (LeafNode) node;
			ni = leaf.discoverItems();
		} catch (XMPPException e) {
			return result;
		}

		Iterator<DiscoverItems.Item> iter = ni.getItems();
		while (iter.hasNext()) {
			DiscoverItems.Item item = iter.next();
			result.add(item.getName());
		}

		return result;
	}

	public List<Subscription> getSubscribeNodeList(){
		try {
			List<Subscription> subList = mPubSubManager.getSubscriptions();
			return subList;
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public Node getNode(String nodeName){
		try {
			return mPubSubManager.getNode(nodeName);
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public String getLastItemXml(String nodeId) {
		try {
			LeafNode node = (LeafNode) mPubSubManager.getNode(nodeId);

			// getItems() can return subclasses of Item, but we don't
			// use that, so keep it simple.
			List<Item> items = node.getItems(1);
			String s = items.get(0).toXML();
			return s;
		} catch (XMPPException e) {
			throw new SoxLibException("problem accessing:" + nodeId + ":" + e.getLocalizedMessage());
		} catch (IndexOutOfBoundsException e) {
			throw new SoxLibException("nodeId item was empty:" + nodeId);
		}
	}

	public PayloadItem getLastItemPayload(String nodeId) {
		try {
			LeafNode node = (LeafNode) mPubSubManager.getNode(nodeId);

			// getItems() can return subclasses of Item, but we don't
			// use that, so keep it simple.
			List<Item> items = node.getItems(1);
			PayloadItem<SimplePayload> pl = (PayloadItem<SimplePayload>)items.get(0);
			return pl;
		} catch (XMPPException e) {
			throw new SoxLibException("problem accessing:" + nodeId + ":" + e.getLocalizedMessage());
		} catch (IndexOutOfBoundsException e) {
			throw new SoxLibException("nodeId item was empty:" + nodeId);
		} catch (ClassCastException e) {
			throw new SoxLibException("nodeId item is not payload" + nodeId);
		}
	}
	
	public void createEventNode(String nodeId) throws SoxLibException{
		ConfigureForm config = configureForEventNode("sox");
		try {
			mPubSubManager.createNode(nodeId,config);
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteNode(String nodeId) throws SoxLibException {
		try {
			mPubSubManager.deleteNode(nodeId);
		} catch (XMPPException e) {
			throw new SoxLibException(e.getLocalizedMessage());
		}
	}

	/**
	 * Create the configuration for an event node. Always create a leaf since
	 * collection nodes are implemented in the smack library yet.
	 *
	 * @return Configuration for an event node.
	 */
	private ConfigureForm configureForEventNode(String desc) {
		ConfigureForm form = new ConfigureForm(FormType.submit);
		form.setNodeType(NodeType.leaf);
		form.setPersistentItems(true);
		form.setTitle(desc);
		return form;
	}


	public class PubSubNodeInfo {
		/**
		 * XMPP pubsub nodes contain information about the node in the <a
		 * href="http://xmpp.org/extensions/xep-0004.html">XMPP data forms
		 * format</a>. The smack library has a java representation of that format
		 * which is below.
		 */
		public DataForm nodeForm;

		/**
		 * The node type as defined by the <a
		 * href="http://xmpp.org/resources/registrar/">XMPP registrar</a>
		 */
		public String nodeType;
	}


}
