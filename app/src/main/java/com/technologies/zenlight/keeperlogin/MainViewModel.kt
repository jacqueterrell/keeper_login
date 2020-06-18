package com.technologies.zenlight.keeperlogin

import android.util.Patterns
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    /******* Getters and Setters ********/

    var callbacks: MainActivityCallbacks? = null
    var isEmailValid = false
    var isPasswordValid = false


    /******* OnClick Listeners ********/

    fun onLoginClicked() = callbacks!!.onLoginClicked()
    fun onNoAccountClicked() = callbacks!!.onNoAccountClicked()
    fun onNeedHelpClicked() = callbacks!!.onNeedHelpClicked()
    fun onEnterpriseLoginClicked() = callbacks!!.onEnterpriseLoginClicked()

    /******* Business Logic ********/

    fun isCredentialsValid(email: String, password: String) : Boolean {
        isEmailValid = email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        isPasswordValid = password.length > 5
        return isEmailValid && isPasswordValid
    }

    fun getErrorMsg(): String {
        return if (!isEmailValid && !isPasswordValid) {
            "Please enter a valid email and password"
        } else if (!isEmailValid) {
            "Please enter a valid email"
        } else {
            "Please enter a valid password"
        }
    }
}