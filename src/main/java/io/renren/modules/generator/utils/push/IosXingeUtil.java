package io.renren.modules.generator.utils.push;

import com.tencent.xinge.MessageIOS;
import com.tencent.xinge.XingeApp;
import io.renren.modules.generator.utils.StringTools;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class IosXingeUtil {
	private static MessageIOS messageIOS;
	private static XingeApp xinge = new XingeApp(2200270265l, "87b15f4ebf323f37fd5376980b664cc1");
	@Value("${xinge.enviroment}")
	private static String XINGE_ENVIROMENT;

	public static JSONObject iosPush(String username, String alert, String open_type, String url, String msg_params) {
		messageIOS = new MessageIOS();
		messageIOS.setType(MessageIOS.TYPE_APNS_NOTIFICATION);
		// 设置消息离线储存多久,此处不做设置使用默认三天
		// messageIOS.setExpireTime(86400);
		messageIOS.setAlert(alert);
		// messageIOS.setBadge(1);
		messageIOS.setCategory("INVITE_CATEGORY");
		messageIOS.setSound("beep.wav");
		if (!StringTools.isNullOrEmpty(open_type) && !StringTools.isNullOrEmpty(url)) {
			Map<String, Object> custom = new HashMap<String, Object>();
			custom.put("open_type", open_type);
			custom.put("url", url);
			custom.put("msg_params", msg_params);
			messageIOS.setCustom(custom);
		}
		return xinge.pushSingleAccount(0, username, messageIOS, XingeApp.IOSENV_PROD);
	}

	public static JSONObject iosBatchPush(List<String> users, String alert, String open_type, String url,
			String msg_params) {
		messageIOS = new MessageIOS();
		messageIOS.setType(MessageIOS.TYPE_APNS_NOTIFICATION);
		// 设置消息离线储存多久,此处不做设置使用默认三天
		// messageIOS.setExpireTime(86400);
		messageIOS.setAlert(alert);
		// messageIOS.setBadge(1);
		messageIOS.setCategory("INVITE_CATEGORY");
		messageIOS.setSound("beep.wav");
		if (!StringTools.isNullOrEmpty(open_type) && !StringTools.isNullOrEmpty(url)) {
			Map<String, Object> custom = new HashMap<String, Object>();
			custom.put("open_type", open_type);
			custom.put("url", url);
			custom.put("msg_params", msg_params);
			messageIOS.setCustom(custom);
		}
		return xinge.pushAccountList(0, users, messageIOS, XingeApp.IOSENV_PROD);
	}
	public static JSONObject iosPushAll(String alert, String open_type, String url,
			String msg_params) {
		messageIOS = new MessageIOS();
		messageIOS.setType(MessageIOS.TYPE_APNS_NOTIFICATION);
		// 设置消息离线储存多久,此处不做设置使用默认三天
		// messageIOS.setExpireTime(86400);
		messageIOS.setAlert(alert);
		// messageIOS.setBadge(1);
		messageIOS.setCategory("INVITE_CATEGORY");
		messageIOS.setSound("beep.wav");
		if (!StringTools.isNullOrEmpty(open_type) && !StringTools.isNullOrEmpty(url)) {
			Map<String, Object> custom = new HashMap<String, Object>();
			custom.put("open_type", open_type);
			custom.put("url", url);
			custom.put("msg_params", msg_params);
			messageIOS.setCustom(custom);
		}
		return xinge.pushAllDevice(0, messageIOS, XingeApp.IOSENV_PROD);
	}
}
