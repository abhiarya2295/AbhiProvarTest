package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@SalesforcePage( title="UAT_ Embedded VF Table PB_ SF 1"                                
               , summary=""
               , page="UAT_EmbeddedVFTablePB_SF1"
               , namespacePrefix=""
               , object="Contact"
               , connection="RegressionOrg"
     )             
public class UAT_EmbeddedVFTablePB_SF1 {

	@TextType()
	@FindBy(xpath = "//div[normalize-space(.)='Last Name']")
	public WebElement sortDiv;
	
}
