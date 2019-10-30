package bonch.dev.school.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import bonch.dev.school.R

class ProfileFragment : Fragment() {

    lateinit var changePasswordButton: Button
    lateinit var passwordFragment: PasswordFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_profile, container,false)
        initializeView(view)
        setListener()
        return view
    }

    private fun initializeView(view: View) {
        changePasswordButton = view.findViewById(R.id.change_password_button)
        passwordFragment = PasswordFragment()

    }

    private fun setListener(){
        changePasswordButton.setOnClickListener {
            passwordFragment.show(
                fragmentManager!!,
                "passwordFragment"
            )
        }
    }

}
