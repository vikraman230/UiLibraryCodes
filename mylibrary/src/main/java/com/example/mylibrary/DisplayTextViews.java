package com.example.mylibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DisplayTextViews extends LinearLayout {

    private LinearLayout containerLayout;
    private LinearLayout lltOrientationLayOut;
    private TextView tvLabelText;
    private TextView tvValueText;
    private TypedArray typedArray;

    //Attributes
    private String orientation;
    private String label;
    private String value;
    private int  labelColor;
    private int  valueColor;
    private String labelFontSize;
    private String valueFontSize;

    public DisplayTextViews(Context context){
        super(context);
    }
    public DisplayTextViews(Context context, AttributeSet attrs){
        super(context,attrs);
        typedArray=context.obtainStyledAttributes(attrs,R.styleable.Control);

        orientation=typedArray.getString(R.styleable.Control_orientation);
        label=typedArray.getString(R.styleable.Control_label);
        value=typedArray.getString(R.styleable.Control_value);
        labelColor=typedArray.getColor(R.styleable.Control_labelColor,0);
        valueColor=typedArray.getColor(R.styleable.Control_valueColor,0);
        initView();

    }

    private void initView() {
        String service=Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater layoutInflater=(LayoutInflater) getContext().getSystemService(service);
        containerLayout=(LinearLayout) layoutInflater.inflate(R.layout.layout,this,true);

        this.tvLabelText=(TextView) containerLayout.findViewById(R.id.tv_label);
        this.tvValueText=(TextView) containerLayout.findViewById(R.id.tv_value);
        this.lltOrientationLayOut=(LinearLayout) containerLayout.findViewById(R.id.llt_containerlayout);
        setLayoutOrientation(orientation);
        setLabelText(label);
        setValueText(value);

    }

    public void setValueText(String value) {
        this.tvValueText.setText(value);
    }

    public void setLabelText(String label) {
        this.tvLabelText.setText(label);
    }

    public void setLayoutOrientation(String orientation) {
        if(orientation!=null){
            if(orientation.equals("1")){
                lltOrientationLayOut.setOrientation(HORIZONTAL);
                int i=lltOrientationLayOut.getChildCount();
                if(i>0){
                    TextView textView=(TextView) lltOrientationLayOut.getChildAt(1);
                    LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                    params.setMargins(15,0,0,0);
                    textView.setLayoutParams(params);
                }
            }
            else {
                lltOrientationLayOut.setOrientation(VERTICAL);
            }
        }

    }
}
