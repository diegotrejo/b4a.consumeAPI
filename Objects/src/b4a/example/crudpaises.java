package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class crudpaises extends Activity implements B4AActivity{
	public static crudpaises mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.crudpaises");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (crudpaises).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.crudpaises");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.crudpaises", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (crudpaises) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (crudpaises) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return crudpaises.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (crudpaises) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (crudpaises) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            crudpaises mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (crudpaises) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static String _apiurl = "";
public anywheresoftware.b4a.objects.EditTextWrapper _txtcodigopais = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtnombre = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtpoblacion = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtcodigoiso = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtmoneda = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtcapital = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtidioma = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="crudpaises";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="Activity.LoadLayout(\"CrudPaises\")";
mostCurrent._activity.LoadLayout("CrudPaises",mostCurrent.activityBA);
RDebugUtils.currentLine=4325380;
 //BA.debugLineNum = 4325380;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="crudpaises";
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="crudpaises";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="End Sub";
return "";
}
public static void  _cmdadd_click() throws Exception{
RDebugUtils.currentModule="crudpaises";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cmdadd_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "cmdadd_click", null); return;}
ResumableSub_cmdAdd_Click rsub = new ResumableSub_cmdAdd_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_cmdAdd_Click extends BA.ResumableSub {
public ResumableSub_cmdAdd_Click(b4a.example.crudpaises parent) {
this.parent = parent;
}
b4a.example.crudpaises parent;
b4a.example.pais _p = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="crudpaises";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=4521985;
 //BA.debugLineNum = 4521985;BA.debugLine="Wait For(CrearPais( txtcodigoPais.Text, txtcodigo";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "crudpaises", "cmdadd_click"), _crearpais((int)(Double.parseDouble(parent.mostCurrent._txtcodigopais.getText())),parent.mostCurrent._txtcodigoiso.getText(),parent.mostCurrent._txtnombre.getText(),parent.mostCurrent._txtcapital.getText(),parent.mostCurrent._txtidioma.getText(),parent.mostCurrent._txtmoneda.getText(),(int)(Double.parseDouble(parent.mostCurrent._txtpoblacion.getText()))));
this.state = 7;
return;
case 7:
//C
this.state = 1;
_p = (b4a.example.pais) result[0];
;
RDebugUtils.currentLine=4521987;
 //BA.debugLineNum = 4521987;BA.debugLine="If p.codigoPais <> 0 Then";
if (true) break;

case 1:
//if
this.state = 6;
if (_p._codigopais /*int*/ !=0) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
RDebugUtils.currentLine=4521988;
 //BA.debugLineNum = 4521988;BA.debugLine="txtcodigoPais.Text = p.codigoPais";
parent.mostCurrent._txtcodigopais.setText(BA.ObjectToCharSequence(_p._codigopais /*int*/ ));
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=4521990;
 //BA.debugLineNum = 4521990;BA.debugLine="Msgbox(\"no se pudo crear pais\", \"error\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("no se pudo crear pais"),BA.ObjectToCharSequence("error"),mostCurrent.activityBA);
 if (true) break;

case 6:
//C
this.state = -1;
;
RDebugUtils.currentLine=4521992;
 //BA.debugLineNum = 4521992;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _crearpais(int _codigopais,String _codigoiso,String _nombre,String _capital,String _idioma,String _moneda,int _poblacion) throws Exception{
RDebugUtils.currentModule="crudpaises";
if (Debug.shouldDelegate(mostCurrent.activityBA, "crearpais", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(mostCurrent.activityBA, "crearpais", new Object[] {_codigopais,_codigoiso,_nombre,_capital,_idioma,_moneda,_poblacion}));}
ResumableSub_CrearPais rsub = new ResumableSub_CrearPais(null,_codigopais,_codigoiso,_nombre,_capital,_idioma,_moneda,_poblacion);
rsub.resume(processBA, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_CrearPais extends BA.ResumableSub {
public ResumableSub_CrearPais(b4a.example.crudpaises parent,int _codigopais,String _codigoiso,String _nombre,String _capital,String _idioma,String _moneda,int _poblacion) {
this.parent = parent;
this._codigopais = _codigopais;
this._codigoiso = _codigoiso;
this._nombre = _nombre;
this._capital = _capital;
this._idioma = _idioma;
this._moneda = _moneda;
this._poblacion = _poblacion;
}
b4a.example.crudpaises parent;
int _codigopais;
String _codigoiso;
String _nombre;
String _capital;
String _idioma;
String _moneda;
int _poblacion;
b4a.example.httpjob _j = null;
String _json = "";
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _jsongenerator = null;
anywheresoftware.b4a.objects.collections.Map _obj = null;
b4a.example.pais _pais = null;
b4a.example.httpjob _response = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="crudpaises";

    while (true) {
        switch (state) {
            case -1:
{
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=6422529;
 //BA.debugLineNum = 6422529;BA.debugLine="Dim j As HttpJob : j.initialize(\"\", Me)";
_j = new b4a.example.httpjob();
RDebugUtils.currentLine=6422529;
 //BA.debugLineNum = 6422529;BA.debugLine="Dim j As HttpJob : j.initialize(\"\", Me)";
_j._initialize /*String*/ (null,processBA,"",crudpaises.getObject());
RDebugUtils.currentLine=6422530;
 //BA.debugLineNum = 6422530;BA.debugLine="Dim json As String";
_json = "";
RDebugUtils.currentLine=6422531;
 //BA.debugLineNum = 6422531;BA.debugLine="Dim jsonGenerator As JSONGenerator";
_jsongenerator = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
RDebugUtils.currentLine=6422532;
 //BA.debugLineNum = 6422532;BA.debugLine="Dim obj As Map : obj.initialize";
_obj = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=6422532;
 //BA.debugLineNum = 6422532;BA.debugLine="Dim obj As Map : obj.initialize";
_obj.Initialize();
RDebugUtils.currentLine=6422533;
 //BA.debugLineNum = 6422533;BA.debugLine="Dim pais As Pais : pais.initialize";
_pais = new b4a.example.pais();
RDebugUtils.currentLine=6422533;
 //BA.debugLineNum = 6422533;BA.debugLine="Dim pais As Pais : pais.initialize";
_pais._initialize /*String*/ (null,processBA);
RDebugUtils.currentLine=6422535;
 //BA.debugLineNum = 6422535;BA.debugLine="obj.Put(\"codigoPais\", codigoPais)";
_obj.Put((Object)("codigoPais"),(Object)(_codigopais));
RDebugUtils.currentLine=6422536;
 //BA.debugLineNum = 6422536;BA.debugLine="obj.Put(\"nombre\", nombre)";
_obj.Put((Object)("nombre"),(Object)(_nombre));
RDebugUtils.currentLine=6422537;
 //BA.debugLineNum = 6422537;BA.debugLine="obj.Put(\"poblacion\", poblacion)";
_obj.Put((Object)("poblacion"),(Object)(_poblacion));
RDebugUtils.currentLine=6422538;
 //BA.debugLineNum = 6422538;BA.debugLine="obj.Put(\"codigoISO\", codigoISO)";
_obj.Put((Object)("codigoISO"),(Object)(_codigoiso));
RDebugUtils.currentLine=6422539;
 //BA.debugLineNum = 6422539;BA.debugLine="obj.Put(\"moneda\", moneda)";
_obj.Put((Object)("moneda"),(Object)(_moneda));
RDebugUtils.currentLine=6422540;
 //BA.debugLineNum = 6422540;BA.debugLine="obj.Put(\"capital\", capital)";
_obj.Put((Object)("capital"),(Object)(_capital));
RDebugUtils.currentLine=6422541;
 //BA.debugLineNum = 6422541;BA.debugLine="obj.Put(\"idioma\", idioma)";
_obj.Put((Object)("idioma"),(Object)(_idioma));
RDebugUtils.currentLine=6422543;
 //BA.debugLineNum = 6422543;BA.debugLine="jsonGenerator.Initialize( obj )";
_jsongenerator.Initialize(_obj);
RDebugUtils.currentLine=6422544;
 //BA.debugLineNum = 6422544;BA.debugLine="json = jsonGenerator.ToPrettyString(5)";
_json = _jsongenerator.ToPrettyString((int) (5));
RDebugUtils.currentLine=6422546;
 //BA.debugLineNum = 6422546;BA.debugLine="j.PostString( apiUrl, json)";
_j._poststring /*String*/ (null,parent.mostCurrent._apiurl,_json);
RDebugUtils.currentLine=6422547;
 //BA.debugLineNum = 6422547;BA.debugLine="j.GetRequest.SetContentType(\"application/json\")";
_j._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("application/json");
RDebugUtils.currentLine=6422548;
 //BA.debugLineNum = 6422548;BA.debugLine="Wait For (j) JobDone( response As HttpJob )";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "crudpaises", "crearpais"), (Object)(_j));
this.state = 5;
return;
case 5:
//C
this.state = 1;
_response = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=6422549;
 //BA.debugLineNum = 6422549;BA.debugLine="If response.Success Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_response._success /*boolean*/ ) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=6422550;
 //BA.debugLineNum = 6422550;BA.debugLine="pais = getPais2( response.GetString)";
_pais = _getpais2(_response._getstring /*String*/ (null));
 if (true) break;

case 4:
//C
this.state = -1;
;
RDebugUtils.currentLine=6422553;
 //BA.debugLineNum = 6422553;BA.debugLine="Return pais";
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)(_pais));return;};
RDebugUtils.currentLine=6422554;
 //BA.debugLineNum = 6422554;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _cmddelete_click() throws Exception{
RDebugUtils.currentModule="crudpaises";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cmddelete_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cmddelete_click", null));}
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Private Sub cmdDelete_Click";
RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="End Sub";
return "";
}
public static void  _cmdselect_click() throws Exception{
RDebugUtils.currentModule="crudpaises";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cmdselect_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "cmdselect_click", null); return;}
ResumableSub_cmdSelect_Click rsub = new ResumableSub_cmdSelect_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_cmdSelect_Click extends BA.ResumableSub {
public ResumableSub_cmdSelect_Click(b4a.example.crudpaises parent) {
this.parent = parent;
}
b4a.example.crudpaises parent;
b4a.example.pais _p = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="crudpaises";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=4718594;
 //BA.debugLineNum = 4718594;BA.debugLine="Wait For( GetPais(txtcodigoPais.Text) ) Complete";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "crudpaises", "cmdselect_click"), _getpais((int)(Double.parseDouble(parent.mostCurrent._txtcodigopais.getText()))));
this.state = 7;
return;
case 7:
//C
this.state = 1;
_p = (b4a.example.pais) result[0];
;
RDebugUtils.currentLine=4718596;
 //BA.debugLineNum = 4718596;BA.debugLine="If p.codigoPais <> 0 Then";
if (true) break;

case 1:
//if
this.state = 6;
if (_p._codigopais /*int*/ !=0) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
RDebugUtils.currentLine=4718597;
 //BA.debugLineNum = 4718597;BA.debugLine="txtcodigoPais.Text = p.codigoPais";
parent.mostCurrent._txtcodigopais.setText(BA.ObjectToCharSequence(_p._codigopais /*int*/ ));
RDebugUtils.currentLine=4718598;
 //BA.debugLineNum = 4718598;BA.debugLine="txtcapital.Text = p.capital";
parent.mostCurrent._txtcapital.setText(BA.ObjectToCharSequence(_p._capital /*String*/ ));
RDebugUtils.currentLine=4718599;
 //BA.debugLineNum = 4718599;BA.debugLine="txtcodigoISO.Text = p.codigoISO";
parent.mostCurrent._txtcodigoiso.setText(BA.ObjectToCharSequence(_p._codigoiso /*String*/ ));
RDebugUtils.currentLine=4718600;
 //BA.debugLineNum = 4718600;BA.debugLine="txtidioma.Text = p.idioma";
parent.mostCurrent._txtidioma.setText(BA.ObjectToCharSequence(_p._idioma /*String*/ ));
RDebugUtils.currentLine=4718601;
 //BA.debugLineNum = 4718601;BA.debugLine="txtmoneda.Text = p.moneda";
parent.mostCurrent._txtmoneda.setText(BA.ObjectToCharSequence(_p._moneda /*String*/ ));
RDebugUtils.currentLine=4718602;
 //BA.debugLineNum = 4718602;BA.debugLine="txtnombre.Text = p.nombre";
parent.mostCurrent._txtnombre.setText(BA.ObjectToCharSequence(_p._nombre /*String*/ ));
RDebugUtils.currentLine=4718603;
 //BA.debugLineNum = 4718603;BA.debugLine="txtpoblacion.Text = p.poblacion";
parent.mostCurrent._txtpoblacion.setText(BA.ObjectToCharSequence(_p._poblacion /*int*/ ));
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=4718605;
 //BA.debugLineNum = 4718605;BA.debugLine="txtcodigoPais.Text = \"\"";
parent.mostCurrent._txtcodigopais.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4718606;
 //BA.debugLineNum = 4718606;BA.debugLine="txtcapital.Text = \"\"";
parent.mostCurrent._txtcapital.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4718607;
 //BA.debugLineNum = 4718607;BA.debugLine="txtcodigoISO.Text = \"\"";
parent.mostCurrent._txtcodigoiso.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4718608;
 //BA.debugLineNum = 4718608;BA.debugLine="txtidioma.Text = \"\"";
parent.mostCurrent._txtidioma.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4718609;
 //BA.debugLineNum = 4718609;BA.debugLine="txtmoneda.Text = \"\"";
parent.mostCurrent._txtmoneda.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4718610;
 //BA.debugLineNum = 4718610;BA.debugLine="txtnombre.Text = \"\"";
parent.mostCurrent._txtnombre.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4718611;
 //BA.debugLineNum = 4718611;BA.debugLine="txtpoblacion.Text = \"\"";
parent.mostCurrent._txtpoblacion.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4718612;
 //BA.debugLineNum = 4718612;BA.debugLine="Msgbox( \"pais no encontrado\", \"Sucedio un error\"";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("pais no encontrado"),BA.ObjectToCharSequence("Sucedio un error"),mostCurrent.activityBA);
 if (true) break;

case 6:
//C
this.state = -1;
;
RDebugUtils.currentLine=4718614;
 //BA.debugLineNum = 4718614;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _getpais(int _codigopais) throws Exception{
RDebugUtils.currentModule="crudpaises";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getpais", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(mostCurrent.activityBA, "getpais", new Object[] {_codigopais}));}
ResumableSub_GetPais rsub = new ResumableSub_GetPais(null,_codigopais);
rsub.resume(processBA, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_GetPais extends BA.ResumableSub {
public ResumableSub_GetPais(b4a.example.crudpaises parent,int _codigopais) {
this.parent = parent;
this._codigopais = _codigopais;
}
b4a.example.crudpaises parent;
int _codigopais;
b4a.example.pais _pais = null;
b4a.example.httpjob _j = null;
b4a.example.httpjob _response = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="crudpaises";

    while (true) {
        switch (state) {
            case -1:
{
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=5242881;
 //BA.debugLineNum = 5242881;BA.debugLine="Dim pais As Pais : pais.initialize";
_pais = new b4a.example.pais();
RDebugUtils.currentLine=5242881;
 //BA.debugLineNum = 5242881;BA.debugLine="Dim pais As Pais : pais.initialize";
_pais._initialize /*String*/ (null,processBA);
RDebugUtils.currentLine=5242882;
 //BA.debugLineNum = 5242882;BA.debugLine="Dim j As HttpJob : j.Initialize(\"\", Me)";
_j = new b4a.example.httpjob();
RDebugUtils.currentLine=5242882;
 //BA.debugLineNum = 5242882;BA.debugLine="Dim j As HttpJob : j.Initialize(\"\", Me)";
_j._initialize /*String*/ (null,processBA,"",crudpaises.getObject());
RDebugUtils.currentLine=5242884;
 //BA.debugLineNum = 5242884;BA.debugLine="j.Download( apiUrl & codigoPais )";
_j._download /*String*/ (null,parent.mostCurrent._apiurl+BA.NumberToString(_codigopais));
RDebugUtils.currentLine=5242885;
 //BA.debugLineNum = 5242885;BA.debugLine="Wait For (j) JobDone( response As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "crudpaises", "getpais"), (Object)(_j));
this.state = 5;
return;
case 5:
//C
this.state = 1;
_response = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=5242887;
 //BA.debugLineNum = 5242887;BA.debugLine="If response.Success Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_response._success /*boolean*/ ) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=5242888;
 //BA.debugLineNum = 5242888;BA.debugLine="pais = getPais2( response.GetString )";
_pais = _getpais2(_response._getstring /*String*/ (null));
 if (true) break;

case 4:
//C
this.state = -1;
;
RDebugUtils.currentLine=5242890;
 //BA.debugLineNum = 5242890;BA.debugLine="Return pais";
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)(_pais));return;};
RDebugUtils.currentLine=5242891;
 //BA.debugLineNum = 5242891;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _cmdupdate_click() throws Exception{
RDebugUtils.currentModule="crudpaises";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cmdupdate_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cmdupdate_click", null));}
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Private Sub cmdUpdate_Click";
RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="End Sub";
return "";
}
public static b4a.example.pais  _getpais2(String _json) throws Exception{
RDebugUtils.currentModule="crudpaises";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getpais2", false))
	 {return ((b4a.example.pais) Debug.delegate(mostCurrent.activityBA, "getpais2", new Object[] {_json}));}
anywheresoftware.b4a.objects.collections.JSONParser _jsonparser = null;
b4a.example.pais _pais = null;
anywheresoftware.b4a.objects.collections.Map _obj = null;
RDebugUtils.currentLine=7077888;
 //BA.debugLineNum = 7077888;BA.debugLine="Private Sub getPais2( json As String ) As Pais";
RDebugUtils.currentLine=7077890;
 //BA.debugLineNum = 7077890;BA.debugLine="Dim jsonParser As JSONParser :  jsonParser.Initia";
_jsonparser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=7077890;
 //BA.debugLineNum = 7077890;BA.debugLine="Dim jsonParser As JSONParser :  jsonParser.Initia";
_jsonparser.Initialize(_json);
RDebugUtils.currentLine=7077891;
 //BA.debugLineNum = 7077891;BA.debugLine="Dim pais As Pais : pais.initialize";
_pais = new b4a.example.pais();
RDebugUtils.currentLine=7077891;
 //BA.debugLineNum = 7077891;BA.debugLine="Dim pais As Pais : pais.initialize";
_pais._initialize /*String*/ (null,processBA);
RDebugUtils.currentLine=7077892;
 //BA.debugLineNum = 7077892;BA.debugLine="Dim obj As Map = jsonParser.NextObject";
_obj = new anywheresoftware.b4a.objects.collections.Map();
_obj = _jsonparser.NextObject();
RDebugUtils.currentLine=7077894;
 //BA.debugLineNum = 7077894;BA.debugLine="pais.codigoPais = obj.Get(\"codigoPais\")";
_pais._codigopais /*int*/  = (int)(BA.ObjectToNumber(_obj.Get((Object)("codigoPais"))));
RDebugUtils.currentLine=7077895;
 //BA.debugLineNum = 7077895;BA.debugLine="pais.capital = obj.Get(\"capital\")";
_pais._capital /*String*/  = BA.ObjectToString(_obj.Get((Object)("capital")));
RDebugUtils.currentLine=7077896;
 //BA.debugLineNum = 7077896;BA.debugLine="pais.codigoISO = obj.Get(\"codigoISO\")";
_pais._codigoiso /*String*/  = BA.ObjectToString(_obj.Get((Object)("codigoISO")));
RDebugUtils.currentLine=7077897;
 //BA.debugLineNum = 7077897;BA.debugLine="pais.idioma = obj.Get(\"idioma\")";
_pais._idioma /*String*/  = BA.ObjectToString(_obj.Get((Object)("idioma")));
RDebugUtils.currentLine=7077898;
 //BA.debugLineNum = 7077898;BA.debugLine="pais.moneda = obj.Get(\"moneda\")";
_pais._moneda /*String*/  = BA.ObjectToString(_obj.Get((Object)("moneda")));
RDebugUtils.currentLine=7077899;
 //BA.debugLineNum = 7077899;BA.debugLine="pais.nombre = obj.Get(\"nombre\")";
_pais._nombre /*String*/  = BA.ObjectToString(_obj.Get((Object)("nombre")));
RDebugUtils.currentLine=7077900;
 //BA.debugLineNum = 7077900;BA.debugLine="pais.poblacion = obj.Get(\"poblacion\")";
_pais._poblacion /*int*/  = (int)(BA.ObjectToNumber(_obj.Get((Object)("poblacion"))));
RDebugUtils.currentLine=7077902;
 //BA.debugLineNum = 7077902;BA.debugLine="Return pais";
if (true) return _pais;
RDebugUtils.currentLine=7077903;
 //BA.debugLineNum = 7077903;BA.debugLine="End Sub";
return null;
}
}