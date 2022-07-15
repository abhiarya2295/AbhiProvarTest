package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@SalesforcePage( title="Angular_ Inside_ VF"                                
               , summary=""
               , page="Angular_Inside_VF"
               , namespacePrefix=""
               , object="Contact"
               , connection="RegressionOrg"
     )             
public class Angular_Inside_VF {

	@TextType()
	@FindBy(xpath = "//input[@id='FNAME']")
	public WebElement firstName;
	@TextType()
	@FindBy(xpath = "//input[@id='LNAME']")
	public WebElement lastName;
	@TextType()
	@FindBy(xpath = "//input[@id='MOBILE']")
	public WebElement mobilePhone;
	@TextType()
	@FindBy(xpath = "//input[@id='EMAIL']")
	public WebElement email;
	@TextType()
	@FindBy(xpath = "//textarea[@id='MOBILEDESC']")
	public WebElement mobileDescription;
	@ButtonType()
	@FindBy(xpath = "//form[@name='myForm']/input")
	public WebElement save;
	
}
