package icell.hu.testdemo.network.listener;

import icell.hu.testdemo.model.UserInfo;

/**
 * Created by ilaszlo on 27/09/16.
 */
public interface LoginListener extends ErrorListener {

    void loginFinished(UserInfo userInfo);


}
