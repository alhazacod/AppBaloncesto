package manuel.appbaloncesto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTeam extends AppCompatActivity implements View.OnClickListener {

    Button btnRegister;

    EditText editTeamA;
    EditText editTeamB;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_team);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnRegister = (Button) findViewById(R.id.btnRegister);

        editTeamA = (EditText) findViewById(R.id.editTeamA);
        editTeamB = (EditText) findViewById(R.id.editTeamB);

        if (getIntent().getExtras() != null) {
            editTeamA.setText(getIntent().getExtras().getString("teamA"));
            editTeamB.setText(getIntent().getExtras().getString("teamB"));
        }

        btnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegister:
                String teamA = editTeamA.getText().toString();
                String teamB = editTeamB.getText().toString();

                Toast.makeText(this, "Nombre del Equipo A" + teamA, Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Nombre del Equipo B" + teamB, Toast.LENGTH_SHORT).show();

                Intent load = new Intent(this, MainActivity.class);
                load.putExtra("teamA", teamA);
                load.putExtra("teamB", teamB);

                startActivity(load);
                break;
        }
    }
}
