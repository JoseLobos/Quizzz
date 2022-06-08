package App.download.quizizz_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Cuestionario_disponible extends AppCompatActivity {
    BaseDeDatos db;

    public Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuestionario_disponible);
        obtenerDatos();
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menuestudiante, menu);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
        c.moveToPosition( info.position );
        menu.setHeaderTitle(c.getString(1));
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        Intent imostrar= new Intent(Cuestionario_disponible.this, Creacion_cuestionario.class);
        startActivity(imostrar);
        return super.onContextItemSelected(item);

    }




    public void obtenerDatos(){
        db = new BaseDeDatos(Cuestionario_disponible.this, "", null, 1);
        c = db.consultarCuestionarios();
        if(c.moveToFirst()){ //hay registro que mostrar

//hacer referencia al ListView
            ListView ltsUser = (ListView)findViewById(R.id.lstCuestionario);

//crear un array de tipo list
            final ArrayList<String> alUsers = new ArrayList<String>();

//crear una array de tipo adaptador
            final ArrayAdapter<String> aaUsers = new
                    ArrayAdapter<String>(Cuestionario_disponible.this, android.R.layout.simple_list_item_1,
                    alUsers);
            ltsUser.setAdapter(aaUsers);;
            do{
                alUsers.add(c.getString(1));
            }while(c.moveToNext());
            aaUsers.notifyDataSetChanged();
            registerForContextMenu(ltsUser);//hacemos referencia al listview para que muestre el menu.
        }else{
            //no hay registros que mostrar
            Toast.makeText(Cuestionario_disponible.this, "No hay Registros que mostrar ",
                    Toast.LENGTH_LONG).show();
        }
    }
}