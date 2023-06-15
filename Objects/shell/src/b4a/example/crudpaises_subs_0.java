package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class crudpaises_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (crudpaises) ","crudpaises",8,crudpaises.mostCurrent.activityBA,crudpaises.mostCurrent,25);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.crudpaises.remoteMe.runUserSub(false, "crudpaises","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 25;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 27;BA.debugLine="Activity.LoadLayout(\"CrudPaises\")";
Debug.ShouldStop(67108864);
crudpaises.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("CrudPaises")),crudpaises.mostCurrent.activityBA);
 BA.debugLineNum = 29;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Activity_Pause (crudpaises) ","crudpaises",8,crudpaises.mostCurrent.activityBA,crudpaises.mostCurrent,35);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.crudpaises.remoteMe.runUserSub(false, "crudpaises","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 35;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Activity_Resume (crudpaises) ","crudpaises",8,crudpaises.mostCurrent.activityBA,crudpaises.mostCurrent,31);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.crudpaises.remoteMe.runUserSub(false, "crudpaises","activity_resume");}
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _cmdadd_click() throws Exception{
try {
		Debug.PushSubsStack("cmdAdd_Click (crudpaises) ","crudpaises",8,crudpaises.mostCurrent.activityBA,crudpaises.mostCurrent,40);
if (RapidSub.canDelegate("cmdadd_click")) { b4a.example.crudpaises.remoteMe.runUserSub(false, "crudpaises","cmdadd_click"); return;}
ResumableSub_cmdAdd_Click rsub = new ResumableSub_cmdAdd_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_cmdAdd_Click extends BA.ResumableSub {
public ResumableSub_cmdAdd_Click(b4a.example.crudpaises parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.crudpaises parent;
RemoteObject _p = RemoteObject.declareNull("b4a.example.pais");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("cmdAdd_Click (crudpaises) ","crudpaises",8,crudpaises.mostCurrent.activityBA,crudpaises.mostCurrent,40);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 41;BA.debugLine="Wait For(CrearPais( txtcodigoPais.Text, txtcodigo";
Debug.ShouldStop(256);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", crudpaises.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "crudpaises", "cmdadd_click"), _crearpais(BA.numberCast(int.class, parent.mostCurrent._txtcodigopais.runMethod(true,"getText")),parent.mostCurrent._txtcodigoiso.runMethod(true,"getText"),parent.mostCurrent._txtnombre.runMethod(true,"getText"),parent.mostCurrent._txtcapital.runMethod(true,"getText"),parent.mostCurrent._txtidioma.runMethod(true,"getText"),parent.mostCurrent._txtmoneda.runMethod(true,"getText"),BA.numberCast(int.class, parent.mostCurrent._txtpoblacion.runMethod(true,"getText"))));
this.state = 7;
return;
case 7:
//C
this.state = 1;
_p = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("p", _p);
;
 BA.debugLineNum = 43;BA.debugLine="If p.codigoPais <> 0 Then";
Debug.ShouldStop(1024);
if (true) break;

case 1:
//if
this.state = 6;
if (RemoteObject.solveBoolean("!",_p.getField(true,"_codigopais" /*RemoteObject*/ ),BA.numberCast(double.class, 0))) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 BA.debugLineNum = 44;BA.debugLine="txtcodigoPais.Text = p.codigoPais";
Debug.ShouldStop(2048);
parent.mostCurrent._txtcodigopais.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_p.getField(true,"_codigopais" /*RemoteObject*/ )));
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 46;BA.debugLine="Msgbox(\"no se pudo crear pais\", \"error\")";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence("no se pudo crear pais")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("error"))),crudpaises.mostCurrent.activityBA);
 if (true) break;

case 6:
//C
this.state = -1;
;
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
public static void  _complete(RemoteObject _p) throws Exception{
}
public static RemoteObject  _cmddelete_click() throws Exception{
try {
		Debug.PushSubsStack("cmdDelete_Click (crudpaises) ","crudpaises",8,crudpaises.mostCurrent.activityBA,crudpaises.mostCurrent,54);
if (RapidSub.canDelegate("cmddelete_click")) { return b4a.example.crudpaises.remoteMe.runUserSub(false, "crudpaises","cmddelete_click");}
 BA.debugLineNum = 54;BA.debugLine="Private Sub cmdDelete_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _cmdselect_click() throws Exception{
try {
		Debug.PushSubsStack("cmdSelect_Click (crudpaises) ","crudpaises",8,crudpaises.mostCurrent.activityBA,crudpaises.mostCurrent,58);
if (RapidSub.canDelegate("cmdselect_click")) { b4a.example.crudpaises.remoteMe.runUserSub(false, "crudpaises","cmdselect_click"); return;}
ResumableSub_cmdSelect_Click rsub = new ResumableSub_cmdSelect_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_cmdSelect_Click extends BA.ResumableSub {
public ResumableSub_cmdSelect_Click(b4a.example.crudpaises parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.crudpaises parent;
RemoteObject _p = RemoteObject.declareNull("b4a.example.pais");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("cmdSelect_Click (crudpaises) ","crudpaises",8,crudpaises.mostCurrent.activityBA,crudpaises.mostCurrent,58);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 60;BA.debugLine="Wait For( GetPais(txtcodigoPais.Text) ) Complete";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", crudpaises.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "crudpaises", "cmdselect_click"), _getpais(BA.numberCast(int.class, parent.mostCurrent._txtcodigopais.runMethod(true,"getText"))));
this.state = 7;
return;
case 7:
//C
this.state = 1;
_p = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("p", _p);
;
 BA.debugLineNum = 62;BA.debugLine="If p.codigoPais <> 0 Then";
Debug.ShouldStop(536870912);
if (true) break;

case 1:
//if
this.state = 6;
if (RemoteObject.solveBoolean("!",_p.getField(true,"_codigopais" /*RemoteObject*/ ),BA.numberCast(double.class, 0))) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 BA.debugLineNum = 63;BA.debugLine="txtcodigoPais.Text = p.codigoPais";
Debug.ShouldStop(1073741824);
parent.mostCurrent._txtcodigopais.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_p.getField(true,"_codigopais" /*RemoteObject*/ )));
 BA.debugLineNum = 64;BA.debugLine="txtcapital.Text = p.capital";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._txtcapital.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_p.getField(true,"_capital" /*RemoteObject*/ )));
 BA.debugLineNum = 65;BA.debugLine="txtcodigoISO.Text = p.codigoISO";
Debug.ShouldStop(1);
parent.mostCurrent._txtcodigoiso.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_p.getField(true,"_codigoiso" /*RemoteObject*/ )));
 BA.debugLineNum = 66;BA.debugLine="txtidioma.Text = p.idioma";
Debug.ShouldStop(2);
parent.mostCurrent._txtidioma.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_p.getField(true,"_idioma" /*RemoteObject*/ )));
 BA.debugLineNum = 67;BA.debugLine="txtmoneda.Text = p.moneda";
Debug.ShouldStop(4);
parent.mostCurrent._txtmoneda.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_p.getField(true,"_moneda" /*RemoteObject*/ )));
 BA.debugLineNum = 68;BA.debugLine="txtnombre.Text = p.nombre";
Debug.ShouldStop(8);
parent.mostCurrent._txtnombre.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_p.getField(true,"_nombre" /*RemoteObject*/ )));
 BA.debugLineNum = 69;BA.debugLine="txtpoblacion.Text = p.poblacion";
Debug.ShouldStop(16);
parent.mostCurrent._txtpoblacion.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_p.getField(true,"_poblacion" /*RemoteObject*/ )));
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 71;BA.debugLine="txtcodigoPais.Text = \"\"";
Debug.ShouldStop(64);
parent.mostCurrent._txtcodigopais.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 72;BA.debugLine="txtcapital.Text = \"\"";
Debug.ShouldStop(128);
parent.mostCurrent._txtcapital.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 73;BA.debugLine="txtcodigoISO.Text = \"\"";
Debug.ShouldStop(256);
parent.mostCurrent._txtcodigoiso.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 74;BA.debugLine="txtidioma.Text = \"\"";
Debug.ShouldStop(512);
parent.mostCurrent._txtidioma.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 75;BA.debugLine="txtmoneda.Text = \"\"";
Debug.ShouldStop(1024);
parent.mostCurrent._txtmoneda.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 76;BA.debugLine="txtnombre.Text = \"\"";
Debug.ShouldStop(2048);
parent.mostCurrent._txtnombre.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 77;BA.debugLine="txtpoblacion.Text = \"\"";
Debug.ShouldStop(4096);
parent.mostCurrent._txtpoblacion.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 78;BA.debugLine="Msgbox( \"pais no encontrado\", \"Sucedio un error\"";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence("pais no encontrado")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Sucedio un error"))),crudpaises.mostCurrent.activityBA);
 if (true) break;

case 6:
//C
this.state = -1;
;
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
public static RemoteObject  _cmdupdate_click() throws Exception{
try {
		Debug.PushSubsStack("cmdUpdate_Click (crudpaises) ","crudpaises",8,crudpaises.mostCurrent.activityBA,crudpaises.mostCurrent,50);
if (RapidSub.canDelegate("cmdupdate_click")) { return b4a.example.crudpaises.remoteMe.runUserSub(false, "crudpaises","cmdupdate_click");}
 BA.debugLineNum = 50;BA.debugLine="Private Sub cmdUpdate_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _crearpais(RemoteObject _codigopais,RemoteObject _codigoiso,RemoteObject _nombre,RemoteObject _capital,RemoteObject _idioma,RemoteObject _moneda,RemoteObject _poblacion) throws Exception{
try {
		Debug.PushSubsStack("CrearPais (crudpaises) ","crudpaises",8,crudpaises.mostCurrent.activityBA,crudpaises.mostCurrent,82);
if (RapidSub.canDelegate("crearpais")) { return b4a.example.crudpaises.remoteMe.runUserSub(false, "crudpaises","crearpais", _codigopais, _codigoiso, _nombre, _capital, _idioma, _moneda, _poblacion);}
ResumableSub_CrearPais rsub = new ResumableSub_CrearPais(null,_codigopais,_codigoiso,_nombre,_capital,_idioma,_moneda,_poblacion);
rsub.remoteResumableSub = anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSubForFilter();
rsub.resume(null, null);
return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.keywords.Common.ResumableSubWrapper"), rsub.remoteResumableSub);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_CrearPais extends BA.ResumableSub {
public ResumableSub_CrearPais(b4a.example.crudpaises parent,RemoteObject _codigopais,RemoteObject _codigoiso,RemoteObject _nombre,RemoteObject _capital,RemoteObject _idioma,RemoteObject _moneda,RemoteObject _poblacion) {
this.parent = parent;
this._codigopais = _codigopais;
this._codigoiso = _codigoiso;
this._nombre = _nombre;
this._capital = _capital;
this._idioma = _idioma;
this._moneda = _moneda;
this._poblacion = _poblacion;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.crudpaises parent;
RemoteObject _codigopais;
RemoteObject _codigoiso;
RemoteObject _nombre;
RemoteObject _capital;
RemoteObject _idioma;
RemoteObject _moneda;
RemoteObject _poblacion;
RemoteObject _j = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _json = RemoteObject.createImmutable("");
RemoteObject _jsongenerator = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");
RemoteObject _obj = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _pais = RemoteObject.declareNull("b4a.example.pais");
RemoteObject _response = RemoteObject.declareNull("b4a.example.httpjob");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("CrearPais (crudpaises) ","crudpaises",8,crudpaises.mostCurrent.activityBA,crudpaises.mostCurrent,82);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
{
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable(null));return;}
case 0:
//C
this.state = 1;
Debug.locals.put("codigoPais", _codigopais);
Debug.locals.put("codigoISO", _codigoiso);
Debug.locals.put("nombre", _nombre);
Debug.locals.put("capital", _capital);
Debug.locals.put("idioma", _idioma);
Debug.locals.put("moneda", _moneda);
Debug.locals.put("poblacion", _poblacion);
 BA.debugLineNum = 83;BA.debugLine="Dim j As HttpJob : j.initialize(\"\", Me)";
Debug.ShouldStop(262144);
_j = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("j", _j);
 BA.debugLineNum = 83;BA.debugLine="Dim j As HttpJob : j.initialize(\"\", Me)";
Debug.ShouldStop(262144);
_j.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,crudpaises.processBA,(Object)(BA.ObjectToString("")),(Object)(crudpaises.getObject()));
 BA.debugLineNum = 84;BA.debugLine="Dim json As String";
Debug.ShouldStop(524288);
_json = RemoteObject.createImmutable("");Debug.locals.put("json", _json);
 BA.debugLineNum = 85;BA.debugLine="Dim jsonGenerator As JSONGenerator";
Debug.ShouldStop(1048576);
_jsongenerator = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");Debug.locals.put("jsonGenerator", _jsongenerator);
 BA.debugLineNum = 86;BA.debugLine="Dim obj As Map : obj.initialize";
Debug.ShouldStop(2097152);
_obj = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("obj", _obj);
 BA.debugLineNum = 86;BA.debugLine="Dim obj As Map : obj.initialize";
Debug.ShouldStop(2097152);
_obj.runVoidMethod ("Initialize");
 BA.debugLineNum = 87;BA.debugLine="Dim pais As Pais : pais.initialize";
Debug.ShouldStop(4194304);
_pais = RemoteObject.createNew ("b4a.example.pais");Debug.locals.put("pais", _pais);
 BA.debugLineNum = 87;BA.debugLine="Dim pais As Pais : pais.initialize";
Debug.ShouldStop(4194304);
_pais.runClassMethod (b4a.example.pais.class, "_initialize" /*RemoteObject*/ ,crudpaises.processBA);
 BA.debugLineNum = 89;BA.debugLine="obj.Put(\"codigoPais\", codigoPais)";
Debug.ShouldStop(16777216);
_obj.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("codigoPais"))),(Object)((_codigopais)));
 BA.debugLineNum = 90;BA.debugLine="obj.Put(\"nombre\", nombre)";
Debug.ShouldStop(33554432);
_obj.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("nombre"))),(Object)((_nombre)));
 BA.debugLineNum = 91;BA.debugLine="obj.Put(\"poblacion\", poblacion)";
Debug.ShouldStop(67108864);
_obj.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("poblacion"))),(Object)((_poblacion)));
 BA.debugLineNum = 92;BA.debugLine="obj.Put(\"codigoISO\", codigoISO)";
Debug.ShouldStop(134217728);
_obj.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("codigoISO"))),(Object)((_codigoiso)));
 BA.debugLineNum = 93;BA.debugLine="obj.Put(\"moneda\", moneda)";
Debug.ShouldStop(268435456);
_obj.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("moneda"))),(Object)((_moneda)));
 BA.debugLineNum = 94;BA.debugLine="obj.Put(\"capital\", capital)";
Debug.ShouldStop(536870912);
_obj.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("capital"))),(Object)((_capital)));
 BA.debugLineNum = 95;BA.debugLine="obj.Put(\"idioma\", idioma)";
Debug.ShouldStop(1073741824);
_obj.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("idioma"))),(Object)((_idioma)));
 BA.debugLineNum = 97;BA.debugLine="jsonGenerator.Initialize( obj )";
Debug.ShouldStop(1);
_jsongenerator.runVoidMethod ("Initialize",(Object)(_obj));
 BA.debugLineNum = 98;BA.debugLine="json = jsonGenerator.ToPrettyString(5)";
Debug.ShouldStop(2);
_json = _jsongenerator.runMethod(true,"ToPrettyString",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("json", _json);
 BA.debugLineNum = 100;BA.debugLine="j.PostString( apiUrl, json)";
Debug.ShouldStop(8);
_j.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(parent.mostCurrent._apiurl),(Object)(_json));
 BA.debugLineNum = 101;BA.debugLine="j.GetRequest.SetContentType(\"application/json\")";
Debug.ShouldStop(16);
_j.runClassMethod (b4a.example.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/json")));
 BA.debugLineNum = 102;BA.debugLine="Wait For (j) JobDone( response As HttpJob )";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", crudpaises.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "crudpaises", "crearpais"), (_j));
this.state = 5;
return;
case 5:
//C
this.state = 1;
_response = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("response", _response);
;
 BA.debugLineNum = 103;BA.debugLine="If response.Success Then";
Debug.ShouldStop(64);
if (true) break;

case 1:
//if
this.state = 4;
if (_response.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 104;BA.debugLine="pais = getPais2( response.GetString)";
Debug.ShouldStop(128);
_pais = _getpais2(_response.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ));Debug.locals.put("pais", _pais);
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 107;BA.debugLine="Return pais";
Debug.ShouldStop(1024);
if (true) {
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,(_pais));return;};
 BA.debugLineNum = 108;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
public static void  _jobdone(RemoteObject _response) throws Exception{
}
public static RemoteObject  _getpais(RemoteObject _codigopais) throws Exception{
try {
		Debug.PushSubsStack("GetPais (crudpaises) ","crudpaises",8,crudpaises.mostCurrent.activityBA,crudpaises.mostCurrent,110);
if (RapidSub.canDelegate("getpais")) { return b4a.example.crudpaises.remoteMe.runUserSub(false, "crudpaises","getpais", _codigopais);}
ResumableSub_GetPais rsub = new ResumableSub_GetPais(null,_codigopais);
rsub.remoteResumableSub = anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSubForFilter();
rsub.resume(null, null);
return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.keywords.Common.ResumableSubWrapper"), rsub.remoteResumableSub);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_GetPais extends BA.ResumableSub {
public ResumableSub_GetPais(b4a.example.crudpaises parent,RemoteObject _codigopais) {
this.parent = parent;
this._codigopais = _codigopais;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.crudpaises parent;
RemoteObject _codigopais;
RemoteObject _pais = RemoteObject.declareNull("b4a.example.pais");
RemoteObject _j = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _response = RemoteObject.declareNull("b4a.example.httpjob");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("GetPais (crudpaises) ","crudpaises",8,crudpaises.mostCurrent.activityBA,crudpaises.mostCurrent,110);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
{
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable(null));return;}
case 0:
//C
this.state = 1;
Debug.locals.put("codigoPais", _codigopais);
 BA.debugLineNum = 111;BA.debugLine="Dim pais As Pais : pais.initialize";
Debug.ShouldStop(16384);
_pais = RemoteObject.createNew ("b4a.example.pais");Debug.locals.put("pais", _pais);
 BA.debugLineNum = 111;BA.debugLine="Dim pais As Pais : pais.initialize";
Debug.ShouldStop(16384);
_pais.runClassMethod (b4a.example.pais.class, "_initialize" /*RemoteObject*/ ,crudpaises.processBA);
 BA.debugLineNum = 112;BA.debugLine="Dim j As HttpJob : j.Initialize(\"\", Me)";
Debug.ShouldStop(32768);
_j = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("j", _j);
 BA.debugLineNum = 112;BA.debugLine="Dim j As HttpJob : j.Initialize(\"\", Me)";
Debug.ShouldStop(32768);
_j.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,crudpaises.processBA,(Object)(BA.ObjectToString("")),(Object)(crudpaises.getObject()));
 BA.debugLineNum = 114;BA.debugLine="j.Download( apiUrl & codigoPais )";
Debug.ShouldStop(131072);
_j.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(RemoteObject.concat(parent.mostCurrent._apiurl,_codigopais)));
 BA.debugLineNum = 115;BA.debugLine="Wait For (j) JobDone( response As HttpJob)";
Debug.ShouldStop(262144);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", crudpaises.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "crudpaises", "getpais"), (_j));
this.state = 5;
return;
case 5:
//C
this.state = 1;
_response = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("response", _response);
;
 BA.debugLineNum = 117;BA.debugLine="If response.Success Then";
Debug.ShouldStop(1048576);
if (true) break;

case 1:
//if
this.state = 4;
if (_response.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 118;BA.debugLine="pais = getPais2( response.GetString )";
Debug.ShouldStop(2097152);
_pais = _getpais2(_response.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ));Debug.locals.put("pais", _pais);
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 120;BA.debugLine="Return pais";
Debug.ShouldStop(8388608);
if (true) {
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,(_pais));return;};
 BA.debugLineNum = 121;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
public static RemoteObject  _getpais2(RemoteObject _json) throws Exception{
try {
		Debug.PushSubsStack("getPais2 (crudpaises) ","crudpaises",8,crudpaises.mostCurrent.activityBA,crudpaises.mostCurrent,123);
if (RapidSub.canDelegate("getpais2")) { return b4a.example.crudpaises.remoteMe.runUserSub(false, "crudpaises","getpais2", _json);}
RemoteObject _jsonparser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _pais = RemoteObject.declareNull("b4a.example.pais");
RemoteObject _obj = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("json", _json);
 BA.debugLineNum = 123;BA.debugLine="Private Sub getPais2( json As String ) As Pais";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 125;BA.debugLine="Dim jsonParser As JSONParser :  jsonParser.Initia";
Debug.ShouldStop(268435456);
_jsonparser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("jsonParser", _jsonparser);
 BA.debugLineNum = 125;BA.debugLine="Dim jsonParser As JSONParser :  jsonParser.Initia";
Debug.ShouldStop(268435456);
_jsonparser.runVoidMethod ("Initialize",(Object)(_json));
 BA.debugLineNum = 126;BA.debugLine="Dim pais As Pais : pais.initialize";
Debug.ShouldStop(536870912);
_pais = RemoteObject.createNew ("b4a.example.pais");Debug.locals.put("pais", _pais);
 BA.debugLineNum = 126;BA.debugLine="Dim pais As Pais : pais.initialize";
Debug.ShouldStop(536870912);
_pais.runClassMethod (b4a.example.pais.class, "_initialize" /*RemoteObject*/ ,crudpaises.processBA);
 BA.debugLineNum = 127;BA.debugLine="Dim obj As Map = jsonParser.NextObject";
Debug.ShouldStop(1073741824);
_obj = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_obj = _jsonparser.runMethod(false,"NextObject");Debug.locals.put("obj", _obj);Debug.locals.put("obj", _obj);
 BA.debugLineNum = 129;BA.debugLine="pais.codigoPais = obj.Get(\"codigoPais\")";
Debug.ShouldStop(1);
_pais.setField ("_codigopais" /*RemoteObject*/ ,BA.numberCast(int.class, _obj.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("codigoPais"))))));
 BA.debugLineNum = 130;BA.debugLine="pais.capital = obj.Get(\"capital\")";
Debug.ShouldStop(2);
_pais.setField ("_capital" /*RemoteObject*/ ,BA.ObjectToString(_obj.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("capital"))))));
 BA.debugLineNum = 131;BA.debugLine="pais.codigoISO = obj.Get(\"codigoISO\")";
Debug.ShouldStop(4);
_pais.setField ("_codigoiso" /*RemoteObject*/ ,BA.ObjectToString(_obj.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("codigoISO"))))));
 BA.debugLineNum = 132;BA.debugLine="pais.idioma = obj.Get(\"idioma\")";
Debug.ShouldStop(8);
_pais.setField ("_idioma" /*RemoteObject*/ ,BA.ObjectToString(_obj.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("idioma"))))));
 BA.debugLineNum = 133;BA.debugLine="pais.moneda = obj.Get(\"moneda\")";
Debug.ShouldStop(16);
_pais.setField ("_moneda" /*RemoteObject*/ ,BA.ObjectToString(_obj.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("moneda"))))));
 BA.debugLineNum = 134;BA.debugLine="pais.nombre = obj.Get(\"nombre\")";
Debug.ShouldStop(32);
_pais.setField ("_nombre" /*RemoteObject*/ ,BA.ObjectToString(_obj.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("nombre"))))));
 BA.debugLineNum = 135;BA.debugLine="pais.poblacion = obj.Get(\"poblacion\")";
Debug.ShouldStop(64);
_pais.setField ("_poblacion" /*RemoteObject*/ ,BA.numberCast(int.class, _obj.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("poblacion"))))));
 BA.debugLineNum = 137;BA.debugLine="Return pais";
Debug.ShouldStop(256);
if (true) return _pais;
 BA.debugLineNum = 138;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private apiUrl As String = \"https://empresautnapi";
crudpaises.mostCurrent._apiurl = BA.ObjectToString("https://empresautnapi2023.azurewebsites.net/api/Paises/");
 //BA.debugLineNum = 16;BA.debugLine="Private txtcodigoPais As EditText";
crudpaises.mostCurrent._txtcodigopais = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private txtnombre As EditText";
crudpaises.mostCurrent._txtnombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private txtpoblacion As EditText";
crudpaises.mostCurrent._txtpoblacion = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private txtcodigoISO As EditText";
crudpaises.mostCurrent._txtcodigoiso = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private txtmoneda As EditText";
crudpaises.mostCurrent._txtmoneda = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private txtcapital As EditText";
crudpaises.mostCurrent._txtcapital = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private txtidioma As EditText";
crudpaises.mostCurrent._txtidioma = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}