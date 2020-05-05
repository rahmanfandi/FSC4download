package com.example.fsc4download

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference



private var firebaseStorage: FirebaseStorage? = null
private var storageReference: StorageReference? = null
lateinit var image1 : ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        firebaseStorage = FirebaseStorage.getInstance()
        storageReference = FirebaseStorage.getInstance().reference


        //inisialisasi image1
        image1 = findViewById(R.id.imageView2)


    }


fun download() {

    println("jalan")
    storageReference?.child("uploads/calon/1")?.downloadUrl?.addOnFailureListener {
        println("url = gagal")
        // failure
    }?.addOnSuccessListener() { taskSnapshot ->
        // success


        var url = taskSnapshot.toString()

        println("url =" + url.toString())



        //dependency glide dipanggil dan diterapkan ke image1
        Glide.with(this)
            .load(url)
            .placeholder(R.color.colorPrimary)
            .error(R.color.colorPrimary)
            .into(image1)

    }///end fun


}

    fun button1(view: View) {
        download()





    }


}
