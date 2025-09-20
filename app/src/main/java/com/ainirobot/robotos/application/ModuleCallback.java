package com.ainirobot.robotos.application;

import android.os.RemoteException;
import android.util.Log;

import com.ainirobot.coreservice.client.module.ModuleCallbackApi;
import com.ainirobot.robotos.LogTools;

public class ModuleCallback extends ModuleCallbackApi {

    private static final String TAG = ModuleCallback.class.getName();

    /**
     * Receive speech request
     * 接收语音指令 底层发起request 请求
     *
     * @param reqId
     * @param reqType 语音指令类型, Speech type
     * @param reqText 语音识别内容, Speech text
     * @param reqParam 语音指令参数, Speech param
     * @throws RemoteException
     */
    @Override
    public boolean onSendRequest(int reqId, String reqType, String reqText, String reqParam) throws RemoteException {
        Log.d(TAG, "New request: " + " type is:" + reqType + " text is:" + reqText + " reqParam = " + reqParam);
        String text = "New request: " + " type is:" + reqType + " text is:" + reqText + " reqParam = " + reqParam;
        LogTools.info(text);
        return true;
    }

    /**
     * hardware error callback
     * 硬件出现异常回调
     * @param function
     * @param type
     * @param message
     * @throws RemoteException
     */
    @Override
    public void onHWReport(int function, String type, String message) throws RemoteException {
        Log.i(TAG, "onHWReport function:" + function + " type:" + type + " message:" + message);
        LogTools.info("onHWReport function:" + function + " type:" + type + " message:" + message);
    }

    /**
     * Suspend system, after this message, RobotOS can not work with this APP
     * 控制权被系统剥夺，收到该事件后，所有Api调用无效
     * @throws RemoteException
     */
    @Override
    public void onSuspend() throws RemoteException {
        Log.d(TAG, "onSuspend");
        LogTools.info("onSuspend");
    }

    /**
     * Recovery system, after this message, RobotOS can work with this APP again.
     * 控制权恢复，收到该事件后，重新恢复对机器人的控制
     * @throws RemoteException
     */
    @Override
    public void onRecovery() throws RemoteException {
        Log.d(TAG, "onRecovery");
        LogTools.info("onRecovery");
    }
}
