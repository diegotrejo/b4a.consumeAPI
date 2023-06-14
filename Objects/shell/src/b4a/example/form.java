
package b4a.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class form {
    public static RemoteObject myClass;
	public form() {
	}
    public static PCBA staticBA = new PCBA(null, form.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _name = RemoteObject.createImmutable("");
public static RemoteObject _url = RemoteObject.createImmutable("");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.httputils2service _httputils2service = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"name",_ref.getField(false, "_name"),"url",_ref.getField(false, "_url")};
}
}