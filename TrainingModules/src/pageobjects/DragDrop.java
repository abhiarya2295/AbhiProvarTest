package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page(title = "DragDrop", summary = "", relativeUrl = "", connection = "Herokuapp")
public class DragDrop {
	WebDriver driver;

	public DragDrop(WebDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	@TextType()
	@FindBy(xpath = "//div[@id='column-a']")
	public WebElement A;

	@TextType()
	@FindBy(xpath = "//div[@id='column-b']")
	public WebElement B;

}

	public void Dra
	   
