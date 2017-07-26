package autologin.weixinserver.com.weixinserver;

import android.accessibilityservice.AccessibilityService;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.List;

public class LoginService extends AccessibilityService {
    public static final String TAG = "Message";
    private  AccessibilityNodeInfo rootNodeInfo;
    public static Bundle createBuddleText(String inputText) {
        Bundle inputContent = new Bundle();
        inputContent.putCharSequence(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE,inputText);
        return inputContent;
    }

        @Override
    protected void onServiceConnected() {
        Log.d(TAG,"onServiceConnected");

    }

    public String description ="";

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        AccessibilityNodeInfo rootNodeInfo = getRootInActiveWindow();
        if (rootNodeInfo == null) {
            return;
        }else {

            List<AccessibilityNodeInfo> logintitleInfo = rootNodeInfo.findAccessibilityNodeInfosByText("登录微信");
            List<AccessibilityNodeInfo> quitNode = rootNodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/bge");
            List<AccessibilityNodeInfo> bigquitetagNow = rootNodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/ad8");
            List<AccessibilityNodeInfo> moreNode = rootNodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/bg9");
            List<AccessibilityNodeInfo> changeUserNode = rootNodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/fi");
            List<AccessibilityNodeInfo> chuangotherlogin = rootNodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/bgd");
            List<AccessibilityNodeInfo> meClickNode = rootNodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/bue");
            List<AccessibilityNodeInfo> setbut = rootNodeInfo.findAccessibilityNodeInfosByText("设置");
            List<AccessibilityNodeInfo> exit = rootNodeInfo.findAccessibilityNodeInfosByText("退出");
                if (logintitleInfo.size()!=0) {
                    this.loginUser(rootNodeInfo,event);
                }else if (moreNode.size()!=0) {
                    moreNode.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }else if(changeUserNode.size()!=0&&exit.size()!=1){
                    Log.d(TAG, "切换账号标题框数量:" + changeUserNode.size());
                    changeUserNode.get(0).getParent().performAction(AccessibilityNodeInfo.ACTION_CLICK);
                    Log.d(TAG, "其他方式登录:" + chuangotherlogin.size());
                        if(chuangotherlogin.size()!=0){
                            chuangotherlogin.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                            Log.d(TAG, "其他方式登录:" + changeUserNode.size());
                        }

                }else if (bigquitetagNow.size()!=0){
                    Log.d(TAG, "退出保存数据:" + bigquitetagNow.size());
                    bigquitetagNow.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }
                else if (exit.size()!=2&&exit.size()!=0){
                    Log.d(TAG, "退出按钮数量:" + exit.size());
                    exit.get(0).getParent().performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }else if(quitNode.size()!=0) {
                    Log.d(TAG, "退出当前账号:" + quitNode.size());
                    quitNode.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }
                else {
                    description = "";
                    if (rootNodeInfo.getContentDescription() != null) {
                        description = rootNodeInfo.getContentDescription().toString();
                    }

                    if(description.contains("的聊天")){
                     if(meClickNode.size()!=0&&setbut.size()==0){
                         Log.d(TAG,"标题数量:" + meClickNode.size());
                            meClickNode.get(3).getParent().performAction(AccessibilityNodeInfo.ACTION_CLICK);
                            Log.d(TAG,"点击我" + "点击我");
                        }else if (setbut.size()!=0){
                         Log.d(TAG,"设置标题数量:" + setbut.size());
                         setbut.get(0).getParent().performAction(AccessibilityNodeInfo.ACTION_CLICK);
                     }

                }//XIAO else

            }
        }//ELEE



    }



    @Override
    public void onInterrupt() {
        Log.d(TAG,"onInterrupt");
    }
    public void pause(AccessibilityNodeInfo info,String text){
        ClipboardManager clipboard = (ClipboardManager)this.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("text", text);
        clipboard.setPrimaryClip(clip);
//焦点（n是AccessibilityNodeInfo对象）
        info.performAction(AccessibilityNodeInfo.ACTION_FOCUS);
////粘贴进入内容
        info.performAction(AccessibilityNodeInfo.ACTION_PASTE);
    }
    public static void performSetText(AccessibilityNodeInfo nodeInfo,String text){
        if(nodeInfo.isEditable()){
            nodeInfo.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT,createBuddleText(text));
        }else{
            performSetText(nodeInfo.getParent(),text);
        }
    }
    private void loginUser(AccessibilityNodeInfo rootNodeInfo,AccessibilityEvent event){
        List<AccessibilityNodeInfo> logintitleInfo =
                rootNodeInfo.findAccessibilityNodeInfosByText("登录微信");
        Log.d(TAG,"登陆界面标题框数量:" + logintitleInfo.size());
        if (logintitleInfo.size() != 0) {
            List<AccessibilityNodeInfo> loginInputInfo =
                    rootNodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/gz");
            Log.d(TAG,"登陆界面输入框数量:" + loginInputInfo.size());

            for (AccessibilityNodeInfo tempNode : loginInputInfo) {
                Log.d(TAG, "tes ");
                if (tempNode.getText()!=null&&tempNode.getText().toString().contains("QQ号/微信号/Email")) {
                    Log.d(TAG, "输入账号");
                    pause(tempNode, "248694148");
                }
                }
            List<AccessibilityNodeInfo> tempNode =
                    rootNodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/bfn");
            AccessibilityNodeInfo   PswNode = tempNode.get(0).getChild(1);
                    pause(PswNode,"aa84857766");

                    ;
            List<AccessibilityNodeInfo> loginbtns =
                    rootNodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/bfo");
            loginbtns.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }
    }


}
