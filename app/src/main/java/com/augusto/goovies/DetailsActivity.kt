package com.augusto.goovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.augusto.goovies.extensions.loadImageCoil
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val title = intent.getStringExtra("titleMovie")
        textDetailTitle.text = title
        val sumaryShort = intent.getStringExtra("descriptionMovie")
        textDescriptionDetail.text = sumaryShort
        val imageMovieDetail = intent.getStringExtra("imageMovie")
        imageDetail.loadImageCoil {
            uri = imageMovieDetail
        }
        val byLineDescription = intent.getStringExtra("byLine")
        textByLine.text = byLineDescription
        val valRating = intent.getStringExtra("valRating")
        textLink.text = valRating

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.anv_share -> Toast.makeText(this, "Share selected", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

}