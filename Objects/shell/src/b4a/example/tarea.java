
package b4a.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class tarea {
    public static RemoteObject myClass;
	public tarea() {
	}
    public static PCBA staticBA = new PCBA(null, tarea.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _userid = RemoteObject.createImmutable(0);
public static RemoteObject _id = RemoteObject.createImmutable(0);
public static RemoteObject _title = RemoteObject.createImmutable("");
public static RemoteObject _completed = RemoteObject.createImmutable(false);
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.crudpaises _crudpaises = null;
public static b4a.example.httputils2service _httputils2service = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"completed",_ref.getField(false, "_completed"),"id",_ref.getField(false, "_id"),"title",_ref.getField(false, "_title"),"userId",_ref.getField(false, "_userid")};
}
}