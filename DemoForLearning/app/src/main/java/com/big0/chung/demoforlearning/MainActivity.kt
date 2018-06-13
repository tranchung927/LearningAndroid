package com.big0.chung.demoforlearning

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onclickStartNewActivity(view: View) {

        // COMPLETED (1) Retrieve the text from the EditText and store it in a variable
        /* We'll first get the text entered by the user in the EditText */

        val textEntered = et_text_entry.text.toString()

        val destinationActivity = ChildActivity::class.java

        val startChildActivityIntent = Intent(this, destinationActivity)

        // COMPLETED (2) Use the putExtra method to put the String from the EditText in the Intent
        /*
         * We use the putExtra method of the Intent class to pass some extra stuff to the
         * Activity that we are starting. Generally, this data is quite simple, such as
         * a String or a number. However, there are ways to pass more complex objects.
         */
        startChildActivityIntent.putExtra(Intent.EXTRA_TEXT, textEntered)

        startActivity(startChildActivityIntent)
    }
}
