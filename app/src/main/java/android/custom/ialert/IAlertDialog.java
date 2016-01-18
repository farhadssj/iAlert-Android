package android.custom.ialert;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import ios.custom.ialert_android.R;

/**
 * Created by Md Farhad Hossain on 1/18/2016.
 */
public class IAlertDialog {

    private Context context;
    private Dialog dialog;

    private IAlertDialogListener iAlertDialogListener=null;

    public IAlertDialog(Context mContext){
        this.context=mContext;
    }
    public void createAlertDialog(String title,String message) {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.ialert_dialog);
        dialog.setCancelable(false);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int screenWidth = (int) (metrics.widthPixels * 0.75);
        lp.width = screenWidth;
        dialog.getWindow().setAttributes(lp);

        TextView titleTextView=(TextView)dialog.findViewById(R.id.iAlertTitle);
        TextView messageTextView=(TextView)dialog.findViewById(R.id.iAlertMessage);
        titleTextView.setText(title);
        messageTextView.setText(message);
        //dialog click event
        Button dialogOkButton=(Button)dialog.findViewById(R.id.iAlertOkButton);
        dialogOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                //save the input value
                if (iAlertDialogListener!=null){
                    iAlertDialogListener.onOk();
                }
            }
        });
        Button dialogCancelButton=(Button)dialog.findViewById(R.id.iAlertCancelButton);
        dialogCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (iAlertDialogListener!=null){
                    iAlertDialogListener.onCancel();
                }
            }
        });

        dialog.show();
    }
    public void setIAlertDialogListener(IAlertDialogListener listener){
        iAlertDialogListener=listener;
    }
}
