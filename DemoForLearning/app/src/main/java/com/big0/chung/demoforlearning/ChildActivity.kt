package com.big0.chung.demoforlearning

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

// COMPLETED (1) Use Android Studio's Activity wizard to create a new Activity called ChildActivity
class ChildActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child)
    }
}
