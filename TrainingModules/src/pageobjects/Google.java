package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="Google"                                
     , summary=""
     , relativeUrl=""
     , connection="Gmail"
     )             
public class Google {

	@LinkType()
	@FindBy(xpath = "//a[text()='Gmail']")
	public WebElement gmail;
			
}
