package net.ombre_jin.td2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import net.ombre_jin.td2.databinding.FragmentAuthenticationBinding


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AuthenticationFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AuthenticationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AuthenticationFragment : Fragment() {


    lateinit var databinding:FragmentAuthenticationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        databinding = DataBindingUtil.inflate(inflater, R.layout.fragment_authentication,container, false)
        var auth_view =  databinding.root

        databinding.authSignup.setOnClickListener()
        { findNavController().navigate(R.id.action_authenticationFragment_to_signupFragment) }

        databinding.login.setOnClickListener()
        { findNavController().navigate(R.id.action_authenticationFragment_to_loginFragment) }

        return auth_view
    }
}
