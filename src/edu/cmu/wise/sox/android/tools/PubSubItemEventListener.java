package edu.cmu.wise.sox.android.tools;

import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PubSubItemEventListener implements ItemEventListener<Item> {

  private static Logger logger = Logger.getLogger(PubSubItemEventListener.class.getSimpleName());


  @Override
  public void handlePublishedItems(ItemPublishEvent<Item> ipe) {
    logger.log(Level.FINER, "Item count: " + ipe.getItems().size());
    logger.log(Level.FINER, ipe.toString());
    logger.log(Level.FINER, ipe.getItems().toString());
    logger.log(Level.FINER, ipe.getSubscriptions().toString());
  }
}
