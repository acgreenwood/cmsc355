<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_app_settings"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="sean.itr1.AppSettings">

    <TextView
        android:text="@string/settings"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:id="@+id/settings_title"
        android:textAppearance="@style/TextAppearance.AppCompat.Large" />

    <Button
        android:text="@string/appearance_button"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:id="@+id/appearance_button"
        android:onClick="onClick"
        android:layout_below="@+id/notifications_button"
        android:layout_alignStart="@+id/notifications_button" />

    <Button
        android:text="@string/notification_button"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:id="@+id/notifications_button"
        android:onClick="onClick"
        android:layout_below="@+id/my_archive_settings"
        android:layout_alignStart="@+id/my_archive_settings" />

    <Button
        android:text="@string/go_to_my_profile"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:layout_below="@+id/appearance_button"
        android:layout_centerHorizontal="true"
        android:id="@+id/my_profile_button"
        android:onClick="onClick" />

    <Button
        android:text="@string/return_to_home_page"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:layout_below="@+id/my_profile_button"
        android:layout_centerHorizontal="true"
        android:id="@+id/return_to_home_page"
        android:onClick="onClick" />

    <Button
        android:text="@string/my_archive_settings"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:id="@+id/my_archive_settings"
        android:onClick="onClick"
        android:layout_marginTop="106dp"
        android:layout_below="@+id/settings_title"
        android:layout_alignStart="@+id/my_profile_button" />
</RelativeLayout>
