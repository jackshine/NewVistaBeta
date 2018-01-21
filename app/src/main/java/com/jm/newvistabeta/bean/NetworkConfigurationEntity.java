package com.jm.newvistabeta.bean;

/**
 * Created by Johnny on 1/21/2018.
 */

public class NetworkConfigurationEntity {
    private String serverIp;
    private int serverPushPort;
    private int clientPullPort;

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public int getServerPushPort() {
        return serverPushPort;
    }

    public void setServerPushPort(int serverPushPort) {
        this.serverPushPort = serverPushPort;
    }

    public int getClientPullPort() {
        return clientPullPort;
    }

    public void setClientPullPort(int clientPullPort) {
        this.clientPullPort = clientPullPort;
    }
}
