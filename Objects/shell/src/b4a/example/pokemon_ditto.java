
package b4a.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class pokemon_ditto {
    public static RemoteObject myClass;
	public pokemon_ditto() {
	}
    public static PCBA staticBA = new PCBA(null, pokemon_ditto.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _abilities = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _base_experience = RemoteObject.createImmutable(0);
public static RemoteObject _forms = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _height = RemoteObject.createImmutable(0);
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.crudpaises _crudpaises = null;
public static b4a.example.httputils2service _httputils2service = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"abilities",_ref.getField(false, "_abilities"),"base_experience",_ref.getField(false, "_base_experience"),"forms",_ref.getField(false, "_forms"),"height",_ref.getField(false, "_height")};
}
}