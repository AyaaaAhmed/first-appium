package BaseScreen;

import javax.mail.Message;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.support.FindBy;

import actions.UiActions;

public class Calculator 
{
	static UiActions action;
	static float answer;
	public Calculator(UiActions action)
	{
		this.action = action;
	}
	//getting the calcuator buttons
	public static By num1 = By.id("com.miui.calculator:id/btn_1_s");
	public static By num2 = By.id("com.miui.calculator:id/btn_2_s");
	public static By num5 = By.id("com.miui.calculator:id/btn_5_s"); 
	public static By dot = By.id("com.miui.calculator:id/btn_dot_s");
	public static By plus = By.id("com.miui.calculator:id/btn_plus_s");
	public static By equal = By.id("com.miui.calculator:id/btn_equal_s");
	//agree on privacy button
	public static By agreeOnPrivacy = By.id("android:id/button1");
	//to skip minmiz the calculator notification
	public static By screenLayout = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout");
	public static By result = By.id("com.miui.calculator:id/result");
	
	//to calculate 5.2 + 1.2 = 6.4
	public static void sumFloating()
	{
		action.oneClick(agreeOnPrivacy);
		action.oneClick(screenLayout);
		action.waitForDisplay(screenLayout);
		try
		{	//5.2 + 1.2 = 6.4
				action.oneClick(num5);action.oneClick(dot);action.oneClick(num2);
				action.oneClick(plus);
				action.oneClick(num1);action.oneClick(dot);action.oneClick(num2);
				action.oneClick(equal);
		}
		catch (ElementNotVisibleException e)
		{
			System.out.println(e);
		}

		String ans= action.waits(result);
		//result removing the "=" to get the floating number
		ans= ans.substring(1);
		answer = Float.parseFloat(ans);
	}
	public static float getResult()
	{
		return (answer);
	}
}
