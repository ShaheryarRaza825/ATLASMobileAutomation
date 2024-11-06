package Utils;

public class LocatorHelper {

    public static LocatorType getLocatorType(String path)
    {
        if (path.contains("/hierarchy/") || path.contains("//android.view"))
        {
            return LocatorType.ANDROID_XPATH;
        }
        else if (path.contains("com.atlashxm")|| path.contains("android:id"))
        {
            return LocatorType.ANDROID_ID;
        }
        else if (path.contains("//*") || path.contains("/html"))
        {
            return LocatorType.WEB_XPATH;
        }
        throw new IllegalArgumentException("Unsupported path pattern: " + path);
    }
}
