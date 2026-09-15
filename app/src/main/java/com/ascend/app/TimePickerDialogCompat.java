package com.ascend.app;
import android.app.TimePickerDialog;
import android.content.Context;
public final class TimePickerDialogCompat {
 public interface Callback { void onTime(int hour,int minute); }
 public static void show(Context c,int h,int m,Callback cb){new TimePickerDialog(c,(v,hh,mm)->cb.onTime(hh,mm),h,m,false).show();}
}
