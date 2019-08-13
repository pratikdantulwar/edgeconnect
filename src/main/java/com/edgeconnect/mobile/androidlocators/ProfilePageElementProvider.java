package com.edgeconnect.mobile.androidlocators;

import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidContext;
import com.edgeconnect.taf.impl.appiumandroid.AppiumAndroidElementProvider;
import com.taf.core.PageElementProvider;
import com.taf.core.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProfilePageElementProvider extends PageElementProvider {
    AppiumAndroidContext appiumAndroidContext;
    AppiumAndroidElementProvider appiumAndroidElementProvider;

    public ProfilePageElementProvider(TestContext context) {
        super(context);
        appiumAndroidContext = (AppiumAndroidContext) context;
        appiumAndroidElementProvider = new AppiumAndroidElementProvider(appiumAndroidContext);
    }

    public Object getMenuIconId() {
        return appiumAndroidElementProvider
                .getElementByID("com.divum.MoneyControl:id/header_menu_icon");
    }

    public Object getMenu(String menuLink) {
        return appiumAndroidElementProvider
                .getElementByXpath(String.format("//android.widget.TextView[@text='%s']", menuLink));
    }

    public Object logOutId() {
        return appiumAndroidElementProvider.getElementByID("com.divum.MoneyControl:id/tvLogout");
    }

    public List<WebElement> getList() {
        return appiumAndroidContext.getDriver().findElements(By.xpath("//*[@resource-id='com.divum.MoneyControl:id/menuName']"));
    }

    public Object getMyProfileId() {
        return appiumAndroidElementProvider.getElementByID("com.divum.MoneyControl:id/tvMyProfile");
    }
    public Object getEmailStatusId(){
        return appiumAndroidElementProvider.getElementByID("com.divum.MoneyControl:id/labelEmailVerifyStatus");
    }
}
