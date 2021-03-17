package com.test.news.helpers

object ValidLogin {
    const val username = "user1"
    const val password = "password"
    const val newsText = "News"
}

object InvalidUsername {
    const val username = "user123"
    const val password = "password"
    const val usernameErrorMessage = "Wrong user name"
}

object InvalidPassword {
    const val username = "user1"
    const val password = "password123"
    const val passwordErrorMessage = "Wrong password"
}