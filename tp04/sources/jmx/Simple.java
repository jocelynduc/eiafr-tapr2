package jmx;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.NotificationBroadcasterSupport;

/* File:	    Simple.java
 * What:	    Simple MBean (Implementation)
 * Who:	      Michel Rast, EIF (michel.rast@eif.ch)
 *
 * History:
 * 2001.06.04 Modification for JDMK 4.2 (Michel Rast)
 * 2006.04.18 Ported to JMX (Rudolf Scheurer, EIF, scheurer@eif.ch)
 * 2008.12.10 Minor modifications (Rudolf Scheurer, EIA-FR, scheurer@hefr.ch)
 * 2010.12.19 Minor modifications (Rudolf Scheurer, EIA-FR, scheurer@hefr.ch)
 */

public class Simple extends NotificationBroadcasterSupport implements
		SimpleMBean {

	protected String state = "initial state";
	protected int nbChanges = 0;
	protected String master = "";

	public String getState() {
		return state;
	}

	public void setState(String s) {
		if (!state.equals(s)) {
			attributeChanged("state");
			AttributeChangeNotification notif = new AttributeChangeNotification(
					this, nbChanges, System.currentTimeMillis(),
					"Attribute 'state' has changed!", "state", "String", state,
					s);
			sendNotification(notif);
		}
		state = s;
	}

	public int getNbChanges() {
		return nbChanges;
	}

	public void reset() {
		nbChanges = 0;
		state = "initial state";
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String s) {
		if (!master.equals(s)) {
			attributeChanged("master");
			AttributeChangeNotification notif = new AttributeChangeNotification(
					this, nbChanges, System.currentTimeMillis(),
					"Attribute 'master' has changed!", "master", "String", state,
					s);
			sendNotification(notif);

		}
		master = s;
	}

	// Use this method to trace attribute changes
	private void attributeChanged(String attributeName) {
		nbChanges++;
		System.out.println("- attribute '" + attributeName
				+ "' has been changed.");
	}

    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[] {
            AttributeChangeNotification.ATTRIBUTE_CHANGE
        };
        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo info =
            new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[] {info};
    }
}
