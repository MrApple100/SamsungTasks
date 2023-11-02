package com.example.cells;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView mines;
    Button[][] cells;
    final int WIDTH = 10;
    final int HEIGHT = 15;
    final int MINESCONST = 3;
    int MinesCurrent = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mines = findViewById(R.id.TV);
        mines.setText(""+MINESCONST+" / "+MinesCurrent);
        generate();
    }

    public void generate(){
        GridLayout layout = findViewById(R.id.GRID);
        layout.removeAllViews();
        layout.setColumnCount(WIDTH);
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
       // divideByZero();
        cells = new Button[HEIGHT][WIDTH];

        for(int i=0;i<HEIGHT;i++){
            for(int j=0;j<WIDTH;j++){
                //assert i==2;
                cells[i][j] = (Button) inflater.inflate(R.layout.cell,layout,false);
            }
        }

        for(int i=0;i<HEIGHT;i++){
            for(int j=0;j<WIDTH;j++){

                cells[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.setBackgroundColor(Color.RED);
                    }
                });
                cells[i][j].setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        v.setBackgroundColor(Color.BLUE);
                        MinesCurrent--;
                        mines.setText(""+MINESCONST+" / "+MinesCurrent);
                        if(MinesCurrent==0){
                            Toast.makeText(getApplicationContext(),"WIN!",Toast.LENGTH_LONG).show();
                        }
                        return true;
                    }
                });

                cells[i][j].setText(""+j+HEIGHT*i);
                cells[i][j].setTag(""+j+HEIGHT*i);
                layout.addView(cells[i][j]);


            }
        }



    }

    private void divideByZero() {
       // int x = 10/0;
    }

    public static int axb(int x){
        return 2*x+10;
    }


}