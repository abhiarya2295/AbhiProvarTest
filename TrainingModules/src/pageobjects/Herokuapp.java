package pageobjects;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.provar.core.testapi.annotations.*;

@Page( title="Herokuapp"                                
     , summary=""
     , relativeUrl=""
     , connection="Herokuapp"
     )             
public class Herokuapp {
    
    @TestLogger
    public Logger testLogger;
     
    WebDriver driver;
    
    public Herokuapp(WebDriver driver){
    
    this.driver=driver;
    
    }
     	    
    public void click1(String text){
		driver.findElement(By.xpath("//div[@id='content']//a[text()='"+text+"']")).click();
	}
	
	public String readPText(){	
	    return driver.findElement(By.xpath("//div[@id='content']//div[@class='example']/p")).getText();    
	}
	
	public String readHText(){	
	    return driver.findElement(By.xpath("//div[@id='content']//div[@class='example']/h3")).getText();    
	}
	
	public void add_remove(){
	    driver.navigate().back();
	    driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();
	}
	
	public void click_button(){
	    
	    driver.findElement(By.xpath("//div[@id='content']//div[@class='example']/button")).click();
	}
	
	public Boolean check_button(){
	  
	  Boolean display = driver.findElement(By.xpath("//div[@id='content']//div[@class='example']/div[@id='elements']/button")).isDisplayed();
      return display;
	}
	
	public int check_button_after_click(){
	  
	   driver.findElement(By.xpath("//div[@id='content']//div[@class='example']/div[@id='elements']/button")).click();
	   List<WebElement> dynamicElement = driver.findElements(By.xpath("//div[@id='content']//div[@class='example']/div[@id='elements']/button"));      
       return dynamicElement.size();     
	} 
	
	public String challenging_dOM(){
	    driver.navigate().back();
	    driver.findElement(By.xpath("//div[@id='content']//a[text()='Challenging DOM']")).click();
	    driver.findElement(By.xpath("//div[contains(@class,'large-2')]//a[@class='button']")).click();
	    String answer = new String();
    
	    ArrayList<WebElement>scripts = new ArrayList<WebElement>((ArrayList<WebElement>) driver.findElements(By.tagName("script")));
	    
	    for(int i = 0; i < scripts.size(); i++) {
	        
	        String focusText = scripts.get(i).getAttribute("innerHTML");
	        
	        if(focusText.contains("canvas.strokeText")) {
	
	                answer = focusText.substring(focusText.indexOf("Answer"), focusText.indexOf("',"));
	                
	                break;
	                
	        }
	    }
	    return answer;
	}
	
	public boolean checkbox(){
	    driver.navigate().back();
	    driver.findElement(By.xpath("//div[@id='content']//a[text()='Checkboxes']")).click();
        WebElement e = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).click();
        e.click();
        return e.isSelected();
	}
	
	public void context_menu(){
	    driver.navigate().back();
	    Actions action = new Actions(driver);
	    driver.findElement(By.xpath("//div[@id='content']//a[text()='Context Menu']")).click();
	    WebElement rightClickElement=driver.findElement(By.xpath("//div[@id='hot-spot']"));
	    action.contextClick(rightClickElement).build().perform();
	    driver.switchTo().alert().dismiss();	    
	}
	
	public void disappearing(){
	    driver.navigate().back();
	    driver.findElement(By.xpath("//div[@id='content']//a[text()='Disappearing Elements']")).click();	    
	   // JavascriptExecutor js = (JavascriptExecutor)driver;
	    WebElement ele = driver.findElement(By.xpath("//div[@id='content']//a[text()='Home']"));	    
	  
	    Actions action = new Actions(driver);
        action.moveToElement(ele).perform();
	}
	
	public void dragAndDrop(){
	   // driver.navigate().back();
	    driver.findElement(By.xpath("//div[@id='content']//a[text()='Drag and Drop']")).click();	    
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript( 
                            "var dt = new DataTransfer();"
						  +	"var drop = new DragEvent('drop', { dataTransfer: dt });"
						  +	"var dragStart = new DragEvent('dragstart', { dataTransfer: dt });"
						  + "var dragEnd = new DragEvent('dragend', { dataTransfer: dt });"
						  + "var dragEnter = new DragEvent('dragenter', { dataTransfer: dt });"
						  + "var dragLeave = new DragEvent('dragleave', { dataTransfer: dt });"
						  + "var dragOver = new DragEvent('dragover', { dataTransfer: dt });"
						  +	"var startElem = document.querySelector('#column-a');"
					      +	"var endElem = document.querySelector('#column-b');"
					      +	"startElem.dispatchEvent(dragEnter);"
						  +	"startElem.dispatchEvent(dragStart);"
						  + "startElem.dispatchEvent(dragLeave);"
                          + "endElem.dispatchEvent(dragOver);"	
                          + "endElem.dispatchEvent(drop);"					
						  +	"startElem.dispatchEvent(dragEnd);"
						  +	"endElem.dispatchEvent(dragEnd);"
	                 ); 
	}
	
	public void dropDown(){
	    driver.navigate().back();
	    driver.findElement(By.xpath("//div[@id='content']//a[text()='Dropdown']")).click();	    
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript(
	    					"var options = document.querySelector('#dropdown');"
						 +  "for (var i = 0; i < options .length; i++) {"
						 +	     " options [i].removeAttribute('selected');"
						 +	    "}"
						 +	"var e = new Event('change');"
						 +	"$('select#dropdown option:eq(2)').attr('selected', 'selected');"
	    				);
	}
	
	public List<String> dynamic_content(){
	    driver.navigate().back();
	    List<String> list = new ArrayList<String>();
	    driver.findElement(By.xpath("//div[@id='content']//a[text()='Dynamic Content']")).click();	
	    list.add(driver.findElement(By.xpath("//div[@id='content']//div[@class='large-10 columns']")).getText());
	    driver.findElement(By.xpath("//div[@id='content']//a")).click();
	    list.add(driver.findElement(By.xpath("//div[@id='content']//div[@class='large-10 columns']")).getText());
	    return list;
    }
    
    public void dynamic_control(){
	    driver.navigate().back();
	    driver.findElement(By.xpath("//div[@id='content']//a[text()='Dynamic Controls']")).click();	 
	    driver.findElement(By.xpath("//div[@id='checkbox']//input")).click();
	    driver.findElement(By.xpath("//div[@id='checkbox']//following-sibling::button")).click();
	    driver.findElement(By.xpath("//form[@id='checkbox-example']//button[text()='Add']")).click();
	    driver.findElement(By.xpath("//form[@id='input-example']//button")).click();
	    driver.findElement(By.xpath("//form//button[text()='Add']")).click();	    
	}
	
	public void dropDownUsingSel(){
	    //driver.navigate().back();
	    driver.findElement(By.xpath("//div[@id='content']//a[text()='Dropdown']")).click();
	    Select d = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
	    d.selectByValue("1");
	    	    
	}
	
	public void dragAndDropUsingSel(){
	   // driver.navigate().back();
	    driver.findElement(By.xpath("//div[@id='content']//a[text()='Drag and Drop']")).click();	    
	    WebElement source= driver.findElement(By.xpath("//div[@id='columns']//div[@id='column-a']"));
        WebElement target= driver.findElement(By.xpath("//div[@id='columns']//div[@id='column-b']"));
        Actions action = new Actions(driver);
        action.clickAndHold(source).build().perform();
        action.moveToElement(target).build().perform();
        action.release(target).build().perform();
	}  
	
	public void EntryAd(){
	
	    driver.navigate().back();
	    driver.findElement(By.xpath("//div[@id='content']//a[text()='Entry Ad']")).click();
	    driver.switchTo().defaultContent(); 	    
	    driver.findElement(By.xpath("//a[@id='restart-ad']")).click();	 
	    driver.switchTo().defaultContent();               
	}  
	
	public void exit_intent(){
	
	    driver.navigate().back();
	    driver.findElement(By.xpath("//div[@id='content']//a[text()='Exit Intent']")).click();
	    //driver.switchTo().defaultContent();
	}
	
	public void file_download(){
	
	    driver.navigate().back();
	    driver.findElement(By.xpath("//div[@id='content']//a[text()='File Download']")).click();
	    driver.findElement(By.xpath("//div[@class='example']//a[text()='5mb script.xml']")).click();
	}
	
	public void file_upload(){
	
	    driver.navigate().back();
	    driver.findElement(By.xpath("//div[@id='content']//a[text()='File Upload']")).click();
	    WebElement browse = driver.findElement(By.xpath("//form//input[@id='file-upload']"));
	    File file = new File("C:\\Users\\ajay.kushwaha\\Downloads\\record.csv");
	    if(file.exists()) 
	    browse.sendKeys("C:\\Users\\ajay.kushwaha\\Downloads\\record.csv");
	    else 
	    testLogger.warning("File does not Exist");	        
	}
	 
	public void forget_password(){
	
	    driver.navigate().back();
	    driver.findElement(By.xpath("//div[@id='content']//a[text()='Forgot Password']")).click();
	    driver.findElement(By.xpath("//div[contains(@class,'large-6 small')]//input")).sendKeys("Value");
	} 
	
	public void horiZontal_slider(){
	
	    driver.navigate().back();
	    driver.findElement(By.xpath("//div[@id='content']//a[text()='Horizontal Slider']")).click();
      //  WebElement slider = driver.findElement(By.xpath("//div[@id='content']//div[@class='sliderContainer']/input"));
        JavascriptExecutor js = (JavascriptExecutor)driver; 
        js.executeScript("document.getElementById('gvLocationHorizontalRail')");
//        Actions move = new Actions(driver);
//        move.dragAndDropBy(slider,2,0).perform();
	}  
	
	public void hover(){
	
	    driver.navigate().back();
	    driver.findElement(By.xpath("//div[@id='content']//a[text()='Hovers']")).click();
        WebElement ele = driver.findElement(By.xpath("//div[@id='content']//img"));
        Actions action = new Actions(driver);
        action.moveToElement(ele).perform();
        driver.navigate().back();
        driver.findElement(By.xpath("//div[@id='content']//a[text()='Infinite Scroll']")).click();
    }
    
    public void infinite_scroll(){
	    
	    driver.navigate().back();
        driver.findElement(By.xpath("//div[@id='content']//a[text()='Infinite Scroll']")).click();
	    driver.navigate();
        JavascriptExecutor js = (JavascriptExecutor)driver;
    
         js.executeScript("window.scrollBy(0,600)");
    }
    
    public void js_alert(){
	    
	    driver.navigate().back();
        driver.findElement(By.xpath("//div[@id='content']//a[text()='JavaScript Alerts']")).click();
	    driver.findElement(By.xpath("//div[@id='content']//div[@class='example']/ul/li[1]/button")).click();
	    driver.switchTo().alert().dismiss();
	    driver.findElement(By.xpath("//div[@id='content']//div[@class='example']/ul/li[2]/button")).click();
	    driver.switchTo().alert().accept();
	    driver.findElement(By.xpath("//div[@id='content']//div[@class='example']/ul/li[3]/button")).click();
	    
	    Alert alert = driver.switchTo().alert();
	    alert.sendKeys("Text");
	    alert.accept();
	}
    
    public void press_key(){
	    
	    driver.navigate().back();
        driver.findElement(By.xpath("//div[@id='content']//a[text()='Key Presses']")).click();
        
        WebElement textbox = driver.findElement(By.xpath("//input[@id='target']"));
        textbox.sendKeys(Keys.SPACE);
	}
	
	public void multipleWindow(String a) {
        
        driver.navigate().back();
        driver.findElement(By.xpath("//div[@id='content']//a[text()='Multiple Windows']")).click();
        driver.findElement(By.xpath("//div[@class='example']/a")).click();
        
		Set<String> allhandles = driver.getWindowHandles();
		Iterator<String> I1 = allhandles.iterator();
		String title = driver.getTitle();
	    //testLogger.warning("First Title");
		//testLogger.warning(title);
		while (I1.hasNext()) {
			String child_window = I1.next();
			driver.switchTo().window(child_window);
			title = driver.getTitle();
			testLogger.warning("Second Title");
			testLogger.warning(title);
			if(!title.contains(a)){
				driver.close();
			}
			
		}
		//driver.switchTo().defaultContent();
	}
	
	public void pop_up_Entry() {
        
        driver.navigate().back();
        driver.findElement(By.xpath("//div[@id='content']//a[text()='Secure File Download']")).click();
        //Alert alert = driver.switchTo().alert();
       // alert.SetAuthenticationCredentials("username", "password");
       String u = "admin";
      // adding username, password with URL
      String str = "https://" + u + ":" + u + "@" +
      "the-internet.herokuapp.com/download_secure";
      driver.get(str);
    } 
    
    public String shadow_dom(){
    
        driver.navigate().back();
        driver.findElement(By.xpath("//div[@id='content']//a[text()='Shadow DOM']")).click();
        return driver.findElement(By.xpath("//div[@id='content']//span[@slot='my-text']")).getText().toString();
    }
    
    public void sortable_data_table(){
    
        driver.navigate().back();
        driver.findElement(By.xpath("//div[@id='content']//a[text()='Sortable Data Tables']")).click();
        driver.findElement(By.xpath("//th/span[text()='First Name']")).click();
    }
    
     public List<String> typos(){
        
        List<String> list = new ArrayList<String>();
        driver.navigate().back();
        driver.findElement(By.xpath("//div[@id='content']//a[text()='Typos']")).click();
        list.add(driver.findElement(By.xpath("//div[@class='example']//p[contains(text(),'Sometimes')]")).getText().toString());
        driver.navigate().refresh();
        list.add(driver.findElement(By.xpath("//div[@class='example']//p[contains(text(),'Sometimes')]")).getText().toString()); 
        return list;
    }
    
    public void UI_event(){
      
      driver.navigate().back();
      driver.findElement(By.xpath("//div[@id='content']//a[text()='JQuery UI Menus']")).click();
      WebElement ele = driver.findElement(By.xpath("//li[@id='ui-id-3']/a[text()='Enabled']"));
      
        Actions action = new Actions(driver);
        action.moveToElement(ele); 
      
       WebElement ele1 = driver.findElement(By.xpath("//li[@id='ui-id-8']/a[contains(text(),'Back')]"));    
       //action.moveToElement(driver.findElement(By.xpath("//li[@id='ui-id-8']/a[contains(text(),'Back')]")));
       testLogger.warning("Hello" + ele1.getText());
     
                //ele1.click();
        
//      JavascriptExecutor js = (JavascriptExecutor)driver;
//    
//      js.executeScript("document.querySelector('#ui-id-8 > a').click()");  
//      driver.navigate().back();
//      js.executeScript("document.querySelector('#ui-id-5 > a').click()"); 
    }
    
    public void input_no(){
          
      driver.findElement(By.xpath("//div[@id='content']//a[text()='Inputs']")).click();
      driver.findElement(By.xpath("//input")).sendKeys("4342");
    }
    
    public void editor(){
      
      driver.navigate().back();      
      driver.findElement(By.xpath("//div[@id='content']//a[text()='WYSIWYG Editor']")).click();
      JavascriptExecutor js = (JavascriptExecutor)driver;
  //    js.executeScript("document.querySelector('div.tox-edit-area').querySelector('iframe').contentDocument.querySelector('body > p').innerText = 'Good '");  
      driver.findElement(By.xpath("//div[@role='menubar']//button/span[text()='File']")).click();
      driver.findElement(By.xpath("//div[@title='New document']")).click();
      js.executeScript("document.querySelector('div.tox-edit-area').querySelector('iframe').contentDocument.querySelector('body > p').innerText = 'Good '");
      driver.findElement(By.xpath("//div[@title='styles']/button")).click();
      driver.findElement(By.xpath("//div[@title='Headings']/div[text()='Headings']")).click();
      driver.findElement(By.xpath("//div[@title='Heading 1']/div/h1")).click();
   }
   
   public void iframe(){
      
      driver.navigate().back();      
      driver.findElement(By.xpath("//div[@id='content']//a[text()='Nested Frames']")).click();
//      JavascriptExecutor js = (JavascriptExecutor)driver;
//      String str = (String) js.executeScript("return document.querySelector('html > frameset > frame').contentDocument.querySelector('frame[name=frame-right]').contentDocument.querySelector('body').textContent");
//      testLogger.warning(str);
      driver.switchTo().frame("frame-top");
      driver.switchTo().frame("frame-left");
      String str = driver.findElement(By.xpath("//body")).getText();
        testLogger.warning(str);
      driver.switchTo().parentFrame();
      driver.switchTo().frame("frame-right");
      String str1 = driver.findElement(By.xpath("//body")).getText();
        testLogger.warning(str1);
      driver.switchTo().defaultContent();
      driver.switchTo().frame("frame-bottom");
      String str2 = driver.findElement(By.xpath("//body")).getText();
        testLogger.warning(str2);
   }  
   
   public void mouse_event(){
      
       JavascriptExecutor js = (JavascriptExecutor)driver;
       js.executeScript(                       
                          "var e = new MouseEvent('focus');"
                         +"document.querySelectorAll('div.uiMenu')[1].querySelector('div > div > a').dispatchEvent(e);"
                        );
   }       				
}