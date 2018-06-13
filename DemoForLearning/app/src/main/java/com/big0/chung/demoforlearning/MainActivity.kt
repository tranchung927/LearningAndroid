package com.big0.chung.demoforlearning

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * This method is called when the Open Website button is clicked. It will open the website
     * specified by the URL represented by the variable urlAsString using implicit Intents.
     *
     * @param v Button that was clicked.
     */

    fun onClickOpenWebpageButton(view: View) {
        val urlAsString = "http://www.udacity.com"
        openWebPage(urlAsString)
    }

    /**
     * This method is called when the Open Location in Map button is clicked. It will open the
     * a map to the location represented by the variable addressString using implicit Intents.
     *
     * @param v Button that was clicked.
     */

    fun onClickOpenAddressButton(view: View) {
        // COMPLETED (5) Store an address in a String
        val addressString = "1600 Amphitheatre Parkway, CA"

        // COMPLETED (6) Use Uri.Builder with the appropriate scheme and query to form the Uri for the address
        val builder = Uri.Builder()
        builder.scheme("geo").path("0,0").query(addressString)
        val addressUri = builder.build()

        // COMPLETED (7) Replace the Toast with a call to showMap, passing in the Uri from the previous step
        showMap(addressUri)
    }

    /**
     * This method is called when the Share Text Content button is clicked. It will simply share
     * the text contained within the String textThatYouWantToShare.
     *
     * @param v Button that was clicked.
     */

    fun onClickShareTextButton(view: View) {
        Toast.makeText(this, "TODO: Share text when this is clicked", Toast.LENGTH_LONG).show()
    }

    /**
     * This is where you will create and fire off your own implicit Intent. Yours will be very
     * similar to what I've done above. You can view a list of implicit Intents on the Common
     * Intents page from the developer documentation.
     *
     * @see <http://developer.android.com/guide/components/intents-common.html/>
     *
     * @param v Button that was clicked.
     */
    fun createYourOwn(view: View) {
        Toast.makeText(this,"TODO: Create Your Own Implicit Intent", Toast.LENGTH_SHORT).show()
    }

    /**
     * This method fires off an implicit Intent to open a webpage.
     *
     * @param url Url of webpage to open. Should start with http:// or https:// as that is the
     *            scheme of the URI expected with this Intent according to the Common Intents page
     */

    fun openWebPage(url: String) {
        /*
         * We wanted to demonstrate the Uri.parse method because its usage occurs frequently. You
         * could have just as easily passed in a Uri as the parameter of this method.
         */
        val webpage = Uri.parse(url)
        /*
         * Here, we create the Intent with the action of ACTION_VIEW. This action allows the user
         * to view particular content. In this case, our webpage URL.
         */
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        /*
         * This is a check we perform with every implicit Intent that we launch. In some cases,
         * the device where this code is running might not have an Activity to perform the action
         * with the data we've specified. Without this check, in those cases your app would crash.
         */
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    // COMPLETED (1) Create a method called showMap with a Uri as the single parameter
    /**
     * This method will fire off an implicit Intent to view a location on a map.
     *
     * When constructing implicit Intents, you can use either the setData method or specify the
     * URI as the second parameter of the Intent's constructor,
     * as I do in {@link #openWebPage(String)}
     *
     * @param geoLocation The Uri representing the location that will be opened in the map
     */
    fun showMap(geoLocation: Uri) {

        // COMPLETED (2) Create an Intent with action type, Intent.ACTION_VIEW
        /*
         * Again, we create an Intent with the action, ACTION_VIEW because we want to VIEW the
         * contents of this Uri.
         */
        val intent = Intent(Intent.ACTION_VIEW)

        // COMPLETED (3) Set the data of the Intent to the Uri passed into this method
        /*
         * Using setData to set the Uri of this Intent has the exact same affect as passing it in
         * the Intent's constructor. This is simply an alternate way of doing this.
         */
        intent.setData(geoLocation)

        // COMPLETED (4) Verify that this Intent can be launched and then call startActivity
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}
