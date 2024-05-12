package moe.caa.multilogin.core.configuration.service.yggdrasil;

import moe.caa.multilogin.api.service.ServiceType;
import moe.caa.multilogin.core.configuration.ConfException;
import moe.caa.multilogin.core.configuration.ProxyConfig;
import moe.caa.multilogin.core.configuration.SkinRestorerConfig;
import org.jetbrains.annotations.NotNull;

/**
 * 正版官方 Yggdrasil
 */
public class OfficialYggdrasilServiceConfig extends BaseYggdrasilServiceConfig {
    public OfficialYggdrasilServiceConfig(int id, String name, InitUUID initUUID, String initNameFormat, boolean whitelist, SkinRestorerConfig skinRestorer, boolean trackIp, int timeout, int retry, long retryDelay, ProxyConfig authProxy) throws ConfException {
        super(id, name, initUUID, initNameFormat, whitelist, skinRestorer, trackIp, timeout, retry, retryDelay, authProxy);
    }

    @Override
    protected String getAuthURL() {
        return "https://".concat("session")
                .concat("server.")
                .concat("mojang")
                .concat(".com")
                .concat("/session")
                .concat("/minecraft")
                .concat("/hasJoined?")
                .concat("username={0}&serverId={1}{2}");
    }

    @Override
    protected String getAuthPostContent() {
        throw new UnsupportedOperationException("get post content");
    }

    @Override
    protected String getAuthTrackIpContent() {
        return "&ip={0}";
    }

    @Override
    public HttpRequestMethod getHttpRequestMethod() {
        return HttpRequestMethod.GET;
    }

    @NotNull
    @Override
    public ServiceType getServiceType() {
        return ServiceType.OFFICIAL;
    }
}
