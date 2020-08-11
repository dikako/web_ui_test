package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Attachment;

public class TakeScreenshot {

	@Attachment
	public static byte[] captureScreenshot(WebDriver driver, String screenshotName) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
}
//	public static void captureScreenshot(WebDriver driver, String screenshotName) {
//		try {
//			TakesScreenshot ts = (TakesScreenshot) driver;
//			File source = ts.getScreenshotAs(OutputType.FILE);
//			System.out.println(source.getPath());
//			File filename = new File("../pwa_ui_test/Screenshots/" + screenshotName + ".png");
//			System.out.println(filename);
//			FileUtils.copyFile(source, filename);
//			System.out.println("Screenshot Taken");
//		} catch (Exception e) {
//			System.out.println("Exception whiletaking screenshoot: " + e.getMessage());
//		}
//	}
//}
