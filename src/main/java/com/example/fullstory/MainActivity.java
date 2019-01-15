package com.example.fullstory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView nei;
    private TextView sho;
    private String strings;//数据源
    private int VISIBLE = 1;//显示全文
    private int gone = 2;//收起
    private int indext = 0;//当前状态

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //内容默认显示三行
        nei.setText(strings);
        nei.setMaxLines(3);
        //状态默认是不展开
        indext = gone;

        //一定要使用post方法
        //如果不适用的话,很有可能会出现textview的getlinecount的值为0
        nei.post(new Runnable() {
            @Override
            public void run() {

                int lineCount = nei.getLineCount();
                Log.e("ee",lineCount+"");
                //判断内容是否查过三行
                if (lineCount > 3) {

                    //超过三行就让"全文"显示
                    sho.setVisibility(View.VISIBLE);

                } else {

                    //否则隐藏也就是没有以下的事件
                    sho.setVisibility(View.GONE);
                }
            }
        });
    }

    private void initView() {
        nei = (TextView) findViewById(R.id.nei);
        nei.setOnClickListener(this);
        sho = (TextView) findViewById(R.id.sho);
        sho.setOnClickListener(this);
        strings = "小说，以刻画人物形象为中心，通过完整的故事情节和环境描写来反映社会生活的文学体裁。\n" +
                "人物、情节、环境是小说的三要素。情节一般包括开端、发展、高潮、结局四部分，有的包括序幕、尾声。环境包括自然环境和社会环境。 小说按照篇幅及容量可分为长篇、中篇、短篇和微型小说（小小说）。按照表现的内容可分为神话、仙侠、武侠、古传、当代等。按照体制可分为章回体小说、日记体小说、书信体小说、自传体小说。按照语言形式可分为文言小说和白话小说。\n" +
                "小说与诗歌、散文、戏剧，并称“四大文学体裁”。\n" +
                "小说刻画人物的方法：心理描写、动作描写、语言描写、外貌描写、神态描写，同时，小说是一种写作方法。" +
                "小说，以刻画人物形象为中心，通过完整的故事情节和环境描写来反映社会生活的文学体裁。\n" +
                "人物、情节、环境是小说的三要素。情节一般包括开端、发展、高潮、结局四部分，有的包括序幕、尾声。环境包括自然环境和社会环境。 小说按照篇幅及容量可分为长篇、中篇、短篇和微型小说（小小说）。按照表现的内容可分为神话、仙侠、武侠、古传、当代等。按照体制可分为章回体小说、日记体小说、书信体小说、自传体小说。按照语言形式可分为文言小说和白话小说。\n" +
                "小说与诗歌、散文、戏剧，并称“四大文学体裁”。\n" +
                "小说刻画人物的方法：心理描写、动作描写、语言描写、外貌描写、神态描写，同时，小说是一种写作方法。" +
                "小说，以刻画人物形象为中心，通过完整的故事情节和环境描写来反映社会生活的文学体裁。\n" +
                "人物、情节、环境是小说的三要素。情节一般包括开端、发展、高潮、结局四部分，有的包括序幕、尾声。环境包括自然环境和社会环境。 小说按照篇幅及容量可分为长篇、中篇、短篇和微型小说（小小说）。按照表现的内容可分为神话、仙侠、武侠、古传、当代等。按照体制可分为章回体小说、日记体小说、书信体小说、自传体小说。按照语言形式可分为文言小说和白话小说。\n" +
                "小说与诗歌、散文、戏剧，并称“四大文学体裁”。\n" +
                "小说刻画人物的方法：心理描写、动作描写、语言描写、外貌描写、神态描写，同时，小说是一种写作方法。";
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.sho:

                //判断当前状态
                if (indext == gone) {
                    indext = VISIBLE;
                    sho.setText("收起");
                    nei.setMaxLines(Integer.MAX_VALUE);
                } else if (indext == VISIBLE) {
                    indext = gone;
                    sho.setText("全文");
                    nei.setMaxLines(3);
                }

                break;
        }
    }

}