package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,25);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 25;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 26;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(33554432);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,33);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 33;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,29);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _button1_click() throws Exception{
try {
		Debug.PushSubsStack("Button1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,37);
if (RapidSub.canDelegate("button1_click")) { b4a.example.main.remoteMe.runUserSub(false, "main","button1_click"); return;}
ResumableSub_Button1_Click rsub = new ResumableSub_Button1_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Button1_Click extends BA.ResumableSub {
public ResumableSub_Button1_Click(b4a.example.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _j = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _j1 = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _json = RemoteObject.createImmutable("");
RemoteObject _jsonparser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _map = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _res = RemoteObject.declareNull("b4a.example.pokemon_ditto");
RemoteObject _f = RemoteObject.declareNull("b4a.example.form");
RemoteObject _a = RemoteObject.declareNull("b4a.example.abilityitem");
RemoteObject group20;
int index20;
int groupLen20;
RemoteObject group24;
int index24;
int groupLen24;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Button1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,37);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 38;BA.debugLine="xui.MsgboxAsync(\"Hello world!\", \"B4X\")";
Debug.ShouldStop(32);
parent._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("Hello world!")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("B4X"))));
 BA.debugLineNum = 40;BA.debugLine="Dim j As HttpJob";
Debug.ShouldStop(128);
_j = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("j", _j);
 BA.debugLineNum = 41;BA.debugLine="j.Initialize(\"\", Me)";
Debug.ShouldStop(256);
_j.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("")),(Object)(main.getObject()));
 BA.debugLineNum = 43;BA.debugLine="j.Download(\"https://pokeapi.co/api/v2/pokemon/dit";
Debug.ShouldStop(1024);
_j.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(RemoteObject.createImmutable("https://pokeapi.co/api/v2/pokemon/ditto")));
 BA.debugLineNum = 44;BA.debugLine="Wait For (j) JobDone(j1 As HttpJob)";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "button1_click"), (_j));
this.state = 14;
return;
case 14:
//C
this.state = 1;
_j1 = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("j1", _j1);
;
 BA.debugLineNum = 45;BA.debugLine="If j1.Success Then";
Debug.ShouldStop(4096);
if (true) break;

case 1:
//if
this.state = 13;
if (_j1.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 3;
}else {
this.state = 12;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 46;BA.debugLine="Log( j1.GetString)";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","5327689",_j1.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ),0);
 BA.debugLineNum = 47;BA.debugLine="Dim json As String = j1.GetString";
Debug.ShouldStop(16384);
_json = _j1.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("json", _json);Debug.locals.put("json", _json);
 BA.debugLineNum = 49;BA.debugLine="Dim jsonParser As JSONParser";
Debug.ShouldStop(65536);
_jsonparser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("jsonParser", _jsonparser);
 BA.debugLineNum = 50;BA.debugLine="jsonParser.Initialize(json)";
Debug.ShouldStop(131072);
_jsonparser.runVoidMethod ("Initialize",(Object)(_json));
 BA.debugLineNum = 52;BA.debugLine="Dim map As Map = jsonParser.NextObject";
Debug.ShouldStop(524288);
_map = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_map = _jsonparser.runMethod(false,"NextObject");Debug.locals.put("map", _map);Debug.locals.put("map", _map);
 BA.debugLineNum = 53;BA.debugLine="Dim res As pokemon_ditto : res.initialize()";
Debug.ShouldStop(1048576);
_res = RemoteObject.createNew ("b4a.example.pokemon_ditto");Debug.locals.put("res", _res);
 BA.debugLineNum = 53;BA.debugLine="Dim res As pokemon_ditto : res.initialize()";
Debug.ShouldStop(1048576);
_res.runClassMethod (b4a.example.pokemon_ditto.class, "_initialize" /*RemoteObject*/ ,main.processBA);
 BA.debugLineNum = 55;BA.debugLine="res.base_experience = map.Get(\"base_experience\")";
Debug.ShouldStop(4194304);
_res.setField ("_base_experience" /*RemoteObject*/ ,BA.numberCast(int.class, _map.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("base_experience"))))));
 BA.debugLineNum = 56;BA.debugLine="res.height = map.Get(\"height\")";
Debug.ShouldStop(8388608);
_res.setField ("_height" /*RemoteObject*/ ,BA.numberCast(int.class, _map.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("height"))))));
 BA.debugLineNum = 57;BA.debugLine="res.forms = GetForms( map.Get(\"forms\") )";
Debug.ShouldStop(16777216);
_res.setField ("_forms" /*RemoteObject*/ ,_getforms(RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _map.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("forms")))))));
 BA.debugLineNum = 58;BA.debugLine="res.abilities = GetAbilities( map.Get(\"abilities";
Debug.ShouldStop(33554432);
_res.setField ("_abilities" /*RemoteObject*/ ,_getabilities(RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _map.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("abilities")))))));
 BA.debugLineNum = 60;BA.debugLine="Log(res.base_experience)";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","5327703",BA.NumberToString(_res.getField(true,"_base_experience" /*RemoteObject*/ )),0);
 BA.debugLineNum = 61;BA.debugLine="Log(res.height)";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","5327704",BA.NumberToString(_res.getField(true,"_height" /*RemoteObject*/ )),0);
 BA.debugLineNum = 62;BA.debugLine="For Each f As form In res.forms";
Debug.ShouldStop(536870912);
if (true) break;

case 4:
//for
this.state = 7;
group20 = _res.getField(false,"_forms" /*RemoteObject*/ );
index20 = 0;
groupLen20 = group20.runMethod(true,"getSize").<Integer>get();
Debug.locals.put("f", _f);
this.state = 15;
if (true) break;

case 15:
//C
this.state = 7;
if (index20 < groupLen20) {
this.state = 6;
_f = (group20.runMethod(false,"Get",index20));Debug.locals.put("f", _f);}
if (true) break;

case 16:
//C
this.state = 15;
index20++;
Debug.locals.put("f", _f);
if (true) break;

case 6:
//C
this.state = 16;
 BA.debugLineNum = 63;BA.debugLine="Log(\"     \" & f.name)";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","5327706",RemoteObject.concat(RemoteObject.createImmutable("     "),_f.getField(true,"_name" /*RemoteObject*/ )),0);
 BA.debugLineNum = 64;BA.debugLine="Log(\"     \" & f.url)";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","5327707",RemoteObject.concat(RemoteObject.createImmutable("     "),_f.getField(true,"_url" /*RemoteObject*/ )),0);
 if (true) break;
if (true) break;
Debug.locals.put("f", _f);
;
 BA.debugLineNum = 66;BA.debugLine="For Each a As abilityItem In res.abilities";
Debug.ShouldStop(2);

case 7:
//for
this.state = 10;
group24 = _res.getField(false,"_abilities" /*RemoteObject*/ );
index24 = 0;
groupLen24 = group24.runMethod(true,"getSize").<Integer>get();
Debug.locals.put("a", _a);
this.state = 17;
if (true) break;

case 17:
//C
this.state = 10;
if (index24 < groupLen24) {
this.state = 9;
_a = (group24.runMethod(false,"Get",index24));Debug.locals.put("a", _a);}
if (true) break;

case 18:
//C
this.state = 17;
index24++;
Debug.locals.put("a", _a);
if (true) break;

case 9:
//C
this.state = 18;
 BA.debugLineNum = 67;BA.debugLine="Log(\"     \" & a.is_hidden)";
Debug.ShouldStop(4);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","5327710",RemoteObject.concat(RemoteObject.createImmutable("     "),_a.getField(true,"_is_hidden" /*RemoteObject*/ )),0);
 BA.debugLineNum = 68;BA.debugLine="Log(\"     \" & a.slot)";
Debug.ShouldStop(8);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","5327711",RemoteObject.concat(RemoteObject.createImmutable("     "),_a.getField(true,"_slot" /*RemoteObject*/ )),0);
 BA.debugLineNum = 69;BA.debugLine="Log(\"     \" & a.ability.name)";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","5327712",RemoteObject.concat(RemoteObject.createImmutable("     "),_a.getField(false,"_ability" /*RemoteObject*/ ).getField(true,"_name" /*RemoteObject*/ )),0);
 BA.debugLineNum = 70;BA.debugLine="Log(\"     \" & a.ability.url)";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","5327713",RemoteObject.concat(RemoteObject.createImmutable("     "),_a.getField(false,"_ability" /*RemoteObject*/ ).getField(true,"_url" /*RemoteObject*/ )),0);
 if (true) break;
if (true) break;

case 10:
//C
this.state = 13;
Debug.locals.put("a", _a);
;
 if (true) break;

case 12:
//C
this.state = 13;
 BA.debugLineNum = 74;BA.debugLine="xui.MsgboxAsync(j1.ErrorMessage, \"Sucedio un err";
Debug.ShouldStop(512);
parent._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence(_j1.getField(true,"_errormessage" /*RemoteObject*/ ))),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Sucedio un error"))));
 if (true) break;

case 13:
//C
this.state = -1;
;
 BA.debugLineNum = 77;BA.debugLine="j.Release";
Debug.ShouldStop(4096);
_j.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _jobdone(RemoteObject _j1) throws Exception{
}
public static void  _button2_click() throws Exception{
try {
		Debug.PushSubsStack("Button2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,109);
if (RapidSub.canDelegate("button2_click")) { b4a.example.main.remoteMe.runUserSub(false, "main","button2_click"); return;}
ResumableSub_Button2_Click rsub = new ResumableSub_Button2_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Button2_Click extends BA.ResumableSub {
public ResumableSub_Button2_Click(b4a.example.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _j = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _respuesta = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _json = RemoteObject.createImmutable("");
RemoteObject _jsonparser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _datos = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _t = RemoteObject.declareNull("b4a.example.tarea");
RemoteObject group11;
int index11;
int groupLen11;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Button2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,109);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 110;BA.debugLine="Dim j As HttpJob";
Debug.ShouldStop(8192);
_j = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("j", _j);
 BA.debugLineNum = 111;BA.debugLine="j.Initialize(\"\", Me)";
Debug.ShouldStop(16384);
_j.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("")),(Object)(main.getObject()));
 BA.debugLineNum = 113;BA.debugLine="j.Download(\"https://jsonplaceholder.typicode.com/";
Debug.ShouldStop(65536);
_j.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(RemoteObject.createImmutable("https://jsonplaceholder.typicode.com/todos")));
 BA.debugLineNum = 114;BA.debugLine="Wait For (j) JobDone( respuesta As HttpJob)";
Debug.ShouldStop(131072);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "button2_click"), (_j));
this.state = 11;
return;
case 11:
//C
this.state = 1;
_respuesta = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("respuesta", _respuesta);
;
 BA.debugLineNum = 115;BA.debugLine="If respuesta.Success Then";
Debug.ShouldStop(262144);
if (true) break;

case 1:
//if
this.state = 10;
if (_respuesta.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 3;
}else {
this.state = 9;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 116;BA.debugLine="Log( respuesta.GetString)";
Debug.ShouldStop(524288);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","5524295",_respuesta.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ),0);
 BA.debugLineNum = 117;BA.debugLine="Dim json As String = respuesta.GetString";
Debug.ShouldStop(1048576);
_json = _respuesta.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("json", _json);Debug.locals.put("json", _json);
 BA.debugLineNum = 118;BA.debugLine="Dim jsonParser As JSONParser";
Debug.ShouldStop(2097152);
_jsonparser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("jsonParser", _jsonparser);
 BA.debugLineNum = 119;BA.debugLine="jsonParser.Initialize(json)";
Debug.ShouldStop(4194304);
_jsonparser.runVoidMethod ("Initialize",(Object)(_json));
 BA.debugLineNum = 121;BA.debugLine="Dim datos As List = GetTareas( jsonParser.NextAr";
Debug.ShouldStop(16777216);
_datos = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_datos = _gettareas(_jsonparser.runMethod(false,"NextArray"));Debug.locals.put("datos", _datos);Debug.locals.put("datos", _datos);
 BA.debugLineNum = 122;BA.debugLine="For Each t As Tarea In datos";
Debug.ShouldStop(33554432);
if (true) break;

case 4:
//for
this.state = 7;
group11 = _datos;
index11 = 0;
groupLen11 = group11.runMethod(true,"getSize").<Integer>get();
Debug.locals.put("t", _t);
this.state = 12;
if (true) break;

case 12:
//C
this.state = 7;
if (index11 < groupLen11) {
this.state = 6;
_t = (group11.runMethod(false,"Get",index11));Debug.locals.put("t", _t);}
if (true) break;

case 13:
//C
this.state = 12;
index11++;
Debug.locals.put("t", _t);
if (true) break;

case 6:
//C
this.state = 13;
 BA.debugLineNum = 123;BA.debugLine="Log( t.title)";
Debug.ShouldStop(67108864);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","5524302",_t.getField(true,"_title" /*RemoteObject*/ ),0);
 BA.debugLineNum = 124;BA.debugLine="Log( t.userId )";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","5524303",BA.NumberToString(_t.getField(true,"_userid" /*RemoteObject*/ )),0);
 BA.debugLineNum = 125;BA.debugLine="Log( t.completed )";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","5524304",BA.ObjectToString(_t.getField(true,"_completed" /*RemoteObject*/ )),0);
 if (true) break;
if (true) break;

case 7:
//C
this.state = 10;
Debug.locals.put("t", _t);
;
 if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 128;BA.debugLine="xui.MsgboxAsync(respuesta.ErrorMessage, \"Sucedio";
Debug.ShouldStop(-2147483648);
parent._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence(_respuesta.getField(true,"_errormessage" /*RemoteObject*/ ))),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Sucedio un error"))));
 if (true) break;

case 10:
//C
this.state = -1;
;
 BA.debugLineNum = 130;BA.debugLine="End Sub";
Debug.ShouldStop(2);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _button3_click() throws Exception{
try {
		Debug.PushSubsStack("Button3_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,147);
if (RapidSub.canDelegate("button3_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button3_click");}
 BA.debugLineNum = 147;BA.debugLine="Private Sub Button3_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 148;BA.debugLine="StartActivity( CrudPaises)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._crudpaises.getObject())));
 BA.debugLineNum = 149;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getabilities(RemoteObject _table) throws Exception{
try {
		Debug.PushSubsStack("GetAbilities (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,92);
if (RapidSub.canDelegate("getabilities")) { return b4a.example.main.remoteMe.runUserSub(false, "main","getabilities", _table);}
RemoteObject _lst = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _a = RemoteObject.declareNull("b4a.example.abilityitem");
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _m2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("table", _table);
 BA.debugLineNum = 92;BA.debugLine="Public Sub GetAbilities(table As List) As List";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="Dim lst As List : lst.initialize";
Debug.ShouldStop(268435456);
_lst = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("lst", _lst);
 BA.debugLineNum = 93;BA.debugLine="Dim lst As List : lst.initialize";
Debug.ShouldStop(268435456);
_lst.runVoidMethod ("Initialize");
 BA.debugLineNum = 94;BA.debugLine="For i = 0 To table.Size-1";
Debug.ShouldStop(536870912);
{
final int step3 = 1;
final int limit3 = RemoteObject.solve(new RemoteObject[] {_table.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 95;BA.debugLine="Dim a As abilityItem :  a.Initialize";
Debug.ShouldStop(1073741824);
_a = RemoteObject.createNew ("b4a.example.abilityitem");Debug.locals.put("a", _a);
 BA.debugLineNum = 95;BA.debugLine="Dim a As abilityItem :  a.Initialize";
Debug.ShouldStop(1073741824);
_a.runClassMethod (b4a.example.abilityitem.class, "_initialize" /*RemoteObject*/ ,main.processBA);
 BA.debugLineNum = 96;BA.debugLine="Dim m As Map = table.Get(i)";
Debug.ShouldStop(-2147483648);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_m = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _table.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("m", _m);Debug.locals.put("m", _m);
 BA.debugLineNum = 97;BA.debugLine="a.is_hidden = m.Get(\"is_hidden\")";
Debug.ShouldStop(1);
_a.setField ("_is_hidden" /*RemoteObject*/ ,BA.ObjectToBoolean(_m.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("is_hidden"))))));
 BA.debugLineNum = 98;BA.debugLine="a.slot = m.Get(\"slot\")";
Debug.ShouldStop(2);
_a.setField ("_slot" /*RemoteObject*/ ,BA.numberCast(int.class, _m.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("slot"))))));
 BA.debugLineNum = 100;BA.debugLine="Dim m2 As Map = m.Get(\"ability\")";
Debug.ShouldStop(8);
_m2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_m2 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _m.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("ability")))));Debug.locals.put("m2", _m2);Debug.locals.put("m2", _m2);
 BA.debugLineNum = 101;BA.debugLine="a.ability.Initialize";
Debug.ShouldStop(16);
_a.getField(false,"_ability" /*RemoteObject*/ ).runClassMethod (b4a.example.ability.class, "_initialize" /*RemoteObject*/ ,main.processBA);
 BA.debugLineNum = 102;BA.debugLine="a.ability.name = m2.Get(\"name\")";
Debug.ShouldStop(32);
_a.getField(false,"_ability" /*RemoteObject*/ ).setField ("_name" /*RemoteObject*/ ,BA.ObjectToString(_m2.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name"))))));
 BA.debugLineNum = 103;BA.debugLine="a.ability.url = m2.Get(\"url\")";
Debug.ShouldStop(64);
_a.getField(false,"_ability" /*RemoteObject*/ ).setField ("_url" /*RemoteObject*/ ,BA.ObjectToString(_m2.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("url"))))));
 BA.debugLineNum = 104;BA.debugLine="lst.Add(a)";
Debug.ShouldStop(128);
_lst.runVoidMethod ("Add",(Object)((_a)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 106;BA.debugLine="Return lst";
Debug.ShouldStop(512);
if (true) return _lst;
 BA.debugLineNum = 107;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getforms(RemoteObject _table) throws Exception{
try {
		Debug.PushSubsStack("GetForms (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,80);
if (RapidSub.canDelegate("getforms")) { return b4a.example.main.remoteMe.runUserSub(false, "main","getforms", _table);}
RemoteObject _lst = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _f = RemoteObject.declareNull("b4a.example.form");
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("table", _table);
 BA.debugLineNum = 80;BA.debugLine="Public Sub GetForms( table As List) As List";
Debug.ShouldStop(32768);
 BA.debugLineNum = 81;BA.debugLine="Dim lst As List : lst.initialize";
Debug.ShouldStop(65536);
_lst = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("lst", _lst);
 BA.debugLineNum = 81;BA.debugLine="Dim lst As List : lst.initialize";
Debug.ShouldStop(65536);
_lst.runVoidMethod ("Initialize");
 BA.debugLineNum = 82;BA.debugLine="For i = 0 To table.Size-1";
Debug.ShouldStop(131072);
{
final int step3 = 1;
final int limit3 = RemoteObject.solve(new RemoteObject[] {_table.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 83;BA.debugLine="Dim f As form :  f.Initialize";
Debug.ShouldStop(262144);
_f = RemoteObject.createNew ("b4a.example.form");Debug.locals.put("f", _f);
 BA.debugLineNum = 83;BA.debugLine="Dim f As form :  f.Initialize";
Debug.ShouldStop(262144);
_f.runClassMethod (b4a.example.form.class, "_initialize" /*RemoteObject*/ ,main.processBA);
 BA.debugLineNum = 84;BA.debugLine="Dim m As Map = table.Get(i)";
Debug.ShouldStop(524288);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_m = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _table.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("m", _m);Debug.locals.put("m", _m);
 BA.debugLineNum = 85;BA.debugLine="f.name = m.Get(\"name\")";
Debug.ShouldStop(1048576);
_f.setField ("_name" /*RemoteObject*/ ,BA.ObjectToString(_m.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name"))))));
 BA.debugLineNum = 86;BA.debugLine="f.url = m.Get(\"url\")";
Debug.ShouldStop(2097152);
_f.setField ("_url" /*RemoteObject*/ ,BA.ObjectToString(_m.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("url"))))));
 BA.debugLineNum = 87;BA.debugLine="lst.Add(f)";
Debug.ShouldStop(4194304);
_lst.runVoidMethod ("Add",(Object)((_f)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 89;BA.debugLine="Return lst";
Debug.ShouldStop(16777216);
if (true) return _lst;
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _gettareas(RemoteObject _tabla) throws Exception{
try {
		Debug.PushSubsStack("GetTareas (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,132);
if (RapidSub.canDelegate("gettareas")) { return b4a.example.main.remoteMe.runUserSub(false, "main","gettareas", _tabla);}
RemoteObject _lst = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
int _i = 0;
RemoteObject _t = RemoteObject.declareNull("b4a.example.tarea");
Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 132;BA.debugLine="Private Sub GetTareas( tabla As List) As List";
Debug.ShouldStop(8);
 BA.debugLineNum = 133;BA.debugLine="Dim lst As List : lst.initialize";
Debug.ShouldStop(16);
_lst = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("lst", _lst);
 BA.debugLineNum = 133;BA.debugLine="Dim lst As List : lst.initialize";
Debug.ShouldStop(16);
_lst.runVoidMethod ("Initialize");
 BA.debugLineNum = 134;BA.debugLine="Dim m As Map";
Debug.ShouldStop(32);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("m", _m);
 BA.debugLineNum = 135;BA.debugLine="For i = 0 To tabla.Size -1";
Debug.ShouldStop(64);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {_tabla.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 136;BA.debugLine="Dim t As Tarea : t.initialize";
Debug.ShouldStop(128);
_t = RemoteObject.createNew ("b4a.example.tarea");Debug.locals.put("t", _t);
 BA.debugLineNum = 136;BA.debugLine="Dim t As Tarea : t.initialize";
Debug.ShouldStop(128);
_t.runClassMethod (b4a.example.tarea.class, "_initialize" /*RemoteObject*/ ,main.processBA);
 BA.debugLineNum = 137;BA.debugLine="m = tabla.Get(i)";
Debug.ShouldStop(256);
_m = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _tabla.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("m", _m);
 BA.debugLineNum = 138;BA.debugLine="t.id = m.Get(\"id\")";
Debug.ShouldStop(512);
_t.setField ("_id" /*RemoteObject*/ ,BA.numberCast(int.class, _m.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 139;BA.debugLine="t.userId = m.Get(\"userId\")";
Debug.ShouldStop(1024);
_t.setField ("_userid" /*RemoteObject*/ ,BA.numberCast(int.class, _m.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("userId"))))));
 BA.debugLineNum = 140;BA.debugLine="t.title = m.Get(\"title\")";
Debug.ShouldStop(2048);
_t.setField ("_title" /*RemoteObject*/ ,BA.ObjectToString(_m.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("title"))))));
 BA.debugLineNum = 141;BA.debugLine="t.completed = m.Get(\"completed\")";
Debug.ShouldStop(4096);
_t.setField ("_completed" /*RemoteObject*/ ,BA.ObjectToBoolean(_m.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("completed"))))));
 BA.debugLineNum = 142;BA.debugLine="lst.Add(t)";
Debug.ShouldStop(8192);
_lst.runVoidMethod ("Add",(Object)((_t)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 144;BA.debugLine="Return lst";
Debug.ShouldStop(32768);
if (true) return _lst;
 BA.debugLineNum = 145;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
crudpaises_subs_0._process_globals();
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
form.myClass = BA.getDeviceClass ("b4a.example.form");
pokemon_ditto.myClass = BA.getDeviceClass ("b4a.example.pokemon_ditto");
ability.myClass = BA.getDeviceClass ("b4a.example.ability");
abilityitem.myClass = BA.getDeviceClass ("b4a.example.abilityitem");
tarea.myClass = BA.getDeviceClass ("b4a.example.tarea");
pais.myClass = BA.getDeviceClass ("b4a.example.pais");
crudpaises.myClass = BA.getDeviceClass ("b4a.example.crudpaises");
httputils2service.myClass = BA.getDeviceClass ("b4a.example.httputils2service");
httpjob.myClass = BA.getDeviceClass ("b4a.example.httpjob");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}