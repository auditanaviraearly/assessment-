package org.d3if3077.assessmenttanaman

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.d3if3077.assessmenttanaman.databinding.ActivityDetailedBinding

class DetailedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val intent = this.intent
        if (intent != null) {
            val name = intent.getStringExtra("name")
            val image = intent.getIntExtra("image", R.drawable.jahe)

            binding.detailName.text = name
            binding.detailImage.setImageResource(image)
        }
    }
}