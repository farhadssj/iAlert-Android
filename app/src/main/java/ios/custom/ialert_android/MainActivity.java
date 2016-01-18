package ios.custom.ialert_android;

import android.custom.ialert.IAlertDialog;
import android.custom.ialert.IAlertDialogListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IAlertDialogListener{

    IAlertDialog iAlertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Show Alert Button click implementation
     * @param v
     */
    public void showAlertButtonClicked(View v){
        iAlertDialog=new IAlertDialog(this);
        //create an alert with tittle & message
        iAlertDialog.createAlertDialog("Confirm Delete...","Are you sure you want delete this?");
        iAlertDialog.setIAlertDialogListener(this);
    }
    @Override
    public void onCancel(){
        Toast.makeText(getApplicationContext(),"Delete Cancel!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOk(){
        Toast.makeText(getApplicationContext(),"Delete Ok!",Toast.LENGTH_SHORT).show();
    }
}
