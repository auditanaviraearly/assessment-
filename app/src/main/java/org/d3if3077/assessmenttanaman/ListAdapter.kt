package org.d3if3077.assessmenttanaman

// Importing necessary Android libraries
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

// Creating a data class named ListData to hold data for each list item
 class ListAdapter(context: Context, dataArrayList: ArrayList<ListData?>?) :
    ArrayAdapter<ListData?>(context, R.layout.list_item, dataArrayList!!) {

    // Overriding the getView method to customize how each list item is displayed
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {

        // Initializing view variable
        var view = view

        // Getting data for the current list item
        val listData = getItem(position)

        // Checking if the view is null
        if (view == null) {
            // Inflating the layout for list item if view is null
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }

        // Finding views within the list item layout
        val listImage = view!!.findViewById<ImageView>(R.id.listImage)
        val listName = view.findViewById<TextView>(R.id.listName)
        val listTime = view.findViewById<TextView>(R.id.listTime)

        // Setting data to views
        listImage.setImageResource(listData!!.image) // Setting image resource
        listName.text = listData.name // Setting name text

        // Returning the customized view for the list item
        return view
    }
}
