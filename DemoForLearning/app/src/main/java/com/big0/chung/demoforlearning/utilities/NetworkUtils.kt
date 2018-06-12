package com.big0.chung.demoforlearning.utilities

import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

class NetworkUtils {
    companion object {
        val GITHUB_BASE_URL = "https://api.github.com/search/repositories"
        val PARAM_QUERY = "q"
        /*
        * The sort field. One of stars, forks, or updated.
        * Default: results are sorted by best match if no field is specified.
        */
        val PARAM_SORT = "sort"
        val sortBy = "stars"

        /**
         * Builds the URL used to query Github.
         *
         * @param githubSearchQuery The keyword that will be queried for.
         * @return The URL to use to query the weather server.
         */

        fun buildUrl(githubSearchQuery: String): URL? {
            return null
        }

        /**
         * This method returns the entire result from the HTTP response.
         *
         * @param url The URL to fetch the HTTP response from.
         * @return The contents of the HTTP response.
         * @throws IOException Related to network and stream reading
         */
        @Throws(IOException::class)
        fun getResponseFromHttpUrl(url: URL): String? {
            val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
            try {
                val input = urlConnection.inputStream
                val scanner = Scanner(input)
                scanner.useDelimiter("\\A")
                val hasInput = scanner.hasNext()

                return if (hasInput) scanner.next() else null

            } finally {
                urlConnection.disconnect()
            }
        }
    }
}