package cn.pfc.fyh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cn.pfc.fyh.R;
/**
 * @author fyh by 2019.5.14 18:29
 *
 * */
public class EasyAdapter extends BaseAdapter {
    Context context; List<String> list;
    public EasyAdapter(Context context, List<String> list) {
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_layout, null);
        //原来的布局
        final LinearLayout linearLayout = convertView.findViewById(R.id.infoLL);
        //新加的布局
        final View rightView = LayoutInflater.from(context).inflate(R.layout.layout,null);
        //添加布局
        linearLayout.addView(rightView);
        //获取view的宽度
        final int cc = rightView.getWidth();
        //设置边距（右边距）
        linearLayout.setPadding(0,0,(cc-200),0);
        TextView inforTV=convertView.findViewById(R.id.inforTV);
       final Button getBtn=rightView.findViewById(R.id.getBtn);
        final Button delBtn=rightView.findViewById(R.id.delBtn);
        inforTV.setText(list.get(position));
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
        convertView.setOnTouchListener(new View.OnTouchListener(){
             float downX=0,upX=0,moveX=0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction())//根据动作来执行代码
                {
                    case MotionEvent.ACTION_DOWN://按下
                        //按下，消失隐藏的view

                        downX = event.getX();
                        rightView.setPadding(0,0,(-cc),0);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        moveX = event.getX();
                        float last = moveX-downX;
                        if(last<0)
                        {
                            //左滑，拖出隐藏的view
                            rightView.setPadding(0,0,-cc,0);
                            if(-last>100)
                            {
                                rightView.setPadding(0,0,200,0);
                            }
                            else if(-last<=100)
                            {
                                rightView.setPadding(0,0,(-cc),0);
                            }
                        }
                        else if(last>0)
                        {
                            //右滑，消失隐藏的view
                            if(last>50)
                            {
                                rightView.setPadding(0,0,(-cc),0);
                            }
                        }
                            break;
                    case MotionEvent.ACTION_UP://松开
                            //pass
                        break;
                    default:
                }
                return true;
            }
        });
        return convertView;
    }
}
