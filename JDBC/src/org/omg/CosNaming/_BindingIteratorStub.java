package org.omg.CosNaming;


/**
* org/omg/CosNaming/_BindingIteratorStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/workspace/8-2-build-windows-i586-cygwin/jdk8u151/9699/corba/src/share/classes/org/omg/CosNaming/nameservice.idl
* Tuesday, September 5, 2017 7:32:37 PM PDT
*/


/**
   * The BindingIterator interface allows a client to iterate through
   * the bindings using the next_one or next_n operations.
   * 
   * The bindings iterator is obtained by using the <tt>list</tt>
   * method on the <tt>NamingContext</tt>. 
   * @see org.omg.CosNaming.NamingContext#list
   */
public class _BindingIteratorStub extends org.omg.CORBA.portable.ObjectImpl implements org.omg.CosNaming.BindingIterator
{


  /**
     * This operation returns the next binding. If there are no more
     * bindings, false is returned.
     * 
     * @param b the returned binding
     */
  public boolean next_one (org.omg.CosNaming.BindingHolder b)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("next_one", true);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                b.value = org.omg.CosNaming.BindingHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return next_one (b        );
            } finally {
                _releaseReply ($in);
            }
  } // next_one


  /**
     * This operation returns at most the requested number of bindings.
     * 
     * @param how_many the maximum number of bindings tro return <p>
     * 
     * @param bl the returned bindings
     */
  public boolean next_n (int how_many, org.omg.CosNaming.BindingListHolder bl)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("next_n", true);
                $out.write_ulong (how_many);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                bl.value = org.omg.CosNaming.BindingListHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return next_n (how_many, bl        );
            } finally {
                _releaseReply ($in);
            }
  } // next_n


  /**
     * This operation destroys the iterator.
     */
  public void destroy ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("destroy", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                destroy (        );
            } finally {
                _releaseReply ($in);
            }
  } // destroy

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:omg.org/CosNaming/BindingIterator:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _BindingIteratorStub
