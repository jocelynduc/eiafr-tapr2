/**
 *
 */
package jmxmp;

/* File:	  JMXMP_Client.java
 * What:	  A management application (client) accessing an JMXMP connector server
 * Who:	    Michel Rast, EIF (michel.rast@eif.ch)
 *
 * History:
 * 2001.06.04 Modification for JDMK 4.2 (Michel Rast)
 * 2006.04.18 Ported to JMX (Rudolf Scheurer, EIF, scheurer@eif.ch)
 * 2008.12.10 Minor modifications (Rudolf Scheurer, EIA-FR, scheurer@hefr.ch)
 */

import javax.management.*;
import javax.management.remote.*;

import jmx.SimpleMBean;

public class JMXMP_Client {

	public static void main(String argv[]) {
		try {
			// Create an JMXMP connector and connect it
			System.out.println("\nCreate an JMXMP connector client and "
					+ "connect it to the JMXMP connector server ...");

			JMXServiceURL url = new JMXServiceURL(
					"service:jmx:jmxmp://localhost:1234");
			JMXConnector jmxc = JMXConnectorFactory.connect(url, null);

			// Get an MBeanServerConnection
			System.out.println("\nGet an MBeanServerConnection ...");
			MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

			// Create the Simple MBean
			System.out.println("\nCreate a Simple MBean...");
			ObjectName objectName = new ObjectName(
					"DefaultDomain:type=Simple,id=remote");
			String className = "jmx.Simple";
			mbsc.createMBean(className,
					objectName);
			// Access and modify the 'owner' attribute
			System.out.println("- attribute 'owner' = "
					+ mbsc.getAttribute(objectName, "Master"));
			mbsc.setAttribute(objectName, new Attribute("Master", "duc_marcacci"));
			System.out.println("- attribute 'owner' = "
					+ mbsc.getAttribute(objectName, "Master"));
			mbsc.invoke(objectName, "reset", null, null);
			// Creating a dedicated MBean proxy
			System.out.println("\nAccessing MBean using proxy ...");
			SimpleMBean simpleProxy = (SimpleMBean) MBeanServerInvocationHandler
					.newProxyInstance(mbsc, objectName, SimpleMBean.class,
							false);

			// Use the proxy
			simpleProxy.setState("final state");
			 System.out.println("- attribute 'state' = " + simpleProxy.getState());

			// Connector remains active until user presses ENTER
			System.out.println("\nPress ENTER to unregister the Simple MBean and stop the client ...");
			System.in.read();

			// Unregister the MBean and close the connector
			System.out.println("Unregistering Simple MBean ...");
			mbsc.unregisterMBean(objectName);
			System.out.println("Closing JMXMP connection ...");
			jmxc.close();
			System.out.println("Done.");

		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}