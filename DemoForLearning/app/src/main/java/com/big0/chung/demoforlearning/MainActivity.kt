package com.big0.chung.demoforlearning

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    // COMPLETED (2) Loop through each toy and append the name to the TextView (add \n for spacing)
        /*
         * Iterate through the array and append the Strings to the TextView. The reason why we add
         * the "\n\n\n" after the String is to give visual separation between each String in the
         * TextView. Later, we'll learn about a better way to display lists of data.
         */
        for (toyName in ToyBox.getToyNames()) {
            tv_toy_names.append(toyName + "\n\n\n")
        }
    }
}
