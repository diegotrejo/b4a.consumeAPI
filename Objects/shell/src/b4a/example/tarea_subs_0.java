package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class tarea_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Public userId As Int";
tarea._userid = RemoteObject.createImmutable(0);__ref.setField("_userid",tarea._userid);
 //BA.debugLineNum = 3;BA.debugLine="Public id As Int";
tarea._id = RemoteObject.createImmutable(0);__ref.setField("_id",tarea._id);
 //BA.debugLineNum = 4;BA.debugLine="Public title As String";
tarea._title = RemoteObject.createImmutable("");__ref.setField("_title",tarea._title);
 //BA.debugLineNum = 5;BA.debugLine="Public completed As Boolean";
tarea._completed = RemoteObject.createImmutable(false);__ref.setField("_completed",tarea._completed);
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (tarea) ","tarea",6,__ref.getField(false, "ba"),__ref,9);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "tarea","initialize", __ref, _ba);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 9;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(256);
 BA.debugLineNum = 11;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}