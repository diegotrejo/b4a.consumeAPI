package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class abilityitem_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Public ability As ability";
abilityitem._ability = RemoteObject.createNew ("b4a.example.ability");__ref.setField("_ability",abilityitem._ability);
 //BA.debugLineNum = 3;BA.debugLine="Public is_hidden As Boolean";
abilityitem._is_hidden = RemoteObject.createImmutable(false);__ref.setField("_is_hidden",abilityitem._is_hidden);
 //BA.debugLineNum = 4;BA.debugLine="Public slot As Int";
abilityitem._slot = RemoteObject.createImmutable(0);__ref.setField("_slot",abilityitem._slot);
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (abilityitem) ","abilityitem",5,__ref.getField(false, "ba"),__ref,8);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "abilityitem","initialize", __ref, _ba);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 8;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(128);
 BA.debugLineNum = 10;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}