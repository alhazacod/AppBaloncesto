package manuel.appbaloncesto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int ta = 0;
    int tb = 0;
    TextView ta_count;
    TextView tb_count;

    TextView tvNameTeamA;
    TextView tvNameTeamB;

    Button btnNames;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Set Name to Intent variable
        tvNameTeamA = (TextView) findViewById(R.id.tvNameTeamA);
        tvNameTeamB = (TextView) findViewById(R.id.tvNameTeamB);


        String nameA = getIntent().getExtras().getString("teamA");
        String nameB = getIntent().getExtras().getString("teamB");

        tvNameTeamA.setText(nameA);
        tvNameTeamB.setText(nameB);
        //END Set Name to Intent variable

        ta_count = (TextView) findViewById(R.id.ta_count);
        tb_count = (TextView) findViewById(R.id.tb_count);

        //Team A listener
        findViewById(R.id.ta_1p).setOnClickListener(this);
        findViewById(R.id.ta_2p).setOnClickListener(this);
        findViewById(R.id.ta_3p).setOnClickListener(this);
        //End Team A listener

        //Team B listener
        findViewById(R.id.tb_1p).setOnClickListener(this);
        findViewById(R.id.tb_2p).setOnClickListener(this);
        findViewById(R.id.tb_3p).setOnClickListener(this);
        //End Team B listener

        findViewById(R.id.btn_clearCounters).setOnClickListener(this);

        btnNames = (Button) findViewById(R.id.btnNames);
        btnNames.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            //Team A
            case R.id.ta_3p:
                ta+=3;
                ta_count.setText(Integer.toString(ta));
                Toast.makeText(this, "+3 al equipo A", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ta_2p:
                ta+=2;
                ta_count.setText(Integer.toString(ta));
                Toast.makeText(this, "+2 al equipo A", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ta_1p:
                ta+=1;
                ta_count.setText(Integer.toString(ta));
                Toast.makeText(this, "+1 al equipo A", Toast.LENGTH_SHORT).show();
                break;
            //End Team A

            //Team B
            case R.id.tb_3p:
                tb+=3;
                tb_count.setText(Integer.toString(tb));
                Toast.makeText(this, "+3 al equipo B", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tb_2p:
                tb+=2;
                tb_count.setText(Integer.toString(tb));
                Toast.makeText(this, "+2 al equipo B", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tb_1p:
                tb+=1;
                tb_count.setText(Integer.toString(tb));
                Toast.makeText(this, "+1 al equipo B", Toast.LENGTH_SHORT).show();
                break;
            //End Team B

            case R.id.btn_clearCounters:
                tb = 0;
                ta = 0;
                tb_count.setText(Integer.toString(tb));
                ta_count.setText(Integer.toString(ta));
                Toast.makeText(this, "Se reiniciaron los contadores", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnNames:
                String teamA = tvNameTeamA.getText().toString();
                String teamB = tvNameTeamB.getText().toString();
                Intent load = new Intent(this, AddTeam.class);
                load.putExtra("teamA", teamA);
                load.putExtra("teamB", teamB);
                startActivity(load);
                break;
        }
    }
}
