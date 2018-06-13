package com.big0.chung.demoforlearning

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import com.big0.chung.demoforlearning.utilities.NetworkUtils
import java.net.URL


class MainActivity : AppCompatActivity() {

    lateinit var mSearchBoxEditText: EditText
    lateinit var mUrlDisplayTextView: TextView
    lateinit var mSearchResultsTextView: TextView

    // COMPLETED (12) Create a variable to store a reference to the error message TextView
    lateinit var mErrorMessageDisplay: TextView

    // COMPLETED (24) Create a ProgressBar variable to store a reference to the ProgressBar
    lateinit var mLoadingIndicator: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSearchBoxEditText = findViewById(R.id.et_search_box)
        mUrlDisplayTextView = findViewById(R.id.tv_url_display)
        mSearchResultsTextView = findViewById(R.id.tv_github_search_results_json)

        // COMPLETED (13) Get a reference to the error TextView using findViewById
        mErrorMessageDisplay = findViewById(R.id.tv_error_message_display);

        // COMPLETED (25) Get a reference to the ProgressBar using findViewById
        mLoadingIndicator = findViewById(R.id.pb_loading_indicator);
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
        GithubQueryTask().execute(githubSearchUrl)

    }

    // COMPLETED (14) Create a method called showJsonDataView to show the data and hide the error
    /**
     * This method will make the View for the JSON data visible and
     * hide the error message.
     * <p>
     * Since it is okay to redundantly set the visibility of a View, we don't
     * need to check whether each view is currently visible or invisible.
     */
    fun showJsonDataView() {
        // First, make sure the error is invisible
        mErrorMessageDisplay.visibility = View.INVISIBLE
        // Then, make sure the JSON data is visible
        mSearchResultsTextView.visibility = View.VISIBLE
    }

    // COMPLETED (15) Create a method called showErrorMessage to show the error and hide the data
    /**
     * This method will make the error message visible and hide the JSON
     * View.
     * <p>
     * Since it is okay to redundantly set the visibility of a View, we don't
     * need to check whether each view is currently visible or invisible.
     */

    fun showErrorMessage() {
        // First, hide the currently visible data
        mSearchResultsTextView.visibility = View.INVISIBLE
        // Then, show the error
        mErrorMessageDisplay.visibility = View.VISIBLE
    }

    inner class GithubQueryTask(): AsyncTask<URL, Void, String>() {

        override fun onPreExecute() {
            super.onPreExecute()
            mLoadingIndicator.visibility = View.VISIBLE
        }

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

        override fun onPostExecute(result: String?) {
            // COMPLETED (27) As soon as the loading is complete, hide the loading indicator
            mLoadingIndicator.visibility = View.INVISIBLE
            if (result != null && !result.equals("")) {
                // COMPLETED (17) Call showJsonDataView if we have valid, non-null results
                showJsonDataView()
                mSearchResultsTextView.text = result
            } else {
                // COMPLETED (16) Call showErrorMessage if the result is null in onPostExecute
                showErrorMessage()
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
