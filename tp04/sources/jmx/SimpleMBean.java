package jmx;
/* File:	  SimpleMBean.java
 * What:	  Simple MBean interface
 * Who:	      Michel Rast, EIF (michel.rast@eif.ch)
 *
 * History:
 * 2001.06.04 Modification for JDMK 4.2 (Michel Rast)
 * 2006.04.18 Ported to JMX (Rudolf Scheurer, EIF, scheurer@eif.ch)
 * 2008.12.10 Minor modifications (Rudolf Scheurer, EIA-FR, scheurer@hefr.ch)
 */

public interface SimpleMBean {
  public String getState();
  public void setState(String s);
  public String getMaster();
  public void setMaster(String s);
  public int getNbChanges();
  public void reset();
}