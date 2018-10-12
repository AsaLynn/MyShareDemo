package com.zxn.share;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by zxn on 2018-8-8 20:52:42.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected TextView tvShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_share) {
            share();
        }
    }

    private void share() {
        /*Intent textIntent = new Intent(Intent.ACTION_SEND);
        textIntent.setType("text/plain");
        textIntent.putExtra(Intent.EXTRA_TEXT, "这是一段分享的文字");
        startActivity(Intent.createChooser(textIntent, "分享"));*/

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "这是一段分享的文字");
        sendIntent.setType("text/plain");
          sendIntent.setClassName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");//微信朋友
//          sendIntent.setClassName("com.tencent.mobileqq", "cooperation.qqfav.widget.QfavJumpActivity");//保存到QQ收藏
//          sendIntent.setClassName("com.tencent.mobileqq", "cooperation.qlink.QlinkShareJumpActivity");//QQ面对面快传
//          sendIntent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.qfileJumpActivity");//传给我的电脑
//          sendIntent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity");//QQ好友或QQ群
          sendIntent
                  .setClassName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI");
          //微信朋友圈，仅支持分享图片
        startActivity(Intent.createChooser(sendIntent, "分享"));
    }

    private void initView() {
        tvShare = (TextView) findViewById(R.id.tv_share);
        tvShare.setOnClickListener(MainActivity.this);
    }
}
