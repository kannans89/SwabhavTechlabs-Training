package org.omg.CosNaming.NamingContextPackage;


/**
* org/omg/CosNaming/NamingContextPackage/NotFoundReason.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/workspace/8-2-build-windows-i586-cygwin/jdk8u151/9699/corba/src/share/classes/org/omg/CosNaming/nameservice.idl
* Tuesday, September 5, 2017 7:32:37 PM PDT
*/


/**
         * Indicates the reason for not able to resolve.
         */
public class NotFoundReason implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 3;
  private static org.omg.CosNaming.NamingContextPackage.NotFoundReason[] __array = new org.omg.CosNaming.NamingContextPackage.NotFoundReason [__size];

  public static final int _missing_node = 0;
  public static final org.omg.CosNaming.NamingContextPackage.NotFoundReason missing_node = new org.omg.CosNaming.NamingContextPackage.NotFoundReason(_missing_node);
  public static final int _not_context = 1;
  public static final org.omg.CosNaming.NamingContextPackage.NotFoundReason not_context = new org.omg.CosNaming.NamingContextPackage.NotFoundReason(_not_context);
  public static final int _not_object = 2;
  public static final org.omg.CosNaming.NamingContextPackage.NotFoundReason not_object = new org.omg.CosNaming.NamingContextPackage.NotFoundReason(_not_object);

  public int value ()
  {
    return __value;
  }

  public static org.omg.CosNaming.NamingContextPackage.NotFoundReason from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected NotFoundReason (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class NotFoundReason
