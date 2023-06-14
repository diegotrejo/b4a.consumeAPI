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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
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
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
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
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, httputils2service.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static void  _button1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button1_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "button1_click", null); return;}
ResumableSub_Button1_Click rsub = new ResumableSub_Button1_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_Button1_Click extends BA.ResumableSub {
public ResumableSub_Button1_Click(b4a.example.main parent) {
this.parent = parent;
}
b4a.example.main parent;
b4a.example.httpjob _j = null;
b4a.example.httpjob _j1 = null;
String _json = "";
anywheresoftware.b4a.objects.collections.JSONParser _jsonparser = null;
anywheresoftware.b4a.objects.collections.Map _map = null;
b4a.example.pokemon_ditto _res = null;
b4a.example.form _f = null;
b4a.example.abilityitem _a = null;
anywheresoftware.b4a.BA.IterableList group20;
int index20;
int groupLen20;
anywheresoftware.b4a.BA.IterableList group24;
int index24;
int groupLen24;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="xui.MsgboxAsync(\"Hello world!\", \"B4X\")";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Hello world!"),BA.ObjectToCharSequence("B4X"));
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="Dim j As HttpJob";
_j = new b4a.example.httpjob();
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="j.Initialize(\"\", Me)";
_j._initialize /*String*/ (null,processBA,"",main.getObject());
RDebugUtils.currentLine=327686;
 //BA.debugLineNum = 327686;BA.debugLine="j.Download(\"https://pokeapi.co/api/v2/pokemon/dit";
_j._download /*String*/ (null,"https://pokeapi.co/api/v2/pokemon/ditto");
RDebugUtils.currentLine=327687;
 //BA.debugLineNum = 327687;BA.debugLine="Wait For (j) JobDone(j1 As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "button1_click"), (Object)(_j));
this.state = 14;
return;
case 14:
//C
this.state = 1;
_j1 = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=327688;
 //BA.debugLineNum = 327688;BA.debugLine="If j1.Success Then";
if (true) break;

case 1:
//if
this.state = 13;
if (_j1._success /*boolean*/ ) { 
this.state = 3;
}else {
this.state = 12;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=327689;
 //BA.debugLineNum = 327689;BA.debugLine="Log( j1.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("3327689",_j1._getstring /*String*/ (null),0);
RDebugUtils.currentLine=327690;
 //BA.debugLineNum = 327690;BA.debugLine="Dim json As String = j1.GetString";
_json = _j1._getstring /*String*/ (null);
RDebugUtils.currentLine=327692;
 //BA.debugLineNum = 327692;BA.debugLine="Dim jsonParser As JSONParser";
_jsonparser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=327693;
 //BA.debugLineNum = 327693;BA.debugLine="jsonParser.Initialize(json)";
_jsonparser.Initialize(_json);
RDebugUtils.currentLine=327695;
 //BA.debugLineNum = 327695;BA.debugLine="Dim map As Map = jsonParser.NextObject";
_map = new anywheresoftware.b4a.objects.collections.Map();
_map = _jsonparser.NextObject();
RDebugUtils.currentLine=327696;
 //BA.debugLineNum = 327696;BA.debugLine="Dim res As pokemon_ditto : res.initialize()";
_res = new b4a.example.pokemon_ditto();
RDebugUtils.currentLine=327696;
 //BA.debugLineNum = 327696;BA.debugLine="Dim res As pokemon_ditto : res.initialize()";
_res._initialize /*String*/ (null,processBA);
RDebugUtils.currentLine=327698;
 //BA.debugLineNum = 327698;BA.debugLine="res.base_experience = map.Get(\"base_experience\")";
_res._base_experience /*int*/  = (int)(BA.ObjectToNumber(_map.Get((Object)("base_experience"))));
RDebugUtils.currentLine=327699;
 //BA.debugLineNum = 327699;BA.debugLine="res.height = map.Get(\"height\")";
_res._height /*int*/  = (int)(BA.ObjectToNumber(_map.Get((Object)("height"))));
RDebugUtils.currentLine=327700;
 //BA.debugLineNum = 327700;BA.debugLine="res.forms = GetForms( map.Get(\"forms\") )";
_res._forms /*anywheresoftware.b4a.objects.collections.List*/  = _getforms((anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_map.Get((Object)("forms")))));
RDebugUtils.currentLine=327701;
 //BA.debugLineNum = 327701;BA.debugLine="res.abilities = GetAbilities( map.Get(\"abilities";
_res._abilities /*anywheresoftware.b4a.objects.collections.List*/  = _getabilities((anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_map.Get((Object)("abilities")))));
RDebugUtils.currentLine=327703;
 //BA.debugLineNum = 327703;BA.debugLine="Log(res.base_experience)";
anywheresoftware.b4a.keywords.Common.LogImpl("3327703",BA.NumberToString(_res._base_experience /*int*/ ),0);
RDebugUtils.currentLine=327704;
 //BA.debugLineNum = 327704;BA.debugLine="Log(res.height)";
anywheresoftware.b4a.keywords.Common.LogImpl("3327704",BA.NumberToString(_res._height /*int*/ ),0);
RDebugUtils.currentLine=327705;
 //BA.debugLineNum = 327705;BA.debugLine="For Each f As form In res.forms";
if (true) break;

case 4:
//for
this.state = 7;
group20 = _res._forms /*anywheresoftware.b4a.objects.collections.List*/ ;
index20 = 0;
groupLen20 = group20.getSize();
this.state = 15;
if (true) break;

case 15:
//C
this.state = 7;
if (index20 < groupLen20) {
this.state = 6;
_f = (b4a.example.form)(group20.Get(index20));}
if (true) break;

case 16:
//C
this.state = 15;
index20++;
if (true) break;

case 6:
//C
this.state = 16;
RDebugUtils.currentLine=327706;
 //BA.debugLineNum = 327706;BA.debugLine="Log(\"     \" & f.name)";
anywheresoftware.b4a.keywords.Common.LogImpl("3327706","     "+_f._name /*String*/ ,0);
RDebugUtils.currentLine=327707;
 //BA.debugLineNum = 327707;BA.debugLine="Log(\"     \" & f.url)";
anywheresoftware.b4a.keywords.Common.LogImpl("3327707","     "+_f._url /*String*/ ,0);
 if (true) break;
if (true) break;
;
RDebugUtils.currentLine=327709;
 //BA.debugLineNum = 327709;BA.debugLine="For Each a As abilityItem In res.abilities";

case 7:
//for
this.state = 10;
group24 = _res._abilities /*anywheresoftware.b4a.objects.collections.List*/ ;
index24 = 0;
groupLen24 = group24.getSize();
this.state = 17;
if (true) break;

case 17:
//C
this.state = 10;
if (index24 < groupLen24) {
this.state = 9;
_a = (b4a.example.abilityitem)(group24.Get(index24));}
if (true) break;

case 18:
//C
this.state = 17;
index24++;
if (true) break;

case 9:
//C
this.state = 18;
RDebugUtils.currentLine=327710;
 //BA.debugLineNum = 327710;BA.debugLine="Log(\"     \" & a.is_hidden)";
anywheresoftware.b4a.keywords.Common.LogImpl("3327710","     "+BA.ObjectToString(_a._is_hidden /*boolean*/ ),0);
RDebugUtils.currentLine=327711;
 //BA.debugLineNum = 327711;BA.debugLine="Log(\"     \" & a.slot)";
anywheresoftware.b4a.keywords.Common.LogImpl("3327711","     "+BA.NumberToString(_a._slot /*int*/ ),0);
RDebugUtils.currentLine=327712;
 //BA.debugLineNum = 327712;BA.debugLine="Log(\"     \" & a.ability.name)";
anywheresoftware.b4a.keywords.Common.LogImpl("3327712","     "+_a._ability /*b4a.example.ability*/ ._name /*String*/ ,0);
RDebugUtils.currentLine=327713;
 //BA.debugLineNum = 327713;BA.debugLine="Log(\"     \" & a.ability.url)";
anywheresoftware.b4a.keywords.Common.LogImpl("3327713","     "+_a._ability /*b4a.example.ability*/ ._url /*String*/ ,0);
 if (true) break;
if (true) break;

case 10:
//C
this.state = 13;
;
 if (true) break;

case 12:
//C
this.state = 13;
RDebugUtils.currentLine=327717;
 //BA.debugLineNum = 327717;BA.debugLine="xui.MsgboxAsync(j1.ErrorMessage, \"Sucedio un err";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence(_j1._errormessage /*String*/ ),BA.ObjectToCharSequence("Sucedio un error"));
 if (true) break;

case 13:
//C
this.state = -1;
;
RDebugUtils.currentLine=327720;
 //BA.debugLineNum = 327720;BA.debugLine="j.Release";
_j._release /*String*/ (null);
RDebugUtils.currentLine=327721;
 //BA.debugLineNum = 327721;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static anywheresoftware.b4a.objects.collections.List  _getforms(anywheresoftware.b4a.objects.collections.List _table) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getforms", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(mostCurrent.activityBA, "getforms", new Object[] {_table}));}
anywheresoftware.b4a.objects.collections.List _lst = null;
int _i = 0;
b4a.example.form _f = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Public Sub GetForms( table As List) As List";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Dim lst As List : lst.initialize";
_lst = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Dim lst As List : lst.initialize";
_lst.Initialize();
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="For i = 0 To table.Size-1";
{
final int step3 = 1;
final int limit3 = (int) (_table.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="Dim f As form :  f.Initialize";
_f = new b4a.example.form();
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="Dim f As form :  f.Initialize";
_f._initialize /*String*/ (null,processBA);
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="Dim m As Map = table.Get(i)";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_table.Get(_i)));
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="f.name = m.Get(\"name\")";
_f._name /*String*/  = BA.ObjectToString(_m.Get((Object)("name")));
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="f.url = m.Get(\"url\")";
_f._url /*String*/  = BA.ObjectToString(_m.Get((Object)("url")));
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="lst.Add(f)";
_lst.Add((Object)(_f));
 }
};
RDebugUtils.currentLine=393225;
 //BA.debugLineNum = 393225;BA.debugLine="Return lst";
if (true) return _lst;
RDebugUtils.currentLine=393226;
 //BA.debugLineNum = 393226;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _getabilities(anywheresoftware.b4a.objects.collections.List _table) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getabilities", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(mostCurrent.activityBA, "getabilities", new Object[] {_table}));}
anywheresoftware.b4a.objects.collections.List _lst = null;
int _i = 0;
b4a.example.abilityitem _a = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
anywheresoftware.b4a.objects.collections.Map _m2 = null;
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Public Sub GetAbilities(table As List) As List";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="Dim lst As List : lst.initialize";
_lst = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="Dim lst As List : lst.initialize";
_lst.Initialize();
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="For i = 0 To table.Size-1";
{
final int step3 = 1;
final int limit3 = (int) (_table.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="Dim a As abilityItem :  a.Initialize";
_a = new b4a.example.abilityitem();
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="Dim a As abilityItem :  a.Initialize";
_a._initialize /*String*/ (null,processBA);
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="Dim m As Map = table.Get(i)";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_table.Get(_i)));
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="a.is_hidden = m.Get(\"is_hidden\")";
_a._is_hidden /*boolean*/  = BA.ObjectToBoolean(_m.Get((Object)("is_hidden")));
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="a.slot = m.Get(\"slot\")";
_a._slot /*int*/  = (int)(BA.ObjectToNumber(_m.Get((Object)("slot"))));
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="Dim m2 As Map = m.Get(\"ability\")";
_m2 = new anywheresoftware.b4a.objects.collections.Map();
_m2 = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_m.Get((Object)("ability"))));
RDebugUtils.currentLine=458761;
 //BA.debugLineNum = 458761;BA.debugLine="a.ability.Initialize";
_a._ability /*b4a.example.ability*/ ._initialize /*String*/ (null,processBA);
RDebugUtils.currentLine=458762;
 //BA.debugLineNum = 458762;BA.debugLine="a.ability.name = m2.Get(\"name\")";
_a._ability /*b4a.example.ability*/ ._name /*String*/  = BA.ObjectToString(_m2.Get((Object)("name")));
RDebugUtils.currentLine=458763;
 //BA.debugLineNum = 458763;BA.debugLine="a.ability.url = m2.Get(\"url\")";
_a._ability /*b4a.example.ability*/ ._url /*String*/  = BA.ObjectToString(_m2.Get((Object)("url")));
RDebugUtils.currentLine=458764;
 //BA.debugLineNum = 458764;BA.debugLine="lst.Add(a)";
_lst.Add((Object)(_a));
 }
};
RDebugUtils.currentLine=458766;
 //BA.debugLineNum = 458766;BA.debugLine="Return lst";
if (true) return _lst;
RDebugUtils.currentLine=458767;
 //BA.debugLineNum = 458767;BA.debugLine="End Sub";
return null;
}
public static void  _button2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button2_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "button2_click", null); return;}
ResumableSub_Button2_Click rsub = new ResumableSub_Button2_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_Button2_Click extends BA.ResumableSub {
public ResumableSub_Button2_Click(b4a.example.main parent) {
this.parent = parent;
}
b4a.example.main parent;
b4a.example.httpjob _j = null;
b4a.example.httpjob _respuesta = null;
String _json = "";
anywheresoftware.b4a.objects.collections.JSONParser _jsonparser = null;
anywheresoftware.b4a.objects.collections.List _datos = null;
b4a.example.tarea _t = null;
anywheresoftware.b4a.BA.IterableList group11;
int index11;
int groupLen11;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="Dim j As HttpJob";
_j = new b4a.example.httpjob();
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="j.Initialize(\"\", Me)";
_j._initialize /*String*/ (null,processBA,"",main.getObject());
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="j.Download(\"https://jsonplaceholder.typicode.com/";
_j._download /*String*/ (null,"https://jsonplaceholder.typicode.com/todos");
RDebugUtils.currentLine=3801093;
 //BA.debugLineNum = 3801093;BA.debugLine="Wait For (j) JobDone( respuesta As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "button2_click"), (Object)(_j));
this.state = 11;
return;
case 11:
//C
this.state = 1;
_respuesta = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="If respuesta.Success Then";
if (true) break;

case 1:
//if
this.state = 10;
if (_respuesta._success /*boolean*/ ) { 
this.state = 3;
}else {
this.state = 9;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=3801095;
 //BA.debugLineNum = 3801095;BA.debugLine="Log( respuesta.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("33801095",_respuesta._getstring /*String*/ (null),0);
RDebugUtils.currentLine=3801096;
 //BA.debugLineNum = 3801096;BA.debugLine="Dim json As String = respuesta.GetString";
_json = _respuesta._getstring /*String*/ (null);
RDebugUtils.currentLine=3801097;
 //BA.debugLineNum = 3801097;BA.debugLine="Dim jsonParser As JSONParser";
_jsonparser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=3801098;
 //BA.debugLineNum = 3801098;BA.debugLine="jsonParser.Initialize(json)";
_jsonparser.Initialize(_json);
RDebugUtils.currentLine=3801100;
 //BA.debugLineNum = 3801100;BA.debugLine="Dim datos As List = GetTareas( jsonParser.NextAr";
_datos = new anywheresoftware.b4a.objects.collections.List();
_datos = _gettareas(_jsonparser.NextArray());
RDebugUtils.currentLine=3801101;
 //BA.debugLineNum = 3801101;BA.debugLine="For Each t As Tarea In datos";
if (true) break;

case 4:
//for
this.state = 7;
group11 = _datos;
index11 = 0;
groupLen11 = group11.getSize();
this.state = 12;
if (true) break;

case 12:
//C
this.state = 7;
if (index11 < groupLen11) {
this.state = 6;
_t = (b4a.example.tarea)(group11.Get(index11));}
if (true) break;

case 13:
//C
this.state = 12;
index11++;
if (true) break;

case 6:
//C
this.state = 13;
RDebugUtils.currentLine=3801102;
 //BA.debugLineNum = 3801102;BA.debugLine="Log( t.title)";
anywheresoftware.b4a.keywords.Common.LogImpl("33801102",_t._title /*String*/ ,0);
RDebugUtils.currentLine=3801103;
 //BA.debugLineNum = 3801103;BA.debugLine="Log( t.userId )";
anywheresoftware.b4a.keywords.Common.LogImpl("33801103",BA.NumberToString(_t._userid /*int*/ ),0);
RDebugUtils.currentLine=3801104;
 //BA.debugLineNum = 3801104;BA.debugLine="Log( t.completed )";
anywheresoftware.b4a.keywords.Common.LogImpl("33801104",BA.ObjectToString(_t._completed /*boolean*/ ),0);
 if (true) break;
if (true) break;

case 7:
//C
this.state = 10;
;
 if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=3801107;
 //BA.debugLineNum = 3801107;BA.debugLine="xui.MsgboxAsync(respuesta.ErrorMessage, \"Sucedio";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence(_respuesta._errormessage /*String*/ ),BA.ObjectToCharSequence("Sucedio un error"));
 if (true) break;

case 10:
//C
this.state = -1;
;
RDebugUtils.currentLine=3801109;
 //BA.debugLineNum = 3801109;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static anywheresoftware.b4a.objects.collections.List  _gettareas(anywheresoftware.b4a.objects.collections.List _tabla) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "gettareas", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(mostCurrent.activityBA, "gettareas", new Object[] {_tabla}));}
anywheresoftware.b4a.objects.collections.List _lst = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
int _i = 0;
b4a.example.tarea _t = null;
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Private Sub GetTareas( tabla As List) As List";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="Dim lst As List : lst.initialize";
_lst = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="Dim lst As List : lst.initialize";
_lst.Initialize();
RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=4587523;
 //BA.debugLineNum = 4587523;BA.debugLine="For i = 0 To tabla.Size -1";
{
final int step4 = 1;
final int limit4 = (int) (_tabla.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=4587524;
 //BA.debugLineNum = 4587524;BA.debugLine="Dim t As Tarea : t.initialize";
_t = new b4a.example.tarea();
RDebugUtils.currentLine=4587524;
 //BA.debugLineNum = 4587524;BA.debugLine="Dim t As Tarea : t.initialize";
_t._initialize /*String*/ (null,processBA);
RDebugUtils.currentLine=4587525;
 //BA.debugLineNum = 4587525;BA.debugLine="m = tabla.Get(i)";
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_tabla.Get(_i)));
RDebugUtils.currentLine=4587526;
 //BA.debugLineNum = 4587526;BA.debugLine="t.id = m.Get(\"id\")";
_t._id /*int*/  = (int)(BA.ObjectToNumber(_m.Get((Object)("id"))));
RDebugUtils.currentLine=4587527;
 //BA.debugLineNum = 4587527;BA.debugLine="t.userId = m.Get(\"userId\")";
_t._userid /*int*/  = (int)(BA.ObjectToNumber(_m.Get((Object)("userId"))));
RDebugUtils.currentLine=4587528;
 //BA.debugLineNum = 4587528;BA.debugLine="t.title = m.Get(\"title\")";
_t._title /*String*/  = BA.ObjectToString(_m.Get((Object)("title")));
RDebugUtils.currentLine=4587529;
 //BA.debugLineNum = 4587529;BA.debugLine="t.completed = m.Get(\"completed\")";
_t._completed /*boolean*/  = BA.ObjectToBoolean(_m.Get((Object)("completed")));
RDebugUtils.currentLine=4587530;
 //BA.debugLineNum = 4587530;BA.debugLine="lst.Add(t)";
_lst.Add((Object)(_t));
 }
};
RDebugUtils.currentLine=4587532;
 //BA.debugLineNum = 4587532;BA.debugLine="Return lst";
if (true) return _lst;
RDebugUtils.currentLine=4587533;
 //BA.debugLineNum = 4587533;BA.debugLine="End Sub";
return null;
}
}