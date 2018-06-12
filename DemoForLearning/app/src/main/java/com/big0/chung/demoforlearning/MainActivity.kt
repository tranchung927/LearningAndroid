package com.big0.chung.demoforlearning

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // COMPLETED (26) Create an EditText variable called mSearchBoxEditText
    lateinit var mSearchBoxEditText: EditText

    // COMPLETED (27) Create a TextView variable called mUrlDisplayTextView
    lateinit var mUrlDisplayTextView: TextView

    // COMPLETED (28) Create a TextView variable called mSearchResultsTextView
    lateinit var mSearchResultsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // COMPLETED (29) Use findViewById to get a reference to mSearchBoxEditText
        mSearchBoxEditText = findViewById(R.id.et_search_box)

        // COMPLETED (30) Use findViewById to get a reference to mUrlDisplayTextView
        mUrlDisplayTextView = findViewById(R.id.tv_url_display)
        
        // COMPLETED (31) Use findViewById to get a reference to mSearchResultsTextView
        mSearchResultsTextView = findViewById(R.id.tv_github_search_results_json)
    }
}
