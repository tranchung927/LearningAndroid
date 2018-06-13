package com.big0.chung.demoforlearning

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val NUM_LIST_ITEMS = 100

    val mAdapter by lazy {
        GreenAdapter(this, NUM_LIST_ITEMS)
    }

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


    // COMPLETED (7) Override onCreateOptionsMenu
    // COMPLETED (8) Use getMenuInflater().inflate to inflate the menu
    // COMPLETED (9) Return true to display this menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    // COMPLETED (10) Override onOptionsItemSelected
    // COMPLETED (11) Within this method, get the ID from the MenuItem
    // COMPLETED (12) If the ID equals R.id.action_refresh, create and set a new adapter on the RecyclerView and return true
    // COMPLETED (13) For now, for all other IDs, return super.onOptionsItemSelected
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
}
