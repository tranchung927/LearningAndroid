package com.big0.chung.demoforlearning

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onclickStartNewActivity(view: View) {
        // COMPLETED (1) Store ChildActivity.class in a Class object called destinationActivity
        /* This is the class that we want to start (and open) when the button is clicked. */
        val destinationActivity = ChildActivity::class.java

        // COMPLETED (2) Create an Intent to start ChildActivity
        /*
         * Here, we create the Intent that will start the Activity we specified above in
         * the destinationActivity variable. The constructor for an Intent also requires a
         * context, which we stored in the variable named "context".
         */
        val startChildActivityIntent = Intent(this, destinationActivity)
        startActivity(startChildActivityIntent)
    }
}
