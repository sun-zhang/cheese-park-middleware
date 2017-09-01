package com.hangwei.wanke.middleware.service;

/**
 * Created by Sam on 9/1/17.
 */
public class TransferService {

    private static Transfer transfer = null;

    public static Transfer getTransferInstance(){
        synchronized (transfer){
            if (transfer==null){
                transfer = new Transfer();
            }
        }
        return transfer;
    }

    public String doPHPHttpPost(String postContent){
        return "";
    }
}
