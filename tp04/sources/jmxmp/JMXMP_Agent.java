package jmxmp;

/* File:   Agent.java
 * What:	  A simple JMX Agent
 * Who:	      Michel Rast, EIF (michel.rast@eif.ch)
 *
 * History:
 * 2001.06.04 Modification for JDMK 4.2 (Michel Rast)
 * 2006.04.18 Ported to JMX (Rudolf Scheurer, EIF, scheurer@eif.ch)
 * 2008.12.10 Minor modifications (Rudolf Scheurer, EIA-FR, scheurer@hefr.ch)
 */

import java.lang.management.ManagementFactory;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

import com.sun.jdmk.comm.HtmlAdaptorServer;

public class JMXMP_Agent {

	public static void main(String argv[]) {
		try {
			// Instanciate the MBean server
			System.out.println("Create MBean server ...");
			MBeanServer mBeanServer = ManagementFactory
					.getPlatformMBeanServer();
			// Create and start an HTML protocol adaptor
			System.out
					.println("Create, register and start an HTML Adaptor server ...");
			HtmlAdaptorServer htmlAdaptor = new HtmlAdaptorServer();
			mBeanServer.registerMBean(htmlAdaptor, null);
			htmlAdaptor.start();
			ObjectName objectName = new ObjectName(
					"Connectors:type=JMXMP,id=remote");
			JMXServiceURL url = new JMXServiceURL("jmxmp", null, 1234);
			JMXConnectorServer jmxConnectorServer = JMXConnectorServerFactory
					.newJMXConnectorServer(url, null, mBeanServer);
			mBeanServer.registerMBean(jmxConnectorServer, objectName);
			jmxConnectorServer.start();
		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}