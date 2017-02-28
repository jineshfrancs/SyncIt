# SyncIt
SyncIt will call a method implemented in your activity to notify data connection changes.

Add SyncApplication to your manifest

```
<application
    android:allowBackup="true"
    android:icon="@mipmap/ic_launcher"
    android:label="@string/app_name"
    android:name="test.jinesh.sync.SyncApplication"
    android:supportsRtl="true"
    android:theme="@style/AppTheme">
   <activity android:name=".MainActivity">
       <intent-filter>
          <action android:name="android.intent.action.MAIN" />

          <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
    </activity>
</application>
```    
 Just implements ```OnSyncListner``` in your activities in which you want to listen for data connection changes.
```
 @Override
 public void onSync(boolean isDataAvailable) {
   if(isDataAvailable){
      /*Call web service to update views here*/
   }else{
      /*No data connection*/
   }
 }
```
