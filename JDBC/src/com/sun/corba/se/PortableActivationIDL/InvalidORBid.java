package com.sun.corba.se.PortableActivationIDL;


/**
* com/sun/corba/se/PortableActivationIDL/InvalidORBid.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/workspace/8-2-build-windows-i586-cygwin/jdk8u151/9699/corba/src/share/classes/com/sun/corba/se/PortableActivationIDL/activation.idl
* Tuesday, September 5, 2017 7:32:37 PM PDT
*/

public final class InvalidORBid extends org.omg.CORBA.UserException
{

  public InvalidORBid ()
  {
    super(InvalidORBidHelper.id());
  } // ctor


  public InvalidORBid (String $reason)
  {
    super(InvalidORBidHelper.id() + "  " + $reason);
  } // ctor

} // class InvalidORBid