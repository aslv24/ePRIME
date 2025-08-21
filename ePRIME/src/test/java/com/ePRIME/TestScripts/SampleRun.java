package com.ePRIME.TestScripts;

import org.testng.annotations.Test;

import com.ePRIME.TestBase.BaseClass;

public class SampleRun extends BaseClass{

	@Test
	public void testRun()
	{
		createDriver("uc");
	}
}
