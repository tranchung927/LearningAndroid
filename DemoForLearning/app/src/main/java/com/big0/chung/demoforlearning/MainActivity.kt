package com.big0.chung.demoforlearning

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.big0.chung.demoforlearning.utilities.NetworkUtils
import java.net.URL


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
        // COMPLETED (4) Create a new GithubQueryTask and call its execute method, passing in the url to query
        GithubQueryTask(this).execute(githubSearchUrl)

    }

    // COMPLETED (1) Create a class called GithubQueryTask that extends AsyncTask<URL, Void, String>
    class GithubQueryTask(val context: MainActivity): AsyncTask<URL, Void, String>() {

        // COMPLETED (2) Override the doInBackground method to perform the query. Return the results. (Hint: You've already written the code to perform the query)
        override fun doInBackground(vararg params: URL?): String? {
            val searchUrl = params[0]
            var githubSearchResults: String? = null
            if (searchUrl != null) {
                try {
                    githubSearchResults = NetworkUtils.getResponseFromHttpUrl(searchUrl)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            return githubSearchResults
        }

        // COMPLETED (3) Override onPostExecute to display the results in the TextView
        override fun onPostExecute(result: String?) {
            if (result != null && !result.equals("")) {
                context.mSearchResultsTextView.text = result
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_search) {
            makeGithubSearchQuery()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
