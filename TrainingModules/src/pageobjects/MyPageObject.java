package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="MyPageObject"                                
     , summary=""
     , relativeUrl=""
     , connection="Gmail"
     )             
public class MyPageObject {

	@LinkType()
	@FindBy(xpath = "//a[text()='Gmail']")
	public WebElement gmail;
	@LinkType()
	@FindBy(xpath = "//span[text()='Create an account']")
	public WebElement getGmailCreateAnAccount;
	@LinkType()
	@FindBy(xpath = "//a[text()='Drag and Drop']")
	public WebElement dragAndDrop;
			
}
