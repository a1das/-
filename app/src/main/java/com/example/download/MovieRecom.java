package com.example.download;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class MovieRecom extends AppCompatActivity {

    ImageView img1, img2, img3, img4,mDownload1,mDownload2,mDownload3,mDownload4;   //图片
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_recom);

        img1 = (ImageView)this.findViewById(R.id.mImageView1);   //图片初始化
        img2 = (ImageView)this.findViewById(R.id.mImageView2);
        img3 = (ImageView)this.findViewById(R.id.mImageView3);
        img4 = (ImageView)this.findViewById(R.id.mImageView4);

        mDownload1 = (ImageView)this.findViewById(R.id.mDown1); //图片按钮初始化
        mDownload2 = (ImageView)this.findViewById(R.id.mDown2);
        mDownload3 = (ImageView)this.findViewById(R.id.mDown3);
        mDownload4 = (ImageView) this.findViewById(R.id.mDown4);

        //下载地址
        String url1 = "http://www.170mv.com/kw/other.web.ra01.sycdn.kuwo.cn/resource/n3/128/25/17/3870959088.mp3";
        String url2 = "";
        String url3 = "";
        String url4 = "";

        mDownload1.setOnClickListener(new btnClick(url1));   //对图片设置监听事件
        mDownload2.setOnClickListener(new btnClick(url1));
        mDownload3.setOnClickListener(new btnClick(url1));
        mDownload4.setOnClickListener(new btnClick(url1));

    }

    class btnClick implements View.OnClickListener
    {
        String url;
        public btnClick(String url)  //参数，下载地址
        {
            this.url = url;
        }

        public void onClick(View view) {
            Intent intent = new Intent();
            //intent.setClass(MovieRecom.this, );      //指定切换的页面

            Bundle bundle = new Bundle();
            bundle.putString("url", url);

            intent.putExtras(bundle);  //将Bundle对象传递给Intent
            //startActivity(intent);   //启动另一个页面,即下载页面

        }
    }

}
