package net.ombre_jin.td2

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_signup.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SignupFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SignupFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignupFragment : Fragment() {
    private val coroutineScope = MainScope()
  //  private val userViewModel by lazy {
   //     ViewModelProviders.of(this).get(UserViewModel::class.java)
   // }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_signup, container, false)

        val sign_up_button = view.findViewById<Button>(R.id.signup_button)
        sign_up_button.setOnClickListener()
        {
            if(!email.text.toString().contains("@")
                || email.text.toString().split("@")[0].isEmpty()
                || email.text.toString().split("@")[1].isEmpty())
            {
                Toast.makeText(context, "Email is invalid", Toast.LENGTH_LONG).show()
            }

            else if(password.text.toString().length < 8)
            {
                Toast.makeText(context, "min length for password is 8", Toast.LENGTH_LONG).show()
            }

            else if(!password_confirmation.text.toString().equals(password.text.toString()))
            {
                Toast.makeText(context, "Please correct password & confirmation", Toast.LENGTH_LONG).show()
            }
            else
            {
                var signupInfos = SignUpForm(
                    firstname.text.toString(),
                    lastname.text.toString(),
                    email.text.toString(),
                    password.text.toString(),
                    password_confirmation.text.toString())

                signup(signupInfos)
            }
        }

        return view
    }

    fun signup(signupForm: SignUpForm): LiveData<TokenResponse?> {

        val tokenData = MutableLiveData<TokenResponse?>()

        coroutineScope.launch {
            var response = loadSignup(signupForm)

            tokenData.postValue(response)
        }

        return tokenData
    }

    suspend fun loadSignup(signUpForm: SignUpForm): TokenResponse? {

        lateinit var tokenResponse: Response<TokenResponse>

        try {
            tokenResponse = API.INSTANCE.userService.signup(signUpForm)
        }

        catch(e : Exception){
            Toast.makeText(context, "API error connection", Toast.LENGTH_LONG).show()
            return null
        }

        if(tokenResponse.isSuccessful)
        {
            PreferenceManager.getDefaultSharedPreferences(context).edit {
                putString(SHARED_PREF_TOKEN_KEY, tokenResponse?.body()?.token.toString())
                println(tokenResponse?.body()?.token.toString())
            }
            findNavController().navigate(R.id.action_signUpFragment_to_mainActivity)
            return tokenResponse.body()
        }
        else
        {
            if(tokenResponse.code()==401)
            {
                Toast.makeText(context, "Unauthorized", Toast.LENGTH_LONG).show()
            }
            else if(tokenResponse.code() == 422)
            {
                Toast.makeText(context, "Unprocessable entity (Is your email valid ?)" , Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(context, "Unknown error: code " + tokenResponse.code() + ";" + tokenResponse.message(), Toast.LENGTH_LONG).show()
            }
            return null
        }
    }
}
