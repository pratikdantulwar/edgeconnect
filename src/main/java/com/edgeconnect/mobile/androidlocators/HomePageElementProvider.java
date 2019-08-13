/**
 *
 */
package com.edgeconnect.mobile.androidlocators;

import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidElementProvider;
import com.taf.core.PageElementProvider;
import com.taf.core.TestContext;

/**
 * @author surendrane
 */
public class HomePageElementProvider extends PageElementProvider {

    AppiumAndroidContext appiumAndroidContext;
    AppiumAndroidElementProvider appiumAndroidElementProvider;

    public HomePageElementProvider(TestContext context) {
        super(context);
        appiumAndroidContext = (AppiumAndroidContext) context;
        appiumAndroidElementProvider = new AppiumAndroidElementProvider(appiumAndroidContext);
    }

    public Object getLoginId() {
        return appiumAndroidElementProvider
                .getElementByID("com.divum.MoneyControl:id/header_user_icon_img");
    }
}