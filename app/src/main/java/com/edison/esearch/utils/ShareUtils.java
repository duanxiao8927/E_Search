package com.edison.esearch.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.edison.esearch.R;
import com.mob.tools.utils.UIHandler;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * 类描述：
 * 创建人：  Edison
 * 创建时间：2016/4/1 11:50
 */
public class ShareUtils {

    private static Context mContext = null;

    public static void share(final Context context, String shareTitle,
                             String shareImage, String shareUrl, String shareDesc) {
        ShareSDK.initSDK(context);

        mContext = context;

        OnekeyShare oks = new OnekeyShare();

        // 关闭sso授权
        oks.disableSSOWhenAuthorize();

        oks.setTitle(shareTitle);

        // text是分享文本，所有平台都需要这个字段
        oks.setText(shareDesc);

        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImageUrl(shareImage);

        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(shareUrl);

        oks.setCallback(new OneKeyShareCallback());

        // 启动分享GUI
        oks.show(context);
    }


    static class OneKeyShareCallback implements PlatformActionListener,Handler.Callback {

        private final int SUCCESS = 0;
        private final int FAILED = 1;
        Toast mToast ;

        public void onComplete(Platform plat, int action,
                               HashMap res) {


            UIHandler.sendEmptyMessage(SUCCESS,this);
        }

        public void onError(Platform plat, int action, Throwable t) {

            UIHandler.sendEmptyMessage(FAILED, this);
        }

        public void onCancel(Platform plat, int action) {
        }

        @Override
        public boolean handleMessage(Message msg) {
            if(msg == null){
                mToast = Toast.makeText(mContext, "", Toast.LENGTH_LONG);
                return false;
            }

            switch (msg.what){
                case SUCCESS:
                    mToast = Toast.makeText(mContext, "SUCCESS", Toast.LENGTH_LONG);
                    break;
                case FAILED:
                    mToast = Toast.makeText(mContext, "FAILED", Toast.LENGTH_LONG);
                    break;
            }

            return false;
        }
    }
}
