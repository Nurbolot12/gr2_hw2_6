package com.example.gr2_hw2_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gr2_hw2_6.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding
    private var imageURL = arrayListOf<ImageModel>()
    private var selectedImage = arrayListOf<ImageModel>()
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fillList()
        initViews()
        clickSend()
    }

    private fun clickSend() {
        binding.btnSend.setOnClickListener {
            if (selectedImage.isNotEmpty()){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(AppConstant.SELECTED_LIST, selectedImage)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please choose any photo!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fillList() {
        imageURL.add(ImageModel("https://mobimg.b-cdn.net/v3/fetch/1b/1bbe0c30fd8b9cd89656e6dc6d5e59a7.jpeg"))
        imageURL.add(ImageModel("https://mobimg.b-cdn.net/v3/fetch/c2/c2e07b2dfe7e27724dd3c36daed54591.jpeg"))
        imageURL.add(ImageModel("https://s1.1zoom.ru/big3/977/Mountains_Scenery_473520.jpg"))
        imageURL.add(ImageModel("https://mobimg.b-cdn.net/v3/fetch/52/5209a3872dced549c0e9a6f8360c5471.jpeg"))
        imageURL.add(ImageModel("https://mobimg.b-cdn.net/v3/fetch/a3/a34c8080eae52f4c2ef90d98e0ce3879.jpeg"))
        imageURL.add(ImageModel("https://get.wallhere.com/photo/cat-grass-lurk-muzzle-bushy-1078052.jpg"))
        imageURL.add(ImageModel("https://mobimg.b-cdn.net/v3/fetch/c8/c8b2da83ea076dc9e0277f8be27390ce.jpeg"))
        imageURL.add(ImageModel("https://mobimg.b-cdn.net/v3/fetch/de/ded9fa489a65dfcfae148dc69b9ec942.jpeg"))
        imageURL.add(ImageModel("https://gas-kvas.com/uploads/posts/2023-02/1675415690_gas-kvas-com-p-kartinki-dlya-fonovogo-risunka-rabochego-s-43.jpg"))
        imageURL.add(ImageModel("https://mobimg.b-cdn.net/v3/fetch/f0/f0c175d42726c757bad68eac27a3c425.jpeg"))
        imageURL.add(ImageModel("https://www.sunhome.ru/i/wallpapers/221/frukti-oboi.orig.jpg"))
        imageURL.add(ImageModel("https://mobimg.b-cdn.net/v3/fetch/c2/c2a0d13ff31dbe50c51820546fdd8e55.jpeg"))
        imageURL.add(ImageModel("https://uprostim.com/wp-content/uploads/2021/04/image101-3.jpg"))
        imageURL.add(ImageModel("https://i.pinimg.com/originals/1e/bf/8f/1ebf8f94c449f1df66f6faa8fd7a963d.jpg"))
        imageURL.add(ImageModel("https://www.ejin.ru/wp-content/uploads/2017/11/cat-and-daisy-desktop-background-1.jpg"))
    }

    private fun initViews() {
        imageAdapter = ImageAdapter(imageURL, this::onClickListener, this::deleteItem)
        binding.rvEdit.layoutManager = GridLayoutManager(this, 3)
        binding.rvEdit.adapter = imageAdapter
    }

    private fun onClickListener(item: ImageModel) {
        selectedImage.add(item)
    }

    private fun deleteItem(item: ImageModel) {
        selectedImage.remove(item)
    }

    object AppConstant{
        const val SELECTED_LIST = "selectedList"
    }
}