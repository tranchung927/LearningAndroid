package com.big0.chung.demoforlearning

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


// COMPLETED (4) Implement GreenAdapter.ListItemClickListener from the MainActivity
class MainActivity : AppCompatActivity(), GreenAdapter.ListItemClickListener {

    val NUM_LIST_ITEMS = 100

    val mAdapter by lazy {
        GreenAdapter(this, NUM_LIST_ITEMS, this)
    }

    // COMPLETED (5) Create a Toast variable called mToast to store the current Toast
    /*
     * If we hold a reference to our Toast, we can cancel it (if it's showing)
     * to display a new Toast. If we didn't do this, Toasts would be delayed
     * in showing up if you clicked many list items in quick succession.
     */
    var mToast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
         * A LinearLayoutManager is responsible for measuring and positioning item views within a
         * RecyclerView into a linear list. This means that it can produce either a horizontal or
         * vertical list depending on which parameter you pass in to the LinearLayoutManager
         * constructor. By default, if you don't specify an orientation, you get a vertical list.
         * In our case, we want a vertical list, so we don't need to pass in an orientation flag to
         * the LinearLayoutManager constructor.
         *
         * There are other LayoutManagers available to display your data in uniform grids,
         * staggered grids, and more! See the developer documentation for more details.
         */
        rv_numbers.layoutManager = LinearLayoutManager(this)

        /*
         * Use this setting to improve performance if you know that changes in content do not
         * change the child layout size in the RecyclerView
         */
        rv_numbers.setHasFixedSize(true)

        /*
         * The GreenAdapter is responsible for displaying each item in the list.
         */
        rv_numbers.adapter = mAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        /*
            * When you click the reset menu item, we want to start all over
            * and display the pretty gradient again. There are a few similar
            * ways of doing this, with this one being the simplest of those
            * ways. (in our humble opinion)
            */
        if (item.itemId == R.id.action_refresh) {
            mAdapter.viewHolderCount = 0
            rv_numbers.adapter = mAdapter
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    // COMPLETED (5) Override ListItemClickListener's onListItemClick method
    /**
     * This is where we receive our callback from
     * {@link com.example.android.recyclerview.GreenAdapter.ListItemClickListener}
     *
     * This callback is invoked when you click on an item in the list.
     *
     * @param clickedItemIndex Index in the list of the item that was clicked.
     */
    override fun onListItemClick(clickedItemIndex: Int) {
        // COMPLETED (6) In the beginning of the method, cancel the Toast if it isn't null
        /*
         * Even if a Toast isn't showing, it's okay to cancel it. Doing so
         * ensures that our new Toast will show immediately, rather than
         * being delayed while other pending Toasts are shown.
         *
         * Comment out these three lines, run the app, and click on a bunch of
         * different items if you're not sure what I'm talking about.
         */
        if (mToast != null) {
            mToast!!.cancel()
        }

        // COMPLETED (7) Show a Toast when an item is clicked, displaying that item number that was clicked
        /*
         * Create a Toast and store it in our Toast field.
         * The Toast that shows up will have a message similar to the following:
         *
         *                     Item #42 clicked.
         */
        val toastMessage = "Item #" + clickedItemIndex + " clicked."
        mToast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG)
        mToast!!.show()
    }
}
