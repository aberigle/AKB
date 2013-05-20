package com.aberigle.java.android.keybinder.test;

import com.aberigle.java.android.keybinder.AndroidKeyEvent;
import com.aberigle.java.android.keybinder.Shell;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (Shell.instance.isAdbWorking()) {
			Shell.instance.input(AndroidKeyEvent.KEYCODE_DPAD_RIGHT);
		}

	}
}
