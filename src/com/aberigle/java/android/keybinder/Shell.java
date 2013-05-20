package com.aberigle.java.android.keybinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public enum Shell {

	instance;

	private Runtime cmd = Runtime.getRuntime();

	private final String shell = "adb shell ";

	private Shell() {
	}

	public boolean isAdbWorking() {
		try {
			Process p = cmd.exec(shell + "ls");
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null)
				if (!line.equalsIgnoreCase(""))
					return true;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void input(int code) {
		try {
			cmd.exec(shell + "input keyevent " + code);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
