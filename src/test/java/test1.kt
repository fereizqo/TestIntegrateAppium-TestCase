import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.ios.IOSElement
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test
import java.net.MalformedURLException
import java.net.URL
import java.util.concurrent.TimeUnit


@Test
class AppiumiOSLocalStorage {
    @BeforeSuite
    @Throws(MalformedURLException::class)
    fun setupAppium() {
        //2
        val URL_STRING = "http://127.0.0.1:4723/wd/hub"
        url = URL(URL_STRING)

        //3
        capabilities = DesiredCapabilities()
        capabilities?.setCapability(MobileCapabilityType.DEVICE_NAME, "appiumTest-67851D55-0B03-4BD1-83D4-70944967E2C9-iPhone X")
        capabilities?.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS")
        capabilities?.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.5")
        capabilities?.setCapability(MobileCapabilityType.APP, "/Users/fereizqosulaiman/Library/Developer/Xcode/DerivedData/TestIntegrateAppium-adjmhysxjrldcnfsbjjtsvhokjhm/Build/Products/Debug-iphonesimulator/TestIntegrateAppium.app")
        capabilities?.setCapability(MobileCapabilityType.NO_RESET, true)
        capabilities?.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest")
        capabilities?.setCapability("useNewWDA", false)
        //4
        driver = IOSDriver<IOSElement>(url, capabilities)
        driver?.manage()?.timeouts()?.implicitlyWait(2, TimeUnit.SECONDS)
        driver?.resetApp()
    }

    @AfterSuite
    @Throws(InterruptedException::class)
    fun uninstallApp() {
        driver?.resetApp()
        driver?.removeApp("com.example.testapplication")
    }

    @Test
    fun sampleTest() {
        driver?.findElementByAccessibilityId("labelTest")
    }

    companion object {
        var url: URL? = null
        var capabilities: DesiredCapabilities? = null
        var driver: IOSDriver<IOSElement>? = null
    }
}