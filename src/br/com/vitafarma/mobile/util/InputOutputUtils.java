package br.com.vitafarma.mobile.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class InputOutputUtils {
	public static void imprime(Object obj) {
		System.out.print(obj);
	}

	public static void showAlert(Activity activity, String title, String message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(activity);

		builder.setTitle(title);
		builder.setMessage(message);

		builder.setPositiveButton("OK", new OnClickListener() {
			public void onClick(DialogInterface arg0, int arg1) {
				return;
			}
		});

		builder.show();
	}
}
