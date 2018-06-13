package com.big0.chung.demoforlearning

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.number_list_item.view.*

/**
 * We couldn't come up with a good name for this class. Then, we realized
 * that this lesson is about RecyclerView.
 *
 * RecyclerView... Recycling... Saving the planet? Being green? Anyone?
 * #crickets
 *
 * Avoid unnecessary garbage collection by using RecyclerView and ViewHolders.
 *
 * If you don't like our puns, we named this Adapter GreenAdapter because its
 * contents are green.
 */

class GreenAdapter(context: Context, val numberOfItems: Int): RecyclerView.Adapter<GreenAdapter.NumberViewHolder>() {

    // COMPLETED (8) When a new GreenAdapter is created, set the viewHolderCount to 0
    var viewHolderCount = 0

    /**
     *
     * This gets called when each new ViewHolder is created. This happens when the RecyclerView
     * is laid out. Enough ViewHolders will be created to fill the screen and allow for scrolling.
     *
     * @param viewGroup The ViewGroup that these ViewHolders are contained within.
     * @param viewType  If your RecyclerView has more than one type of item (which ours doesn't) you
     *                  can use this viewType integer to provide a different layout. See
     *                  {@link android.support.v7.widget.RecyclerView.Adapter#getItemViewType(int)}
     *                  for more details.
     * @return A new NumberViewHolder that holds the View for each list item
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val view = LayoutInflater.from(parent.context)

        val cell = NumberViewHolder(view.inflate(R.layout.number_list_item, parent, false))

        // COMPLETED (9) Set the text of viewHolderIndex to "ViewHolder index: " + viewHolderCount
        cell.itemView.tv_view_holder_instance.text = "ViewHolder index: " + viewHolderCount

        // COMPLETED (10) Set the background color of viewHolder.itemView with the color from above
        cell.itemView.setBackgroundColor(ColorUtils.getViewHolderBackgroundColorFromInstance(parent.context, viewHolderCount))

        // COMPLETED (11) Increment viewHolderCount and log its value
        viewHolderCount ++
        return cell
    }

    /**
     * This method simply returns the number of items to display. It is used behind the scenes
     * to help layout our Views and for animations.
     *
     * @return The number of items available in our forecast
     */
    override fun getItemCount(): Int {
        return numberOfItems
    }

    /**
     * OnBindViewHolder is called by the RecyclerView to display the data at the specified
     * position. In this method, we update the contents of the ViewHolder to display the correct
     * indices in the list for this particular position, using the "position" argument that is conveniently
     * passed into us.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.bind(position)
    }

    /**
     * Cache of the children views for a list item.
     */
    class NumberViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(listIndex: Int) {
            itemView.tv_item_number.text = listIndex.toString()
        }
    }
}