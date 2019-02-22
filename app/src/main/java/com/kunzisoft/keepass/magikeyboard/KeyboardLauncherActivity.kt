package com.kunzisoft.keepass.magikeyboard

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kunzisoft.keepass.activities.GroupActivity
import com.kunzisoft.keepass.app.App
import com.kunzisoft.keepass.fileselect.FileSelectActivity
import com.kunzisoft.keepass.timeout.TimeoutHelper

class KeyboardLauncherActivity : AppCompatActivity() {

    companion object {
        val TAG = KeyboardLauncherActivity::class.java.name!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        TimeoutHelper.checkTime(this)
        if (App.getDB().loaded)
            GroupActivity.launchForKeyboardSelection(this, true)
        else {
            // Pass extra to get entry
            FileSelectActivity.launchForKeyboardSelection(this)
        }
        finish()
        super.onCreate(savedInstanceState)
    }
}
