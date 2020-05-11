package kr.co.ajsoft.ex40sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etAge;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.et_name);
        etAge=findViewById(R.id.et_age);
        tv=findViewById(R.id.tv);
    }

    public void clickSave(View view) {
        String name=etName.getText().toString();
        int age;
        try{
            age=Integer.parseInt(etAge.getText().toString());

        }catch (Exception e){
            age=0;

        }



        //Data.xml파일에 데이터를 저장하기 위해
        //SharedPreferences객체를 소환하기
        SharedPreferences preferences=getSharedPreferences("Data",MODE_PRIVATE);


        //문서 작성을 시작한다는 메소드를
        //실행하면 문서에 글작성을 해주는 Editor 객체 생성
        SharedPreferences.Editor editor=preferences.edit();

        editor.putString("Name",name);//키값 : 식별자, 밸류 : 값
        editor.putInt("Age",age);

        //문서작성이 끝났다라고 메소드를 실행
        editor.commit();


    }

    public void clickLoad(View view) {

        SharedPreferences preferences=getSharedPreferences("Data",MODE_PRIVATE);

        String name=preferences.getString("Name","no name");
        int age=preferences.getInt("Age",0);

        tv.setText(name+" , "+ age);


    }
}
