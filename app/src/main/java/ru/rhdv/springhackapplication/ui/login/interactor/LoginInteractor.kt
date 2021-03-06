package ru.rhdv.springhackapplication.ui.login.interactor

import io.reactivex.Observable
import ru.rhdv.springhackapplication.data.network.ApiHelper
import ru.rhdv.springhackapplication.data.network.response.LoginResponse
import ru.rhdv.springhackapplication.data.preferences.PreferencesHelper
import ru.rhdv.springhackapplication.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class LoginInteractor @Inject constructor(preferencesHelper: PreferencesHelper, apiHelper: ApiHelper):
        BaseInteractor(preferencesHelper = preferencesHelper, apiHelper = apiHelper), LoginMvpInteractor {

    override fun doServerLogin(login: String, password: String): Observable<LoginResponse> {
        return apiHelper.doUserLogin(login = login, password = password)
    }

    override fun saveAccessToken(accessToken: String?) = preferencesHelper.setAccessTokenFromServer(accessToken = accessToken)

}