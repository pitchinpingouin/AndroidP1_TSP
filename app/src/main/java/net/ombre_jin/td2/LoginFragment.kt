package net.ombre_jin.td2

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.edit
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import net.ombre_jin.td2.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LoginFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    lateinit var databinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        databinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        var view = databinding.root

        databinding.login.setOnClickListener()
        {
            if (databinding.emailText.text.toString().equals("")) {
                Toast.makeText(context, "Email empty", Toast.LENGTH_SHORT).show()
            } else if (databinding.passwordText.text.toString().equals("")) {
                Toast.makeText(context, "Password empty", Toast.LENGTH_SHORT).show()
            } else {
                var loginInfos = LoginForm(
                    databinding.emailText.text.toString(),
                    databinding.passwordText.text.toString()
                )
                // TODO : login
                apiLogin(loginInfos)
            }
        }
        return view
    }

    fun apiLogin(loginInfos: LoginForm): LiveData<TokenResponse?> {

        val tokenData = MutableLiveData<TokenResponse?>()

        MainScope().launch {
            var response = API.INSTANCE.userService.login(loginInfos)

            if (response.isSuccessful)
            {
                PreferenceManager.getDefaultSharedPreferences(context).edit {
                    putString(SHARED_PREF_TOKEN_KEY, response.body()?.token)
                }
                findNavController().navigate(R.id.action_loginFragment_to_mainActivity)
                tokenData.postValue(response.body())
            } else {
                Toast.makeText(context, "Authentication failed", Toast.LENGTH_LONG).show()
            }

        }
        return tokenData
    }
}
