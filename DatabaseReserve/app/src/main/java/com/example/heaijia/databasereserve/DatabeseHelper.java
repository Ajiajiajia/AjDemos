package com.example.heaijia.databasereserve;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * @author heaijia
 * @since 2018/4/19 下午9:27
 * email 549044363@qq.com
 */


/**
 *getWritableDatabase()：创建或打开一个可以读写的数据库
 *getReadableDatabase()：创建或打开一个数据库
 */

public class DatabeseHelper extends SQLiteOpenHelper {

    /**
     * 建表
     */
    public static final String CREATE_BOOK="create table Book("
        + "id integer primary key autoincrement, "
        + "anthor text, "
        + "price real, "
        + "pages integer, "
        + "name text)";

    public static final String CREATE_CATEGORY="create table Category("
        + "id integer primary key autoincrement, "
        + "category_name text, "
        + "category_code integer)";

    private Context mcontext;

    /**
     * 构造方法  上下文对象、数据库名称、CursorFactory类型 、数据库版本
     */
    public DatabeseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mcontext=context;
    }

    /**
     * 数据库第一次生成时候调用
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        Toast.makeText(mcontext,"Create succeed",Toast.LENGTH_SHORT).show();

    }

    /**
     *数据库需要升级活着实现删除数据表，并建立新的数据表
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if ");
    }
}
