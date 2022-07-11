package org.example.gson;

import com.google.gson.Gson;

import javax.management.Attribute;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class GsonMap {

    public static Map ConverObjectToMap(Object obj){
//        try {
//            Field[] fields = obj.getClass().getDeclaredFields();
//            Map resultMap = new HashMap();
//            for(int i=0; i<=fields.length-1;i++){
//                fields[i].setAccessible(true);
//
//                if(fields[i].getType().toString().equals("interface java.util.Set")){
//                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//                    System.out.println("fields["+i+"]:"+fields[i]);
//                    System.out.println("fields[i].getType():"+fields[i].getType());
//                    resultMap.put(fields[i].getName(), fields[i].get(obj));
//                }
//            }
//            return resultMap;
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return null;
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            Map resultMap = new HashMap();
            for(int i=0; i<=fields.length-1;i++){
                fields[i].setAccessible(true);
                System.out.println("fields["+i+"]:"+fields[i]);
                System.out.println("fields[i].getType():"+fields[i].getType());
                System.out.println("fields[i].get(obj):"+fields[i].get(obj));
//                if(fields[i].getType().toString().equals("interface java.util.Set")){
//                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//                    System.out.println("fields["+i+"]:"+fields[i]);
//                    System.out.println("fields[i].getType():"+fields[i].getType());
////                    System.out.println("fields[i].get(obj):"+fields[i].get(obj));
//                    resultMap.put(fields[i].getName(), fields[i].get(obj));
//                }
            }
            return resultMap;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void start(){
        Gson gson = new Gson();

        String json = "configurationProperties = {\"configClientProperties\":{\"spring.cloud.config.profile\":\"default\",\"spring.cloud.config.password\":\"******\",\"spring.cloud.config.requestReadTimeout\":\"185000\",\"spring.cloud.config.username\":\"lena-admin\",\"spring.cloud.config.uri\":\"[http://localhost:7700/lena-embed-manager/config]\",\"spring.cloud.config.discovery\":\"{enabled\\u003dfalse, serviceId\\u003dconfigserver}\",\"spring.cloud.config.sendState\":\"true\",\"spring.cloud.config.requestConnectTimeout\":\"10000\",\"spring.cloud.config.mediaType\":\"application/vnd.spring-cloud.config-server.v2+json\",\"spring.cloud.config.failFast\":\"false\",\"spring.cloud.config.name\":\"application\",\"spring.cloud.config.enabled\":\"false\",\"spring.cloud.config.headers\":\"{}\",\"spring.cloud.config.tls\":\"{enabled\\u003dfalse, keyStorePassword\\u003d******, keyPassword\\u003d******, trustStorePassword\\u003d******}\"},\"spring.cloud.config-org.springframework.cloud.bootstrap.config.PropertySourceBootstrapProperties\":{\"spring.cloud.config.allowOverride\":\"true\",\"spring.cloud.config.overrideSystemProperties\":\"true\",\"spring.cloud.config.overrideNone\":\"false\"},\"inetUtilsProperties\":{\"spring.cloud.inetutils.defaultIpAddress\":\"127.0.0.1\",\"spring.cloud.inetutils.ignoredInterfaces\":\"[]\",\"spring.cloud.inetutils.preferredNetworks\":\"[]\",\"spring.cloud.inetutils.timeoutSeconds\":\"1\",\"spring.cloud.inetutils.useOnlySiteLocalInterfaces\":\"false\",\"spring.cloud.inetutils.defaultHostname\":\"localhost\"},\"server.lena-lena.embed.boot.config.properties.LenaProperties\":{\"server.lena.backgroundProcessorDelay\":\"PT10S\",\"server.lena.stuckThread\":\"{threshold\\u003d600, interruptThreadThreshold\\u003d-1}\",\"server.lena.hostHeader\":\"X-Forwarded-Host\",\"server.lena.processorCache\":\"200\",\"server.lena.maxSwallowSize\":\"{}\",\"server.lena.acceptCount\":\"100\",\"server.lena.portHeader\":\"X-Forwarded-Port\",\"server.lena.relaxedQueryChars\":\"[]\",\"server.lena.redirectContextRoot\":\"true\",\"server.lena.maxThreads\":\"200\",\"server.lena.additionalTldSkipPatterns\":\"[]\",\"server.lena.serverProperties\":\"{error\\u003d{path\\u003d/error, includeException\\u003dfalse, includeStacktrace\\u003dNEVER, includeMessage\\u003dNEVER, includeBindingErrors\\u003dNEVER, whitelabel\\u003d{enabled\\u003dtrue}}, maxHttpHeaderSize\\u003d{}, shutdown\\u003dIMMEDIATE, servlet\\u003d{contextParameters\\u003d{}, applicationDisplayName\\u003dapplication, registerDefaultServlet\\u003dtrue}, tomcat\\u003d{accesslog\\u003d{enabled\\u003dfalse, pattern\\u003dcommon, directory\\u003dlogs, prefix\\u003daccess_log, suffix\\u003d.log, checkExists\\u003dfalse, rotate\\u003dtrue, renameOnRotate\\u003dfalse, maxDays\\u003d-1, fileDateFormat\\u003d.yyyy-MM-dd, ipv6Canonical\\u003dfalse, requestAttributesEnabled\\u003dfalse, buffered\\u003dtrue}, threads\\u003d{max\\u003d200, minSpare\\u003d10}, backgroundProcessorDelay\\u003dPT10S, maxHttpFormPostSize\\u003d{}, maxSwallowSize\\u003d{}, redirectContextRoot\\u003dtrue, useRelativeRedirects\\u003dfalse, uriEncoding\\u003dUTF-8, maxConnections\\u003d8192, acceptCount\\u003d100, processorCache\\u003d200, additionalTldSkipPatterns\\u003d[], relaxedPathChars\\u003d[], relaxedQueryChars\\u003d[], resource\\u003d{allowCaching\\u003dtrue}, mbeanregistry\\u003d{enabled\\u003dfalse}, remoteip\\u003d{internalProxies\\u003d10\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|192\\\\.168\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|169\\\\.254\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|127\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.1[6-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.2[0-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.3[0-1]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|0:0:0:0:0:0:0:1|::1, protocolHeaderHttpsValue\\u003dhttps, hostHeader\\u003dX-Forwarded-Host, portHeader\\u003dX-Forwarded-Port}, hostHeader\\u003dX-Forwarded-Host, portHeader\\u003dX-Forwarded-Port, maxThreads\\u003d200, internalProxies\\u003d10\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|192\\\\.168\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|169\\\\.254\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|127\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.1[6-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.2[0-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.3[0-1]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|0:0:0:0:0:0:0:1|::1, protocolHeaderHttpsValue\\u003dhttps, minSpareThreads\\u003d10}, jetty\\u003d{accesslog\\u003d{enabled\\u003dfalse, format\\u003dNCSA, retentionPeriod\\u003d31, append\\u003dfalse}, threads\\u003d{acceptors\\u003d-1, selectors\\u003d-1, max\\u003d200, min\\u003d8, idleTimeout\\u003dPT1M}, maxHttpFormPostSize\\u003d{}, acceptors\\u003d-1, minThreads\\u003d8, maxThreads\\u003d200, selectors\\u003d-1, threadIdleTimeout\\u003dPT1M}, netty\\u003d{}, undertow\\u003d{maxHttpPostSize\\u003d{}, eagerFilterInit\\u003dtrue, maxHeaders\\u003d200, maxCookies\\u003d200, allowEncodedSlash\\u003dfalse, decodeUrl\\u003dtrue, urlCharset\\u003dUTF-8, alwaysSetKeepAlive\\u003dtrue, accesslog\\u003d{enabled\\u003dfalse, pattern\\u003dcommon, prefix\\u003daccess_log., suffix\\u003dlog, dir\\u003dC:\\\\workspace\\\\embed-lena-test\\\\logs, rotate\\u003dtrue}, threads\\u003d{}, options\\u003d{socket\\u003d{}, server\\u003d{}}}}\",\"server.lena.maxHttpFormPostSize\":\"{}\",\"server.lena.maxConnections\":\"8192\",\"server.lena.relaxedPathChars\":\"[]\",\"server.lena.internalProxies\":\"10\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|192\\\\.168\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|169\\\\.254\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|127\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.1[6-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.2[0-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.3[0-1]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|0:0:0:0:0:0:0:1|::1\",\"server.lena.protocolHeaderHttpsValue\":\"https\",\"server.lena.useRelativeRedirects\":\"false\",\"server.lena.uriEncoding\":\"UTF-8\",\"server.lena.minSpareThreads\":\"10\"},\"spring.jackson-org.springframework.boot.autoconfigure.jackson.JacksonProperties\":{\"spring.jackson.visibility\":\"{}\",\"spring.jackson.mapper\":\"{}\",\"spring.jackson.serialization\":\"{}\",\"spring.jackson.parser\":\"{}\",\"spring.jackson.deserialization\":\"{}\",\"spring.jackson.generator\":\"{}\"},\"spring.gson-org.springframework.boot.autoconfigure.gson.GsonProperties\":{},\"encrypt-org.springframework.cloud.bootstrap.encrypt.KeyProperties\":{\"encrypt.keyStore\":\"{type\\u003djks}\",\"encrypt.salt\":\"deadbeef\",\"encrypt.failOnError\":\"true\"},\"server.lena.connector-lena.embed.boot.config.properties.LenaConnectorProperties\":{\"server.lena.connector.parseBodyMethods\":\"POST\",\"server.lena.connector.useBodyEncodingForUri\":\"false\",\"server.lena.connector.secure\":\"false\",\"server.lena.connector.enableLookups\":\"false\",\"server.lena.connector.asyncTimeout\":\"30000\",\"server.lena.connector.redirectPort\":\"443\",\"server.lena.connector.proxyPort\":\"0\",\"server.lena.connector.xpoweredBy\":\"false\",\"server.lena.connector.scheme\":\"http\",\"server.lena.connector.maxCookieCount\":\"200\",\"server.lena.connector.useIpVhosts\":\"false\",\"server.lena.connector.allowTrace\":\"false\",\"server.lena.connector.maxParameterCount\":\"10000\",\"server.lena.connector.maxPostSize\":\"2097152\",\"server.lena.connector.uriEncoding\":\"UTF-8\",\"server.lena.connector.discardFacades\":\"false\",\"server.lena.connector.maxSavePostSize\":\"4096\"},\"server.lena.config-lena.embed.boot.config.properties.LenaCloudConfigProperties\":{\"server.lena.config.requestReadTimeout\":\"185000\",\"server.lena.config.uri\":\"[http://localhost:7700/lena-embed-manager/config]\",\"server.lena.config.name\":\"application\",\"server.lena.config.mediaType\":\"application/vnd.spring-cloud.config-server.v2+json\",\"server.lena.config.discovery\":\"{enabled\\u003dfalse, serviceId\\u003dconfigserver}\",\"server.lena.config.enabled\":\"false\",\"server.lena.config.clientProperties\":\"{enabled\\u003dfalse, profile\\u003ddefault, name\\u003dapplication, username\\u003dlena-admin, password\\u003d******, uri\\u003d[http://localhost:7700/lena-embed-manager/config], mediaType\\u003dapplication/vnd.spring-cloud.config-server.v2+json, discovery\\u003d{enabled\\u003dfalse, serviceId\\u003dconfigserver}, tls\\u003d{enabled\\u003dfalse, keyStorePassword\\u003d******, keyPassword\\u003d******, trustStorePassword\\u003d******}, failFast\\u003dfalse, requestReadTimeout\\u003d185000, requestConnectTimeout\\u003d10000, sendState\\u003dtrue, headers\\u003d{}}\",\"server.lena.config.sendState\":\"true\",\"server.lena.config.username\":\"lena-admin\",\"server.lena.config.profile\":\"default\",\"server.lena.config.requestConnectTimeout\":\"10000\",\"server.lena.config.tls\":\"{enabled\\u003dfalse, keyStorePassword\\u003d******, keyPassword\\u003d******, trustStorePassword\\u003d******}\",\"server.lena.config.password\":\"******\",\"server.lena.config.failFast\":\"false\"},\"spring.info-org.springframework.boot.autoconfigure.info.ProjectInfoProperties\":{\"spring.info.git\":\"{location\\u003d{}, encoding\\u003dUTF-8}\",\"spring.info.build\":\"{location\\u003d{}, encoding\\u003dUTF-8}\"},\"spring.task.scheduling-org.springframework.boot.autoconfigure.task.TaskSchedulingProperties\":{\"spring.task.scheduling.threadNamePrefix\":\"scheduling-\",\"spring.task.scheduling.pool\":\"{size\\u003d1}\",\"spring.task.scheduling.shutdown\":\"{awaitTermination\\u003dfalse}\"},\"spring.lifecycle-org.springframework.boot.autoconfigure.context.LifecycleProperties\":{\"spring.lifecycle.timeoutPerShutdownPhase\":\"PT30S\"},\"spring.resources-org.springframework.boot.autoconfigure.web.ResourceProperties\":{\"spring.resources.cache\":\"{cachecontrol\\u003d{}}\",\"spring.resources.addMappings\":\"true\",\"spring.resources.chain\":\"{cache\\u003dtrue, htmlApplicationCache\\u003dfalse, compressed\\u003dfalse, strategy\\u003d{fixed\\u003d{enabled\\u003dfalse, paths\\u003d[/**]}, content\\u003d{enabled\\u003dfalse, paths\\u003d[/**]}}}\",\"spring.resources.staticLocations\":\"[classpath:/META-INF/resources/, classpath:/resources/, classpath:/static/, classpath:/public/]\"},\"configClientHealthProperties\":{\"health.config.enabled\":\"false\",\"health.config.timeToLive\":\"300000\"},\"spring.cloud.service-registry.auto-registration-org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties\":{\"spring.cloud.service-registry.auto-registration.enabled\":\"true\",\"spring.cloud.service-registry.auto-registration.failFast\":\"false\",\"spring.cloud.service-registry.auto-registration.registerManagement\":\"true\"},\"simpleDiscoveryProperties\":{\"spring.cloud.discovery.client.simple.order\":\"0\",\"spring.cloud.discovery.client.simple.instances\":\"{}\"},\"spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties\":{\"spring.mvc.view\":\"{}\",\"spring.mvc.format\":\"{}\",\"spring.mvc.throwExceptionIfNoHandlerFound\":\"false\",\"spring.mvc.localeResolver\":\"ACCEPT_HEADER\",\"spring.mvc.staticPathPattern\":\"/**\",\"spring.mvc.contentnegotiation\":\"{favorPathExtension\\u003dfalse, favorParameter\\u003dfalse, mediaTypes\\u003d{}}\",\"spring.mvc.dispatchTraceRequest\":\"false\",\"spring.mvc.dispatchOptionsRequest\":\"true\",\"spring.mvc.logResolvedException\":\"false\",\"spring.mvc.pathmatch\":\"{useSuffixPattern\\u003dfalse, useRegisteredSuffixPattern\\u003dfalse}\",\"spring.mvc.async\":\"{}\",\"spring.mvc.ignoreDefaultModelOnRedirect\":\"true\",\"spring.mvc.servlet\":\"{path\\u003d/, loadOnStartup\\u003d-1}\",\"spring.mvc.publishRequestHandledEvents\":\"true\",\"spring.mvc.logRequestDetails\":\"false\"},\"spring.cloud.compatibility-verifier-org.springframework.cloud.configuration.CompatibilityVerifierProperties\":{\"spring.cloud.compatibility-verifier.enabled\":\"false\",\"spring.cloud.compatibility-verifier.compatibleBootVersions\":\"[2.2.x, 2.3.x]\"},\"spring.servlet.multipart-org.springframework.boot.autoconfigure.web.servlet.MultipartProperties\":{\"spring.servlet.multipart.fileSizeThreshold\":\"{}\",\"spring.servlet.multipart.enabled\":\"true\",\"spring.servlet.multipart.maxFileSize\":\"{}\",\"spring.servlet.multipart.resolveLazily\":\"false\",\"spring.servlet.multipart.maxRequestSize\":\"{}\"},\"server-org.springframework.boot.autoconfigure.web.ServerProperties\":{\"server.error\":\"{path\\u003d/error, includeException\\u003dfalse, includeStacktrace\\u003dNEVER, includeMessage\\u003dNEVER, includeBindingErrors\\u003dNEVER, whitelabel\\u003d{enabled\\u003dtrue}}\",\"server.tomcat\":\"{accesslog\\u003d{enabled\\u003dfalse, pattern\\u003dcommon, directory\\u003dlogs, prefix\\u003daccess_log, suffix\\u003d.log, checkExists\\u003dfalse, rotate\\u003dtrue, renameOnRotate\\u003dfalse, maxDays\\u003d-1, fileDateFormat\\u003d.yyyy-MM-dd, ipv6Canonical\\u003dfalse, requestAttributesEnabled\\u003dfalse, buffered\\u003dtrue}, threads\\u003d{max\\u003d200, minSpare\\u003d10}, backgroundProcessorDelay\\u003dPT10S, maxHttpFormPostSize\\u003d{}, maxSwallowSize\\u003d{}, redirectContextRoot\\u003dtrue, useRelativeRedirects\\u003dfalse, uriEncoding\\u003dUTF-8, maxConnections\\u003d8192, acceptCount\\u003d100, processorCache\\u003d200, additionalTldSkipPatterns\\u003d[], relaxedPathChars\\u003d[], relaxedQueryChars\\u003d[], resource\\u003d{allowCaching\\u003dtrue}, mbeanregistry\\u003d{enabled\\u003dfalse}, remoteip\\u003d{internalProxies\\u003d10\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|192\\\\.168\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|169\\\\.254\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|127\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.1[6-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.2[0-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.3[0-1]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|0:0:0:0:0:0:0:1|::1, protocolHeaderHttpsValue\\u003dhttps, hostHeader\\u003dX-Forwarded-Host, portHeader\\u003dX-Forwarded-Port}, hostHeader\\u003dX-Forwarded-Host, portHeader\\u003dX-Forwarded-Port, maxThreads\\u003d200, internalProxies\\u003d10\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|192\\\\.168\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|169\\\\.254\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|127\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.1[6-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.2[0-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.3[0-1]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|0:0:0:0:0:0:0:1|::1, protocolHeaderHttpsValue\\u003dhttps, minSpareThreads\\u003d10}\",\"server.netty\":\"{}\",\"server.undertow\":\"{maxHttpPostSize\\u003d{}, eagerFilterInit\\u003dtrue, maxHeaders\\u003d200, maxCookies\\u003d200, allowEncodedSlash\\u003dfalse, decodeUrl\\u003dtrue, urlCharset\\u003dUTF-8, alwaysSetKeepAlive\\u003dtrue, accesslog\\u003d{enabled\\u003dfalse, pattern\\u003dcommon, prefix\\u003daccess_log., suffix\\u003dlog, dir\\u003dC:\\\\workspace\\\\embed-lena-test\\\\logs, rotate\\u003dtrue}, threads\\u003d{}, options\\u003d{socket\\u003d{}, server\\u003d{}}}\",\"server.jetty\":\"{accesslog\\u003d{enabled\\u003dfalse, format\\u003dNCSA, retentionPeriod\\u003d31, append\\u003dfalse}, threads\\u003d{acceptors\\u003d-1, selectors\\u003d-1, max\\u003d200, min\\u003d8, idleTimeout\\u003dPT1M}, maxHttpFormPostSize\\u003d{}, acceptors\\u003d-1, minThreads\\u003d8, maxThreads\\u003d200, selectors\\u003d-1, threadIdleTimeout\\u003dPT1M}\",\"server.servlet\":\"{contextParameters\\u003d{}, applicationDisplayName\\u003dapplication, registerDefaultServlet\\u003dtrue}\",\"server.maxHttpHeaderSize\":\"{}\",\"server.shutdown\":\"IMMEDIATE\"},\"spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties\":{\"spring.task.execution.threadNamePrefix\":\"task-\",\"spring.task.execution.pool\":\"{queueCapacity\\u003d2147483647, coreSize\\u003d8, maxSize\\u003d2147483647, allowCoreThreadTimeout\\u003dtrue, keepAlive\\u003dPT1M}\",\"spring.task.execution.shutdown\":\"{awaitTermination\\u003dfalse}\"}}\n";
        String json2 = json.split(" = ")[1];
        System.out.println("json2:"+json2);
        String json3 = "{\"configClientProperties\":{\"spring.cloud.config.profile\":\"default\",\"spring.cloud.config.password\":\"******\",\"spring.cloud.config.requestReadTimeout\":\"185000\",\"spring.cloud.config.username\":\"lena-admin\",\"spring.cloud.config.uri\":\"[http://localhost:7700/lena-embed-manager/config]\",\"spring.cloud.config.discovery\":\"{enabled\\u003dfalse, serviceId\\u003dconfigserver}\",\"spring.cloud.config.sendState\":\"true\",\"spring.cloud.config.requestConnectTimeout\":\"10000\",\"spring.cloud.config.mediaType\":\"application/vnd.spring-cloud.config-server.v2+json\",\"spring.cloud.config.failFast\":\"false\",\"spring.cloud.config.name\":\"application\",\"spring.cloud.config.enabled\":\"false\",\"spring.cloud.config.headers\":\"{}\",\"spring.cloud.config.tls\":\"{enabled\\u003dfalse, keyStorePassword\\u003d******, keyPassword\\u003d******, trustStorePassword\\u003d******}\"},\"spring.cloud.config-org.springframework.cloud.bootstrap.config.PropertySourceBootstrapProperties\":{\"spring.cloud.config.allowOverride\":\"true\",\"spring.cloud.config.overrideSystemProperties\":\"true\",\"spring.cloud.config.overrideNone\":\"false\"},\"inetUtilsProperties\":{\"spring.cloud.inetutils.defaultIpAddress\":\"127.0.0.1\",\"spring.cloud.inetutils.ignoredInterfaces\":\"[]\",\"spring.cloud.inetutils.preferredNetworks\":\"[]\",\"spring.cloud.inetutils.timeoutSeconds\":\"1\",\"spring.cloud.inetutils.useOnlySiteLocalInterfaces\":\"false\",\"spring.cloud.inetutils.defaultHostname\":\"localhost\"},\"server.lena-lena.embed.boot.config.properties.LenaProperties\":{\"server.lena.backgroundProcessorDelay\":\"PT10S\",\"server.lena.stuckThread\":\"{threshold\\u003d600, interruptThreadThreshold\\u003d-1}\",\"server.lena.hostHeader\":\"X-Forwarded-Host\",\"server.lena.processorCache\":\"200\",\"server.lena.maxSwallowSize\":\"{}\",\"server.lena.acceptCount\":\"100\",\"server.lena.portHeader\":\"X-Forwarded-Port\",\"server.lena.relaxedQueryChars\":\"[]\",\"server.lena.redirectContextRoot\":\"true\",\"server.lena.maxThreads\":\"200\",\"server.lena.additionalTldSkipPatterns\":\"[]\",\"server.lena.serverProperties\":\"{error\\u003d{path\\u003d/error, includeException\\u003dfalse, includeStacktrace\\u003dNEVER, includeMessage\\u003dNEVER, includeBindingErrors\\u003dNEVER, whitelabel\\u003d{enabled\\u003dtrue}}, maxHttpHeaderSize\\u003d{}, shutdown\\u003dIMMEDIATE, servlet\\u003d{contextParameters\\u003d{}, applicationDisplayName\\u003dapplication, registerDefaultServlet\\u003dtrue}, tomcat\\u003d{accesslog\\u003d{enabled\\u003dfalse, pattern\\u003dcommon, directory\\u003dlogs, prefix\\u003daccess_log, suffix\\u003d.log, checkExists\\u003dfalse, rotate\\u003dtrue, renameOnRotate\\u003dfalse, maxDays\\u003d-1, fileDateFormat\\u003d.yyyy-MM-dd, ipv6Canonical\\u003dfalse, requestAttributesEnabled\\u003dfalse, buffered\\u003dtrue}, threads\\u003d{max\\u003d200, minSpare\\u003d10}, backgroundProcessorDelay\\u003dPT10S, maxHttpFormPostSize\\u003d{}, maxSwallowSize\\u003d{}, redirectContextRoot\\u003dtrue, useRelativeRedirects\\u003dfalse, uriEncoding\\u003dUTF-8, maxConnections\\u003d8192, acceptCount\\u003d100, processorCache\\u003d200, additionalTldSkipPatterns\\u003d[], relaxedPathChars\\u003d[], relaxedQueryChars\\u003d[], resource\\u003d{allowCaching\\u003dtrue}, mbeanregistry\\u003d{enabled\\u003dfalse}, remoteip\\u003d{internalProxies\\u003d10\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|192\\\\.168\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|169\\\\.254\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|127\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.1[6-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.2[0-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.3[0-1]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|0:0:0:0:0:0:0:1|::1, protocolHeaderHttpsValue\\u003dhttps, hostHeader\\u003dX-Forwarded-Host, portHeader\\u003dX-Forwarded-Port}, hostHeader\\u003dX-Forwarded-Host, portHeader\\u003dX-Forwarded-Port, maxThreads\\u003d200, internalProxies\\u003d10\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|192\\\\.168\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|169\\\\.254\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|127\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.1[6-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.2[0-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.3[0-1]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|0:0:0:0:0:0:0:1|::1, protocolHeaderHttpsValue\\u003dhttps, minSpareThreads\\u003d10}, jetty\\u003d{accesslog\\u003d{enabled\\u003dfalse, format\\u003dNCSA, retentionPeriod\\u003d31, append\\u003dfalse}, threads\\u003d{acceptors\\u003d-1, selectors\\u003d-1, max\\u003d200, min\\u003d8, idleTimeout\\u003dPT1M}, maxHttpFormPostSize\\u003d{}, acceptors\\u003d-1, minThreads\\u003d8, maxThreads\\u003d200, selectors\\u003d-1, threadIdleTimeout\\u003dPT1M}, netty\\u003d{}, undertow\\u003d{maxHttpPostSize\\u003d{}, eagerFilterInit\\u003dtrue, maxHeaders\\u003d200, maxCookies\\u003d200, allowEncodedSlash\\u003dfalse, decodeUrl\\u003dtrue, urlCharset\\u003dUTF-8, alwaysSetKeepAlive\\u003dtrue, accesslog\\u003d{enabled\\u003dfalse, pattern\\u003dcommon, prefix\\u003daccess_log., suffix\\u003dlog, dir\\u003dC:\\\\workspace\\\\embed-lena-test\\\\logs, rotate\\u003dtrue}, threads\\u003d{}, options\\u003d{socket\\u003d{}, server\\u003d{}}}}\",\"server.lena.maxHttpFormPostSize\":\"{}\",\"server.lena.maxConnections\":\"8192\",\"server.lena.relaxedPathChars\":\"[]\",\"server.lena.internalProxies\":\"10\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|192\\\\.168\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|169\\\\.254\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|127\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.1[6-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.2[0-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.3[0-1]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|0:0:0:0:0:0:0:1|::1\",\"server.lena.protocolHeaderHttpsValue\":\"https\",\"server.lena.useRelativeRedirects\":\"false\",\"server.lena.uriEncoding\":\"UTF-8\",\"server.lena.minSpareThreads\":\"10\"},\"spring.jackson-org.springframework.boot.autoconfigure.jackson.JacksonProperties\":{\"spring.jackson.visibility\":\"{}\",\"spring.jackson.mapper\":\"{}\",\"spring.jackson.serialization\":\"{}\",\"spring.jackson.parser\":\"{}\",\"spring.jackson.deserialization\":\"{}\",\"spring.jackson.generator\":\"{}\"},\"spring.gson-org.springframework.boot.autoconfigure.gson.GsonProperties\":{},\"encrypt-org.springframework.cloud.bootstrap.encrypt.KeyProperties\":{\"encrypt.keyStore\":\"{type\\u003djks}\",\"encrypt.salt\":\"deadbeef\",\"encrypt.failOnError\":\"true\"},\"server.lena.connector-lena.embed.boot.config.properties.LenaConnectorProperties\":{\"server.lena.connector.parseBodyMethods\":\"POST\",\"server.lena.connector.useBodyEncodingForUri\":\"false\",\"server.lena.connector.secure\":\"false\",\"server.lena.connector.enableLookups\":\"false\",\"server.lena.connector.asyncTimeout\":\"30000\",\"server.lena.connector.redirectPort\":\"443\",\"server.lena.connector.proxyPort\":\"0\",\"server.lena.connector.xpoweredBy\":\"false\",\"server.lena.connector.scheme\":\"http\",\"server.lena.connector.maxCookieCount\":\"200\",\"server.lena.connector.useIpVhosts\":\"false\",\"server.lena.connector.allowTrace\":\"false\",\"server.lena.connector.maxParameterCount\":\"10000\",\"server.lena.connector.maxPostSize\":\"2097152\",\"server.lena.connector.uriEncoding\":\"UTF-8\",\"server.lena.connector.discardFacades\":\"false\",\"server.lena.connector.maxSavePostSize\":\"4096\"},\"server.lena.config-lena.embed.boot.config.properties.LenaCloudConfigProperties\":{\"server.lena.config.requestReadTimeout\":\"185000\",\"server.lena.config.uri\":\"[http://localhost:7700/lena-embed-manager/config]\",\"server.lena.config.name\":\"application\",\"server.lena.config.mediaType\":\"application/vnd.spring-cloud.config-server.v2+json\",\"server.lena.config.discovery\":\"{enabled\\u003dfalse, serviceId\\u003dconfigserver}\",\"server.lena.config.enabled\":\"false\",\"server.lena.config.clientProperties\":\"{enabled\\u003dfalse, profile\\u003ddefault, name\\u003dapplication, username\\u003dlena-admin, password\\u003d******, uri\\u003d[http://localhost:7700/lena-embed-manager/config], mediaType\\u003dapplication/vnd.spring-cloud.config-server.v2+json, discovery\\u003d{enabled\\u003dfalse, serviceId\\u003dconfigserver}, tls\\u003d{enabled\\u003dfalse, keyStorePassword\\u003d******, keyPassword\\u003d******, trustStorePassword\\u003d******}, failFast\\u003dfalse, requestReadTimeout\\u003d185000, requestConnectTimeout\\u003d10000, sendState\\u003dtrue, headers\\u003d{}}\",\"server.lena.config.sendState\":\"true\",\"server.lena.config.username\":\"lena-admin\",\"server.lena.config.profile\":\"default\",\"server.lena.config.requestConnectTimeout\":\"10000\",\"server.lena.config.tls\":\"{enabled\\u003dfalse, keyStorePassword\\u003d******, keyPassword\\u003d******, trustStorePassword\\u003d******}\",\"server.lena.config.password\":\"******\",\"server.lena.config.failFast\":\"false\"},\"spring.info-org.springframework.boot.autoconfigure.info.ProjectInfoProperties\":{\"spring.info.git\":\"{location\\u003d{}, encoding\\u003dUTF-8}\",\"spring.info.build\":\"{location\\u003d{}, encoding\\u003dUTF-8}\"},\"spring.task.scheduling-org.springframework.boot.autoconfigure.task.TaskSchedulingProperties\":{\"spring.task.scheduling.threadNamePrefix\":\"scheduling-\",\"spring.task.scheduling.pool\":\"{size\\u003d1}\",\"spring.task.scheduling.shutdown\":\"{awaitTermination\\u003dfalse}\"},\"spring.lifecycle-org.springframework.boot.autoconfigure.context.LifecycleProperties\":{\"spring.lifecycle.timeoutPerShutdownPhase\":\"PT30S\"},\"spring.resources-org.springframework.boot.autoconfigure.web.ResourceProperties\":{\"spring.resources.cache\":\"{cachecontrol\\u003d{}}\",\"spring.resources.addMappings\":\"true\",\"spring.resources.chain\":\"{cache\\u003dtrue, htmlApplicationCache\\u003dfalse, compressed\\u003dfalse, strategy\\u003d{fixed\\u003d{enabled\\u003dfalse, paths\\u003d[/**]}, content\\u003d{enabled\\u003dfalse, paths\\u003d[/**]}}}\",\"spring.resources.staticLocations\":\"[classpath:/META-INF/resources/, classpath:/resources/, classpath:/static/, classpath:/public/]\"},\"configClientHealthProperties\":{\"health.config.enabled\":\"false\",\"health.config.timeToLive\":\"300000\"},\"spring.cloud.service-registry.auto-registration-org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties\":{\"spring.cloud.service-registry.auto-registration.enabled\":\"true\",\"spring.cloud.service-registry.auto-registration.failFast\":\"false\",\"spring.cloud.service-registry.auto-registration.registerManagement\":\"true\"},\"simpleDiscoveryProperties\":{\"spring.cloud.discovery.client.simple.order\":\"0\",\"spring.cloud.discovery.client.simple.instances\":\"{}\"},\"spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties\":{\"spring.mvc.view\":\"{}\",\"spring.mvc.format\":\"{}\",\"spring.mvc.throwExceptionIfNoHandlerFound\":\"false\",\"spring.mvc.localeResolver\":\"ACCEPT_HEADER\",\"spring.mvc.staticPathPattern\":\"/**\",\"spring.mvc.contentnegotiation\":\"{favorPathExtension\\u003dfalse, favorParameter\\u003dfalse, mediaTypes\\u003d{}}\",\"spring.mvc.dispatchTraceRequest\":\"false\",\"spring.mvc.dispatchOptionsRequest\":\"true\",\"spring.mvc.logResolvedException\":\"false\",\"spring.mvc.pathmatch\":\"{useSuffixPattern\\u003dfalse, useRegisteredSuffixPattern\\u003dfalse}\",\"spring.mvc.async\":\"{}\",\"spring.mvc.ignoreDefaultModelOnRedirect\":\"true\",\"spring.mvc.servlet\":\"{path\\u003d/, loadOnStartup\\u003d-1}\",\"spring.mvc.publishRequestHandledEvents\":\"true\",\"spring.mvc.logRequestDetails\":\"false\"},\"spring.cloud.compatibility-verifier-org.springframework.cloud.configuration.CompatibilityVerifierProperties\":{\"spring.cloud.compatibility-verifier.enabled\":\"false\",\"spring.cloud.compatibility-verifier.compatibleBootVersions\":\"[2.2.x, 2.3.x]\"},\"spring.servlet.multipart-org.springframework.boot.autoconfigure.web.servlet.MultipartProperties\":{\"spring.servlet.multipart.fileSizeThreshold\":\"{}\",\"spring.servlet.multipart.enabled\":\"true\",\"spring.servlet.multipart.maxFileSize\":\"{}\",\"spring.servlet.multipart.resolveLazily\":\"false\",\"spring.servlet.multipart.maxRequestSize\":\"{}\"},\"server-org.springframework.boot.autoconfigure.web.ServerProperties\":{\"server.error\":\"{path\\u003d/error, includeException\\u003dfalse, includeStacktrace\\u003dNEVER, includeMessage\\u003dNEVER, includeBindingErrors\\u003dNEVER, whitelabel\\u003d{enabled\\u003dtrue}}\",\"server.tomcat\":\"{accesslog\\u003d{enabled\\u003dfalse, pattern\\u003dcommon, directory\\u003dlogs, prefix\\u003daccess_log, suffix\\u003d.log, checkExists\\u003dfalse, rotate\\u003dtrue, renameOnRotate\\u003dfalse, maxDays\\u003d-1, fileDateFormat\\u003d.yyyy-MM-dd, ipv6Canonical\\u003dfalse, requestAttributesEnabled\\u003dfalse, buffered\\u003dtrue}, threads\\u003d{max\\u003d200, minSpare\\u003d10}, backgroundProcessorDelay\\u003dPT10S, maxHttpFormPostSize\\u003d{}, maxSwallowSize\\u003d{}, redirectContextRoot\\u003dtrue, useRelativeRedirects\\u003dfalse, uriEncoding\\u003dUTF-8, maxConnections\\u003d8192, acceptCount\\u003d100, processorCache\\u003d200, additionalTldSkipPatterns\\u003d[], relaxedPathChars\\u003d[], relaxedQueryChars\\u003d[], resource\\u003d{allowCaching\\u003dtrue}, mbeanregistry\\u003d{enabled\\u003dfalse}, remoteip\\u003d{internalProxies\\u003d10\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|192\\\\.168\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|169\\\\.254\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|127\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.1[6-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.2[0-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.3[0-1]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|0:0:0:0:0:0:0:1|::1, protocolHeaderHttpsValue\\u003dhttps, hostHeader\\u003dX-Forwarded-Host, portHeader\\u003dX-Forwarded-Port}, hostHeader\\u003dX-Forwarded-Host, portHeader\\u003dX-Forwarded-Port, maxThreads\\u003d200, internalProxies\\u003d10\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|192\\\\.168\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|169\\\\.254\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|127\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.1[6-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.2[0-9]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|172\\\\.3[0-1]{1}\\\\.\\\\d{1,3}\\\\.\\\\d{1,3}|0:0:0:0:0:0:0:1|::1, protocolHeaderHttpsValue\\u003dhttps, minSpareThreads\\u003d10}\",\"server.netty\":\"{}\",\"server.undertow\":\"{maxHttpPostSize\\u003d{}, eagerFilterInit\\u003dtrue, maxHeaders\\u003d200, maxCookies\\u003d200, allowEncodedSlash\\u003dfalse, decodeUrl\\u003dtrue, urlCharset\\u003dUTF-8, alwaysSetKeepAlive\\u003dtrue, accesslog\\u003d{enabled\\u003dfalse, pattern\\u003dcommon, prefix\\u003daccess_log., suffix\\u003dlog, dir\\u003dC:\\\\workspace\\\\embed-lena-test\\\\logs, rotate\\u003dtrue}, threads\\u003d{}, options\\u003d{socket\\u003d{}, server\\u003d{}}}\",\"server.jetty\":\"{accesslog\\u003d{enabled\\u003dfalse, format\\u003dNCSA, retentionPeriod\\u003d31, append\\u003dfalse}, threads\\u003d{acceptors\\u003d-1, selectors\\u003d-1, max\\u003d200, min\\u003d8, idleTimeout\\u003dPT1M}, maxHttpFormPostSize\\u003d{}, acceptors\\u003d-1, minThreads\\u003d8, maxThreads\\u003d200, selectors\\u003d-1, threadIdleTimeout\\u003dPT1M}\",\"server.servlet\":\"{contextParameters\\u003d{}, applicationDisplayName\\u003dapplication, registerDefaultServlet\\u003dtrue}\",\"server.maxHttpHeaderSize\":\"{}\",\"server.shutdown\":\"IMMEDIATE\"},\"spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties\":{\"spring.task.execution.threadNamePrefix\":\"task-\",\"spring.task.execution.pool\":\"{queueCapacity\\u003d2147483647, coreSize\\u003d8, maxSize\\u003d2147483647, allowCoreThreadTimeout\\u003dtrue, keepAlive\\u003dPT1M}\",\"spring.task.execution.shutdown\":\"{awaitTermination\\u003dfalse}\"}}";
        System.out.println("json3:"+json3);

        if(json2.equals(json3)){
            System.out.println("same");
        }else{
            System.out.println("not smae");
        }

        Map<String, Map<String,String>> configurationMap = new HashMap<String,Map<String,String>>();
        configurationMap = (Map<String,Map<String,String>>) gson.fromJson(json3.toString(), configurationMap.getClass());

        Iterator iter = configurationMap.keySet().iterator();
        while(iter.hasNext()){
            String key = (String) iter.next();
            System.out.println("key1:"+key);
            Map<String,String> value = (Map<String, String>) configurationMap.get(key);
            Iterator iter2 = value.keySet().iterator();
            while(iter2.hasNext()){
                String key2 = (String) iter2.next();
                System.out.println("key2:"+key2);
                System.out.println("value2:"+value.get(key2));
            }
        }

    }


//    public void start(){
//        B b = new B();
//        b.map.put("name","classB");
//        b.map.put("package","default");
//
//        A a = new A();
//        a.map.put("className",b);
//
//        Map<String,A> data = new HashMap<>();
//        data.put("data",a);
//        Gson gson = new Gson();
//
//        Map<String,Object> map = new HashMap<>();
//        map = gson.fromJson(gson.toJson(data),map.getClass());
////        System.out.println("data.toString():"+data.toString());
//        System.out.println(map.toString());
////        System.out.println(map.get("data").toString());
////        System.out.println(map.get("data"));
//
//        Iterator iter = map.keySet().iterator();
////        Iterator iter2 = null;
//        while(iter.hasNext()){
//            String key = (String) iter.next();
//            System.out.println("key:"+key);
//            System.out.println("value:"+map.get(key));
//            Map<String,B> map2 = (Map<String, B>) map.get(key);
////            Map<String,Object> map2 = (Map<String, Object>) map.get(key);
//            Iterator iter2 = map2.keySet().iterator();
//            while(iter2.hasNext()){
//                String key2 = (String)iter2.next();
//                System.out.println("key2:"+key2);
//                System.out.println("value:"+map2.get(key2));
//            }
//        }
////
//
//
//    }
}

class MapDTO{
    String key;
    Map<String,String> map;

    public MapDTO(){
        map = new HashMap<>();
    }

    public String toString(){
        return "key:"+key+",map:"+map.toString();
    }
}