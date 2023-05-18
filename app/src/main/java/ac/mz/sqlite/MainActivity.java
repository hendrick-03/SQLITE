package ac.mz.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ac.mz.sqlite.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;

    private static final String DB_NOME = "ALUNOSI31.DB";
    private static final int DB_VERSION = 1;
    private static Database databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        databaseHelper = new Database(this, DB_NOME, null, DB_VERSION);

        mainBinding.savebtn.setOnClickListener(
                v -> {
                    gravar();
                }
        );
    }
    private void gravar(){
        if (databaseHelper.save(mainBinding.nomeEd.getText().toString(),mainBinding.cursoEd.getText().toString()) !=1) {
            Toast.makeText(this, "SUCESSS", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Error, please try again", Toast.LENGTH_SHORT).show();
        }
    }
}