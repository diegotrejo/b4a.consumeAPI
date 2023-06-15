package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class pais_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Public codigoPais As Int";
pais._codigopais = RemoteObject.createImmutable(0);__ref.setField("_codigopais",pais._codigopais);
 //BA.debugLineNum = 3;BA.debugLine="Public nombre As String";
pais._nombre = RemoteObject.createImmutable("");__ref.setField("_nombre",pais._nombre);
 //BA.debugLineNum = 4;BA.debugLine="Public poblacion As Int";
pais._poblacion = RemoteObject.createImmutable(0);__ref.setField("_poblacion",pais._poblacion);
 //BA.debugLineNum = 5;BA.debugLine="Public codigoISO As String";
pais._codigoiso = RemoteObject.createImmutable("");__ref.setField("_codigoiso",pais._codigoiso);
 //BA.debugLineNum = 6;BA.debugLine="Public moneda As String";
pais._moneda = RemoteObject.createImmutable("");__ref.setField("_moneda",pais._moneda);
 //BA.debugLineNum = 7;BA.debugLine="Public capital As String";
pais._capital = RemoteObject.createImmutable("");__ref.setField("_capital",pais._capital);
 //BA.debugLineNum = 8;BA.debugLine="Public idioma As String";
pais._idioma = RemoteObject.createImmutable("");__ref.setField("_idioma",pais._idioma);
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (pais) ","pais",7,__ref.getField(false, "ba"),__ref,12);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "pais","initialize", __ref, _ba);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 12;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(2048);
 BA.debugLineNum = 14;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}