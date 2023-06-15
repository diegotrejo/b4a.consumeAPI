B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=12.2
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private apiUrl As String = "https://empresautnapi2023.azurewebsites.net/api/Paises/"
	Private txtcodigoPais As EditText
	Private txtnombre As EditText
	Private txtpoblacion As EditText
	Private txtcodigoISO As EditText
	Private txtmoneda As EditText
	Private txtcapital As EditText
	Private txtidioma As EditText
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("CrudPaises")

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub cmdAdd_Click
	Wait For(CrearPais( txtcodigoPais.Text, txtcodigoISO.Text, txtnombre.Text, txtcapital.Text, txtidioma.Text, txtmoneda.Text, txtpoblacion.Text)) Complete (p As Pais)
	
	If p <> Null Then
		txtcodigoPais.Text = p.codigoPais
	Else
		Msgbox("no se pudo crear pais", "error")
	End If
End Sub

Private Sub cmdUpdate_Click
	wait for (ActualizarPais( txtcodigoPais.Text, txtcodigoISO.Text, txtnombre.Text, txtcapital.Text, txtidioma.Text, txtmoneda.Text, txtpoblacion.Text)) Complete (success As Boolean)
	If success Then
		Msgbox("datos actualizados", "Ok")
	Else
		Msgbox("no se pudo actualizar", "error")
	End If
End Sub

Private Sub cmdDelete_Click
	wait for (BorrarPais( txtcodigoPais.Text )) Complete(success As Boolean)
	If success Then
		txtcodigoPais.Text = ""
		txtcapital.Text = ""
		txtcodigoISO.Text = ""
		txtidioma.Text = ""
		txtmoneda.Text = ""
		txtnombre.Text = ""
		txtpoblacion.Text = ""
		Msgbox("datos borrados", "Ok")
	Else
		Msgbox("no se pudo borrar", "error")
	End If
End Sub

Private Sub cmdSelect_Click
	
	Wait For( GetPais(txtcodigoPais.Text) ) Complete (p As Pais)
	
	If p <> Null Then
		txtcodigoPais.Text = p.codigoPais
		txtcapital.Text = p.capital
		txtcodigoISO.Text = p.codigoISO
		txtidioma.Text = p.idioma
		txtmoneda.Text = p.moneda
		txtnombre.Text = p.nombre
		txtpoblacion.Text = p.poblacion
	Else
		txtcodigoPais.Text = ""
		txtcapital.Text = ""
		txtcodigoISO.Text = ""
		txtidioma.Text = ""
		txtmoneda.Text = ""
		txtnombre.Text = ""
		txtpoblacion.Text = ""
		Msgbox( "pais no encontrado", "Sucedio un error")
	End If
End Sub

Private Sub CrearPais( codigoPais As Int, codigoISO As String, nombre As String, capital As String, idioma As String, moneda As String, poblacion As Int) As ResumableSub
	Dim api As HttpJob : api.initialize("", Me)
	Dim json As String
	Dim jsonGenerator As JSONGenerator
	Dim obj As Map : obj.initialize
	Dim pais As Pais = Null
	
	obj.Put("codigoPais", codigoPais)
	obj.Put("nombre", nombre)
	obj.Put("poblacion", poblacion)
	obj.Put("codigoISO", codigoISO)
	obj.Put("moneda", moneda)
	obj.Put("capital", capital)
	obj.Put("idioma", idioma)
	
	jsonGenerator.Initialize( obj )
	json = jsonGenerator.ToPrettyString(5)
	
	api.PostString( apiUrl, json)
	api.GetRequest.SetContentType("application/json")
	
	Wait For (api) JobDone( response As HttpJob )
	If response.Success Then
		pais = getPais2( response.GetString)
	End If
	
	Return pais
End Sub

Private Sub ActualizarPais( codigoPais As Int, codigoISO As String, nombre As String, capital As String, idioma As String, moneda As String, poblacion As Int) As ResumableSub
	Dim api As HttpJob : api.initialize("", Me)
	Dim json As String
	Dim jsonGenerator As JSONGenerator
	Dim obj As Map : obj.initialize
	
	obj.Put("codigoPais", codigoPais)
	obj.Put("nombre", nombre)
	obj.Put("poblacion", poblacion)
	obj.Put("codigoISO", codigoISO)
	obj.Put("moneda", moneda)
	obj.Put("capital", capital)
	obj.Put("idioma", idioma)
	
	jsonGenerator.Initialize( obj )
	json = jsonGenerator.ToPrettyString(5)
	
	api.PutString( apiUrl, json)
	api.GetRequest.SetContentType("application/json")
	
	Wait For (api) JobDone( response As HttpJob )
	Return response.Success

End Sub

Private Sub GetPais( codigoPais As Int ) As ResumableSub 
	Dim api As HttpJob : api.Initialize("", Me)
	Dim pais As Pais = Null
	
	api.Download( apiUrl & codigoPais )
	Wait For (api) JobDone( response As HttpJob)
	
	If response.Success Then
		pais = getPais2( response.GetString )	
	End If
	Return pais
End Sub

Private Sub BorrarPais( codigoPais As Int) As ResumableSub
	Dim api As HttpJob : api.initialize("", Me)
	api.Delete(apiUrl & codigoPais )
	Wait For (api) JobDone( response As HttpJob )
	Return response.Success
End Sub

Private Sub getPais2( json As String ) As Pais
	
	Dim jsonParser As JSONParser :  jsonParser.Initialize(json)
	Dim pais As Pais : pais.initialize
	Dim obj As Map = jsonParser.NextObject
	
	pais.codigoPais = obj.Get("codigoPais")
	pais.capital = obj.Get("capital")
	pais.codigoISO = obj.Get("codigoISO")
	pais.idioma = obj.Get("idioma")
	pais.moneda = obj.Get("moneda")
	pais.nombre = obj.Get("nombre")
	pais.poblacion = obj.Get("poblacion")
	
	Return pais
End Sub

