package com.aldreduser.developwithfreedom.Level_2.Storage_Package

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.aldreduser.developwithfreedom.R

/* Ways to store data

-files on the device
-in key-value pairs
-in a database
-or with other data types


-App-specific storage:  meant for the app's use only, in dedicated directories. Use the
 directories within internal storage to save sensitive information that other apps shouldn't access.
-Shared storage: Store files that your app intends to share with other apps, including media, documents, and other files.
-Preferences: Store private, primitive data in key-value pairs.
-Databases: Store structured data in a private database using the Room persistence library.


tips:
-Don't open and close files repeatedly (for performance)
*/


class LocalStorageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level2_activity_local_storage)
    }
    fun textFileStorageJavaClicked(view: View) {
        val intent = Intent(this, TextStorageJavaActivity::class.java)
        startActivity(intent)
    }
    fun getPreferencesButtonClicked(view: View) {
        val intent = Intent(this, GetPreferencesActivity::class.java)
        startActivity(intent)
    }
    fun sharedPreferencesButtonClicked(view: View) {
        val intent = Intent(this, SharedPreferenceActivity::class.java)
        startActivity(intent)
    }
    fun appSpecificStorageClicked(view: View) {
        val intent = Intent(this, AppSpecificStorage::class.java)
        startActivity(intent)
    }
    fun databaseSQLButtonClicked(view: View) {
        val intent = Intent(this, StorageSQLActivity::class.java)
        startActivity(intent)
    }
}
