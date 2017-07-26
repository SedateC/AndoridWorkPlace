package com.database.sedatec.databasetest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class DatabaseProvider extends ContentProvider {
    public static final int BOOK_DIR = 0;
    public static final int BOOK_ITEM = 1;
    public static final int CATEGORY_DIR = 2;
    public static final int CATEGORY_ITEM = 3;
    public static final String AUTHORITY="com.example.database.provider";//这里和OTHER创建的一样
    private static UriMatcher uriMatcher;
    private MydatabaseHelper mydatabaseHelper;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,"book",BOOK_DIR);
        uriMatcher.addURI(AUTHORITY,"book/#",BOOK_ITEM);
        uriMatcher.addURI(AUTHORITY,"category",CATEGORY_DIR);
        uriMatcher.addURI(AUTHORITY,"category/#",CATEGORY_ITEM);
    }

    @Override
    public boolean onCreate() {
        mydatabaseHelper = new MydatabaseHelper(getContext(),"BookStore.db",null,2);
        return true;
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = mydatabaseHelper.getReadableDatabase();
        Cursor cursor = null;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                cursor = db.query("Book",projection,selection,selectionArgs,null,null,sortOrder);
            break;
            case BOOK_ITEM:
                String bookid = uri.getPathSegments().get(1);
                cursor = db.query("Book",projection,"id=?",new String[]{bookid},null,null,sortOrder);
                break;
            case CATEGORY_DIR:
                cursor = db.query("Category",projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case CATEGORY_ITEM:
                String categoryid = uri.getPathSegments().get(1);
                cursor = db.query("Category",projection,"id=?",new String[]{categoryid},null,null,sortOrder);
                break;
            default:
                break;
        }
            return cursor;
    }


    public DatabaseProvider() {

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = mydatabaseHelper.getWritableDatabase();
        int deleteRows =0;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                deleteRows  = db.delete("Book",selection,selectionArgs);
                break;
            case BOOK_ITEM:
                String bookid = uri.getPathSegments().get(1);
                deleteRows = db.delete("Book","id=?",new String[]{bookid});
                break;
            case CATEGORY_DIR:
                deleteRows  = db.delete("Category",selection,selectionArgs);
                break;
            case CATEGORY_ITEM:
                String categoryid = uri.getPathSegments().get(1);
                deleteRows  = db.delete("Category","id=?",new String[]{categoryid});
                break;
            default:
                break;

        }
            return  deleteRows;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                return "vnd.android.cursor.dir/com.example.database.provider.book";
            case BOOK_ITEM:
                return "vnd.android.cursor.item/com.example.database.provider.book";
            case CATEGORY_DIR:
                return "vnd.android.cursor.dir/com.example.database.provider.category";
            case CATEGORY_ITEM:
                return "vnd.android.cursor.item/com.example.database.provider.category";
            default:
                break;
        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = mydatabaseHelper.getWritableDatabase();
        Uri uriReturn =null;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
            case BOOK_ITEM:
                long newBookid = db.insert("Book",null,values);
                uriReturn = Uri.parse("content://"+AUTHORITY+"/book/"+newBookid);
            case CATEGORY_DIR:
            case CATEGORY_ITEM:
                long newCategoryid = db.insert("Category",null,values);
                uriReturn = Uri.parse("content://"+AUTHORITY+"/category/"+newCategoryid);
                break;
            default:
                break;
        }
    return uriReturn;
    }




    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        SQLiteDatabase database  = mydatabaseHelper.getWritableDatabase();
        int updatedRows = 0;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                updatedRows = database.update("Book",values,selection,selectionArgs);
                break;
            case BOOK_ITEM:
                String bookid = uri.getPathSegments().get(1);
                updatedRows = database.update("Book",values,"id=?",new String[]{bookid});
                break;
            case CATEGORY_DIR:
                updatedRows = database.update("Category",values,selection,selectionArgs);
                break;
            case CATEGORY_ITEM:
                String categoryid = uri.getPathSegments().get(1);
                updatedRows = database.update("Category",values,"id=?",new String[]{categoryid});
                break;
            default:
                break;
        }
        return updatedRows;
    }
}
