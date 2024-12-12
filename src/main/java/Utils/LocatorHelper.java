package Utils;

public class LocatorHelper {

    public static LocatorTypeEnum getLocatorType(String path)
    {
        if (path.contains("/hierarchy/") || path.contains("//android.view")||path.contains("android.widget"))
        {
            return LocatorTypeEnum.ANDROID_XPATH;
        }
        else if (path.contains("com.atlashxm")|| path.contains("android:id"))
        {
            return LocatorTypeEnum.ANDROID_ID;
        }
        else if (path.contains("//*") || path.contains("/html"))
        {
            return LocatorTypeEnum.WEB_XPATH;
        }
        throw new IllegalArgumentException("Unsupported path pattern: " + path);
    }
}
