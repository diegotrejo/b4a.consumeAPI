
package b4a.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class abilityitem {
    public static RemoteObject myClass;
	public abilityitem() {
	}
    public static PCBA staticBA = new PCBA(null, abilityitem.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _ability = RemoteObject.declareNull("b4a.example.ability");
public static RemoteObject _is_hidden = RemoteObject.createImmutable(false);
public static RemoteObject _slot = RemoteObject.createImmutable(0);
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.httputils2service _httputils2service = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"is_hidden",_ref.getField(false, "_is_hidden"),"slot",_ref.getField(false, "_slot")};
}
}