package com.appdynamicsffi.sample2;

import com.appdynamics.eumagent.runtime.AgentConfiguration;
import com.appdynamics.eumagent.runtime.Instrumentation;
import com.konylabs.android.KonyMain;


public class AppDynamics {
	
	public static void initWithAppKey(String appKey) {
		System.out.println("android app dynamics initWithAppKey");
		System.out.println("KonyMain.getAppContext() : " + KonyMain.getAppContext());
		System.out.println("KonyMain.getActivityContext() : " + KonyMain.getActivityContext());
		
		int stringId = KonyMain.getActivityContext().getApplicationInfo().labelRes;
		System.out.println("stringId : " + stringId);
		System.out.println("KonyMain.getActivityContext().getString(stringId) : " + KonyMain.getActivityContext().getString(stringId));
		System.out.println("V2");
	//	Instrumentation.start(appKey, KonyMain.getAppContext(), true);
	Instrumentation.start(AgentConfiguration.builder().withAppKey(appKey) 
					.withContext(KonyMain.getAppContext()) 
				.withCompileTimeInstrumentationCheck(false) .withLoggingEnabled(true) .build());
	}
	
	public static void reportMetricWithName(String metricName, long count){
		System.out.println("android app dynamics reportMetricWithName: " + metricName + " count : " + count);
		Instrumentation.reportMetric(metricName, count);
	}
	
	public static void startTimerWithName(String timerName){
		System.out.println("android app dynamics startTimerWithName: " + timerName);
		Instrumentation.startTimer(timerName);
	}
	
	public static void stopTimerWithName(String timerName){
		System.out.println("android app dynamics stopTimerWithName: " + timerName);
		Instrumentation.stopTimer(timerName);
		
	}
	
	public static void setUserData(String key, String value, boolean persist){
		System.out.println("android app dynamics setUserData key : " + key + " value : " + value + " persist:" + persist);
		Instrumentation.setUserData(key, value, persist); 
	}
	
	public static void takeScreenshot(){
		System.out.println("android app dynamics screenshot");
		Instrumentation.takeScreenshot(); 
	}
	
}
