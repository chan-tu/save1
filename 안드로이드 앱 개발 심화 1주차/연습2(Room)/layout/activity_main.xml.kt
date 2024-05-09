<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout  xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="5dp"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/student_ID_EditText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:hint="@string/ID"
        android:inputType="number"
        android:minHeight="50dp"
        app:layout_constraintEnd_toStartOf="@+id/query_Button"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintHorizontal_chainStyle="spread_inside"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/student_Name_EditText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:hint="@string/Name"
        android:inputType="textPersonName"
        android:minHeight="50dp"
        app:layout_constraintEnd_toStartOf="@+id/student_add_Button"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintHorizontal_chainStyle="spread_inside"
        app:layout_constraintStart_toStartOf="@+id/student_ID_EditText"
        app:layout_constraintTop_toBottomOf="@+id/student_ID_EditText" />

    <Button
        android:id="@+id/student_add_Button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/Add_Student"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toEndOf="@+id/student_Name_EditText"
        app:layout_constraintTop_toBottomOf="@+id/query_Button"/>

    <Button
        android:id="@+id/query_Button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/Query_Student"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toEndOf="@+id/student_ID_EditText"
        app:layout_constraintTop_toTopOf="parent"/>

    <TextView
        android:id="@+id/student_Result_Text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="15dp"
        android:text="@string/Result_of_Query_Student"
        android:textStyle="bold"
        android:textColor="@color/black"
        app:layout_constraintStart_toStartOf="@+id/student_Name_EditText"
        app:layout_constraintTop_toBottomOf="@+id/student_Name_EditText" />

    <TextView
        android:id="@+id/student_List_Text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="25dp"
        android:text="@string/Student_List"
        android:textStyle="bold"
        android:textColor="@color/black"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/student_Query_text"/>

    <TextView
        android:id="@+id/student_Query_text"
        android:layout_width="0dp"
        android:layout_height="100sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/student_Result_Text"/>

    <TextView
        android:id="@+id/student_List_Text2"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginBottom="8dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/student_List_Text"/>

</androidx.constraintlayout.widget.ConstraintLayout >
