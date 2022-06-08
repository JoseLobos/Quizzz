package com.example.quizizz_maker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDeDatos extends SQLiteOpenHelper {
    public static final String Quizz_maker = "QuizzMaker";
    public static final int v = 1;
    String cuestionarios = "create table cuestionarios (idCuestionario integer primary key autoincrement, nombre text, categoria text, pregunta1 text, respuestaCorrecta1_1 text, respuesta1_1 text, respuesta1_2 text, respuesta1_3 text, pregunta2 text, respuestaCorrecta2_1 text, respuesta2_1 text, respuesta2_2 text, respuesta2_3 )";

    public BaseDeDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Quizz_maker, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(cuestionarios);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void guardarCuestionario(String Nombre,String Categoria, String Pregunt, String RespCor, String RespInc1, String RespInc2, String RespInc3, String accion, String Id, String Pregunt2, String RespCor2, String RespInc2_1, String RespInc2_2, String RespInc2_3  ){
        SQLiteDatabase db = getWritableDatabase();
        if(accion.equals("modificar")){
            db.execSQL("update cuestionarios set  Nombre='"+Nombre+"',Categoria='"+Categoria+"',pregunta='"+ Pregunt +"', respuestaCorrecta='"+ RespCor +"',respuestaInc1='"+RespInc1+"', respuestaInc2='"+RespInc2+"',respuestaInc3='"+RespInc3+"',pregunta2='"+ Pregunt2 +"', respuestaCorrecta2='"+ RespCor2 +"',respuestaInc2_1='"+RespInc2_1+"', respuestaInc2_2='"+RespInc2_2+"',respuestaInc2_3='"+RespInc2_3+"', where idCuestionario='"+ Id +"'");
        } else{
            db.execSQL("insert into cuestionarios (nombre, categoria, pregunta1, respuestaCorrecta1_1, respuesta1_1, respuesta1_2, respuesta1_3, pregunta2, respuestaCorrecta2_1, respuesta2_1, respuesta2_2, respuesta2_3) values('"+Nombre+"','"+Categoria+"','"+Pregunt+"','"+RespCor+"', '"+RespInc1+"','"+RespInc2+"','"+RespInc3+"','"+Pregunt2+"','"+RespCor2+"','"+RespInc2_1+"','"+RespInc2_2+"','"+RespInc2_3+"')");
        }
    }
    public void eliminarCuestionario(String id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from cuestionarios where idCuestionario='"+ id +"'");
    }
    public Cursor consultarCuestionarios(){
        String sql = "select * from cuestionarios order by nombre asc";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        return c;
    }
}


