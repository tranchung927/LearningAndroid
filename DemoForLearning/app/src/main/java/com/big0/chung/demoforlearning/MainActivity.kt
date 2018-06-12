package com.big0.chung.demoforlearning

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.big0.chung.demoforlearning.utilities.NetworkUtils


class MainActivity : AppCompatActivity() {

    lateinit var mSearchBoxEditText: EditText
    lateinit var mUrlDisplayTextView: TextView
    lateinit var mSearchResultsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSearchBoxEditText = findViewById(R.id.et_search_box)
        mUrlDisplayTextView = findViewById(R.id.tv_url_display)
        mSearchResultsTextView = findViewById(R.id.tv_github_search_results_json)
    }

    // COMPLETED (2) Create a method called makeGithubSearchQuery
    // COMPLETED (3) Within this method, build the URL with the text from the EditText and set the built URL to the TextView
    /**
     * This method retrieves the search text from the EditText, constructs
     * the URL (using {@link NetworkUtils}) for the github repository you'd like to find, displays
     * that URL in a TextView, and finally fires off an AsyncTask to perform the GET request using
     * our (not yet created) {@link GithubQueryTask}
     */

    fun makeGithubSearchQuery() {
        val githubQuery = mSearchBoxEditText.text.toString()
        val githubSearchUrl = NetworkUtils.buildUrl(githubQuery)
        mUrlDisplayTextView.text = githubSearchUrl.toString()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_search) {
            // COMPLETED (4) Remove the Toast message when the search menu item is clicked
            // COMPLETED (5) Call makeGithubSearchQuery when the search menu item is clicked
            makeGithubSearchQuery()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
