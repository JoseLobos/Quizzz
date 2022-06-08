package App.download.quizizz_maker;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Cuestionario_disponible_Docente extends AppCompatActivity {
    BaseDeDatos db;

    public Cursor c;
    public String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuestionario_disponible_docentess);
        obtenerDatos();

    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.mimenu, menu);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
        c.moveToPosition( info.position );
        menu.setHeaderTitle(c.getString(1));
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnxModificar:
                try {
                    String user[] = {
                            c.getString(1),
                            c.getString(2),
                            c.getString(3),
                            c.getString(4),
                            c.getString(5),
                            c.getString(6),
                            c.getString(7),
                            c.getString(8),
                            c.getString(9),
                            c.getString(10),
                            c.getString(11),
                            c.getString(12)
                    };
                    Bundle idc = new Bundle();
                    idc.putString("id", c.getString(0));
                    idc.putString("accion","modificar");
                    idc.putStringArray("user", user);
                    Intent iusuario = new Intent(Cuestionario_disponible_Docente.this, Creacion_Cuestionarios.class);
                    iusuario.putExtras(idc);
                    startActivity(iusuario);
                }
                catch (Exception e){
                    Toast.makeText(Cuestionario_disponible_Docente.this, "Error: "+ e.getMessage().toString(),
                            Toast.LENGTH_LONG).show();
                }
                return true;
            case R.id.mnxEliminar:
                AlertDialog confirmacion = eliminar();
                confirmacion.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }


    }
    public AlertDialog eliminar() {
        AlertDialog.Builder confirmacion = new
                AlertDialog.Builder(Cuestionario_disponible_Docente.this);
        confirmacion.setTitle(c.getString(1));
        confirmacion.setMessage("Esta Seguro de Eliminar el registgro?");
        confirmacion.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
// TODO Auto-generated method stub
                db.eliminarCuestionario(c.getString(0));
                dialog.cancel();
                Toast.makeText(Cuestionario_disponible_Docente.this, "El registro se elimino satisfactoriamente.", Toast.LENGTH_LONG).show();
            }
        });
        confirmacion.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Toast.makeText(Cuestionario_disponible_Docente.this, "Accion cancelado por el usuario.",
                        Toast.LENGTH_LONG).show();
            }
        } );
        return confirmacion.create();
    }




    public void obtenerDatos(){
        db = new BaseDeDatos(Cuestionario_disponible_Docente.this, "", null, 1);
        c = db.consultarCuestionarios();
        if(c.moveToFirst()){ //hay registro que mostrar


            ListView ltsUser = (ListView)findViewById(R.id.QuizDocentes);


            final ArrayList<String> alUsers = new ArrayList<String>();


            final ArrayAdapter<String> aaUsers = new
                    ArrayAdapter<String>(Cuestionario_disponible_Docente.this, android.R.layout.simple_list_item_1,
                    alUsers);

            ltsUser.setAdapter(aaUsers);;

            do{
                alUsers.add(c.getString(1));

            }while(c.moveToNext());
            aaUsers.notifyDataSetChanged();
            registerForContextMenu(ltsUser);
        }else{
            Toast.makeText(Cuestionario_disponible_Docente.this, "No hay Registros que mostrar ",
                    Toast.LENGTH_LONG).show();
        }


    }
  }