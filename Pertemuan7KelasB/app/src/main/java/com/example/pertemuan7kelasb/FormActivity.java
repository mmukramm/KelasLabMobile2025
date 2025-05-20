package com.example.pertemuan7kelasb;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pertemuan7kelasb.database.DatabaseContract;
import com.example.pertemuan7kelasb.database.StudentHelper;

public class FormActivity extends AppCompatActivity {

    public static final String EXTRA_STUDENT = "extra_student";
    public static final int RESULT_ADD = 101;
    public static final int RESULT_UPDATE = 201;
    public static final int RESULT_DELETE = 301;
    public static final int REQUEST_UPDATE = 200;


    private EditText etName, etNim;

    private Button btnSave, btnDelete;

    private StudentHelper studentHelper;
    private Boolean isEdit = false;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etName = findViewById(R.id.et_name);
        etNim = findViewById(R.id.et_nim);
        btnDelete = findViewById(R.id.btn_delete);
        btnSave = findViewById(R.id.btn_save);

        studentHelper = StudentHelper.getInstance(getApplicationContext());
        studentHelper.open();

        student = getIntent().getParcelableExtra(EXTRA_STUDENT);

        if (student != null) {
            isEdit = true;
        } else {
            student = new Student();
        }

        String actionBarTitle;
        String buttonTitle;

        if (isEdit) {
            actionBarTitle = "Edit Student";
            buttonTitle = "Update";

            if (student != null) {
                etName.setText(student.getName());
                etNim.setText(student.getNim());
            }

            btnDelete.setVisibility(View.VISIBLE);
        } else {
            actionBarTitle = "Add Student";
            buttonTitle = "Save";
        }

        btnSave.setText(buttonTitle);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(actionBarTitle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnSave.setOnClickListener(view -> saveStudent());
        btnDelete.setOnClickListener(view -> deleteStudent());

    }


    private void saveStudent() {
        String name = etName.getText().toString().trim();
        String nim = etNim.getText().toString().trim();


        if (name.isEmpty()) {
            etName.setError("Please fill this field");
            return;
        }

        if (nim.isEmpty()) {
            etNim.setError("Please fill this field");
            return;
        }

        student.setName(name);
        student.setNim(nim);

        Intent intent = new Intent();
        intent.putExtra(EXTRA_STUDENT, student);

        ContentValues values = new ContentValues();
        values.put(DatabaseContract.StudentColumn.NAME, name);
        values.put(DatabaseContract.StudentColumn.NIM, nim);


        if (isEdit) {
            long result = studentHelper.update(String.valueOf(student.getId()), values);
            if (result > 0) {
                setResult(RESULT_UPDATE, intent);
                finish();
            } else {
                Toast.makeText(this, "Failed to update data", Toast.LENGTH_SHORT).show();
            }
        } else {
            long result = studentHelper.insert(values);
            if (result > 0) {
                student.setId((int) result);
                setResult(RESULT_ADD, intent);
                finish();
            } else {
                Toast.makeText(this, "Failed to add data", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void deleteStudent() {
        if (student != null && student.getId() > 0) {
            long result = studentHelper.deleteById(String.valueOf(student.getId()));
            if (result > 0) {
                setResult(RESULT_DELETE);
                finish();
            } else {
                Toast.makeText(this, "Failed to delete data", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Invalid student data", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (studentHelper != null) {
            studentHelper.close();
        }
    }
}