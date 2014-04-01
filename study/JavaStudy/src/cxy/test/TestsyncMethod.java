package cxy.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestsyncMethod {
	
	public static String getNowDate(){
		Date sysdate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss SSS");
		String strsys =format.format(sysdate);
		return strsys;
	}

	public void iA() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("iA is starting:"+getNowDate());
	}

	public void iB() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("iB is starting:"+getNowDate());
	}

	public synchronized void iSyncA() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("iSyncA is starting:"+getNowDate());
	}

	public synchronized void iSyncB() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("iSyncB is starting:"+getNowDate());
	}
	
	public static void cA() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("class cA is starting:"+getNowDate());
	}

	public static void cB() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("class cB is starting:"+getNowDate());
	}

	public static synchronized void cSyncA() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("class cSyncA is starting:"+getNowDate());
	}

	public static synchronized void cSyncB() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" class cSyncB is starting:"+getNowDate());
	}

}
