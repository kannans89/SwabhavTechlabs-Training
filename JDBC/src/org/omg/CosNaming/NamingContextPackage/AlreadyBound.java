package org.omg.CosNaming.NamingContextPackage;


/**
* org/omg/CosNaming/NamingContextPackage/AlreadyBound.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/workspace/8-2-build-windows-i586-cygwin/jdk8u151/9699/corba/src/share/classes/org/omg/CosNaming/nameservice.idl
* Tuesday, September 5, 2017 7:32:37 PM PDT
*/

public final class AlreadyBound extends org.omg.CORBA.UserException
{

  public AlreadyBound ()
  {
    super(AlreadyBoundHelper.id());
  } // ctor


  public AlreadyBound (String $reason)
  {
    super(AlreadyBoundHelper.id() + "  " + $reason);
  } // ctor

} // class AlreadyBound
