package com.example.sqldemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
private MyDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper=new MyDbHelper(MainActivity.this,"myDedsB",null,2);
        Button button=findViewById(R.id.btn);
        Button button1=findViewById(R.id.add);
        Button button2=findViewById(R.id.update);
        Button button3=findViewById(R.id.delete);
   Button button4=findViewById(R.id.query);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 dbHelper.getWritableDatabase();

            }
        });
    button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SQLiteDatabase db=  dbHelper.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put("name", "The Da Vinci Code");
            values.put("author", "Dan Brown");
            values.put("pages", 454);
            values.put("price",16.9);
            db.insert("Book",null,values);
            values.clear();
            values.put("name", "The Lost Symbol");
            values.put("author", "Dan Brown");
            values.put("pages", 510);
            values.put("price", 19.95);
            db.insert("Book", null, values); // 插入第二条数据
            Toast.makeText(MainActivity.this,"数据插入",Toast.LENGTH_SHORT).show();
        }
    });
    button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("price", 10.99);
         db.update("Book",values,"name=?",new String[]{"The Da Vinci Code"});
            Toast.makeText(MainActivity.this,"更新",Toast.LENGTH_SHORT).show();
        }
    });
button3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        db.delete("Book","page>?",new String[]{"200"});
        Toast.makeText(MainActivity.this,"删除",Toast.LENGTH_SHORT).show();

    }
});
   button4.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           SQLiteDatabase db=dbHelper.getWritableDatabase();
           Cursor cursor=db.query("Book",null,null,null,null,null,null,null);

       }
   });
    }
}
