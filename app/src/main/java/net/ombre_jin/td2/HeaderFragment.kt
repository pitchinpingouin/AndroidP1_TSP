package net.ombre_jin.td2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.header_fragment.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.header_fragment.view.*
import android.content.Intent

class HeaderFragment : Fragment() {

    override fun onResume() {
        //Glide.with(this).load("http://goo.gl/gEgYUd").fitCenter().circleCrop().into(user_avatar)
        MainScope().launch {
            val url = API.userService.getInfo().body()?.avatar ?: "https://goo.gl/gEgYUd"
            Glide.with(this@HeaderFragment).load(url).fitCenter().circleCrop().into(user_avatar)
        }

        user_name.isClickable = true
        user_name.setOnClickListener {
            val selectAvatarIntent = Intent(activity?.baseContext, UserInfoActivity::class.java)
            startActivity(selectAvatarIntent)
        }

        super.onResume()
    }

    private val coroutineScope = MainScope()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.header_fragment, container)
        val view = inflater.inflate(R.layout.header_fragment, container)
        coroutineScope.launch {
            val name: String? = API.userService.getInfo().body()?.firstname
            //println(API.userService.getInfo().body())
            if(name != null) view.user_name.text = name
        }
        return view
    }
}