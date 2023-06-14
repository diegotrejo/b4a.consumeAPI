package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class pokemon_ditto_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Public abilities As List";
pokemon_ditto._abilities = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");__ref.setField("_abilities",pokemon_ditto._abilities);
 //BA.debugLineNum = 3;BA.debugLine="Public base_experience As Int";
pokemon_ditto._base_experience = RemoteObject.createImmutable(0);__ref.setField("_base_experience",pokemon_ditto._base_experience);
 //BA.debugLineNum = 4;BA.debugLine="Public forms As List";
pokemon_ditto._forms = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");__ref.setField("_forms",pokemon_ditto._forms);
 //BA.debugLineNum = 5;BA.debugLine="Public height As Int";
pokemon_ditto._height = RemoteObject.createImmutable(0);__ref.setField("_height",pokemon_ditto._height);
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (pokemon_ditto) ","pokemon_ditto",3,__ref.getField(false, "ba"),__ref,9);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "pokemon_ditto","initialize", __ref, _ba);}
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