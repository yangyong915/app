package com.example.administrator.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

/**
 * Created on 2016/8/11.
 * Author：qdq
 * Description:标题view
 */
public class TitleView extends LinearLayout implements View.OnClickListener{
    private ImageView left_iv;
    private TextView left_tv;
    private TextView center_tv;
    private ImageView right_iv;
    private TextView right_tv;


    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
        initLisener();
    }

    private void initLisener() {
        left_iv.setOnClickListener(this);
        left_tv.setOnClickListener(this);
        right_iv.setOnClickListener(this);
        right_tv.setOnClickListener(this);
    }

    private void initView() {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.title_layout,this);
        left_iv= (ImageView) view.findViewById(R.id.left_iv);
        left_tv= (TextView) view.findViewById(R.id.left_tv);
        center_tv= (TextView) view.findViewById(R.id.center_tv);
        right_iv= (ImageView) view.findViewById(R.id.right_iv);
        right_tv= (TextView) view.findViewById(R.id.right_tv);
    }
    public void setLeftVisible(int visible){
        left_tv.setVisibility(visible);
        left_iv.setVisibility(visible);
    }
    public void setRightVisible(int visible){
        right_iv.setVisibility(visible);
        right_tv.setVisibility(visible);
    }
    public void setLeftText(String content){
        left_tv.setVisibility(VISIBLE);
        left_tv.setText(content);
    }
    public void setLeftIcon(int resId){
        left_iv.setVisibility(VISIBLE);
        left_iv.setImageResource(resId);
    }
    public void setCenterText(String content){
        center_tv.setVisibility(VISIBLE);
        center_tv.setText(content);
    }
    public void setRightText(String content){
        right_tv.setVisibility(VISIBLE);
        right_tv.setText(content);
    }
    public void setRightIcon(int resId){
        right_iv.setVisibility(VISIBLE);
        right_iv.setImageResource(resId);
    }
    @Override
    public void onClick(View v) {
        if(v==left_iv){
            if(leftIvListener!=null){
                leftIvListener.click(v);
            }

        }else if(v==left_tv){
            if(leftTvListener!=null){
                leftTvListener.click(v);
            }
        }else if(v==right_iv){
            if(rightIvListener!=null){
                rightIvListener.click(v);
            }
        }else if(v==right_tv){
            if(rightTvListener!=null){
                rightTvListener.click(v);
            }
        }
    }
    private LeftIvClickListener leftIvListener;
    private LeftTvClickListener leftTvListener;
    private RightIvClickListener rightIvListener;
    private RightTvClickListener rightTvListener;

    public void setLeftIvListener(LeftIvClickListener leftIvListener) {
        this.leftIvListener = leftIvListener;
    }

    public void setLeftTvListener(LeftTvClickListener leftTvListener) {
        this.leftTvListener = leftTvListener;
    }

    public void setRightIvListener(RightIvClickListener rightIvListener) {
        this.rightIvListener = rightIvListener;
    }

    public void setRightTvListener(RightTvClickListener rightTvListener) {
        this.rightTvListener = rightTvListener;
    }

    public interface LeftIvClickListener{
        void click(View view);
    }
    public interface LeftTvClickListener{
        void click(View view);
    }
    public interface RightIvClickListener{
        void click(View view);
    }
    public interface RightTvClickListener{
        void click(View view);
    }
}
