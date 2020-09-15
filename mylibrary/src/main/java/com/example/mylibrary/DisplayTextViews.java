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

    private DisplayTextViews(Context context){
        super(context);
    }
    private DisplayTextViews(Context context, AttributeSet attrs){
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
        this.tvValueText=(TextView) containerLayout.findViewById(R.id.tv_label);
        this.lltOrientationLayOut=(LinearLayout) containerLayout.findViewById(R.id.llt_containerlayout);
        setLayoutOrientation(orientation);
        setLabelText(label);
        setValueText(value);

    }

    private void setValueText(String value) {
        this.tvValueText.setText(value);
    }

    private void setLabelText(String label) {
        this.tvLabelText.setText(label);
    }

    private void setLayoutOrientation(String orientation) {

    }
}
