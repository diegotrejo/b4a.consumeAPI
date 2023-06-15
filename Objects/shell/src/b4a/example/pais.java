
package b4a.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class pais {
    public static RemoteObject myClass;
	public pais() {
	}
    public static PCBA staticBA = new PCBA(null, pais.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _codigopais = RemoteObject.createImmutable(0);
public static RemoteObject _nombre = RemoteObject.createImmutable("");
public static RemoteObject _poblacion = RemoteObject.createImmutable(0);
public static RemoteObject _codigoiso = RemoteObject.createImmutable("");
public static RemoteObject _moneda = RemoteObject.createImmutable("");
public static RemoteObject _capital = RemoteObject.createImmutable("");
public static RemoteObject _idioma = RemoteObject.createImmutable("");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.crudpaises _crudpaises = null;
public static b4a.example.httputils2service _httputils2service = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"capital",_ref.getField(false, "_capital"),"codigoISO",_ref.getField(false, "_codigoiso"),"codigoPais",_ref.getField(false, "_codigopais"),"idioma",_ref.getField(false, "_idioma"),"moneda",_ref.getField(false, "_moneda"),"nombre",_ref.getField(false, "_nombre"),"poblacion",_ref.getField(false, "_poblacion")};
}
}