package com.example.d2lesson49;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.d2lesson49.models.QuestionModel;
import com.example.d2lesson49.service.QuestionModelImpl;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private TextView txtSavol;
    private RadioButton rad1,rad2,rad3,rad4;
    private Button button;
    private QuestionModelImpl questionModel = new QuestionModelImpl();
    private List<QuestionModel> list;
    private  int index = 0;
    private String myAnswer = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        checkBox = findViewById(R.id.check1);
//        txt = findViewById(R.id.txt);
//        linearLayout = findViewById(R.id.container);
//
//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b){
//                    linearLayout.setBackgroundColor(Color.RED);
//                    txt.setText("Checked bo'ldi");
//                }else {
//                    txt.setText("Uncheked bo'ldi");
//                    linearLayout.setBackgroundColor(Color.BLUE);
//                }
//            }
//        })

        setUi();
        loadData();
        setTest();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if (id != -1){

                myAnswer = ((RadioButton)findViewById(id)).getText().toString();
                }
            }
        });
        button.setOnClickListener(view -> {
            if (myAnswer == null){
                Toast.makeText(this, "Javob tanlang!", Toast.LENGTH_SHORT).show();
            }else {
                if (myAnswer.equalsIgnoreCase(list.get(index).getAnswer())){
                    Toast.makeText(this, "Barakalla", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Xato", Toast.LENGTH_SHORT).show();
                }
                if (index<list.size()-1){

                index++;
                radioGroup.clearCheck();
                setTest();
                }else{
                    txtSavol.setText("Savollar tugadi");
                }
            }

        });




    }

    private void setTest() {
        list = questionModel.getList();
        QuestionModel questionModel1 = list.get(index);
        txtSavol.setText(questionModel1.getQuestion());
        rad1.setText(questionModel1.getVar1());
        rad2.setText(questionModel1.getVar2());
        rad3.setText(questionModel1.getVar3());
        rad4.setText(questionModel1.getVar4());
        myAnswer = null;
    }

    private void loadData() {
        questionModel.add();
    }

    private void setUi() {
        radioGroup = findViewById(R.id.radG);
        rad1 = findViewById(R.id.rad1);
        rad2 = findViewById(R.id.rad2);
        rad3 = findViewById(R.id.rad3);
        rad4 = findViewById(R.id.rad4);
        txtSavol = findViewById(R.id.txtSavol);
        button = findViewById(R.id.btnNext);
    }
}