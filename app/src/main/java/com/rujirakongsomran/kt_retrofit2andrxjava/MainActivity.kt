package com.rujirakongsomran.kt_retrofit2andrxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rujirakongsomran.kt_retrofit2andrxjava.Adapter.PostAdapter
import com.rujirakongsomran.kt_retrofit2andrxjava.Model.Post
import com.rujirakongsomran.kt_retrofit2andrxjava.Retrofit.IMyAPI
import com.rujirakongsomran.kt_retrofit2andrxjava.Retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal lateinit var jsonApi: IMyAPI
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init API
        val retrofit = RetrofitClient.instance
        jsonApi = retrofit.create(IMyAPI::class.java)

        // View
        recyclerViewPosts.setHasFixedSize(true)
        recyclerViewPosts.layoutManager = LinearLayoutManager(this)
        fetchData()
    }

    private fun fetchData() {
        compositeDisposable.add(jsonApi.posts
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { posts -> displayData(posts) }
        )
    }

    private fun displayData(posts: List<Post>?) {
        var adapter = PostAdapter(this, posts!!)
        recyclerViewPosts.adapter = adapter
    }
}