package org.d3if3077.assessmenttanaman

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.d3if3077.assessmenttanaman.databinding.ActivityMainBinding
import org.d3if3077.assessmenttanaman.screen.MainScreen
import org.d3if3077.assessmenttanaman.ui.theme.AssessmentTanamanTheme

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: ListData
    var dataArrayList = ArrayList<ListData?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageList = intArrayOf(
            R.drawable.jahe,
            R.drawable.lidah_buaya,
            R.drawable.sambiloto,
            R.drawable.kunyit,
            R.drawable.daun_kemangi
        )

        val descList = intArrayOf(
            R.string.jahe,
            R.string.lidah_buaya,
            R.string.sambiloto,
            R.string.kunyit,
            R.string.daun_kemangi,
        )
        val nameList = arrayOf("Jahe", "Lidah Buaya", "Sambiloto", "Kunyit", "Daun Kemangi")

        for (i in imageList.indices) {
            listData = ListData(
                nameList[i],
                imageList[i]
            )
            dataArrayList.add(listData)
        }

        listAdapter = ListAdapter(this@MainActivity, dataArrayList)
        binding.listview.adapter = listAdapter
        binding.listview.isClickable = true

        binding.listview.onItemClickListener = OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this@MainActivity, DetailedActivity::class.java)
            intent.putExtra("name", nameList[i])
            intent.putExtra("image", imageList[i])
            startActivity(intent)
        }
    }

    // Adapter class for the ListView
        class ListAdapter(context: Context, dataArrayList: ArrayList<ListData?>?) :
        ArrayAdapter<ListData?>(context, R.layout.list_item, dataArrayList!!) {

        override fun getView(position: Int, view: View?, parent: ViewGroup): View {

            var view = view
            val listData = getItem(position)

            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
            }

            val listImage = view!!.findViewById<ImageView>(R.id.listImage)
            val listName = view.findViewById<TextView>(R.id.listName)
            val listTime = view.findViewById<TextView>(R.id.listTime)

            listImage.setImageResource(listData!!.image)
            listName.text = listData.name

            return view
        }
    }

    // Data class to hold information for each list item
    data class ListData(
        val name: String,
        val image: Int
    )

    // Your MainActivity composable class
    @Composable
    fun MainActivityContent() {
        AssessmentTanamanTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                MainScreen()
            }
        }
    }
}
