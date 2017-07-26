package com.database.sedatec.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.LitePalDB;
import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.sql.Connection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button create = (Button)findViewById(R.id.create_Button);
        Button addbook = (Button)findViewById(R.id.addbook_Button);
        Button selectButton = (Button)findViewById(R.id.select_Button);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
                Toast.makeText(MainActivity.this, "success create", Toast.LENGTH_SHORT).show();
            }
        });

        addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book =  new Book();
                book.setName("the book code");
                book.setAuthor("Author");
                book.setId(1);
                book.setPages(500);
                book.setPress("press");
                book.setPrice(39.5);
                book.save();
                Toast.makeText(MainActivity.this, "save!!!", Toast.LENGTH_SHORT).show();
            }
        });
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = DataSupport.findAll(Book.class);
                for (Book book:books) {
                    Log.d("message", book.toString());
                }
            }
        });
    }
}
//07-23 15:45:06.858 7017-7017/? E/SQLiteDatabase: Failed to open database '
// /storage/emulated/0/Android/data/com.database.sedatec.litepaltest/files/databases/BookStore.db'.