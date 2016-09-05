package lzw_usual_module.usual_module;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //Button按钮的监听器
        Button button_change = (Button) findViewById(R.id.button_change);
        button_change.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String message = "信息改变成功";
                EditText editText = (EditText) findViewById(R.id.message);
                editText.setText(message);
            }
        });

        final TextView sex = (TextView) findViewById(R.id.sex);

        //CheckBox按钮的监视器,在选择的时候出现信息，点击取消的时候信息消失
        final RadioButton button_men = (RadioButton) findViewById(R.id.men);
        final CheckBox box_women = (CheckBox) findViewById(R.id.women);
        box_women.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //用于判断是否选中组件
                boolean checked = ((CheckBox) view).isChecked();
                switch(view.getId()){
                    case R.id.men:sex.setText(""+button_men.getText());
                    case R.id.women:
                        if(checked){
                            sex.setText(""+sex.getText()+box_women.getText());
                        }
                        else{
                            sex.setText("性别：");
                        }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
/*
1.在checkBox类型的选择的时候点击取消后依然存在性别为“女”——添加判断组件是否被选中的方法 boolean checked = ((CheckBox) view).isChecked();
2.在往TextView类型组件中直接使用getText()+box_women.getText()往sex.setText()中传递参数时出现错误——需改为""+getText()+box_women.getText(),目的是转换成String类型
 */