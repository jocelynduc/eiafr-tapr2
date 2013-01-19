package jmx;
/* File:   Agent.java
 * What:	  A simple JMX Agent
 * Who:	      Michel Rast, EIF (michel.rast@eif.ch)
 *
 * History:
 * 2001.06.04 Modification for JDMK 4.2 (Michel Rast)
 * 2006.04.18 Ported to JMX (Rudolf Scheurer, EIF, scheurer@eif.ch)
 * 2008.12.10 Minor modifications (Rudolf Scheurer, EIA-FR, scheurer@hefr.ch)
 */

import javax.management.*;
import com.sun.jdmk.comm.HtmlAdaptorServer;

public class Agent {

  public static void main(String argv[]) {
    try {
      // Instanciate the MBean server
      System.out.println("Create MBean server ...");
      MBeanServer mBeanServer = MBeanServerFactory.createMBeanServer();

      // Create and start an HTML protocol adaptor
      System.out.println("Create, register and start an HTML Adaptor server ...");
      HtmlAdaptorServer htmlAdaptor = new HtmlAdaptorServer();
      mBeanServer.registerMBean(htmlAdaptor, null);
      htmlAdaptor.start();
      System.out.println("HTML Adaptor server is running ...");

      // P2: two instances of MBean Simple
      Simple simple1 = new Simple();
      Simple simple2 = new Simple();
      ObjectName objectName1 = new
    		  ObjectName("DefaultDomain:type=Simple,name=Duc");
      mBeanServer.registerMBean(simple1, objectName1 );
      ObjectName objectName2 = new
    		  ObjectName("DefaultDomain:type=Simple,name=Marcacci");
      mBeanServer.registerMBean(simple2, objectName2 );
    }  
    catch(Exception e) {
      e.printStackTrace();
      return;
    }
  }
}