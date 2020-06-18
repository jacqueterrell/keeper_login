package com.technologies.zenlight.keeperlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.technologies.zenlight.keeperlogin.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityCallbacks {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.callbacks = this
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
    }

    override fun onLoginClicked() {
        val email = et_email.text.toString()
        val password = et_password.text.toString()
        if (viewModel.isCredentialsValid(email,password)) {
            Toast.makeText(this, "Logging In", Toast.LENGTH_SHORT).show()
        } else {
            val errorMsg = viewModel.getErrorMsg()
            Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNoAccountClicked() {}
    override fun onNeedHelpClicked() {}
    override fun onEnterpriseLoginClicked() {}
}
