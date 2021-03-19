/*
 * author: Garrett
 * date: 3/19/2021
 * project: InstagramClone
 * description:
 */

package com.garrett.instagramclone;

import com.parse.Parse;
import android.app.Application;

public class ParseApplication extends Application {
    @Override
    public void onCreate () {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("i3wG71Iuj45K8zi9HWbSmLG0SsotUfarnKflTqjT")
                .clientKey("vZkqWFW628Brthk9XQaJB8Ay3Xc91tqXPx2L0WEO")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
